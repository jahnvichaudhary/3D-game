/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jme3.renderer.framegraph;

import java.util.ArrayList;

/**
 *A FGBindingPass represents a Pass that needs to perform state machine binding, ShaderResource binding, FrameBuffer binding and other operations.
 * @author JohnKkk
 */
public class FGBindingPass extends FGPass{
    protected ArrayList<FGBindable> binds;
    protected FGBindingPass(String name){
        this(name, new ArrayList<FGBindable>());
    }
    protected FGBindingPass(String name, ArrayList<FGBindable> binds){
        super(name);
        this.binds = binds;
    }
    
    public void addBind(FGBindable bind){
        binds.add(bind);
    }
    
    public <T extends FGBindable>void addBindSink(String name){
        int index = binds.size() - 1;
        registerSink(new FGContainerBindableSink<T>(name, binds, index));
    }
    
    public void bindAll(FGRenderContext renderContext){
        // Bind all objects
        for(FGBindable bind : binds){
            bind.bind(renderContext);
        }
    }

    @Override
    public void execute(FGRenderContext renderContext) {
    }
}
