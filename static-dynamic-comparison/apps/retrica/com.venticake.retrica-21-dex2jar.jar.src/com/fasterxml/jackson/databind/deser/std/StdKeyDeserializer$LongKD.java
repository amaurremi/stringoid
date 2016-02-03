package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;

@JacksonStdImpl
final class StdKeyDeserializer$LongKD
  extends StdKeyDeserializer
{
  StdKeyDeserializer$LongKD()
  {
    super(Long.class);
  }
  
  public Long _parse(String paramString, DeserializationContext paramDeserializationContext)
  {
    return Long.valueOf(_parseLong(paramString));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/std/StdKeyDeserializer$LongKD.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */