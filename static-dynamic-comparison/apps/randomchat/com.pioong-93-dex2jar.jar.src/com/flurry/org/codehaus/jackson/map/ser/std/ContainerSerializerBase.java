package com.flurry.org.codehaus.jackson.map.ser.std;

import com.flurry.org.codehaus.jackson.map.TypeSerializer;

public abstract class ContainerSerializerBase<T>
  extends SerializerBase<T>
{
  protected ContainerSerializerBase(Class<T> paramClass)
  {
    super(paramClass);
  }
  
  protected ContainerSerializerBase(Class<?> paramClass, boolean paramBoolean)
  {
    super(paramClass, paramBoolean);
  }
  
  public abstract ContainerSerializerBase<?> _withValueTypeSerializer(TypeSerializer paramTypeSerializer);
  
  public ContainerSerializerBase<?> withValueTypeSerializer(TypeSerializer paramTypeSerializer)
  {
    if (paramTypeSerializer == null) {
      return this;
    }
    return _withValueTypeSerializer(paramTypeSerializer);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/ser/std/ContainerSerializerBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */