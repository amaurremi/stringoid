package org.codehaus.jackson.node;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonStreamContext;
import org.codehaus.jackson.JsonToken;

abstract class NodeCursor
  extends JsonStreamContext
{
  final NodeCursor _parent;
  
  public NodeCursor(int paramInt, NodeCursor paramNodeCursor)
  {
    this._type = paramInt;
    this._index = -1;
    this._parent = paramNodeCursor;
  }
  
  public abstract boolean currentHasChildren();
  
  public abstract JsonNode currentNode();
  
  public abstract JsonToken endToken();
  
  public abstract String getCurrentName();
  
  public final NodeCursor getParent()
  {
    return this._parent;
  }
  
  public final NodeCursor iterateChildren()
  {
    JsonNode localJsonNode = currentNode();
    if (localJsonNode == null) {
      throw new IllegalStateException("No current node");
    }
    if (localJsonNode.isArray()) {
      return new NodeCursor.Array(localJsonNode, this);
    }
    if (localJsonNode.isObject()) {
      return new NodeCursor.Object(localJsonNode, this);
    }
    throw new IllegalStateException("Current node of type " + localJsonNode.getClass().getName());
  }
  
  public abstract JsonToken nextToken();
  
  public abstract JsonToken nextValue();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/node/NodeCursor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */