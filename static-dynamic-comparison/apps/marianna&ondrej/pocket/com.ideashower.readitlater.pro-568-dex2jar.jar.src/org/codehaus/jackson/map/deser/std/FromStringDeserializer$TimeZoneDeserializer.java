package org.codehaus.jackson.map.deser.std;

import java.util.TimeZone;
import org.codehaus.jackson.map.DeserializationContext;

public class FromStringDeserializer$TimeZoneDeserializer
  extends FromStringDeserializer
{
  public FromStringDeserializer$TimeZoneDeserializer()
  {
    super(TimeZone.class);
  }
  
  protected TimeZone _deserialize(String paramString, DeserializationContext paramDeserializationContext)
  {
    return TimeZone.getTimeZone(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/std/FromStringDeserializer$TimeZoneDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */