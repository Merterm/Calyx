package com.compass.ingenium.myapplication.modelclasses;

import com.compass.ingenium.myapplication.modelclasses.Event;

/**
 * Created by mertinan on 22.4.2015.
 */
public abstract class Pigment {
    public abstract Event getEvent(int location);
    public abstract void addEvent( Event event);
    public abstract Event removeEvent( int location);
}
