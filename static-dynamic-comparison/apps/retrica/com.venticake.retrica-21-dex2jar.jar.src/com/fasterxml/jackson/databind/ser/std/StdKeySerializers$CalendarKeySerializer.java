package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.databind.JsonSerializer;
import java.util.Calendar;

public class StdKeySerializers$CalendarKeySerializer
  extends StdSerializer<Calendar>
{
  protected static final JsonSerializer<?> instance = new CalendarKeySerializer();
  
  public StdKeySerializers$CalendarKeySerializer()
  {
    super(Calendar.class);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/ser/std/StdKeySerializers$CalendarKeySerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */