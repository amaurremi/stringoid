package org.codehaus.jackson.map.ext;

import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.deser.std.StdScalarDeserializer;

public class CoreXMLDeserializers$GregorianCalendarDeserializer
  extends StdScalarDeserializer
{
  public CoreXMLDeserializers$GregorianCalendarDeserializer()
  {
    super(XMLGregorianCalendar.class);
  }
  
  public XMLGregorianCalendar deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    paramJsonParser = _parseDate(paramJsonParser, paramDeserializationContext);
    if (paramJsonParser == null) {
      return null;
    }
    paramDeserializationContext = new GregorianCalendar();
    paramDeserializationContext.setTime(paramJsonParser);
    return CoreXMLDeserializers._dataTypeFactory.newXMLGregorianCalendar(paramDeserializationContext);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ext/CoreXMLDeserializers$GregorianCalendarDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */