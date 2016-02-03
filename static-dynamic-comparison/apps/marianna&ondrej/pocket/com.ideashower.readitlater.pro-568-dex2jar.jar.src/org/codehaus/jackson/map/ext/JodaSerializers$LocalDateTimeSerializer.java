package org.codehaus.jackson.map.ext;

import java.lang.reflect.Type;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.SerializationConfig.Feature;
import org.codehaus.jackson.map.SerializerProvider;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalDateTime.Property;

public final class JodaSerializers$LocalDateTimeSerializer
  extends JodaSerializers.JodaSerializer
{
  public JodaSerializers$LocalDateTimeSerializer()
  {
    super(LocalDateTime.class);
  }
  
  public JsonNode getSchema(SerializerProvider paramSerializerProvider, Type paramType)
  {
    if (paramSerializerProvider.isEnabled(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS)) {}
    for (paramSerializerProvider = "array";; paramSerializerProvider = "string") {
      return createSchemaNode(paramSerializerProvider, true);
    }
  }
  
  public void serialize(LocalDateTime paramLocalDateTime, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
  {
    if (paramSerializerProvider.isEnabled(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS))
    {
      paramJsonGenerator.writeStartArray();
      paramJsonGenerator.writeNumber(paramLocalDateTime.year().get());
      paramJsonGenerator.writeNumber(paramLocalDateTime.monthOfYear().get());
      paramJsonGenerator.writeNumber(paramLocalDateTime.dayOfMonth().get());
      paramJsonGenerator.writeNumber(paramLocalDateTime.hourOfDay().get());
      paramJsonGenerator.writeNumber(paramLocalDateTime.minuteOfHour().get());
      paramJsonGenerator.writeNumber(paramLocalDateTime.secondOfMinute().get());
      paramJsonGenerator.writeNumber(paramLocalDateTime.millisOfSecond().get());
      paramJsonGenerator.writeEndArray();
      return;
    }
    paramJsonGenerator.writeString(printLocalDateTime(paramLocalDateTime));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ext/JodaSerializers$LocalDateTimeSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */