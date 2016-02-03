package org.codehaus.jackson.map.deser.std;

import java.util.Calendar;
import org.codehaus.jackson.map.DeserializationContext;

final class StdKeyDeserializer$CalendarKD
  extends StdKeyDeserializer
{
  protected StdKeyDeserializer$CalendarKD()
  {
    super(Calendar.class);
  }
  
  public Calendar _parse(String paramString, DeserializationContext paramDeserializationContext)
  {
    paramString = paramDeserializationContext.parseDate(paramString);
    if (paramString == null) {
      return null;
    }
    return paramDeserializationContext.constructCalendar(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/std/StdKeyDeserializer$CalendarKD.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */