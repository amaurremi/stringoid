package com.amazonaws.javax.xml.stream.xerces.xni.parser;

public abstract interface XMLErrorHandler
{
  public abstract void error(String paramString1, String paramString2, XMLParseException paramXMLParseException);
  
  public abstract void fatalError(String paramString1, String paramString2, XMLParseException paramXMLParseException);
  
  public abstract void warning(String paramString1, String paramString2, XMLParseException paramXMLParseException);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/xerces/xni/parser/XMLErrorHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */