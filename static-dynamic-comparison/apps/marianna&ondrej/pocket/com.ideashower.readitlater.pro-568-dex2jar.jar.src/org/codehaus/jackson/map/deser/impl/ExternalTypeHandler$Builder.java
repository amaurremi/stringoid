package org.codehaus.jackson.map.deser.impl;

import java.util.ArrayList;
import java.util.HashMap;
import org.codehaus.jackson.map.deser.SettableBeanProperty;

public class ExternalTypeHandler$Builder
{
  private final HashMap _nameToPropertyIndex = new HashMap();
  private final ArrayList _properties = new ArrayList();
  
  public void addExternal(SettableBeanProperty paramSettableBeanProperty, String paramString)
  {
    Integer localInteger = Integer.valueOf(this._properties.size());
    this._properties.add(new ExternalTypeHandler.ExtTypedProperty(paramSettableBeanProperty, paramString));
    this._nameToPropertyIndex.put(paramSettableBeanProperty.getName(), localInteger);
    this._nameToPropertyIndex.put(paramString, localInteger);
  }
  
  public ExternalTypeHandler build()
  {
    return new ExternalTypeHandler((ExternalTypeHandler.ExtTypedProperty[])this._properties.toArray(new ExternalTypeHandler.ExtTypedProperty[this._properties.size()]), this._nameToPropertyIndex, null, null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/impl/ExternalTypeHandler$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */