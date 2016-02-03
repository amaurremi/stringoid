package com.flurry.org.codehaus.jackson.impl;

import com.flurry.org.codehaus.jackson.Base64Variant;
import com.flurry.org.codehaus.jackson.JsonParseException;
import com.flurry.org.codehaus.jackson.JsonParser.Feature;
import com.flurry.org.codehaus.jackson.JsonToken;
import com.flurry.org.codehaus.jackson.ObjectCodec;
import com.flurry.org.codehaus.jackson.io.IOContext;
import com.flurry.org.codehaus.jackson.sym.CharsToNameCanonicalizer;
import com.flurry.org.codehaus.jackson.util.ByteArrayBuilder;
import com.flurry.org.codehaus.jackson.util.CharTypes;
import com.flurry.org.codehaus.jackson.util.TextBuffer;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public final class ReaderBasedParser
  extends JsonParserBase
{
  protected char[] _inputBuffer;
  protected ObjectCodec _objectCodec;
  protected Reader _reader;
  protected final CharsToNameCanonicalizer _symbols;
  protected boolean _tokenIncomplete = false;
  
  public ReaderBasedParser(IOContext paramIOContext, int paramInt, Reader paramReader, ObjectCodec paramObjectCodec, CharsToNameCanonicalizer paramCharsToNameCanonicalizer)
  {
    super(paramIOContext, paramInt);
    this._reader = paramReader;
    this._inputBuffer = paramIOContext.allocTokenBuffer();
    this._objectCodec = paramObjectCodec;
    this._symbols = paramCharsToNameCanonicalizer;
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
  
  private String _parseFieldName2(int paramInt1, int paramInt2, int paramInt3)
    throws IOException, JsonParseException
  {
    this._textBuffer.resetWithShared(this._inputBuffer, paramInt1, this._inputPtr - paramInt1);
    Object localObject = this._textBuffer.getCurrentSegment();
    paramInt1 = this._textBuffer.getCurrentSegmentSize();
    for (;;)
    {
      if ((this._inputPtr >= this._inputEnd) && (!loadMore())) {
        _reportInvalidEOF(": was expecting closing '" + (char)paramInt3 + "' for name");
      }
      char[] arrayOfChar = this._inputBuffer;
      int k = this._inputPtr;
      this._inputPtr = (k + 1);
      int j = arrayOfChar[k];
      int i = j;
      if (j <= 92)
      {
        if (j != 92) {
          break label174;
        }
        i = _decodeEscaped();
      }
      for (;;)
      {
        paramInt2 = paramInt2 * 31 + j;
        k = paramInt1 + 1;
        localObject[paramInt1] = i;
        if (k < localObject.length) {
          break label262;
        }
        localObject = this._textBuffer.finishCurrentSegment();
        paramInt1 = 0;
        break;
        label174:
        i = j;
        if (j <= paramInt3)
        {
          if (j == paramInt3)
          {
            this._textBuffer.setCurrentLength(paramInt1);
            localObject = this._textBuffer;
            arrayOfChar = ((TextBuffer)localObject).getTextBuffer();
            paramInt1 = ((TextBuffer)localObject).getTextOffset();
            paramInt3 = ((TextBuffer)localObject).size();
            return this._symbols.findSymbol(arrayOfChar, paramInt1, paramInt3, paramInt2);
          }
          i = j;
          if (j < 32)
          {
            _throwUnquotedSpace(j, "name");
            i = j;
          }
        }
      }
      label262:
      paramInt1 = k;
    }
  }
  
  private String _parseUnusualFieldName2(int paramInt1, int paramInt2, int[] paramArrayOfInt)
    throws IOException, JsonParseException
  {
    this._textBuffer.resetWithShared(this._inputBuffer, paramInt1, this._inputPtr - paramInt1);
    char[] arrayOfChar = this._textBuffer.getCurrentSegment();
    paramInt1 = this._textBuffer.getCurrentSegmentSize();
    int k = paramArrayOfInt.length;
    for (;;)
    {
      if ((this._inputPtr >= this._inputEnd) && (!loadMore())) {}
      int j;
      for (;;)
      {
        this._textBuffer.setCurrentLength(paramInt1);
        paramArrayOfInt = this._textBuffer;
        arrayOfChar = paramArrayOfInt.getTextBuffer();
        paramInt1 = paramArrayOfInt.getTextOffset();
        j = paramArrayOfInt.size();
        return this._symbols.findSymbol(arrayOfChar, paramInt1, j, paramInt2);
        int i = this._inputBuffer[this._inputPtr];
        if (i <= k)
        {
          if (paramArrayOfInt[i] != 0) {}
        }
        else {
          while (Character.isJavaIdentifierPart(i))
          {
            this._inputPtr += 1;
            paramInt2 = paramInt2 * 31 + i;
            j = paramInt1 + 1;
            arrayOfChar[paramInt1] = i;
            if (j < arrayOfChar.length) {
              break label188;
            }
            arrayOfChar = this._textBuffer.finishCurrentSegment();
            paramInt1 = 0;
            break;
          }
        }
      }
      label188:
      paramInt1 = j;
    }
  }
  
  private final void _skipCComment()
    throws IOException, JsonParseException
  {
    for (;;)
    {
      int i;
      if ((this._inputPtr < this._inputEnd) || (loadMore()))
      {
        char[] arrayOfChar = this._inputBuffer;
        i = this._inputPtr;
        this._inputPtr = (i + 1);
        i = arrayOfChar[i];
        if (i > 42) {
          continue;
        }
        if (i != 42) {
          break label101;
        }
        if ((this._inputPtr < this._inputEnd) || (loadMore())) {}
      }
      else
      {
        _reportInvalidEOF(" in a comment");
        return;
      }
      if (this._inputBuffer[this._inputPtr] == '/')
      {
        this._inputPtr += 1;
        return;
        label101:
        if (i < 32) {
          if (i == 10) {
            _skipLF();
          } else if (i == 13) {
            _skipCR();
          } else if (i != 9) {
            _throwInvalidSpace(i);
          }
        }
      }
    }
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
    char[] arrayOfChar = this._inputBuffer;
    int i = this._inputPtr;
    this._inputPtr = (i + 1);
    i = arrayOfChar[i];
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
    for (;;)
    {
      int i;
      if ((this._inputPtr < this._inputEnd) || (loadMore()))
      {
        char[] arrayOfChar = this._inputBuffer;
        i = this._inputPtr;
        this._inputPtr = (i + 1);
        i = arrayOfChar[i];
        if (i >= 32) {
          continue;
        }
        if (i == 10) {
          _skipLF();
        }
      }
      else
      {
        return;
      }
      if (i == 13)
      {
        _skipCR();
        return;
      }
      if (i != 9) {
        _throwInvalidSpace(i);
      }
    }
  }
  
  private final int _skipWS()
    throws IOException, JsonParseException
  {
    while ((this._inputPtr < this._inputEnd) || (loadMore()))
    {
      char[] arrayOfChar = this._inputBuffer;
      int i = this._inputPtr;
      this._inputPtr = (i + 1);
      i = arrayOfChar[i];
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
      char[] arrayOfChar = this._inputBuffer;
      i = this._inputPtr;
      this._inputPtr = (i + 1);
      int j = arrayOfChar[i];
      if (j > 32)
      {
        i = j;
        if (j != 47) {
          return i;
        }
        _skipComment();
      }
      else if (j != 32)
      {
        if (j == 10) {
          _skipLF();
        } else if (j == 13) {
          _skipCR();
        } else if (j != 9) {
          _throwInvalidSpace(j);
        }
      }
    }
    _handleEOF();
    int i = -1;
    return i;
  }
  
  private final char _verifyNoLeadingZeroes()
    throws IOException, JsonParseException
  {
    if ((this._inputPtr >= this._inputEnd) && (!loadMore())) {}
    char c2;
    do
    {
      for (char c1 = '0'; (this._inputPtr >= this._inputEnd) && (!loadMore()); c1 = c2) {
        do
        {
          return c1;
          c2 = this._inputBuffer[this._inputPtr];
          if ((c2 < '0') || (c2 > '9')) {
            return '0';
          }
          if (!isEnabled(JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS)) {
            reportInvalidNumber("Leading zeroes not allowed");
          }
          this._inputPtr += 1;
          c1 = c2;
        } while (c2 != '0');
      }
      c2 = this._inputBuffer[this._inputPtr];
      if ((c2 < '0') || (c2 > '9')) {
        return '0';
      }
      this._inputPtr += 1;
      c1 = c2;
    } while (c2 == '0');
    return c2;
  }
  
  private final JsonToken parseNumberText2(boolean paramBoolean)
    throws IOException, JsonParseException
  {
    Object localObject2 = this._textBuffer.emptyAndGetCurrentSegment();
    int k = 0;
    if (paramBoolean)
    {
      localObject2[0] = 45;
      k = 0 + 1;
    }
    int n = 0;
    Object localObject1;
    int m;
    int i;
    int j;
    int i1;
    label85:
    int i4;
    if (this._inputPtr < this._inputEnd)
    {
      localObject1 = this._inputBuffer;
      m = this._inputPtr;
      this._inputPtr = (m + 1);
      i = localObject1[m];
      j = i;
      if (i == 48) {
        j = _verifyNoLeadingZeroes();
      }
      i1 = 0;
      i = j;
      if ((i < 48) || (i > 57)) {
        break label910;
      }
      n += 1;
      localObject1 = localObject2;
      m = k;
      if (k >= localObject2.length)
      {
        localObject1 = this._textBuffer.finishCurrentSegment();
        m = 0;
      }
      k = m + 1;
      localObject1[m] = i;
      if ((this._inputPtr < this._inputEnd) || (loadMore())) {
        break label682;
      }
      i = 0;
      m = 1;
      i4 = n;
    }
    for (;;)
    {
      if (i4 == 0) {
        reportInvalidNumber("Missing integer part (next char " + _getCharDesc(i) + ")");
      }
      int i5 = 0;
      i1 = 0;
      label234:
      int i2;
      if (i == 46)
      {
        n = k + 1;
        localObject1[k] = i;
        k = n;
        if ((this._inputPtr >= this._inputEnd) && (!loadMore()))
        {
          i2 = 1;
          label255:
          j = i;
          m = i2;
          i5 = i1;
          localObject2 = localObject1;
          n = k;
          if (i1 == 0)
          {
            reportUnexpectedNumberChar(i, "Decimal point not followed by a digit");
            n = k;
            localObject2 = localObject1;
            i5 = i1;
            m = i2;
            j = i;
          }
        }
      }
      for (;;)
      {
        int i3 = 0;
        i1 = 0;
        int i6;
        if (j != 101)
        {
          k = m;
          i6 = n;
          if (j != 69) {}
        }
        else
        {
          localObject1 = localObject2;
          k = n;
          if (n >= localObject2.length)
          {
            localObject1 = this._textBuffer.finishCurrentSegment();
            k = 0;
          }
          n = k + 1;
          localObject1[k] = j;
          if (this._inputPtr >= this._inputEnd) {
            break label820;
          }
          localObject2 = this._inputBuffer;
          k = this._inputPtr;
          this._inputPtr = (k + 1);
          i = localObject2[k];
          label406:
          if ((i != 45) && (i != 43)) {
            break label886;
          }
          if (n < localObject1.length) {
            break label879;
          }
          localObject1 = this._textBuffer.finishCurrentSegment();
          k = 0;
          label438:
          localObject1[k] = i;
          if (this._inputPtr >= this._inputEnd) {
            break label831;
          }
          localObject2 = this._inputBuffer;
          n = this._inputPtr;
          this._inputPtr = (n + 1);
          i = localObject2[n];
          label481:
          k += 1;
          i3 = i1;
        }
        for (;;)
        {
          i2 = m;
          i1 = i3;
          n = k;
          if (i <= 57)
          {
            i2 = m;
            i1 = i3;
            n = k;
            if (i >= 48)
            {
              i1 = i3 + 1;
              localObject2 = localObject1;
              n = k;
              if (k >= localObject1.length)
              {
                localObject2 = this._textBuffer.finishCurrentSegment();
                n = 0;
              }
              k = n + 1;
              localObject2[n] = i;
              if ((this._inputPtr < this._inputEnd) || (loadMore())) {
                break label842;
              }
              i2 = 1;
              n = k;
            }
          }
          k = i2;
          i3 = i1;
          i6 = n;
          if (i1 == 0)
          {
            reportUnexpectedNumberChar(i, "Exponent indicator not followed by a digit");
            i6 = n;
            i3 = i1;
            k = i2;
          }
          if (k == 0) {
            this._inputPtr -= 1;
          }
          this._textBuffer.setCurrentLength(i6);
          return reset(paramBoolean, i4, i5, i3);
          i = getNextChar("No digit following minus sign");
          break;
          label682:
          localObject2 = this._inputBuffer;
          m = this._inputPtr;
          this._inputPtr = (m + 1);
          i = localObject2[m];
          localObject2 = localObject1;
          break label85;
          localObject2 = this._inputBuffer;
          n = this._inputPtr;
          this._inputPtr = (n + 1);
          j = localObject2[n];
          i = j;
          i2 = m;
          if (j < 48) {
            break label255;
          }
          i = j;
          i2 = m;
          if (j > 57) {
            break label255;
          }
          i1 += 1;
          localObject2 = localObject1;
          n = k;
          if (k >= localObject1.length)
          {
            localObject2 = this._textBuffer.finishCurrentSegment();
            n = 0;
          }
          localObject2[n] = j;
          k = n + 1;
          i = j;
          localObject1 = localObject2;
          break label234;
          label820:
          i = getNextChar("expected a digit for number exponent");
          break label406;
          label831:
          i = getNextChar("expected a digit for number exponent");
          break label481;
          label842:
          localObject1 = this._inputBuffer;
          n = this._inputPtr;
          this._inputPtr = (n + 1);
          i = localObject1[n];
          i3 = i1;
          localObject1 = localObject2;
          continue;
          label879:
          k = n;
          break label438;
          label886:
          k = n;
          i3 = i1;
        }
        j = i;
        localObject2 = localObject1;
        n = k;
      }
      label910:
      m = i1;
      i4 = n;
      localObject1 = localObject2;
    }
  }
  
  protected void _closeInput()
    throws IOException
  {
    if (this._reader != null)
    {
      if ((this._ioContext.isResourceManaged()) || (isEnabled(JsonParser.Feature.AUTO_CLOSE_SOURCE))) {
        this._reader.close();
      }
      this._reader = null;
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
      char[] arrayOfChar = this._inputBuffer;
      int i = this._inputPtr;
      this._inputPtr = (i + 1);
      char c = arrayOfChar[i];
      if (c > ' ')
      {
        int j = paramBase64Variant.decodeBase64Char(c);
        i = j;
        if (j < 0)
        {
          if (c == '"') {
            return localByteArrayBuilder.toByteArray();
          }
          i = _decodeBase64Escape(paramBase64Variant, c, 0);
          if (i < 0) {}
        }
        else
        {
          if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
          }
          arrayOfChar = this._inputBuffer;
          j = this._inputPtr;
          this._inputPtr = (j + 1);
          c = arrayOfChar[j];
          int k = paramBase64Variant.decodeBase64Char(c);
          j = k;
          if (k < 0) {
            j = _decodeBase64Escape(paramBase64Variant, c, 1);
          }
          int m = i << 6 | j;
          if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
          }
          arrayOfChar = this._inputBuffer;
          i = this._inputPtr;
          this._inputPtr = (i + 1);
          c = arrayOfChar[i];
          j = paramBase64Variant.decodeBase64Char(c);
          k = j;
          if (j < 0)
          {
            i = j;
            if (j != -2)
            {
              if ((c == '"') && (!paramBase64Variant.usesPadding()))
              {
                localByteArrayBuilder.append(m >> 4);
                return localByteArrayBuilder.toByteArray();
              }
              i = _decodeBase64Escape(paramBase64Variant, c, 2);
            }
            k = i;
            if (i == -2)
            {
              if (this._inputPtr >= this._inputEnd) {
                loadMoreGuaranteed();
              }
              arrayOfChar = this._inputBuffer;
              i = this._inputPtr;
              this._inputPtr = (i + 1);
              c = arrayOfChar[i];
              if (!paramBase64Variant.usesPaddingChar(c)) {
                throw reportInvalidBase64Char(paramBase64Variant, c, 3, "expected padding character '" + paramBase64Variant.getPaddingChar() + "'");
              }
              localByteArrayBuilder.append(m >> 4);
              continue;
            }
          }
          m = m << 6 | k;
          if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
          }
          arrayOfChar = this._inputBuffer;
          i = this._inputPtr;
          this._inputPtr = (i + 1);
          c = arrayOfChar[i];
          j = paramBase64Variant.decodeBase64Char(c);
          k = j;
          if (j < 0)
          {
            i = j;
            if (j != -2)
            {
              if ((c == '"') && (!paramBase64Variant.usesPadding()))
              {
                localByteArrayBuilder.appendTwoBytes(m >> 2);
                return localByteArrayBuilder.toByteArray();
              }
              i = _decodeBase64Escape(paramBase64Variant, c, 3);
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
  
  protected final char _decodeEscaped()
    throws IOException, JsonParseException
  {
    if ((this._inputPtr >= this._inputEnd) && (!loadMore())) {
      _reportInvalidEOF(" in character escape sequence");
    }
    char[] arrayOfChar = this._inputBuffer;
    int i = this._inputPtr;
    this._inputPtr = (i + 1);
    char c2 = arrayOfChar[i];
    char c1 = c2;
    switch (c2)
    {
    default: 
      c1 = _handleUnrecognizedCharacterEscape(c2);
    case '"': 
    case '/': 
    case '\\': 
      return c1;
    case 'b': 
      return '\b';
    case 't': 
      return '\t';
    case 'n': 
      return '\n';
    case 'f': 
      return '\f';
    case 'r': 
      return '\r';
    }
    int j = 0;
    i = 0;
    while (i < 4)
    {
      if ((this._inputPtr >= this._inputEnd) && (!loadMore())) {
        _reportInvalidEOF(" in character escape sequence");
      }
      arrayOfChar = this._inputBuffer;
      int k = this._inputPtr;
      this._inputPtr = (k + 1);
      k = arrayOfChar[k];
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
    int i = this._inputPtr;
    int k = this._inputEnd;
    int j = i;
    if (i < k)
    {
      int[] arrayOfInt = CharTypes.getInputCodeLatin1();
      int m = arrayOfInt.length;
      do
      {
        int n = this._inputBuffer[i];
        if ((n < m) && (arrayOfInt[n] != 0))
        {
          j = i;
          if (n != 34) {
            break;
          }
          this._textBuffer.resetWithShared(this._inputBuffer, this._inputPtr, i - this._inputPtr);
          this._inputPtr = (i + 1);
          return;
        }
        j = i + 1;
        i = j;
      } while (j < k);
    }
    this._textBuffer.resetWithCopy(this._inputBuffer, this._inputPtr, j - this._inputPtr);
    this._inputPtr = j;
    _finishString2();
  }
  
  protected void _finishString2()
    throws IOException, JsonParseException
  {
    Object localObject1 = this._textBuffer.getCurrentSegment();
    int k = this._textBuffer.getCurrentSegmentSize();
    if ((this._inputPtr >= this._inputEnd) && (!loadMore())) {
      _reportInvalidEOF(": was expecting closing quote for a string value");
    }
    Object localObject2 = this._inputBuffer;
    int m = this._inputPtr;
    this._inputPtr = (m + 1);
    int j = localObject2[m];
    int i = j;
    if (j <= 92)
    {
      if (j != 92) {
        break label131;
      }
      i = _decodeEscaped();
    }
    for (;;)
    {
      localObject2 = localObject1;
      m = k;
      if (k >= localObject1.length)
      {
        localObject2 = this._textBuffer.finishCurrentSegment();
        m = 0;
      }
      localObject2[m] = i;
      k = m + 1;
      localObject1 = localObject2;
      break;
      label131:
      i = j;
      if (j <= 34)
      {
        if (j == 34)
        {
          this._textBuffer.setCurrentLength(k);
          return;
        }
        i = j;
        if (j < 32)
        {
          _throwUnquotedSpace(j, "string value");
          i = j;
        }
      }
    }
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
  
  protected final JsonToken _handleApostropheValue()
    throws IOException, JsonParseException
  {
    Object localObject1 = this._textBuffer.emptyAndGetCurrentSegment();
    int k = this._textBuffer.getCurrentSegmentSize();
    if ((this._inputPtr >= this._inputEnd) && (!loadMore())) {
      _reportInvalidEOF(": was expecting closing quote for a string value");
    }
    Object localObject2 = this._inputBuffer;
    int m = this._inputPtr;
    this._inputPtr = (m + 1);
    int j = localObject2[m];
    int i = j;
    if (j <= 92)
    {
      if (j != 92) {
        break label131;
      }
      i = _decodeEscaped();
    }
    for (;;)
    {
      localObject2 = localObject1;
      m = k;
      if (k >= localObject1.length)
      {
        localObject2 = this._textBuffer.finishCurrentSegment();
        m = 0;
      }
      localObject2[m] = i;
      k = m + 1;
      localObject1 = localObject2;
      break;
      label131:
      i = j;
      if (j <= 39)
      {
        if (j == 39)
        {
          this._textBuffer.setCurrentLength(k);
          return JsonToken.VALUE_STRING;
        }
        i = j;
        if (j < 32)
        {
          _throwUnquotedSpace(j, "string value");
          i = j;
        }
      }
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
  
  protected final JsonToken _handleUnexpectedValue(int paramInt)
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
    char[] arrayOfChar = this._inputBuffer;
    paramInt = this._inputPtr;
    this._inputPtr = (paramInt + 1);
    return _handleInvalidNumberStart(arrayOfChar[paramInt], false);
  }
  
  protected final String _handleUnusualFieldName(int paramInt)
    throws IOException, JsonParseException
  {
    if ((paramInt == 39) && (isEnabled(JsonParser.Feature.ALLOW_SINGLE_QUOTES))) {
      return _parseApostropheFieldName();
    }
    if (!isEnabled(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES)) {
      _reportUnexpectedChar(paramInt, "was expecting double-quote to start field name");
    }
    int[] arrayOfInt = CharTypes.getInputCodeLatin1JsNames();
    int m = arrayOfInt.length;
    boolean bool;
    int j;
    int k;
    int n;
    if (paramInt < m) {
      if ((arrayOfInt[paramInt] == 0) && ((paramInt < 48) || (paramInt > 57)))
      {
        bool = true;
        if (!bool) {
          _reportUnexpectedChar(paramInt, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
        }
        i = this._inputPtr;
        j = 0;
        k = 0;
        n = this._inputEnd;
        paramInt = i;
        if (i >= n) {
          break label248;
        }
        paramInt = i;
        i = k;
      }
    }
    label221:
    do
    {
      j = this._inputBuffer[paramInt];
      if (j < m)
      {
        if (arrayOfInt[j] == 0) {
          break label221;
        }
        j = this._inputPtr - 1;
        this._inputPtr = paramInt;
        return this._symbols.findSymbol(this._inputBuffer, j, paramInt - j, i);
        bool = false;
        break;
        bool = Character.isJavaIdentifierPart((char)paramInt);
        break;
      }
      if (!Character.isJavaIdentifierPart((char)j))
      {
        j = this._inputPtr - 1;
        this._inputPtr = paramInt;
        return this._symbols.findSymbol(this._inputBuffer, j, paramInt - j, i);
      }
      j = i * 31 + j;
      k = paramInt + 1;
      i = j;
      paramInt = k;
    } while (k < n);
    paramInt = k;
    label248:
    int i = this._inputPtr;
    this._inputPtr = paramInt;
    return _parseUnusualFieldName2(i - 1, j, arrayOfInt);
  }
  
  protected final void _matchToken(String paramString, int paramInt)
    throws IOException, JsonParseException
  {
    int j = paramString.length();
    int i;
    do
    {
      if ((this._inputPtr >= this._inputEnd) && (!loadMore())) {
        _reportInvalidEOFInValue();
      }
      if (this._inputBuffer[this._inputPtr] != paramString.charAt(paramInt)) {
        _reportInvalidToken(paramString.substring(0, paramInt), "'null', 'true', 'false' or NaN");
      }
      this._inputPtr += 1;
      i = paramInt + 1;
      paramInt = i;
    } while (i < j);
    if ((this._inputPtr >= this._inputEnd) && (!loadMore())) {}
    char c;
    do
    {
      return;
      c = this._inputBuffer[this._inputPtr];
    } while ((c < '0') || (c == ']') || (c == '}') || (!Character.isJavaIdentifierPart(c)));
    this._inputPtr += 1;
    _reportInvalidToken(paramString.substring(0, i), "'null', 'true', 'false' or NaN");
  }
  
  protected final String _parseApostropheFieldName()
    throws IOException, JsonParseException
  {
    int k = this._inputPtr;
    int i = 0;
    int m = 0;
    int n = this._inputEnd;
    int j = k;
    if (k < n)
    {
      int[] arrayOfInt = CharTypes.getInputCodeLatin1();
      int i1 = arrayOfInt.length;
      j = k;
      i = m;
      k = this._inputBuffer[j];
      if (k == 39)
      {
        k = this._inputPtr;
        this._inputPtr = (j + 1);
        return this._symbols.findSymbol(this._inputBuffer, k, j - k, i);
      }
      if ((k >= i1) || (arrayOfInt[k] == 0)) {
        break label113;
      }
    }
    for (;;)
    {
      k = this._inputPtr;
      this._inputPtr = j;
      return _parseFieldName2(k, i, 39);
      label113:
      m = i * 31 + k;
      k = j + 1;
      i = m;
      j = k;
      if (k < n) {
        break;
      }
      i = m;
      j = k;
    }
  }
  
  protected final String _parseFieldName(int paramInt)
    throws IOException, JsonParseException
  {
    if (paramInt != 34) {
      return _handleUnusualFieldName(paramInt);
    }
    paramInt = this._inputPtr;
    int k = 0;
    int i = 0;
    int m = this._inputEnd;
    int j = paramInt;
    if (paramInt < m)
    {
      int[] arrayOfInt = CharTypes.getInputCodeLatin1();
      int n = arrayOfInt.length;
      do
      {
        int i1 = this._inputBuffer[paramInt];
        if ((i1 < n) && (arrayOfInt[i1] != 0))
        {
          k = i;
          j = paramInt;
          if (i1 != 34) {
            break;
          }
          j = this._inputPtr;
          this._inputPtr = (paramInt + 1);
          return this._symbols.findSymbol(this._inputBuffer, j, paramInt - j, i);
        }
        k = i * 31 + i1;
        j = paramInt + 1;
        i = k;
        paramInt = j;
      } while (j < m);
    }
    paramInt = this._inputPtr;
    this._inputPtr = j;
    return _parseFieldName2(paramInt, k, 34);
  }
  
  protected void _releaseBuffers()
    throws IOException
  {
    super._releaseBuffers();
    char[] arrayOfChar = this._inputBuffer;
    if (arrayOfChar != null)
    {
      this._inputBuffer = null;
      this._ioContext.releaseTokenBuffer(arrayOfChar);
    }
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
        _reportError("Unrecognized token '" + paramString1.toString() + "': was expecting ");
        return;
        c = this._inputBuffer[this._inputPtr];
      } while (!Character.isJavaIdentifierPart(c));
      this._inputPtr += 1;
      paramString1.append(c);
    }
  }
  
  protected final void _skipCR()
    throws IOException
  {
    if (((this._inputPtr < this._inputEnd) || (loadMore())) && (this._inputBuffer[this._inputPtr] == '\n')) {
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
    int i = this._inputPtr;
    int j = this._inputEnd;
    char[] arrayOfChar = this._inputBuffer;
    for (;;)
    {
      int k = j;
      int m = i;
      if (i >= j)
      {
        this._inputPtr = i;
        if (!loadMore()) {
          _reportInvalidEOF(": was expecting closing quote for a string value");
        }
        m = this._inputPtr;
        k = this._inputEnd;
      }
      i = m + 1;
      j = arrayOfChar[m];
      if (j <= 92)
      {
        if (j == 92)
        {
          this._inputPtr = i;
          _decodeEscaped();
          i = this._inputPtr;
          j = this._inputEnd;
          continue;
        }
        if (j <= 34)
        {
          if (j == 34)
          {
            this._inputPtr = i;
            return;
          }
          if (j < 32)
          {
            this._inputPtr = i;
            _throwUnquotedSpace(j, "string value");
          }
        }
      }
      j = k;
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
    return this._reader;
  }
  
  protected char getNextChar(String paramString)
    throws IOException, JsonParseException
  {
    if ((this._inputPtr >= this._inputEnd) && (!loadMore())) {
      _reportInvalidEOF(paramString);
    }
    paramString = this._inputBuffer;
    int i = this._inputPtr;
    this._inputPtr = (i + 1);
    return paramString[i];
  }
  
  public final String getText()
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
    if (this._reader != null)
    {
      i = this._reader.read(this._inputBuffer, 0, this._inputBuffer.length);
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
    throw new IOException("Reader returned 0 characters when trying to read " + this._inputEnd);
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
    Object localObject;
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
    boolean bool = this._parsingContext.inObject();
    j = i;
    if (bool)
    {
      localObject = _parseFieldName(i);
      this._parsingContext.setCurrentName((String)localObject);
      this._currToken = JsonToken.FIELD_NAME;
      i = _skipWS();
      if (i != 58) {
        _reportUnexpectedChar(i, "was expecting a colon to separate field name and value");
      }
      j = _skipWS();
    }
    switch (j)
    {
    default: 
      localObject = _handleUnexpectedValue(j);
    }
    while (bool)
    {
      this._nextToken = ((JsonToken)localObject);
      return this._currToken;
      this._tokenIncomplete = true;
      localObject = JsonToken.VALUE_STRING;
      continue;
      if (!bool) {
        this._parsingContext = this._parsingContext.createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
      }
      localObject = JsonToken.START_ARRAY;
      continue;
      if (!bool) {
        this._parsingContext = this._parsingContext.createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
      }
      localObject = JsonToken.START_OBJECT;
      continue;
      _reportUnexpectedChar(j, "expected a value");
      _matchToken("true", 1);
      localObject = JsonToken.VALUE_TRUE;
      continue;
      _matchToken("false", 1);
      localObject = JsonToken.VALUE_FALSE;
      continue;
      _matchToken("null", 1);
      localObject = JsonToken.VALUE_NULL;
      continue;
      localObject = parseNumberText(j);
    }
    this._currToken = ((JsonToken)localObject);
    return (JsonToken)localObject;
  }
  
  protected final JsonToken parseNumberText(int paramInt)
    throws IOException, JsonParseException
  {
    boolean bool;
    int i2;
    int i3;
    int i;
    if (paramInt == 45)
    {
      bool = true;
      j = this._inputPtr;
      i2 = j - 1;
      i3 = this._inputEnd;
      i = j;
      if (!bool) {
        break label110;
      }
      if (j < this._inputEnd) {
        break label71;
      }
    }
    label71:
    label110:
    int k;
    label121:
    int i1;
    int m;
    int n;
    label243:
    label281:
    do
    {
      do
      {
        paramInt = i2;
        if (bool) {
          paramInt = i2 + 1;
        }
        this._inputPtr = paramInt;
        return parseNumberText2(bool);
        bool = false;
        break;
        arrayOfChar = this._inputBuffer;
        i = j + 1;
        paramInt = arrayOfChar[j];
        if ((paramInt > 57) || (paramInt < 48))
        {
          this._inputPtr = i;
          return _handleInvalidNumberStart(paramInt, true);
        }
      } while (paramInt == 48);
      k = 1;
      paramInt = i;
      if (paramInt < this._inputEnd)
      {
        arrayOfChar = this._inputBuffer;
        i = paramInt + 1;
        i1 = arrayOfChar[paramInt];
        if ((i1 < 48) || (i1 > 57))
        {
          m = 0;
          n = 0;
          paramInt = i;
          j = i1;
          if (i1 != 46) {
            break label243;
          }
          j = i;
          i = n;
        }
      }
      for (;;)
      {
        if (j >= i3)
        {
          break;
          k += 1;
          paramInt = i;
          break label121;
          break;
        }
        arrayOfChar = this._inputBuffer;
        paramInt = j + 1;
        j = arrayOfChar[j];
        if ((j < 48) || (j > 57))
        {
          if (i == 0) {
            reportUnexpectedNumberChar(j, "Decimal point not followed by a digit");
          }
          m = i;
          n = 0;
          i = 0;
          if (j != 101)
          {
            i1 = paramInt;
            if (j != 69) {
              break label396;
            }
          }
          if (paramInt < i3) {
            break label281;
          }
          break;
        }
        i += 1;
        j = paramInt;
      }
      arrayOfChar = this._inputBuffer;
      n = paramInt + 1;
      j = arrayOfChar[paramInt];
      if ((j != 45) && (j != 43)) {
        break label436;
      }
    } while (n >= i3);
    char[] arrayOfChar = this._inputBuffer;
    paramInt = n + 1;
    int j = arrayOfChar[n];
    for (;;)
    {
      if ((j <= 57) && (j >= 48))
      {
        i += 1;
        if (paramInt >= i3) {
          break;
        }
        j = this._inputBuffer[paramInt];
        paramInt += 1;
        continue;
      }
      n = i;
      i1 = paramInt;
      if (i == 0)
      {
        reportUnexpectedNumberChar(j, "Exponent indicator not followed by a digit");
        i1 = paramInt;
        n = i;
      }
      label396:
      paramInt = i1 - 1;
      this._inputPtr = paramInt;
      this._textBuffer.resetWithShared(this._inputBuffer, i2, paramInt - i2);
      return reset(bool, k, m, n);
      label436:
      paramInt = n;
    }
  }
  
  public int releaseBuffered(Writer paramWriter)
    throws IOException
  {
    int i = this._inputEnd - this._inputPtr;
    if (i < 1) {
      return 0;
    }
    int j = this._inputPtr;
    paramWriter.write(this._inputBuffer, j, i);
    return i;
  }
  
  public void setCodec(ObjectCodec paramObjectCodec)
  {
    this._objectCodec = paramObjectCodec;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/impl/ReaderBasedParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */