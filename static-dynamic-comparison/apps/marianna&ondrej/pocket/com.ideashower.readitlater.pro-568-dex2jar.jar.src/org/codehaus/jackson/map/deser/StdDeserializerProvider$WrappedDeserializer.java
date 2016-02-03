package org.codehaus.jackson.map.deser;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.TypeDeserializer;

public final class StdDeserializerProvider$WrappedDeserializer
  extends JsonDeserializer
{
  final JsonDeserializer _deserializer;
  final TypeDeserializer _typeDeserializer;
  
  public StdDeserializerProvider$WrappedDeserializer(TypeDeserializer paramTypeDeserializer, JsonDeserializer paramJsonDeserializer)
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/StdDeserializerProvider$WrappedDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */