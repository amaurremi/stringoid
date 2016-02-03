package org.codehaus.jackson.map.ext;

import java.lang.reflect.Type;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.SerializationConfig.Feature;
import org.codehaus.jackson.map.SerializerProvider;
import org.joda.time.DateMidnight;
import org.joda.time.DateMidnight.Property;

public final class JodaSerializers$DateMidnightSerializer
  extends JodaSerializers.JodaSerializer
{
  public JodaSerializers$DateMidnightSerializer()
  {
    super(DateMidnight.class);
  }
  
  public JsonNode getSchema(SerializerProvider paramSerializerProvider, Type paramType)
  {
    if (paramSerializerProvider.isEnabled(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS)) {}
    for (paramSerializerProvider = "array";; paramSerializerProvider = "string") {
      return createSchemaNode(paramSerializerProvider, true);
    }
  }
  
  public void serialize(DateMidnight paramDateMidnight, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
  {
    if (paramSerializerProvider.isEnabled(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS))
    {
      paramJsonGenerator.writeStartArray();
      paramJsonGenerator.writeNumber(paramDateMidnight.year().get());
      paramJsonGenerator.writeNumber(paramDateMidnight.monthOfYear().get());
      paramJsonGenerator.writeNumber(paramDateMidnight.dayOfMonth().get());
      paramJsonGenerator.writeEndArray();
      return;
    }
    paramJsonGenerator.writeString(printLocalDate(paramDateMidnight));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ext/JodaSerializers$DateMidnightSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */