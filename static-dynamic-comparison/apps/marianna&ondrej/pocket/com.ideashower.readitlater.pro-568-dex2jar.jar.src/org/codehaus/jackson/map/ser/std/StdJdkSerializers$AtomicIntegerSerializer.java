package org.codehaus.jackson.map.ser.std;

import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicInteger;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.SerializerProvider;

public final class StdJdkSerializers$AtomicIntegerSerializer
  extends ScalarSerializerBase
{
  public StdJdkSerializers$AtomicIntegerSerializer()
  {
    super(AtomicInteger.class, false);
  }
  
  public JsonNode getSchema(SerializerProvider paramSerializerProvider, Type paramType)
  {
    return createSchemaNode("integer", true);
  }
  
  public void serialize(AtomicInteger paramAtomicInteger, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
  {
    paramJsonGenerator.writeNumber(paramAtomicInteger.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ser/std/StdJdkSerializers$AtomicIntegerSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */