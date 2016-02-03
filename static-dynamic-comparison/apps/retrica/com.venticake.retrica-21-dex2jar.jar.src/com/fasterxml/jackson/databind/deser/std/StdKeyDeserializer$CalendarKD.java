package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import java.util.Calendar;

@JacksonStdImpl
final class StdKeyDeserializer$CalendarKD
  extends StdKeyDeserializer
{
  protected StdKeyDeserializer$CalendarKD()
  {
    super(Calendar.class);
  }
  
  public Object _parse(String paramString, DeserializationContext paramDeserializationContext)
  {
    paramString = paramDeserializationContext.parseDate(paramString);
    if (paramString == null) {
      return null;
    }
    return paramDeserializationContext.constructCalendar(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/std/StdKeyDeserializer$CalendarKD.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */