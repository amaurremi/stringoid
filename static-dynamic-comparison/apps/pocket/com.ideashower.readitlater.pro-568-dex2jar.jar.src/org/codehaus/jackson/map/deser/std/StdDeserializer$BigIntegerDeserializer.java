package org.codehaus.jackson.map.deser.std;

import java.math.BigDecimal;
import java.math.BigInteger;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;

@JacksonStdImpl
public class StdDeserializer$BigIntegerDeserializer
  extends StdScalarDeserializer
{
  public StdDeserializer$BigIntegerDeserializer()
  {
    super(BigInteger.class);
  }
  
  public BigInteger deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    if (localJsonToken == JsonToken.VALUE_NUMBER_INT) {
      switch (StdDeserializer.1.$SwitchMap$org$codehaus$jackson$JsonParser$NumberType[paramJsonParser.getNumberType().ordinal()])
      {
      }
    }
    do
    {
      paramJsonParser = paramJsonParser.getText().trim();
      if (paramJsonParser.length() != 0) {
        break;
      }
      return null;
      return BigInteger.valueOf(paramJsonParser.getLongValue());
      if (localJsonToken == JsonToken.VALUE_NUMBER_FLOAT) {
        return paramJsonParser.getDecimalValue().toBigInteger();
      }
    } while (localJsonToken == JsonToken.VALUE_STRING);
    throw paramDeserializationContext.mappingException(this._valueClass, localJsonToken);
    try
    {
      paramJsonParser = new BigInteger(paramJsonParser);
      return paramJsonParser;
    }
    catch (IllegalArgumentException paramJsonParser)
    {
      throw paramDeserializationContext.weirdStringException(this._valueClass, "not a valid representation");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/std/StdDeserializer$BigIntegerDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */