package org.codehaus.jackson.map.ser.impl;

import org.codehaus.jackson.map.JsonSerializer;

final class PropertySerializerMap$Multi
  extends PropertySerializerMap
{
  private static final int MAX_ENTRIES = 8;
  private final PropertySerializerMap.TypeAndSerializer[] _entries;
  
  public PropertySerializerMap$Multi(PropertySerializerMap.TypeAndSerializer[] paramArrayOfTypeAndSerializer)
  {
    this._entries = paramArrayOfTypeAndSerializer;
  }
  
  public PropertySerializerMap newWith(Class paramClass, JsonSerializer paramJsonSerializer)
  {
    int i = this._entries.length;
    if (i == 8) {
      return this;
    }
    PropertySerializerMap.TypeAndSerializer[] arrayOfTypeAndSerializer = new PropertySerializerMap.TypeAndSerializer[i + 1];
    System.arraycopy(this._entries, 0, arrayOfTypeAndSerializer, 0, i);
    arrayOfTypeAndSerializer[i] = new PropertySerializerMap.TypeAndSerializer(paramClass, paramJsonSerializer);
    return new Multi(arrayOfTypeAndSerializer);
  }
  
  public JsonSerializer serializerFor(Class paramClass)
  {
    int i = 0;
    int j = this._entries.length;
    while (i < j)
    {
      PropertySerializerMap.TypeAndSerializer localTypeAndSerializer = this._entries[i];
      if (localTypeAndSerializer.type == paramClass) {
        return localTypeAndSerializer.serializer;
      }
      i += 1;
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ser/impl/PropertySerializerMap$Multi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */