package com.amazonaws.javax.xml.stream.events;

public class EntityReferenceEvent
  extends DummyEvent
  implements EntityReference
{
  private EntityDeclaration fEntityDeclaration;
  private String fEntityName;
  
  public EntityReferenceEvent()
  {
    init();
  }
  
  public EntityReferenceEvent(String paramString, EntityDeclaration paramEntityDeclaration)
  {
    init();
    this.fEntityName = paramString;
    this.fEntityDeclaration = paramEntityDeclaration;
  }
  
  public String getName()
  {
    return this.fEntityName;
  }
  
  protected void init()
  {
    setEventType(9);
  }
  
  public String toString()
  {
    String str2 = this.fEntityDeclaration.getReplacementText();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return "&" + getName() + ";='" + str1 + "'";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/events/EntityReferenceEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */