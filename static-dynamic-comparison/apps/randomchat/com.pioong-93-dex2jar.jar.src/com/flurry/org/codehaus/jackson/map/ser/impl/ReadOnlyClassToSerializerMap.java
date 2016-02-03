package com.flurry.org.codehaus.jackson.map.ser.impl;

import com.flurry.org.codehaus.jackson.map.JsonSerializer;
import com.flurry.org.codehaus.jackson.type.JavaType;
import java.util.HashMap;

public final class ReadOnlyClassToSerializerMap
{
  protected final SerializerCache.TypeKey _cacheKey = new SerializerCache.TypeKey(getClass(), false);
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
    this._cacheKey.resetTyped(paramJavaType);
    return this._map.find(this._cacheKey);
  }
  
  public JsonSerializer<Object> typedValueSerializer(Class<?> paramClass)
  {
    this._cacheKey.resetTyped(paramClass);
    return this._map.find(this._cacheKey);
  }
  
  public JsonSerializer<Object> untypedValueSerializer(JavaType paramJavaType)
  {
    this._cacheKey.resetUntyped(paramJavaType);
    return this._map.find(this._cacheKey);
  }
  
  public JsonSerializer<Object> untypedValueSerializer(Class<?> paramClass)
  {
    this._cacheKey.resetUntyped(paramClass);
    return this._map.find(this._cacheKey);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/ser/impl/ReadOnlyClassToSerializerMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */