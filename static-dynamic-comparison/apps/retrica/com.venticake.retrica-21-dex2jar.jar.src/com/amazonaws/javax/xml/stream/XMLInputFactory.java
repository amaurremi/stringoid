package com.amazonaws.javax.xml.stream;

import java.io.InputStream;

public abstract class XMLInputFactory
{
  public static XMLInputFactory newInstance()
  {
    return (XMLInputFactory)FactoryFinder.find("com.amazonaws.javax.xml.stream.XMLInputFactory", "com.amazonaws.javax.xml.stream.ZephyrParserFactory");
  }
  
  public abstract XMLEventReader createXMLEventReader(InputStream paramInputStream);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/XMLInputFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */