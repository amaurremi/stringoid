package org.codehaus.jackson.node;

import java.math.BigDecimal;
import java.util.List;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonToken;

public abstract class ContainerNode
  extends BaseJsonNode
{
  JsonNodeFactory _nodeFactory;
  
  protected ContainerNode(JsonNodeFactory paramJsonNodeFactory)
  {
    this._nodeFactory = paramJsonNodeFactory;
  }
  
  public final POJONode POJONode(Object paramObject)
  {
    return this._nodeFactory.POJONode(paramObject);
  }
  
  public final ArrayNode arrayNode()
  {
    return this._nodeFactory.arrayNode();
  }
  
  public String asText()
  {
    return "";
  }
  
  public abstract JsonToken asToken();
  
  public final BinaryNode binaryNode(byte[] paramArrayOfByte)
  {
    return this._nodeFactory.binaryNode(paramArrayOfByte);
  }
  
  public final BinaryNode binaryNode(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return this._nodeFactory.binaryNode(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public final BooleanNode booleanNode(boolean paramBoolean)
  {
    return this._nodeFactory.booleanNode(paramBoolean);
  }
  
  public abstract ObjectNode findParent(String paramString);
  
  public abstract List findParents(String paramString, List paramList);
  
  public abstract JsonNode findValue(String paramString);
  
  public abstract List findValues(String paramString, List paramList);
  
  public abstract List findValuesAsText(String paramString, List paramList);
  
  public abstract JsonNode get(int paramInt);
  
  public abstract JsonNode get(String paramString);
  
  public String getValueAsText()
  {
    return null;
  }
  
  public boolean isContainerNode()
  {
    return true;
  }
  
  public final NullNode nullNode()
  {
    return this._nodeFactory.nullNode();
  }
  
  public final NumericNode numberNode(byte paramByte)
  {
    return this._nodeFactory.numberNode(paramByte);
  }
  
  public final NumericNode numberNode(double paramDouble)
  {
    return this._nodeFactory.numberNode(paramDouble);
  }
  
  public final NumericNode numberNode(float paramFloat)
  {
    return this._nodeFactory.numberNode(paramFloat);
  }
  
  public final NumericNode numberNode(int paramInt)
  {
    return this._nodeFactory.numberNode(paramInt);
  }
  
  public final NumericNode numberNode(long paramLong)
  {
    return this._nodeFactory.numberNode(paramLong);
  }
  
  public final NumericNode numberNode(BigDecimal paramBigDecimal)
  {
    return this._nodeFactory.numberNode(paramBigDecimal);
  }
  
  public final NumericNode numberNode(short paramShort)
  {
    return this._nodeFactory.numberNode(paramShort);
  }
  
  public final ObjectNode objectNode()
  {
    return this._nodeFactory.objectNode();
  }
  
  public abstract ContainerNode removeAll();
  
  public abstract int size();
  
  public final TextNode textNode(String paramString)
  {
    return this._nodeFactory.textNode(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/node/ContainerNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */