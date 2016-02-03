package com.fasterxml.jackson.databind.node;

public final class BooleanNode
  extends ValueNode
{
  public static final BooleanNode FALSE = new BooleanNode();
  public static final BooleanNode TRUE = new BooleanNode();
  
  public static BooleanNode getFalse()
  {
    return FALSE;
  }
  
  public static BooleanNode getTrue()
  {
    return TRUE;
  }
  
  public String asText()
  {
    if (this == TRUE) {
      return "true";
    }
    return "false";
  }
  
  public boolean equals(Object paramObject)
  {
    return paramObject == this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/node/BooleanNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */