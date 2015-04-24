package com.compass.ingenium.myapplication.modelclasses;


/**
 * Created by Mert Inan on 22.4.2015.
 */
public class WeekPigment extends Pigment {
    DayPigment[] dayPigments;

    public WeekPigment(){}

    public WeekPigment( DayPigment[] dayPigments){
        this.dayPigments = dayPigments;
    }

    /*@Override
    public Event getEvent(int dayLocation, int eventLocation) {
        return dayPigments[dayLocation].getEvent(eventLocation);
    }*/

    /*@Override
    public void addEvent(Event event, int dayLocation) {
        dayPigments[dayLocation].addEvent(event);
    }*/

    @Override
    public Event getEvent(int location) {
        return null;
    }

    @Override
    public void addEvent(Event event) {

    }

    @Override
    public Event removeEvent(int location) {
        return null;
    }
}
