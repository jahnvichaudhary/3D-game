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

import com.jme3.asset.AssetManager;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.framegraph.passes.DeferredPass;
import com.jme3.renderer.framegraph.passes.GBufferPass;
import com.jme3.renderer.framegraph.passes.OutputBucketPass;
import com.jme3.renderer.framegraph.passes.OutputPass;
import com.jme3.renderer.framegraph.passes.PostProcessingPass;
import com.jme3.renderer.framegraph.passes.RenderPass;
import com.jme3.renderer.framegraph.passes.TileDeferredPass;
import com.jme3.renderer.queue.RenderQueue;

/**
 * Utility class for constructing common framegraphs.
 * 
 * @author codex
 */
public class FrameGraphFactory {
    
    /**
     * Constructs a standard forward framegraph, with no controllable features.
     * 
     * @param assetManager
     * @param renderManager
     * @return forward framegraph
     */
    public static FrameGraph forward(AssetManager assetManager, RenderManager renderManager) {
        FrameGraph fg = new FrameGraph(assetManager, renderManager);
        fg.add(new OutputBucketPass(RenderQueue.Bucket.Opaque));
        fg.add(new OutputBucketPass(RenderQueue.Bucket.Sky, DepthRange.REAR));
        fg.add(new OutputBucketPass(RenderQueue.Bucket.Transparent));
        fg.add(new OutputBucketPass(RenderQueue.Bucket.Gui, DepthRange.FRONT));
        fg.add(new PostProcessingPass());
        fg.add(new OutputBucketPass(RenderQueue.Bucket.Translucent));
        return fg;
    }
    
    /**
     * Constructs a deferred or tiled deferred framegraph.
     * 
     * @param assetManager
     * @param renderManager
     * @param tiled true to construct advanced tiled deferred
     * @return deferred framegraph
     */
    public static FrameGraph deferred(AssetManager assetManager, RenderManager renderManager, boolean tiled) {
        FrameGraph fg = new FrameGraph(assetManager, renderManager);
        GBufferPass gbuf = fg.add(new GBufferPass());
        RenderPass deferred;
        if (!tiled) {
            deferred = fg.add(new DeferredPass());
        } else {
            deferred = fg.add(new TileDeferredPass());
        }
        OutputPass defOut = fg.add(new OutputPass());
        fg.add(new OutputBucketPass(RenderQueue.Bucket.Sky, DepthRange.REAR));
        fg.add(new OutputBucketPass(RenderQueue.Bucket.Transparent));
        fg.add(new OutputBucketPass(RenderQueue.Bucket.Gui, DepthRange.FRONT));
        fg.add(new PostProcessingPass());
        fg.add(new OutputBucketPass(RenderQueue.Bucket.Translucent));
        
        deferred.makeInput(gbuf, "Diffuse", "Diffuse");
        deferred.makeInput(gbuf, "Specular", "Specular");
        deferred.makeInput(gbuf, "Emissive", "Emissive");
        deferred.makeInput(gbuf, "Normal", "Normal");
        deferred.makeInput(gbuf, "Depth", "Depth");
        deferred.makeInput(gbuf, "Lights", "Lights");
        
        defOut.makeInput(deferred, "Color", "Color");
        defOut.makeInput(gbuf, "Depth", "Depth");
        
        return fg;
        
    }
    
}
