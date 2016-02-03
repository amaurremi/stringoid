package org.codehaus.jackson.map.deser.std;

import org.codehaus.jackson.map.DeserializationContext;

final class StdKeyDeserializer$BoolKD
  extends StdKeyDeserializer
{
  StdKeyDeserializer$BoolKD()
  {
    super(Boolean.class);
  }
  
  public Boolean _parse(String paramString, DeserializationContext paramDeserializationContext)
  {
    if ("true".equals(paramString)) {
      return Boolean.TRUE;
    }
    if ("false".equals(paramString)) {
      return Boolean.FALSE;
    }
    throw paramDeserializationContext.weirdKeyException(this._keyClass, paramString, "value not 'true' or 'false'");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/std/StdKeyDeserializer$BoolKD.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */