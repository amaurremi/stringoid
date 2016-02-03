package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.impl.IndexedListSerializer;
import com.fasterxml.jackson.databind.ser.impl.IteratorSerializer;

public class StdContainerSerializers
{
  public static ContainerSerializer<?> collectionSerializer(JavaType paramJavaType, boolean paramBoolean, TypeSerializer paramTypeSerializer, JsonSerializer<Object> paramJsonSerializer)
  {
    return new CollectionSerializer(paramJavaType, paramBoolean, paramTypeSerializer, null, paramJsonSerializer);
  }
  
  public static JsonSerializer<?> enumSetSerializer(JavaType paramJavaType)
  {
    return new EnumSetSerializer(paramJavaType, null);
  }
  
  public static ContainerSerializer<?> indexedListSerializer(JavaType paramJavaType, boolean paramBoolean, TypeSerializer paramTypeSerializer, JsonSerializer<Object> paramJsonSerializer)
  {
    return new IndexedListSerializer(paramJavaType, paramBoolean, paramTypeSerializer, null, paramJsonSerializer);
  }
  
  public static ContainerSerializer<?> iterableSerializer(JavaType paramJavaType, boolean paramBoolean, TypeSerializer paramTypeSerializer)
  {
    return new IterableSerializer(paramJavaType, paramBoolean, paramTypeSerializer, null);
  }
  
  public static ContainerSerializer<?> iteratorSerializer(JavaType paramJavaType, boolean paramBoolean, TypeSerializer paramTypeSerializer)
  {
    return new IteratorSerializer(paramJavaType, paramBoolean, paramTypeSerializer, null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/ser/std/StdContainerSerializers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */