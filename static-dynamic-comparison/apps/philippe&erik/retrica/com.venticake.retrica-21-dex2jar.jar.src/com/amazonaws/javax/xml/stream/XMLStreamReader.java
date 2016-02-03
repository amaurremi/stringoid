package com.amazonaws.javax.xml.stream;

import com.amazonaws.javax.xml.namespace.NamespaceContext;
import com.amazonaws.javax.xml.namespace.QName;

public abstract interface XMLStreamReader
{
  public abstract void close();
  
  public abstract int getAttributeCount();
  
  public abstract QName getAttributeName(int paramInt);
  
  public abstract String getAttributeType(int paramInt);
  
  public abstract String getAttributeValue(int paramInt);
  
  public abstract String getCharacterEncodingScheme();
  
  public abstract String getEncoding();
  
  public abstract int getEventType();
  
  public abstract String getLocalName();
  
  public abstract Location getLocation();
  
  public abstract NamespaceContext getNamespaceContext();
  
  public abstract int getNamespaceCount();
  
  public abstract String getNamespacePrefix(int paramInt);
  
  public abstract String getNamespaceURI();
  
  public abstract String getNamespaceURI(int paramInt);
  
  public abstract String getPIData();
  
  public abstract String getPITarget();
  
  public abstract String getPrefix();
  
  public abstract Object getProperty(String paramString);
  
  public abstract String getText();
  
  public abstract String getVersion();
  
  public abstract boolean hasNext();
  
  public abstract boolean isAttributeSpecified(int paramInt);
  
  public abstract boolean isStandalone();
  
  public abstract int next();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/XMLStreamReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */