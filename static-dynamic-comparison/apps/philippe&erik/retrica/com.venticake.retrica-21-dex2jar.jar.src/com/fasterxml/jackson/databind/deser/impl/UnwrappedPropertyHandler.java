package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.util.NameTransformer;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import java.util.ArrayList;
import java.util.Iterator;

public class UnwrappedPropertyHandler
{
  protected final ArrayList<SettableBeanProperty> _properties = new ArrayList();
  
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
  
  public void renameAll(NameTransformer paramNameTransformer)
  {
    Iterator localIterator = new ArrayList(this._properties).iterator();
    this._properties.clear();
    while (localIterator.hasNext())
    {
      Object localObject = (SettableBeanProperty)localIterator.next();
      SettableBeanProperty localSettableBeanProperty = ((SettableBeanProperty)localObject).withName(paramNameTransformer.transform(((SettableBeanProperty)localObject).getName()));
      JsonDeserializer localJsonDeserializer1 = localSettableBeanProperty.getValueDeserializer();
      localObject = localSettableBeanProperty;
      if (localJsonDeserializer1 != null)
      {
        JsonDeserializer localJsonDeserializer2 = localJsonDeserializer1.unwrappingDeserializer(paramNameTransformer);
        localObject = localSettableBeanProperty;
        if (localJsonDeserializer2 != localJsonDeserializer1) {
          localObject = localSettableBeanProperty.withValueDeserializer(localJsonDeserializer2);
        }
      }
      this._properties.add(localObject);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/impl/UnwrappedPropertyHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */