package com.fasterxml.jackson.databind.node;

import java.math.BigDecimal;

public final class DecimalNode
  extends NumericNode
{
  private static final BigDecimal MAX_INTEGER;
  private static final BigDecimal MAX_LONG = BigDecimal.valueOf(Long.MAX_VALUE);
  private static final BigDecimal MIN_INTEGER = BigDecimal.valueOf(-2147483648L);
  private static final BigDecimal MIN_LONG;
  protected final BigDecimal _value;
  
  static
  {
    MAX_INTEGER = BigDecimal.valueOf(2147483647L);
    MIN_LONG = BigDecimal.valueOf(Long.MIN_VALUE);
  }
  
  public DecimalNode(BigDecimal paramBigDecimal)
  {
    this._value = paramBigDecimal;
  }
  
  public static DecimalNode valueOf(BigDecimal paramBigDecimal)
  {
    return new DecimalNode(paramBigDecimal);
  }
  
  public String asText()
  {
    return this._value.toString();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramObject == this) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramObject == null);
      bool1 = bool2;
    } while (paramObject.getClass() != getClass());
    return ((DecimalNode)paramObject)._value.equals(this._value);
  }
  
  public int hashCode()
  {
    return this._value.hashCode();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/node/DecimalNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */