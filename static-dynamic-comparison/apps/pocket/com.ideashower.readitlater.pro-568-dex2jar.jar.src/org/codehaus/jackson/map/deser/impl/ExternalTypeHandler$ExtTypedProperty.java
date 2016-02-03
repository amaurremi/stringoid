package org.codehaus.jackson.map.deser.impl;

import org.codehaus.jackson.map.deser.SettableBeanProperty;

final class ExternalTypeHandler$ExtTypedProperty
{
  private final SettableBeanProperty _property;
  private final String _typePropertyName;
  
  public ExternalTypeHandler$ExtTypedProperty(SettableBeanProperty paramSettableBeanProperty, String paramString)
  {
    this._property = paramSettableBeanProperty;
    this._typePropertyName = paramString;
  }
  
  public SettableBeanProperty getProperty()
  {
    return this._property;
  }
  
  public String getTypePropertyName()
  {
    return this._typePropertyName;
  }
  
  public boolean hasTypePropertyName(String paramString)
  {
    return paramString.equals(this._typePropertyName);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/impl/ExternalTypeHandler$ExtTypedProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */