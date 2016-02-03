package org.codehaus.jackson.map.deser.std;

import java.util.Currency;
import org.codehaus.jackson.map.DeserializationContext;

public class FromStringDeserializer$CurrencyDeserializer
  extends FromStringDeserializer
{
  public FromStringDeserializer$CurrencyDeserializer()
  {
    super(Currency.class);
  }
  
  protected Currency _deserialize(String paramString, DeserializationContext paramDeserializationContext)
  {
    return Currency.getInstance(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/std/FromStringDeserializer$CurrencyDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */