package com.amazonaws.javax.xml.stream;

public abstract class Entity
{
  public boolean inExternalSubset;
  public String name;
  
  public Entity()
  {
    clear();
  }
  
  public Entity(String paramString, boolean paramBoolean)
  {
    this.name = paramString;
    this.inExternalSubset = paramBoolean;
  }
  
  public void clear()
  {
    this.name = null;
    this.inExternalSubset = false;
  }
  
  public boolean isEntityDeclInExternalSubset()
  {
    return this.inExternalSubset;
  }
  
  public abstract boolean isExternal();
  
  public abstract boolean isUnparsed();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/Entity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */