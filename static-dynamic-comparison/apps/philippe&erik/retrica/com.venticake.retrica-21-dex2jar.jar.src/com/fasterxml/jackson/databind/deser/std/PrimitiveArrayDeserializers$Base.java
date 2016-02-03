package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;

abstract class PrimitiveArrayDeserializers$Base<T>
  extends StdDeserializer<T>
{
  protected PrimitiveArrayDeserializers$Base(Class<T> paramClass)
  {
    super(paramClass);
  }
  
  public Object deserializeWithType(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TypeDeserializer paramTypeDeserializer)
  {
    return paramTypeDeserializer.deserializeTypedFromArray(paramJsonParser, paramDeserializationContext);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/std/PrimitiveArrayDeserializers$Base.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */