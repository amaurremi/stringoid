package com.amazonaws.javax.xml.stream.util;

import com.amazonaws.javax.xml.stream.XMLStreamReader;
import com.amazonaws.javax.xml.stream.events.XMLEvent;

public abstract interface XMLEventAllocator
{
  public abstract XMLEvent allocate(XMLStreamReader paramXMLStreamReader);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/util/XMLEventAllocator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */