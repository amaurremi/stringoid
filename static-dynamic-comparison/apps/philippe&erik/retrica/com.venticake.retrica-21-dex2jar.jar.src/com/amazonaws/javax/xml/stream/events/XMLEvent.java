package com.amazonaws.javax.xml.stream.events;

public abstract interface XMLEvent
{
  public abstract Characters asCharacters();
  
  public abstract StartElement asStartElement();
  
  public abstract int getEventType();
  
  public abstract boolean isAttribute();
  
  public abstract boolean isCharacters();
  
  public abstract boolean isEndDocument();
  
  public abstract boolean isEndElement();
  
  public abstract boolean isNamespace();
  
  public abstract boolean isStartDocument();
  
  public abstract boolean isStartElement();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/events/XMLEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */