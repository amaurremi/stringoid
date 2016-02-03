package com.flurry.org.codehaus.jackson.node;

import com.flurry.org.codehaus.jackson.JsonGenerator;
import com.flurry.org.codehaus.jackson.JsonParser.NumberType;
import com.flurry.org.codehaus.jackson.JsonProcessingException;
import com.flurry.org.codehaus.jackson.JsonToken;
import com.flurry.org.codehaus.jackson.io.NumberOutput;
import com.flurry.org.codehaus.jackson.map.SerializerProvider;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public final class LongNode
  extends NumericNode
{
  final long _value;
  
  public LongNode(long paramLong)
  {
    this._value = paramLong;
  }
  
  public static LongNode valueOf(long paramLong)
  {
    return new LongNode(paramLong);
  }
  
  public boolean asBoolean(boolean paramBoolean)
  {
    return this._value != 0L;
  }
  
  public String asText()
  {
    return NumberOutput.toString(this._value);
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
    } while (((LongNode)paramObject)._value == this._value);
    return false;
  }
  
  public BigInteger getBigIntegerValue()
  {
    return BigInteger.valueOf(this._value);
  }
  
  public BigDecimal getDecimalValue()
  {
    return BigDecimal.valueOf(this._value);
  }
  
  public double getDoubleValue()
  {
    return this._value;
  }
  
  public int getIntValue()
  {
    return (int)this._value;
  }
  
  public long getLongValue()
  {
    return this._value;
  }
  
  public JsonParser.NumberType getNumberType()
  {
    return JsonParser.NumberType.LONG;
  }
  
  public Number getNumberValue()
  {
    return Long.valueOf(this._value);
  }
  
  public int hashCode()
  {
    return (int)this._value ^ (int)(this._value >> 32);
  }
  
  public boolean isIntegralNumber()
  {
    return true;
  }
  
  public boolean isLong()
  {
    return true;
  }
  
  public final void serialize(JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException, JsonProcessingException
  {
    paramJsonGenerator.writeNumber(this._value);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/node/LongNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */