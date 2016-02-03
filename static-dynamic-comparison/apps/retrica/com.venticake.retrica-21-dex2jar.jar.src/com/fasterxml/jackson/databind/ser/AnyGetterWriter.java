package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.ser.std.MapSerializer;

public class AnyGetterWriter
{
  protected final AnnotatedMember _accessor;
  protected final BeanProperty _property;
  protected MapSerializer _serializer;
  
  public AnyGetterWriter(BeanProperty paramBeanProperty, AnnotatedMember paramAnnotatedMember, MapSerializer paramMapSerializer)
  {
    this._accessor = paramAnnotatedMember;
    this._property = paramBeanProperty;
    this._serializer = paramMapSerializer;
  }
  
  public void resolve(SerializerProvider paramSerializerProvider)
  {
    this._serializer = ((MapSerializer)this._serializer.createContextual(paramSerializerProvider, this._property));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/ser/AnyGetterWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */