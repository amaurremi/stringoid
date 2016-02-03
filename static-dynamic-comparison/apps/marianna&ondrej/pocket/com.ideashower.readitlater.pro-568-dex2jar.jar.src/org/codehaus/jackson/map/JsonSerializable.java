package org.codehaus.jackson.map;

import org.codehaus.jackson.JsonGenerator;

@Deprecated
public abstract interface JsonSerializable
{
  public abstract void serialize(JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/JsonSerializable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */