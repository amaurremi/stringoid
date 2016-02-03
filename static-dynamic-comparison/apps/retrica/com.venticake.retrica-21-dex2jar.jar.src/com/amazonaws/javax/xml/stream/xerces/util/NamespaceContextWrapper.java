package com.amazonaws.javax.xml.stream.xerces.util;

public class NamespaceContextWrapper
  implements com.amazonaws.javax.xml.namespace.NamespaceContext
{
  private com.amazonaws.javax.xml.stream.xerces.xni.NamespaceContext fNamespaceContext;
  
  public NamespaceContextWrapper(com.amazonaws.javax.xml.stream.xerces.xni.NamespaceContext paramNamespaceContext)
  {
    this.fNamespaceContext = paramNamespaceContext;
  }
  
  public com.amazonaws.javax.xml.stream.xerces.xni.NamespaceContext getNamespaceContext()
  {
    return this.fNamespaceContext;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/xerces/util/NamespaceContextWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */