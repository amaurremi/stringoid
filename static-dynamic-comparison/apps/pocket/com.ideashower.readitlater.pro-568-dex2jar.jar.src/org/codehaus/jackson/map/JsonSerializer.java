package org.codehaus.jackson.map;

import org.codehaus.jackson.JsonGenerator;

public abstract class JsonSerializer
{
  public Class handledType()
  {
    return null;
  }
  
  public boolean isUnwrappingSerializer()
  {
    return false;
  }
  
  public abstract void serialize(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider);
  
  public void serializeWithType(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider, TypeSerializer paramTypeSerializer)
  {
    serialize(paramObject, paramJsonGenerator, paramSerializerProvider);
  }
  
  public JsonSerializer unwrappingSerializer()
  {
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/JsonSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */