/*
 * Copyright (c) 2009-2021 jMonkeyEngine
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
package com.jme3.util;

import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicLong;

import com.jme3.util.functional.NoArgFunction;
import com.jme3.util.functional.VoidFunction;


/**
 * StatefulObject is an object that stores one or more states
 * 
 * @author Riccardo Balbo
 */
public class StatefulObject implements Cloneable{
    private static AtomicLong globalId = new AtomicLong(Long.MIN_VALUE);

    private static long getNewSnapshotID(){
        return  globalId.getAndUpdate(n->{
            long nn=n+1;
            if(nn==-1||n==0)nn=1;    
            return nn;
        });
    }

    /** 
     * A state that can be updated.
     */
    public static abstract class State<S extends StatefulObject> {
        private volatile long snapshotID = 0;

        /**
         * Get unique ID of the snapshot of the current state.
         * The ID changes after every update.
         * @return
         */
        public long getSnapshotID() {
            return snapshotID;
        }

        /**
         * Called when the state needs to be updated
         * @param hint Hint on what need to be updated (may be ignored)
         */
        public abstract void updateState(S forObject, Object hint);

        private void _updateState(StatefulObject forObject, Object hint) {
            this.updateState((S)forObject, hint);
        }

        /**
         * Called after the update is completed.
         * Updates the snapshot ID so that objects monitoring it can know that 
         * the state has new data.
         */
        public void commitUpdate() {
            snapshotID = getNewSnapshotID(); // update the snapshot id
        }

        public abstract State<S> cloneStateFor(S obj);

        private State<S> _cloneStateFor(StatefulObject obj) {
            return cloneStateFor((S) obj);
        }

        /**
         * Called after the state is attached for the first time
         */
        public abstract void attachedTo(S obj);

        private void _attachedTo(StatefulObject obj) {
            attachedTo((S) obj);
        }
    }
    
 
    
    private transient Map<Object, State<? extends StatefulObject>> states;
    
    /**
     * Get registered states
     * 
     * @return Map containing all the registered states and their keys
     */
    protected Map<Object, State<? extends StatefulObject>> getStates() {
        if (states == null) {
            states = (Map<Object, State<? extends StatefulObject>>) Collections.synchronizedMap(new WeakHashMap<Object, State<? extends StatefulObject>>());         
        }
        return states;
    }
    /**
     * Get or attach a state
     * @param <T>
     * @param key Something that is unique and represent the state (can be any object)
     * @param constructor constructor used to create a new state if it doesn't exist
     * @return
     */
    public <T extends State<? extends StatefulObject>> T  getState(Object key, NoArgFunction<T> constructor) {        
        State<? extends StatefulObject> state = getStates().get(key);
        if (state == null && constructor != null) {
            state = constructor.eval();
            getStates().put(key, state);
            state._attachedTo(this);
        }
        return (T)state;
    }

    /**
     * Detach a state
     * @param key Key representing the state
     * @return
     */
    public Object removeState(Object key) {
        return getStates().remove(key);
    }

    /**
     * Mark states for update
     * @param hint Suggest what to update (can be ignored)
     */
    protected void updateStates(Object hint){
        Map<Object,State<? extends StatefulObject>> m= getStates();
        for(State<? extends StatefulObject> s:m.values()){
            s._updateState(this,hint);
        }
    }

    /**
     * Execute a function for each state
     * @param f 
     */
    protected void forEachState(VoidFunction<State<? extends StatefulObject>> f){
        Map<Object, State<? extends StatefulObject>> m = getStates();
        for(State<? extends StatefulObject> s:m.values()){
            f.eval(s);
        }
    }


    @Override
    protected StatefulObject clone() throws CloneNotSupportedException {
        StatefulObject clone=(StatefulObject)super.clone();
        clone.states = null;
        Map<Object, State<? extends StatefulObject>> states = getStates();
        Map<Object, State<? extends StatefulObject>> clonedStates = clone.getStates();
        assert states!=clonedStates;        
        for (Object k : states.keySet()) {
            State<? extends StatefulObject> s = states.get(k);
            s = s._cloneStateFor(clone);
            if (s != null) clonedStates.put(k, s);
            s._attachedTo(clone);
        }
        return clone;
    }

   
}