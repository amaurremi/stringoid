package com.amazonaws.javax.xml.stream.xerces.xni;

import java.util.Enumeration;

public abstract interface NamespaceContext
{
  public static final String XMLNS_URI = "http://www.w3.org/2000/xmlns/".intern();
  public static final String XML_URI = "http://www.w3.org/XML/1998/namespace".intern();
  
  public abstract boolean declarePrefix(String paramString1, String paramString2);
  
  public abstract Enumeration getAllPrefixes();
  
  public abstract String getDeclaredPrefixAt(int paramInt);
  
  public abstract int getDeclaredPrefixCount();
  
  public abstract String getURI(String paramString);
  
  public abstract void popContext();
  
  public abstract void pushContext();
  
  public abstract void reset();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/xerces/xni/NamespaceContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */