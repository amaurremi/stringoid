package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.impl.ReadOnlyClassToSerializerMap;
import java.util.HashMap;

public final class SerializerCache
{
  private ReadOnlyClassToSerializerMap _readOnlyMap = null;
  private HashMap<SerializerCache.TypeKey, JsonSerializer<Object>> _sharedMap = new HashMap(64);
  
  public void addAndResolveNonTypedSerializer(JavaType paramJavaType, JsonSerializer<Object> paramJsonSerializer, SerializerProvider paramSerializerProvider)
  {
    try
    {
      if (this._sharedMap.put(new SerializerCache.TypeKey(paramJavaType, false), paramJsonSerializer) == null) {
        this._readOnlyMap = null;
      }
      if ((paramJsonSerializer instanceof ResolvableSerializer)) {
        ((ResolvableSerializer)paramJsonSerializer).resolve(paramSerializerProvider);
      }
      return;
    }
    finally {}
  }
  
  public void addAndResolveNonTypedSerializer(Class<?> paramClass, JsonSerializer<Object> paramJsonSerializer, SerializerProvider paramSerializerProvider)
  {
    try
    {
      if (this._sharedMap.put(new SerializerCache.TypeKey(paramClass, false), paramJsonSerializer) == null) {
        this._readOnlyMap = null;
      }
      if ((paramJsonSerializer instanceof ResolvableSerializer)) {
        ((ResolvableSerializer)paramJsonSerializer).resolve(paramSerializerProvider);
      }
      return;
    }
    finally {}
  }
  
  public void addTypedSerializer(JavaType paramJavaType, JsonSerializer<Object> paramJsonSerializer)
  {
    try
    {
      if (this._sharedMap.put(new SerializerCache.TypeKey(paramJavaType, true), paramJsonSerializer) == null) {
        this._readOnlyMap = null;
      }
      return;
    }
    finally {}
  }
  
  public ReadOnlyClassToSerializerMap getReadOnlyLookupMap()
  {
    try
    {
      ReadOnlyClassToSerializerMap localReadOnlyClassToSerializerMap2 = this._readOnlyMap;
      ReadOnlyClassToSerializerMap localReadOnlyClassToSerializerMap1 = localReadOnlyClassToSerializerMap2;
      if (localReadOnlyClassToSerializerMap2 == null)
      {
        localReadOnlyClassToSerializerMap1 = ReadOnlyClassToSerializerMap.from(this._sharedMap);
        this._readOnlyMap = localReadOnlyClassToSerializerMap1;
      }
      return localReadOnlyClassToSerializerMap1.instance();
    }
    finally {}
  }
  
  public JsonSerializer<Object> typedValueSerializer(JavaType paramJavaType)
  {
    try
    {
      paramJavaType = (JsonSerializer)this._sharedMap.get(new SerializerCache.TypeKey(paramJavaType, true));
      return paramJavaType;
    }
    finally {}
  }
  
  public JsonSerializer<Object> untypedValueSerializer(JavaType paramJavaType)
  {
    try
    {
      paramJavaType = (JsonSerializer)this._sharedMap.get(new SerializerCache.TypeKey(paramJavaType, false));
      return paramJavaType;
    }
    finally {}
  }
  
  public JsonSerializer<Object> untypedValueSerializer(Class<?> paramClass)
  {
    try
    {
      paramClass = (JsonSerializer)this._sharedMap.get(new SerializerCache.TypeKey(paramClass, false));
      return paramClass;
    }
    finally {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/ser/SerializerCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */