package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.databind.JavaType;

public final class SerializerCache$TypeKey
{
  protected Class<?> _class;
  protected int _hashCode;
  protected boolean _isTyped;
  protected JavaType _type;
  
  public SerializerCache$TypeKey(JavaType paramJavaType, boolean paramBoolean)
  {
    this._type = paramJavaType;
    this._class = null;
    this._isTyped = paramBoolean;
    this._hashCode = hash(paramJavaType, paramBoolean);
  }
  
  public SerializerCache$TypeKey(Class<?> paramClass, boolean paramBoolean)
  {
    this._class = paramClass;
    this._type = null;
    this._isTyped = paramBoolean;
    this._hashCode = hash(paramClass, paramBoolean);
  }
  
  private static final int hash(JavaType paramJavaType, boolean paramBoolean)
  {
    int j = paramJavaType.hashCode() - 1;
    int i = j;
    if (paramBoolean) {
      i = j - 1;
    }
    return i;
  }
  
  private static final int hash(Class<?> paramClass, boolean paramBoolean)
  {
    int j = paramClass.getName().hashCode();
    int i = j;
    if (paramBoolean) {
      i = j + 1;
    }
    return i;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      paramObject = (TypeKey)paramObject;
      if (((TypeKey)paramObject)._isTyped != this._isTyped) {
        break label55;
      }
      if (this._class == null) {
        break;
      }
    } while (((TypeKey)paramObject)._class == this._class);
    return false;
    return this._type.equals(((TypeKey)paramObject)._type);
    label55:
    return false;
  }
  
  public final int hashCode()
  {
    return this._hashCode;
  }
  
  public void resetTyped(JavaType paramJavaType)
  {
    this._type = paramJavaType;
    this._class = null;
    this._isTyped = true;
    this._hashCode = hash(paramJavaType, true);
  }
  
  public void resetUntyped(JavaType paramJavaType)
  {
    this._type = paramJavaType;
    this._class = null;
    this._isTyped = false;
    this._hashCode = hash(paramJavaType, false);
  }
  
  public void resetUntyped(Class<?> paramClass)
  {
    this._type = null;
    this._class = paramClass;
    this._isTyped = false;
    this._hashCode = hash(paramClass, false);
  }
  
  public final String toString()
  {
    if (this._class != null) {
      return "{class: " + this._class.getName() + ", typed? " + this._isTyped + "}";
    }
    return "{type: " + this._type + ", typed? " + this._isTyped + "}";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/ser/SerializerCache$TypeKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */