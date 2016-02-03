package org.codehaus.jackson.node;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.TypeSerializer;

public class ObjectNode
  extends ContainerNode
{
  protected LinkedHashMap _children = null;
  
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
  
  public List findParents(String paramString, List paramList)
  {
    Object localObject;
    if (this._children != null)
    {
      Iterator localIterator = this._children.entrySet().iterator();
      localObject = paramList;
      if (!localIterator.hasNext()) {
        break label100;
      }
      localObject = (Map.Entry)localIterator.next();
      if (paramString.equals(((Map.Entry)localObject).getKey()))
      {
        if (paramList != null) {
          break label102;
        }
        paramList = new ArrayList();
      }
    }
    label100:
    label102:
    for (;;)
    {
      paramList.add(this);
      for (;;)
      {
        break;
        paramList = ((JsonNode)((Map.Entry)localObject).getValue()).findParents(paramString, paramList);
      }
      localObject = paramList;
      return (List)localObject;
    }
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
  
  public List findValues(String paramString, List paramList)
  {
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
          paramList = (List)localObject;
        }
        else
        {
          paramList = ((JsonNode)localEntry.getValue()).findValues(paramString, paramList);
        }
      }
    }
    Object localObject = paramList;
    return (List)localObject;
  }
  
  public List findValuesAsText(String paramString, List paramList)
  {
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
          paramList = (List)localObject;
        }
        else
        {
          paramList = ((JsonNode)localEntry.getValue()).findValuesAsText(paramString, paramList);
        }
      }
    }
    Object localObject = paramList;
    return (List)localObject;
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
  
  public Iterator getElements()
  {
    if (this._children == null) {
      return ContainerNode.NoNodesIterator.instance();
    }
    return this._children.values().iterator();
  }
  
  public Iterator getFieldNames()
  {
    if (this._children == null) {
      return ContainerNode.NoStringsIterator.instance();
    }
    return this._children.keySet().iterator();
  }
  
  public Iterator getFields()
  {
    if (this._children == null) {
      return ObjectNode.NoFieldsIterator.instance;
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
  
  public JsonNode putAll(Map paramMap)
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
  
  public ArrayNode putArray(String paramString)
  {
    ArrayNode localArrayNode = arrayNode();
    _put(paramString, localArrayNode);
    return localArrayNode;
  }
  
  protected void putContentsTo(Map paramMap)
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
  
  public ObjectNode remove(Collection paramCollection)
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
  
  public ObjectNode retain(Collection paramCollection)
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
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/node/ObjectNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */