package org.codehaus.jackson.map.ser.impl;

import org.codehaus.jackson.map.JsonSerializer;

final class PropertySerializerMap$Empty
  extends PropertySerializerMap
{
  protected static final Empty instance = new Empty();
  
  public PropertySerializerMap newWith(Class paramClass, JsonSerializer paramJsonSerializer)
  {
    return new PropertySerializerMap.Single(paramClass, paramJsonSerializer);
  }
  
  public JsonSerializer serializerFor(Class paramClass)
  {
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ser/impl/PropertySerializerMap$Empty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */