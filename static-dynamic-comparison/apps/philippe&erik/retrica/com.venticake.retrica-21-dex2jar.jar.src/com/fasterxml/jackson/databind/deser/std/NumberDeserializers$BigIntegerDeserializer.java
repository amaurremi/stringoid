package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import java.math.BigDecimal;
import java.math.BigInteger;

@JacksonStdImpl
public class NumberDeserializers$BigIntegerDeserializer
  extends StdScalarDeserializer<BigInteger>
{
  public NumberDeserializers$BigIntegerDeserializer()
  {
    super(BigInteger.class);
  }
  
  public BigInteger deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    Object localObject = paramJsonParser.getCurrentToken();
    if (localObject == JsonToken.VALUE_NUMBER_INT) {
      switch (NumberDeserializers.1.$SwitchMap$com$fasterxml$jackson$core$JsonParser$NumberType[paramJsonParser.getNumberType().ordinal()])
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
      if (localObject == JsonToken.VALUE_NUMBER_FLOAT) {
        return paramJsonParser.getDecimalValue().toBigInteger();
      }
    } while (localObject == JsonToken.VALUE_STRING);
    throw paramDeserializationContext.mappingException(this._valueClass, (JsonToken)localObject);
    try
    {
      localObject = new BigInteger(paramJsonParser);
      return (BigInteger)localObject;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw paramDeserializationContext.weirdStringException(paramJsonParser, this._valueClass, "not a valid representation");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/std/NumberDeserializers$BigIntegerDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */