package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.DeserializationContext;
import java.util.Currency;

public class JdkDeserializers$CurrencyDeserializer
  extends FromStringDeserializer<Currency>
{
  public JdkDeserializers$CurrencyDeserializer()
  {
    super(Currency.class);
  }
  
  protected Currency _deserialize(String paramString, DeserializationContext paramDeserializationContext)
  {
    return Currency.getInstance(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/std/JdkDeserializers$CurrencyDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */