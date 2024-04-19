/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jme3.renderer.pass;

import com.jme3.renderer.RenderManager;
import com.jme3.renderer.framegraph.DepthRange;
import com.jme3.renderer.framegraph.MyFrameGraph;
import com.jme3.renderer.framegraph.RenderContext;
import com.jme3.renderer.framegraph.RenderQueueModule;
import com.jme3.renderer.queue.RenderQueue;
import com.jme3.scene.Geometry;

/**
 *
 * @author codex
 */
public class ForwardModule extends RenderQueueModule {

    private final RenderQueue.Bucket bucket;
    protected DepthRange depth;

    public ForwardModule(RenderQueue.Bucket bucket) {
        this(bucket, null);
    }
    public ForwardModule(RenderQueue.Bucket bucket, DepthRange depth) {
        this.bucket = bucket;
        this.depth = depth;
    }
    
    @Override
    public void dispatchPassSetup(RenderQueue queue) {
        canExecute = !queue.isQueueEmpty(bucket);
    }
    @Override
    public void executeDrawCommands(RenderContext context) {
        if (!canExecute) {
            return;
        }
        if (depth != null) {
            context.setDepthRange(depth);
        }
        context.getRenderQueue().renderQueue(bucket, context.getRenderManager(), context.getViewPort().getCamera(), true);
    }
    @Override
    public void initialize(MyFrameGraph frameGraph) {}
    @Override
    public void prepare(RenderContext context) {}
    @Override
    public boolean drawGeometry(RenderManager rm, Geometry geom) {
        rm.renderGeometry(geom);
        return true;
    }
    
    public static ForwardModule sky() {
        return new ForwardModule(RenderQueue.Bucket.Sky, new DepthRange(1, 1));
    }
    public static ForwardModule transparent() {
        return new ForwardModule(RenderQueue.Bucket.Transparent, DepthRange.IDENTITY);
    }
    public static ForwardModule translucent() {
        return new ForwardModule(RenderQueue.Bucket.Translucent, DepthRange.IDENTITY);
    }
    
}
