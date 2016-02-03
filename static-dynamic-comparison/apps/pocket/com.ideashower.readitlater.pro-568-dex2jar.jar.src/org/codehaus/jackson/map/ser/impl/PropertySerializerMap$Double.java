package org.codehaus.jackson.map.ser.impl;

import org.codehaus.jackson.map.JsonSerializer;

final class PropertySerializerMap$Double
  extends PropertySerializerMap
{
  private final JsonSerializer _serializer1;
  private final JsonSerializer _serializer2;
  private final Class _type1;
  private final Class _type2;
  
  public PropertySerializerMap$Double(Class paramClass1, JsonSerializer paramJsonSerializer1, Class paramClass2, JsonSerializer paramJsonSerializer2)
  {
    this._type1 = paramClass1;
    this._serializer1 = paramJsonSerializer1;
    this._type2 = paramClass2;
    this._serializer2 = paramJsonSerializer2;
  }
  
  public PropertySerializerMap newWith(Class paramClass, JsonSerializer paramJsonSerializer)
  {
    return new PropertySerializerMap.Multi(new PropertySerializerMap.TypeAndSerializer[] { new PropertySerializerMap.TypeAndSerializer(this._type1, this._serializer1), new PropertySerializerMap.TypeAndSerializer(this._type2, this._serializer2) });
  }
  
  public JsonSerializer serializerFor(Class paramClass)
  {
    if (paramClass == this._type1) {
      return this._serializer1;
    }
    if (paramClass == this._type2) {
      return this._serializer2;
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ser/impl/PropertySerializerMap$Double.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */