package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import java.io.IOException;
import java.util.Locale;

@JacksonStdImpl
final class StdKeyDeserializer$LocaleKD
  extends StdKeyDeserializer
{
  protected JdkDeserializers.LocaleDeserializer _localeDeserializer = new JdkDeserializers.LocaleDeserializer();
  
  StdKeyDeserializer$LocaleKD()
  {
    super(Locale.class);
  }
  
  protected Locale _parse(String paramString, DeserializationContext paramDeserializationContext)
  {
    try
    {
      Locale localLocale = this._localeDeserializer._deserialize(paramString, paramDeserializationContext);
      return localLocale;
    }
    catch (IOException localIOException)
    {
      throw paramDeserializationContext.weirdKeyException(this._keyClass, paramString, "unable to parse key as locale");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/std/StdKeyDeserializer$LocaleKD.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */