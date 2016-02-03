package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;

@JacksonStdImpl
final class StdKeyDeserializer$StringKD
  extends StdKeyDeserializer
{
  private static final StringKD sObject = new StringKD(Object.class);
  private static final StringKD sString = new StringKD(String.class);
  
  private StdKeyDeserializer$StringKD(Class<?> paramClass)
  {
    super(paramClass);
  }
  
  public static StringKD forType(Class<?> paramClass)
  {
    if (paramClass == String.class) {
      return sString;
    }
    if (paramClass == Object.class) {
      return sObject;
    }
    return new StringKD(paramClass);
  }
  
  public String _parse(String paramString, DeserializationContext paramDeserializationContext)
  {
    return paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/std/StdKeyDeserializer$StringKD.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */