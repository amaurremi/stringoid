package com.amazonaws.javax.xml.stream;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import java.util.Iterator;

public abstract interface XMLEventReader
  extends Iterator
{
  public abstract void close();
  
  public abstract boolean hasNext();
  
  public abstract XMLEvent nextEvent();
  
  public abstract XMLEvent peek();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/XMLEventReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */