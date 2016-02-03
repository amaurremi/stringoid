package com.fasterxml.jackson.core;

public class JsonParseException
  extends JsonProcessingException
{
  public JsonParseException(String paramString, JsonLocation paramJsonLocation)
  {
    super(paramString, paramJsonLocation);
  }
  
  public JsonParseException(String paramString, JsonLocation paramJsonLocation, Throwable paramThrowable)
  {
    super(paramString, paramJsonLocation, paramThrowable);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/core/JsonParseException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */