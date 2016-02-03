package org.codehaus.jackson.map.ext;

import java.lang.reflect.Type;
import javax.xml.datatype.XMLGregorianCalendar;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.ser.std.CalendarSerializer;
import org.codehaus.jackson.map.ser.std.SerializerBase;

public class CoreXMLSerializers$XMLGregorianCalendarSerializer
  extends SerializerBase
{
  public CoreXMLSerializers$XMLGregorianCalendarSerializer()
  {
    super(XMLGregorianCalendar.class);
  }
  
  public JsonNode getSchema(SerializerProvider paramSerializerProvider, Type paramType)
  {
    return CalendarSerializer.instance.getSchema(paramSerializerProvider, paramType);
  }
  
  public void serialize(XMLGregorianCalendar paramXMLGregorianCalendar, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
  {
    CalendarSerializer.instance.serialize(paramXMLGregorianCalendar.toGregorianCalendar(), paramJsonGenerator, paramSerializerProvider);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ext/CoreXMLSerializers$XMLGregorianCalendarSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */