package org.codehaus.jackson.map.ser.std;

import java.util.Calendar;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

public class StdKeySerializers$CalendarKeySerializer
  extends SerializerBase
{
  protected static final JsonSerializer instance = new CalendarKeySerializer();
  
  public StdKeySerializers$CalendarKeySerializer()
  {
    super(Calendar.class);
  }
  
  public void serialize(Calendar paramCalendar, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
  {
    paramSerializerProvider.defaultSerializeDateKey(paramCalendar.getTimeInMillis(), paramJsonGenerator);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ser/std/StdKeySerializers$CalendarKeySerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */