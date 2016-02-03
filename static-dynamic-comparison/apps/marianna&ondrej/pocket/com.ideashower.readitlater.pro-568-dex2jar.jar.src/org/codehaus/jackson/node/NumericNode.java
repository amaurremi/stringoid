package org.codehaus.jackson.node;

import java.math.BigDecimal;
import java.math.BigInteger;
import org.codehaus.jackson.JsonParser.NumberType;

public abstract class NumericNode
  extends ValueNode
{
  public double asDouble()
  {
    return getDoubleValue();
  }
  
  public double asDouble(double paramDouble)
  {
    return getDoubleValue();
  }
  
  public int asInt()
  {
    return getIntValue();
  }
  
  public int asInt(int paramInt)
  {
    return getIntValue();
  }
  
  public long asLong()
  {
    return getLongValue();
  }
  
  public long asLong(long paramLong)
  {
    return getLongValue();
  }
  
  public abstract String asText();
  
  public abstract BigInteger getBigIntegerValue();
  
  public abstract BigDecimal getDecimalValue();
  
  public abstract double getDoubleValue();
  
  public abstract int getIntValue();
  
  public abstract long getLongValue();
  
  public abstract JsonParser.NumberType getNumberType();
  
  public abstract Number getNumberValue();
  
  public final boolean isNumber()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/node/NumericNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */