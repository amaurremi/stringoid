package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;

@JacksonStdImpl
final class StdKeyDeserializer$ByteKD
  extends StdKeyDeserializer
{
  StdKeyDeserializer$ByteKD()
  {
    super(Byte.class);
  }
  
  public Byte _parse(String paramString, DeserializationContext paramDeserializationContext)
  {
    int i = _parseInt(paramString);
    if ((i < -128) || (i > 255)) {
      throw paramDeserializationContext.weirdKeyException(this._keyClass, paramString, "overflow, value can not be represented as 8-bit value");
    }
    return Byte.valueOf((byte)i);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/std/StdKeyDeserializer$ByteKD.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */