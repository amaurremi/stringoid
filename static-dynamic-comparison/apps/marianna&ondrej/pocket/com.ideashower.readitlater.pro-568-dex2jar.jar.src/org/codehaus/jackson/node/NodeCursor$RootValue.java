package org.codehaus.jackson.node;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonToken;

public final class NodeCursor$RootValue
  extends NodeCursor
{
  protected boolean _done = false;
  JsonNode _node;
  
  public NodeCursor$RootValue(JsonNode paramJsonNode, NodeCursor paramNodeCursor)
  {
    super(0, paramNodeCursor);
    this._node = paramJsonNode;
  }
  
  public boolean currentHasChildren()
  {
    return false;
  }
  
  public JsonNode currentNode()
  {
    return this._node;
  }
  
  public JsonToken endToken()
  {
    return null;
  }
  
  public String getCurrentName()
  {
    return null;
  }
  
  public JsonToken nextToken()
  {
    if (!this._done)
    {
      this._done = true;
      return this._node.asToken();
    }
    this._node = null;
    return null;
  }
  
  public JsonToken nextValue()
  {
    return nextToken();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/node/NodeCursor$RootValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */