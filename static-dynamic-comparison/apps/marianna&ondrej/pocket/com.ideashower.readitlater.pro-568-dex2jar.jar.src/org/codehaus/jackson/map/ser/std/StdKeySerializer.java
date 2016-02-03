package org.codehaus.jackson.map.ser.std;

import java.lang.reflect.Type;
import java.util.Date;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.SerializerProvider;

public class StdKeySerializer
  extends SerializerBase
{
  static final StdKeySerializer instace = new StdKeySerializer();
  
  public StdKeySerializer()
  {
    super(Object.class);
  }
  
  public JsonNode getSchema(SerializerProvider paramSerializerProvider, Type paramType)
  {
    return createSchemaNode("string");
  }
  
  public void serialize(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
  {
    if ((paramObject instanceof Date))
    {
      paramSerializerProvider.defaultSerializeDateKey((Date)paramObject, paramJsonGenerator);
      return;
    }
    paramJsonGenerator.writeFieldName(paramObject.toString());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ser/std/StdKeySerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */