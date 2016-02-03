package org.codehaus.jackson.map.deser.std;

import org.codehaus.jackson.map.DeserializationContext;

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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/std/StdKeyDeserializer$CharKD.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */