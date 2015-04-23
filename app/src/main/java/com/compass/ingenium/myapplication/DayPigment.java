package com.compass.ingenium.myapplication;

import java.util.ArrayList;

/**
 * Created by mertinan on 22.4.2015.
 */
public class DayPigment extends Pigment{
    ArrayList<Event> events;

    public DayPigment(ArrayList<Event> events){
        this.events = events;
    }

    public DayPigment(){}

    @Override
    public Event getEvent(int location) {
        return events.get(location);
    }

    @Override
    public void addEvent(Event event) {
        events.add(event);
    }

    @Override
    public Event removeEvent(int location) {
        return events.remove(location);
    }
}
