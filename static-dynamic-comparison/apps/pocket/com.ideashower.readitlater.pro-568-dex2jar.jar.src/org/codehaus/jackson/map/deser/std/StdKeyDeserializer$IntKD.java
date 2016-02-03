package org.codehaus.jackson.map.deser.std;

import org.codehaus.jackson.map.DeserializationContext;

final class StdKeyDeserializer$IntKD
  extends StdKeyDeserializer
{
  StdKeyDeserializer$IntKD()
  {
    super(Integer.class);
  }
  
  public Integer _parse(String paramString, DeserializationContext paramDeserializationContext)
  {
    return Integer.valueOf(_parseInt(paramString));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/std/StdKeyDeserializer$IntKD.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */