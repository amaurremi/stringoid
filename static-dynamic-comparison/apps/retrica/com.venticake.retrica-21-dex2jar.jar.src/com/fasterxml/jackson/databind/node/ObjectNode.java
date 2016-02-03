package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ObjectNode
  extends ContainerNode<ObjectNode>
{
  protected Map<String, JsonNode> _children = null;
  
  public ObjectNode(JsonNodeFactory paramJsonNodeFactory)
  {
    super(paramJsonNodeFactory);
  }
  
  private final JsonNode _put(String paramString, JsonNode paramJsonNode)
  {
    if (this._children == null) {
      this._children = _createMap();
    }
    return (JsonNode)this._children.put(paramString, paramJsonNode);
  }
  
  protected Map<String, JsonNode> _createMap()
  {
    return new LinkedHashMap();
  }
  
  public Iterator<JsonNode> elements()
  {
    if (this._children == null) {
      return ContainerNode.NoNodesIterator.instance();
    }
    return this._children.values().iterator();
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (paramObject.getClass() != getClass()) {
      return false;
    }
    paramObject = (ObjectNode)paramObject;
    if (((ObjectNode)paramObject).size() != size()) {
      return false;
    }
    if (this._children != null)
    {
      Iterator localIterator = this._children.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (Map.Entry)localIterator.next();
        Object localObject1 = (String)((Map.Entry)localObject2).getKey();
        localObject2 = (JsonNode)((Map.Entry)localObject2).getValue();
        localObject1 = ((ObjectNode)paramObject).get((String)localObject1);
        if ((localObject1 == null) || (!((JsonNode)localObject1).equals(localObject2))) {
          return false;
        }
      }
    }
    return true;
  }
  
  public JsonNode get(String paramString)
  {
    if (this._children != null) {
      return (JsonNode)this._children.get(paramString);
    }
    return null;
  }
  
  public int hashCode()
  {
    if (this._children == null) {
      return -1;
    }
    return this._children.hashCode();
  }
  
  public JsonNode replace(String paramString, JsonNode paramJsonNode)
  {
    Object localObject = paramJsonNode;
    if (paramJsonNode == null) {
      localObject = nullNode();
    }
    return _put(paramString, (JsonNode)localObject);
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
    StringBuilder localStringBuilder = new StringBuilder((size() << 4) + 32);
    localStringBuilder.append("{");
    if (this._children != null)
    {
      Iterator localIterator = this._children.entrySet().iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (i > 0) {
          localStringBuilder.append(",");
        }
        TextNode.appendQuoted(localStringBuilder, (String)localEntry.getKey());
        localStringBuilder.append(':');
        localStringBuilder.append(((JsonNode)localEntry.getValue()).toString());
        i += 1;
      }
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/node/ObjectNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */