package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;

@JacksonStdImpl
final class StdKeyDeserializer$CharKD
  extends StdKeyDeserializer
{
  StdKeyDeserializer$CharKD()
  {
    super(Character.class);
  }
  
  public Character _parse(String paramString, DeserializationContext paramDeserializationContext)
  {
    if (paramString.length() == 1) {
      return Character.valueOf(paramString.charAt(0));
    }
    throw paramDeserializationContext.weirdKeyException(this._keyClass, paramString, "can only convert 1-character Strings");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/std/StdKeyDeserializer$CharKD.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */