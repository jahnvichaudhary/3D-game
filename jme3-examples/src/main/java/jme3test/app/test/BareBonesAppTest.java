///*
// * Copyright (c) 2009-2021 jMonkeyEngine
// * All rights reserved.
// *
// * Redistribution and use in source and binary forms, with or without
// * modification, are permitted provided that the following conditions are
// * met:
// *
// * * Redistributions of source code must retain the above copyright
// *   notice, this list of conditions and the following disclaimer.
// *
// * * Redistributions in binary form must reproduce the above copyright
// *   notice, this list of conditions and the following disclaimer in the
// *   documentation and/or other materials provided with the distribution.
// *
// * * Neither the name of 'jMonkeyEngine' nor the names of its contributors
// *   may be used to endorse or promote products derived from this software
// *   without specific prior written permission.
// *
// * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
// * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
// * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
// * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
// * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
// * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
// * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
// * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
// * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
// * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
// * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
// */
//
//package jme3test.app.test;
//
//import com.jme3.system.AppSettings;
//import com.jme3.testable.impl.JmeAppTest;
//import com.jme3.scene.Geometry;
//import com.jme3.scene.shape.Box;
//import com.jme3.system.Annotations;
//
//import jme3test.Launcher;
//
///**
// * Test a bare-bones application, without SimpleApplication.
// */
//@Annotations.TestableTags({Launcher.SIG_ALL})
//public class BareBonesAppTest extends JmeAppTest<AppSettings> {
//
//    private Geometry boxGeom;
//
//    public static void main(String[] args){
//        AppSettings settings = new AppSettings(true);
//        settings.setRenderer(AppSettings.LWJGL_OPENGL2);
//        settings.setAudioRenderer(AppSettings.LWJGL_OPENAL);
//        new BareBonesAppTest().launch(settings);
//    }
//
//
//    @Override
//    public void simpleUpdate(float tpf) {
//        super.simpleUpdate(tpf);
//        boxGeom.rotate(tpf * 2, tpf * 4, tpf * 3);
//    }
//
//    @Override
//    public void simpleInitApp() {
//
//        // create a box
//        boxGeom = new Geometry("Box", new Box(2, 2, 2));
//
//        // load some default material
//        boxGeom.setMaterial(assetManager.loadMaterial("Interface/Logo/Logo.j3m"));
//
//        // attach box to display in primary viewport
//        rootNode.attachChild(boxGeom);
//    }
//
//
//    @Override
//    public void launch(AppSettings userData) {
//        super.launch(userData);
//        setSettings(userData);
//        setShowSettings(false);
//        start();
//    }
//}
