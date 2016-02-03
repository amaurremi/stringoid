package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

public abstract class StdArraySerializers$TypedPrimitiveArraySerializer<T>
  extends ArraySerializerBase<T>
{
  protected final TypeSerializer _valueTypeSerializer;
  
  protected StdArraySerializers$TypedPrimitiveArraySerializer(TypedPrimitiveArraySerializer<T> paramTypedPrimitiveArraySerializer, BeanProperty paramBeanProperty, TypeSerializer paramTypeSerializer)
  {
    super(paramTypedPrimitiveArraySerializer, paramBeanProperty);
    this._valueTypeSerializer = paramTypeSerializer;
  }
  
  protected StdArraySerializers$TypedPrimitiveArraySerializer(Class<T> paramClass)
  {
    super(paramClass);
    this._valueTypeSerializer = null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/ser/std/StdArraySerializers$TypedPrimitiveArraySerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */