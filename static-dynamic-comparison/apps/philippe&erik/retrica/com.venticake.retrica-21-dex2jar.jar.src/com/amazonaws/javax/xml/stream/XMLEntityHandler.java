package com.amazonaws.javax.xml.stream;

import com.amazonaws.javax.xml.stream.xerces.xni.XMLResourceIdentifier;

public abstract interface XMLEntityHandler
{
  public abstract void endEntity(String paramString);
  
  public abstract void startEntity(String paramString1, XMLResourceIdentifier paramXMLResourceIdentifier, String paramString2);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/XMLEntityHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */