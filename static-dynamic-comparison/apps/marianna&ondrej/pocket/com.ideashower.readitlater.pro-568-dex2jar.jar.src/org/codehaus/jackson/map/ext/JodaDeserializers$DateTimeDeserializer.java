package org.codehaus.jackson.map.ext;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.ReadableInstant;

public class JodaDeserializers$DateTimeDeserializer
  extends JodaDeserializers.JodaDeserializer
{
  public JodaDeserializers$DateTimeDeserializer(Class paramClass)
  {
    super(paramClass);
  }
  
  public ReadableInstant deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    if (localJsonToken == JsonToken.VALUE_NUMBER_INT) {
      return new DateTime(paramJsonParser.getLongValue(), DateTimeZone.UTC);
    }
    if (localJsonToken == JsonToken.VALUE_STRING)
    {
      paramJsonParser = paramJsonParser.getText().trim();
      if (paramJsonParser.length() == 0) {
        return null;
      }
      return new DateTime(paramJsonParser, DateTimeZone.UTC);
    }
    throw paramDeserializationContext.mappingException(getValueClass());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ext/JodaDeserializers$DateTimeDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */