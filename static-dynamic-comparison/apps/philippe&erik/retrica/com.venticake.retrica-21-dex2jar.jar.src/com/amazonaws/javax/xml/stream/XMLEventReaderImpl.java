package com.amazonaws.javax.xml.stream;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.javax.xml.stream.events.XMLEventAllocatorImpl;
import com.amazonaws.javax.xml.stream.util.XMLEventAllocator;
import java.util.NoSuchElementException;

public class XMLEventReaderImpl
  implements XMLEventReader
{
  private XMLEvent fLastEvent;
  private XMLEvent fPeekedEvent;
  protected XMLEventAllocator fXMLEventAllocator;
  protected XMLStreamReader fXMLReader;
  
  public XMLEventReaderImpl(XMLStreamReader paramXMLStreamReader)
  {
    this.fXMLReader = paramXMLStreamReader;
    this.fXMLEventAllocator = ((XMLEventAllocator)paramXMLStreamReader.getProperty("com.amazonaws.javax.xml.stream.allocator"));
    if (this.fXMLEventAllocator == null) {
      this.fXMLEventAllocator = new XMLEventAllocatorImpl();
    }
    this.fPeekedEvent = this.fXMLEventAllocator.allocate(this.fXMLReader);
  }
  
  public void close()
  {
    this.fXMLReader.close();
  }
  
  public boolean hasNext()
  {
    if (this.fPeekedEvent != null) {
      return true;
    }
    try
    {
      boolean bool = this.fXMLReader.hasNext();
      return bool;
    }
    catch (XMLStreamException localXMLStreamException) {}
    return false;
  }
  
  public Object next()
  {
    try
    {
      XMLEvent localXMLEvent = nextEvent();
      return localXMLEvent;
    }
    catch (XMLStreamException localXMLStreamException)
    {
      this.fLastEvent = null;
      throw new NoSuchElementException();
    }
  }
  
  public XMLEvent nextEvent()
  {
    if (this.fPeekedEvent != null)
    {
      this.fLastEvent = this.fPeekedEvent;
      this.fPeekedEvent = null;
      return this.fLastEvent;
    }
    if (this.fXMLReader.hasNext())
    {
      this.fXMLReader.next();
      XMLEvent localXMLEvent = this.fXMLEventAllocator.allocate(this.fXMLReader);
      this.fLastEvent = localXMLEvent;
      return localXMLEvent;
    }
    this.fLastEvent = null;
    throw new NoSuchElementException();
  }
  
  public XMLEvent peek()
  {
    if (this.fPeekedEvent != null) {
      return this.fPeekedEvent;
    }
    if (hasNext())
    {
      this.fXMLReader.next();
      this.fPeekedEvent = this.fXMLEventAllocator.allocate(this.fXMLReader);
      return this.fPeekedEvent;
    }
    return null;
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/XMLEventReaderImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */