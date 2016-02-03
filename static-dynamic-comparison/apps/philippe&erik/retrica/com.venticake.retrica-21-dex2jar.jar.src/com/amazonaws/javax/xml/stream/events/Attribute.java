package com.amazonaws.javax.xml.stream.events;

import com.amazonaws.javax.xml.namespace.QName;

public abstract interface Attribute
  extends XMLEvent
{
  public abstract QName getName();
  
  public abstract String getValue();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/events/Attribute.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */