package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap;

public abstract class AsArraySerializerBase<T>
  extends ContainerSerializer<T>
  implements ContextualSerializer
{
  protected PropertySerializerMap _dynamicSerializers;
  protected final JsonSerializer<Object> _elementSerializer;
  protected final JavaType _elementType;
  protected final BeanProperty _property;
  protected final boolean _staticTyping;
  protected final TypeSerializer _valueTypeSerializer;
  
  protected AsArraySerializerBase(AsArraySerializerBase<?> paramAsArraySerializerBase, BeanProperty paramBeanProperty, TypeSerializer paramTypeSerializer, JsonSerializer<?> paramJsonSerializer)
  {
    super(paramAsArraySerializerBase);
    this._elementType = paramAsArraySerializerBase._elementType;
    this._staticTyping = paramAsArraySerializerBase._staticTyping;
    this._valueTypeSerializer = paramTypeSerializer;
    this._property = paramAsArraySerializerBase._property;
    this._elementSerializer = paramJsonSerializer;
    this._dynamicSerializers = paramAsArraySerializerBase._dynamicSerializers;
  }
  
  protected AsArraySerializerBase(Class<?> paramClass, JavaType paramJavaType, boolean paramBoolean, TypeSerializer paramTypeSerializer, BeanProperty paramBeanProperty, JsonSerializer<Object> paramJsonSerializer)
  {
    super(paramClass, false);
    this._elementType = paramJavaType;
    if (!paramBoolean)
    {
      paramBoolean = bool;
      if (paramJavaType != null)
      {
        paramBoolean = bool;
        if (!paramJavaType.isFinal()) {}
      }
    }
    else
    {
      paramBoolean = true;
    }
    this._staticTyping = paramBoolean;
    this._valueTypeSerializer = paramTypeSerializer;
    this._property = paramBeanProperty;
    this._elementSerializer = paramJsonSerializer;
    this._dynamicSerializers = PropertySerializerMap.emptyMap();
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
        if ((localObject1 == this._elementSerializer) && (paramBeanProperty == this._property))
        {
          paramSerializerProvider = this;
          if (this._valueTypeSerializer == localTypeSerializer) {}
        }
        else
        {
          paramSerializerProvider = withResolved(paramBeanProperty, localTypeSerializer, (JsonSerializer)localObject1);
        }
        return paramSerializerProvider;
        localObject1 = localObject2;
        if ((localObject2 instanceof ContextualSerializer)) {
          localObject1 = ((ContextualSerializer)localObject2).createContextual(paramSerializerProvider, paramBeanProperty);
        }
      }
    }
  }
  
  public abstract AsArraySerializerBase<T> withResolved(BeanProperty paramBeanProperty, TypeSerializer paramTypeSerializer, JsonSerializer<?> paramJsonSerializer);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/ser/std/AsArraySerializerBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */