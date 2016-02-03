package com.amazonaws.javax.xml.stream.events;

import com.amazonaws.javax.xml.stream.Location;

public abstract class DummyEvent
  implements XMLEvent
{
  private int fEventType;
  protected Location fLocation = null;
  
  public Characters asCharacters()
  {
    return (Characters)this;
  }
  
  public StartElement asStartElement()
  {
    return (StartElement)this;
  }
  
  public int getEventType()
  {
    return this.fEventType;
  }
  
  public boolean isAttribute()
  {
    return this.fEventType == 10;
  }
  
  public boolean isCharacters()
  {
    return this.fEventType == 4;
  }
  
  public boolean isEndDocument()
  {
    return this.fEventType == 8;
  }
  
  public boolean isEndElement()
  {
    return this.fEventType == 2;
  }
  
  public boolean isNamespace()
  {
    return this.fEventType == 13;
  }
  
  public boolean isStartDocument()
  {
    return this.fEventType == 7;
  }
  
  public boolean isStartElement()
  {
    return this.fEventType == 1;
  }
  
  protected void setEventType(int paramInt)
  {
    this.fEventType = paramInt;
  }
  
  void setLocation(Location paramLocation)
  {
    this.fLocation = paramLocation;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/events/DummyEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */