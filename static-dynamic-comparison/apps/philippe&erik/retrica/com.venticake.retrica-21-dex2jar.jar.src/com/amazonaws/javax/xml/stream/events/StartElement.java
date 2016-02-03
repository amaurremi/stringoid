package com.amazonaws.javax.xml.stream.events;

import com.amazonaws.javax.xml.namespace.QName;
import java.util.Iterator;

public abstract interface StartElement
  extends XMLEvent
{
  public abstract Iterator getAttributes();
  
  public abstract QName getName();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/events/StartElement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */