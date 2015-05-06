package com.compass.ingenium.myapplication.modelclasses;

import com.compass.ingenium.myapplication.modelclasses.Event;

import java.io.Serializable;

/**
 * Created by mertinan on 22.4.2015.
 */
public abstract class Pigment implements Serializable {
    public abstract Event getEvent(int location);
    public abstract void addEvent( Event event);
    public abstract Event removeEvent( int location);
}
