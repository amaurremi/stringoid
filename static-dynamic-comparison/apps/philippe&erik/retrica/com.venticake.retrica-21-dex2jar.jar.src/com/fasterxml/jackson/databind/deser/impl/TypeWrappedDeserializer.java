package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;

public final class TypeWrappedDeserializer
  extends JsonDeserializer<Object>
{
  final JsonDeserializer<Object> _deserializer;
  final TypeDeserializer _typeDeserializer;
  
  public TypeWrappedDeserializer(TypeDeserializer paramTypeDeserializer, JsonDeserializer<Object> paramJsonDeserializer)
  {
    this._typeDeserializer = paramTypeDeserializer;
    this._deserializer = paramJsonDeserializer;
  }
  
  public Object deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    return this._deserializer.deserializeWithType(paramJsonParser, paramDeserializationContext, this._typeDeserializer);
  }
  
  public Object deserializeWithType(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TypeDeserializer paramTypeDeserializer)
  {
    throw new IllegalStateException("Type-wrapped deserializer's deserializeWithType should never get called");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/impl/TypeWrappedDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */