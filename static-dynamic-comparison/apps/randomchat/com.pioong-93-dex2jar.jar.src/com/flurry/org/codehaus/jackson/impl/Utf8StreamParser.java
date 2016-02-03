package com.flurry.org.codehaus.jackson.impl;

import com.flurry.org.codehaus.jackson.Base64Variant;
import com.flurry.org.codehaus.jackson.JsonParseException;
import com.flurry.org.codehaus.jackson.JsonParser.Feature;
import com.flurry.org.codehaus.jackson.JsonToken;
import com.flurry.org.codehaus.jackson.ObjectCodec;
import com.flurry.org.codehaus.jackson.SerializableString;
import com.flurry.org.codehaus.jackson.io.IOContext;
import com.flurry.org.codehaus.jackson.sym.BytesToNameCanonicalizer;
import com.flurry.org.codehaus.jackson.sym.Name;
import com.flurry.org.codehaus.jackson.util.ByteArrayBuilder;
import com.flurry.org.codehaus.jackson.util.CharTypes;
import com.flurry.org.codehaus.jackson.util.TextBuffer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

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
    throws IOException, JsonParseException
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
    return (paramInt & 0x1F) << 6 | i & 0x3F;
  }
  
  private final int _decodeUtf8_3(int paramInt)
    throws IOException, JsonParseException
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
    throws IOException, JsonParseException
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
    throws IOException, JsonParseException
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
    return ((((paramInt & 0x7) << 6 | i & 0x3F) << 6 | j & 0x3F) << 6 | k & 0x3F) - 65536;
  }
  
  private final void _finishString2(char[] paramArrayOfChar, int paramInt)
    throws IOException, JsonParseException
  {
    int[] arrayOfInt = sInputCodesUtf8;
    byte[] arrayOfByte = this._inputBuffer;
    int j;
    int i;
    for (char[] arrayOfChar = paramArrayOfChar;; arrayOfChar = paramArrayOfChar)
    {
      j = this._inputPtr;
      i = j;
      if (j >= this._inputEnd)
      {
        loadMoreGuaranteed();
        i = this._inputPtr;
      }
      paramArrayOfChar = arrayOfChar;
      j = paramInt;
      if (paramInt >= arrayOfChar.length)
      {
        paramArrayOfChar = this._textBuffer.finishCurrentSegment();
        j = 0;
      }
      int k = Math.min(this._inputEnd, paramArrayOfChar.length - j + i);
      paramInt = j;
      while (i < k)
      {
        j = i + 1;
        i = arrayOfByte[i] & 0xFF;
        if (arrayOfInt[i] != 0)
        {
          this._inputPtr = j;
          if (i != 34) {
            break label158;
          }
          this._textBuffer.setCurrentLength(paramInt);
          return;
        }
        paramArrayOfChar[paramInt] = ((char)i);
        i = j;
        paramInt += 1;
      }
      this._inputPtr = i;
    }
    label158:
    switch (arrayOfInt[i])
    {
    default: 
      if (i < 32) {
        _throwUnquotedSpace(i, "string value");
      }
      break;
    }
    for (;;)
    {
      arrayOfChar = paramArrayOfChar;
      j = paramInt;
      if (paramInt >= paramArrayOfChar.length)
      {
        arrayOfChar = this._textBuffer.finishCurrentSegment();
        j = 0;
      }
      arrayOfChar[j] = ((char)i);
      paramInt = j + 1;
      break;
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
        j = _decodeUtf8_4(i);
        i = paramInt + 1;
        paramArrayOfChar[paramInt] = ((char)(0xD800 | j >> 10));
        arrayOfChar = paramArrayOfChar;
        paramInt = i;
        if (i >= paramArrayOfChar.length)
        {
          arrayOfChar = this._textBuffer.finishCurrentSegment();
          paramInt = 0;
        }
        i = 0xDC00 | j & 0x3FF;
        paramArrayOfChar = arrayOfChar;
        continue;
        _reportInvalidChar(i);
      }
    }
  }
  
  private final void _isNextTokenNameNo(int paramInt)
    throws IOException, JsonParseException
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
    throws IOException, JsonParseException
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
    throws IOException, JsonParseException
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
    throws IOException, JsonParseException
  {
    int i1 = 0;
    int m = 0;
    int i = 0;
    int i2 = 0;
    Object localObject = paramArrayOfChar;
    int j = paramInt1;
    int n = paramInt2;
    if (paramInt2 == 46)
    {
      paramArrayOfChar[paramInt1] = ((char)paramInt2);
      paramInt1 += 1;
      k = paramInt2;
      paramInt2 = m;
      if ((this._inputPtr < this._inputEnd) || (loadMore())) {
        break label470;
      }
      m = 1;
      label63:
      i = m;
      i1 = paramInt2;
      localObject = paramArrayOfChar;
      j = paramInt1;
      n = k;
      if (paramInt2 == 0)
      {
        reportUnexpectedNumberChar(k, "Decimal point not followed by a digit");
        n = k;
        j = paramInt1;
        localObject = paramArrayOfChar;
        i1 = paramInt2;
        i = m;
      }
    }
    int k = 0;
    m = 0;
    if (n != 101)
    {
      paramInt1 = i;
      i2 = j;
      if (n != 69) {}
    }
    else
    {
      paramArrayOfChar = (char[])localObject;
      paramInt2 = j;
      if (j >= localObject.length)
      {
        paramArrayOfChar = this._textBuffer.finishCurrentSegment();
        paramInt2 = 0;
      }
      paramInt1 = paramInt2 + 1;
      paramArrayOfChar[paramInt2] = ((char)n);
      if (this._inputPtr >= this._inputEnd) {
        loadMoreGuaranteed();
      }
      localObject = this._inputBuffer;
      paramInt2 = this._inputPtr;
      this._inputPtr = (paramInt2 + 1);
      paramInt2 = localObject[paramInt2] & 0xFF;
      if ((paramInt2 != 45) && (paramInt2 != 43)) {
        break label616;
      }
      if (paramInt1 < paramArrayOfChar.length) {
        break label613;
      }
      paramArrayOfChar = this._textBuffer.finishCurrentSegment();
      paramInt1 = 0;
      label240:
      paramArrayOfChar[paramInt1] = ((char)paramInt2);
      if (this._inputPtr >= this._inputEnd) {
        loadMoreGuaranteed();
      }
      localObject = this._inputBuffer;
      paramInt2 = this._inputPtr;
      this._inputPtr = (paramInt2 + 1);
      paramInt2 = localObject[paramInt2] & 0xFF;
      paramInt1 += 1;
      k = m;
    }
    for (;;)
    {
      n = i;
      m = k;
      j = paramInt1;
      if (paramInt2 <= 57)
      {
        n = i;
        m = k;
        j = paramInt1;
        if (paramInt2 >= 48)
        {
          k += 1;
          localObject = paramArrayOfChar;
          j = paramInt1;
          if (paramInt1 >= paramArrayOfChar.length)
          {
            localObject = this._textBuffer.finishCurrentSegment();
            j = 0;
          }
          paramInt1 = j + 1;
          localObject[j] = ((char)paramInt2);
          if ((this._inputPtr < this._inputEnd) || (loadMore())) {
            break label582;
          }
          n = 1;
          j = paramInt1;
          m = k;
        }
      }
      paramInt1 = n;
      k = m;
      i2 = j;
      if (m == 0)
      {
        reportUnexpectedNumberChar(paramInt2, "Exponent indicator not followed by a digit");
        i2 = j;
        k = m;
        paramInt1 = n;
      }
      if (paramInt1 == 0) {
        this._inputPtr -= 1;
      }
      this._textBuffer.setCurrentLength(i2);
      return resetFloat(paramBoolean, paramInt3, i1, k);
      label470:
      localObject = this._inputBuffer;
      i = this._inputPtr;
      this._inputPtr = (i + 1);
      i = localObject[i] & 0xFF;
      m = i2;
      k = i;
      if (i < 48) {
        break label63;
      }
      m = i2;
      k = i;
      if (i > 57) {
        break label63;
      }
      j = paramInt2 + 1;
      localObject = paramArrayOfChar;
      paramInt2 = paramInt1;
      if (paramInt1 >= paramArrayOfChar.length)
      {
        localObject = this._textBuffer.finishCurrentSegment();
        paramInt2 = 0;
      }
      localObject[paramInt2] = ((char)i);
      paramInt1 = paramInt2 + 1;
      paramInt2 = j;
      paramArrayOfChar = (char[])localObject;
      k = i;
      break;
      label582:
      paramArrayOfChar = this._inputBuffer;
      paramInt2 = this._inputPtr;
      this._inputPtr = (paramInt2 + 1);
      paramInt2 = paramArrayOfChar[paramInt2] & 0xFF;
      paramArrayOfChar = (char[])localObject;
      continue;
      label613:
      break label240;
      label616:
      k = m;
    }
  }
  
  private final JsonToken _parserNumber2(char[] paramArrayOfChar, int paramInt1, boolean paramBoolean, int paramInt2)
    throws IOException, JsonParseException
  {
    for (;;)
    {
      if ((this._inputPtr >= this._inputEnd) && (!loadMore()))
      {
        this._textBuffer.setCurrentLength(paramInt1);
        return resetInt(paramBoolean, paramInt2);
      }
      Object localObject = this._inputBuffer;
      int i = this._inputPtr;
      this._inputPtr = (i + 1);
      int j = localObject[i] & 0xFF;
      if ((j > 57) || (j < 48))
      {
        if ((j != 46) && (j != 101) && (j != 69)) {
          break;
        }
        return _parseFloatText(paramArrayOfChar, paramInt1, j, paramBoolean, paramInt2);
      }
      localObject = paramArrayOfChar;
      i = paramInt1;
      if (paramInt1 >= paramArrayOfChar.length)
      {
        localObject = this._textBuffer.finishCurrentSegment();
        i = 0;
      }
      localObject[i] = ((char)j);
      paramInt2 += 1;
      paramInt1 = i + 1;
      paramArrayOfChar = (char[])localObject;
    }
    this._inputPtr -= 1;
    this._textBuffer.setCurrentLength(paramInt1);
    return resetInt(paramBoolean, paramInt2);
  }
  
  private final void _skipCComment()
    throws IOException, JsonParseException
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
          break;
        case 2: 
          _skipUtf8_2(i);
          break;
        case 3: 
          _skipUtf8_3(i);
          break;
        case 4: 
          _skipUtf8_4(i);
        }
      }
    }
    _reportInvalidEOF(" in a comment");
  }
  
  private final int _skipColon()
    throws IOException, JsonParseException
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
      i = arrayOfByte[i] & 0xFF;
      if (i > 32)
      {
        if (i != 47)
        {
          return i;
          _skipCR();
          break;
          _skipLF();
          break;
          _skipComment();
          break;
        }
        _skipComment();
        continue;
      }
      if (i != 32) {
        if (i == 10) {
          _skipLF();
        } else if (i == 13) {
          _skipCR();
        } else if (i != 9) {
          _throwInvalidSpace(i);
        }
      }
    }
    label343:
    throw _constructError("Unexpected end-of-input within/between " + this._parsingContext.getTypeDesc() + " entries");
  }
  
  private final void _skipComment()
    throws IOException, JsonParseException
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
    throws IOException, JsonParseException
  {
    int[] arrayOfInt = CharTypes.getInputCodeComment();
    for (;;)
    {
      int i;
      int j;
      if ((this._inputPtr < this._inputEnd) || (loadMore()))
      {
        byte[] arrayOfByte = this._inputBuffer;
        i = this._inputPtr;
        this._inputPtr = (i + 1);
        i = arrayOfByte[i] & 0xFF;
        j = arrayOfInt[i];
        if (j == 0) {}
      }
      else
      {
        switch (j)
        {
        case 42: 
        default: 
          _reportInvalidChar(i);
          break;
        case 10: 
          _skipLF();
          return;
        case 13: 
          _skipCR();
          return;
        case 2: 
          _skipUtf8_2(i);
          break;
        case 3: 
          _skipUtf8_3(i);
          break;
        case 4: 
          _skipUtf8_4(i);
        }
      }
    }
  }
  
  private final void _skipUtf8_2(int paramInt)
    throws IOException, JsonParseException
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
    throws IOException, JsonParseException
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
    throws IOException, JsonParseException
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
    throws IOException, JsonParseException
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
    throws IOException, JsonParseException
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
    throws IOException, JsonParseException
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
    throws JsonParseException
  {
    int i3 = (paramInt1 << 2) - 4 + paramInt2;
    int i2;
    Object localObject1;
    int i;
    int m;
    label49:
    int j;
    int i1;
    int n;
    label120:
    Object localObject2;
    if (paramInt2 < 4)
    {
      i2 = paramArrayOfInt[(paramInt1 - 1)];
      paramArrayOfInt[(paramInt1 - 1)] = (i2 << (4 - paramInt2 << 3));
      localObject1 = this._textBuffer.emptyAndGetCurrentSegment();
      i = 0;
      m = 0;
      if (i >= i3) {
        break label521;
      }
      j = paramArrayOfInt[(i >> 2)] >> (3 - (i & 0x3) << 3) & 0xFF;
      int k = i + 1;
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
      k -= 65536;
      localObject2 = localObject1;
      if (m >= localObject1.length) {
        localObject2 = this._textBuffer.expandCurrentSegment();
      }
      j = m + 1;
      localObject2[m] = ((char)(55296 + (k >> 10)));
      i1 = 0xDC00 | k & 0x3FF;
      localObject1 = localObject2;
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (j >= localObject1.length) {
        localObject2 = this._textBuffer.expandCurrentSegment();
      }
      m = j + 1;
      localObject2[j] = ((char)i1);
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
      j = m;
      i = n;
    }
  }
  
  private final Name findName(int paramInt1, int paramInt2)
    throws JsonParseException
  {
    Name localName = this._symbols.findName(paramInt1);
    if (localName != null) {
      return localName;
    }
    this._quadBuffer[0] = paramInt1;
    return addName(this._quadBuffer, 1, paramInt2);
  }
  
  private final Name findName(int paramInt1, int paramInt2, int paramInt3)
    throws JsonParseException
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
    throws JsonParseException
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
    throws IOException, JsonParseException
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
    throws IOException, JsonParseException
  {
    return parseEscapedFieldName(this._quadBuffer, 0, paramInt1, paramInt2, paramInt3);
  }
  
  private final Name parseFieldName(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws IOException, JsonParseException
  {
    this._quadBuffer[0] = paramInt1;
    return parseEscapedFieldName(this._quadBuffer, 1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void _closeInput()
    throws IOException
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
    throws IOException, JsonParseException
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
          m = i << 6 | j;
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
          localByteArrayBuilder.appendThreeBytes(m << 6 | k);
        }
      }
    }
  }
  
  protected int _decodeCharForError(int paramInt)
    throws IOException, JsonParseException
  {
    int i = paramInt;
    if (paramInt < 0)
    {
      if ((paramInt & 0xE0) != 192) {
        break label145;
      }
      i = paramInt & 0x1F;
      paramInt = 1;
    }
    for (;;)
    {
      int j = nextByte();
      if ((j & 0xC0) != 128) {
        _reportInvalidOther(j & 0xFF);
      }
      j = i << 6 | j & 0x3F;
      i = j;
      if (paramInt > 1)
      {
        i = nextByte();
        if ((i & 0xC0) != 128) {
          _reportInvalidOther(i & 0xFF);
        }
        j = j << 6 | i & 0x3F;
        i = j;
        if (paramInt > 2)
        {
          paramInt = nextByte();
          if ((paramInt & 0xC0) != 128) {
            _reportInvalidOther(paramInt & 0xFF);
          }
          i = j << 6 | paramInt & 0x3F;
        }
      }
      return i;
      label145:
      if ((paramInt & 0xF0) == 224)
      {
        i = paramInt & 0xF;
        paramInt = 2;
      }
      else if ((paramInt & 0xF8) == 240)
      {
        i = paramInt & 0x7;
        paramInt = 3;
      }
      else
      {
        _reportInvalidInitial(paramInt & 0xFF);
        j = 1;
        i = paramInt;
        paramInt = j;
      }
    }
  }
  
  protected final char _decodeEscaped()
    throws IOException, JsonParseException
  {
    if ((this._inputPtr >= this._inputEnd) && (!loadMore())) {
      _reportInvalidEOF(" in character escape sequence");
    }
    byte[] arrayOfByte = this._inputBuffer;
    int i = this._inputPtr;
    this._inputPtr = (i + 1);
    i = arrayOfByte[i];
    switch (i)
    {
    default: 
      return _handleUnrecognizedCharacterEscape((char)_decodeCharForError(i));
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
      return (char)i;
    }
    int j = 0;
    i = 0;
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
    throws IOException, JsonParseException
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
    int m = Math.min(this._inputEnd, arrayOfChar.length + i);
    byte[] arrayOfByte = this._inputBuffer;
    int k = 0;
    j = i;
    i = k;
    while (j < m)
    {
      k = arrayOfByte[j] & 0xFF;
      if (arrayOfInt[k] != 0)
      {
        if (k != 34) {
          break;
        }
        this._inputPtr = (j + 1);
        this._textBuffer.setCurrentLength(i);
        return;
      }
      j += 1;
      arrayOfChar[i] = ((char)k);
      i += 1;
    }
    this._inputPtr = j;
    _finishString2(arrayOfChar, i);
  }
  
  protected final String _getText2(JsonToken paramJsonToken)
  {
    if (paramJsonToken == null) {
      return null;
    }
    switch (paramJsonToken)
    {
    default: 
      return paramJsonToken.asString();
    case ???: 
      return this._parsingContext.getCurrentName();
    }
    return this._textBuffer.contentsAsString();
  }
  
  protected JsonToken _handleApostropheValue()
    throws IOException, JsonParseException
  {
    int i = 0;
    Object localObject2 = this._textBuffer.emptyAndGetCurrentSegment();
    int[] arrayOfInt = sInputCodesUtf8;
    byte[] arrayOfByte = this._inputBuffer;
    if (this._inputPtr >= this._inputEnd) {
      loadMoreGuaranteed();
    }
    Object localObject1 = localObject2;
    int k = i;
    if (i >= localObject2.length)
    {
      localObject1 = this._textBuffer.finishCurrentSegment();
      k = 0;
    }
    i = this._inputEnd;
    int n = this._inputPtr + (localObject1.length - k);
    int m = i;
    int j = k;
    if (n < i)
    {
      m = n;
      j = k;
    }
    for (;;)
    {
      localObject2 = localObject1;
      i = j;
      if (this._inputPtr >= m) {
        break;
      }
      i = this._inputPtr;
      this._inputPtr = (i + 1);
      n = arrayOfByte[i] & 0xFF;
      if ((n == 39) || (arrayOfInt[n] != 0))
      {
        if (n != 39) {
          break label180;
        }
        this._textBuffer.setCurrentLength(j);
        return JsonToken.VALUE_STRING;
      }
      localObject1[j] = ((char)n);
      j += 1;
    }
    label180:
    switch (arrayOfInt[n])
    {
    default: 
      if (n < 32) {
        _throwUnquotedSpace(n, "string value");
      }
      _reportInvalidChar(n);
      k = j;
      localObject2 = localObject1;
      i = n;
    case 1: 
    case 2: 
    case 3: 
      for (;;)
      {
        localObject1 = localObject2;
        j = k;
        if (k >= localObject2.length)
        {
          localObject1 = this._textBuffer.finishCurrentSegment();
          j = 0;
        }
        localObject1[j] = ((char)i);
        i = j + 1;
        localObject2 = localObject1;
        break;
        i = n;
        localObject2 = localObject1;
        k = j;
        if (n != 34)
        {
          i = _decodeEscaped();
          localObject2 = localObject1;
          k = j;
          continue;
          i = _decodeUtf8_2(n);
          localObject2 = localObject1;
          k = j;
          continue;
          if (this._inputEnd - this._inputPtr >= 2)
          {
            i = _decodeUtf8_3fast(n);
            localObject2 = localObject1;
            k = j;
          }
          else
          {
            i = _decodeUtf8_3(n);
            localObject2 = localObject1;
            k = j;
          }
        }
      }
    }
    i = _decodeUtf8_4(n);
    k = j + 1;
    localObject1[j] = ((char)(0xD800 | i >> 10));
    if (k >= localObject1.length)
    {
      localObject1 = this._textBuffer.finishCurrentSegment();
      k = 0;
    }
    for (;;)
    {
      i = 0xDC00 | i & 0x3FF;
      localObject2 = localObject1;
      break;
    }
  }
  
  protected JsonToken _handleInvalidNumberStart(int paramInt, boolean paramBoolean)
    throws IOException, JsonParseException
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
    throws IOException, JsonParseException
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
    throws IOException, JsonParseException
  {
    if ((paramInt == 39) && (isEnabled(JsonParser.Feature.ALLOW_SINGLE_QUOTES)))
    {
      localObject1 = _parseApostropheFieldName();
      return (Name)localObject1;
    }
    if (!isEnabled(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES)) {
      _reportUnexpectedChar(paramInt, "was expecting double-quote to start field name");
    }
    Object localObject3 = CharTypes.getInputCodeUtf8JsNames();
    if (localObject3[paramInt] != 0) {
      _reportUnexpectedChar(paramInt, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
    }
    Object localObject1 = this._quadBuffer;
    int j = 0;
    int k = 0;
    int m = 0;
    int i = paramInt;
    paramInt = m;
    for (;;)
    {
      if (k < 4)
      {
        k += 1;
        j = j << 8 | i;
        i = k;
      }
      for (;;)
      {
        if ((this._inputPtr >= this._inputEnd) && (!loadMore())) {
          _reportInvalidEOF(" in field name");
        }
        m = this._inputBuffer[this._inputPtr] & 0xFF;
        if (localObject3[m] == 0) {
          break label285;
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
        localObject3 = this._symbols.findName((int[])localObject2, k);
        localObject1 = localObject3;
        if (localObject3 != null) {
          break;
        }
        return addName((int[])localObject2, k, i);
        localObject2 = localObject1;
        if (paramInt >= localObject1.length)
        {
          localObject2 = growArrayBy((int[])localObject1, localObject1.length);
          this._quadBuffer = ((int[])localObject2);
        }
        k = paramInt + 1;
        localObject2[paramInt] = j;
        paramInt = 1;
        j = i;
        i = paramInt;
        paramInt = k;
        localObject1 = localObject2;
      }
      label285:
      this._inputPtr += 1;
      k = i;
      i = m;
    }
  }
  
  protected final boolean _loadToHaveAtLeast(int paramInt)
    throws IOException
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
      this._inputEnd += j;
    }
    label186:
    return true;
  }
  
  protected final void _matchToken(String paramString, int paramInt)
    throws IOException, JsonParseException
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
    throws IOException, JsonParseException
  {
    if ((this._inputPtr >= this._inputEnd) && (!loadMore())) {
      _reportInvalidEOF(": was expecting closing ''' for name");
    }
    Object localObject1 = this._inputBuffer;
    int i = this._inputPtr;
    this._inputPtr = (i + 1);
    int m = localObject1[i] & 0xFF;
    if (m == 39) {
      localObject1 = BytesToNameCanonicalizer.getEmptyName();
    }
    int j;
    Object localObject3;
    do
    {
      return (Name)localObject1;
      localObject1 = this._quadBuffer;
      k = 0;
      j = 0;
      localObject3 = sInputCodesLatin1;
      i = 0;
      if (m != 39) {
        break;
      }
      if (j <= 0) {
        break label619;
      }
      localObject2 = localObject1;
      if (i >= localObject1.length)
      {
        localObject2 = growArrayBy((int[])localObject1, localObject1.length);
        this._quadBuffer = ((int[])localObject2);
      }
      m = i + 1;
      localObject2[i] = k;
      i = m;
      localObject3 = this._symbols.findName((int[])localObject2, i);
      localObject1 = localObject3;
    } while (localObject3 != null);
    return addName((int[])localObject2, i, j);
    int n = m;
    int i3 = k;
    int i4 = j;
    int i2 = i;
    Object localObject2 = localObject1;
    if (m != 34)
    {
      n = m;
      i3 = k;
      i4 = j;
      i2 = i;
      localObject2 = localObject1;
      if (localObject3[m] != 0)
      {
        if (m == 92) {
          break label458;
        }
        _throwUnquotedSpace(m, "name");
      }
    }
    label352:
    label399:
    label458:
    for (int i1 = m;; i1 = _decodeEscaped())
    {
      n = i1;
      i3 = k;
      i4 = j;
      i2 = i;
      localObject2 = localObject1;
      if (i1 > 127)
      {
        i2 = k;
        n = j;
        m = i;
        localObject2 = localObject1;
        if (j >= 4)
        {
          localObject2 = localObject1;
          if (i >= localObject1.length)
          {
            localObject2 = growArrayBy((int[])localObject1, localObject1.length);
            this._quadBuffer = ((int[])localObject2);
          }
          localObject2[i] = k;
          i2 = 0;
          n = 0;
          m = i + 1;
        }
        if (i1 >= 2048) {
          break label467;
        }
        i = i2 << 8 | i1 >> 6 | 0xC0;
        k = n + 1;
        j = m;
        n = i1 & 0x3F | 0x80;
        i2 = j;
        i4 = k;
        i3 = i;
      }
      if (i4 >= 4) {
        break label571;
      }
      j = i4 + 1;
      k = i3 << 8 | n;
      i = i2;
      localObject1 = localObject2;
      if ((this._inputPtr >= this._inputEnd) && (!loadMore())) {
        _reportInvalidEOF(" in field name");
      }
      localObject2 = this._inputBuffer;
      m = this._inputPtr;
      this._inputPtr = (m + 1);
      m = localObject2[m] & 0xFF;
      break;
    }
    label467:
    int k = i2 << 8 | i1 >> 12 | 0xE0;
    i = n + 1;
    if (i >= 4)
    {
      localObject1 = localObject2;
      if (m >= localObject2.length)
      {
        localObject1 = growArrayBy((int[])localObject2, localObject2.length);
        this._quadBuffer = ((int[])localObject1);
      }
      j = m + 1;
      localObject1[m] = k;
      k = 0;
      i = 0;
    }
    for (;;)
    {
      k = k << 8 | i1 >> 6 & 0x3F | 0x80;
      m = i + 1;
      i = k;
      k = m;
      localObject2 = localObject1;
      break label352;
      label571:
      localObject1 = localObject2;
      if (i2 >= localObject2.length)
      {
        localObject1 = growArrayBy((int[])localObject2, localObject2.length);
        this._quadBuffer = ((int[])localObject1);
      }
      i = i2 + 1;
      localObject1[i2] = i3;
      k = n;
      j = 1;
      break label399;
      label619:
      localObject2 = localObject1;
      break;
      j = m;
      localObject1 = localObject2;
    }
  }
  
  protected final Name _parseFieldName(int paramInt)
    throws IOException, JsonParseException
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
    throws IOException
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
    throws JsonParseException
  {
    if (paramInt < 32) {
      _throwInvalidSpace(paramInt);
    }
    _reportInvalidInitial(paramInt);
  }
  
  protected void _reportInvalidInitial(int paramInt)
    throws JsonParseException
  {
    _reportError("Invalid UTF-8 start byte 0x" + Integer.toHexString(paramInt));
  }
  
  protected void _reportInvalidOther(int paramInt)
    throws JsonParseException
  {
    _reportError("Invalid UTF-8 middle byte 0x" + Integer.toHexString(paramInt));
  }
  
  protected void _reportInvalidOther(int paramInt1, int paramInt2)
    throws JsonParseException
  {
    this._inputPtr = paramInt2;
    _reportInvalidOther(paramInt1);
  }
  
  protected void _reportInvalidToken(String paramString1, String paramString2)
    throws IOException, JsonParseException
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
    throws IOException
  {
    if (((this._inputPtr < this._inputEnd) || (loadMore())) && (this._inputBuffer[this._inputPtr] == 10)) {
      this._inputPtr += 1;
    }
    this._currInputRow += 1;
    this._currInputRowStart = this._inputPtr;
  }
  
  protected final void _skipLF()
    throws IOException
  {
    this._currInputRow += 1;
    this._currInputRowStart = this._inputPtr;
  }
  
  protected void _skipString()
    throws IOException, JsonParseException
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
    label198:
    for (;;)
    {
      if (i < j)
      {
        k = i + 1;
        m = arrayOfByte[i] & 0xFF;
        i = k;
        if (arrayOfInt[m] == 0) {
          break label198;
        }
        this._inputPtr = k;
        if (m != 34) {}
      }
      else
      {
        this._inputPtr = i;
        break;
      }
      switch (arrayOfInt[m])
      {
      default: 
        if (m < 32) {
          _throwUnquotedSpace(m, "string value");
        }
        break;
      case 1: 
        _decodeEscaped();
        break;
      case 2: 
        _skipUtf8_2(m);
        break;
      case 3: 
        _skipUtf8_3(m);
        break;
      case 4: 
        _skipUtf8_4(m);
        break;
        _reportInvalidChar(m);
        break;
      }
    }
  }
  
  public void close()
    throws IOException
  {
    super.close();
    this._symbols.release();
  }
  
  public byte[] getBinaryValue(Base64Variant paramBase64Variant)
    throws IOException, JsonParseException
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
    throws IOException, JsonParseException
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
    throws IOException, JsonParseException
  {
    if (this._currToken != null)
    {
      switch (this._currToken)
      {
      default: 
        return this._currToken.asCharArray();
      case ???: 
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
      case ???: 
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
    throws IOException, JsonParseException
  {
    int i = 0;
    if (this._currToken != null) {}
    switch (this._currToken)
    {
    default: 
      i = this._currToken.asCharArray().length;
      return i;
    case ???: 
      return this._parsingContext.getCurrentName().length();
    case ???: 
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
    throws IOException, JsonParseException
  {
    if (this._currToken != null) {}
    switch (this._currToken)
    {
    case ???: 
    default: 
      return 0;
    case ???: 
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
    throws IOException
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
    throws IOException, JsonParseException
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
    switch (nextToken())
    {
    default: 
      return null;
    case ???: 
      return Boolean.TRUE;
    }
    return Boolean.FALSE;
  }
  
  public boolean nextFieldName(SerializableString paramSerializableString)
    throws IOException, JsonParseException
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
          j = 0;
          n = this._inputPtr;
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
    throws IOException, JsonParseException
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
    throws IOException, JsonParseException
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
    throws IOException, JsonParseException
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
    throws IOException, JsonParseException
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
    throws IOException, JsonParseException
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
          break label491;
        }
        if (paramInt4 < 4) {
          break label488;
        }
        localObject1 = paramArrayOfInt;
        if (paramInt1 >= paramArrayOfInt.length)
        {
          localObject1 = growArrayBy(paramArrayOfInt, paramArrayOfInt.length);
          this._quadBuffer = ((int[])localObject1);
        }
        i = paramInt1 + 1;
        localObject1[paramInt1] = paramInt2;
        paramInt2 = 0;
        paramInt4 = 0;
        paramArrayOfInt = (int[])localObject1;
        paramInt1 = i;
        label179:
        if (paramInt3 >= 2048) {
          break label325;
        }
        i = paramInt2 << 8 | paramInt3 >> 6 | 0xC0;
        paramInt2 = paramInt4 + 1;
        paramInt4 = paramInt1;
        paramInt1 = i;
        paramInt3 = paramInt3 & 0x3F | 0x80;
        i = paramInt2;
        paramInt2 = paramInt3;
        paramInt3 = paramInt1;
        paramInt1 = paramInt4;
      }
    }
    for (;;)
    {
      if (i < 4)
      {
        paramInt4 = i + 1;
        paramInt2 = paramInt3 << 8 | paramInt2;
        label257:
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
        label325:
        paramInt2 = paramInt2 << 8 | paramInt3 >> 12 | 0xE0;
        i = paramInt4 + 1;
        if (i < 4) {
          break label479;
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
        paramInt1 = i;
        paramArrayOfInt = (int[])localObject1;
      }
      for (;;)
      {
        i = paramInt4 << 8 | paramInt3 >> 6 & 0x3F | 0x80;
        paramInt2 += 1;
        paramInt4 = paramInt1;
        paramInt1 = i;
        break;
        localObject1 = paramArrayOfInt;
        if (paramInt1 >= paramArrayOfInt.length)
        {
          localObject1 = growArrayBy(paramArrayOfInt, paramArrayOfInt.length);
          this._quadBuffer = ((int[])localObject1);
        }
        paramInt4 = paramInt1 + 1;
        localObject1[paramInt1] = paramInt3;
        paramInt3 = 1;
        paramArrayOfInt = (int[])localObject1;
        paramInt1 = paramInt4;
        paramInt4 = paramInt3;
        break label257;
        label479:
        paramInt4 = paramInt2;
        paramInt2 = i;
      }
      label488:
      break label179;
      label491:
      paramInt3 = paramInt2;
      paramInt2 = i;
      i = paramInt4;
    }
  }
  
  protected Name parseLongFieldName(int paramInt)
    throws IOException, JsonParseException
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
    throws IOException, JsonParseException
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
    paramInt = paramInt << 8 | i;
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
    throws IOException, JsonParseException
  {
    char[] arrayOfChar = this._textBuffer.emptyAndGetCurrentSegment();
    if (paramInt == 45) {}
    byte[] arrayOfByte;
    for (boolean bool = true; bool; bool = false)
    {
      i = 0 + 1;
      arrayOfChar[0] = '-';
      if (this._inputPtr >= this._inputEnd) {
        loadMoreGuaranteed();
      }
      arrayOfByte = this._inputBuffer;
      paramInt = this._inputPtr;
      this._inputPtr = (paramInt + 1);
      j = arrayOfByte[paramInt] & 0xFF;
      if (j >= 48)
      {
        paramInt = j;
        if (j <= 57) {
          break label104;
        }
      }
      return _handleInvalidNumberStart(j, true);
    }
    int i = 0;
    label104:
    int j = paramInt;
    if (paramInt == 48) {
      j = _verifyNoLeadingZeroes();
    }
    int k = i + 1;
    arrayOfChar[i] = ((char)j);
    int m = 1;
    int n = this._inputPtr + arrayOfChar.length;
    i = k;
    j = m;
    paramInt = n;
    if (n > this._inputEnd)
    {
      paramInt = this._inputEnd;
      j = m;
      i = k;
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
  
  public int releaseBuffered(OutputStream paramOutputStream)
    throws IOException
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
    throws IOException, JsonParseException
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/impl/Utf8StreamParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */