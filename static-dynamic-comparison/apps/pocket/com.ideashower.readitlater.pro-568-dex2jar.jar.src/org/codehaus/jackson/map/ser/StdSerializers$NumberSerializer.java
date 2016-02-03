package org.codehaus.jackson.map.ser;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;
import org.codehaus.jackson.map.ser.std.ScalarSerializerBase;

@JacksonStdImpl
public final class StdSerializers$NumberSerializer
  extends ScalarSerializerBase
{
  public static final NumberSerializer instance = new NumberSerializer();
  
  public StdSerializers$NumberSerializer()
  {
    super(Number.class);
  }
  
  public JsonNode getSchema(SerializerProvider paramSerializerProvider, Type paramType)
  {
    return createSchemaNode("number", true);
  }
  
  public void serialize(Number paramNumber, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
  {
    if ((paramNumber instanceof BigDecimal))
    {
      paramJsonGenerator.writeNumber((BigDecimal)paramNumber);
      return;
    }
    if ((paramNumber instanceof BigInteger))
    {
      paramJsonGenerator.writeNumber((BigInteger)paramNumber);
      return;
    }
    if ((paramNumber instanceof Integer))
    {
      paramJsonGenerator.writeNumber(paramNumber.intValue());
      return;
    }
    if ((paramNumber instanceof Long))
    {
      paramJsonGenerator.writeNumber(paramNumber.longValue());
      return;
    }
    if ((paramNumber instanceof Double))
    {
      paramJsonGenerator.writeNumber(paramNumber.doubleValue());
      return;
    }
    if ((paramNumber instanceof Float))
    {
      paramJsonGenerator.writeNumber(paramNumber.floatValue());
      return;
    }
    if (((paramNumber instanceof Byte)) || ((paramNumber instanceof Short)))
    {
      paramJsonGenerator.writeNumber(paramNumber.intValue());
      return;
    }
    paramJsonGenerator.writeNumber(paramNumber.toString());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ser/StdSerializers$NumberSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */