/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jme3.material.plugin.export.material;

import com.jme3.export.JmeExporter;
import com.jme3.export.OutputCapsule;
import com.jme3.export.Savable;
import com.jme3.material.Material;
import com.jme3.material.MaterialDef;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 * Saves a Material to a j3m file with proper formatting.
 *
 * usage is :
 * <pre>
 *     J3MExporter exporter = new J3MExporter();
 *     exporter.save(material, myFile);
 *     //or
 *     exporter.save(material, myOutputStream);
 * </pre>
 *
 * @author tsr
 * @author nehon (documentation and safety check)
 */
public class J3MExporter implements JmeExporter {

    private final J3MRootOutputCapsule rootCapsule;

    /**
     * Create a J3MExporter
     */
    public J3MExporter() {
        rootCapsule = new J3MRootOutputCapsule(this);
    }

    @Override
    public void save(Savable object, OutputStream f) throws IOException {

        if (!(object instanceof Material)) {
            throw new IllegalArgumentException("J3MExporter can only save com.jme3.material.Material class");
        }

        try (OutputStreamWriter out = new OutputStreamWriter(f, StandardCharsets.UTF_8);
                BufferedWriter writer = new BufferedWriter(out)) {

            rootCapsule.clear();
            object.write(this);
            rootCapsule.writeToStream(writer);

        }
    }

    @Override
    public void save(Savable object, File f) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(f)) {
            save(object, fos);
        }
    }

    @Override
    public OutputCapsule getCapsule(Savable object) {
        if ((object instanceof Material) || (object instanceof MaterialDef)) {
            return rootCapsule;
        }

        return rootCapsule.getCapsule(object);
    }

}
