package org.codehaus.jackson.map.deser.std;

import org.codehaus.jackson.map.DeserializationContext;

final class StdKeyDeserializer$DoubleKD
  extends StdKeyDeserializer
{
  StdKeyDeserializer$DoubleKD()
  {
    super(Double.class);
  }
  
  public Double _parse(String paramString, DeserializationContext paramDeserializationContext)
  {
    return Double.valueOf(_parseDouble(paramString));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/std/StdKeyDeserializer$DoubleKD.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */