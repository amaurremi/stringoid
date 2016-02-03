package org.codehaus.jackson.map.ser.impl;

import org.codehaus.jackson.map.JsonSerializer;

final class PropertySerializerMap$Single
  extends PropertySerializerMap
{
  private final JsonSerializer _serializer;
  private final Class _type;
  
  public PropertySerializerMap$Single(Class paramClass, JsonSerializer paramJsonSerializer)
  {
    this._type = paramClass;
    this._serializer = paramJsonSerializer;
  }
  
  public PropertySerializerMap newWith(Class paramClass, JsonSerializer paramJsonSerializer)
  {
    return new PropertySerializerMap.Double(this._type, this._serializer, paramClass, paramJsonSerializer);
  }
  
  public JsonSerializer serializerFor(Class paramClass)
  {
    if (paramClass == this._type) {
      return this._serializer;
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ser/impl/PropertySerializerMap$Single.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */