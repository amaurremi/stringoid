package com.fasterxml.jackson.databind.node;

public abstract class ContainerNode<T extends ContainerNode<T>>
  extends BaseJsonNode
{
  protected final JsonNodeFactory _nodeFactory;
  
  protected ContainerNode(JsonNodeFactory paramJsonNodeFactory)
  {
    this._nodeFactory = paramJsonNodeFactory;
  }
  
  public String asText()
  {
    return "";
  }
  
  public final NullNode nullNode()
  {
    return this._nodeFactory.nullNode();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/node/ContainerNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */