package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.io.NumberOutput;

public final class DoubleNode
  extends NumericNode
{
  protected final double _value;
  
  public DoubleNode(double paramDouble)
  {
    this._value = paramDouble;
  }
  
  public static DoubleNode valueOf(double paramDouble)
  {
    return new DoubleNode(paramDouble);
  }
  
  public String asText()
  {
    return NumberOutput.toString(this._value);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    double d;
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (paramObject.getClass() != getClass()) {
        return false;
      }
      d = ((DoubleNode)paramObject)._value;
    } while (Double.compare(this._value, d) == 0);
    return false;
  }
  
  public int hashCode()
  {
    long l = Double.doubleToLongBits(this._value);
    int i = (int)l;
    return (int)(l >> 32) ^ i;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/node/DoubleNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */