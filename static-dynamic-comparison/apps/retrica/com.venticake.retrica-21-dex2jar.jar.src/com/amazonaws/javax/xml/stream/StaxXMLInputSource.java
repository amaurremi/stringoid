package com.amazonaws.javax.xml.stream;

import com.amazonaws.javax.xml.stream.xerces.xni.parser.XMLInputSource;

public class StaxXMLInputSource
{
  XMLEventReader fEventReader;
  XMLInputSource fInputSource;
  XMLStreamReader fStreamReader;
  
  public StaxXMLInputSource(XMLEventReader paramXMLEventReader)
  {
    this.fEventReader = paramXMLEventReader;
  }
  
  public StaxXMLInputSource(XMLStreamReader paramXMLStreamReader)
  {
    this.fStreamReader = paramXMLStreamReader;
  }
  
  public StaxXMLInputSource(XMLInputSource paramXMLInputSource)
  {
    this.fInputSource = paramXMLInputSource;
  }
  
  public XMLInputSource getXMLInputSource()
  {
    return this.fInputSource;
  }
  
  public boolean hasXMLStreamOrXMLEventReader()
  {
    return (this.fStreamReader != null) || (this.fEventReader != null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/StaxXMLInputSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */