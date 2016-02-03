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
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class ArrayNode
  extends ContainerNode
{
  protected ArrayList<JsonNode> _children;
  
  public ArrayNode(JsonNodeFactory paramJsonNodeFactory)
  {
    super(paramJsonNodeFactory);
  }
  
  private void _add(JsonNode paramJsonNode)
  {
    if (this._children == null) {
      this._children = new ArrayList();
    }
    this._children.add(paramJsonNode);
  }
  
  private void _insert(int paramInt, JsonNode paramJsonNode)
  {
    if (this._children == null)
    {
      this._children = new ArrayList();
      this._children.add(paramJsonNode);
      return;
    }
    if (paramInt < 0)
    {
      this._children.add(0, paramJsonNode);
      return;
    }
    if (paramInt >= this._children.size())
    {
      this._children.add(paramJsonNode);
      return;
    }
    this._children.add(paramInt, paramJsonNode);
  }
  
  private boolean _sameChildren(ArrayList<JsonNode> paramArrayList)
  {
    int j = paramArrayList.size();
    if (size() != j) {
      return false;
    }
    int i = 0;
    while (i < j)
    {
      if (!((JsonNode)this._children.get(i)).equals(paramArrayList.get(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public JsonNode _set(int paramInt, JsonNode paramJsonNode)
  {
    if ((this._children == null) || (paramInt < 0) || (paramInt >= this._children.size())) {
      throw new IndexOutOfBoundsException("Illegal index " + paramInt + ", array size " + size());
    }
    return (JsonNode)this._children.set(paramInt, paramJsonNode);
  }
  
  public void add(double paramDouble)
  {
    _add(numberNode(paramDouble));
  }
  
  public void add(float paramFloat)
  {
    _add(numberNode(paramFloat));
  }
  
  public void add(int paramInt)
  {
    _add(numberNode(paramInt));
  }
  
  public void add(long paramLong)
  {
    _add(numberNode(paramLong));
  }
  
  public void add(JsonNode paramJsonNode)
  {
    Object localObject = paramJsonNode;
    if (paramJsonNode == null) {
      localObject = nullNode();
    }
    _add((JsonNode)localObject);
  }
  
  public void add(Boolean paramBoolean)
  {
    if (paramBoolean == null)
    {
      addNull();
      return;
    }
    _add(booleanNode(paramBoolean.booleanValue()));
  }
  
  public void add(Double paramDouble)
  {
    if (paramDouble == null)
    {
      addNull();
      return;
    }
    _add(numberNode(paramDouble.doubleValue()));
  }
  
  public void add(Float paramFloat)
  {
    if (paramFloat == null)
    {
      addNull();
      return;
    }
    _add(numberNode(paramFloat.floatValue()));
  }
  
  public void add(Integer paramInteger)
  {
    if (paramInteger == null)
    {
      addNull();
      return;
    }
    _add(numberNode(paramInteger.intValue()));
  }
  
  public void add(Long paramLong)
  {
    if (paramLong == null)
    {
      addNull();
      return;
    }
    _add(numberNode(paramLong.longValue()));
  }
  
  public void add(String paramString)
  {
    if (paramString == null)
    {
      addNull();
      return;
    }
    _add(textNode(paramString));
  }
  
  public void add(BigDecimal paramBigDecimal)
  {
    if (paramBigDecimal == null)
    {
      addNull();
      return;
    }
    _add(numberNode(paramBigDecimal));
  }
  
  public void add(boolean paramBoolean)
  {
    _add(booleanNode(paramBoolean));
  }
  
  public void add(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      addNull();
      return;
    }
    _add(binaryNode(paramArrayOfByte));
  }
  
  public JsonNode addAll(ArrayNode paramArrayNode)
  {
    int i = paramArrayNode.size();
    if (i > 0)
    {
      if (this._children == null) {
        this._children = new ArrayList(i + 2);
      }
      paramArrayNode.addContentsTo(this._children);
    }
    return this;
  }
  
  public JsonNode addAll(Collection<JsonNode> paramCollection)
  {
    if (paramCollection.size() > 0)
    {
      if (this._children == null) {
        this._children = new ArrayList(paramCollection);
      }
    }
    else {
      return this;
    }
    this._children.addAll(paramCollection);
    return this;
  }
  
  public ArrayNode addArray()
  {
    ArrayNode localArrayNode = arrayNode();
    _add(localArrayNode);
    return localArrayNode;
  }
  
  protected void addContentsTo(List<JsonNode> paramList)
  {
    if (this._children != null)
    {
      Iterator localIterator = this._children.iterator();
      while (localIterator.hasNext()) {
        paramList.add((JsonNode)localIterator.next());
      }
    }
  }
  
  public void addNull()
  {
    _add(nullNode());
  }
  
  public ObjectNode addObject()
  {
    ObjectNode localObjectNode = objectNode();
    _add(localObjectNode);
    return localObjectNode;
  }
  
  public void addPOJO(Object paramObject)
  {
    if (paramObject == null)
    {
      addNull();
      return;
    }
    _add(POJONode(paramObject));
  }
  
  public JsonToken asToken()
  {
    return JsonToken.START_ARRAY;
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
  
  public ObjectNode findParent(String paramString)
  {
    if (this._children != null)
    {
      Iterator localIterator = this._children.iterator();
      while (localIterator.hasNext())
      {
        JsonNode localJsonNode = ((JsonNode)localIterator.next()).findParent(paramString);
        if (localJsonNode != null) {
          return (ObjectNode)localJsonNode;
        }
      }
    }
    return null;
  }
  
  public List<JsonNode> findParents(String paramString, List<JsonNode> paramList)
  {
    List<JsonNode> localList = paramList;
    if (this._children != null)
    {
      Iterator localIterator = this._children.iterator();
      for (;;)
      {
        localList = paramList;
        if (!localIterator.hasNext()) {
          break;
        }
        paramList = ((JsonNode)localIterator.next()).findParents(paramString, paramList);
      }
    }
    return localList;
  }
  
  public JsonNode findValue(String paramString)
  {
    if (this._children != null)
    {
      Iterator localIterator = this._children.iterator();
      while (localIterator.hasNext())
      {
        JsonNode localJsonNode = ((JsonNode)localIterator.next()).findValue(paramString);
        if (localJsonNode != null) {
          return localJsonNode;
        }
      }
    }
    return null;
  }
  
  public List<JsonNode> findValues(String paramString, List<JsonNode> paramList)
  {
    List<JsonNode> localList = paramList;
    if (this._children != null)
    {
      Iterator localIterator = this._children.iterator();
      for (;;)
      {
        localList = paramList;
        if (!localIterator.hasNext()) {
          break;
        }
        paramList = ((JsonNode)localIterator.next()).findValues(paramString, paramList);
      }
    }
    return localList;
  }
  
  public List<String> findValuesAsText(String paramString, List<String> paramList)
  {
    List<String> localList = paramList;
    if (this._children != null)
    {
      Iterator localIterator = this._children.iterator();
      for (;;)
      {
        localList = paramList;
        if (!localIterator.hasNext()) {
          break;
        }
        paramList = ((JsonNode)localIterator.next()).findValuesAsText(paramString, paramList);
      }
    }
    return localList;
  }
  
  public JsonNode get(int paramInt)
  {
    if ((paramInt >= 0) && (this._children != null) && (paramInt < this._children.size())) {
      return (JsonNode)this._children.get(paramInt);
    }
    return null;
  }
  
  public JsonNode get(String paramString)
  {
    return null;
  }
  
  public Iterator<JsonNode> getElements()
  {
    if (this._children == null) {
      return ContainerNode.NoNodesIterator.instance();
    }
    return this._children.iterator();
  }
  
  public int hashCode()
  {
    int j;
    if (this._children == null)
    {
      j = 1;
      return j;
    }
    int i = this._children.size();
    Iterator localIterator = this._children.iterator();
    for (;;)
    {
      j = i;
      if (!localIterator.hasNext()) {
        break;
      }
      JsonNode localJsonNode = (JsonNode)localIterator.next();
      if (localJsonNode != null) {
        i ^= localJsonNode.hashCode();
      }
    }
  }
  
  public void insert(int paramInt, double paramDouble)
  {
    _insert(paramInt, numberNode(paramDouble));
  }
  
  public void insert(int paramInt, float paramFloat)
  {
    _insert(paramInt, numberNode(paramFloat));
  }
  
  public void insert(int paramInt1, int paramInt2)
  {
    _insert(paramInt1, numberNode(paramInt2));
  }
  
  public void insert(int paramInt, long paramLong)
  {
    _insert(paramInt, numberNode(paramLong));
  }
  
  public void insert(int paramInt, JsonNode paramJsonNode)
  {
    Object localObject = paramJsonNode;
    if (paramJsonNode == null) {
      localObject = nullNode();
    }
    _insert(paramInt, (JsonNode)localObject);
  }
  
  public void insert(int paramInt, Boolean paramBoolean)
  {
    if (paramBoolean == null)
    {
      insertNull(paramInt);
      return;
    }
    _insert(paramInt, booleanNode(paramBoolean.booleanValue()));
  }
  
  public void insert(int paramInt, Double paramDouble)
  {
    if (paramDouble == null)
    {
      insertNull(paramInt);
      return;
    }
    _insert(paramInt, numberNode(paramDouble.doubleValue()));
  }
  
  public void insert(int paramInt, Float paramFloat)
  {
    if (paramFloat == null)
    {
      insertNull(paramInt);
      return;
    }
    _insert(paramInt, numberNode(paramFloat.floatValue()));
  }
  
  public void insert(int paramInt, Integer paramInteger)
  {
    if (paramInteger == null)
    {
      insertNull(paramInt);
      return;
    }
    _insert(paramInt, numberNode(paramInteger.intValue()));
  }
  
  public void insert(int paramInt, Long paramLong)
  {
    if (paramLong == null)
    {
      insertNull(paramInt);
      return;
    }
    _insert(paramInt, numberNode(paramLong.longValue()));
  }
  
  public void insert(int paramInt, String paramString)
  {
    if (paramString == null)
    {
      insertNull(paramInt);
      return;
    }
    _insert(paramInt, textNode(paramString));
  }
  
  public void insert(int paramInt, BigDecimal paramBigDecimal)
  {
    if (paramBigDecimal == null)
    {
      insertNull(paramInt);
      return;
    }
    _insert(paramInt, numberNode(paramBigDecimal));
  }
  
  public void insert(int paramInt, boolean paramBoolean)
  {
    _insert(paramInt, booleanNode(paramBoolean));
  }
  
  public void insert(int paramInt, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      insertNull(paramInt);
      return;
    }
    _insert(paramInt, binaryNode(paramArrayOfByte));
  }
  
  public ArrayNode insertArray(int paramInt)
  {
    ArrayNode localArrayNode = arrayNode();
    _insert(paramInt, localArrayNode);
    return localArrayNode;
  }
  
  public void insertNull(int paramInt)
  {
    _insert(paramInt, nullNode());
  }
  
  public ObjectNode insertObject(int paramInt)
  {
    ObjectNode localObjectNode = objectNode();
    _insert(paramInt, localObjectNode);
    return localObjectNode;
  }
  
  public void insertPOJO(int paramInt, Object paramObject)
  {
    if (paramObject == null)
    {
      insertNull(paramInt);
      return;
    }
    _insert(paramInt, POJONode(paramObject));
  }
  
  public boolean isArray()
  {
    return true;
  }
  
  public JsonNode path(int paramInt)
  {
    if ((paramInt >= 0) && (this._children != null) && (paramInt < this._children.size())) {
      return (JsonNode)this._children.get(paramInt);
    }
    return MissingNode.getInstance();
  }
  
  public JsonNode path(String paramString)
  {
    return MissingNode.getInstance();
  }
  
  public JsonNode remove(int paramInt)
  {
    if ((paramInt >= 0) && (this._children != null) && (paramInt < this._children.size())) {
      return (JsonNode)this._children.remove(paramInt);
    }
    return null;
  }
  
  public ArrayNode removeAll()
  {
    this._children = null;
    return this;
  }
  
  public final void serialize(JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException, JsonProcessingException
  {
    paramJsonGenerator.writeStartArray();
    if (this._children != null)
    {
      Iterator localIterator = this._children.iterator();
      while (localIterator.hasNext()) {
        ((BaseJsonNode)localIterator.next()).serialize(paramJsonGenerator, paramSerializerProvider);
      }
    }
    paramJsonGenerator.writeEndArray();
  }
  
  public void serializeWithType(JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider, TypeSerializer paramTypeSerializer)
    throws IOException, JsonProcessingException
  {
    paramTypeSerializer.writeTypePrefixForArray(this, paramJsonGenerator);
    if (this._children != null)
    {
      Iterator localIterator = this._children.iterator();
      while (localIterator.hasNext()) {
        ((BaseJsonNode)localIterator.next()).serialize(paramJsonGenerator, paramSerializerProvider);
      }
    }
    paramTypeSerializer.writeTypeSuffixForArray(this, paramJsonGenerator);
  }
  
  public JsonNode set(int paramInt, JsonNode paramJsonNode)
  {
    Object localObject = paramJsonNode;
    if (paramJsonNode == null) {
      localObject = nullNode();
    }
    return _set(paramInt, (JsonNode)localObject);
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
      int i = 0;
      int j = this._children.size();
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/node/ArrayNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */