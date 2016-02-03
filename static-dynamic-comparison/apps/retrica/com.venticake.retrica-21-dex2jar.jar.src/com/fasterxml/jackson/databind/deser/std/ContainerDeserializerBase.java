package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.JsonDeserializer;

public abstract class ContainerDeserializerBase<T>
  extends StdDeserializer<T>
{
  protected ContainerDeserializerBase(Class<?> paramClass)
  {
    super(paramClass);
  }
  
  public abstract JsonDeserializer<Object> getContentDeserializer();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/std/ContainerDeserializerBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */