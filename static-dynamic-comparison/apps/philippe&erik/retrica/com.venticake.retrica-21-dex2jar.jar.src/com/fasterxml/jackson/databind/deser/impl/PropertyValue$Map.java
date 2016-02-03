package com.fasterxml.jackson.databind.deser.impl;

import java.util.Map;

final class PropertyValue$Map
  extends PropertyValue
{
  final Object _key;
  
  public PropertyValue$Map(PropertyValue paramPropertyValue, Object paramObject1, Object paramObject2)
  {
    super(paramPropertyValue, paramObject1);
    this._key = paramObject2;
  }
  
  public void assign(Object paramObject)
  {
    ((Map)paramObject).put(this._key, this.value);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/impl/PropertyValue$Map.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */