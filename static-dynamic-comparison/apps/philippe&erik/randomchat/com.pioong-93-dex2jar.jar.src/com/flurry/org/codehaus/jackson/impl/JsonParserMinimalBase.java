package com.flurry.org.codehaus.jackson.impl;

import com.flurry.org.codehaus.jackson.Base64Variant;
import com.flurry.org.codehaus.jackson.JsonParseException;
import com.flurry.org.codehaus.jackson.JsonParser;
import com.flurry.org.codehaus.jackson.JsonParser.Feature;
import com.flurry.org.codehaus.jackson.JsonProcessingException;
import com.flurry.org.codehaus.jackson.JsonStreamContext;
import com.flurry.org.codehaus.jackson.JsonToken;
import com.flurry.org.codehaus.jackson.io.NumberInput;
import com.flurry.org.codehaus.jackson.util.ByteArrayBuilder;
import java.io.IOException;

public abstract class JsonParserMinimalBase
  extends JsonParser
{
  protected static final int INT_APOSTROPHE = 39;
  protected static final int INT_ASTERISK = 42;
  protected static final int INT_BACKSLASH = 92;
  protected static final int INT_COLON = 58;
  protected static final int INT_COMMA = 44;
  protected static final int INT_CR = 13;
  protected static final int INT_LBRACKET = 91;
  protected static final int INT_LCURLY = 123;
  protected static final int INT_LF = 10;
  protected static final int INT_QUOTE = 34;
  protected static final int INT_RBRACKET = 93;
  protected static final int INT_RCURLY = 125;
  protected static final int INT_SLASH = 47;
  protected static final int INT_SPACE = 32;
  protected static final int INT_TAB = 9;
  protected static final int INT_b = 98;
  protected static final int INT_f = 102;
  protected static final int INT_n = 110;
  protected static final int INT_r = 114;
  protected static final int INT_t = 116;
  protected static final int INT_u = 117;
  
  protected JsonParserMinimalBase() {}
  
  protected JsonParserMinimalBase(int paramInt)
  {
    super(paramInt);
  }
  
  protected static final String _getCharDesc(int paramInt)
  {
    char c = (char)paramInt;
    if (Character.isISOControl(c)) {
      return "(CTRL-CHAR, code " + paramInt + ")";
    }
    if (paramInt > 255) {
      return "'" + c + "' (code " + paramInt + " / 0x" + Integer.toHexString(paramInt) + ")";
    }
    return "'" + c + "' (code " + paramInt + ")";
  }
  
  protected final JsonParseException _constructError(String paramString, Throwable paramThrowable)
  {
    return new JsonParseException(paramString, getCurrentLocation(), paramThrowable);
  }
  
  protected void _decodeBase64(String paramString, ByteArrayBuilder paramByteArrayBuilder, Base64Variant paramBase64Variant)
    throws IOException, JsonParseException
  {
    int i = 0;
    int k = paramString.length();
    if (i < k) {}
    for (;;)
    {
      int j = i + 1;
      char c = paramString.charAt(i);
      if (j >= k) {
        return;
      }
      if (c > ' ')
      {
        int m = paramBase64Variant.decodeBase64Char(c);
        if (m < 0) {
          _reportInvalidBase64(paramBase64Variant, c, 0, null);
        }
        if (j >= k) {
          _reportBase64EOF();
        }
        i = j + 1;
        c = paramString.charAt(j);
        j = paramBase64Variant.decodeBase64Char(c);
        if (j < 0) {
          _reportInvalidBase64(paramBase64Variant, c, 1, null);
        }
        m = m << 6 | j;
        if (i >= k)
        {
          if (!paramBase64Variant.usesPadding())
          {
            paramByteArrayBuilder.append(m >> 4);
            return;
          }
          _reportBase64EOF();
        }
        j = i + 1;
        c = paramString.charAt(i);
        i = paramBase64Variant.decodeBase64Char(c);
        if (i < 0)
        {
          if (i != -2) {
            _reportInvalidBase64(paramBase64Variant, c, 2, null);
          }
          if (j >= k) {
            _reportBase64EOF();
          }
          i = j + 1;
          c = paramString.charAt(j);
          if (!paramBase64Variant.usesPaddingChar(c)) {
            _reportInvalidBase64(paramBase64Variant, c, 3, "expected padding character '" + paramBase64Variant.getPaddingChar() + "'");
          }
          paramByteArrayBuilder.append(m >> 4);
          break;
        }
        m = m << 6 | i;
        if (j >= k)
        {
          if (!paramBase64Variant.usesPadding())
          {
            paramByteArrayBuilder.appendTwoBytes(m >> 2);
            return;
          }
          _reportBase64EOF();
        }
        i = j + 1;
        c = paramString.charAt(j);
        j = paramBase64Variant.decodeBase64Char(c);
        if (j < 0)
        {
          if (j != -2) {
            _reportInvalidBase64(paramBase64Variant, c, 3, null);
          }
          paramByteArrayBuilder.appendTwoBytes(m >> 2);
          break;
        }
        paramByteArrayBuilder.appendThreeBytes(m << 6 | j);
        break;
      }
      i = j;
    }
  }
  
  protected abstract void _handleEOF()
    throws JsonParseException;
  
  protected char _handleUnrecognizedCharacterEscape(char paramChar)
    throws JsonProcessingException
  {
    if (isEnabled(JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER)) {}
    while ((paramChar == '\'') && (isEnabled(JsonParser.Feature.ALLOW_SINGLE_QUOTES))) {
      return paramChar;
    }
    _reportError("Unrecognized character escape " + _getCharDesc(paramChar));
    return paramChar;
  }
  
  protected void _reportBase64EOF()
    throws JsonParseException
  {
    throw _constructError("Unexpected end-of-String in base64 content");
  }
  
  protected final void _reportError(String paramString)
    throws JsonParseException
  {
    throw _constructError(paramString);
  }
  
  protected void _reportInvalidBase64(Base64Variant paramBase64Variant, char paramChar, int paramInt, String paramString)
    throws JsonParseException
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
      throw _constructError((String)localObject);
      if (paramBase64Variant.usesPaddingChar(paramChar)) {
        paramBase64Variant = "Unexpected padding character ('" + paramBase64Variant.getPaddingChar() + "') as character #" + (paramInt + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character";
      } else if ((!Character.isDefined(paramChar)) || (Character.isISOControl(paramChar))) {
        paramBase64Variant = "Illegal character (code 0x" + Integer.toHexString(paramChar) + ") in base64 content";
      } else {
        paramBase64Variant = "Illegal character '" + paramChar + "' (code 0x" + Integer.toHexString(paramChar) + ") in base64 content";
      }
    }
  }
  
  protected void _reportInvalidEOF()
    throws JsonParseException
  {
    _reportInvalidEOF(" in " + this._currToken);
  }
  
  protected void _reportInvalidEOF(String paramString)
    throws JsonParseException
  {
    _reportError("Unexpected end-of-input" + paramString);
  }
  
  protected void _reportInvalidEOFInValue()
    throws JsonParseException
  {
    _reportInvalidEOF(" in a value");
  }
  
  protected void _reportUnexpectedChar(int paramInt, String paramString)
    throws JsonParseException
  {
    String str2 = "Unexpected character (" + _getCharDesc(paramInt) + ")";
    String str1 = str2;
    if (paramString != null) {
      str1 = str2 + ": " + paramString;
    }
    _reportError(str1);
  }
  
  protected final void _throwInternal()
  {
    throw new RuntimeException("Internal error: this code path should never get executed");
  }
  
  protected void _throwInvalidSpace(int paramInt)
    throws JsonParseException
  {
    paramInt = (char)paramInt;
    _reportError("Illegal character (" + _getCharDesc(paramInt) + "): only regular white space (\\r, \\n, \\t) is allowed between tokens");
  }
  
  protected void _throwUnquotedSpace(int paramInt, String paramString)
    throws JsonParseException
  {
    if ((!isEnabled(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS)) || (paramInt >= 32))
    {
      paramInt = (char)paramInt;
      _reportError("Illegal unquoted character (" + _getCharDesc(paramInt) + "): has to be escaped using backslash to be included in " + paramString);
    }
  }
  
  protected final void _wrapError(String paramString, Throwable paramThrowable)
    throws JsonParseException
  {
    throw _constructError(paramString, paramThrowable);
  }
  
  public abstract void close()
    throws IOException;
  
  public abstract byte[] getBinaryValue(Base64Variant paramBase64Variant)
    throws IOException, JsonParseException;
  
  public abstract String getCurrentName()
    throws IOException, JsonParseException;
  
  public abstract JsonStreamContext getParsingContext();
  
  public abstract String getText()
    throws IOException, JsonParseException;
  
  public abstract char[] getTextCharacters()
    throws IOException, JsonParseException;
  
  public abstract int getTextLength()
    throws IOException, JsonParseException;
  
  public abstract int getTextOffset()
    throws IOException, JsonParseException;
  
  public boolean getValueAsBoolean(boolean paramBoolean)
    throws IOException, JsonParseException
  {
    boolean bool2 = true;
    boolean bool1;
    if (this._currToken != null)
    {
      bool1 = bool2;
      switch (this._currToken)
      {
      }
    }
    do
    {
      bool1 = paramBoolean;
      do
      {
        return bool1;
        bool1 = bool2;
      } while (getIntValue() != 0);
      return false;
      return false;
      Object localObject = getEmbeddedObject();
      if ((localObject instanceof Boolean)) {
        return ((Boolean)localObject).booleanValue();
      }
    } while (!"true".equals(getText().trim()));
    return true;
  }
  
  public double getValueAsDouble(double paramDouble)
    throws IOException, JsonParseException
  {
    if (this._currToken != null) {
      switch (this._currToken)
      {
      }
    }
    Object localObject;
    do
    {
      return paramDouble;
      return getDoubleValue();
      return 1.0D;
      return 0.0D;
      return NumberInput.parseAsDouble(getText(), paramDouble);
      localObject = getEmbeddedObject();
    } while (!(localObject instanceof Number));
    return ((Number)localObject).doubleValue();
  }
  
  public int getValueAsInt(int paramInt)
    throws IOException, JsonParseException
  {
    if (this._currToken != null) {
      switch (this._currToken)
      {
      }
    }
    Object localObject;
    do
    {
      return paramInt;
      return getIntValue();
      return 1;
      return 0;
      return NumberInput.parseAsInt(getText(), paramInt);
      localObject = getEmbeddedObject();
    } while (!(localObject instanceof Number));
    return ((Number)localObject).intValue();
  }
  
  public long getValueAsLong(long paramLong)
    throws IOException, JsonParseException
  {
    if (this._currToken != null) {
      switch (this._currToken)
      {
      }
    }
    Object localObject;
    do
    {
      return paramLong;
      return getLongValue();
      return 1L;
      return 0L;
      return NumberInput.parseAsLong(getText(), paramLong);
      localObject = getEmbeddedObject();
    } while (!(localObject instanceof Number));
    return ((Number)localObject).longValue();
  }
  
  public abstract boolean hasTextCharacters();
  
  public abstract boolean isClosed();
  
  public abstract JsonToken nextToken()
    throws IOException, JsonParseException;
  
  public JsonParser skipChildren()
    throws IOException, JsonParseException
  {
    if ((this._currToken != JsonToken.START_OBJECT) && (this._currToken != JsonToken.START_ARRAY)) {
      return this;
    }
    int i = 1;
    int j;
    do
    {
      for (;;)
      {
        JsonToken localJsonToken = nextToken();
        if (localJsonToken == null)
        {
          _handleEOF();
          return this;
        }
        switch (localJsonToken)
        {
        default: 
          break;
        case ???: 
        case ???: 
          i += 1;
        }
      }
      j = i - 1;
      i = j;
    } while (j != 0);
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/impl/JsonParserMinimalBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */