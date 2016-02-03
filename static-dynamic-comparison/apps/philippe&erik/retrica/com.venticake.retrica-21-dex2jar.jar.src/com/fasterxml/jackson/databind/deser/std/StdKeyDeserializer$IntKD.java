package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;

@JacksonStdImpl
final class StdKeyDeserializer$IntKD
  extends StdKeyDeserializer
{
  StdKeyDeserializer$IntKD()
  {
    super(Integer.class);
  }
  
  public Integer _parse(String paramString, DeserializationContext paramDeserializationContext)
  {
    return Integer.valueOf(_parseInt(paramString));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/std/StdKeyDeserializer$IntKD.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */