package com.amazonaws.javax.xml.stream;

public class Entity$InternalEntity
  extends Entity
{
  public String text;
  
  public Entity$InternalEntity()
  {
    clear();
  }
  
  public Entity$InternalEntity(String paramString1, String paramString2, boolean paramBoolean)
  {
    super(paramString1, paramBoolean);
    this.text = paramString2;
  }
  
  public void clear()
  {
    super.clear();
    this.text = null;
  }
  
  public final boolean isExternal()
  {
    return false;
  }
  
  public final boolean isUnparsed()
  {
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/Entity$InternalEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */