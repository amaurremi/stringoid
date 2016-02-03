package org.codehaus.jackson.map.deser.impl;

import org.codehaus.jackson.map.deser.SettableAnyProperty;

final class PropertyValue$Any
  extends PropertyValue
{
  final SettableAnyProperty _property;
  final String _propertyName;
  
  public PropertyValue$Any(PropertyValue paramPropertyValue, Object paramObject, SettableAnyProperty paramSettableAnyProperty, String paramString)
  {
    super(paramPropertyValue, paramObject);
    this._property = paramSettableAnyProperty;
    this._propertyName = paramString;
  }
  
  public void assign(Object paramObject)
  {
    this._property.set(paramObject, this._propertyName, this.value);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/impl/PropertyValue$Any.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */