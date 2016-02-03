package org.codehaus.jackson.map.ser;

import java.lang.reflect.Type;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;
import org.codehaus.jackson.map.ser.std.NonTypedScalarSerializerBase;

@JacksonStdImpl
public final class StdSerializers$BooleanSerializer
  extends NonTypedScalarSerializerBase
{
  final boolean _forPrimitive;
  
  public StdSerializers$BooleanSerializer(boolean paramBoolean)
  {
    super(Boolean.class);
    this._forPrimitive = paramBoolean;
  }
  
  public JsonNode getSchema(SerializerProvider paramSerializerProvider, Type paramType)
  {
    if (!this._forPrimitive) {}
    for (boolean bool = true;; bool = false) {
      return createSchemaNode("boolean", bool);
    }
  }
  
  public void serialize(Boolean paramBoolean, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
  {
    paramJsonGenerator.writeBoolean(paramBoolean.booleanValue());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ser/StdSerializers$BooleanSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */