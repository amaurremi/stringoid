package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.io.NumberOutput;

public final class IntNode
  extends NumericNode
{
  private static final IntNode[] CANONICALS = new IntNode[12];
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
    } while (((IntNode)paramObject)._value == this._value);
    return false;
  }
  
  public int hashCode()
  {
    return this._value;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/node/IntNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */