package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.io.CharTypes;

public final class TextNode
  extends ValueNode
{
  static final TextNode EMPTY_STRING_NODE = new TextNode("");
  final String _value;
  
  public TextNode(String paramString)
  {
    this._value = paramString;
  }
  
  protected static void appendQuoted(StringBuilder paramStringBuilder, String paramString)
  {
    paramStringBuilder.append('"');
    CharTypes.appendQuoted(paramStringBuilder, paramString);
    paramStringBuilder.append('"');
  }
  
  public static TextNode valueOf(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    if (paramString.length() == 0) {
      return EMPTY_STRING_NODE;
    }
    return new TextNode(paramString);
  }
  
  public String asText()
  {
    return this._value;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramObject == this) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramObject == null);
      bool1 = bool2;
    } while (paramObject.getClass() != getClass());
    return ((TextNode)paramObject)._value.equals(this._value);
  }
  
  public int hashCode()
  {
    return this._value.hashCode();
  }
  
  public String toString()
  {
    int i = this._value.length();
    StringBuilder localStringBuilder = new StringBuilder((i >> 4) + (i + 2));
    appendQuoted(localStringBuilder, this._value);
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/node/TextNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */