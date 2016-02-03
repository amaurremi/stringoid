package com.amazonaws.javax.xml.stream.events;

import com.amazonaws.javax.xml.stream.dtd.nonvalidating.XMLNotationDecl;

public class NotationDeclarationImpl
  extends DummyEvent
  implements NotationDeclaration
{
  String fName = null;
  String fPublicId = null;
  String fSystemId = null;
  
  public NotationDeclarationImpl()
  {
    setEventType(14);
  }
  
  public NotationDeclarationImpl(XMLNotationDecl paramXMLNotationDecl)
  {
    this.fName = paramXMLNotationDecl.name;
    this.fPublicId = paramXMLNotationDecl.publicId;
    this.fSystemId = paramXMLNotationDecl.systemId;
    setEventType(14);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/events/NotationDeclarationImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */