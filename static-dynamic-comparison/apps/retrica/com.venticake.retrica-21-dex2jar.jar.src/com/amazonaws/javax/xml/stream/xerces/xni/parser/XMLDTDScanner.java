package com.amazonaws.javax.xml.stream.xerces.xni.parser;

public abstract interface XMLDTDScanner
  extends XMLDTDContentModelSource, XMLDTDSource
{
  public abstract boolean scanDTDExternalSubset(boolean paramBoolean);
  
  public abstract boolean scanDTDInternalSubset(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
  
  public abstract void setInputSource(XMLInputSource paramXMLInputSource);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/xerces/xni/parser/XMLDTDScanner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */