/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jme3.renderer.framegraph;

import com.jme3.renderer.framegraph.parameters.RenderParameterGroup;
import com.jme3.renderer.framegraph.parameters.ParameterBinding;
import com.jme3.renderer.framegraph.parameters.ParameterManager;
import com.jme3.renderer.framegraph.parameters.RenderParameter;
import com.jme3.profile.AppProfiler;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import java.util.LinkedList;

/**
 *
 * @author codex
 */
public class MyFrameGraph {
    
    private final LinkedList<FGModule> passes = new LinkedList<>();
    private final ParameterManager parameters = new ParameterManager();
    private final RenderContext context;
    
    public MyFrameGraph(RenderManager renderManager) {
        context = new RenderContext(renderManager);
    }
    
    public void prepareRender(ViewPort vp, AppProfiler prof, float tpf) {
        context.update(vp, prof, tpf);
    }
    
    public void preFrame() {
        for (FGModule p : passes) {
            p.preFrame(context);
        }
    }
    
    public void postQueue() {
        for (FGModule p : passes) {
            p.postQueue(context);
        }
    }
    
    public void execute() {
        // prepare passes for execution
        for (FGModule p : passes) {
            p.prepare(context);
        }
        // execute
        for (FGModule p : passes) {
            // accept parameters as arguments to the pass
            parameters.pull(p);
            // execute pass
            p.execute(context);
            // apply resulting output parameters to connected input parameters
            parameters.push(p);
            // reset depth render range
            context.setDepthRange(DepthRange.IDENTITY);
            // reset geometry handler
            context.getRenderManager().setGeometryRenderHandler(null);
        }
        // reset passes
        for (FGModule p : passes) {
            p.reset();
        }
    }
    
    public void add(FGModule pass) {
        pass.initialize(this);
        passes.add(pass);
        registerParameterGroup(pass);
    }
    
    public <T extends FGModule> T get(Class<T> type) {
        for (FGModule p : passes) {
            if (type.isAssignableFrom(p.getClass())) {
                return (T)p;
            }
        }
        return null;
    }
    
    public ParameterManager getParameters() {
        return parameters;
    }
    
    public RenderContext getContext() {
        return context;
    }
    
    public <T extends RenderParameter> T registerParameter(T param) {
        parameters.register(param);
        return param;
    }
    
    public void registerParameterGroup(RenderParameterGroup group) {
        parameters.register(group);
    }
    
    public ParameterBinding bindToOutput(String target, RenderParameter input) {
        return parameters.bindToOutput(target, input);
    }
    
    public ParameterBinding bindToInput(String target, RenderParameter output) {
        return parameters.bindToInput(target, output);
    }
    
    public void removeParameter(RenderParameter param) {
        parameters.remove(param);
    }
    
    public void removeParameterGroup(RenderParameterGroup group) {
        parameters.remove(group);
    }
    
}
