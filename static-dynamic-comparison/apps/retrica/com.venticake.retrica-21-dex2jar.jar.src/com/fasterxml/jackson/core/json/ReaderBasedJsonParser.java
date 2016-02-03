package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.base.ParserBase;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.TextBuffer;
import java.io.IOException;
import java.io.Reader;

public final class ReaderBasedJsonParser
  extends ParserBase
{
  protected final int _hashSeed;
  protected char[] _inputBuffer;
  protected ObjectCodec _objectCodec;
  protected Reader _reader;
  protected final CharsToNameCanonicalizer _symbols;
  protected boolean _tokenIncomplete = false;
  
  public ReaderBasedJsonParser(IOContext paramIOContext, int paramInt, Reader paramReader, ObjectCodec paramObjectCodec, CharsToNameCanonicalizer paramCharsToNameCanonicalizer)
  {
    super(paramIOContext, paramInt);
    this._reader = paramReader;
    this._inputBuffer = paramIOContext.allocTokenBuffer();
    this._objectCodec = paramObjectCodec;
    this._symbols = paramCharsToNameCanonicalizer;
    this._hashSeed = paramCharsToNameCanonicalizer.hashSeed();
  }
  
  private JsonToken _nextAfterName()
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
      if (j <= 92) {
        if (j != 92) {}
      }
      for (int i = _decodeEscaped();; i = j)
      {
        paramInt2 = paramInt2 * 33 + j;
        k = paramInt1 + 1;
        localObject[paramInt1] = i;
        if (k < localObject.length) {
          break label250;
        }
        localObject = this._textBuffer.finishCurrentSegment();
        paramInt1 = 0;
        break;
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
          if (j < 32) {
            _throwUnquotedSpace(j, "name");
          }
        }
      }
      label250:
      paramInt1 = k;
    }
  }
  
  private String _parseUnusualFieldName2(int paramInt1, int paramInt2, int[] paramArrayOfInt)
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
            paramInt2 = paramInt2 * 33 + i;
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
  
  private void _skipCComment()
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
  
  private void _skipComment()
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
  
  private void _skipCppComment()
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
  
  private int _skipWS()
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
  
  private int _skipWSOrEnd()
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
  
  private char _verifyNoLeadingZeroes()
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
  
  private JsonToken parseNumberText2(boolean paramBoolean)
  {
    int i5 = 0;
    Object localObject2 = this._textBuffer.emptyAndGetCurrentSegment();
    if (paramBoolean) {
      localObject2[0] = 45;
    }
    for (int k = 1;; k = 0)
    {
      Object localObject1;
      int m;
      int i;
      label80:
      int n;
      int i1;
      if (this._inputPtr < this._inputEnd)
      {
        localObject1 = this._inputBuffer;
        m = this._inputPtr;
        this._inputPtr = (m + 1);
        i = localObject1[m];
        int j = i;
        if (i == 48) {
          j = _verifyNoLeadingZeroes();
        }
        m = 0;
        i = j;
        if ((i < 48) || (i > 57)) {
          break label865;
        }
        m += 1;
        n = k;
        localObject1 = localObject2;
        if (k >= localObject2.length)
        {
          localObject1 = this._textBuffer.finishCurrentSegment();
          n = 0;
        }
        k = n + 1;
        localObject1[n] = i;
        if ((this._inputPtr < this._inputEnd) || (loadMore())) {
          break label628;
        }
        n = 1;
        i = 0;
        i1 = m;
        m = k;
      }
      for (k = n;; k = n)
      {
        if (i1 == 0) {
          reportInvalidNumber("Missing integer part (next char " + _getCharDesc(i) + ")");
        }
        label251:
        int i2;
        if (i == 46)
        {
          localObject1[m] = i;
          m += 1;
          n = 0;
          if ((this._inputPtr >= this._inputEnd) && (!loadMore()))
          {
            k = 1;
            if (n == 0) {
              reportUnexpectedNumberChar(i, "Decimal point not followed by a digit");
            }
            i2 = n;
            n = m;
            m = k;
            localObject2 = localObject1;
            k = n;
          }
        }
        for (;;)
        {
          label373:
          label405:
          label448:
          label457:
          int i3;
          label544:
          int i4;
          if ((i == 101) || (i == 69))
          {
            n = k;
            localObject1 = localObject2;
            if (k >= localObject2.length)
            {
              localObject1 = this._textBuffer.finishCurrentSegment();
              n = 0;
            }
            k = n + 1;
            localObject1[n] = i;
            if (this._inputPtr < this._inputEnd)
            {
              localObject2 = this._inputBuffer;
              n = this._inputPtr;
              this._inputPtr = (n + 1);
              i = localObject2[n];
              if ((i != 45) && (i != 43)) {
                break label820;
              }
              if (k < localObject1.length) {
                break label817;
              }
              localObject1 = this._textBuffer.finishCurrentSegment();
              k = 0;
              localObject1[k] = i;
              if (this._inputPtr >= this._inputEnd) {
                break label758;
              }
              localObject2 = this._inputBuffer;
              n = this._inputPtr;
              this._inputPtr = (n + 1);
              i = localObject2[n];
              k += 1;
              n = 0;
              if ((i > 57) || (i < 48)) {
                break label802;
              }
              n += 1;
              i3 = k;
              localObject2 = localObject1;
              if (k >= localObject1.length)
              {
                localObject2 = this._textBuffer.finishCurrentSegment();
                i3 = 0;
              }
              k = i3 + 1;
              localObject2[i3] = i;
              if ((this._inputPtr < this._inputEnd) || (loadMore())) {
                break label769;
              }
              i3 = 1;
              m = k;
              k = i3;
              i3 = k;
              i4 = m;
              i5 = n;
              if (n == 0)
              {
                reportUnexpectedNumberChar(i, "Exponent indicator not followed by a digit");
                i5 = n;
                i4 = m;
                i3 = k;
              }
              label581:
              if (i3 == 0) {
                this._inputPtr -= 1;
              }
              this._textBuffer.setCurrentLength(i4);
              return reset(paramBoolean, i1, i2, i5);
              i = getNextChar("No digit following minus sign");
              break;
              label628:
              localObject2 = this._inputBuffer;
              n = this._inputPtr;
              this._inputPtr = (n + 1);
              i = localObject2[n];
              localObject2 = localObject1;
              break label80;
              localObject2 = this._inputBuffer;
              i2 = this._inputPtr;
              this._inputPtr = (i2 + 1);
              i = localObject2[i2];
              if (i < 48) {
                break label840;
              }
              if (i > 57) {
                break label251;
              }
              n += 1;
              if (m < localObject1.length) {
                break label837;
              }
              localObject1 = this._textBuffer.finishCurrentSegment();
              m = 0;
            }
          }
          label758:
          label769:
          label802:
          label817:
          label820:
          label837:
          for (;;)
          {
            i2 = m + 1;
            localObject1[m] = i;
            m = i2;
            break;
            i = getNextChar("expected a digit for number exponent");
            break label373;
            i = getNextChar("expected a digit for number exponent");
            break label448;
            localObject1 = this._inputBuffer;
            i3 = this._inputPtr;
            this._inputPtr = (i3 + 1);
            i = localObject1[i3];
            localObject1 = localObject2;
            break label457;
            i3 = k;
            k = m;
            m = i3;
            break label544;
            break label405;
            n = 0;
            break label457;
            i3 = m;
            i4 = k;
            break label581;
          }
          label840:
          break label251;
          i2 = 0;
          n = k;
          k = m;
          localObject2 = localObject1;
          m = n;
        }
        label865:
        n = 0;
        i1 = m;
        localObject1 = localObject2;
        m = k;
      }
    }
  }
  
  protected void _closeInput()
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
          int m = j | i << 6;
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
          localByteArrayBuilder.appendThreeBytes(k | m << 6);
        }
      }
    }
  }
  
  protected char _decodeEscaped()
  {
    int j = 0;
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
  {
    char[] arrayOfChar1 = this._textBuffer.getCurrentSegment();
    int k = this._textBuffer.getCurrentSegmentSize();
    if ((this._inputPtr >= this._inputEnd) && (!loadMore())) {
      _reportInvalidEOF(": was expecting closing quote for a string value");
    }
    char[] arrayOfChar2 = this._inputBuffer;
    int m = this._inputPtr;
    this._inputPtr = (m + 1);
    int j = arrayOfChar2[m];
    int i = j;
    if (j <= 92)
    {
      if (j == 92) {
        i = _decodeEscaped();
      }
    }
    else
    {
      label87:
      if (k < arrayOfChar1.length) {
        break label165;
      }
      arrayOfChar1 = this._textBuffer.finishCurrentSegment();
      k = 0;
    }
    label165:
    for (;;)
    {
      m = k + 1;
      arrayOfChar1[k] = i;
      k = m;
      break;
      i = j;
      if (j > 34) {
        break label87;
      }
      if (j == 34)
      {
        this._textBuffer.setCurrentLength(k);
        return;
      }
      i = j;
      if (j >= 32) {
        break label87;
      }
      _throwUnquotedSpace(j, "string value");
      i = j;
      break label87;
    }
  }
  
  protected String _getText2(JsonToken paramJsonToken)
  {
    if (paramJsonToken == null) {
      return null;
    }
    switch (1.$SwitchMap$com$fasterxml$jackson$core$JsonToken[paramJsonToken.ordinal()])
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
    char[] arrayOfChar1 = this._textBuffer.emptyAndGetCurrentSegment();
    int k = this._textBuffer.getCurrentSegmentSize();
    if ((this._inputPtr >= this._inputEnd) && (!loadMore())) {
      _reportInvalidEOF(": was expecting closing quote for a string value");
    }
    char[] arrayOfChar2 = this._inputBuffer;
    int m = this._inputPtr;
    this._inputPtr = (m + 1);
    int j = arrayOfChar2[m];
    int i = j;
    if (j <= 92)
    {
      if (j == 92) {
        i = _decodeEscaped();
      }
    }
    else
    {
      label87:
      if (k < arrayOfChar1.length) {
        break label168;
      }
      arrayOfChar1 = this._textBuffer.finishCurrentSegment();
      k = 0;
    }
    label168:
    for (;;)
    {
      m = k + 1;
      arrayOfChar1[k] = i;
      k = m;
      break;
      i = j;
      if (j > 39) {
        break label87;
      }
      if (j == 39)
      {
        this._textBuffer.setCurrentLength(k);
        return JsonToken.VALUE_STRING;
      }
      i = j;
      if (j >= 32) {
        break label87;
      }
      _throwUnquotedSpace(j, "string value");
      i = j;
      break label87;
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
    char[] arrayOfChar = this._inputBuffer;
    paramInt = this._inputPtr;
    this._inputPtr = (paramInt + 1);
    return _handleInvalidNumberStart(arrayOfChar[paramInt], false);
  }
  
  protected String _handleUnusualFieldName(int paramInt)
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
    int k;
    int n;
    int j;
    if (paramInt < m) {
      if ((arrayOfInt[paramInt] == 0) && ((paramInt < 48) || (paramInt > 57)))
      {
        bool = true;
        if (!bool) {
          _reportUnexpectedChar(paramInt, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
        }
        k = this._inputPtr;
        i = this._hashSeed;
        n = this._inputEnd;
        j = i;
        paramInt = k;
        if (k >= n) {
          break label251;
        }
        paramInt = k;
      }
    }
    label224:
    do
    {
      j = this._inputBuffer[paramInt];
      if (j < m)
      {
        if (arrayOfInt[j] == 0) {
          break label224;
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
      j = i * 33 + j;
      k = paramInt + 1;
      i = j;
      paramInt = k;
    } while (k < n);
    paramInt = k;
    label251:
    int i = this._inputPtr;
    this._inputPtr = paramInt;
    return _parseUnusualFieldName2(i - 1, j, arrayOfInt);
  }
  
  protected void _matchToken(String paramString, int paramInt)
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
    _reportInvalidToken(paramString.substring(0, i), "'null', 'true', 'false' or NaN");
  }
  
  protected String _parseApostropheFieldName()
  {
    int m = this._inputPtr;
    int k = this._hashSeed;
    int n = this._inputEnd;
    int i = k;
    int j = m;
    if (m < n)
    {
      int[] arrayOfInt = CharTypes.getInputCodeLatin1();
      int i1 = arrayOfInt.length;
      j = m;
      i = k;
      k = this._inputBuffer[j];
      if (k == 39)
      {
        k = this._inputPtr;
        this._inputPtr = (j + 1);
        return this._symbols.findSymbol(this._inputBuffer, k, j - k, i);
      }
      if ((k >= i1) || (arrayOfInt[k] == 0)) {
        break label118;
      }
    }
    for (;;)
    {
      k = this._inputPtr;
      this._inputPtr = j;
      return _parseFieldName2(k, i, 39);
      label118:
      m = i * 33 + k;
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
  
  protected String _parseFieldName(int paramInt)
  {
    if (paramInt != 34) {
      return _handleUnusualFieldName(paramInt);
    }
    paramInt = this._inputPtr;
    int i = this._hashSeed;
    int m = this._inputEnd;
    int k = i;
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
        k = i * 33 + i1;
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
  
  protected void _skipCR()
  {
    if (((this._inputPtr < this._inputEnd) || (loadMore())) && (this._inputBuffer[this._inputPtr] == '\n')) {
      this._inputPtr += 1;
    }
    this._currInputRow += 1;
    this._currInputRowStart = this._inputPtr;
  }
  
  protected void _skipLF()
  {
    this._currInputRow += 1;
    this._currInputRowStart = this._inputPtr;
  }
  
  protected void _skipString()
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
  
  public Object getEmbeddedObject()
  {
    return null;
  }
  
  protected char getNextChar(String paramString)
  {
    if ((this._inputPtr >= this._inputEnd) && (!loadMore())) {
      _reportInvalidEOF(paramString);
    }
    paramString = this._inputBuffer;
    int i = this._inputPtr;
    this._inputPtr = (i + 1);
    return paramString[i];
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
      switch (1.$SwitchMap$com$fasterxml$jackson$core$JsonToken[this._currToken.ordinal()])
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
    switch (1.$SwitchMap$com$fasterxml$jackson$core$JsonToken[this._currToken.ordinal()])
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
    switch (1.$SwitchMap$com$fasterxml$jackson$core$JsonToken[this._currToken.ordinal()])
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
  
  public String getValueAsString()
  {
    if (this._currToken == JsonToken.VALUE_STRING)
    {
      if (this._tokenIncomplete)
      {
        this._tokenIncomplete = false;
        _finishString();
      }
      return this._textBuffer.contentsAsString();
    }
    return super.getValueAsString(null);
  }
  
  public String getValueAsString(String paramString)
  {
    if (this._currToken == JsonToken.VALUE_STRING)
    {
      if (this._tokenIncomplete)
      {
        this._tokenIncomplete = false;
        _finishString();
      }
      return this._textBuffer.contentsAsString();
    }
    return super.getValueAsString(paramString);
  }
  
  protected boolean loadMore()
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
  
  protected JsonToken parseNumberText(int paramInt)
  {
    int k = 1;
    int n = 0;
    int i3 = 0;
    boolean bool;
    int i;
    int i2;
    int i4;
    if (paramInt == 45)
    {
      bool = true;
      i = this._inputPtr;
      i2 = i - 1;
      i4 = this._inputEnd;
      if (!bool) {
        break label123;
      }
      if (i < this._inputEnd) {
        break label75;
      }
    }
    label57:
    label75:
    char[] arrayOfChar;
    int j;
    int m;
    for (;;)
    {
      if (bool)
      {
        paramInt = i2 + 1;
        this._inputPtr = paramInt;
        return parseNumberText2(bool);
        bool = false;
        break;
        arrayOfChar = this._inputBuffer;
        j = i + 1;
        m = arrayOfChar[i];
        if (m <= 57)
        {
          paramInt = j;
          i = m;
          if (m >= 48) {}
        }
        else
        {
          this._inputPtr = j;
          return _handleInvalidNumberStart(m, true);
          label123:
          j = i;
          i = paramInt;
          paramInt = j;
        }
        if (i != 48)
        {
          i = paramInt;
          label137:
          if (i < this._inputEnd)
          {
            arrayOfChar = this._inputBuffer;
            paramInt = i + 1;
            j = arrayOfChar[i];
            if ((j < 48) || (j > 57))
            {
              if (j != 46) {
                break label440;
              }
              i = 0;
              j = paramInt;
              paramInt = i;
              label184:
              if (j >= i4) {
                break label360;
              }
              arrayOfChar = this._inputBuffer;
              i = j + 1;
              j = arrayOfChar[j];
              if ((j >= 48) && (j <= 57)) {
                break label353;
              }
              if (paramInt == 0) {
                reportUnexpectedNumberChar(j, "Decimal point not followed by a digit");
              }
              m = paramInt;
              paramInt = i;
            }
          }
        }
      }
    }
    for (;;)
    {
      int i1;
      if (j != 101)
      {
        i1 = paramInt;
        if (j != 69) {}
      }
      else
      {
        if (paramInt >= i4) {
          break;
        }
        arrayOfChar = this._inputBuffer;
        i = paramInt + 1;
        j = arrayOfChar[paramInt];
        if ((j != 45) && (j != 43)) {
          break label432;
        }
        if (i >= i4) {
          break;
        }
        arrayOfChar = this._inputBuffer;
        paramInt = i + 1;
        j = arrayOfChar[i];
        i = i3;
      }
      for (;;)
      {
        if ((j <= 57) && (j >= 48))
        {
          i += 1;
          if (paramInt >= i4) {
            break;
          }
          j = this._inputBuffer[paramInt];
          paramInt += 1;
          continue;
          k += 1;
          i = paramInt;
          break label137;
          break;
          label353:
          paramInt += 1;
          j = i;
          break label184;
          label360:
          break;
        }
        n = i;
        i1 = paramInt;
        if (i == 0)
        {
          reportUnexpectedNumberChar(j, "Exponent indicator not followed by a digit");
          i1 = paramInt;
          n = i;
        }
        paramInt = i1 - 1;
        this._inputPtr = paramInt;
        this._textBuffer.resetWithShared(this._inputBuffer, i2, paramInt - i2);
        return reset(bool, k, m, n);
        paramInt = i2;
        break label57;
        label432:
        paramInt = i;
        i = i3;
      }
      label440:
      m = 0;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/core/json/ReaderBasedJsonParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */