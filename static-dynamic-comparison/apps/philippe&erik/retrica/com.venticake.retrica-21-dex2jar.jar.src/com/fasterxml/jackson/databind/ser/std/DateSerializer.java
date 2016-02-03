package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import java.text.DateFormat;
import java.util.Date;

@JacksonStdImpl
public class DateSerializer
  extends DateTimeSerializerBase<Date>
{
  public static DateSerializer instance = new DateSerializer();
  
  public DateSerializer()
  {
    this(false, null);
  }
  
  public DateSerializer(boolean paramBoolean, DateFormat paramDateFormat)
  {
    super(Date.class, paramBoolean, paramDateFormat);
  }
  
  public DateSerializer withFormat(boolean paramBoolean, DateFormat paramDateFormat)
  {
    if (paramBoolean) {
      return new DateSerializer(true, null);
    }
    return new DateSerializer(false, paramDateFormat);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/ser/std/DateSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */