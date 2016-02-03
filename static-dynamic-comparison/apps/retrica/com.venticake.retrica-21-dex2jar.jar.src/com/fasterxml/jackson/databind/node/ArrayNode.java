package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayNode
  extends ContainerNode<ArrayNode>
{
  protected List<JsonNode> _children;
  
  public ArrayNode(JsonNodeFactory paramJsonNodeFactory)
  {
    super(paramJsonNodeFactory);
  }
  
  private ArrayNode _add(JsonNode paramJsonNode)
  {
    if (this._children == null) {
      this._children = _createList();
    }
    this._children.add(paramJsonNode);
    return this;
  }
  
  private boolean _sameChildren(List<JsonNode> paramList)
  {
    int j = paramList.size();
    if (size() != j) {
      return false;
    }
    int i = 0;
    while (i < j)
    {
      if (!((JsonNode)this._children.get(i)).equals(paramList.get(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  protected List<JsonNode> _createList()
  {
    return new ArrayList();
  }
  
  public ArrayNode add(JsonNode paramJsonNode)
  {
    Object localObject = paramJsonNode;
    if (paramJsonNode == null) {
      localObject = nullNode();
    }
    _add((JsonNode)localObject);
    return this;
  }
  
  public Iterator<JsonNode> elements()
  {
    if (this._children == null) {
      return ContainerNode.NoNodesIterator.instance();
    }
    return this._children.iterator();
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
      paramObject = (ArrayNode)paramObject;
      if ((this._children != null) && (this._children.size() != 0)) {
        break;
      }
    } while (((ArrayNode)paramObject).size() == 0);
    return false;
    return ((ArrayNode)paramObject)._sameChildren(this._children);
  }
  
  public JsonNode get(String paramString)
  {
    return null;
  }
  
  public int hashCode()
  {
    int j;
    if (this._children == null) {
      j = 1;
    }
    int i;
    Iterator localIterator;
    do
    {
      return j;
      i = this._children.size();
      localIterator = this._children.iterator();
      j = i;
    } while (!localIterator.hasNext());
    JsonNode localJsonNode = (JsonNode)localIterator.next();
    if (localJsonNode != null) {
      i = localJsonNode.hashCode() ^ i;
    }
    for (;;)
    {
      break;
    }
  }
  
  public int size()
  {
    if (this._children == null) {
      return 0;
    }
    return this._children.size();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder((size() << 4) + 16);
    localStringBuilder.append('[');
    if (this._children != null)
    {
      int j = this._children.size();
      int i = 0;
      while (i < j)
      {
        if (i > 0) {
          localStringBuilder.append(',');
        }
        localStringBuilder.append(((JsonNode)this._children.get(i)).toString());
        i += 1;
      }
    }
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/node/ArrayNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */