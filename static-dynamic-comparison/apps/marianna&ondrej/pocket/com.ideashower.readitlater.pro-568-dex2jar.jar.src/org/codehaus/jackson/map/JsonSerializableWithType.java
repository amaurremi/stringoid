package org.codehaus.jackson.map;

import org.codehaus.jackson.JsonGenerator;

public abstract interface JsonSerializableWithType
  extends JsonSerializable
{
  public abstract void serializeWithType(JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider, TypeSerializer paramTypeSerializer);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/JsonSerializableWithType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */