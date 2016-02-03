package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.io.NumberOutput;

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
  
  public String asText()
  {
    return NumberOutput.toString(this._value);
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
  
  public int hashCode()
  {
    return (int)this._value ^ (int)(this._value >> 32);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/node/LongNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */