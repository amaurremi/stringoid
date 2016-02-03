package org.codehaus.jackson.map.deser.std;

import java.util.Calendar;
import java.util.Date;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;

@JacksonStdImpl
public class CalendarDeserializer
  extends StdScalarDeserializer
{
  protected final Class _calendarClass;
  
  public CalendarDeserializer()
  {
    this(null);
  }
  
  public CalendarDeserializer(Class paramClass)
  {
    super(Calendar.class);
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
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/std/CalendarDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */