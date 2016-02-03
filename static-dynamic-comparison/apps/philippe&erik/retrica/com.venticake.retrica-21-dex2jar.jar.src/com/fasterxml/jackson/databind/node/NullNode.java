package com.fasterxml.jackson.databind.node;

public final class NullNode
  extends ValueNode
{
  public static final NullNode instance = new NullNode();
  
  public static NullNode getInstance()
  {
    return instance;
  }
  
  public String asText()
  {
    return "null";
  }
  
  public boolean equals(Object paramObject)
  {
    return paramObject == this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/node/NullNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */