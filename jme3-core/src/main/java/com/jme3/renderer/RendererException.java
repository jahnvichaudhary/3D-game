/*
 * Copyright (c) 2009-2012 jMonkeyEngine
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
package com.jme3.renderer;

/**
 * <code>RendererException</code> is raised when a renderer encounters
 * a fatal rendering error.
 *
 * @author Kirill Vainer
 */
public class RendererException extends RuntimeException {

    /**
     * The attachment to this exception.
     */
    private Object attachment;

    /**
     * Creates a new instance of <code>RendererException</code>
     *
     * @param message the message
     */
    public RendererException(final String message){
        super(message);
    }

    /**
     * Instantiates a new Renderer exception.
     *
     * @param message    the message
     * @param attachment the attachment
     */
    public RendererException(final String message, final Object attachment) {
        super(message);
        this.attachment = attachment;
    }

    /**
     * Instantiates a new Renderer exception.
     *
     * @param message    the message
     * @param cause      the cause
     * @param attachment the attachment
     */
    public RendererException(final String message, final Throwable cause, final Object attachment) {
        super(message, cause);
        this.attachment = attachment;
    }

    /**
     * Gets attachment.
     *
     * @return attachment attachment
     */
    public Object getAttachment() {
        return attachment;
    }
}
