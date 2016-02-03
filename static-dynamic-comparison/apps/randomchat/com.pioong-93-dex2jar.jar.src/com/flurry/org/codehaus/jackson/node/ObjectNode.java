package com.flurry.org.codehaus.jackson.node;

import com.flurry.org.codehaus.jackson.JsonGenerator;
import com.flurry.org.codehaus.jackson.JsonNode;
import com.flurry.org.codehaus.jackson.JsonProcessingException;
import com.flurry.org.codehaus.jackson.JsonToken;
import com.flurry.org.codehaus.jackson.map.SerializerProvider;
import com.flurry.org.codehaus.jackson.map.TypeSerializer;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

public class ObjectNode
  extends ContainerNode
{
  protected LinkedHashMap<String, JsonNode> _children = null;
  
  public ObjectNode(JsonNodeFactory paramJsonNodeFactory)
  {
    super(paramJsonNodeFactory);
  }
  
  private final JsonNode _put(String paramString, JsonNode paramJsonNode)
  {
    if (this._children == null) {
      this._children = new LinkedHashMap();
    }
    return (JsonNode)this._children.put(paramString, paramJsonNode);
  }
  
  public JsonToken asToken()
  {
    return JsonToken.START_OBJECT;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    Object localObject2;
    Object localObject1;
    do
    {
      Iterator localIterator;
      while (!localIterator.hasNext())
      {
        do
        {
          return true;
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
        } while (this._children == null);
        localIterator = this._children.entrySet().iterator();
      }
      localObject2 = (Map.Entry)localIterator.next();
      localObject1 = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (JsonNode)((Map.Entry)localObject2).getValue();
      localObject1 = ((ObjectNode)paramObject).get((String)localObject1);
    } while ((localObject1 != null) && (((JsonNode)localObject1).equals(localObject2)));
    return false;
  }
  
  public ObjectNode findParent(String paramString)
  {
    if (this._children != null)
    {
      Iterator localIterator = this._children.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        if (paramString.equals(((Map.Entry)localObject).getKey())) {
          return this;
        }
        localObject = ((JsonNode)((Map.Entry)localObject).getValue()).findParent(paramString);
        if (localObject != null) {
          return (ObjectNode)localObject;
        }
      }
    }
    return null;
  }
  
  public List<JsonNode> findParents(String paramString, List<JsonNode> paramList)
  {
    Object localObject = paramList;
    if (this._children != null)
    {
      Iterator localIterator = this._children.entrySet().iterator();
      for (;;)
      {
        localObject = paramList;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (Map.Entry)localIterator.next();
        if (paramString.equals(((Map.Entry)localObject).getKey()))
        {
          localObject = paramList;
          if (paramList == null) {
            localObject = new ArrayList();
          }
          ((List)localObject).add(this);
          paramList = (List<JsonNode>)localObject;
        }
        else
        {
          paramList = ((JsonNode)((Map.Entry)localObject).getValue()).findParents(paramString, paramList);
        }
      }
    }
    return (List<JsonNode>)localObject;
  }
  
  public JsonNode findValue(String paramString)
  {
    if (this._children != null)
    {
      Iterator localIterator = this._children.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        if (paramString.equals(((Map.Entry)localObject).getKey())) {
          return (JsonNode)((Map.Entry)localObject).getValue();
        }
        localObject = ((JsonNode)((Map.Entry)localObject).getValue()).findValue(paramString);
        if (localObject != null) {
          return (JsonNode)localObject;
        }
      }
    }
    return null;
  }
  
  public List<JsonNode> findValues(String paramString, List<JsonNode> paramList)
  {
    Object localObject = paramList;
    if (this._children != null)
    {
      Iterator localIterator = this._children.entrySet().iterator();
      for (;;)
      {
        localObject = paramList;
        if (!localIterator.hasNext()) {
          break;
        }
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (paramString.equals(localEntry.getKey()))
        {
          localObject = paramList;
          if (paramList == null) {
            localObject = new ArrayList();
          }
          ((List)localObject).add(localEntry.getValue());
          paramList = (List<JsonNode>)localObject;
        }
        else
        {
          paramList = ((JsonNode)localEntry.getValue()).findValues(paramString, paramList);
        }
      }
    }
    return (List<JsonNode>)localObject;
  }
  
  public List<String> findValuesAsText(String paramString, List<String> paramList)
  {
    Object localObject = paramList;
    if (this._children != null)
    {
      Iterator localIterator = this._children.entrySet().iterator();
      for (;;)
      {
        localObject = paramList;
        if (!localIterator.hasNext()) {
          break;
        }
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (paramString.equals(localEntry.getKey()))
        {
          localObject = paramList;
          if (paramList == null) {
            localObject = new ArrayList();
          }
          ((List)localObject).add(((JsonNode)localEntry.getValue()).asText());
          paramList = (List<String>)localObject;
        }
        else
        {
          paramList = ((JsonNode)localEntry.getValue()).findValuesAsText(paramString, paramList);
        }
      }
    }
    return (List<String>)localObject;
  }
  
  public JsonNode get(int paramInt)
  {
    return null;
  }
  
  public JsonNode get(String paramString)
  {
    if (this._children != null) {
      return (JsonNode)this._children.get(paramString);
    }
    return null;
  }
  
  public Iterator<JsonNode> getElements()
  {
    if (this._children == null) {
      return ContainerNode.NoNodesIterator.instance();
    }
    return this._children.values().iterator();
  }
  
  public Iterator<String> getFieldNames()
  {
    if (this._children == null) {
      return ContainerNode.NoStringsIterator.instance();
    }
    return this._children.keySet().iterator();
  }
  
  public Iterator<Map.Entry<String, JsonNode>> getFields()
  {
    if (this._children == null) {
      return NoFieldsIterator.instance;
    }
    return this._children.entrySet().iterator();
  }
  
  public int hashCode()
  {
    if (this._children == null) {
      return -1;
    }
    return this._children.hashCode();
  }
  
  public boolean isObject()
  {
    return true;
  }
  
  public JsonNode path(int paramInt)
  {
    return MissingNode.getInstance();
  }
  
  public JsonNode path(String paramString)
  {
    if (this._children != null)
    {
      paramString = (JsonNode)this._children.get(paramString);
      if (paramString != null) {
        return paramString;
      }
    }
    return MissingNode.getInstance();
  }
  
  public JsonNode put(String paramString, JsonNode paramJsonNode)
  {
    Object localObject = paramJsonNode;
    if (paramJsonNode == null) {
      localObject = nullNode();
    }
    return _put(paramString, (JsonNode)localObject);
  }
  
  public void put(String paramString, double paramDouble)
  {
    _put(paramString, numberNode(paramDouble));
  }
  
  public void put(String paramString, float paramFloat)
  {
    _put(paramString, numberNode(paramFloat));
  }
  
  public void put(String paramString, int paramInt)
  {
    _put(paramString, numberNode(paramInt));
  }
  
  public void put(String paramString, long paramLong)
  {
    _put(paramString, numberNode(paramLong));
  }
  
  public void put(String paramString, Boolean paramBoolean)
  {
    if (paramBoolean == null)
    {
      _put(paramString, nullNode());
      return;
    }
    _put(paramString, booleanNode(paramBoolean.booleanValue()));
  }
  
  public void put(String paramString, Double paramDouble)
  {
    if (paramDouble == null)
    {
      _put(paramString, nullNode());
      return;
    }
    _put(paramString, numberNode(paramDouble.doubleValue()));
  }
  
  public void put(String paramString, Float paramFloat)
  {
    if (paramFloat == null)
    {
      _put(paramString, nullNode());
      return;
    }
    _put(paramString, numberNode(paramFloat.floatValue()));
  }
  
  public void put(String paramString, Integer paramInteger)
  {
    if (paramInteger == null)
    {
      _put(paramString, nullNode());
      return;
    }
    _put(paramString, numberNode(paramInteger.intValue()));
  }
  
  public void put(String paramString, Long paramLong)
  {
    if (paramLong == null)
    {
      _put(paramString, nullNode());
      return;
    }
    _put(paramString, numberNode(paramLong.longValue()));
  }
  
  public void put(String paramString1, String paramString2)
  {
    if (paramString2 == null)
    {
      putNull(paramString1);
      return;
    }
    _put(paramString1, textNode(paramString2));
  }
  
  public void put(String paramString, BigDecimal paramBigDecimal)
  {
    if (paramBigDecimal == null)
    {
      putNull(paramString);
      return;
    }
    _put(paramString, numberNode(paramBigDecimal));
  }
  
  public void put(String paramString, boolean paramBoolean)
  {
    _put(paramString, booleanNode(paramBoolean));
  }
  
  public void put(String paramString, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      _put(paramString, nullNode());
      return;
    }
    _put(paramString, binaryNode(paramArrayOfByte));
  }
  
  public JsonNode putAll(ObjectNode paramObjectNode)
  {
    int i = paramObjectNode.size();
    if (i > 0)
    {
      if (this._children == null) {
        this._children = new LinkedHashMap(i);
      }
      paramObjectNode.putContentsTo(this._children);
    }
    return this;
  }
  
  public JsonNode putAll(Map<String, JsonNode> paramMap)
  {
    if (this._children == null) {
      this._children = new LinkedHashMap(paramMap);
    }
    for (;;)
    {
      return this;
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        JsonNode localJsonNode = (JsonNode)localEntry.getValue();
        paramMap = localJsonNode;
        if (localJsonNode == null) {
          paramMap = nullNode();
        }
        this._children.put(localEntry.getKey(), paramMap);
      }
    }
  }
  
  public ArrayNode putArray(String paramString)
  {
    ArrayNode localArrayNode = arrayNode();
    _put(paramString, localArrayNode);
    return localArrayNode;
  }
  
  protected void putContentsTo(Map<String, JsonNode> paramMap)
  {
    if (this._children != null)
    {
      Iterator localIterator = this._children.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        paramMap.put(localEntry.getKey(), localEntry.getValue());
      }
    }
  }
  
  public void putNull(String paramString)
  {
    _put(paramString, nullNode());
  }
  
  public ObjectNode putObject(String paramString)
  {
    ObjectNode localObjectNode = objectNode();
    _put(paramString, localObjectNode);
    return localObjectNode;
  }
  
  public void putPOJO(String paramString, Object paramObject)
  {
    _put(paramString, POJONode(paramObject));
  }
  
  public JsonNode remove(String paramString)
  {
    if (this._children != null) {
      return (JsonNode)this._children.remove(paramString);
    }
    return null;
  }
  
  public ObjectNode remove(Collection<String> paramCollection)
  {
    if (this._children != null)
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        String str = (String)paramCollection.next();
        this._children.remove(str);
      }
    }
    return this;
  }
  
  public ObjectNode removeAll()
  {
    this._children = null;
    return this;
  }
  
  public ObjectNode retain(Collection<String> paramCollection)
  {
    if (this._children != null)
    {
      Iterator localIterator = this._children.entrySet().iterator();
      while (localIterator.hasNext()) {
        if (!paramCollection.contains(((Map.Entry)localIterator.next()).getKey())) {
          localIterator.remove();
        }
      }
    }
    return this;
  }
  
  public ObjectNode retain(String... paramVarArgs)
  {
    return retain(Arrays.asList(paramVarArgs));
  }
  
  public final void serialize(JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException, JsonProcessingException
  {
    paramJsonGenerator.writeStartObject();
    if (this._children != null)
    {
      Iterator localIterator = this._children.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        paramJsonGenerator.writeFieldName((String)localEntry.getKey());
        ((BaseJsonNode)localEntry.getValue()).serialize(paramJsonGenerator, paramSerializerProvider);
      }
    }
    paramJsonGenerator.writeEndObject();
  }
  
  public void serializeWithType(JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider, TypeSerializer paramTypeSerializer)
    throws IOException, JsonProcessingException
  {
    paramTypeSerializer.writeTypePrefixForObject(this, paramJsonGenerator);
    if (this._children != null)
    {
      Iterator localIterator = this._children.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        paramJsonGenerator.writeFieldName((String)localEntry.getKey());
        ((BaseJsonNode)localEntry.getValue()).serialize(paramJsonGenerator, paramSerializerProvider);
      }
    }
    paramTypeSerializer.writeTypeSuffixForObject(this, paramJsonGenerator);
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
      int i = 0;
      Iterator localIterator = this._children.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (i > 0) {
          localStringBuilder.append(",");
        }
        i += 1;
        TextNode.appendQuoted(localStringBuilder, (String)localEntry.getKey());
        localStringBuilder.append(':');
        localStringBuilder.append(((JsonNode)localEntry.getValue()).toString());
      }
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public ObjectNode with(String paramString)
  {
    if (this._children == null) {
      this._children = new LinkedHashMap();
    }
    Object localObject;
    do
    {
      localObject = objectNode();
      this._children.put(paramString, localObject);
      return (ObjectNode)localObject;
      localObject = (JsonNode)this._children.get(paramString);
    } while (localObject == null);
    if ((localObject instanceof ObjectNode)) {
      return (ObjectNode)localObject;
    }
    throw new UnsupportedOperationException("Property '" + paramString + "' has value that is not of type ObjectNode (but " + localObject.getClass().getName() + ")");
  }
  
  protected static class NoFieldsIterator
    implements Iterator<Map.Entry<String, JsonNode>>
  {
    static final NoFieldsIterator instance = new NoFieldsIterator();
    
    public boolean hasNext()
    {
      return false;
    }
    
    public Map.Entry<String, JsonNode> next()
    {
      throw new NoSuchElementException();
    }
    
    public void remove()
    {
      throw new IllegalStateException();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/node/ObjectNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */