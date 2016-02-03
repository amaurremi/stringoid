package com.fasterxml.jackson.databind.type;

import com.fasterxml.jackson.databind.JavaType;

public final class MapType
  extends MapLikeType
{
  private MapType(Class<?> paramClass, JavaType paramJavaType1, JavaType paramJavaType2, Object paramObject1, Object paramObject2)
  {
    super(paramClass, paramJavaType1, paramJavaType2, paramObject1, paramObject2);
  }
  
  public static MapType construct(Class<?> paramClass, JavaType paramJavaType1, JavaType paramJavaType2)
  {
    return new MapType(paramClass, paramJavaType1, paramJavaType2, null, null);
  }
  
  protected JavaType _narrow(Class<?> paramClass)
  {
    return new MapType(paramClass, this._keyType, this._valueType, this._valueHandler, this._typeHandler);
  }
  
  public JavaType narrowContentsBy(Class<?> paramClass)
  {
    if (paramClass == this._valueType.getRawClass()) {
      return this;
    }
    return new MapType(this._class, this._keyType, this._valueType.narrowBy(paramClass), this._valueHandler, this._typeHandler);
  }
  
  public JavaType narrowKey(Class<?> paramClass)
  {
    if (paramClass == this._keyType.getRawClass()) {
      return this;
    }
    return new MapType(this._class, this._keyType.narrowBy(paramClass), this._valueType, this._valueHandler, this._typeHandler);
  }
  
  public String toString()
  {
    return "[map type; class " + this._class.getName() + ", " + this._keyType + " -> " + this._valueType + "]";
  }
  
  public JavaType widenContentsBy(Class<?> paramClass)
  {
    if (paramClass == this._valueType.getRawClass()) {
      return this;
    }
    return new MapType(this._class, this._keyType, this._valueType.widenBy(paramClass), this._valueHandler, this._typeHandler);
  }
  
  public JavaType widenKey(Class<?> paramClass)
  {
    if (paramClass == this._keyType.getRawClass()) {
      return this;
    }
    return new MapType(this._class, this._keyType.widenBy(paramClass), this._valueType, this._valueHandler, this._typeHandler);
  }
  
  public MapType withContentTypeHandler(Object paramObject)
  {
    return new MapType(this._class, this._keyType, this._valueType.withTypeHandler(paramObject), this._valueHandler, this._typeHandler);
  }
  
  public MapType withContentValueHandler(Object paramObject)
  {
    return new MapType(this._class, this._keyType, this._valueType.withValueHandler(paramObject), this._valueHandler, this._typeHandler);
  }
  
  public MapType withKeyValueHandler(Object paramObject)
  {
    return new MapType(this._class, this._keyType.withValueHandler(paramObject), this._valueType, this._valueHandler, this._typeHandler);
  }
  
  public MapType withTypeHandler(Object paramObject)
  {
    return new MapType(this._class, this._keyType, this._valueType, this._valueHandler, paramObject);
  }
  
  public MapType withValueHandler(Object paramObject)
  {
    return new MapType(this._class, this._keyType, this._valueType, paramObject, this._typeHandler);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/type/MapType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */