package com.fasterxml.jackson.databind.node;

public final class POJONode
  extends ValueNode
{
  protected final Object _value;
  
  public POJONode(Object paramObject)
  {
    this._value = paramObject;
  }
  
  public String asText()
  {
    if (this._value == null) {
      return "null";
    }
    return this._value.toString();
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
      paramObject = (POJONode)paramObject;
      if (this._value != null) {
        break;
      }
    } while (((POJONode)paramObject)._value == null);
    return false;
    return this._value.equals(((POJONode)paramObject)._value);
  }
  
  public int hashCode()
  {
    return this._value.hashCode();
  }
  
  public String toString()
  {
    return String.valueOf(this._value);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/node/POJONode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */