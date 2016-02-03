package com.amazonaws.javax.xml.stream.events;

import com.amazonaws.javax.xml.stream.xerces.xni.XMLResourceIdentifier;

public class EntityDeclarationImpl
  extends DummyEvent
  implements EntityDeclaration
{
  private String fEntityName;
  private String fNotationName;
  private String fReplacementText;
  private XMLResourceIdentifier fXMLResourceIdentifier;
  
  public EntityDeclarationImpl()
  {
    init();
  }
  
  public EntityDeclarationImpl(String paramString1, String paramString2)
  {
    this(paramString1, paramString2, null);
  }
  
  public EntityDeclarationImpl(String paramString1, String paramString2, XMLResourceIdentifier paramXMLResourceIdentifier)
  {
    init();
    this.fEntityName = paramString1;
    this.fReplacementText = paramString2;
    this.fXMLResourceIdentifier = paramXMLResourceIdentifier;
  }
  
  public String getReplacementText()
  {
    return this.fReplacementText;
  }
  
  protected void init()
  {
    setEventType(15);
  }
  
  public void setEntityName(String paramString)
  {
    this.fEntityName = paramString;
  }
  
  public void setEntityReplacementText(String paramString)
  {
    this.fReplacementText = paramString;
  }
  
  public void setNotationName(String paramString)
  {
    this.fNotationName = paramString;
  }
  
  public void setXMLResourceIdentifier(XMLResourceIdentifier paramXMLResourceIdentifier)
  {
    this.fXMLResourceIdentifier = paramXMLResourceIdentifier;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/events/EntityDeclarationImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */