package com.amazonaws.javax.xml.stream;

import com.amazonaws.javax.xml.stream.xerces.xni.XMLResourceIdentifier;

public class Entity$ExternalEntity
  extends Entity
{
  public XMLResourceIdentifier entityLocation;
  public String notation;
  
  public Entity$ExternalEntity()
  {
    clear();
  }
  
  public Entity$ExternalEntity(String paramString1, XMLResourceIdentifier paramXMLResourceIdentifier, String paramString2, boolean paramBoolean)
  {
    super(paramString1, paramBoolean);
    this.entityLocation = paramXMLResourceIdentifier;
    this.notation = paramString2;
  }
  
  public void clear()
  {
    super.clear();
    this.entityLocation = null;
    this.notation = null;
  }
  
  public final boolean isExternal()
  {
    return true;
  }
  
  public final boolean isUnparsed()
  {
    return this.notation != null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/Entity$ExternalEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */