package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;

public final class DefaultSerializerProvider$Impl
  extends DefaultSerializerProvider
{
  public DefaultSerializerProvider$Impl() {}
  
  protected DefaultSerializerProvider$Impl(SerializerProvider paramSerializerProvider, SerializationConfig paramSerializationConfig, SerializerFactory paramSerializerFactory)
  {
    super(paramSerializerProvider, paramSerializationConfig, paramSerializerFactory);
  }
  
  public Impl createInstance(SerializationConfig paramSerializationConfig, SerializerFactory paramSerializerFactory)
  {
    return new Impl(this, paramSerializationConfig, paramSerializerFactory);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/ser/DefaultSerializerProvider$Impl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */