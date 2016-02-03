package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.InjectableValues;

public final class DefaultDeserializationContext$Impl
  extends DefaultDeserializationContext
{
  protected DefaultDeserializationContext$Impl(Impl paramImpl, DeserializationConfig paramDeserializationConfig, JsonParser paramJsonParser, InjectableValues paramInjectableValues)
  {
    super(paramImpl, paramDeserializationConfig, paramJsonParser, paramInjectableValues);
  }
  
  public DefaultDeserializationContext$Impl(DeserializerFactory paramDeserializerFactory)
  {
    super(paramDeserializerFactory, null);
  }
  
  public DefaultDeserializationContext createInstance(DeserializationConfig paramDeserializationConfig, JsonParser paramJsonParser, InjectableValues paramInjectableValues)
  {
    return new Impl(this, paramDeserializationConfig, paramJsonParser, paramInjectableValues);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/DefaultDeserializationContext$Impl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */