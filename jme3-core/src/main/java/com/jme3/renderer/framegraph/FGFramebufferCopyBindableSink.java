/*
 * Copyright (c) 2009-2023 jMonkeyEngine
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

import com.jme3.texture.FrameBuffer;

import java.util.ArrayList;

/**
 * @author JohnKkk
 * @param <T>
 */
public class FGFramebufferCopyBindableSink extends BindableSink {
    
    private FramebufferCopyBindableProxy proxy;
    
    public FGFramebufferCopyBindableSink(String registeredName, FrameBuffer distFrameBuffer, boolean copyColor, boolean copyDepth, boolean copyStencil) {
        super(registeredName);
        proxy = new FramebufferCopyBindableProxy(distFrameBuffer, copyColor, copyDepth, copyStencil);
    }

    private final static class FramebufferCopyBindableProxy implements FGBindable {
        FrameBuffer sourceFramebuffer;
        FrameBuffer distFramebuffer;
        boolean bCopyColor;
        boolean bCopyDepth;
        boolean bCopyStencil;

        public FramebufferCopyBindableProxy(FrameBuffer distFramebuffer, boolean bCopyColor, boolean bCopyDepth, boolean bCopyStencil) {
            this.distFramebuffer = distFramebuffer;
            this.bCopyColor = bCopyColor;
            this.bCopyDepth = bCopyDepth;
            this.bCopyStencil = bCopyStencil;
        }

        public void setSourceFramebuffer(FrameBuffer sourceFramebuffer) {
            this.sourceFramebuffer = sourceFramebuffer;
        }

        @Override
        public void bind(RenderContext renderContext) {
            if(this.distFramebuffer != null || this.sourceFramebuffer != null){
                renderContext.getRenderer().copyFrameBuffer(this.sourceFramebuffer,
                        (this.distFramebuffer != null ? this.distFramebuffer : renderContext.getViewPort().getOutputFrameBuffer()),
                        bCopyColor, bCopyDepth || bCopyStencil);
            }
        }
    }
    
    public final void setDistFrameBuffer(FrameBuffer distFrameBuffer){
        proxy.distFramebuffer = distFrameBuffer;
    }

    @Override
    public void bind(FGSource fgSource) {
        FGBindable p = fgSource.yieldBindable();
        if (p == null) {
            System.err.println("Binding input [" + getRegisteredName() + "] to output [" + getLinkPassName() + "." + getLinkPassResName() + "] " + " { " + fgSource.getName() + " } ");
            return;
        }
        if(fgSource instanceof FramebufferSource){
            linked = true;
            FramebufferSource framebufferSource = (FramebufferSource)fgSource;
            proxy.setSourceFramebuffer(((FramebufferSource.FrameBufferSourceProxy)framebufferSource.yieldBindable()).getFrameBuffer());
            target = proxy;
        }
        else{
            System.err.println(getRegisteredName() + " needs a FGFramebufferSource");
        }
    }

    @Override
    public void postLinkValidate() {

    }
}
