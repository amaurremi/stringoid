package org.codehaus.jackson.map.deser.std;

import java.util.Date;
import org.codehaus.jackson.map.DeserializationContext;

final class StdKeyDeserializer$DateKD
  extends StdKeyDeserializer
{
  protected StdKeyDeserializer$DateKD()
  {
    super(Date.class);
  }
  
  public Date _parse(String paramString, DeserializationContext paramDeserializationContext)
  {
    return paramDeserializationContext.parseDate(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/std/StdKeyDeserializer$DateKD.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */