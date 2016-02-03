package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;

@JacksonStdImpl
public class RawSerializer<T>
  extends StdSerializer<T>
{
  public RawSerializer(Class<?> paramClass)
  {
    super(paramClass, false);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/ser/std/RawSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */