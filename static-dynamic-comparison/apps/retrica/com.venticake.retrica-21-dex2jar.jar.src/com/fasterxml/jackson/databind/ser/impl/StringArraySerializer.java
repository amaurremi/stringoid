package com.fasterxml.jackson.databind.ser.impl;

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
import com.fasterxml.jackson.databind.ser.std.ArraySerializerBase;
import com.fasterxml.jackson.databind.type.TypeFactory;

@JacksonStdImpl
public class StringArraySerializer
  extends ArraySerializerBase<String[]>
  implements ContextualSerializer
{
  private static final JavaType VALUE_TYPE = TypeFactory.defaultInstance().uncheckedSimpleType(String.class);
  public static final StringArraySerializer instance = new StringArraySerializer();
  protected final JsonSerializer<Object> _elementSerializer;
  
  protected StringArraySerializer()
  {
    super(String[].class, null);
    this._elementSerializer = null;
  }
  
  public StringArraySerializer(StringArraySerializer paramStringArraySerializer, BeanProperty paramBeanProperty, JsonSerializer<?> paramJsonSerializer)
  {
    super(paramStringArraySerializer, paramBeanProperty);
    this._elementSerializer = paramJsonSerializer;
  }
  
  public ContainerSerializer<?> _withValueTypeSerializer(TypeSerializer paramTypeSerializer)
  {
    return this;
  }
  
  public JsonSerializer<?> createContextual(SerializerProvider paramSerializerProvider, BeanProperty paramBeanProperty)
  {
    Object localObject2;
    if (paramBeanProperty != null)
    {
      localObject1 = paramBeanProperty.getMember();
      if (localObject1 != null)
      {
        localObject2 = paramSerializerProvider.getAnnotationIntrospector().findContentSerializer((Annotated)localObject1);
        if (localObject2 == null) {}
      }
    }
    for (Object localObject1 = paramSerializerProvider.serializerInstance((Annotated)localObject1, localObject2);; localObject1 = null)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = this._elementSerializer;
      }
      if (localObject2 == null) {
        localObject1 = paramSerializerProvider.findValueSerializer(String.class, paramBeanProperty);
      }
      for (;;)
      {
        paramSerializerProvider = (SerializerProvider)localObject1;
        if (isDefaultSerializer((JsonSerializer)localObject1)) {
          paramSerializerProvider = null;
        }
        if (paramSerializerProvider != this._elementSerializer) {
          break;
        }
        return this;
        localObject1 = localObject2;
        if ((localObject2 instanceof ContextualSerializer)) {
          localObject1 = ((ContextualSerializer)localObject2).createContextual(paramSerializerProvider, paramBeanProperty);
        }
      }
      return new StringArraySerializer(this, paramBeanProperty, paramSerializerProvider);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/ser/impl/StringArraySerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */