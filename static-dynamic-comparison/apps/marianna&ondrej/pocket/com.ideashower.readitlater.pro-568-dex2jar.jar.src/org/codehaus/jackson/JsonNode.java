package org.codehaus.jackson;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class JsonNode
  implements Iterable
{
  protected static final List NO_NODES = ;
  protected static final List NO_STRINGS = Collections.emptyList();
  
  public boolean asBoolean()
  {
    return asBoolean(false);
  }
  
  public boolean asBoolean(boolean paramBoolean)
  {
    return paramBoolean;
  }
  
  public double asDouble()
  {
    return asDouble(0.0D);
  }
  
  public double asDouble(double paramDouble)
  {
    return paramDouble;
  }
  
  public int asInt()
  {
    return asInt(0);
  }
  
  public int asInt(int paramInt)
  {
    return paramInt;
  }
  
  public long asLong()
  {
    return asLong(0L);
  }
  
  public long asLong(long paramLong)
  {
    return paramLong;
  }
  
  public abstract String asText();
  
  public abstract JsonToken asToken();
  
  public abstract boolean equals(Object paramObject);
  
  public abstract JsonNode findParent(String paramString);
  
  public final List findParents(String paramString)
  {
    List localList = findParents(paramString, null);
    paramString = localList;
    if (localList == null) {
      paramString = Collections.emptyList();
    }
    return paramString;
  }
  
  public abstract List findParents(String paramString, List paramList);
  
  public abstract JsonNode findPath(String paramString);
  
  public abstract JsonNode findValue(String paramString);
  
  public final List findValues(String paramString)
  {
    List localList = findValues(paramString, null);
    paramString = localList;
    if (localList == null) {
      paramString = Collections.emptyList();
    }
    return paramString;
  }
  
  public abstract List findValues(String paramString, List paramList);
  
  public final List findValuesAsText(String paramString)
  {
    List localList = findValuesAsText(paramString, null);
    paramString = localList;
    if (localList == null) {
      paramString = Collections.emptyList();
    }
    return paramString;
  }
  
  public abstract List findValuesAsText(String paramString, List paramList);
  
  public JsonNode get(int paramInt)
  {
    return null;
  }
  
  public JsonNode get(String paramString)
  {
    return null;
  }
  
  public BigInteger getBigIntegerValue()
  {
    return BigInteger.ZERO;
  }
  
  public byte[] getBinaryValue()
  {
    return null;
  }
  
  public boolean getBooleanValue()
  {
    return false;
  }
  
  public BigDecimal getDecimalValue()
  {
    return BigDecimal.ZERO;
  }
  
  public double getDoubleValue()
  {
    return 0.0D;
  }
  
  public Iterator getElements()
  {
    return NO_NODES.iterator();
  }
  
  public Iterator getFieldNames()
  {
    return NO_STRINGS.iterator();
  }
  
  public Iterator getFields()
  {
    return Collections.emptyList().iterator();
  }
  
  public int getIntValue()
  {
    return 0;
  }
  
  public long getLongValue()
  {
    return 0L;
  }
  
  public abstract JsonParser.NumberType getNumberType();
  
  public Number getNumberValue()
  {
    return null;
  }
  
  @Deprecated
  public final JsonNode getPath(int paramInt)
  {
    return path(paramInt);
  }
  
  @Deprecated
  public final JsonNode getPath(String paramString)
  {
    return path(paramString);
  }
  
  public String getTextValue()
  {
    return null;
  }
  
  @Deprecated
  public boolean getValueAsBoolean()
  {
    return asBoolean(false);
  }
  
  @Deprecated
  public boolean getValueAsBoolean(boolean paramBoolean)
  {
    return asBoolean(paramBoolean);
  }
  
  @Deprecated
  public double getValueAsDouble()
  {
    return asDouble(0.0D);
  }
  
  @Deprecated
  public double getValueAsDouble(double paramDouble)
  {
    return asDouble(paramDouble);
  }
  
  @Deprecated
  public int getValueAsInt()
  {
    return asInt(0);
  }
  
  @Deprecated
  public int getValueAsInt(int paramInt)
  {
    return asInt(paramInt);
  }
  
  @Deprecated
  public long getValueAsLong()
  {
    return asLong(0L);
  }
  
  @Deprecated
  public long getValueAsLong(long paramLong)
  {
    return asLong(paramLong);
  }
  
  @Deprecated
  public String getValueAsText()
  {
    return asText();
  }
  
  public boolean has(int paramInt)
  {
    return get(paramInt) != null;
  }
  
  public boolean has(String paramString)
  {
    return get(paramString) != null;
  }
  
  public boolean isArray()
  {
    return false;
  }
  
  public boolean isBigDecimal()
  {
    return false;
  }
  
  public boolean isBigInteger()
  {
    return false;
  }
  
  public boolean isBinary()
  {
    return false;
  }
  
  public boolean isBoolean()
  {
    return false;
  }
  
  public boolean isContainerNode()
  {
    return false;
  }
  
  public boolean isDouble()
  {
    return false;
  }
  
  public boolean isFloatingPointNumber()
  {
    return false;
  }
  
  public boolean isInt()
  {
    return false;
  }
  
  public boolean isIntegralNumber()
  {
    return false;
  }
  
  public boolean isLong()
  {
    return false;
  }
  
  public boolean isMissingNode()
  {
    return false;
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  public boolean isNumber()
  {
    return false;
  }
  
  public boolean isObject()
  {
    return false;
  }
  
  public boolean isPojo()
  {
    return false;
  }
  
  public boolean isTextual()
  {
    return false;
  }
  
  public boolean isValueNode()
  {
    return false;
  }
  
  public final Iterator iterator()
  {
    return getElements();
  }
  
  public abstract JsonNode path(int paramInt);
  
  public abstract JsonNode path(String paramString);
  
  public int size()
  {
    return 0;
  }
  
  public abstract String toString();
  
  public abstract JsonParser traverse();
  
  public JsonNode with(String paramString)
  {
    throw new UnsupportedOperationException("JsonNode not of type ObjectNode (but " + getClass().getName() + "), can not call with() on it");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/JsonNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */