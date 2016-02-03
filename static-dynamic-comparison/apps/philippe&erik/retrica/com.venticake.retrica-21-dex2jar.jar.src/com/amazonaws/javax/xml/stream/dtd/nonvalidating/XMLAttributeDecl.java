package com.amazonaws.javax.xml.stream.dtd.nonvalidating;

import com.amazonaws.javax.xml.stream.xerces.xni.QName;

public class XMLAttributeDecl
{
  public final QName name = new QName();
  public boolean optional;
  public final XMLSimpleType simpleType = new XMLSimpleType();
  
  public void setValues(QName paramQName, XMLSimpleType paramXMLSimpleType, boolean paramBoolean)
  {
    this.name.setValues(paramQName);
    this.simpleType.setValues(paramXMLSimpleType);
    this.optional = paramBoolean;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/dtd/nonvalidating/XMLAttributeDecl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */