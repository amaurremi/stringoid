package com.fasterxml.jackson.core.base;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.io.NumberInput;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;

public abstract class ParserMinimalBase
  extends JsonParser
{
  protected JsonToken _currToken;
  protected JsonToken _lastClearedToken;
  
  protected ParserMinimalBase() {}
  
  protected ParserMinimalBase(int paramInt)
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
  {
    int k = paramString.length();
    int i = 0;
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
  
  protected abstract void _handleEOF();
  
  protected char _handleUnrecognizedCharacterEscape(char paramChar)
  {
    if (isEnabled(JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER)) {}
    while ((paramChar == '\'') && (isEnabled(JsonParser.Feature.ALLOW_SINGLE_QUOTES))) {
      return paramChar;
    }
    _reportError("Unrecognized character escape " + _getCharDesc(paramChar));
    return paramChar;
  }
  
  protected void _reportBase64EOF()
  {
    throw _constructError("Unexpected end-of-String in base64 content");
  }
  
  protected final void _reportError(String paramString)
  {
    throw _constructError(paramString);
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
  {
    _reportInvalidEOF(" in " + this._currToken);
  }
  
  protected void _reportInvalidEOF(String paramString)
  {
    _reportError("Unexpected end-of-input" + paramString);
  }
  
  protected void _reportInvalidEOFInValue()
  {
    _reportInvalidEOF(" in a value");
  }
  
  protected void _reportUnexpectedChar(int paramInt, String paramString)
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
  {
    paramInt = (char)paramInt;
    _reportError("Illegal character (" + _getCharDesc(paramInt) + "): only regular white space (\\r, \\n, \\t) is allowed between tokens");
  }
  
  protected void _throwUnquotedSpace(int paramInt, String paramString)
  {
    if ((!isEnabled(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS)) || (paramInt >= 32))
    {
      paramInt = (char)paramInt;
      _reportError("Illegal unquoted character (" + _getCharDesc(paramInt) + "): has to be escaped using backslash to be included in " + paramString);
    }
  }
  
  protected final void _wrapError(String paramString, Throwable paramThrowable)
  {
    throw _constructError(paramString, paramThrowable);
  }
  
  public void clearCurrentToken()
  {
    if (this._currToken != null)
    {
      this._lastClearedToken = this._currToken;
      this._currToken = null;
    }
  }
  
  public JsonToken getCurrentToken()
  {
    return this._currToken;
  }
  
  public abstract String getText();
  
  public int getValueAsInt(int paramInt)
  {
    if (this._currToken != null) {
      switch (1.$SwitchMap$com$fasterxml$jackson$core$JsonToken[this._currToken.ordinal()])
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
  {
    if (this._currToken != null) {
      switch (1.$SwitchMap$com$fasterxml$jackson$core$JsonToken[this._currToken.ordinal()])
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
  
  public String getValueAsString(String paramString)
  {
    if ((this._currToken != JsonToken.VALUE_STRING) && ((this._currToken == null) || (this._currToken == JsonToken.VALUE_NULL) || (!this._currToken.isScalarValue()))) {
      return paramString;
    }
    return getText();
  }
  
  public boolean hasCurrentToken()
  {
    return this._currToken != null;
  }
  
  public abstract JsonToken nextToken();
  
  public JsonToken nextValue()
  {
    JsonToken localJsonToken2 = nextToken();
    JsonToken localJsonToken1 = localJsonToken2;
    if (localJsonToken2 == JsonToken.FIELD_NAME) {
      localJsonToken1 = nextToken();
    }
    return localJsonToken1;
  }
  
  public JsonParser skipChildren()
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
        switch (1.$SwitchMap$com$fasterxml$jackson$core$JsonToken[localJsonToken.ordinal()])
        {
        default: 
          break;
        case 1: 
        case 2: 
          i += 1;
        }
      }
      j = i - 1;
      i = j;
    } while (j != 0);
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/core/base/ParserMinimalBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */