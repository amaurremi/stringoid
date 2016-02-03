package org.codehaus.jackson.map.ser.std;

import java.util.Date;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

public class StdKeySerializers$DateKeySerializer
  extends SerializerBase
{
  protected static final JsonSerializer instance = new DateKeySerializer();
  
  public StdKeySerializers$DateKeySerializer()
  {
    super(Date.class);
  }
  
  public void serialize(Date paramDate, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
  {
    paramSerializerProvider.defaultSerializeDateKey(paramDate, paramJsonGenerator);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ser/std/StdKeySerializers$DateKeySerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */