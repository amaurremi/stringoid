package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.util.ArrayList;
import java.util.HashMap;

public class ExternalTypeHandler$Builder
{
  private final HashMap<String, Integer> _nameToPropertyIndex = new HashMap();
  private final ArrayList<ExternalTypeHandler.ExtTypedProperty> _properties = new ArrayList();
  
  public void addExternal(SettableBeanProperty paramSettableBeanProperty, TypeDeserializer paramTypeDeserializer)
  {
    Integer localInteger = Integer.valueOf(this._properties.size());
    this._properties.add(new ExternalTypeHandler.ExtTypedProperty(paramSettableBeanProperty, paramTypeDeserializer));
    this._nameToPropertyIndex.put(paramSettableBeanProperty.getName(), localInteger);
    this._nameToPropertyIndex.put(paramTypeDeserializer.getPropertyName(), localInteger);
  }
  
  public ExternalTypeHandler build()
  {
    return new ExternalTypeHandler((ExternalTypeHandler.ExtTypedProperty[])this._properties.toArray(new ExternalTypeHandler.ExtTypedProperty[this._properties.size()]), this._nameToPropertyIndex, null, null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/impl/ExternalTypeHandler$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */