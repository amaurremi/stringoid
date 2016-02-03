package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import java.util.Date;

@JacksonStdImpl
final class StdKeyDeserializer$DateKD
  extends StdKeyDeserializer
{
  protected StdKeyDeserializer$DateKD()
  {
    super(Date.class);
  }
  
  public Object _parse(String paramString, DeserializationContext paramDeserializationContext)
  {
    return paramDeserializationContext.parseDate(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/std/StdKeyDeserializer$DateKD.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */