package org.codehaus.jackson.node;

import org.codehaus.jackson.Base64Variant;
import org.codehaus.jackson.Base64Variants;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonLocation;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.io.NumberInput;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.util.ByteArrayBuilder;
import org.codehaus.jackson.util.CharTypes;

public final class TextNode
  extends ValueNode
{
  static final TextNode EMPTY_STRING_NODE = new TextNode("");
  static final int INT_SPACE = 32;
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
  
  protected void _reportBase64EOF()
  {
    throw new JsonParseException("Unexpected end-of-String when base64 content", JsonLocation.NA);
  }
  
  protected void _reportInvalidBase64(Base64Variant paramBase64Variant, char paramChar, int paramInt)
  {
    _reportInvalidBase64(paramBase64Variant, paramChar, paramInt, null);
  }
  
  protected void _reportInvalidBase64(Base64Variant paramBase64Variant, char paramChar, int paramInt, String paramString)
  {
    if (paramChar <= ' ') {
      paramBase64Variant = "Illegal white space character (code 0x" + Integer.toHexString(paramChar) + ") as character #" + (paramInt + 1) + " of 4-char base64 unit: can only used between units";
    }
    for (;;)
    {
      Object localObject = paramBase64Variant;
      if (paramString != null) {
        localObject = paramBase64Variant + ": " + paramString;
      }
      throw new JsonParseException((String)localObject, JsonLocation.NA);
      if (paramBase64Variant.usesPaddingChar(paramChar)) {
        paramBase64Variant = "Unexpected padding character ('" + paramBase64Variant.getPaddingChar() + "') as character #" + (paramInt + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character";
      } else if ((!Character.isDefined(paramChar)) || (Character.isISOControl(paramChar))) {
        paramBase64Variant = "Illegal character (code 0x" + Integer.toHexString(paramChar) + ") in base64 content";
      } else {
        paramBase64Variant = "Illegal character '" + paramChar + "' (code 0x" + Integer.toHexString(paramChar) + ") in base64 content";
      }
    }
  }
  
  public boolean asBoolean(boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (this._value != null)
    {
      bool = paramBoolean;
      if ("true".equals(this._value.trim())) {
        bool = true;
      }
    }
    return bool;
  }
  
  public double asDouble(double paramDouble)
  {
    return NumberInput.parseAsDouble(this._value, paramDouble);
  }
  
  public int asInt(int paramInt)
  {
    return NumberInput.parseAsInt(this._value, paramInt);
  }
  
  public long asLong(long paramLong)
  {
    return NumberInput.parseAsLong(this._value, paramLong);
  }
  
  public String asText()
  {
    return this._value;
  }
  
  public JsonToken asToken()
  {
    return JsonToken.VALUE_STRING;
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
  
  public byte[] getBinaryValue()
  {
    return getBinaryValue(Base64Variants.getDefaultVariant());
  }
  
  public byte[] getBinaryValue(Base64Variant paramBase64Variant)
  {
    ByteArrayBuilder localByteArrayBuilder = new ByteArrayBuilder(100);
    String str = this._value;
    int k = str.length();
    int i = 0;
    if (i < k) {}
    for (;;)
    {
      int j = i + 1;
      char c = str.charAt(i);
      if (j >= k) {}
      int m;
      for (;;)
      {
        return localByteArrayBuilder.toByteArray();
        if (c <= ' ') {
          break label383;
        }
        m = paramBase64Variant.decodeBase64Char(c);
        if (m < 0) {
          _reportInvalidBase64(paramBase64Variant, c, 0);
        }
        if (j >= k) {
          _reportBase64EOF();
        }
        i = j + 1;
        c = str.charAt(j);
        j = paramBase64Variant.decodeBase64Char(c);
        if (j < 0) {
          _reportInvalidBase64(paramBase64Variant, c, 1);
        }
        m = m << 6 | j;
        if (i >= k)
        {
          if (!paramBase64Variant.usesPadding()) {
            localByteArrayBuilder.append(m >> 4);
          } else {
            _reportBase64EOF();
          }
        }
        else
        {
          j = i + 1;
          c = str.charAt(i);
          i = paramBase64Variant.decodeBase64Char(c);
          if (i < 0)
          {
            if (i != -2) {
              _reportInvalidBase64(paramBase64Variant, c, 2);
            }
            if (j >= k) {
              _reportBase64EOF();
            }
            i = j + 1;
            c = str.charAt(j);
            if (!paramBase64Variant.usesPaddingChar(c)) {
              _reportInvalidBase64(paramBase64Variant, c, 3, "expected padding character '" + paramBase64Variant.getPaddingChar() + "'");
            }
            localByteArrayBuilder.append(m >> 4);
            break;
          }
          m = m << 6 | i;
          if (j < k) {
            break label316;
          }
          if (paramBase64Variant.usesPadding()) {
            break label312;
          }
          localByteArrayBuilder.appendTwoBytes(m >> 2);
        }
      }
      label312:
      _reportBase64EOF();
      label316:
      i = j + 1;
      c = str.charAt(j);
      j = paramBase64Variant.decodeBase64Char(c);
      if (j < 0)
      {
        if (j != -2) {
          _reportInvalidBase64(paramBase64Variant, c, 3);
        }
        localByteArrayBuilder.appendTwoBytes(m >> 2);
        break;
      }
      localByteArrayBuilder.appendThreeBytes(m << 6 | j);
      break;
      label383:
      i = j;
    }
  }
  
  public String getTextValue()
  {
    return this._value;
  }
  
  public int hashCode()
  {
    return this._value.hashCode();
  }
  
  public boolean isTextual()
  {
    return true;
  }
  
  public final void serialize(JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
  {
    if (this._value == null)
    {
      paramJsonGenerator.writeNull();
      return;
    }
    paramJsonGenerator.writeString(this._value);
  }
  
  public String toString()
  {
    int i = this._value.length();
    StringBuilder localStringBuilder = new StringBuilder((i >> 4) + (i + 2));
    appendQuoted(localStringBuilder, this._value);
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/node/TextNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */