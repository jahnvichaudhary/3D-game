/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jme3.renderer.framegraph.passes;

import com.jme3.export.InputCapsule;
import com.jme3.export.JmeExporter;
import com.jme3.export.JmeImporter;
import com.jme3.export.OutputCapsule;
import com.jme3.renderer.Camera;
import com.jme3.renderer.ViewPort;
import com.jme3.renderer.framegraph.FGRenderContext;
import com.jme3.renderer.framegraph.FrameGraph;
import com.jme3.renderer.framegraph.ResourceTicket;
import com.jme3.renderer.queue.GeometryComparator;
import com.jme3.renderer.queue.GeometryList;
import com.jme3.renderer.queue.GuiComparator;
import com.jme3.renderer.queue.NullComparator;
import com.jme3.renderer.queue.OpaqueComparator;
import com.jme3.renderer.queue.RenderQueue;
import static com.jme3.renderer.queue.RenderQueue.Bucket.Opaque;
import com.jme3.renderer.queue.TransparentComparator;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author codex
 */
public class SceneEnqueuePass extends RenderPass {
    
    private final Bucket[] buckets = {
        new Bucket("Opaque", new OpaqueComparator()),
        new Bucket("Gui", new GuiComparator()),
        new Bucket("Transparent", new TransparentComparator()),
        new Bucket("Translucent", new TransparentComparator()),
        new Bucket("Sky", new NullComparator()),
    };
    
    private boolean runControlRender = true;

    public SceneEnqueuePass() {}
    public SceneEnqueuePass(boolean runControlRender) {
        this.runControlRender = runControlRender;
    }
    
    @Override
    protected void initialize(FrameGraph frameGraph) {
        for (Bucket b : buckets) {
            b.ticket = addOutput(b.name);
        }
    }
    @Override
    protected void prepare(FGRenderContext context) {
        for (Bucket b : buckets) {
            declare(null, b.ticket);
        }
    }
    @Override
    protected void execute(FGRenderContext context) {
        ViewPort vp = context.getViewPort();
        List<Spatial> scenes = vp.getScenes();
        for (int i = scenes.size(); i >= 0; i--) {
            vp.getCamera().setPlaneState(0);
            queueSubScene(context, scenes.get(i), null);
        }
        for (Bucket b : buckets) {
            resources.setPrimitive(b.ticket, b.queue);
        }
    }
    @Override
    protected void reset(FGRenderContext context) {}
    @Override
    protected void cleanup(FrameGraph frameGraph) {}
    @Override
    public void write(JmeExporter ex) throws IOException {
        super.write(ex);
        OutputCapsule out = ex.getCapsule(this);
        out.write(runControlRender, "runControlRender", true);
    }
    @Override
    public void read(JmeImporter im) throws IOException {
        super.read(im);
        InputCapsule in = im.getCapsule(this);
        runControlRender = in.readBoolean("runControlRender", true);
    }
    
    private void queueSubScene(FGRenderContext context, Spatial scene, RenderQueue.Bucket parentBucket) {
        // check culling
        Camera cam = context.getViewPort().getCamera();
        if (!scene.checkCulling(cam)) {
            return;
        }
        // render controls
        if (runControlRender) {
            scene.runControlRender(context.getRenderManager(), context.getViewPort());
        }
        // get target bucket
        RenderQueue.Bucket b = scene.getLocalQueueBucket();
        if (b == RenderQueue.Bucket.Inherit) {
            b = parentBucket;
            if (b == null) {
                b = scene.getQueueBucket();
            }
        }
        if (scene instanceof Node) {
            Node n = (Node)scene;
            int camState = cam.getPlaneState();
            for (Spatial s : n.getChildren()) {
                // restore cam state before queueing children
                cam.setPlaneState(camState);
                queueSubScene(context, s, b);
            }
        } else if (scene instanceof Geometry) {
            // add to the render queue
            Geometry g = (Geometry)scene;
            if (g.getMaterial() == null) {
                throw new IllegalStateException("No material is set for Geometry: " + g.getName());
            }
            getBucket(b).queue.add(g);
        }
    }
    private Bucket getBucket(RenderQueue.Bucket bucket) {
        switch (bucket) {
            case Opaque: return buckets[0];
            case Gui: return buckets[1];
            case Transparent: return buckets[2];
            case Translucent: return buckets[3];
            case Sky: return buckets[4];
            default: throw new IllegalArgumentException(bucket+" does not have a corresponding geometry list.");
        }
    }
    
    private static class Bucket {
        
        public final String name;
        public final GeometryList queue;
        public ResourceTicket<GeometryList> ticket;
        
        public Bucket(String name, GeometryComparator comparator) {
            this.name = name;
            this.queue = new GeometryList(comparator);
        }
        
    }
    
}
