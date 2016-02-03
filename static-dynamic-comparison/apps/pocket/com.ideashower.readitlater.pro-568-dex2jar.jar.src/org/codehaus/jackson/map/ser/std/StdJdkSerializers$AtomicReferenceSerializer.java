package org.codehaus.jackson.map.ser.std;

import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicReference;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.SerializerProvider;

public final class StdJdkSerializers$AtomicReferenceSerializer
  extends SerializerBase
{
  public StdJdkSerializers$AtomicReferenceSerializer()
  {
    super(AtomicReference.class, false);
  }
  
  public JsonNode getSchema(SerializerProvider paramSerializerProvider, Type paramType)
  {
    return createSchemaNode("any", true);
  }
  
  public void serialize(AtomicReference paramAtomicReference, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
  {
    paramSerializerProvider.defaultSerializeValue(paramAtomicReference.get(), paramJsonGenerator);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ser/std/StdJdkSerializers$AtomicReferenceSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */