package com.flurry.org.codehaus.jackson.node;

import com.flurry.org.codehaus.jackson.JsonGenerator;
import com.flurry.org.codehaus.jackson.JsonParser.NumberType;
import com.flurry.org.codehaus.jackson.JsonProcessingException;
import com.flurry.org.codehaus.jackson.JsonToken;
import com.flurry.org.codehaus.jackson.map.SerializerProvider;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public final class BigIntegerNode
  extends NumericNode
{
  protected final BigInteger _value;
  
  public BigIntegerNode(BigInteger paramBigInteger)
  {
    this._value = paramBigInteger;
  }
  
  public static BigIntegerNode valueOf(BigInteger paramBigInteger)
  {
    return new BigIntegerNode(paramBigInteger);
  }
  
  public boolean asBoolean(boolean paramBoolean)
  {
    return !BigInteger.ZERO.equals(this._value);
  }
  
  public String asText()
  {
    return this._value.toString();
  }
  
  public JsonToken asToken()
  {
    return JsonToken.VALUE_NUMBER_INT;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (paramObject.getClass() != getClass()) {
        return false;
      }
    } while (((BigIntegerNode)paramObject)._value == this._value);
    return false;
  }
  
  public BigInteger getBigIntegerValue()
  {
    return this._value;
  }
  
  public BigDecimal getDecimalValue()
  {
    return new BigDecimal(this._value);
  }
  
  public double getDoubleValue()
  {
    return this._value.doubleValue();
  }
  
  public int getIntValue()
  {
    return this._value.intValue();
  }
  
  public long getLongValue()
  {
    return this._value.longValue();
  }
  
  public JsonParser.NumberType getNumberType()
  {
    return JsonParser.NumberType.BIG_INTEGER;
  }
  
  public Number getNumberValue()
  {
    return this._value;
  }
  
  public int hashCode()
  {
    return this._value.hashCode();
  }
  
  public boolean isBigInteger()
  {
    return true;
  }
  
  public boolean isIntegralNumber()
  {
    return true;
  }
  
  public final void serialize(JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException, JsonProcessingException
  {
    paramJsonGenerator.writeNumber(this._value);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/node/BigIntegerNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */