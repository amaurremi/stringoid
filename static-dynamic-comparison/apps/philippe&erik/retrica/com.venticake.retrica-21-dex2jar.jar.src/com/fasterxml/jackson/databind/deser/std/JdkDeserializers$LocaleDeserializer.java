package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.DeserializationContext;
import java.util.Locale;

public class JdkDeserializers$LocaleDeserializer
  extends FromStringDeserializer<Locale>
{
  public JdkDeserializers$LocaleDeserializer()
  {
    super(Locale.class);
  }
  
  protected Locale _deserialize(String paramString, DeserializationContext paramDeserializationContext)
  {
    int i = paramString.indexOf('_');
    if (i < 0) {
      return new Locale(paramString);
    }
    paramDeserializationContext = paramString.substring(0, i);
    paramString = paramString.substring(i + 1);
    i = paramString.indexOf('_');
    if (i < 0) {
      return new Locale(paramDeserializationContext, paramString);
    }
    return new Locale(paramDeserializationContext, paramString.substring(0, i), paramString.substring(i + 1));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/std/JdkDeserializers$LocaleDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */