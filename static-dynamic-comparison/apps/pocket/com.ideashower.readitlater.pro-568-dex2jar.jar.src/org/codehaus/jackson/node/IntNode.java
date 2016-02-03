package org.codehaus.jackson.node;

import java.math.BigDecimal;
import java.math.BigInteger;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParser.NumberType;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.io.NumberOutput;
import org.codehaus.jackson.map.SerializerProvider;

public final class IntNode
  extends NumericNode
{
  private static final IntNode[] CANONICALS = new IntNode[12];
  static final int MAX_CANONICAL = 10;
  static final int MIN_CANONICAL = -1;
  final int _value;
  
  static
  {
    int i = 0;
    while (i < 12)
    {
      CANONICALS[i] = new IntNode(i - 1);
      i += 1;
    }
  }
  
  public IntNode(int paramInt)
  {
    this._value = paramInt;
  }
  
  public static IntNode valueOf(int paramInt)
  {
    if ((paramInt > 10) || (paramInt < -1)) {
      return new IntNode(paramInt);
    }
    return CANONICALS[(paramInt + 1)];
  }
  
  public boolean asBoolean(boolean paramBoolean)
  {
    return this._value != 0;
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
    } while (((IntNode)paramObject)._value == this._value);
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
    return this._value;
  }
  
  public long getLongValue()
  {
    return this._value;
  }
  
  public JsonParser.NumberType getNumberType()
  {
    return JsonParser.NumberType.INT;
  }
  
  public Number getNumberValue()
  {
    return Integer.valueOf(this._value);
  }
  
  public int hashCode()
  {
    return this._value;
  }
  
  public boolean isInt()
  {
    return true;
  }
  
  public boolean isIntegralNumber()
  {
    return true;
  }
  
  public final void serialize(JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
  {
    paramJsonGenerator.writeNumber(this._value);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/node/IntNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */