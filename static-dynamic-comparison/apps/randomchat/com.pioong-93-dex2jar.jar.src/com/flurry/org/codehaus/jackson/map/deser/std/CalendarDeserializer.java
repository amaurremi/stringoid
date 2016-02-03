package com.flurry.org.codehaus.jackson.map.deser.std;

import com.flurry.org.codehaus.jackson.JsonParser;
import com.flurry.org.codehaus.jackson.JsonProcessingException;
import com.flurry.org.codehaus.jackson.map.DeserializationContext;
import com.flurry.org.codehaus.jackson.map.annotate.JacksonStdImpl;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

@JacksonStdImpl
public class CalendarDeserializer
  extends StdScalarDeserializer<Calendar>
{
  protected final Class<? extends Calendar> _calendarClass;
  
  public CalendarDeserializer()
  {
    this(null);
  }
  
  public CalendarDeserializer(Class<? extends Calendar> paramClass)
  {
    super(Calendar.class);
    this._calendarClass = paramClass;
  }
  
  public Calendar deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
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
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/deser/std/CalendarDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */