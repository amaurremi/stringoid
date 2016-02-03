package com.fasterxml.jackson.annotation;

import java.io.Serializable;

public final class ObjectIdGenerator$IdKey
  implements Serializable
{
  private final int hashCode;
  private final Object key;
  private final Class<?> scope;
  private final Class<?> type;
  
  public ObjectIdGenerator$IdKey(Class<?> paramClass1, Class<?> paramClass2, Object paramObject)
  {
    this.type = paramClass1;
    this.scope = paramClass2;
    this.key = paramObject;
    int j = paramObject.hashCode() + paramClass1.getName().hashCode();
    int i = j;
    if (paramClass2 != null) {
      i = j ^ paramClass2.getName().hashCode();
    }
    this.hashCode = i;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (paramObject.getClass() != getClass()) {
        return false;
      }
      paramObject = (IdKey)paramObject;
    } while ((((IdKey)paramObject).key.equals(this.key)) && (((IdKey)paramObject).type == this.type) && (((IdKey)paramObject).scope == this.scope));
    return false;
  }
  
  public int hashCode()
  {
    return this.hashCode;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/annotation/ObjectIdGenerator$IdKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */