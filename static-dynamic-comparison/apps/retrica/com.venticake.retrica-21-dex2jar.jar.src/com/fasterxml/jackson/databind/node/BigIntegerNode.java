package com.fasterxml.jackson.databind.node;

import java.math.BigInteger;

public final class BigIntegerNode
  extends NumericNode
{
  private static final BigInteger MAX_INTEGER;
  private static final BigInteger MAX_LONG = BigInteger.valueOf(Long.MAX_VALUE);
  private static final BigInteger MIN_INTEGER = BigInteger.valueOf(-2147483648L);
  private static final BigInteger MIN_LONG;
  protected final BigInteger _value;
  
  static
  {
    MAX_INTEGER = BigInteger.valueOf(2147483647L);
    MIN_LONG = BigInteger.valueOf(Long.MIN_VALUE);
  }
  
  public BigIntegerNode(BigInteger paramBigInteger)
  {
    this._value = paramBigInteger;
  }
  
  public static BigIntegerNode valueOf(BigInteger paramBigInteger)
  {
    return new BigIntegerNode(paramBigInteger);
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
    return ((BigIntegerNode)paramObject)._value.equals(this._value);
  }
  
  public int hashCode()
  {
    return this._value.hashCode();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/node/BigIntegerNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */