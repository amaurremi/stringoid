package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;

final class ExternalTypeHandler$ExtTypedProperty
{
  private final SettableBeanProperty _property;
  private final TypeDeserializer _typeDeserializer;
  private final String _typePropertyName;
  
  public ExternalTypeHandler$ExtTypedProperty(SettableBeanProperty paramSettableBeanProperty, TypeDeserializer paramTypeDeserializer)
  {
    this._property = paramSettableBeanProperty;
    this._typeDeserializer = paramTypeDeserializer;
    this._typePropertyName = paramTypeDeserializer.getPropertyName();
  }
  
  public String getDefaultTypeId()
  {
    Class localClass = this._typeDeserializer.getDefaultImpl();
    if (localClass == null) {
      return null;
    }
    return this._typeDeserializer.getTypeIdResolver().idFromValueAndType(null, localClass);
  }
  
  public SettableBeanProperty getProperty()
  {
    return this._property;
  }
  
  public String getTypePropertyName()
  {
    return this._typePropertyName;
  }
  
  public boolean hasDefaultType()
  {
    return this._typeDeserializer.getDefaultImpl() != null;
  }
  
  public boolean hasTypePropertyName(String paramString)
  {
    return paramString.equals(this._typePropertyName);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/impl/ExternalTypeHandler$ExtTypedProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */