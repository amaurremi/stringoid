package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;

@JacksonStdImpl
final class StdKeyDeserializer$FloatKD
  extends StdKeyDeserializer
{
  StdKeyDeserializer$FloatKD()
  {
    super(Float.class);
  }
  
  public Float _parse(String paramString, DeserializationContext paramDeserializationContext)
  {
    return Float.valueOf((float)_parseDouble(paramString));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/std/StdKeyDeserializer$FloatKD.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */