package org.codehaus.jackson.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.codehaus.jackson.Base64Variant;
import org.codehaus.jackson.JsonParser.Feature;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.ObjectCodec;
import org.codehaus.jackson.SerializableString;
import org.codehaus.jackson.io.IOContext;
import org.codehaus.jackson.sym.BytesToNameCanonicalizer;
import org.codehaus.jackson.sym.Name;
import org.codehaus.jackson.util.ByteArrayBuilder;
import org.codehaus.jackson.util.CharTypes;
import org.codehaus.jackson.util.TextBuffer;

public final class Utf8StreamParser
  extends JsonParserBase
{
  static final byte BYTE_LF = 10;
  private static final int[] sInputCodesLatin1 = CharTypes.getInputCodeLatin1();
  private static final int[] sInputCodesUtf8 = ;
  protected boolean _bufferRecyclable;
  protected byte[] _inputBuffer;
  protected InputStream _inputStream;
  protected ObjectCodec _objectCodec;
  private int _quad1;
  protected int[] _quadBuffer = new int[16];
  protected final BytesToNameCanonicalizer _symbols;
  protected boolean _tokenIncomplete = false;
  
  public Utf8StreamParser(IOContext paramIOContext, int paramInt1, InputStream paramInputStream, ObjectCodec paramObjectCodec, BytesToNameCanonicalizer paramBytesToNameCanonicalizer, byte[] paramArrayOfByte, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    super(paramIOContext, paramInt1);
    this._inputStream = paramInputStream;
    this._objectCodec = paramObjectCodec;
    this._symbols = paramBytesToNameCanonicalizer;
    this._inputBuffer = paramArrayOfByte;
    this._inputPtr = paramInt2;
    this._inputEnd = paramInt3;
    this._bufferRecyclable = paramBoolean;
    if (!JsonParser.Feature.CANONICALIZE_FIELD_NAMES.enabledIn(paramInt1)) {
      _throwInternal();
    }
  }
  
  private final int _decodeUtf8_2(int paramInt)
  {
    if (this._inputPtr >= this._inputEnd) {
      loadMoreGuaranteed();
    }
    byte[] arrayOfByte = this._inputBuffer;
    int i = this._inputPtr;
    this._inputPtr = (i + 1);
    i = arrayOfByte[i];
    if ((i & 0xC0) != 128) {
      _reportInvalidOther(i & 0xFF, this._inputPtr);
    }
    return i & 0x3F | (paramInt & 0x1F) << 6;
  }
  
  private final int _decodeUtf8_3(int paramInt)
  {
    if (this._inputPtr >= this._inputEnd) {
      loadMoreGuaranteed();
    }
    byte[] arrayOfByte = this._inputBuffer;
    int i = this._inputPtr;
    this._inputPtr = (i + 1);
    i = arrayOfByte[i];
    if ((i & 0xC0) != 128) {
      _reportInvalidOther(i & 0xFF, this._inputPtr);
    }
    if (this._inputPtr >= this._inputEnd) {
      loadMoreGuaranteed();
    }
    arrayOfByte = this._inputBuffer;
    int j = this._inputPtr;
    this._inputPtr = (j + 1);
    j = arrayOfByte[j];
    if ((j & 0xC0) != 128) {
      _reportInvalidOther(j & 0xFF, this._inputPtr);
    }
    return ((paramInt & 0xF) << 6 | i & 0x3F) << 6 | j & 0x3F;
  }
  
  private final int _decodeUtf8_3fast(int paramInt)
  {
    byte[] arrayOfByte = this._inputBuffer;
    int i = this._inputPtr;
    this._inputPtr = (i + 1);
    i = arrayOfByte[i];
    if ((i & 0xC0) != 128) {
      _reportInvalidOther(i & 0xFF, this._inputPtr);
    }
    arrayOfByte = this._inputBuffer;
    int j = this._inputPtr;
    this._inputPtr = (j + 1);
    j = arrayOfByte[j];
    if ((j & 0xC0) != 128) {
      _reportInvalidOther(j & 0xFF, this._inputPtr);
    }
    return ((paramInt & 0xF) << 6 | i & 0x3F) << 6 | j & 0x3F;
  }
  
  private final int _decodeUtf8_4(int paramInt)
  {
    if (this._inputPtr >= this._inputEnd) {
      loadMoreGuaranteed();
    }
    byte[] arrayOfByte = this._inputBuffer;
    int i = this._inputPtr;
    this._inputPtr = (i + 1);
    i = arrayOfByte[i];
    if ((i & 0xC0) != 128) {
      _reportInvalidOther(i & 0xFF, this._inputPtr);
    }
    if (this._inputPtr >= this._inputEnd) {
      loadMoreGuaranteed();
    }
    arrayOfByte = this._inputBuffer;
    int j = this._inputPtr;
    this._inputPtr = (j + 1);
    j = arrayOfByte[j];
    if ((j & 0xC0) != 128) {
      _reportInvalidOther(j & 0xFF, this._inputPtr);
    }
    if (this._inputPtr >= this._inputEnd) {
      loadMoreGuaranteed();
    }
    arrayOfByte = this._inputBuffer;
    int k = this._inputPtr;
    this._inputPtr = (k + 1);
    k = arrayOfByte[k];
    if ((k & 0xC0) != 128) {
      _reportInvalidOther(k & 0xFF, this._inputPtr);
    }
    return (((i & 0x3F | (paramInt & 0x7) << 6) << 6 | j & 0x3F) << 6 | k & 0x3F) - 65536;
  }
  
  private final void _finishString2(char[] paramArrayOfChar, int paramInt)
  {
    int[] arrayOfInt = sInputCodesUtf8;
    byte[] arrayOfByte = this._inputBuffer;
    char[] arrayOfChar = paramArrayOfChar;
    int i;
    int j;
    int k;
    for (;;)
    {
      i = this._inputPtr;
      j = i;
      if (i >= this._inputEnd)
      {
        loadMoreGuaranteed();
        j = this._inputPtr;
      }
      paramArrayOfChar = arrayOfChar;
      i = paramInt;
      if (paramInt >= arrayOfChar.length)
      {
        paramArrayOfChar = this._textBuffer.finishCurrentSegment();
        i = 0;
      }
      k = Math.min(this._inputEnd, paramArrayOfChar.length - i + j);
      while (j < k)
      {
        paramInt = j + 1;
        j = arrayOfByte[j] & 0xFF;
        if (arrayOfInt[j] != 0)
        {
          this._inputPtr = paramInt;
          if (j != 34) {
            break label160;
          }
          this._textBuffer.setCurrentLength(i);
          return;
        }
        paramArrayOfChar[i] = ((char)j);
        j = paramInt;
        i += 1;
      }
      this._inputPtr = j;
      arrayOfChar = paramArrayOfChar;
      paramInt = i;
    }
    label160:
    switch (arrayOfInt[j])
    {
    default: 
      if (j < 32)
      {
        _throwUnquotedSpace(j, "string value");
        paramInt = j;
        label214:
        if (i < paramArrayOfChar.length) {
          break label379;
        }
        paramArrayOfChar = this._textBuffer.finishCurrentSegment();
        i = 0;
      }
      break;
    }
    label379:
    for (;;)
    {
      j = i + 1;
      paramArrayOfChar[i] = ((char)paramInt);
      arrayOfChar = paramArrayOfChar;
      paramInt = j;
      break;
      paramInt = _decodeEscaped();
      break label214;
      paramInt = _decodeUtf8_2(j);
      break label214;
      if (this._inputEnd - this._inputPtr >= 2)
      {
        paramInt = _decodeUtf8_3fast(j);
        break label214;
      }
      paramInt = _decodeUtf8_3(j);
      break label214;
      k = _decodeUtf8_4(j);
      j = i + 1;
      paramArrayOfChar[i] = ((char)(0xD800 | k >> 10));
      paramInt = j;
      arrayOfChar = paramArrayOfChar;
      if (j >= paramArrayOfChar.length)
      {
        arrayOfChar = this._textBuffer.finishCurrentSegment();
        paramInt = 0;
      }
      i = paramInt;
      paramInt = k & 0x3FF | 0xDC00;
      paramArrayOfChar = arrayOfChar;
      break label214;
      _reportInvalidChar(j);
      paramInt = j;
      break label214;
    }
  }
  
  private final void _isNextTokenNameNo(int paramInt)
  {
    Object localObject = _parseFieldName(paramInt);
    this._parsingContext.setCurrentName(((Name)localObject).getName());
    this._currToken = JsonToken.FIELD_NAME;
    paramInt = _skipWS();
    if (paramInt != 58) {
      _reportUnexpectedChar(paramInt, "was expecting a colon to separate field name and value");
    }
    paramInt = _skipWS();
    if (paramInt == 34)
    {
      this._tokenIncomplete = true;
      this._nextToken = JsonToken.VALUE_STRING;
      return;
    }
    switch (paramInt)
    {
    default: 
      localObject = _handleUnexpectedValue(paramInt);
    }
    for (;;)
    {
      this._nextToken = ((JsonToken)localObject);
      return;
      localObject = JsonToken.START_ARRAY;
      continue;
      localObject = JsonToken.START_OBJECT;
      continue;
      _reportUnexpectedChar(paramInt, "expected a value");
      _matchToken("true", 1);
      localObject = JsonToken.VALUE_TRUE;
      continue;
      _matchToken("false", 1);
      localObject = JsonToken.VALUE_FALSE;
      continue;
      _matchToken("null", 1);
      localObject = JsonToken.VALUE_NULL;
      continue;
      localObject = parseNumberText(paramInt);
    }
  }
  
  private final void _isNextTokenNameYes()
  {
    if ((this._inputPtr < this._inputEnd) && (this._inputBuffer[this._inputPtr] == 58))
    {
      this._inputPtr += 1;
      byte[] arrayOfByte = this._inputBuffer;
      i = this._inputPtr;
      this._inputPtr = (i + 1);
      i = arrayOfByte[i];
      if (i == 34)
      {
        this._tokenIncomplete = true;
        this._nextToken = JsonToken.VALUE_STRING;
        return;
      }
      if (i == 123)
      {
        this._nextToken = JsonToken.START_OBJECT;
        return;
      }
      if (i == 91)
      {
        this._nextToken = JsonToken.START_ARRAY;
        return;
      }
      int j = i & 0xFF;
      if (j > 32)
      {
        i = j;
        if (j != 47) {}
      }
      else
      {
        this._inputPtr -= 1;
      }
    }
    for (int i = _skipWS();; i = _skipColon()) {
      switch (i)
      {
      default: 
        this._nextToken = _handleUnexpectedValue(i);
        return;
      }
    }
    this._tokenIncomplete = true;
    this._nextToken = JsonToken.VALUE_STRING;
    return;
    this._nextToken = JsonToken.START_ARRAY;
    return;
    this._nextToken = JsonToken.START_OBJECT;
    return;
    _reportUnexpectedChar(i, "expected a value");
    _matchToken("true", 1);
    this._nextToken = JsonToken.VALUE_TRUE;
    return;
    _matchToken("false", 1);
    this._nextToken = JsonToken.VALUE_FALSE;
    return;
    _matchToken("null", 1);
    this._nextToken = JsonToken.VALUE_NULL;
    return;
    this._nextToken = parseNumberText(i);
  }
  
  private final JsonToken _nextAfterName()
  {
    this._nameCopied = false;
    JsonToken localJsonToken = this._nextToken;
    this._nextToken = null;
    if (localJsonToken == JsonToken.START_ARRAY) {
      this._parsingContext = this._parsingContext.createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
    }
    for (;;)
    {
      this._currToken = localJsonToken;
      return localJsonToken;
      if (localJsonToken == JsonToken.START_OBJECT) {
        this._parsingContext = this._parsingContext.createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
      }
    }
  }
  
  private final JsonToken _nextTokenNotInObject(int paramInt)
  {
    if (paramInt == 34)
    {
      this._tokenIncomplete = true;
      localJsonToken = JsonToken.VALUE_STRING;
      this._currToken = localJsonToken;
      return localJsonToken;
    }
    switch (paramInt)
    {
    default: 
      localJsonToken = _handleUnexpectedValue(paramInt);
      this._currToken = localJsonToken;
      return localJsonToken;
    case 91: 
      this._parsingContext = this._parsingContext.createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
      localJsonToken = JsonToken.START_ARRAY;
      this._currToken = localJsonToken;
      return localJsonToken;
    case 123: 
      this._parsingContext = this._parsingContext.createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
      localJsonToken = JsonToken.START_OBJECT;
      this._currToken = localJsonToken;
      return localJsonToken;
    case 93: 
    case 125: 
      _reportUnexpectedChar(paramInt, "expected a value");
    case 116: 
      _matchToken("true", 1);
      localJsonToken = JsonToken.VALUE_TRUE;
      this._currToken = localJsonToken;
      return localJsonToken;
    case 102: 
      _matchToken("false", 1);
      localJsonToken = JsonToken.VALUE_FALSE;
      this._currToken = localJsonToken;
      return localJsonToken;
    case 110: 
      _matchToken("null", 1);
      localJsonToken = JsonToken.VALUE_NULL;
      this._currToken = localJsonToken;
      return localJsonToken;
    }
    JsonToken localJsonToken = parseNumberText(paramInt);
    this._currToken = localJsonToken;
    return localJsonToken;
  }
  
  private final JsonToken _parseFloatText(char[] paramArrayOfChar, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    int i = 0;
    int j = 0;
    int m = 0;
    int k;
    label55:
    Object localObject;
    if (paramInt2 == 46)
    {
      k = paramInt1 + 1;
      paramArrayOfChar[paramInt1] = ((char)paramInt2);
      j = paramInt2;
      paramInt1 = k;
      paramInt2 = i;
      if ((this._inputPtr >= this._inputEnd) && (!loadMore()))
      {
        i = 1;
        if (paramInt2 == 0) {
          reportUnexpectedNumberChar(j, "Decimal point not followed by a digit");
        }
        k = paramInt2;
        paramInt2 = j;
        localObject = paramArrayOfChar;
      }
    }
    for (;;)
    {
      label196:
      label251:
      label335:
      int n;
      int i1;
      if ((paramInt2 == 101) || (paramInt2 == 69))
      {
        j = paramInt1;
        paramArrayOfChar = (char[])localObject;
        if (paramInt1 >= localObject.length)
        {
          paramArrayOfChar = this._textBuffer.finishCurrentSegment();
          j = 0;
        }
        paramInt1 = j + 1;
        paramArrayOfChar[j] = ((char)paramInt2);
        if (this._inputPtr >= this._inputEnd) {
          loadMoreGuaranteed();
        }
        localObject = this._inputBuffer;
        paramInt2 = this._inputPtr;
        this._inputPtr = (paramInt2 + 1);
        j = localObject[paramInt2] & 0xFF;
        if ((j == 45) || (j == 43)) {
          if (paramInt1 >= paramArrayOfChar.length)
          {
            paramArrayOfChar = this._textBuffer.finishCurrentSegment();
            paramInt1 = 0;
            paramArrayOfChar[paramInt1] = ((char)j);
            if (this._inputPtr >= this._inputEnd) {
              loadMoreGuaranteed();
            }
            localObject = this._inputBuffer;
            paramInt2 = this._inputPtr;
            this._inputPtr = (paramInt2 + 1);
            j = localObject[paramInt2] & 0xFF;
            paramInt1 += 1;
            paramInt2 = 0;
            if ((j <= 57) && (j >= 48))
            {
              paramInt2 += 1;
              m = paramInt1;
              localObject = paramArrayOfChar;
              if (paramInt1 >= paramArrayOfChar.length)
              {
                localObject = this._textBuffer.finishCurrentSegment();
                m = 0;
              }
              paramInt1 = m + 1;
              localObject[m] = ((char)j);
              if ((this._inputPtr >= this._inputEnd) && (!loadMore()))
              {
                m = paramInt2;
                paramInt2 = 1;
                i = paramInt1;
                paramInt1 = m;
                m = paramInt1;
                n = paramInt2;
                i1 = i;
                if (paramInt1 == 0)
                {
                  reportUnexpectedNumberChar(j, "Exponent indicator not followed by a digit");
                  i1 = i;
                  n = paramInt2;
                  m = paramInt1;
                }
                label367:
                if (n == 0) {
                  this._inputPtr -= 1;
                }
                this._textBuffer.setCurrentLength(i1);
                return resetFloat(paramBoolean, paramInt3, k, m);
                localObject = this._inputBuffer;
                i = this._inputPtr;
                this._inputPtr = (i + 1);
                k = localObject[i] & 0xFF;
                i = m;
                j = k;
                if (k < 48) {
                  break label55;
                }
                i = m;
                j = k;
                if (k > 57) {
                  break label55;
                }
                paramInt2 += 1;
                if (paramInt1 < paramArrayOfChar.length) {
                  break label577;
                }
                paramArrayOfChar = this._textBuffer.finishCurrentSegment();
                paramInt1 = 0;
              }
            }
          }
        }
      }
      label577:
      for (;;)
      {
        i = paramInt1 + 1;
        paramArrayOfChar[paramInt1] = ((char)k);
        paramInt1 = i;
        j = k;
        break;
        paramArrayOfChar = this._inputBuffer;
        j = this._inputPtr;
        this._inputPtr = (j + 1);
        j = paramArrayOfChar[j] & 0xFF;
        paramArrayOfChar = (char[])localObject;
        break label251;
        m = paramInt1;
        paramInt1 = paramInt2;
        paramInt2 = i;
        i = m;
        break label335;
        break label196;
        paramInt2 = 0;
        break label251;
        m = 0;
        n = i;
        i1 = paramInt1;
        break label367;
      }
      k = 0;
      localObject = paramArrayOfChar;
      i = j;
    }
  }
  
  private final JsonToken _parserNumber2(char[] paramArrayOfChar, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if ((this._inputPtr >= this._inputEnd) && (!loadMore()))
    {
      this._textBuffer.setCurrentLength(paramInt1);
      return resetInt(paramBoolean, paramInt2);
    }
    byte[] arrayOfByte = this._inputBuffer;
    int i = this._inputPtr;
    this._inputPtr = (i + 1);
    int j = arrayOfByte[i] & 0xFF;
    if ((j > 57) || (j < 48))
    {
      if ((j == 46) || (j == 101) || (j == 69)) {
        return _parseFloatText(paramArrayOfChar, paramInt1, j, paramBoolean, paramInt2);
      }
    }
    else
    {
      if (paramInt1 < paramArrayOfChar.length) {
        break label177;
      }
      paramArrayOfChar = this._textBuffer.finishCurrentSegment();
      paramInt1 = 0;
    }
    label177:
    for (;;)
    {
      i = paramInt1 + 1;
      paramArrayOfChar[paramInt1] = ((char)j);
      paramInt2 += 1;
      paramInt1 = i;
      break;
      this._inputPtr -= 1;
      this._textBuffer.setCurrentLength(paramInt1);
      return resetInt(paramBoolean, paramInt2);
    }
  }
  
  private final void _skipCComment()
  {
    int[] arrayOfInt = CharTypes.getInputCodeComment();
    while ((this._inputPtr < this._inputEnd) || (loadMore()))
    {
      byte[] arrayOfByte = this._inputBuffer;
      int i = this._inputPtr;
      this._inputPtr = (i + 1);
      i = arrayOfByte[i] & 0xFF;
      int j = arrayOfInt[i];
      if (j != 0) {
        switch (j)
        {
        default: 
          _reportInvalidChar(i);
          break;
        case 42: 
          if (this._inputBuffer[this._inputPtr] == 47)
          {
            this._inputPtr += 1;
            return;
          }
          break;
        case 10: 
          _skipLF();
          break;
        case 13: 
          _skipCR();
        }
      }
    }
    _reportInvalidEOF(" in a comment");
  }
  
  private final int _skipColon()
  {
    if (this._inputPtr >= this._inputEnd) {
      loadMoreGuaranteed();
    }
    byte[] arrayOfByte = this._inputBuffer;
    int i = this._inputPtr;
    this._inputPtr = (i + 1);
    i = arrayOfByte[i];
    if (i == 58)
    {
      if (this._inputPtr < this._inputEnd)
      {
        i = this._inputBuffer[this._inputPtr] & 0xFF;
        if ((i > 32) && (i != 47))
        {
          this._inputPtr += 1;
          return i;
        }
      }
    }
    else
    {
      i &= 0xFF;
      switch (i)
      {
      default: 
        label97:
        if (i < 32) {
          _throwInvalidSpace(i);
        }
        if (this._inputPtr >= this._inputEnd) {
          loadMoreGuaranteed();
        }
        arrayOfByte = this._inputBuffer;
        i = this._inputPtr;
        this._inputPtr = (i + 1);
        i = arrayOfByte[i] & 0xFF;
        if (i != 58) {
          _reportUnexpectedChar(i, "was expecting a colon to separate field name and value");
        }
        break;
      }
    }
    for (;;)
    {
      if ((this._inputPtr >= this._inputEnd) && (!loadMore())) {
        break label343;
      }
      arrayOfByte = this._inputBuffer;
      i = this._inputPtr;
      this._inputPtr = (i + 1);
      int j = arrayOfByte[i] & 0xFF;
      if (j > 32)
      {
        i = j;
        if (j != 47) {
          break;
        }
        _skipComment();
        continue;
        _skipCR();
        break label97;
        _skipLF();
        break label97;
        _skipComment();
        break label97;
      }
      if (j != 32) {
        if (j == 10) {
          _skipLF();
        } else if (j == 13) {
          _skipCR();
        } else if (j != 9) {
          _throwInvalidSpace(j);
        }
      }
    }
    label343:
    throw _constructError("Unexpected end-of-input within/between " + this._parsingContext.getTypeDesc() + " entries");
  }
  
  private final void _skipComment()
  {
    if (!isEnabled(JsonParser.Feature.ALLOW_COMMENTS)) {
      _reportUnexpectedChar(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
    }
    if ((this._inputPtr >= this._inputEnd) && (!loadMore())) {
      _reportInvalidEOF(" in a comment");
    }
    byte[] arrayOfByte = this._inputBuffer;
    int i = this._inputPtr;
    this._inputPtr = (i + 1);
    i = arrayOfByte[i] & 0xFF;
    if (i == 47)
    {
      _skipCppComment();
      return;
    }
    if (i == 42)
    {
      _skipCComment();
      return;
    }
    _reportUnexpectedChar(i, "was expecting either '*' or '/' for a comment");
  }
  
  private final void _skipCppComment()
  {
    int[] arrayOfInt = CharTypes.getInputCodeComment();
    while ((this._inputPtr < this._inputEnd) || (loadMore()))
    {
      byte[] arrayOfByte = this._inputBuffer;
      int i = this._inputPtr;
      this._inputPtr = (i + 1);
      i = arrayOfByte[i] & 0xFF;
      int j = arrayOfInt[i];
      if (j != 0) {
        switch (j)
        {
        case 42: 
        default: 
          _reportInvalidChar(i);
          break;
        case 10: 
          _skipLF();
        }
      }
    }
    return;
    _skipCR();
  }
  
  private final void _skipUtf8_2(int paramInt)
  {
    if (this._inputPtr >= this._inputEnd) {
      loadMoreGuaranteed();
    }
    byte[] arrayOfByte = this._inputBuffer;
    paramInt = this._inputPtr;
    this._inputPtr = (paramInt + 1);
    paramInt = arrayOfByte[paramInt];
    if ((paramInt & 0xC0) != 128) {
      _reportInvalidOther(paramInt & 0xFF, this._inputPtr);
    }
  }
  
  private final void _skipUtf8_3(int paramInt)
  {
    if (this._inputPtr >= this._inputEnd) {
      loadMoreGuaranteed();
    }
    byte[] arrayOfByte = this._inputBuffer;
    paramInt = this._inputPtr;
    this._inputPtr = (paramInt + 1);
    paramInt = arrayOfByte[paramInt];
    if ((paramInt & 0xC0) != 128) {
      _reportInvalidOther(paramInt & 0xFF, this._inputPtr);
    }
    if (this._inputPtr >= this._inputEnd) {
      loadMoreGuaranteed();
    }
    arrayOfByte = this._inputBuffer;
    paramInt = this._inputPtr;
    this._inputPtr = (paramInt + 1);
    paramInt = arrayOfByte[paramInt];
    if ((paramInt & 0xC0) != 128) {
      _reportInvalidOther(paramInt & 0xFF, this._inputPtr);
    }
  }
  
  private final void _skipUtf8_4(int paramInt)
  {
    if (this._inputPtr >= this._inputEnd) {
      loadMoreGuaranteed();
    }
    byte[] arrayOfByte = this._inputBuffer;
    paramInt = this._inputPtr;
    this._inputPtr = (paramInt + 1);
    paramInt = arrayOfByte[paramInt];
    if ((paramInt & 0xC0) != 128) {
      _reportInvalidOther(paramInt & 0xFF, this._inputPtr);
    }
    if (this._inputPtr >= this._inputEnd) {
      loadMoreGuaranteed();
    }
    arrayOfByte = this._inputBuffer;
    paramInt = this._inputPtr;
    this._inputPtr = (paramInt + 1);
    paramInt = arrayOfByte[paramInt];
    if ((paramInt & 0xC0) != 128) {
      _reportInvalidOther(paramInt & 0xFF, this._inputPtr);
    }
    if (this._inputPtr >= this._inputEnd) {
      loadMoreGuaranteed();
    }
    arrayOfByte = this._inputBuffer;
    paramInt = this._inputPtr;
    this._inputPtr = (paramInt + 1);
    paramInt = arrayOfByte[paramInt];
    if ((paramInt & 0xC0) != 128) {
      _reportInvalidOther(paramInt & 0xFF, this._inputPtr);
    }
  }
  
  private final int _skipWS()
  {
    while ((this._inputPtr < this._inputEnd) || (loadMore()))
    {
      byte[] arrayOfByte = this._inputBuffer;
      int i = this._inputPtr;
      this._inputPtr = (i + 1);
      i = arrayOfByte[i] & 0xFF;
      if (i > 32)
      {
        if (i != 47) {
          return i;
        }
        _skipComment();
      }
      else if (i != 32)
      {
        if (i == 10) {
          _skipLF();
        } else if (i == 13) {
          _skipCR();
        } else if (i != 9) {
          _throwInvalidSpace(i);
        }
      }
    }
    throw _constructError("Unexpected end-of-input within/between " + this._parsingContext.getTypeDesc() + " entries");
  }
  
  private final int _skipWSOrEnd()
  {
    while ((this._inputPtr < this._inputEnd) || (loadMore()))
    {
      byte[] arrayOfByte = this._inputBuffer;
      int i = this._inputPtr;
      this._inputPtr = (i + 1);
      i = arrayOfByte[i] & 0xFF;
      if (i > 32)
      {
        if (i != 47) {
          return i;
        }
        _skipComment();
      }
      else if (i != 32)
      {
        if (i == 10) {
          _skipLF();
        } else if (i == 13) {
          _skipCR();
        } else if (i != 9) {
          _throwInvalidSpace(i);
        }
      }
    }
    _handleEOF();
    return -1;
  }
  
  private final int _verifyNoLeadingZeroes()
  {
    if ((this._inputPtr >= this._inputEnd) && (!loadMore())) {}
    int j;
    do
    {
      for (int i = 48; (this._inputPtr >= this._inputEnd) && (!loadMore()); i = j) {
        do
        {
          return i;
          j = this._inputBuffer[this._inputPtr] & 0xFF;
          if ((j < 48) || (j > 57)) {
            return 48;
          }
          if (!isEnabled(JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS)) {
            reportInvalidNumber("Leading zeroes not allowed");
          }
          this._inputPtr += 1;
          i = j;
        } while (j != 48);
      }
      j = this._inputBuffer[this._inputPtr] & 0xFF;
      if ((j < 48) || (j > 57)) {
        return 48;
      }
      this._inputPtr += 1;
      i = j;
    } while (j == 48);
    return j;
  }
  
  private final Name addName(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int i3 = (paramInt1 << 2) - 4 + paramInt2;
    int i2;
    Object localObject1;
    int m;
    int i;
    label49:
    int j;
    int k;
    int i1;
    int n;
    label120:
    Object localObject2;
    if (paramInt2 < 4)
    {
      i2 = paramArrayOfInt[(paramInt1 - 1)];
      paramArrayOfInt[(paramInt1 - 1)] = (i2 << (4 - paramInt2 << 3));
      localObject1 = this._textBuffer.emptyAndGetCurrentSegment();
      m = 0;
      i = 0;
      if (i >= i3) {
        break label521;
      }
      j = paramArrayOfInt[(i >> 2)] >> (3 - (i & 0x3) << 3) & 0xFF;
      k = i + 1;
      i1 = j;
      n = k;
      if (j <= 127) {
        break label559;
      }
      if ((j & 0xE0) != 192) {
        break label456;
      }
      i = j & 0x1F;
      j = 1;
      if (k + j > i3) {
        _reportInvalidEOF(" in field name");
      }
      i1 = paramArrayOfInt[(k >> 2)] >> (3 - (k & 0x3) << 3);
      n = k + 1;
      if ((i1 & 0xC0) != 128) {
        _reportInvalidOther(i1);
      }
      i1 = i << 6 | i1 & 0x3F;
      k = i1;
      i = n;
      if (j > 1)
      {
        i = paramArrayOfInt[(n >> 2)] >> (3 - (n & 0x3) << 3);
        n += 1;
        if ((i & 0xC0) != 128) {
          _reportInvalidOther(i);
        }
        i1 = i1 << 6 | i & 0x3F;
        k = i1;
        i = n;
        if (j > 2)
        {
          k = paramArrayOfInt[(n >> 2)] >> (3 - (n & 0x3) << 3);
          i = n + 1;
          if ((k & 0xC0) != 128) {
            _reportInvalidOther(k & 0xFF);
          }
          k = i1 << 6 | k & 0x3F;
        }
      }
      i1 = k;
      n = i;
      if (j <= 2) {
        break label559;
      }
      j = k - 65536;
      localObject2 = localObject1;
      if (m >= localObject1.length) {
        localObject2 = this._textBuffer.expandCurrentSegment();
      }
      localObject2[m] = ((char)(55296 + (j >> 10)));
      k = m + 1;
      localObject1 = localObject2;
      j = j & 0x3FF | 0xDC00;
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (k >= localObject1.length) {
        localObject2 = this._textBuffer.expandCurrentSegment();
      }
      m = k + 1;
      localObject2[k] = ((char)j);
      localObject1 = localObject2;
      break label49;
      i2 = 0;
      break;
      label456:
      if ((j & 0xF0) == 224)
      {
        i = j & 0xF;
        j = 2;
        break label120;
      }
      if ((j & 0xF8) == 240)
      {
        i = j & 0x7;
        j = 3;
        break label120;
      }
      _reportInvalidInitial(j);
      i = 1;
      j = 1;
      break label120;
      label521:
      localObject1 = new String((char[])localObject1, 0, m);
      if (paramInt2 < 4) {
        paramArrayOfInt[(paramInt1 - 1)] = i2;
      }
      return this._symbols.addName((String)localObject1, paramArrayOfInt, paramInt1);
      label559:
      j = i1;
      i = n;
      k = m;
    }
  }
  
  private final Name findName(int paramInt1, int paramInt2)
  {
    Name localName = this._symbols.findName(paramInt1);
    if (localName != null) {
      return localName;
    }
    this._quadBuffer[0] = paramInt1;
    return addName(this._quadBuffer, 1, paramInt2);
  }
  
  private final Name findName(int paramInt1, int paramInt2, int paramInt3)
  {
    Name localName = this._symbols.findName(paramInt1, paramInt2);
    if (localName != null) {
      return localName;
    }
    this._quadBuffer[0] = paramInt1;
    this._quadBuffer[1] = paramInt2;
    return addName(this._quadBuffer, 2, paramInt3);
  }
  
  private final Name findName(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    int[] arrayOfInt = paramArrayOfInt;
    if (paramInt1 >= paramArrayOfInt.length)
    {
      arrayOfInt = growArrayBy(paramArrayOfInt, paramArrayOfInt.length);
      this._quadBuffer = arrayOfInt;
    }
    int i = paramInt1 + 1;
    arrayOfInt[paramInt1] = paramInt2;
    Name localName = this._symbols.findName(arrayOfInt, i);
    paramArrayOfInt = localName;
    if (localName == null) {
      paramArrayOfInt = addName(arrayOfInt, i, paramInt3);
    }
    return paramArrayOfInt;
  }
  
  public static int[] growArrayBy(int[] paramArrayOfInt, int paramInt)
  {
    if (paramArrayOfInt == null) {
      return new int[paramInt];
    }
    int i = paramArrayOfInt.length;
    int[] arrayOfInt = new int[i + paramInt];
    System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, i);
    return arrayOfInt;
  }
  
  private int nextByte()
  {
    if (this._inputPtr >= this._inputEnd) {
      loadMoreGuaranteed();
    }
    byte[] arrayOfByte = this._inputBuffer;
    int i = this._inputPtr;
    this._inputPtr = (i + 1);
    return arrayOfByte[i] & 0xFF;
  }
  
  private final Name parseFieldName(int paramInt1, int paramInt2, int paramInt3)
  {
    return parseEscapedFieldName(this._quadBuffer, 0, paramInt1, paramInt2, paramInt3);
  }
  
  private final Name parseFieldName(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this._quadBuffer[0] = paramInt1;
    return parseEscapedFieldName(this._quadBuffer, 1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void _closeInput()
  {
    if (this._inputStream != null)
    {
      if ((this._ioContext.isResourceManaged()) || (isEnabled(JsonParser.Feature.AUTO_CLOSE_SOURCE))) {
        this._inputStream.close();
      }
      this._inputStream = null;
    }
  }
  
  protected byte[] _decodeBase64(Base64Variant paramBase64Variant)
  {
    ByteArrayBuilder localByteArrayBuilder = _getByteArrayBuilder();
    for (;;)
    {
      if (this._inputPtr >= this._inputEnd) {
        loadMoreGuaranteed();
      }
      byte[] arrayOfByte = this._inputBuffer;
      int i = this._inputPtr;
      this._inputPtr = (i + 1);
      int k = arrayOfByte[i] & 0xFF;
      if (k > 32)
      {
        int j = paramBase64Variant.decodeBase64Char(k);
        i = j;
        if (j < 0)
        {
          if (k == 34) {
            return localByteArrayBuilder.toByteArray();
          }
          i = _decodeBase64Escape(paramBase64Variant, k, 0);
          if (i < 0) {}
        }
        else
        {
          if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
          }
          arrayOfByte = this._inputBuffer;
          j = this._inputPtr;
          this._inputPtr = (j + 1);
          int m = arrayOfByte[j] & 0xFF;
          k = paramBase64Variant.decodeBase64Char(m);
          j = k;
          if (k < 0) {
            j = _decodeBase64Escape(paramBase64Variant, m, 1);
          }
          m = j | i << 6;
          if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
          }
          arrayOfByte = this._inputBuffer;
          i = this._inputPtr;
          this._inputPtr = (i + 1);
          int n = arrayOfByte[i] & 0xFF;
          j = paramBase64Variant.decodeBase64Char(n);
          k = j;
          if (j < 0)
          {
            i = j;
            if (j != -2)
            {
              if ((n == 34) && (!paramBase64Variant.usesPadding()))
              {
                localByteArrayBuilder.append(m >> 4);
                return localByteArrayBuilder.toByteArray();
              }
              i = _decodeBase64Escape(paramBase64Variant, n, 2);
            }
            k = i;
            if (i == -2)
            {
              if (this._inputPtr >= this._inputEnd) {
                loadMoreGuaranteed();
              }
              arrayOfByte = this._inputBuffer;
              i = this._inputPtr;
              this._inputPtr = (i + 1);
              i = arrayOfByte[i] & 0xFF;
              if (!paramBase64Variant.usesPaddingChar(i)) {
                throw reportInvalidBase64Char(paramBase64Variant, i, 3, "expected padding character '" + paramBase64Variant.getPaddingChar() + "'");
              }
              localByteArrayBuilder.append(m >> 4);
              continue;
            }
          }
          m = m << 6 | k;
          if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
          }
          arrayOfByte = this._inputBuffer;
          i = this._inputPtr;
          this._inputPtr = (i + 1);
          n = arrayOfByte[i] & 0xFF;
          j = paramBase64Variant.decodeBase64Char(n);
          k = j;
          if (j < 0)
          {
            i = j;
            if (j != -2)
            {
              if ((n == 34) && (!paramBase64Variant.usesPadding()))
              {
                localByteArrayBuilder.appendTwoBytes(m >> 2);
                return localByteArrayBuilder.toByteArray();
              }
              i = _decodeBase64Escape(paramBase64Variant, n, 3);
            }
            k = i;
            if (i == -2)
            {
              localByteArrayBuilder.appendTwoBytes(m >> 2);
              continue;
            }
          }
          localByteArrayBuilder.appendThreeBytes(k | m << 6);
        }
      }
    }
  }
  
  protected int _decodeCharForError(int paramInt)
  {
    int j = paramInt;
    int i;
    if (paramInt < 0)
    {
      if ((paramInt & 0xE0) != 192) {
        break label145;
      }
      paramInt &= 0x1F;
      i = 1;
    }
    for (;;)
    {
      j = nextByte();
      if ((j & 0xC0) != 128) {
        _reportInvalidOther(j & 0xFF);
      }
      paramInt = paramInt << 6 | j & 0x3F;
      j = paramInt;
      if (i > 1)
      {
        j = nextByte();
        if ((j & 0xC0) != 128) {
          _reportInvalidOther(j & 0xFF);
        }
        paramInt = paramInt << 6 | j & 0x3F;
        j = paramInt;
        if (i > 2)
        {
          i = nextByte();
          if ((i & 0xC0) != 128) {
            _reportInvalidOther(i & 0xFF);
          }
          j = paramInt << 6 | i & 0x3F;
        }
      }
      return j;
      label145:
      if ((paramInt & 0xF0) == 224)
      {
        paramInt &= 0xF;
        i = 2;
      }
      else if ((paramInt & 0xF8) == 240)
      {
        paramInt &= 0x7;
        i = 3;
      }
      else
      {
        _reportInvalidInitial(paramInt & 0xFF);
        i = 1;
      }
    }
  }
  
  protected final char _decodeEscaped()
  {
    int i = 0;
    if ((this._inputPtr >= this._inputEnd) && (!loadMore())) {
      _reportInvalidEOF(" in character escape sequence");
    }
    byte[] arrayOfByte = this._inputBuffer;
    int j = this._inputPtr;
    this._inputPtr = (j + 1);
    j = arrayOfByte[j];
    switch (j)
    {
    default: 
      return _handleUnrecognizedCharacterEscape((char)_decodeCharForError(j));
    case 98: 
      return '\b';
    case 116: 
      return '\t';
    case 110: 
      return '\n';
    case 102: 
      return '\f';
    case 114: 
      return '\r';
    case 34: 
    case 47: 
    case 92: 
      return (char)j;
    }
    j = 0;
    while (i < 4)
    {
      if ((this._inputPtr >= this._inputEnd) && (!loadMore())) {
        _reportInvalidEOF(" in character escape sequence");
      }
      arrayOfByte = this._inputBuffer;
      int k = this._inputPtr;
      this._inputPtr = (k + 1);
      k = arrayOfByte[k];
      int m = CharTypes.charToHex(k);
      if (m < 0) {
        _reportUnexpectedChar(k, "expected a hex-digit for character escape sequence");
      }
      j = j << 4 | m;
      i += 1;
    }
    return (char)j;
  }
  
  protected void _finishString()
  {
    int j = this._inputPtr;
    int i = j;
    if (j >= this._inputEnd)
    {
      loadMoreGuaranteed();
      i = this._inputPtr;
    }
    char[] arrayOfChar = this._textBuffer.emptyAndGetCurrentSegment();
    int[] arrayOfInt = sInputCodesUtf8;
    int k = Math.min(this._inputEnd, arrayOfChar.length + i);
    byte[] arrayOfByte = this._inputBuffer;
    j = 0;
    while (i < k)
    {
      int m = arrayOfByte[i] & 0xFF;
      if (arrayOfInt[m] != 0)
      {
        if (m != 34) {
          break;
        }
        this._inputPtr = (i + 1);
        this._textBuffer.setCurrentLength(j);
        return;
      }
      arrayOfChar[j] = ((char)m);
      j += 1;
      i += 1;
    }
    this._inputPtr = i;
    _finishString2(arrayOfChar, j);
  }
  
  protected final String _getText2(JsonToken paramJsonToken)
  {
    if (paramJsonToken == null) {
      return null;
    }
    switch (1.$SwitchMap$org$codehaus$jackson$JsonToken[paramJsonToken.ordinal()])
    {
    default: 
      return paramJsonToken.asString();
    case 1: 
      return this._parsingContext.getCurrentName();
    }
    return this._textBuffer.contentsAsString();
  }
  
  protected JsonToken _handleApostropheValue()
  {
    Object localObject2 = this._textBuffer.emptyAndGetCurrentSegment();
    int[] arrayOfInt = sInputCodesUtf8;
    byte[] arrayOfByte = this._inputBuffer;
    int i = 0;
    if (this._inputPtr >= this._inputEnd) {
      loadMoreGuaranteed();
    }
    Object localObject1 = localObject2;
    int j = i;
    if (i >= localObject2.length)
    {
      localObject1 = this._textBuffer.finishCurrentSegment();
      j = 0;
    }
    int k = this._inputEnd;
    i = this._inputPtr + (localObject1.length - j);
    if (i < k) {
      k = i;
    }
    for (;;)
    {
      localObject2 = localObject1;
      i = j;
      if (this._inputPtr >= k) {
        break;
      }
      i = this._inputPtr;
      this._inputPtr = (i + 1);
      i = arrayOfByte[i] & 0xFF;
      if ((i == 39) || (arrayOfInt[i] != 0))
      {
        if (i == 39)
        {
          this._textBuffer.setCurrentLength(j);
          return JsonToken.VALUE_STRING;
        }
      }
      else
      {
        localObject1[j] = ((char)i);
        j += 1;
        continue;
      }
      switch (arrayOfInt[i])
      {
      default: 
        if (i < 32) {
          _throwUnquotedSpace(i, "string value");
        }
        _reportInvalidChar(i);
      }
      for (;;)
      {
        if (j >= localObject1.length)
        {
          localObject1 = this._textBuffer.finishCurrentSegment();
          j = 0;
          label232:
          k = j + 1;
          localObject1[j] = ((char)i);
          localObject2 = localObject1;
          i = k;
          break;
          if (i != 34)
          {
            i = _decodeEscaped();
            continue;
            i = _decodeUtf8_2(i);
            continue;
            if (this._inputEnd - this._inputPtr >= 2)
            {
              i = _decodeUtf8_3fast(i);
            }
            else
            {
              i = _decodeUtf8_3(i);
              continue;
              k = _decodeUtf8_4(i);
              i = j + 1;
              localObject1[j] = ((char)(0xD800 | k >> 10));
              if (i < localObject1.length) {
                break label360;
              }
              localObject1 = this._textBuffer.finishCurrentSegment();
            }
          }
        }
      }
      label360:
      for (j = 0;; j = i)
      {
        i = 0xDC00 | k & 0x3FF;
        break;
        break label232;
      }
    }
  }
  
  protected JsonToken _handleInvalidNumberStart(int paramInt, boolean paramBoolean)
  {
    double d = Double.NEGATIVE_INFINITY;
    int i = paramInt;
    Object localObject;
    if (paramInt == 73)
    {
      if ((this._inputPtr >= this._inputEnd) && (!loadMore())) {
        _reportInvalidEOFInValue();
      }
      localObject = this._inputBuffer;
      paramInt = this._inputPtr;
      this._inputPtr = (paramInt + 1);
      paramInt = localObject[paramInt];
      if (paramInt != 78) {
        break label162;
      }
      if (paramBoolean)
      {
        localObject = "-INF";
        _matchToken((String)localObject, 3);
        if (!isEnabled(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
          break label117;
        }
        if (!paramBoolean) {
          break label110;
        }
      }
      for (;;)
      {
        return resetAsNaN((String)localObject, d);
        localObject = "+INF";
        break;
        label110:
        d = Double.POSITIVE_INFINITY;
      }
      label117:
      _reportError("Non-standard token '" + (String)localObject + "': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
      i = paramInt;
    }
    for (;;)
    {
      reportUnexpectedNumberChar(i, "expected digit (0-9) to follow minus sign, for valid numeric value");
      return null;
      label162:
      i = paramInt;
      if (paramInt == 110)
      {
        if (paramBoolean)
        {
          localObject = "-Infinity";
          _matchToken((String)localObject, 3);
          if (!isEnabled(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
            break label224;
          }
          if (!paramBoolean) {
            break label217;
          }
        }
        for (;;)
        {
          return resetAsNaN((String)localObject, d);
          localObject = "+Infinity";
          break;
          label217:
          d = Double.POSITIVE_INFINITY;
        }
        label224:
        _reportError("Non-standard token '" + (String)localObject + "': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
        i = paramInt;
      }
    }
  }
  
  protected JsonToken _handleUnexpectedValue(int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 39: 
    case 78: 
      for (;;)
      {
        _reportUnexpectedChar(paramInt, "expected a valid value (number, String, array, object, 'true', 'false' or 'null')");
        return null;
        if (isEnabled(JsonParser.Feature.ALLOW_SINGLE_QUOTES))
        {
          return _handleApostropheValue();
          _matchToken("NaN", 1);
          if (isEnabled(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
            return resetAsNaN("NaN", NaN.0D);
          }
          _reportError("Non-standard token 'NaN': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
        }
      }
    }
    if ((this._inputPtr >= this._inputEnd) && (!loadMore())) {
      _reportInvalidEOFInValue();
    }
    byte[] arrayOfByte = this._inputBuffer;
    paramInt = this._inputPtr;
    this._inputPtr = (paramInt + 1);
    return _handleInvalidNumberStart(arrayOfByte[paramInt] & 0xFF, false);
  }
  
  protected final Name _handleUnusualFieldName(int paramInt)
  {
    if ((paramInt == 39) && (isEnabled(JsonParser.Feature.ALLOW_SINGLE_QUOTES))) {
      return _parseApostropheFieldName();
    }
    if (!isEnabled(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES)) {
      _reportUnexpectedChar(paramInt, "was expecting double-quote to start field name");
    }
    int[] arrayOfInt = CharTypes.getInputCodeUtf8JsNames();
    if (arrayOfInt[paramInt] != 0) {
      _reportUnexpectedChar(paramInt, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
    }
    Object localObject1 = this._quadBuffer;
    int k = 0;
    int j = 0;
    int i = paramInt;
    paramInt = 0;
    for (;;)
    {
      if (k < 4) {
        j = i | j << 8;
      }
      int m;
      for (i = k + 1;; i = k)
      {
        if ((this._inputPtr >= this._inputEnd) && (!loadMore())) {
          _reportInvalidEOF(" in field name");
        }
        m = this._inputBuffer[this._inputPtr] & 0xFF;
        if (arrayOfInt[m] == 0) {
          break;
        }
        k = paramInt;
        Object localObject2 = localObject1;
        if (i > 0)
        {
          localObject2 = localObject1;
          if (paramInt >= localObject1.length)
          {
            localObject2 = growArrayBy((int[])localObject1, localObject1.length);
            this._quadBuffer = ((int[])localObject2);
          }
          localObject2[paramInt] = j;
          k = paramInt + 1;
        }
        localObject1 = this._symbols.findName((int[])localObject2, k);
        if (localObject1 != null) {
          break label286;
        }
        return addName((int[])localObject2, k, i);
        localObject2 = localObject1;
        if (paramInt >= localObject1.length)
        {
          localObject2 = growArrayBy((int[])localObject1, localObject1.length);
          this._quadBuffer = ((int[])localObject2);
        }
        localObject2[paramInt] = j;
        localObject1 = localObject2;
        k = 1;
        j = i;
        paramInt += 1;
      }
      this._inputPtr += 1;
      k = i;
      i = m;
    }
    label286:
    return (Name)localObject1;
  }
  
  protected final boolean _loadToHaveAtLeast(int paramInt)
  {
    if (this._inputStream == null) {
      return false;
    }
    int i = this._inputEnd - this._inputPtr;
    if ((i > 0) && (this._inputPtr > 0))
    {
      this._currInputProcessed += this._inputPtr;
      this._currInputRowStart -= this._inputPtr;
      System.arraycopy(this._inputBuffer, this._inputPtr, this._inputBuffer, 0, i);
      this._inputEnd = i;
      label79:
      this._inputPtr = 0;
    }
    for (;;)
    {
      if (this._inputEnd >= paramInt) {
        break label186;
      }
      int j = this._inputStream.read(this._inputBuffer, this._inputEnd, this._inputBuffer.length - this._inputEnd);
      if (j < 1)
      {
        _closeInput();
        if (j != 0) {
          break;
        }
        throw new IOException("InputStream.read() returned 0 characters when trying to read " + i + " bytes");
        this._inputEnd = 0;
        break label79;
      }
      this._inputEnd = (j + this._inputEnd);
    }
    label186:
    return true;
  }
  
  protected final void _matchToken(String paramString, int paramInt)
  {
    int j = paramString.length();
    int i;
    do
    {
      if ((this._inputPtr >= this._inputEnd) && (!loadMore())) {
        _reportInvalidEOF(" in a value");
      }
      if (this._inputBuffer[this._inputPtr] != paramString.charAt(paramInt)) {
        _reportInvalidToken(paramString.substring(0, paramInt), "'null', 'true', 'false' or NaN");
      }
      this._inputPtr += 1;
      i = paramInt + 1;
      paramInt = i;
    } while (i < j);
    if ((this._inputPtr >= this._inputEnd) && (!loadMore())) {}
    do
    {
      return;
      paramInt = this._inputBuffer[this._inputPtr] & 0xFF;
    } while ((paramInt < 48) || (paramInt == 93) || (paramInt == 125) || (!Character.isJavaIdentifierPart((char)_decodeCharForError(paramInt))));
    this._inputPtr += 1;
    _reportInvalidToken(paramString.substring(0, i), "'null', 'true', 'false' or NaN");
  }
  
  protected final Name _parseApostropheFieldName()
  {
    if ((this._inputPtr >= this._inputEnd) && (!loadMore())) {
      _reportInvalidEOF(": was expecting closing ''' for name");
    }
    Object localObject1 = this._inputBuffer;
    int i = this._inputPtr;
    this._inputPtr = (i + 1);
    int m = localObject1[i] & 0xFF;
    if (m == 39) {
      return BytesToNameCanonicalizer.getEmptyName();
    }
    localObject1 = this._quadBuffer;
    int[] arrayOfInt = sInputCodesLatin1;
    int j = 0;
    int k = 0;
    i = 0;
    Object localObject2;
    int n;
    if (m == 39)
    {
      if (j <= 0) {
        break label557;
      }
      localObject2 = localObject1;
      if (i >= localObject1.length)
      {
        localObject2 = growArrayBy((int[])localObject1, localObject1.length);
        this._quadBuffer = ((int[])localObject2);
      }
      localObject2[i] = k;
      localObject1 = localObject2;
      i += 1;
      localObject2 = this._symbols.findName((int[])localObject1, i);
      if (localObject2 == null) {
        return addName((int[])localObject1, i, j);
      }
    }
    else
    {
      n = m;
      if (m == 34) {
        break label566;
      }
      n = m;
      if (arrayOfInt[m] == 0) {
        break label566;
      }
      if (m != 92)
      {
        _throwUnquotedSpace(m, "name");
        label197:
        n = m;
        if (m <= 127) {
          break label566;
        }
        if (j < 4) {
          break label563;
        }
        localObject2 = localObject1;
        if (i >= localObject1.length)
        {
          localObject2 = growArrayBy((int[])localObject1, localObject1.length);
          this._quadBuffer = ((int[])localObject2);
        }
        localObject2[i] = k;
        j = 0;
        i += 1;
        k = 0;
        localObject1 = localObject2;
        label257:
        if (m >= 2048) {
          break label407;
        }
        k = k << 8 | m >> 6 | 0xC0;
        j += 1;
        label284:
        n = k;
        k = j;
        j = m & 0x3F | 0x80;
        m = k;
      }
    }
    for (;;)
    {
      if (m < 4)
      {
        k = j | n << 8;
        m += 1;
        j = i;
        i = m;
        label327:
        if ((this._inputPtr >= this._inputEnd) && (!loadMore())) {
          _reportInvalidEOF(" in field name");
        }
        localObject2 = this._inputBuffer;
        m = this._inputPtr;
        this._inputPtr = (m + 1);
        n = localObject2[m] & 0xFF;
        m = i;
        i = j;
        j = m;
        m = n;
        break;
        m = _decodeEscaped();
        break label197;
        label407:
        k = k << 8 | m >> 12 | 0xE0;
        j += 1;
        if (j < 4) {
          break label560;
        }
        localObject2 = localObject1;
        if (i >= localObject1.length)
        {
          localObject2 = growArrayBy((int[])localObject1, localObject1.length);
          this._quadBuffer = ((int[])localObject2);
        }
        localObject2[i] = k;
        i += 1;
        localObject1 = localObject2;
        j = 0;
        k = 0;
      }
      label557:
      label560:
      for (;;)
      {
        k = k << 8 | m >> 6 & 0x3F | 0x80;
        j += 1;
        break label284;
        localObject2 = localObject1;
        if (i >= localObject1.length)
        {
          localObject2 = growArrayBy((int[])localObject1, localObject1.length);
          this._quadBuffer = ((int[])localObject2);
        }
        localObject2[i] = n;
        localObject1 = localObject2;
        k = 1;
        m = i + 1;
        i = k;
        k = j;
        j = m;
        break label327;
        return (Name)localObject2;
        break;
      }
      label563:
      break label257;
      label566:
      m = j;
      j = n;
      n = k;
    }
  }
  
  protected final Name _parseFieldName(int paramInt)
  {
    if (paramInt != 34) {
      return _handleUnusualFieldName(paramInt);
    }
    if (this._inputPtr + 9 > this._inputEnd) {
      return slowParseFieldName();
    }
    byte[] arrayOfByte = this._inputBuffer;
    int[] arrayOfInt = sInputCodesLatin1;
    paramInt = this._inputPtr;
    this._inputPtr = (paramInt + 1);
    paramInt = arrayOfByte[paramInt] & 0xFF;
    if (arrayOfInt[paramInt] == 0)
    {
      int i = this._inputPtr;
      this._inputPtr = (i + 1);
      i = arrayOfByte[i] & 0xFF;
      if (arrayOfInt[i] == 0)
      {
        paramInt = paramInt << 8 | i;
        i = this._inputPtr;
        this._inputPtr = (i + 1);
        i = arrayOfByte[i] & 0xFF;
        if (arrayOfInt[i] == 0)
        {
          paramInt = paramInt << 8 | i;
          i = this._inputPtr;
          this._inputPtr = (i + 1);
          i = arrayOfByte[i] & 0xFF;
          if (arrayOfInt[i] == 0)
          {
            paramInt = paramInt << 8 | i;
            i = this._inputPtr;
            this._inputPtr = (i + 1);
            i = arrayOfByte[i] & 0xFF;
            if (arrayOfInt[i] == 0)
            {
              this._quad1 = paramInt;
              return parseMediumFieldName(i, arrayOfInt);
            }
            if (i == 34) {
              return findName(paramInt, 4);
            }
            return parseFieldName(paramInt, i, 4);
          }
          if (i == 34) {
            return findName(paramInt, 3);
          }
          return parseFieldName(paramInt, i, 3);
        }
        if (i == 34) {
          return findName(paramInt, 2);
        }
        return parseFieldName(paramInt, i, 2);
      }
      if (i == 34) {
        return findName(paramInt, 1);
      }
      return parseFieldName(paramInt, i, 1);
    }
    if (paramInt == 34) {
      return BytesToNameCanonicalizer.getEmptyName();
    }
    return parseFieldName(0, paramInt, 0);
  }
  
  protected void _releaseBuffers()
  {
    super._releaseBuffers();
    if (this._bufferRecyclable)
    {
      byte[] arrayOfByte = this._inputBuffer;
      if (arrayOfByte != null)
      {
        this._inputBuffer = null;
        this._ioContext.releaseReadIOBuffer(arrayOfByte);
      }
    }
  }
  
  protected void _reportInvalidChar(int paramInt)
  {
    if (paramInt < 32) {
      _throwInvalidSpace(paramInt);
    }
    _reportInvalidInitial(paramInt);
  }
  
  protected void _reportInvalidInitial(int paramInt)
  {
    _reportError("Invalid UTF-8 start byte 0x" + Integer.toHexString(paramInt));
  }
  
  protected void _reportInvalidOther(int paramInt)
  {
    _reportError("Invalid UTF-8 middle byte 0x" + Integer.toHexString(paramInt));
  }
  
  protected void _reportInvalidOther(int paramInt1, int paramInt2)
  {
    this._inputPtr = paramInt2;
    _reportInvalidOther(paramInt1);
  }
  
  protected void _reportInvalidToken(String paramString1, String paramString2)
  {
    paramString1 = new StringBuilder(paramString1);
    for (;;)
    {
      if ((this._inputPtr >= this._inputEnd) && (!loadMore())) {}
      char c;
      do
      {
        _reportError("Unrecognized token '" + paramString1.toString() + "': was expecting " + paramString2);
        return;
        byte[] arrayOfByte = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = (i + 1);
        c = (char)_decodeCharForError(arrayOfByte[i]);
      } while (!Character.isJavaIdentifierPart(c));
      this._inputPtr += 1;
      paramString1.append(c);
    }
  }
  
  protected final void _skipCR()
  {
    if (((this._inputPtr < this._inputEnd) || (loadMore())) && (this._inputBuffer[this._inputPtr] == 10)) {
      this._inputPtr += 1;
    }
    this._currInputRow += 1;
    this._currInputRowStart = this._inputPtr;
  }
  
  protected final void _skipLF()
  {
    this._currInputRow += 1;
    this._currInputRowStart = this._inputPtr;
  }
  
  protected void _skipString()
  {
    this._tokenIncomplete = false;
    int[] arrayOfInt = sInputCodesUtf8;
    byte[] arrayOfByte = this._inputBuffer;
    int k = this._inputPtr;
    int m = this._inputEnd;
    int j = m;
    int i = k;
    if (k >= m)
    {
      loadMoreGuaranteed();
      i = this._inputPtr;
      j = this._inputEnd;
    }
    for (;;)
    {
      if (i < j)
      {
        k = i + 1;
        i = arrayOfByte[i] & 0xFF;
        if (arrayOfInt[i] == 0) {
          break label188;
        }
        this._inputPtr = k;
        if (i != 34) {}
      }
      else
      {
        this._inputPtr = i;
        break;
      }
      switch (arrayOfInt[i])
      {
      default: 
        if (i < 32) {
          _throwUnquotedSpace(i, "string value");
        }
        break;
      case 1: 
        _decodeEscaped();
        break;
      case 2: 
        _skipUtf8_2(i);
        break;
      case 3: 
        _skipUtf8_3(i);
        break;
      case 4: 
        _skipUtf8_4(i);
        break;
        _reportInvalidChar(i);
        break;
      }
      label188:
      i = k;
    }
  }
  
  public void close()
  {
    super.close();
    this._symbols.release();
  }
  
  public byte[] getBinaryValue(Base64Variant paramBase64Variant)
  {
    if ((this._currToken != JsonToken.VALUE_STRING) && ((this._currToken != JsonToken.VALUE_EMBEDDED_OBJECT) || (this._binaryValue == null))) {
      _reportError("Current token (" + this._currToken + ") not VALUE_STRING or VALUE_EMBEDDED_OBJECT, can not access as binary");
    }
    if (this._tokenIncomplete) {}
    for (;;)
    {
      try
      {
        this._binaryValue = _decodeBase64(paramBase64Variant);
        this._tokenIncomplete = false;
        return this._binaryValue;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        throw _constructError("Failed to decode VALUE_STRING as base64 (" + paramBase64Variant + "): " + localIllegalArgumentException.getMessage());
      }
      if (this._binaryValue == null)
      {
        ByteArrayBuilder localByteArrayBuilder = _getByteArrayBuilder();
        _decodeBase64(getText(), localByteArrayBuilder, paramBase64Variant);
        this._binaryValue = localByteArrayBuilder.toByteArray();
      }
    }
  }
  
  public ObjectCodec getCodec()
  {
    return this._objectCodec;
  }
  
  public Object getInputSource()
  {
    return this._inputStream;
  }
  
  public String getText()
  {
    JsonToken localJsonToken = this._currToken;
    if (localJsonToken == JsonToken.VALUE_STRING)
    {
      if (this._tokenIncomplete)
      {
        this._tokenIncomplete = false;
        _finishString();
      }
      return this._textBuffer.contentsAsString();
    }
    return _getText2(localJsonToken);
  }
  
  public char[] getTextCharacters()
  {
    if (this._currToken != null)
    {
      switch (1.$SwitchMap$org$codehaus$jackson$JsonToken[this._currToken.ordinal()])
      {
      default: 
        return this._currToken.asCharArray();
      case 1: 
        String str;
        int i;
        if (!this._nameCopied)
        {
          str = this._parsingContext.getCurrentName();
          i = str.length();
          if (this._nameCopyBuffer != null) {
            break label116;
          }
          this._nameCopyBuffer = this._ioContext.allocNameCopyBuffer(i);
        }
        for (;;)
        {
          str.getChars(0, i, this._nameCopyBuffer, 0);
          this._nameCopied = true;
          return this._nameCopyBuffer;
          if (this._nameCopyBuffer.length < i) {
            this._nameCopyBuffer = new char[i];
          }
        }
      case 2: 
        label116:
        if (this._tokenIncomplete)
        {
          this._tokenIncomplete = false;
          _finishString();
        }
        break;
      }
      return this._textBuffer.getTextBuffer();
    }
    return null;
  }
  
  public int getTextLength()
  {
    int i = 0;
    if (this._currToken != null) {}
    switch (1.$SwitchMap$org$codehaus$jackson$JsonToken[this._currToken.ordinal()])
    {
    default: 
      i = this._currToken.asCharArray().length;
      return i;
    case 1: 
      return this._parsingContext.getCurrentName().length();
    case 2: 
      if (this._tokenIncomplete)
      {
        this._tokenIncomplete = false;
        _finishString();
      }
      break;
    }
    return this._textBuffer.size();
  }
  
  public int getTextOffset()
  {
    if (this._currToken != null) {}
    switch (1.$SwitchMap$org$codehaus$jackson$JsonToken[this._currToken.ordinal()])
    {
    case 1: 
    default: 
      return 0;
    case 2: 
      if (this._tokenIncomplete)
      {
        this._tokenIncomplete = false;
        _finishString();
      }
      break;
    }
    return this._textBuffer.getTextOffset();
  }
  
  protected final boolean loadMore()
  {
    boolean bool2 = false;
    this._currInputProcessed += this._inputEnd;
    this._currInputRowStart -= this._inputEnd;
    boolean bool1 = bool2;
    int i;
    if (this._inputStream != null)
    {
      i = this._inputStream.read(this._inputBuffer, 0, this._inputBuffer.length);
      if (i <= 0) {
        break label74;
      }
      this._inputPtr = 0;
      this._inputEnd = i;
      bool1 = true;
    }
    label74:
    do
    {
      return bool1;
      _closeInput();
      bool1 = bool2;
    } while (i != 0);
    throw new IOException("InputStream.read() returned 0 characters when trying to read " + this._inputBuffer.length + " bytes");
  }
  
  public Boolean nextBooleanValue()
  {
    Boolean localBoolean = null;
    if (this._currToken == JsonToken.FIELD_NAME)
    {
      this._nameCopied = false;
      JsonToken localJsonToken = this._nextToken;
      this._nextToken = null;
      this._currToken = localJsonToken;
      if (localJsonToken == JsonToken.VALUE_TRUE) {
        localBoolean = Boolean.TRUE;
      }
      do
      {
        return localBoolean;
        if (localJsonToken == JsonToken.VALUE_FALSE) {
          return Boolean.FALSE;
        }
        if (localJsonToken == JsonToken.START_ARRAY)
        {
          this._parsingContext = this._parsingContext.createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
          return null;
        }
      } while (localJsonToken != JsonToken.START_OBJECT);
      this._parsingContext = this._parsingContext.createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
      return null;
    }
    switch (1.$SwitchMap$org$codehaus$jackson$JsonToken[nextToken().ordinal()])
    {
    default: 
      return null;
    case 5: 
      return Boolean.TRUE;
    }
    return Boolean.FALSE;
  }
  
  public boolean nextFieldName(SerializableString paramSerializableString)
  {
    this._numTypesValid = 0;
    if (this._currToken == JsonToken.FIELD_NAME)
    {
      _nextAfterName();
      return false;
    }
    if (this._tokenIncomplete) {
      _skipString();
    }
    int j = _skipWSOrEnd();
    if (j < 0)
    {
      close();
      this._currToken = null;
      return false;
    }
    this._tokenInputTotal = (this._currInputProcessed + this._inputPtr - 1L);
    this._tokenInputRow = this._currInputRow;
    this._tokenInputCol = (this._inputPtr - this._currInputRowStart - 1);
    this._binaryValue = null;
    if (j == 93)
    {
      if (!this._parsingContext.inArray()) {
        _reportMismatchedEndMarker(j, '}');
      }
      this._parsingContext = this._parsingContext.getParent();
      this._currToken = JsonToken.END_ARRAY;
      return false;
    }
    if (j == 125)
    {
      if (!this._parsingContext.inObject()) {
        _reportMismatchedEndMarker(j, ']');
      }
      this._parsingContext = this._parsingContext.getParent();
      this._currToken = JsonToken.END_OBJECT;
      return false;
    }
    int i = j;
    if (this._parsingContext.expectComma())
    {
      if (j != 44) {
        _reportUnexpectedChar(j, "was expecting comma to separate " + this._parsingContext.getTypeDesc() + " entries");
      }
      i = _skipWS();
    }
    if (!this._parsingContext.inObject())
    {
      _nextTokenNotInObject(i);
      return false;
    }
    byte[] arrayOfByte;
    int k;
    int m;
    int n;
    if (i == 34)
    {
      arrayOfByte = paramSerializableString.asQuotedUTF8();
      k = arrayOfByte.length;
      if (this._inputPtr + k < this._inputEnd)
      {
        m = this._inputPtr + k;
        if (this._inputBuffer[m] == 34)
        {
          n = this._inputPtr;
          j = 0;
        }
      }
    }
    for (;;)
    {
      if (j == k)
      {
        this._inputPtr = (m + 1);
        this._parsingContext.setCurrentName(paramSerializableString.getValue());
        this._currToken = JsonToken.FIELD_NAME;
        _isNextTokenNameYes();
        return true;
      }
      if (arrayOfByte[j] != this._inputBuffer[(n + j)])
      {
        _isNextTokenNameNo(i);
        return false;
      }
      j += 1;
    }
  }
  
  public int nextIntValue(int paramInt)
  {
    JsonToken localJsonToken;
    int i;
    if (this._currToken == JsonToken.FIELD_NAME)
    {
      this._nameCopied = false;
      localJsonToken = this._nextToken;
      this._nextToken = null;
      this._currToken = localJsonToken;
      if (localJsonToken == JsonToken.VALUE_NUMBER_INT) {
        i = getIntValue();
      }
    }
    do
    {
      do
      {
        return i;
        if (localJsonToken == JsonToken.START_ARRAY)
        {
          this._parsingContext = this._parsingContext.createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
          return paramInt;
        }
        i = paramInt;
      } while (localJsonToken != JsonToken.START_OBJECT);
      this._parsingContext = this._parsingContext.createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
      return paramInt;
      i = paramInt;
    } while (nextToken() != JsonToken.VALUE_NUMBER_INT);
    return getIntValue();
  }
  
  public long nextLongValue(long paramLong)
  {
    JsonToken localJsonToken;
    long l;
    if (this._currToken == JsonToken.FIELD_NAME)
    {
      this._nameCopied = false;
      localJsonToken = this._nextToken;
      this._nextToken = null;
      this._currToken = localJsonToken;
      if (localJsonToken == JsonToken.VALUE_NUMBER_INT) {
        l = getLongValue();
      }
    }
    do
    {
      do
      {
        return l;
        if (localJsonToken == JsonToken.START_ARRAY)
        {
          this._parsingContext = this._parsingContext.createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
          return paramLong;
        }
        l = paramLong;
      } while (localJsonToken != JsonToken.START_OBJECT);
      this._parsingContext = this._parsingContext.createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
      return paramLong;
      l = paramLong;
    } while (nextToken() != JsonToken.VALUE_NUMBER_INT);
    return getLongValue();
  }
  
  public String nextTextValue()
  {
    String str = null;
    if (this._currToken == JsonToken.FIELD_NAME)
    {
      this._nameCopied = false;
      localJsonToken = this._nextToken;
      this._nextToken = null;
      this._currToken = localJsonToken;
      if (localJsonToken == JsonToken.VALUE_STRING)
      {
        if (this._tokenIncomplete)
        {
          this._tokenIncomplete = false;
          _finishString();
        }
        str = this._textBuffer.contentsAsString();
      }
    }
    while (nextToken() != JsonToken.VALUE_STRING)
    {
      JsonToken localJsonToken;
      do
      {
        return str;
        if (localJsonToken == JsonToken.START_ARRAY)
        {
          this._parsingContext = this._parsingContext.createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
          return null;
        }
      } while (localJsonToken != JsonToken.START_OBJECT);
      this._parsingContext = this._parsingContext.createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
      return null;
    }
    return getText();
  }
  
  public JsonToken nextToken()
  {
    this._numTypesValid = 0;
    if (this._currToken == JsonToken.FIELD_NAME) {
      return _nextAfterName();
    }
    if (this._tokenIncomplete) {
      _skipString();
    }
    int j = _skipWSOrEnd();
    if (j < 0)
    {
      close();
      this._currToken = null;
      return null;
    }
    this._tokenInputTotal = (this._currInputProcessed + this._inputPtr - 1L);
    this._tokenInputRow = this._currInputRow;
    this._tokenInputCol = (this._inputPtr - this._currInputRowStart - 1);
    this._binaryValue = null;
    if (j == 93)
    {
      if (!this._parsingContext.inArray()) {
        _reportMismatchedEndMarker(j, '}');
      }
      this._parsingContext = this._parsingContext.getParent();
      localObject = JsonToken.END_ARRAY;
      this._currToken = ((JsonToken)localObject);
      return (JsonToken)localObject;
    }
    if (j == 125)
    {
      if (!this._parsingContext.inObject()) {
        _reportMismatchedEndMarker(j, ']');
      }
      this._parsingContext = this._parsingContext.getParent();
      localObject = JsonToken.END_OBJECT;
      this._currToken = ((JsonToken)localObject);
      return (JsonToken)localObject;
    }
    int i = j;
    if (this._parsingContext.expectComma())
    {
      if (j != 44) {
        _reportUnexpectedChar(j, "was expecting comma to separate " + this._parsingContext.getTypeDesc() + " entries");
      }
      i = _skipWS();
    }
    if (!this._parsingContext.inObject()) {
      return _nextTokenNotInObject(i);
    }
    Object localObject = _parseFieldName(i);
    this._parsingContext.setCurrentName(((Name)localObject).getName());
    this._currToken = JsonToken.FIELD_NAME;
    i = _skipWS();
    if (i != 58) {
      _reportUnexpectedChar(i, "was expecting a colon to separate field name and value");
    }
    i = _skipWS();
    if (i == 34)
    {
      this._tokenIncomplete = true;
      this._nextToken = JsonToken.VALUE_STRING;
      return this._currToken;
    }
    switch (i)
    {
    default: 
      localObject = _handleUnexpectedValue(i);
    }
    for (;;)
    {
      this._nextToken = ((JsonToken)localObject);
      return this._currToken;
      localObject = JsonToken.START_ARRAY;
      continue;
      localObject = JsonToken.START_OBJECT;
      continue;
      _reportUnexpectedChar(i, "expected a value");
      _matchToken("true", 1);
      localObject = JsonToken.VALUE_TRUE;
      continue;
      _matchToken("false", 1);
      localObject = JsonToken.VALUE_FALSE;
      continue;
      _matchToken("null", 1);
      localObject = JsonToken.VALUE_NULL;
      continue;
      localObject = parseNumberText(i);
    }
  }
  
  protected Name parseEscapedFieldName(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject2 = sInputCodesLatin1;
    int i = paramInt3;
    Object localObject1;
    if (localObject2[paramInt3] != 0)
    {
      if (paramInt3 == 34)
      {
        localObject1 = paramArrayOfInt;
        paramInt3 = paramInt1;
        if (paramInt4 > 0)
        {
          localObject1 = paramArrayOfInt;
          if (paramInt1 >= paramArrayOfInt.length)
          {
            localObject1 = growArrayBy(paramArrayOfInt, paramArrayOfInt.length);
            this._quadBuffer = ((int[])localObject1);
          }
          localObject1[paramInt1] = paramInt2;
          paramInt3 = paramInt1 + 1;
        }
        localObject2 = this._symbols.findName((int[])localObject1, paramInt3);
        paramArrayOfInt = (int[])localObject2;
        if (localObject2 == null) {
          paramArrayOfInt = addName((int[])localObject1, paramInt3, paramInt4);
        }
        return paramArrayOfInt;
      }
      if (paramInt3 != 92)
      {
        _throwUnquotedSpace(paramInt3, "name");
        label118:
        i = paramInt3;
        if (paramInt3 <= 127) {
          break label485;
        }
        if (paramInt4 < 4) {
          break label482;
        }
        localObject1 = paramArrayOfInt;
        if (paramInt1 >= paramArrayOfInt.length)
        {
          localObject1 = growArrayBy(paramArrayOfInt, paramArrayOfInt.length);
          this._quadBuffer = ((int[])localObject1);
        }
        i = paramInt1 + 1;
        localObject1[paramInt1] = paramInt2;
        paramInt4 = 0;
        paramInt2 = 0;
        paramArrayOfInt = (int[])localObject1;
        paramInt1 = i;
        label179:
        if (paramInt3 >= 2048) {
          break label333;
        }
        i = paramInt3 >> 6 | 0xC0 | paramInt2 << 8;
        paramInt4 += 1;
        paramInt2 = paramInt1;
        paramInt1 = i;
        int j = paramInt3 & 0x3F | 0x80;
        i = paramInt4;
        paramInt3 = paramInt2;
        paramInt4 = paramInt1;
        paramInt2 = j;
        paramInt1 = paramInt3;
        paramInt3 = paramInt4;
      }
    }
    for (;;)
    {
      if (i < 4)
      {
        paramInt4 = i + 1;
        paramInt2 |= paramInt3 << 8;
        label265:
        if ((this._inputPtr >= this._inputEnd) && (!loadMore())) {
          _reportInvalidEOF(" in field name");
        }
        localObject1 = this._inputBuffer;
        paramInt3 = this._inputPtr;
        this._inputPtr = (paramInt3 + 1);
        paramInt3 = localObject1[paramInt3] & 0xFF;
        break;
        paramInt3 = _decodeEscaped();
        break label118;
        label333:
        i = paramInt3 >> 12 | 0xE0 | paramInt2 << 8;
        paramInt2 = paramInt4 + 1;
        if (paramInt2 < 4) {
          break label475;
        }
        localObject1 = paramArrayOfInt;
        if (paramInt1 >= paramArrayOfInt.length)
        {
          localObject1 = growArrayBy(paramArrayOfInt, paramArrayOfInt.length);
          this._quadBuffer = ((int[])localObject1);
        }
        localObject1[paramInt1] = i;
        paramInt1 += 1;
        paramArrayOfInt = (int[])localObject1;
        paramInt2 = 0;
      }
      label475:
      for (paramInt4 = 0;; paramInt4 = i)
      {
        i = paramInt4 << 8 | paramInt3 >> 6 & 0x3F | 0x80;
        paramInt4 = paramInt2 + 1;
        paramInt2 = paramInt1;
        paramInt1 = i;
        break;
        localObject1 = paramArrayOfInt;
        if (paramInt1 >= paramArrayOfInt.length)
        {
          localObject1 = growArrayBy(paramArrayOfInt, paramArrayOfInt.length);
          this._quadBuffer = ((int[])localObject1);
        }
        localObject1[paramInt1] = paramInt3;
        paramInt4 = 1;
        paramInt1 += 1;
        paramArrayOfInt = (int[])localObject1;
        break label265;
      }
      label482:
      break label179;
      label485:
      paramInt3 = paramInt2;
      paramInt2 = i;
      i = paramInt4;
    }
  }
  
  protected Name parseLongFieldName(int paramInt)
  {
    int[] arrayOfInt = sInputCodesLatin1;
    int j = 2;
    int i = paramInt;
    paramInt = j;
    for (;;)
    {
      if (this._inputEnd - this._inputPtr < 4) {
        return parseEscapedFieldName(this._quadBuffer, paramInt, 0, i, 0);
      }
      byte[] arrayOfByte = this._inputBuffer;
      j = this._inputPtr;
      this._inputPtr = (j + 1);
      j = arrayOfByte[j] & 0xFF;
      if (arrayOfInt[j] != 0)
      {
        if (j == 34) {
          return findName(this._quadBuffer, paramInt, i, 1);
        }
        return parseEscapedFieldName(this._quadBuffer, paramInt, i, j, 1);
      }
      i = i << 8 | j;
      arrayOfByte = this._inputBuffer;
      j = this._inputPtr;
      this._inputPtr = (j + 1);
      j = arrayOfByte[j] & 0xFF;
      if (arrayOfInt[j] != 0)
      {
        if (j == 34) {
          return findName(this._quadBuffer, paramInt, i, 2);
        }
        return parseEscapedFieldName(this._quadBuffer, paramInt, i, j, 2);
      }
      i = i << 8 | j;
      arrayOfByte = this._inputBuffer;
      j = this._inputPtr;
      this._inputPtr = (j + 1);
      j = arrayOfByte[j] & 0xFF;
      if (arrayOfInt[j] != 0)
      {
        if (j == 34) {
          return findName(this._quadBuffer, paramInt, i, 3);
        }
        return parseEscapedFieldName(this._quadBuffer, paramInt, i, j, 3);
      }
      j = i << 8 | j;
      arrayOfByte = this._inputBuffer;
      i = this._inputPtr;
      this._inputPtr = (i + 1);
      i = arrayOfByte[i] & 0xFF;
      if (arrayOfInt[i] != 0)
      {
        if (i == 34) {
          return findName(this._quadBuffer, paramInt, j, 4);
        }
        return parseEscapedFieldName(this._quadBuffer, paramInt, j, i, 4);
      }
      if (paramInt >= this._quadBuffer.length) {
        this._quadBuffer = growArrayBy(this._quadBuffer, paramInt);
      }
      this._quadBuffer[paramInt] = j;
      paramInt += 1;
    }
  }
  
  protected final Name parseMediumFieldName(int paramInt, int[] paramArrayOfInt)
  {
    byte[] arrayOfByte = this._inputBuffer;
    int i = this._inputPtr;
    this._inputPtr = (i + 1);
    i = arrayOfByte[i] & 0xFF;
    if (paramArrayOfInt[i] != 0)
    {
      if (i == 34) {
        return findName(this._quad1, paramInt, 1);
      }
      return parseFieldName(this._quad1, paramInt, i, 1);
    }
    paramInt = i | paramInt << 8;
    arrayOfByte = this._inputBuffer;
    i = this._inputPtr;
    this._inputPtr = (i + 1);
    i = arrayOfByte[i] & 0xFF;
    if (paramArrayOfInt[i] != 0)
    {
      if (i == 34) {
        return findName(this._quad1, paramInt, 2);
      }
      return parseFieldName(this._quad1, paramInt, i, 2);
    }
    paramInt = paramInt << 8 | i;
    arrayOfByte = this._inputBuffer;
    i = this._inputPtr;
    this._inputPtr = (i + 1);
    i = arrayOfByte[i] & 0xFF;
    if (paramArrayOfInt[i] != 0)
    {
      if (i == 34) {
        return findName(this._quad1, paramInt, 3);
      }
      return parseFieldName(this._quad1, paramInt, i, 3);
    }
    paramInt = paramInt << 8 | i;
    arrayOfByte = this._inputBuffer;
    i = this._inputPtr;
    this._inputPtr = (i + 1);
    i = arrayOfByte[i] & 0xFF;
    if (paramArrayOfInt[i] != 0)
    {
      if (i == 34) {
        return findName(this._quad1, paramInt, 4);
      }
      return parseFieldName(this._quad1, paramInt, i, 4);
    }
    this._quadBuffer[0] = this._quad1;
    this._quadBuffer[1] = paramInt;
    return parseLongFieldName(i);
  }
  
  protected final JsonToken parseNumberText(int paramInt)
  {
    int k = 1;
    char[] arrayOfChar = this._textBuffer.emptyAndGetCurrentSegment();
    if (paramInt == 45) {}
    byte[] arrayOfByte;
    for (boolean bool = true;; bool = false)
    {
      if (!bool) {
        break label306;
      }
      arrayOfChar[0] = '-';
      if (this._inputPtr >= this._inputEnd) {
        loadMoreGuaranteed();
      }
      arrayOfByte = this._inputBuffer;
      paramInt = this._inputPtr;
      this._inputPtr = (paramInt + 1);
      paramInt = arrayOfByte[paramInt] & 0xFF;
      if ((paramInt >= 48) && (paramInt <= 57)) {
        break;
      }
      return _handleInvalidNumberStart(paramInt, true);
    }
    label306:
    for (int i = 1;; i = 0)
    {
      int j = paramInt;
      if (paramInt == 48) {
        j = _verifyNoLeadingZeroes();
      }
      int m = i + 1;
      arrayOfChar[i] = ((char)j);
      int n = this._inputPtr + arrayOfChar.length;
      paramInt = n;
      i = m;
      j = k;
      if (n > this._inputEnd)
      {
        paramInt = this._inputEnd;
        j = k;
        i = m;
      }
      for (;;)
      {
        if (this._inputPtr >= paramInt) {
          return _parserNumber2(arrayOfChar, i, bool, j);
        }
        arrayOfByte = this._inputBuffer;
        k = this._inputPtr;
        this._inputPtr = (k + 1);
        k = arrayOfByte[k] & 0xFF;
        if ((k < 48) || (k > 57))
        {
          if ((k != 46) && (k != 101) && (k != 69)) {
            break;
          }
          return _parseFloatText(arrayOfChar, i, k, bool, j);
        }
        j += 1;
        arrayOfChar[i] = ((char)k);
        i += 1;
      }
      this._inputPtr -= 1;
      this._textBuffer.setCurrentLength(i);
      return resetInt(bool, j);
    }
  }
  
  public int releaseBuffered(OutputStream paramOutputStream)
  {
    int i = this._inputEnd - this._inputPtr;
    if (i < 1) {
      return 0;
    }
    int j = this._inputPtr;
    paramOutputStream.write(this._inputBuffer, j, i);
    return i;
  }
  
  public void setCodec(ObjectCodec paramObjectCodec)
  {
    this._objectCodec = paramObjectCodec;
  }
  
  protected Name slowParseFieldName()
  {
    if ((this._inputPtr >= this._inputEnd) && (!loadMore())) {
      _reportInvalidEOF(": was expecting closing '\"' for name");
    }
    byte[] arrayOfByte = this._inputBuffer;
    int i = this._inputPtr;
    this._inputPtr = (i + 1);
    i = arrayOfByte[i] & 0xFF;
    if (i == 34) {
      return BytesToNameCanonicalizer.getEmptyName();
    }
    return parseEscapedFieldName(this._quadBuffer, 0, 0, i, 0);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/impl/Utf8StreamParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */