/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jme3.scene;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Iterates over the scene graph with the depth-first traversal method.
 * 
 * <p>This iterable is meant to be used only once.
 * 
 * @author codex
 */
public class SceneGraphIterator implements Iterable<Spatial>, Iterator<Spatial> {
    
    private Spatial current;
    private Spatial main;
    private final LinkedList<PathNode> path = new LinkedList<>();

    public SceneGraphIterator(Spatial main) {
        if (main instanceof Node) {
            path.add(new PathNode((Node)main));
        }
        this.main = main;
    }

    @Override
    public Iterator<Spatial> iterator() {
        return this;
    }
    @Override
    public boolean hasNext() {
        if (main != null) return true;
        trim();
        return !path.isEmpty();
    }
    @Override
    public Spatial next() {
        if (main != null) {
            current = main;
            main = null;
        }
        else {
            current = path.getLast().iterator.next();
            if (current instanceof Node) {
                path.addLast(new PathNode((Node)current));
            }
        }
        return current;
    }
    
    /**
     * Get the current spatial.
     *
     * @return
     */
    public Spatial current() {
        return current;
    }
    
    /**
     * Makes this iterator ignore all children of the current spatial.
     * The children of the current spatial will not be iterated through.
     */
    public void ignoreChildren() {
        if (current instanceof Node) {
            path.removeLast();
        }
    }
    
    /**
     * Trims the path to the first available node.
     */
    private void trim() {
        if (!path.isEmpty() && !path.getLast().iterator.hasNext()) {
            path.removeLast();
            trim();
        }
    }
    
    private static class PathNode {

        Node node;
        Iterator<Spatial> iterator;

        PathNode(Node node) {
            this.node = node;
            iterator = this.node.getChildren().iterator();
        }
        
    }
    
}
