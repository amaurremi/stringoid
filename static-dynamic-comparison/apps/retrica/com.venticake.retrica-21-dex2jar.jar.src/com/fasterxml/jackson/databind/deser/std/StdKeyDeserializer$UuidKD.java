package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import java.util.UUID;

@JacksonStdImpl
final class StdKeyDeserializer$UuidKD
  extends StdKeyDeserializer
{
  protected StdKeyDeserializer$UuidKD()
  {
    super(UUID.class);
  }
  
  public Object _parse(String paramString, DeserializationContext paramDeserializationContext)
  {
    return UUID.fromString(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/std/StdKeyDeserializer$UuidKD.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */