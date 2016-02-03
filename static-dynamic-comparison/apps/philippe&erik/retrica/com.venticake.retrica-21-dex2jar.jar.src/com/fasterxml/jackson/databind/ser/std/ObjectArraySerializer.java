package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap;

@JacksonStdImpl
public class ObjectArraySerializer
  extends ArraySerializerBase<Object[]>
  implements ContextualSerializer
{
  protected PropertySerializerMap _dynamicSerializers;
  protected JsonSerializer<Object> _elementSerializer;
  protected final JavaType _elementType;
  protected final boolean _staticTyping;
  protected final TypeSerializer _valueTypeSerializer;
  
  public ObjectArraySerializer(JavaType paramJavaType, boolean paramBoolean, TypeSerializer paramTypeSerializer, JsonSerializer<Object> paramJsonSerializer)
  {
    super(Object[].class, null);
    this._elementType = paramJavaType;
    this._staticTyping = paramBoolean;
    this._valueTypeSerializer = paramTypeSerializer;
    this._dynamicSerializers = PropertySerializerMap.emptyMap();
    this._elementSerializer = paramJsonSerializer;
  }
  
  public ObjectArraySerializer(ObjectArraySerializer paramObjectArraySerializer, BeanProperty paramBeanProperty, TypeSerializer paramTypeSerializer, JsonSerializer<?> paramJsonSerializer)
  {
    super(paramObjectArraySerializer, paramBeanProperty);
    this._elementType = paramObjectArraySerializer._elementType;
    this._valueTypeSerializer = paramTypeSerializer;
    this._staticTyping = paramObjectArraySerializer._staticTyping;
    this._dynamicSerializers = paramObjectArraySerializer._dynamicSerializers;
    this._elementSerializer = paramJsonSerializer;
  }
  
  public ContainerSerializer<?> _withValueTypeSerializer(TypeSerializer paramTypeSerializer)
  {
    return new ObjectArraySerializer(this._elementType, this._staticTyping, paramTypeSerializer, this._elementSerializer);
  }
  
  public JsonSerializer<?> createContextual(SerializerProvider paramSerializerProvider, BeanProperty paramBeanProperty)
  {
    TypeSerializer localTypeSerializer = this._valueTypeSerializer;
    if (localTypeSerializer != null) {
      localTypeSerializer = localTypeSerializer.forProperty(paramBeanProperty);
    }
    for (;;)
    {
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (paramBeanProperty != null)
      {
        AnnotatedMember localAnnotatedMember = paramBeanProperty.getMember();
        localObject1 = localObject2;
        if (localAnnotatedMember != null)
        {
          Object localObject3 = paramSerializerProvider.getAnnotationIntrospector().findContentSerializer(localAnnotatedMember);
          localObject1 = localObject2;
          if (localObject3 != null) {
            localObject1 = paramSerializerProvider.serializerInstance(localAnnotatedMember, localObject3);
          }
        }
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = this._elementSerializer;
      }
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (this._elementType != null) {
          if (!this._staticTyping)
          {
            localObject1 = localObject2;
            if (!hasContentTypeAnnotation(paramSerializerProvider, paramBeanProperty)) {}
          }
          else
          {
            localObject1 = paramSerializerProvider.findValueSerializer(this._elementType, paramBeanProperty);
          }
        }
      }
      for (;;)
      {
        return withResolved(paramBeanProperty, localTypeSerializer, (JsonSerializer)localObject1);
        localObject1 = localObject2;
        if ((localObject2 instanceof ContextualSerializer)) {
          localObject1 = ((ContextualSerializer)this._elementSerializer).createContextual(paramSerializerProvider, paramBeanProperty);
        }
      }
    }
  }
  
  public ObjectArraySerializer withResolved(BeanProperty paramBeanProperty, TypeSerializer paramTypeSerializer, JsonSerializer<?> paramJsonSerializer)
  {
    if ((this._property == paramBeanProperty) && (paramJsonSerializer == this._elementSerializer) && (this._valueTypeSerializer == paramTypeSerializer)) {
      return this;
    }
    return new ObjectArraySerializer(this, paramBeanProperty, paramTypeSerializer, paramJsonSerializer);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/ser/std/ObjectArraySerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */