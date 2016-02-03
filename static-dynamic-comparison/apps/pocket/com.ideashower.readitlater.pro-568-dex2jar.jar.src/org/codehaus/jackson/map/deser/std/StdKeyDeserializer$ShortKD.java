package org.codehaus.jackson.map.deser.std;

import org.codehaus.jackson.map.DeserializationContext;

final class StdKeyDeserializer$ShortKD
  extends StdKeyDeserializer
{
  StdKeyDeserializer$ShortKD()
  {
    super(Integer.class);
  }
  
  public Short _parse(String paramString, DeserializationContext paramDeserializationContext)
  {
    int i = _parseInt(paramString);
    if ((i < 32768) || (i > 32767)) {
      throw paramDeserializationContext.weirdKeyException(this._keyClass, paramString, "overflow, value can not be represented as 16-bit value");
    }
    return Short.valueOf((short)i);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/std/StdKeyDeserializer$ShortKD.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */