package com.compass.ingenium.myapplication;

import java.sql.Time;
import java.util.*;

/**
 * name: Event
 * description:Event class which will be organised in Pigments
 * author: imge.gokalp
 * version 1.0
 * date: 22/04/2015
 */ 
public class Event
{
  
  // properties
  protected Time startTime;
  protected Time endTime;
  protected Date date;
  protected String description;
  protected boolean isOver; 
  protected float length;
  
  // constructors
  public Event (Time start, Time end, Date date, String description)
  {
   startTime = start;
   endTime = end;
   this.date = date;
   this.description = description;
   isOver = false;
  }
  
  // methods
  
  //get methods
  public Time getStartTime()
  {
    return startTime;
  }
  
  public Time getEndTime()
  {
    return endTime;
  }
  
  public Date getDate()
  {
    return date;
  }
  
  public String getDescription()
  {
    return description;
  }
  
  public boolean getOver()
  {
    return isOver;
  }
  
  public float getlength()
  {
    return length;
  }
    
  //set methods
  
  public void setStartTime(Time start)
  {
    startTime = start;
  }
  
  public void setEndTime(Time end)
  {
    endTime = end;
  }
  
  public void setDate(Date date)
  {
    this.date = date;
  }
  
  public void setDescription(String description)
  {
    this.description = description;
  }
    
  public void setLength(Float length)
  {
    this.length = length;
  }
}