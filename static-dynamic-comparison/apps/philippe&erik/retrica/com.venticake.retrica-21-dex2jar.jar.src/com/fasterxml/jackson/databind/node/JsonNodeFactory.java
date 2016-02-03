package com.fasterxml.jackson.databind.node;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

public class JsonNodeFactory
  implements Serializable
{
  private static final JsonNodeFactory decimalsAsIs = new JsonNodeFactory(true);
  private static final JsonNodeFactory decimalsNormalized = new JsonNodeFactory(false);
  public static final JsonNodeFactory instance = decimalsNormalized;
  private final boolean _cfgBigDecimalExact;
  
  protected JsonNodeFactory()
  {
    this(false);
  }
  
  protected JsonNodeFactory(boolean paramBoolean)
  {
    this._cfgBigDecimalExact = paramBoolean;
  }
  
  public POJONode POJONode(Object paramObject)
  {
    return new POJONode(paramObject);
  }
  
  public ArrayNode arrayNode()
  {
    return new ArrayNode(this);
  }
  
  public BinaryNode binaryNode(byte[] paramArrayOfByte)
  {
    return BinaryNode.valueOf(paramArrayOfByte);
  }
  
  public BooleanNode booleanNode(boolean paramBoolean)
  {
    if (paramBoolean) {
      return BooleanNode.getTrue();
    }
    return BooleanNode.getFalse();
  }
  
  public NullNode nullNode()
  {
    return NullNode.getInstance();
  }
  
  public NumericNode numberNode(double paramDouble)
  {
    return DoubleNode.valueOf(paramDouble);
  }
  
  public NumericNode numberNode(int paramInt)
  {
    return IntNode.valueOf(paramInt);
  }
  
  public NumericNode numberNode(long paramLong)
  {
    return LongNode.valueOf(paramLong);
  }
  
  public NumericNode numberNode(BigDecimal paramBigDecimal)
  {
    if (this._cfgBigDecimalExact) {}
    for (;;)
    {
      return DecimalNode.valueOf(paramBigDecimal);
      paramBigDecimal = paramBigDecimal.stripTrailingZeros();
    }
  }
  
  public NumericNode numberNode(BigInteger paramBigInteger)
  {
    return BigIntegerNode.valueOf(paramBigInteger);
  }
  
  public ObjectNode objectNode()
  {
    return new ObjectNode(this);
  }
  
  public TextNode textNode(String paramString)
  {
    return TextNode.valueOf(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/node/JsonNodeFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */