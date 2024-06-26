/*
 * Copyright (c) 2024 jMonkeyEngine
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 * * Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in the
 *   documentation and/or other materials provided with the distribution.
 *
 * * Neither the name of 'jMonkeyEngine' nor the names of its contributors
 *   may be used to endorse or promote products derived from this software
 *   without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.jme3.renderer.framegraph;

import com.jme3.renderer.framegraph.passes.RenderPass;
import com.jme3.asset.AssetManager;
import com.jme3.asset.FrameGraphKey;
import com.jme3.opencl.CommandQueue;
import com.jme3.opencl.Context;
import com.jme3.profile.AppProfiler;
import com.jme3.profile.FgStep;
import com.jme3.profile.VpStep;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.RendererException;
import com.jme3.renderer.ViewPort;
import com.jme3.renderer.framegraph.client.GraphSetting;
import com.jme3.renderer.framegraph.debug.GraphEventCapture;
import com.jme3.renderer.framegraph.passes.Attribute;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Manages render passes, dependencies, and resources in a node-based parameter system.
 * <p>
 * Rendering is a complicated task, involving many parameters and resources. The framegraph
 * aims to simplify rendering from the user's perspective, and limit the creation, binding,
 * and destruction of resources wherever possible.
 * <p>
 * Passes are expected to declare and describe beforehand the resources they plan on using
 * during execution. Passes can also reference resources declared by other passes. The resource
 * manager can determine from these "promises" which passes can be culled, as their contributions
 * would ultimately go unused.
 * <p>
 * During execution, passes expected ask the resource manager for the resource the declared or referenced
 * earlier. If the resource does not already exist (is virtual) the manager will either create a new
 * resource or allocate an existing, unused resource that qualifies based on the description provided
 * on declaration. Reallocation is usually preferred to reduce memory footprint.
 * <p>
 * FrameGraph execution occurs in four steps:
 * <ol>
 *  <li><strong>Preparation.</strong> Passes declare, reserve, and reference resources
 * during this step.</li>
 *  <li><strong>Culling.</strong> The resource manager determines which resources and
 * passes are unused, and culls them. This can often save loads of resources, as many
 * passes may not used for large parts of the application.</li>
 *  <li><strong>Execution.</strong> Passes that were not culled acquire the resources
 * they need, and perform rendering operations. All passes are expected to release
 * all resources they declared or referenced in the first step, however, this is done
 * automatically by {@link RenderPass}.</li>
 *  <li><strong>Reset.</strong> Passes perform whatever post-rendering cleanup is necessary.</li>
 * </ol>
 * <p>
 * Each step begins only after every qualifying pass has completed the previous step.
 * <p>
 * Passes are executed in the order they appear in the queue. This can sometimes lead
 * to unintended consequences, as a pass may use resources generated by a later queue.
 * 
 * @author codex
 */
public class FrameGraph {
    
    /**
     * Index for the main render thread pass queue.
     */
    public static final int RENDER_THREAD = 0;
    
    private final AssetManager assetManager;
    private final ResourceList resources;
    private final FGRenderContext context;
    private final ArrayList<PassQueueExecutor> queues = new ArrayList<>(1);
    private final HashMap<String, Object> settings = new HashMap<>();
    private String name = "FrameGraph";
    private boolean rendered = false;
    private Exception renderException;
    
    /**
     * Creates a new blank framegraph.
     * 
     * @param assetManager asset manager (not null)
     */
    public FrameGraph(AssetManager assetManager) {
        this.assetManager = assetManager;
        this.resources = new ResourceList(this);
        this.context = new FGRenderContext(this);
        this.queues.add(new PassQueueExecutor(this, RENDER_THREAD));
    }
    /**
     * Creates a new framegraph from the given data.
     * 
     * @param assetManager
     * @param data 
     */
    public FrameGraph(AssetManager assetManager, FrameGraphData data) {
        this(assetManager);
        applyData(data);
    }
    /**
     * Creates a new framegraph from data obtained by the given asset key.
     * 
     * @param assetManager
     * @param key 
     */
    public FrameGraph(AssetManager assetManager, FrameGraphKey key) {
        this(assetManager, assetManager.loadFrameGraph(key));
    }
    /**
     * Creates a new framegraph from data obtained by the given asset name.
     * 
     * @param assetManager
     * @param dataAsset 
     */
    public FrameGraph(AssetManager assetManager, String dataAsset) {
        this(assetManager, assetManager.loadFrameGraph(dataAsset));
    }
    
    /**
     * Configures the framegraph rendering context.
     * 
     * @param rm
     * @param vp viewport to render (not null)
     * @param prof profiler (may be null)
     * @param tpf time per frame
     */
    public void configure(RenderManager rm, ViewPort vp, AppProfiler prof, float tpf) {
        resources.setRenderManager(rm);
        context.target(rm, vp, prof, tpf);
    }
    /**
     * Executes this framegraph.
     * <p>
     * The overall execution step occurs in 4 stages:
     * <ol>
     *   <li>Preparation.</li>
     *   <li>Culling.</li>
     *   <li>Rendering (execution).</li>
     *   <li>Clean (reset).</li>
     * </ol>
     * 
     * @return true if this is the first execution this frame
     */
    public boolean execute() {
        // prepare
        ViewPort vp = context.getViewPort();
        AppProfiler prof = context.getProfiler();
        GraphEventCapture cap = context.getGraphCapture();
        if (cap != null) {
            cap.renderViewPort(context.getViewPort());
        }
        if (prof != null) prof.vpStep(VpStep.FrameGraphSetup, vp, null);
        if (!rendered) {
            resources.beginRenderingSession();
        }
        for (PassQueueExecutor queue : queues) {
            for (RenderPass p : queue) {
                if (prof != null) prof.fgStep(FgStep.Prepare, p.getProfilerName());
                if (cap != null) cap.prepareRenderPass(p.getIndex(), p.getProfilerName());
                p.prepareRender(context);
            }
        }
        // cull passes and resources
        if (prof != null) prof.vpStep(VpStep.FrameGraphCull, vp, null);
        for (PassQueueExecutor queue : queues) {
            for (RenderPass p : queue) {
                p.countReferences();
            }
        }
        resources.cullUnreferenced();
        // execute
        if (prof != null) prof.vpStep(VpStep.FrameGraphExecute, vp, null);
        context.pushRenderSettings();
        renderException = null;
        for (PassQueueExecutor p : queues) {
            p.execute(context);
        }
        if (renderException != null) {
            renderException.printStackTrace(System.err);
            throw new RendererException("An uncaught rendering exception occured, forcing the application to shut down.");
        }
        context.popFrameBuffer();
        // reset
        if (prof != null) prof.vpStep(VpStep.FrameGraphReset, vp, null);
        for (PassQueueExecutor queue : queues) {
            for (RenderPass p : queue) {
                if (prof != null) prof.fgStep(FgStep.Reset, p.getProfilerName());
                p.resetRender(context);
            }
        }
        // cleanup resources
        resources.clear();
        if (rendered) return false;
        else return (rendered = true);
    }
    /**
     * Should be called only when all rendering for the frame is complete.
     */
    public void renderingComplete() {
        // notify passes
        for (PassQueueExecutor queue : queues) {
            for (RenderPass p : queue) {
                p.renderingComplete();
            }
        }
        // reset flags
        rendered = false;
    }
    
    private PassQueueExecutor getQueue(int i) {
        if (i >= queues.size()) {
            PassQueueExecutor queue = new PassQueueExecutor(this, i);
            queues.add(queue);
            return queue;
        } else {
            return queues.get(i);
        }
    }
    
    /**
     * Adds the pass to end of the pass queue.
     * 
     * @param <T>
     * @param pass
     * @return given pass
     */
    public <T extends RenderPass> T add(T pass) {
        return getQueue(RENDER_THREAD).add(pass);
    }
    /**
     * 
     * 
     * @param <T>
     * @param pass
     * @param threadIndex
     * @return 
     */
    public <T extends RenderPass> T add(T pass, int threadIndex) {
        return getQueue(threadIndex).add(pass);
    }
    /**
     * Adds the pass at the index in the pass queue.
     * <p>
     * If the index is &gt;= the current queue size, the pass will
     * be added to the end of the queue. Passes above the added pass
     * will have their indexes shifted.
     * 
     * @param <T>
     * @param pass
     * @param threadIndex
     * @param queueIndex
     * @return 
     */
    public <T extends RenderPass> T add(T pass, int threadIndex, int queueIndex) {
        return getQueue(threadIndex).add(pass, queueIndex);
    }
    /**
     * Creates and adds an Attribute pass and links it to the given ticket.
     * <p>
     * This is handy for quickly debugging various resources in the graph.
     * 
     * @param <T>
     * @param ticket ticket to reference from
     * @return created Attribute
     */
    public <T> Attribute<T> addAttribute(ResourceTicket<T> ticket) {
        return getQueue(RENDER_THREAD).addAttribute(ticket);
    }
    
    /**
     * Gets the first pass that is of or a subclass of the given class.
     * 
     * @param <T>
     * @param type
     * @return first qualifying pass, or null
     */
    public <T extends RenderPass> T get(Class<T> type) {
        for (PassQueueExecutor q : queues) {
            T p = q.get(type);
            if (p != null) {
                return p;
            }
        }
        return null;
    }
    /**
     * Gets the first pass of the given class that is named as given.
     * 
     * @param <T>
     * @param type
     * @param name
     * @return first qualifying pass, or null
     */
    public <T extends RenderPass> T get(Class<T> type, String name) {
        for (PassQueueExecutor q : queues) {
            T p = q.get(type, name);
            if (p != null) {
                return p;
            }
        }
        return null;
    }
    /**
     * Gets the pass that holds the given id number.
     * 
     * @param <T>
     * @param type
     * @param id
     * @return pass of the id, or null
     */
    public <T extends RenderPass> T get(Class<T> type, int id) {
        for (PassQueueExecutor q : queues) {
            T p = q.get(type, id);
            if (p != null) {
                return p;
            }
        }
        return null;
    }
    
    /**
     * Removes the pass at the index in the queue.
     * <p>
     * Passes above the removed pass will have their indexes shifted.
     * 
     * @param i
     * @return removed pass
     * @throws IndexOutOfBoundsException if the index is less than zero or &gt;= the queue size
     */
    public RenderPass remove(int i) {
        return queues.get(RENDER_THREAD).remove(i);
    }
    /**
     * Removes the given pass from the queue.
     * <p>
     * Passes above the removed pass will have their indexes shifted.
     * 
     * @param pass
     * @return true if the pass was removed from the queue
     */
    public boolean remove(RenderPass pass) {
        for (PassQueueExecutor queue : queues) {
            if (queue.remove(pass)) {
                return true;
            }
        }
        return false;
    }
    /**
     * Clears all passes from the pass queue.
     */
    public void clear() {
        for (PassQueueExecutor queue : queues) {
            queue.clear();
        }
    }
    
    /**
     * Sets the setting under the name.
     * 
     * @param <T>
     * @param name
     * @param object
     * @return given object
     */
    public <T> T setSetting(String name, T object) {
        settings.put(name, object);
        return object;
    }
    /**
     * Sets the setting under the name and creates a GraphSetting
     * of the same name.
     * 
     * @param <T>
     * @param name
     * @param object
     * @param create
     * @return created graph setting
     */
    public <T> GraphSetting<T> setSetting(String name, T object, boolean create) {
        setSetting(name, object);
        if (create) {
            return new GraphSetting<>(name);
        } else {
            return null;
        }
    }
    /**
     * Sets an integer setting based on a boolean value.
     * <p>
     * If the boolean is true, 0 is written, otherwise -1 is written. This is
     * used primarily for Junction sources: 0 points to the first input, and -1
     * points to no input.
     * 
     * @param name
     * @param value
     * @return 
     */
    public int setJunctionSetting(String name, boolean value) {
        return setSetting(name, value ? 0 : -1);
    }
    /**
     * Gets the setting under the name, or null.
     * 
     * @param <T>
     * @param name
     * @return 
     */
    public <T> T getSetting(String name) {
        Object obj = settings.get(name);
        if (obj != null) {
            return (T)obj;
        } else {
            return null;
        }
    }
    /**
     * Removes the setting under the name.
     * 
     * @param <T>
     * @param name
     * @return removed setting, or null
     */
    public <T> T removeSetting(String name) {
        Object obj = settings.remove(name);
        if (obj != null) {
            return (T)obj;
        } else {
            return null;
        }
    }
    /**
     * Gets the settings map.
     * <p>
     * The returned map may be modified.
     * 
     * @return 
     */
    public HashMap<String, Object> getSettingsMap() {
        return settings;
    }
    
    /**
     * Sets the name of this framegraph.
     * 
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Sets the OpenCL context for compute shading.
     * 
     * @param clContext 
     */
    public void setCLContext(Context clContext) {
        context.setCLContext(clContext);
    }
    /**
     * Assigns this framegraph to the OpenCL command queue.
     * <p>
     * Passes do not need to use the assigned command queue, but are encouraged to.
     * 
     * @param clQueue 
     */
    public void setCLQueue(CommandQueue clQueue) {
        context.setCLQueue(clQueue);
    }
    
    /**
     * Called internally when a rendering exception occurs.
     * 
     * @param ex
     */
    public void interruptRendering(Exception ex) {
        assert ex != null : "Interrupting exception cannot be null.";
        renderException = ex;
        for (PassQueueExecutor q : queues) {
            q.interrupt();
        }
    }
    
    /**
     * 
     * @return 
     */
    public AssetManager getAssetManager() {
        return assetManager;
    }
    /**
     * Gets the ResourceList that manages resources for this framegraph.
     * 
     * @return 
     */
    public ResourceList getResources() {
        return resources;
    }
    /**
     * Gets the framegraph rendering context.
     * 
     * @return 
     */
    public FGRenderContext getContext() {
        return context;
    }
    /**
     * 
     * @return 
     */
    public RenderManager getRenderManager() {
        return context.getRenderManager();
    }
    /**
     * Gets the OpenCL context for compute shading.
     * 
     * @return 
     */
    public Context getCLContext() {
        return context.getCLContext();
    }
    /**
     * Gets the name of this framegraph.
     * 
     * @return 
     */
    public String getName() {
        return name;
    }
    /**
     * Returns true if this framegraph is running asynchronous passes.
     * 
     * @return 
     */
    public boolean isAsync() {
        return queues.size() > 1;
    }
    
    /**
     * Applies the framegraph data to this framegraph.
     * 
     * @param data
     * @return this instance
     */
    public final FrameGraph applyData(FrameGraphData data) {
        data.apply(this);
        return this;
    }
    /**
     * Applies the framegraph data to this framegraph.
     * 
     * @param data
     * @return this instance
     * @throws ClassCastException if the object is not an instance of {@link FrameGraphData}.
     * @throws NullPointerException if the object is null
     */
    public FrameGraph applyData(Object data) {
        if (data != null) {
            if (data instanceof FrameGraphData) {
                return applyData((FrameGraphData)data);
            } else {
                throw new ClassCastException(data.getClass()+" cannot be cast to "+FrameGraphData.class);
            }
        } else {
            throw new NullPointerException("Proxy cannot be null");
        }
    }
    /**
     * Loads and applies framegraph data from the key.
     * 
     * @param key
     * @return 
     */
    public FrameGraph loadData(FrameGraphKey key) {
        return applyData(assetManager.loadFrameGraph(key));
    }
    /**
     * Loads and applies framegraph data at the specified asset path.
     * 
     * @param assetPath
     * @return 
     */
    public FrameGraph loadData(String assetPath) {
        return applyData(assetManager.loadFrameGraph(assetPath));
    }
    /**
     * Creates exportable framegraph data.
     * 
     * @return 
     */
    public FrameGraphData createData() {
        return new FrameGraphData(this, queues, settings);
    }
    
    @Override
    public String toString() {
        return "FrameGraph ("+name+")";
    }
    
}
