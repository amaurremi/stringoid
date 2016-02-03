package org.codehaus.jackson.map.ser.impl;

import java.util.HashMap;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ResolvableSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.type.JavaType;

public final class SerializerCache
{
  private ReadOnlyClassToSerializerMap _readOnlyMap = null;
  private HashMap _sharedMap = new HashMap(64);
  
  public void addAndResolveNonTypedSerializer(Class paramClass, JsonSerializer paramJsonSerializer, SerializerProvider paramSerializerProvider)
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
  
  public void addAndResolveNonTypedSerializer(JavaType paramJavaType, JsonSerializer paramJsonSerializer, SerializerProvider paramSerializerProvider)
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
  
  public void addTypedSerializer(Class paramClass, JsonSerializer paramJsonSerializer)
  {
    try
    {
      if (this._sharedMap.put(new SerializerCache.TypeKey(paramClass, true), paramJsonSerializer) == null) {
        this._readOnlyMap = null;
      }
      return;
    }
    finally {}
  }
  
  public void addTypedSerializer(JavaType paramJavaType, JsonSerializer paramJsonSerializer)
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
  
  public void flush()
  {
    try
    {
      this._sharedMap.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
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
  
  public int size()
  {
    try
    {
      int i = this._sharedMap.size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public JsonSerializer typedValueSerializer(Class paramClass)
  {
    try
    {
      paramClass = (JsonSerializer)this._sharedMap.get(new SerializerCache.TypeKey(paramClass, true));
      return paramClass;
    }
    finally {}
  }
  
  public JsonSerializer typedValueSerializer(JavaType paramJavaType)
  {
    try
    {
      paramJavaType = (JsonSerializer)this._sharedMap.get(new SerializerCache.TypeKey(paramJavaType, true));
      return paramJavaType;
    }
    finally {}
  }
  
  public JsonSerializer untypedValueSerializer(Class paramClass)
  {
    try
    {
      paramClass = (JsonSerializer)this._sharedMap.get(new SerializerCache.TypeKey(paramClass, false));
      return paramClass;
    }
    finally {}
  }
  
  public JsonSerializer untypedValueSerializer(JavaType paramJavaType)
  {
    try
    {
      paramJavaType = (JsonSerializer)this._sharedMap.get(new SerializerCache.TypeKey(paramJavaType, false));
      return paramJavaType;
    }
    finally {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ser/impl/SerializerCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */