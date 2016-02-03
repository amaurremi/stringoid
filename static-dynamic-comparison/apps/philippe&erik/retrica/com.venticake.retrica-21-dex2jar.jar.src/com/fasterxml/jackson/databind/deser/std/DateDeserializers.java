package com.fasterxml.jackson.databind.deser.std;

import java.util.GregorianCalendar;

public class DateDeserializers
{
  public static StdDeserializer<?>[] all()
  {
    return new StdDeserializer[] { new DateDeserializers.CalendarDeserializer(), new DateDeserializers.DateDeserializer(), new DateDeserializers.CalendarDeserializer(GregorianCalendar.class), new DateDeserializers.SqlDateDeserializer(), new DateDeserializers.TimestampDeserializer(), new DateDeserializers.TimeZoneDeserializer() };
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/std/DateDeserializers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */