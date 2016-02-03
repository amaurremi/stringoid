package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;

@JacksonStdImpl
public class MapSerializer
  extends ContainerSerializer<Map<?, ?>>
  implements ContextualSerializer
{
  protected static final JavaType UNSPECIFIED_TYPE = ;
  protected PropertySerializerMap _dynamicValueSerializers;
  protected final HashSet<String> _ignoredEntries;
  protected JsonSerializer<Object> _keySerializer;
  protected final JavaType _keyType;
  protected final BeanProperty _property;
  protected JsonSerializer<Object> _valueSerializer;
  protected final JavaType _valueType;
  protected final boolean _valueTypeIsStatic;
  protected final TypeSerializer _valueTypeSerializer;
  
  protected MapSerializer(MapSerializer paramMapSerializer, BeanProperty paramBeanProperty, JsonSerializer<?> paramJsonSerializer1, JsonSerializer<?> paramJsonSerializer2, HashSet<String> paramHashSet)
  {
    super(Map.class, false);
    this._ignoredEntries = paramHashSet;
    this._keyType = paramMapSerializer._keyType;
    this._valueType = paramMapSerializer._valueType;
    this._valueTypeIsStatic = paramMapSerializer._valueTypeIsStatic;
    this._valueTypeSerializer = paramMapSerializer._valueTypeSerializer;
    this._keySerializer = paramJsonSerializer1;
    this._valueSerializer = paramJsonSerializer2;
    this._dynamicValueSerializers = paramMapSerializer._dynamicValueSerializers;
    this._property = paramBeanProperty;
  }
  
  protected MapSerializer(MapSerializer paramMapSerializer, TypeSerializer paramTypeSerializer)
  {
    super(Map.class, false);
    this._ignoredEntries = paramMapSerializer._ignoredEntries;
    this._keyType = paramMapSerializer._keyType;
    this._valueType = paramMapSerializer._valueType;
    this._valueTypeIsStatic = paramMapSerializer._valueTypeIsStatic;
    this._valueTypeSerializer = paramTypeSerializer;
    this._keySerializer = paramMapSerializer._keySerializer;
    this._valueSerializer = paramMapSerializer._valueSerializer;
    this._dynamicValueSerializers = paramMapSerializer._dynamicValueSerializers;
    this._property = paramMapSerializer._property;
  }
  
  protected MapSerializer(HashSet<String> paramHashSet, JavaType paramJavaType1, JavaType paramJavaType2, boolean paramBoolean, TypeSerializer paramTypeSerializer, JsonSerializer<?> paramJsonSerializer1, JsonSerializer<?> paramJsonSerializer2)
  {
    super(Map.class, false);
    this._ignoredEntries = paramHashSet;
    this._keyType = paramJavaType1;
    this._valueType = paramJavaType2;
    this._valueTypeIsStatic = paramBoolean;
    this._valueTypeSerializer = paramTypeSerializer;
    this._keySerializer = paramJsonSerializer1;
    this._valueSerializer = paramJsonSerializer2;
    this._dynamicValueSerializers = PropertySerializerMap.emptyMap();
    this._property = null;
  }
  
  public static MapSerializer construct(String[] paramArrayOfString, JavaType paramJavaType, boolean paramBoolean, TypeSerializer paramTypeSerializer, JsonSerializer<Object> paramJsonSerializer1, JsonSerializer<Object> paramJsonSerializer2)
  {
    HashSet localHashSet = toSet(paramArrayOfString);
    if (paramJavaType == null)
    {
      paramArrayOfString = UNSPECIFIED_TYPE;
      paramJavaType = paramArrayOfString;
      if (paramBoolean) {
        break label69;
      }
      if ((paramJavaType == null) || (!paramJavaType.isFinal())) {
        break label64;
      }
      paramBoolean = true;
    }
    label64:
    label69:
    for (;;)
    {
      return new MapSerializer(localHashSet, paramArrayOfString, paramJavaType, paramBoolean, paramTypeSerializer, paramJsonSerializer1, paramJsonSerializer2);
      paramArrayOfString = paramJavaType.getKeyType();
      paramJavaType = paramJavaType.getContentType();
      break;
      paramBoolean = false;
    }
  }
  
  private static HashSet<String> toSet(String[] paramArrayOfString)
  {
    Object localObject;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      localObject = null;
      return (HashSet<String>)localObject;
    }
    HashSet localHashSet = new HashSet(paramArrayOfString.length);
    int j = paramArrayOfString.length;
    int i = 0;
    for (;;)
    {
      localObject = localHashSet;
      if (i >= j) {
        break;
      }
      localHashSet.add(paramArrayOfString[i]);
      i += 1;
    }
  }
  
  public MapSerializer _withValueTypeSerializer(TypeSerializer paramTypeSerializer)
  {
    return new MapSerializer(this, paramTypeSerializer);
  }
  
  public JsonSerializer<?> createContextual(SerializerProvider paramSerializerProvider, BeanProperty paramBeanProperty)
  {
    Object localObject1 = null;
    Object localObject2;
    Object localObject3;
    if (paramBeanProperty != null)
    {
      localObject2 = paramBeanProperty.getMember();
      if (localObject2 != null)
      {
        localObject3 = paramSerializerProvider.getAnnotationIntrospector();
        localObject1 = ((AnnotationIntrospector)localObject3).findKeySerializer((Annotated)localObject2);
        if (localObject1 != null)
        {
          localObject1 = paramSerializerProvider.serializerInstance((Annotated)localObject2, localObject1);
          localObject3 = ((AnnotationIntrospector)localObject3).findContentSerializer((Annotated)localObject2);
          if (localObject3 != null) {
            localObject2 = paramSerializerProvider.serializerInstance((Annotated)localObject2, localObject3);
          }
        }
      }
    }
    for (;;)
    {
      localObject3 = localObject2;
      if (localObject2 == null) {
        localObject3 = this._valueSerializer;
      }
      if (localObject3 == null)
      {
        if ((!this._valueTypeIsStatic) && (!hasContentTypeAnnotation(paramSerializerProvider, paramBeanProperty))) {
          break label315;
        }
        localObject2 = paramSerializerProvider.findValueSerializer(this._valueType, paramBeanProperty);
      }
      for (;;)
      {
        if (localObject1 == null) {}
        for (localObject3 = this._keySerializer;; localObject3 = localObject1)
        {
          label148:
          String[] arrayOfString;
          if (localObject3 == null)
          {
            localObject1 = paramSerializerProvider.findKeySerializer(this._keyType, paramBeanProperty);
            localObject3 = this._ignoredEntries;
            paramSerializerProvider = paramSerializerProvider.getAnnotationIntrospector();
            if ((paramSerializerProvider == null) || (paramBeanProperty == null)) {
              break label296;
            }
            arrayOfString = paramSerializerProvider.findPropertiesToIgnore(paramBeanProperty.getMember());
            if (arrayOfString == null) {
              break label296;
            }
            if (localObject3 != null) {
              break label283;
            }
          }
          label283:
          for (paramSerializerProvider = new HashSet();; paramSerializerProvider = new HashSet((Collection)localObject3))
          {
            int j = arrayOfString.length;
            int i = 0;
            for (;;)
            {
              localObject3 = paramSerializerProvider;
              if (i >= j) {
                break;
              }
              paramSerializerProvider.add(arrayOfString[i]);
              i += 1;
            }
            if (!(localObject3 instanceof ContextualSerializer)) {
              break label315;
            }
            localObject2 = ((ContextualSerializer)localObject3).createContextual(paramSerializerProvider, paramBeanProperty);
            break;
            localObject1 = localObject3;
            if (!(localObject3 instanceof ContextualSerializer)) {
              break label148;
            }
            localObject1 = ((ContextualSerializer)localObject3).createContextual(paramSerializerProvider, paramBeanProperty);
            break label148;
          }
          label296:
          return withResolved(paramBeanProperty, (JsonSerializer)localObject1, (JsonSerializer)localObject2, (HashSet)localObject3);
        }
        label315:
        localObject2 = localObject3;
      }
      localObject2 = null;
      continue;
      localObject1 = null;
      break;
      localObject2 = null;
    }
  }
  
  public MapSerializer withResolved(BeanProperty paramBeanProperty, JsonSerializer<?> paramJsonSerializer1, JsonSerializer<?> paramJsonSerializer2, HashSet<String> paramHashSet)
  {
    return new MapSerializer(this, paramBeanProperty, paramJsonSerializer1, paramJsonSerializer2, paramHashSet);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/ser/std/MapSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */