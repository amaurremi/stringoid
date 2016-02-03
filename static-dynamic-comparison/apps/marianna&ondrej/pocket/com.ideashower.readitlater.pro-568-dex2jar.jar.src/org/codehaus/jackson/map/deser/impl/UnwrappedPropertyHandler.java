package org.codehaus.jackson.map.deser.impl;

import java.util.ArrayList;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.deser.SettableBeanProperty;
import org.codehaus.jackson.util.TokenBuffer;

public class UnwrappedPropertyHandler
{
  protected final ArrayList _properties = new ArrayList();
  
  public void addProperty(SettableBeanProperty paramSettableBeanProperty)
  {
    this._properties.add(paramSettableBeanProperty);
  }
  
  public Object processUnwrapped(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject, TokenBuffer paramTokenBuffer)
  {
    int j = this._properties.size();
    int i = 0;
    while (i < j)
    {
      paramJsonParser = (SettableBeanProperty)this._properties.get(i);
      JsonParser localJsonParser = paramTokenBuffer.asParser();
      localJsonParser.nextToken();
      paramJsonParser.deserializeAndSet(localJsonParser, paramDeserializationContext, paramObject);
      i += 1;
    }
    return paramObject;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/impl/UnwrappedPropertyHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */