package org.codehaus.jackson.node;

import java.util.Iterator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonToken;

public final class NodeCursor$Array
  extends NodeCursor
{
  Iterator _contents;
  JsonNode _currentNode;
  
  public NodeCursor$Array(JsonNode paramJsonNode, NodeCursor paramNodeCursor)
  {
    super(1, paramNodeCursor);
    this._contents = paramJsonNode.getElements();
  }
  
  public boolean currentHasChildren()
  {
    return ((ContainerNode)currentNode()).size() > 0;
  }
  
  public JsonNode currentNode()
  {
    return this._currentNode;
  }
  
  public JsonToken endToken()
  {
    return JsonToken.END_ARRAY;
  }
  
  public String getCurrentName()
  {
    return null;
  }
  
  public JsonToken nextToken()
  {
    if (!this._contents.hasNext())
    {
      this._currentNode = null;
      return null;
    }
    this._currentNode = ((JsonNode)this._contents.next());
    return this._currentNode.asToken();
  }
  
  public JsonToken nextValue()
  {
    return nextToken();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/node/NodeCursor$Array.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */