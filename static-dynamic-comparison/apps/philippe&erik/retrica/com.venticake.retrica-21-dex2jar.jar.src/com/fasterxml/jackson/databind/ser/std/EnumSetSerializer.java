package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.util.EnumSet;

public class EnumSetSerializer
  extends AsArraySerializerBase<EnumSet<? extends Enum<?>>>
{
  public EnumSetSerializer(JavaType paramJavaType, BeanProperty paramBeanProperty)
  {
    super(EnumSet.class, paramJavaType, true, null, paramBeanProperty, null);
  }
  
  public EnumSetSerializer(EnumSetSerializer paramEnumSetSerializer, BeanProperty paramBeanProperty, TypeSerializer paramTypeSerializer, JsonSerializer<?> paramJsonSerializer)
  {
    super(paramEnumSetSerializer, paramBeanProperty, paramTypeSerializer, paramJsonSerializer);
  }
  
  public EnumSetSerializer _withValueTypeSerializer(TypeSerializer paramTypeSerializer)
  {
    return this;
  }
  
  public EnumSetSerializer withResolved(BeanProperty paramBeanProperty, TypeSerializer paramTypeSerializer, JsonSerializer<?> paramJsonSerializer)
  {
    return new EnumSetSerializer(this, paramBeanProperty, paramTypeSerializer, paramJsonSerializer);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/ser/std/EnumSetSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */