package com.flurry.org.codehaus.jackson.map.deser.impl;

import com.flurry.org.codehaus.jackson.JsonParser;
import com.flurry.org.codehaus.jackson.JsonProcessingException;
import com.flurry.org.codehaus.jackson.map.DeserializationContext;
import com.flurry.org.codehaus.jackson.map.deser.SettableBeanProperty;
import com.flurry.org.codehaus.jackson.util.TokenBuffer;
import java.io.IOException;
import java.util.ArrayList;

public class UnwrappedPropertyHandler
{
  protected final ArrayList<SettableBeanProperty> _properties = new ArrayList();
  
  public void addProperty(SettableBeanProperty paramSettableBeanProperty)
  {
    this._properties.add(paramSettableBeanProperty);
  }
  
  public Object processUnwrapped(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject, TokenBuffer paramTokenBuffer)
    throws IOException, JsonProcessingException
  {
    int i = 0;
    int j = this._properties.size();
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/deser/impl/UnwrappedPropertyHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */