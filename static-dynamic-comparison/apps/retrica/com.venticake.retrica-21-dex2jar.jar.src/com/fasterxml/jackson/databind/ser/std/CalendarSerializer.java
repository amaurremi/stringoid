package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import java.text.DateFormat;
import java.util.Calendar;

@JacksonStdImpl
public class CalendarSerializer
  extends DateTimeSerializerBase<Calendar>
{
  public static CalendarSerializer instance = new CalendarSerializer();
  
  public CalendarSerializer()
  {
    this(false, null);
  }
  
  public CalendarSerializer(boolean paramBoolean, DateFormat paramDateFormat)
  {
    super(Calendar.class, paramBoolean, paramDateFormat);
  }
  
  public CalendarSerializer withFormat(boolean paramBoolean, DateFormat paramDateFormat)
  {
    if (paramBoolean) {
      return new CalendarSerializer(true, null);
    }
    return new CalendarSerializer(false, paramDateFormat);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/ser/std/CalendarSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */