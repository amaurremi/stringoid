package org.codehaus.jackson.map.ext;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.deser.std.StdScalarDeserializer;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

abstract class JodaDeserializers$JodaDeserializer
  extends StdScalarDeserializer
{
  static final DateTimeFormatter _localDateTimeFormat = ;
  
  protected JodaDeserializers$JodaDeserializer(Class paramClass)
  {
    super(paramClass);
  }
  
  protected DateTime parseLocal(JsonParser paramJsonParser)
  {
    paramJsonParser = paramJsonParser.getText().trim();
    if (paramJsonParser.length() == 0) {
      return null;
    }
    return _localDateTimeFormat.parseDateTime(paramJsonParser);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ext/JodaDeserializers$JodaDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */