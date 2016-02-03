package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.databind.util.NameTransformer;

public abstract class JsonSerializer<T>
{
  public Class<T> handledType()
  {
    return null;
  }
  
  public boolean isUnwrappingSerializer()
  {
    return false;
  }
  
  public JsonSerializer<T> unwrappingSerializer(NameTransformer paramNameTransformer)
  {
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/JsonSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */