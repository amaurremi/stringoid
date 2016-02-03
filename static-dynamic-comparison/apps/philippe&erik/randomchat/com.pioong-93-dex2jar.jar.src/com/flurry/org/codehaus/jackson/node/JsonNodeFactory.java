package com.flurry.org.codehaus.jackson.node;

import java.math.BigDecimal;
import java.math.BigInteger;

public class JsonNodeFactory
{
  public static final JsonNodeFactory instance = new JsonNodeFactory();
  
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
  
  public BinaryNode binaryNode(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return BinaryNode.valueOf(paramArrayOfByte, paramInt1, paramInt2);
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
  
  public NumericNode numberNode(byte paramByte)
  {
    return IntNode.valueOf(paramByte);
  }
  
  public NumericNode numberNode(double paramDouble)
  {
    return DoubleNode.valueOf(paramDouble);
  }
  
  public NumericNode numberNode(float paramFloat)
  {
    return DoubleNode.valueOf(paramFloat);
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
    return DecimalNode.valueOf(paramBigDecimal);
  }
  
  public NumericNode numberNode(BigInteger paramBigInteger)
  {
    return BigIntegerNode.valueOf(paramBigInteger);
  }
  
  public NumericNode numberNode(short paramShort)
  {
    return IntNode.valueOf(paramShort);
  }
  
  public ValueNode numberNode(Byte paramByte)
  {
    if (paramByte == null) {
      return nullNode();
    }
    return IntNode.valueOf(paramByte.intValue());
  }
  
  public ValueNode numberNode(Double paramDouble)
  {
    if (paramDouble == null) {
      return nullNode();
    }
    return DoubleNode.valueOf(paramDouble.doubleValue());
  }
  
  public ValueNode numberNode(Float paramFloat)
  {
    if (paramFloat == null) {
      return nullNode();
    }
    return DoubleNode.valueOf(paramFloat.doubleValue());
  }
  
  public ValueNode numberNode(Integer paramInteger)
  {
    if (paramInteger == null) {
      return nullNode();
    }
    return IntNode.valueOf(paramInteger.intValue());
  }
  
  public ValueNode numberNode(Long paramLong)
  {
    if (paramLong == null) {
      return nullNode();
    }
    return LongNode.valueOf(paramLong.longValue());
  }
  
  public ValueNode numberNode(Short paramShort)
  {
    if (paramShort == null) {
      return nullNode();
    }
    return IntNode.valueOf(paramShort.shortValue());
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/node/JsonNodeFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */