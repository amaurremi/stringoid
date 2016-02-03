package org.codehaus.jackson.node;

import java.util.Iterator;
import java.util.Map.Entry;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonToken;

public final class NodeCursor$Object
  extends NodeCursor
{
  Iterator _contents;
  Map.Entry _current;
  boolean _needEntry;
  
  public NodeCursor$Object(JsonNode paramJsonNode, NodeCursor paramNodeCursor)
  {
    super(2, paramNodeCursor);
    this._contents = ((ObjectNode)paramJsonNode).getFields();
    this._needEntry = true;
  }
  
  public boolean currentHasChildren()
  {
    return ((ContainerNode)currentNode()).size() > 0;
  }
  
  public JsonNode currentNode()
  {
    if (this._current == null) {
      return null;
    }
    return (JsonNode)this._current.getValue();
  }
  
  public JsonToken endToken()
  {
    return JsonToken.END_OBJECT;
  }
  
  public String getCurrentName()
  {
    if (this._current == null) {
      return null;
    }
    return (String)this._current.getKey();
  }
  
  public JsonToken nextToken()
  {
    if (this._needEntry)
    {
      if (!this._contents.hasNext())
      {
        this._current = null;
        return null;
      }
      this._needEntry = false;
      this._current = ((Map.Entry)this._contents.next());
      return JsonToken.FIELD_NAME;
    }
    this._needEntry = true;
    return ((JsonNode)this._current.getValue()).asToken();
  }
  
  public JsonToken nextValue()
  {
    JsonToken localJsonToken2 = nextToken();
    JsonToken localJsonToken1 = localJsonToken2;
    if (localJsonToken2 == JsonToken.FIELD_NAME) {
      localJsonToken1 = nextToken();
    }
    return localJsonToken1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/node/NodeCursor$Object.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */