package com.compass.ingenium.myapplication;


/**
 * Created by nurteninan on 22.4.2015.
 */
public class WeekPigment extends Pigment {
    DayPigment[] dayPigments;

    public WeekPigment(){}

    public WeekPigment( DayPigment[] dayPigments){
        this.dayPigments = dayPigments;
    }

    @Override
    public Event getEvent(int dayLocation, int eventLocation) {
        return dayPigments[dayLocation].getEvent(eventLocation);
    }

    @Override
    public void addEvent(Event event, int dayLocation) {
        dayPigments[dayLocation].addEvent(event);
    }

    @Override
    public Event removeEvent(int location) {
        return null;
    }
}
