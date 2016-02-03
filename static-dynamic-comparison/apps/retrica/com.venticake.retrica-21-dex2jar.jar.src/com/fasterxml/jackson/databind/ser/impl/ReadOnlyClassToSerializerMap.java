package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ser.SerializerCache.TypeKey;
import java.util.HashMap;

public final class ReadOnlyClassToSerializerMap
{
  protected SerializerCache.TypeKey _cacheKey = null;
  protected final JsonSerializerMap _map;
  
  private ReadOnlyClassToSerializerMap(JsonSerializerMap paramJsonSerializerMap)
  {
    this._map = paramJsonSerializerMap;
  }
  
  public static ReadOnlyClassToSerializerMap from(HashMap<SerializerCache.TypeKey, JsonSerializer<Object>> paramHashMap)
  {
    return new ReadOnlyClassToSerializerMap(new JsonSerializerMap(paramHashMap));
  }
  
  public ReadOnlyClassToSerializerMap instance()
  {
    return new ReadOnlyClassToSerializerMap(this._map);
  }
  
  public JsonSerializer<Object> typedValueSerializer(JavaType paramJavaType)
  {
    if (this._cacheKey == null) {
      this._cacheKey = new SerializerCache.TypeKey(paramJavaType, true);
    }
    for (;;)
    {
      return this._map.find(this._cacheKey);
      this._cacheKey.resetTyped(paramJavaType);
    }
  }
  
  public JsonSerializer<Object> untypedValueSerializer(JavaType paramJavaType)
  {
    if (this._cacheKey == null) {
      this._cacheKey = new SerializerCache.TypeKey(paramJavaType, false);
    }
    for (;;)
    {
      return this._map.find(this._cacheKey);
      this._cacheKey.resetUntyped(paramJavaType);
    }
  }
  
  public JsonSerializer<Object> untypedValueSerializer(Class<?> paramClass)
  {
    if (this._cacheKey == null) {
      this._cacheKey = new SerializerCache.TypeKey(paramClass, false);
    }
    for (;;)
    {
      return this._map.find(this._cacheKey);
      this._cacheKey.resetUntyped(paramClass);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/ser/impl/ReadOnlyClassToSerializerMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */