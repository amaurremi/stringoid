package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

@JacksonStdImpl
public class DateDeserializers$CalendarDeserializer
  extends DateDeserializers.DateBasedDeserializer<Calendar>
{
  protected final Class<? extends Calendar> _calendarClass;
  
  public DateDeserializers$CalendarDeserializer()
  {
    super(Calendar.class);
    this._calendarClass = null;
  }
  
  public DateDeserializers$CalendarDeserializer(CalendarDeserializer paramCalendarDeserializer, DateFormat paramDateFormat, String paramString)
  {
    super(paramCalendarDeserializer, paramDateFormat, paramString);
    this._calendarClass = paramCalendarDeserializer._calendarClass;
  }
  
  public DateDeserializers$CalendarDeserializer(Class<? extends Calendar> paramClass)
  {
    super(paramClass);
    this._calendarClass = paramClass;
  }
  
  public Calendar deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    paramJsonParser = _parseDate(paramJsonParser, paramDeserializationContext);
    if (paramJsonParser == null) {
      return null;
    }
    if (this._calendarClass == null) {
      return paramDeserializationContext.constructCalendar(paramJsonParser);
    }
    try
    {
      Calendar localCalendar = (Calendar)this._calendarClass.newInstance();
      localCalendar.setTimeInMillis(paramJsonParser.getTime());
      return localCalendar;
    }
    catch (Exception paramJsonParser)
    {
      throw paramDeserializationContext.instantiationException(this._calendarClass, paramJsonParser);
    }
  }
  
  protected CalendarDeserializer withDateFormat(DateFormat paramDateFormat, String paramString)
  {
    return new CalendarDeserializer(this, paramDateFormat, paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/std/DateDeserializers$CalendarDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */