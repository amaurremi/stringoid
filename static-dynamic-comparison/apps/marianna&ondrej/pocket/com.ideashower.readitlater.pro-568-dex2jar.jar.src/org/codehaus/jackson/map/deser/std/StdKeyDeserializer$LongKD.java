package org.codehaus.jackson.map.deser.std;

import org.codehaus.jackson.map.DeserializationContext;

final class StdKeyDeserializer$LongKD
  extends StdKeyDeserializer
{
  StdKeyDeserializer$LongKD()
  {
    super(Long.class);
  }
  
  public Long _parse(String paramString, DeserializationContext paramDeserializationContext)
  {
    return Long.valueOf(_parseLong(paramString));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/std/StdKeyDeserializer$LongKD.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */