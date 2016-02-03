package org.codehaus.jackson.impl;

import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.codehaus.jackson.Base64Variant;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonGenerator.Feature;
import org.codehaus.jackson.JsonStreamContext;
import org.codehaus.jackson.ObjectCodec;
import org.codehaus.jackson.PrettyPrinter;
import org.codehaus.jackson.SerializableString;
import org.codehaus.jackson.io.CharacterEscapes;
import org.codehaus.jackson.io.IOContext;
import org.codehaus.jackson.io.NumberOutput;
import org.codehaus.jackson.io.SerializedString;
import org.codehaus.jackson.util.CharTypes;

public final class WriterBasedGenerator
  extends JsonGeneratorBase
{
  protected static final char[] HEX_CHARS = ;
  protected static final int SHORT_WRITE = 32;
  protected static final int[] sOutputEscapes = CharTypes.get7BitOutputEscapes();
  protected CharacterEscapes _characterEscapes;
  protected SerializableString _currentEscape;
  protected char[] _entityBuffer;
  protected final IOContext _ioContext;
  protected int _maximumNonEscapedChar;
  protected char[] _outputBuffer;
  protected int _outputEnd;
  protected int[] _outputEscapes = sOutputEscapes;
  protected int _outputHead = 0;
  protected int _outputTail = 0;
  protected final Writer _writer;
  
  public WriterBasedGenerator(IOContext paramIOContext, int paramInt, ObjectCodec paramObjectCodec, Writer paramWriter)
  {
    super(paramInt, paramObjectCodec);
    this._ioContext = paramIOContext;
    this._writer = paramWriter;
    this._outputBuffer = paramIOContext.allocConcatBuffer();
    this._outputEnd = this._outputBuffer.length;
    if (isEnabled(JsonGenerator.Feature.ESCAPE_NON_ASCII)) {
      setHighestNonEscapedChar(127);
    }
  }
  
  private char[] _allocateEntityBuffer()
  {
    char[] arrayOfChar = new char[14];
    arrayOfChar[0] = '\\';
    arrayOfChar[2] = '\\';
    arrayOfChar[3] = 'u';
    arrayOfChar[4] = '0';
    arrayOfChar[5] = '0';
    arrayOfChar[8] = '\\';
    arrayOfChar[9] = 'u';
    this._entityBuffer = arrayOfChar;
    return arrayOfChar;
  }
  
  private final void _appendCharacterEscape(char paramChar, int paramInt)
  {
    Object localObject;
    if (paramInt >= 0)
    {
      if (this._outputTail + 2 > this._outputEnd) {
        _flushBuffer();
      }
      localObject = this._outputBuffer;
      paramChar = this._outputTail;
      this._outputTail = (paramChar + '\001');
      localObject[paramChar] = 92;
      localObject = this._outputBuffer;
      paramChar = this._outputTail;
      this._outputTail = (paramChar + '\001');
      localObject[paramChar] = ((char)paramInt);
      return;
    }
    if (paramInt != -2)
    {
      if (this._outputTail + 2 > this._outputEnd) {
        _flushBuffer();
      }
      paramInt = this._outputTail;
      localObject = this._outputBuffer;
      int i = paramInt + 1;
      localObject[paramInt] = 92;
      paramInt = i + 1;
      localObject[i] = 117;
      if (paramChar > 'ÿ')
      {
        i = paramChar >> '\b' & 0xFF;
        int j = paramInt + 1;
        localObject[paramInt] = HEX_CHARS[(i >> 4)];
        paramInt = j + 1;
        localObject[j] = HEX_CHARS[(i & 0xF)];
        paramChar = (char)(paramChar & 0xFF);
      }
      for (;;)
      {
        i = paramInt + 1;
        localObject[paramInt] = HEX_CHARS[(paramChar >> '\004')];
        localObject[i] = HEX_CHARS[(paramChar & 0xF)];
        this._outputTail = i;
        return;
        i = paramInt + 1;
        localObject[paramInt] = 48;
        paramInt = i + 1;
        localObject[i] = 48;
      }
    }
    if (this._currentEscape == null) {
      localObject = this._characterEscapes.getEscapeSequence(paramChar).getValue();
    }
    for (;;)
    {
      paramChar = ((String)localObject).length();
      if (this._outputTail + paramChar <= this._outputEnd) {
        break;
      }
      _flushBuffer();
      if (paramChar <= this._outputEnd) {
        break;
      }
      this._writer.write((String)localObject);
      return;
      localObject = this._currentEscape.getValue();
      this._currentEscape = null;
    }
    ((String)localObject).getChars(0, paramChar, this._outputBuffer, this._outputTail);
    this._outputTail += paramChar;
  }
  
  private final int _prependOrWriteCharacterEscape(char[] paramArrayOfChar, int paramInt1, int paramInt2, char paramChar, int paramInt3)
  {
    Object localObject;
    if (paramInt3 >= 0)
    {
      if ((paramInt1 > 1) && (paramInt1 < paramInt2))
      {
        paramInt1 -= 2;
        paramArrayOfChar[paramInt1] = '\\';
        paramArrayOfChar[(paramInt1 + 1)] = ((char)paramInt3);
        return paramInt1;
      }
      localObject = this._entityBuffer;
      paramArrayOfChar = (char[])localObject;
      if (localObject == null) {
        paramArrayOfChar = _allocateEntityBuffer();
      }
      paramArrayOfChar[1] = ((char)paramInt3);
      this._writer.write(paramArrayOfChar, 0, 2);
      return paramInt1;
    }
    if (paramInt3 != -2)
    {
      if ((paramInt1 > 5) && (paramInt1 < paramInt2))
      {
        paramInt1 -= 6;
        paramInt2 = paramInt1 + 1;
        paramArrayOfChar[paramInt1] = '\\';
        paramInt1 = paramInt2 + 1;
        paramArrayOfChar[paramInt2] = 'u';
        if (paramChar > 'ÿ')
        {
          paramInt2 = paramChar >> '\b' & 0xFF;
          paramInt3 = paramInt1 + 1;
          paramArrayOfChar[paramInt1] = HEX_CHARS[(paramInt2 >> 4)];
          paramInt1 = paramInt3 + 1;
          paramArrayOfChar[paramInt3] = HEX_CHARS[(paramInt2 & 0xF)];
          paramChar = (char)(paramChar & 0xFF);
        }
        for (;;)
        {
          paramInt2 = paramInt1 + 1;
          paramArrayOfChar[paramInt1] = HEX_CHARS[(paramChar >> '\004')];
          paramArrayOfChar[paramInt2] = HEX_CHARS[(paramChar & 0xF)];
          return paramInt2 - 5;
          paramInt2 = paramInt1 + 1;
          paramArrayOfChar[paramInt1] = '0';
          paramInt1 = paramInt2 + 1;
          paramArrayOfChar[paramInt2] = '0';
        }
      }
      localObject = this._entityBuffer;
      paramArrayOfChar = (char[])localObject;
      if (localObject == null) {
        paramArrayOfChar = _allocateEntityBuffer();
      }
      this._outputHead = this._outputTail;
      if (paramChar > 'ÿ')
      {
        paramInt2 = paramChar >> '\b' & 0xFF;
        paramChar &= 0xFF;
        paramArrayOfChar[10] = HEX_CHARS[(paramInt2 >> 4)];
        paramArrayOfChar[11] = HEX_CHARS[(paramInt2 & 0xF)];
        paramArrayOfChar[12] = HEX_CHARS[(paramChar >> '\004')];
        paramArrayOfChar[13] = HEX_CHARS[(paramChar & 0xF)];
        this._writer.write(paramArrayOfChar, 8, 6);
        return paramInt1;
      }
      paramArrayOfChar[6] = HEX_CHARS[(paramChar >> '\004')];
      paramArrayOfChar[7] = HEX_CHARS[(paramChar & 0xF)];
      this._writer.write(paramArrayOfChar, 2, 6);
      return paramInt1;
    }
    if (this._currentEscape == null) {
      localObject = this._characterEscapes.getEscapeSequence(paramChar).getValue();
    }
    for (;;)
    {
      paramChar = ((String)localObject).length();
      if ((paramInt1 < paramChar) || (paramInt1 >= paramInt2)) {
        break;
      }
      paramInt1 -= paramChar;
      ((String)localObject).getChars(0, paramChar, paramArrayOfChar, paramInt1);
      return paramInt1;
      localObject = this._currentEscape.getValue();
      this._currentEscape = null;
    }
    this._writer.write((String)localObject);
    return paramInt1;
  }
  
  private final void _prependOrWriteCharacterEscape(char paramChar, int paramInt)
  {
    char[] arrayOfChar;
    Object localObject;
    if (paramInt >= 0)
    {
      if (this._outputTail >= 2)
      {
        paramChar = this._outputTail - 2;
        this._outputHead = paramChar;
        this._outputBuffer[paramChar] = '\\';
        this._outputBuffer[(paramChar + '\001')] = ((char)paramInt);
        return;
      }
      arrayOfChar = this._entityBuffer;
      localObject = arrayOfChar;
      if (arrayOfChar == null) {
        localObject = _allocateEntityBuffer();
      }
      this._outputHead = this._outputTail;
      localObject[1] = ((char)paramInt);
      this._writer.write((char[])localObject, 0, 2);
      return;
    }
    if (paramInt != -2)
    {
      if (this._outputTail >= 6)
      {
        localObject = this._outputBuffer;
        paramInt = this._outputTail - 6;
        this._outputHead = paramInt;
        localObject[paramInt] = 92;
        paramInt += 1;
        localObject[paramInt] = 117;
        if (paramChar > 'ÿ')
        {
          int i = paramChar >> '\b' & 0xFF;
          paramInt += 1;
          localObject[paramInt] = HEX_CHARS[(i >> 4)];
          paramInt += 1;
          localObject[paramInt] = HEX_CHARS[(i & 0xF)];
          paramChar = (char)(paramChar & 0xFF);
        }
        for (;;)
        {
          paramInt += 1;
          localObject[paramInt] = HEX_CHARS[(paramChar >> '\004')];
          localObject[(paramInt + 1)] = HEX_CHARS[(paramChar & 0xF)];
          return;
          paramInt += 1;
          localObject[paramInt] = 48;
          paramInt += 1;
          localObject[paramInt] = 48;
        }
      }
      arrayOfChar = this._entityBuffer;
      localObject = arrayOfChar;
      if (arrayOfChar == null) {
        localObject = _allocateEntityBuffer();
      }
      this._outputHead = this._outputTail;
      if (paramChar > 'ÿ')
      {
        paramInt = paramChar >> '\b' & 0xFF;
        paramChar &= 0xFF;
        localObject[10] = HEX_CHARS[(paramInt >> 4)];
        localObject[11] = HEX_CHARS[(paramInt & 0xF)];
        localObject[12] = HEX_CHARS[(paramChar >> '\004')];
        localObject[13] = HEX_CHARS[(paramChar & 0xF)];
        this._writer.write((char[])localObject, 8, 6);
        return;
      }
      localObject[6] = HEX_CHARS[(paramChar >> '\004')];
      localObject[7] = HEX_CHARS[(paramChar & 0xF)];
      this._writer.write((char[])localObject, 2, 6);
      return;
    }
    if (this._currentEscape == null) {
      localObject = this._characterEscapes.getEscapeSequence(paramChar).getValue();
    }
    for (;;)
    {
      paramChar = ((String)localObject).length();
      if (this._outputTail < paramChar) {
        break;
      }
      paramInt = this._outputTail - paramChar;
      this._outputHead = paramInt;
      ((String)localObject).getChars(0, paramChar, this._outputBuffer, paramInt);
      return;
      localObject = this._currentEscape.getValue();
      this._currentEscape = null;
    }
    this._outputHead = this._outputTail;
    this._writer.write((String)localObject);
  }
  
  private void _writeLongString(String paramString)
  {
    _flushBuffer();
    int m = paramString.length();
    int i = 0;
    int k = this._outputEnd;
    int j = k;
    if (i + k > m) {
      j = m - i;
    }
    paramString.getChars(i, i + j, this._outputBuffer, 0);
    if (this._characterEscapes != null) {
      _writeSegmentCustom(j);
    }
    for (;;)
    {
      j = i + j;
      i = j;
      if (j < m) {
        break;
      }
      return;
      if (this._maximumNonEscapedChar != 0) {
        _writeSegmentASCII(j, this._maximumNonEscapedChar);
      } else {
        _writeSegment(j);
      }
    }
  }
  
  private final void _writeNull()
  {
    if (this._outputTail + 4 >= this._outputEnd) {
      _flushBuffer();
    }
    int i = this._outputTail;
    char[] arrayOfChar = this._outputBuffer;
    arrayOfChar[i] = 'n';
    i += 1;
    arrayOfChar[i] = 'u';
    i += 1;
    arrayOfChar[i] = 'l';
    i += 1;
    arrayOfChar[i] = 'l';
    this._outputTail = (i + 1);
  }
  
  private final void _writeQuotedInt(int paramInt)
  {
    if (this._outputTail + 13 >= this._outputEnd) {
      _flushBuffer();
    }
    char[] arrayOfChar = this._outputBuffer;
    int i = this._outputTail;
    this._outputTail = (i + 1);
    arrayOfChar[i] = '"';
    this._outputTail = NumberOutput.outputInt(paramInt, this._outputBuffer, this._outputTail);
    arrayOfChar = this._outputBuffer;
    paramInt = this._outputTail;
    this._outputTail = (paramInt + 1);
    arrayOfChar[paramInt] = '"';
  }
  
  private final void _writeQuotedLong(long paramLong)
  {
    if (this._outputTail + 23 >= this._outputEnd) {
      _flushBuffer();
    }
    char[] arrayOfChar = this._outputBuffer;
    int i = this._outputTail;
    this._outputTail = (i + 1);
    arrayOfChar[i] = '"';
    this._outputTail = NumberOutput.outputLong(paramLong, this._outputBuffer, this._outputTail);
    arrayOfChar = this._outputBuffer;
    i = this._outputTail;
    this._outputTail = (i + 1);
    arrayOfChar[i] = '"';
  }
  
  private final void _writeQuotedRaw(Object paramObject)
  {
    if (this._outputTail >= this._outputEnd) {
      _flushBuffer();
    }
    char[] arrayOfChar = this._outputBuffer;
    int i = this._outputTail;
    this._outputTail = (i + 1);
    arrayOfChar[i] = '"';
    writeRaw(paramObject.toString());
    if (this._outputTail >= this._outputEnd) {
      _flushBuffer();
    }
    paramObject = this._outputBuffer;
    i = this._outputTail;
    this._outputTail = (i + 1);
    paramObject[i] = 34;
  }
  
  private final void _writeSegment(int paramInt)
  {
    int[] arrayOfInt = this._outputEscapes;
    int n = arrayOfInt.length;
    int j = 0;
    int i;
    for (int k = 0;; k = _prependOrWriteCharacterEscape(this._outputBuffer, j, paramInt, i, arrayOfInt[i]))
    {
      if (j < paramInt)
      {
        i = this._outputBuffer[j];
        if ((i >= n) || (arrayOfInt[i] == 0)) {
          break label73;
        }
      }
      for (;;)
      {
        int m = j - k;
        if (m <= 0) {
          break label93;
        }
        this._writer.write(this._outputBuffer, k, m);
        if (j < paramInt) {
          break label93;
        }
        return;
        label73:
        m = j + 1;
        j = m;
        if (m < paramInt) {
          break;
        }
        j = m;
      }
      label93:
      j += 1;
    }
  }
  
  private final void _writeSegmentASCII(int paramInt1, int paramInt2)
  {
    int j = 0;
    int[] arrayOfInt = this._outputEscapes;
    int i2 = Math.min(arrayOfInt.length, this._maximumNonEscapedChar + 1);
    int m = 0;
    int k = 0;
    for (;;)
    {
      int i1;
      int i;
      if (k < paramInt1)
      {
        i1 = j;
        i = this._outputBuffer[k];
        if (i >= i2) {
          break label98;
        }
        j = arrayOfInt[i];
        if (j == 0) {
          break label113;
        }
      }
      for (;;)
      {
        int n = k - m;
        if (n <= 0) {
          break label140;
        }
        this._writer.write(this._outputBuffer, m, n);
        if (k < paramInt1) {
          break label140;
        }
        return;
        label98:
        j = i1;
        if (i > paramInt2)
        {
          j = -1;
        }
        else
        {
          label113:
          n = k + 1;
          i1 = j;
          k = n;
          if (n < paramInt1) {
            break;
          }
          k = n;
        }
      }
      label140:
      k += 1;
      m = _prependOrWriteCharacterEscape(this._outputBuffer, k, paramInt1, i, j);
    }
  }
  
  private final void _writeSegmentCustom(int paramInt)
  {
    int k = 0;
    int[] arrayOfInt = this._outputEscapes;
    int m;
    int i3;
    CharacterEscapes localCharacterEscapes;
    int n;
    int j;
    if (this._maximumNonEscapedChar < 1)
    {
      m = 65535;
      i3 = Math.min(arrayOfInt.length, this._maximumNonEscapedChar + 1);
      localCharacterEscapes = this._characterEscapes;
      n = 0;
      j = 0;
    }
    for (;;)
    {
      int i2;
      label55:
      int i;
      if (k < paramInt)
      {
        i2 = j;
        i = this._outputBuffer[k];
        if (i >= i3) {
          break label121;
        }
        j = arrayOfInt[i];
        if (j == 0) {
          break label160;
        }
      }
      for (;;)
      {
        int i1 = k - n;
        if (i1 <= 0) {
          break label186;
        }
        this._writer.write(this._outputBuffer, n, i1);
        if (k < paramInt) {
          break label186;
        }
        return;
        m = this._maximumNonEscapedChar;
        break;
        label121:
        if (i > m)
        {
          j = -1;
        }
        else
        {
          SerializableString localSerializableString = localCharacterEscapes.getEscapeSequence(i);
          this._currentEscape = localSerializableString;
          j = i2;
          if (localSerializableString != null)
          {
            j = -2;
          }
          else
          {
            label160:
            i1 = k + 1;
            i2 = j;
            k = i1;
            if (i1 < paramInt) {
              break label55;
            }
            k = i1;
          }
        }
      }
      label186:
      k += 1;
      n = _prependOrWriteCharacterEscape(this._outputBuffer, k, paramInt, i, j);
    }
  }
  
  private void _writeString(String paramString)
  {
    int i = paramString.length();
    if (i > this._outputEnd)
    {
      _writeLongString(paramString);
      return;
    }
    if (this._outputTail + i > this._outputEnd) {
      _flushBuffer();
    }
    paramString.getChars(0, i, this._outputBuffer, this._outputTail);
    if (this._characterEscapes != null)
    {
      _writeStringCustom(i);
      return;
    }
    if (this._maximumNonEscapedChar != 0)
    {
      _writeStringASCII(i, this._maximumNonEscapedChar);
      return;
    }
    _writeString2(i);
  }
  
  private final void _writeString(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (this._characterEscapes != null) {
      _writeStringCustom(paramArrayOfChar, paramInt1, paramInt2);
    }
    label50:
    label58:
    label78:
    label168:
    label189:
    label205:
    for (;;)
    {
      return;
      if (this._maximumNonEscapedChar != 0)
      {
        _writeStringASCII(paramArrayOfChar, paramInt1, paramInt2, this._maximumNonEscapedChar);
        return;
      }
      int j = paramInt2 + paramInt1;
      int[] arrayOfInt = this._outputEscapes;
      int k = arrayOfInt.length;
      int i;
      if (paramInt1 < j)
      {
        paramInt2 = paramInt1;
        i = paramArrayOfChar[paramInt2];
        if ((i >= k) || (arrayOfInt[i] == 0)) {
          break label168;
        }
        i = paramInt2 - paramInt1;
        if (i >= 32) {
          break label189;
        }
        if (this._outputTail + i > this._outputEnd) {
          _flushBuffer();
        }
        if (i > 0)
        {
          System.arraycopy(paramArrayOfChar, paramInt1, this._outputBuffer, this._outputTail, i);
          this._outputTail += i;
        }
      }
      for (;;)
      {
        if (paramInt2 >= j) {
          break label205;
        }
        paramInt1 = paramInt2 + 1;
        char c = paramArrayOfChar[paramInt2];
        _appendCharacterEscape(c, arrayOfInt[c]);
        break label50;
        break;
        i = paramInt2 + 1;
        paramInt2 = i;
        if (i < j) {
          break label58;
        }
        paramInt2 = i;
        break label78;
        _flushBuffer();
        this._writer.write(paramArrayOfChar, paramInt1, i);
      }
    }
  }
  
  private void _writeString2(int paramInt)
  {
    paramInt = this._outputTail + paramInt;
    int[] arrayOfInt = this._outputEscapes;
    int i = arrayOfInt.length;
    if (this._outputTail < paramInt)
    {
      int j;
      do
      {
        j = this._outputBuffer[this._outputTail];
        if ((j < i) && (arrayOfInt[j] != 0))
        {
          j = this._outputTail - this._outputHead;
          if (j > 0) {
            this._writer.write(this._outputBuffer, this._outputHead, j);
          }
          char[] arrayOfChar = this._outputBuffer;
          j = this._outputTail;
          this._outputTail = (j + 1);
          char c = arrayOfChar[j];
          _prependOrWriteCharacterEscape(c, arrayOfInt[c]);
          break;
        }
        j = this._outputTail + 1;
        this._outputTail = j;
      } while (j < paramInt);
    }
  }
  
  private void _writeStringASCII(int paramInt1, int paramInt2)
  {
    int j = this._outputTail + paramInt1;
    int[] arrayOfInt = this._outputEscapes;
    int k = Math.min(arrayOfInt.length, this._maximumNonEscapedChar + 1);
    if (this._outputTail < j) {
      label124:
      do
      {
        int i = this._outputBuffer[this._outputTail];
        if (i < k)
        {
          paramInt1 = arrayOfInt[i];
          if (paramInt1 == 0) {}
        }
        else
        {
          for (;;)
          {
            int m = this._outputTail - this._outputHead;
            if (m > 0) {
              this._writer.write(this._outputBuffer, this._outputHead, m);
            }
            this._outputTail += 1;
            _prependOrWriteCharacterEscape(i, paramInt1);
            break;
            if (i <= paramInt2) {
              break label124;
            }
            paramInt1 = -1;
          }
        }
        paramInt1 = this._outputTail + 1;
        this._outputTail = paramInt1;
      } while (paramInt1 < j);
    }
  }
  
  private final void _writeStringASCII(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3)
  {
    int n = paramInt2 + paramInt1;
    int[] arrayOfInt = this._outputEscapes;
    int i1 = Math.min(arrayOfInt.length, paramInt3 + 1);
    int j = 0;
    paramInt2 = paramInt1;
    paramInt1 = j;
    for (;;)
    {
      int m;
      int i;
      int k;
      if (paramInt2 < n)
      {
        j = paramInt2;
        m = paramInt1;
        i = paramArrayOfChar[j];
        if (i >= i1) {
          break label144;
        }
        k = arrayOfInt[i];
        paramInt1 = k;
        if (k == 0) {
          break label159;
        }
        paramInt1 = k;
        label74:
        k = j - paramInt2;
        if (k >= 32) {
          break label186;
        }
        if (this._outputTail + k > this._outputEnd) {
          _flushBuffer();
        }
        if (k > 0)
        {
          System.arraycopy(paramArrayOfChar, paramInt2, this._outputBuffer, this._outputTail, k);
          this._outputTail += k;
        }
      }
      for (;;)
      {
        if (j < n) {
          break label204;
        }
        return;
        label144:
        paramInt1 = m;
        if (i > paramInt3)
        {
          paramInt1 = -1;
          break label74;
        }
        label159:
        k = j + 1;
        m = paramInt1;
        j = k;
        if (k < n) {
          break;
        }
        j = k;
        break label74;
        label186:
        _flushBuffer();
        this._writer.write(paramArrayOfChar, paramInt2, k);
      }
      label204:
      paramInt2 = j + 1;
      _appendCharacterEscape(i, paramInt1);
    }
  }
  
  private void _writeStringCustom(int paramInt)
  {
    int k = this._outputTail + paramInt;
    int[] arrayOfInt = this._outputEscapes;
    int j;
    int m;
    CharacterEscapes localCharacterEscapes;
    if (this._maximumNonEscapedChar < 1)
    {
      j = 65535;
      m = Math.min(arrayOfInt.length, j + 1);
      localCharacterEscapes = this._characterEscapes;
      label42:
      if (this._outputTail >= k) {}
    }
    else
    {
      label171:
      do
      {
        int i = this._outputBuffer[this._outputTail];
        if (i < m)
        {
          paramInt = arrayOfInt[i];
          if (paramInt == 0) {}
        }
        else
        {
          for (;;)
          {
            int n = this._outputTail - this._outputHead;
            if (n > 0) {
              this._writer.write(this._outputBuffer, this._outputHead, n);
            }
            this._outputTail += 1;
            _prependOrWriteCharacterEscape(i, paramInt);
            break label42;
            j = this._maximumNonEscapedChar;
            break;
            if (i > j)
            {
              paramInt = -1;
            }
            else
            {
              SerializableString localSerializableString = localCharacterEscapes.getEscapeSequence(i);
              this._currentEscape = localSerializableString;
              if (localSerializableString == null) {
                break label171;
              }
              paramInt = -2;
            }
          }
        }
        paramInt = this._outputTail + 1;
        this._outputTail = paramInt;
      } while (paramInt < k);
    }
  }
  
  private final void _writeStringCustom(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int i1 = paramInt2 + paramInt1;
    int[] arrayOfInt = this._outputEscapes;
    int k;
    int i2;
    CharacterEscapes localCharacterEscapes;
    int j;
    if (this._maximumNonEscapedChar < 1)
    {
      k = 65535;
      i2 = Math.min(arrayOfInt.length, k + 1);
      localCharacterEscapes = this._characterEscapes;
      j = 0;
      paramInt2 = paramInt1;
      paramInt1 = j;
    }
    for (;;)
    {
      int n;
      label61:
      int i;
      int m;
      if (paramInt2 < i1)
      {
        j = paramInt2;
        n = paramInt1;
        i = paramArrayOfChar[j];
        if (i >= i2) {
          break label171;
        }
        m = arrayOfInt[i];
        paramInt1 = m;
        if (m == 0) {
          break label212;
        }
        paramInt1 = m;
        label92:
        m = j - paramInt2;
        if (m >= 32) {
          break label239;
        }
        if (this._outputTail + m > this._outputEnd) {
          _flushBuffer();
        }
        if (m > 0)
        {
          System.arraycopy(paramArrayOfChar, paramInt2, this._outputBuffer, this._outputTail, m);
          this._outputTail += m;
        }
      }
      for (;;)
      {
        if (j < i1) {
          break label257;
        }
        return;
        k = this._maximumNonEscapedChar;
        break;
        label171:
        if (i > k)
        {
          paramInt1 = -1;
          break label92;
        }
        SerializableString localSerializableString = localCharacterEscapes.getEscapeSequence(i);
        this._currentEscape = localSerializableString;
        paramInt1 = n;
        if (localSerializableString != null)
        {
          paramInt1 = -2;
          break label92;
        }
        label212:
        m = j + 1;
        n = paramInt1;
        j = m;
        if (m < i1) {
          break label61;
        }
        j = m;
        break label92;
        label239:
        _flushBuffer();
        this._writer.write(paramArrayOfChar, paramInt2, m);
      }
      label257:
      paramInt2 = j + 1;
      _appendCharacterEscape(i, paramInt1);
    }
  }
  
  private void writeRawLong(String paramString)
  {
    int j = this._outputEnd - this._outputTail;
    paramString.getChars(0, j, this._outputBuffer, this._outputTail);
    this._outputTail += j;
    _flushBuffer();
    int i = paramString.length() - j;
    while (i > this._outputEnd)
    {
      int k = this._outputEnd;
      paramString.getChars(j, j + k, this._outputBuffer, 0);
      this._outputHead = 0;
      this._outputTail = k;
      _flushBuffer();
      j += k;
      i -= k;
    }
    paramString.getChars(j, j + i, this._outputBuffer, 0);
    this._outputHead = 0;
    this._outputTail = i;
  }
  
  protected final void _flushBuffer()
  {
    int i = this._outputTail - this._outputHead;
    if (i > 0)
    {
      int j = this._outputHead;
      this._outputHead = 0;
      this._outputTail = 0;
      this._writer.write(this._outputBuffer, j, i);
    }
  }
  
  protected void _releaseBuffers()
  {
    char[] arrayOfChar = this._outputBuffer;
    if (arrayOfChar != null)
    {
      this._outputBuffer = null;
      this._ioContext.releaseConcatBuffer(arrayOfChar);
    }
  }
  
  protected final void _verifyPrettyValueWrite(String paramString, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      _cantHappen();
    }
    do
    {
      return;
      this._cfgPrettyPrinter.writeArrayValueSeparator(this);
      return;
      this._cfgPrettyPrinter.writeObjectFieldValueSeparator(this);
      return;
      this._cfgPrettyPrinter.writeRootValueSeparator(this);
      return;
      if (this._writeContext.inArray())
      {
        this._cfgPrettyPrinter.beforeArrayValues(this);
        return;
      }
    } while (!this._writeContext.inObject());
    this._cfgPrettyPrinter.beforeObjectEntries(this);
  }
  
  protected final void _verifyValueWrite(String paramString)
  {
    int j = this._writeContext.writeValue();
    if (j == 5) {
      _reportError("Can not " + paramString + ", expecting field name");
    }
    if (this._cfgPrettyPrinter == null)
    {
      int i;
      switch (j)
      {
      default: 
        return;
      case 1: 
        i = 44;
      }
      for (;;)
      {
        if (this._outputTail >= this._outputEnd) {
          _flushBuffer();
        }
        this._outputBuffer[this._outputTail] = i;
        this._outputTail += 1;
        return;
        i = 58;
        continue;
        i = 32;
      }
    }
    _verifyPrettyValueWrite(paramString, j);
  }
  
  protected void _writeBinary(Base64Variant paramBase64Variant, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int m = this._outputEnd - 6;
    int j = paramBase64Variant.getMaxLineLength() >> 2;
    int i = paramInt1;
    paramInt1 = j;
    int k;
    while (i <= paramInt2 - 3)
    {
      if (this._outputTail > m) {
        _flushBuffer();
      }
      j = i + 1;
      i = paramArrayOfByte[i];
      k = j + 1;
      int n = paramArrayOfByte[j];
      j = k + 1;
      this._outputTail = paramBase64Variant.encodeBase64Chunk((n & 0xFF | i << 8) << 8 | paramArrayOfByte[k] & 0xFF, this._outputBuffer, this._outputTail);
      k = paramInt1 - 1;
      paramInt1 = k;
      i = j;
      if (k <= 0)
      {
        char[] arrayOfChar = this._outputBuffer;
        paramInt1 = this._outputTail;
        this._outputTail = (paramInt1 + 1);
        arrayOfChar[paramInt1] = '\\';
        arrayOfChar = this._outputBuffer;
        paramInt1 = this._outputTail;
        this._outputTail = (paramInt1 + 1);
        arrayOfChar[paramInt1] = 'n';
        paramInt1 = paramBase64Variant.getMaxLineLength() >> 2;
        i = j;
      }
    }
    j = paramInt2 - i;
    if (j > 0)
    {
      if (this._outputTail > m) {
        _flushBuffer();
      }
      k = i + 1;
      paramInt2 = paramArrayOfByte[i] << 16;
      paramInt1 = paramInt2;
      if (j == 2) {
        paramInt1 = paramInt2 | (paramArrayOfByte[k] & 0xFF) << 8;
      }
      this._outputTail = paramBase64Variant.encodeBase64Partial(paramInt1, j, this._outputBuffer, this._outputTail);
    }
  }
  
  protected void _writeFieldName(String paramString, boolean paramBoolean)
  {
    if (this._cfgPrettyPrinter != null)
    {
      _writePPFieldName(paramString, paramBoolean);
      return;
    }
    if (this._outputTail + 1 >= this._outputEnd) {
      _flushBuffer();
    }
    if (paramBoolean)
    {
      arrayOfChar = this._outputBuffer;
      i = this._outputTail;
      this._outputTail = (i + 1);
      arrayOfChar[i] = ',';
    }
    if (!isEnabled(JsonGenerator.Feature.QUOTE_FIELD_NAMES))
    {
      _writeString(paramString);
      return;
    }
    char[] arrayOfChar = this._outputBuffer;
    int i = this._outputTail;
    this._outputTail = (i + 1);
    arrayOfChar[i] = '"';
    _writeString(paramString);
    if (this._outputTail >= this._outputEnd) {
      _flushBuffer();
    }
    paramString = this._outputBuffer;
    i = this._outputTail;
    this._outputTail = (i + 1);
    paramString[i] = 34;
  }
  
  public void _writeFieldName(SerializableString paramSerializableString, boolean paramBoolean)
  {
    if (this._cfgPrettyPrinter != null)
    {
      _writePPFieldName(paramSerializableString, paramBoolean);
      return;
    }
    if (this._outputTail + 1 >= this._outputEnd) {
      _flushBuffer();
    }
    if (paramBoolean)
    {
      arrayOfChar = this._outputBuffer;
      i = this._outputTail;
      this._outputTail = (i + 1);
      arrayOfChar[i] = ',';
    }
    paramSerializableString = paramSerializableString.asQuotedChars();
    if (!isEnabled(JsonGenerator.Feature.QUOTE_FIELD_NAMES))
    {
      writeRaw(paramSerializableString, 0, paramSerializableString.length);
      return;
    }
    char[] arrayOfChar = this._outputBuffer;
    int i = this._outputTail;
    this._outputTail = (i + 1);
    arrayOfChar[i] = '"';
    i = paramSerializableString.length;
    if (this._outputTail + i + 1 >= this._outputEnd)
    {
      writeRaw(paramSerializableString, 0, i);
      if (this._outputTail >= this._outputEnd) {
        _flushBuffer();
      }
      paramSerializableString = this._outputBuffer;
      i = this._outputTail;
      this._outputTail = (i + 1);
      paramSerializableString[i] = 34;
      return;
    }
    System.arraycopy(paramSerializableString, 0, this._outputBuffer, this._outputTail, i);
    this._outputTail += i;
    paramSerializableString = this._outputBuffer;
    i = this._outputTail;
    this._outputTail = (i + 1);
    paramSerializableString[i] = 34;
  }
  
  protected final void _writePPFieldName(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      this._cfgPrettyPrinter.writeObjectEntrySeparator(this);
    }
    while (isEnabled(JsonGenerator.Feature.QUOTE_FIELD_NAMES))
    {
      if (this._outputTail >= this._outputEnd) {
        _flushBuffer();
      }
      char[] arrayOfChar = this._outputBuffer;
      int i = this._outputTail;
      this._outputTail = (i + 1);
      arrayOfChar[i] = '"';
      _writeString(paramString);
      if (this._outputTail >= this._outputEnd) {
        _flushBuffer();
      }
      paramString = this._outputBuffer;
      i = this._outputTail;
      this._outputTail = (i + 1);
      paramString[i] = 34;
      return;
      this._cfgPrettyPrinter.beforeObjectEntries(this);
    }
    _writeString(paramString);
  }
  
  protected final void _writePPFieldName(SerializableString paramSerializableString, boolean paramBoolean)
  {
    if (paramBoolean) {
      this._cfgPrettyPrinter.writeObjectEntrySeparator(this);
    }
    for (;;)
    {
      paramSerializableString = paramSerializableString.asQuotedChars();
      if (!isEnabled(JsonGenerator.Feature.QUOTE_FIELD_NAMES)) {
        break;
      }
      if (this._outputTail >= this._outputEnd) {
        _flushBuffer();
      }
      char[] arrayOfChar = this._outputBuffer;
      int i = this._outputTail;
      this._outputTail = (i + 1);
      arrayOfChar[i] = '"';
      writeRaw(paramSerializableString, 0, paramSerializableString.length);
      if (this._outputTail >= this._outputEnd) {
        _flushBuffer();
      }
      paramSerializableString = this._outputBuffer;
      i = this._outputTail;
      this._outputTail = (i + 1);
      paramSerializableString[i] = 34;
      return;
      this._cfgPrettyPrinter.beforeObjectEntries(this);
    }
    writeRaw(paramSerializableString, 0, paramSerializableString.length);
  }
  
  public void close()
  {
    super.close();
    if ((this._outputBuffer != null) && (isEnabled(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT))) {
      for (;;)
      {
        JsonWriteContext localJsonWriteContext = getOutputContext();
        if (localJsonWriteContext.inArray())
        {
          writeEndArray();
        }
        else
        {
          if (!localJsonWriteContext.inObject()) {
            break;
          }
          writeEndObject();
        }
      }
    }
    _flushBuffer();
    if (this._writer != null)
    {
      if ((!this._ioContext.isResourceManaged()) && (!isEnabled(JsonGenerator.Feature.AUTO_CLOSE_TARGET))) {
        break label97;
      }
      this._writer.close();
    }
    for (;;)
    {
      _releaseBuffers();
      return;
      label97:
      if (isEnabled(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM)) {
        this._writer.flush();
      }
    }
  }
  
  public final void flush()
  {
    _flushBuffer();
    if ((this._writer != null) && (isEnabled(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM))) {
      this._writer.flush();
    }
  }
  
  public CharacterEscapes getCharacterEscapes()
  {
    return this._characterEscapes;
  }
  
  public int getHighestEscapedChar()
  {
    return this._maximumNonEscapedChar;
  }
  
  public Object getOutputTarget()
  {
    return this._writer;
  }
  
  public JsonGenerator setCharacterEscapes(CharacterEscapes paramCharacterEscapes)
  {
    this._characterEscapes = paramCharacterEscapes;
    if (paramCharacterEscapes == null)
    {
      this._outputEscapes = sOutputEscapes;
      return this;
    }
    this._outputEscapes = paramCharacterEscapes.getEscapeCodesForAscii();
    return this;
  }
  
  public JsonGenerator setHighestNonEscapedChar(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    this._maximumNonEscapedChar = i;
    return this;
  }
  
  public void writeBinary(Base64Variant paramBase64Variant, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    _verifyValueWrite("write binary value");
    if (this._outputTail >= this._outputEnd) {
      _flushBuffer();
    }
    char[] arrayOfChar = this._outputBuffer;
    int i = this._outputTail;
    this._outputTail = (i + 1);
    arrayOfChar[i] = '"';
    _writeBinary(paramBase64Variant, paramArrayOfByte, paramInt1, paramInt1 + paramInt2);
    if (this._outputTail >= this._outputEnd) {
      _flushBuffer();
    }
    paramBase64Variant = this._outputBuffer;
    paramInt1 = this._outputTail;
    this._outputTail = (paramInt1 + 1);
    paramBase64Variant[paramInt1] = 34;
  }
  
  public void writeBoolean(boolean paramBoolean)
  {
    _verifyValueWrite("write boolean value");
    if (this._outputTail + 5 >= this._outputEnd) {
      _flushBuffer();
    }
    int i = this._outputTail;
    char[] arrayOfChar = this._outputBuffer;
    if (paramBoolean)
    {
      arrayOfChar[i] = 't';
      i += 1;
      arrayOfChar[i] = 'r';
      i += 1;
      arrayOfChar[i] = 'u';
      i += 1;
      arrayOfChar[i] = 'e';
    }
    for (;;)
    {
      this._outputTail = (i + 1);
      return;
      arrayOfChar[i] = 'f';
      i += 1;
      arrayOfChar[i] = 'a';
      i += 1;
      arrayOfChar[i] = 'l';
      i += 1;
      arrayOfChar[i] = 's';
      i += 1;
      arrayOfChar[i] = 'e';
    }
  }
  
  public final void writeEndArray()
  {
    if (!this._writeContext.inArray()) {
      _reportError("Current context not an ARRAY but " + this._writeContext.getTypeDesc());
    }
    if (this._cfgPrettyPrinter != null) {
      this._cfgPrettyPrinter.writeEndArray(this, this._writeContext.getEntryCount());
    }
    for (;;)
    {
      this._writeContext = this._writeContext.getParent();
      return;
      if (this._outputTail >= this._outputEnd) {
        _flushBuffer();
      }
      char[] arrayOfChar = this._outputBuffer;
      int i = this._outputTail;
      this._outputTail = (i + 1);
      arrayOfChar[i] = ']';
    }
  }
  
  public final void writeEndObject()
  {
    if (!this._writeContext.inObject()) {
      _reportError("Current context not an object but " + this._writeContext.getTypeDesc());
    }
    this._writeContext = this._writeContext.getParent();
    if (this._cfgPrettyPrinter != null)
    {
      this._cfgPrettyPrinter.writeEndObject(this, this._writeContext.getEntryCount());
      return;
    }
    if (this._outputTail >= this._outputEnd) {
      _flushBuffer();
    }
    char[] arrayOfChar = this._outputBuffer;
    int i = this._outputTail;
    this._outputTail = (i + 1);
    arrayOfChar[i] = '}';
  }
  
  public final void writeFieldName(String paramString)
  {
    boolean bool = true;
    int i = this._writeContext.writeFieldName(paramString);
    if (i == 4) {
      _reportError("Can not write a field name, expecting a value");
    }
    if (i == 1) {}
    for (;;)
    {
      _writeFieldName(paramString, bool);
      return;
      bool = false;
    }
  }
  
  public final void writeFieldName(SerializableString paramSerializableString)
  {
    boolean bool = true;
    int i = this._writeContext.writeFieldName(paramSerializableString.getValue());
    if (i == 4) {
      _reportError("Can not write a field name, expecting a value");
    }
    if (i == 1) {}
    for (;;)
    {
      _writeFieldName(paramSerializableString, bool);
      return;
      bool = false;
    }
  }
  
  public final void writeFieldName(SerializedString paramSerializedString)
  {
    boolean bool = true;
    int i = this._writeContext.writeFieldName(paramSerializedString.getValue());
    if (i == 4) {
      _reportError("Can not write a field name, expecting a value");
    }
    if (i == 1) {}
    for (;;)
    {
      _writeFieldName(paramSerializedString, bool);
      return;
      bool = false;
    }
  }
  
  public void writeNull()
  {
    _verifyValueWrite("write null value");
    _writeNull();
  }
  
  public void writeNumber(double paramDouble)
  {
    if ((this._cfgNumbersAsStrings) || (((Double.isNaN(paramDouble)) || (Double.isInfinite(paramDouble))) && (isEnabled(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS))))
    {
      writeString(String.valueOf(paramDouble));
      return;
    }
    _verifyValueWrite("write number");
    writeRaw(String.valueOf(paramDouble));
  }
  
  public void writeNumber(float paramFloat)
  {
    if ((this._cfgNumbersAsStrings) || (((Float.isNaN(paramFloat)) || (Float.isInfinite(paramFloat))) && (isEnabled(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS))))
    {
      writeString(String.valueOf(paramFloat));
      return;
    }
    _verifyValueWrite("write number");
    writeRaw(String.valueOf(paramFloat));
  }
  
  public void writeNumber(int paramInt)
  {
    _verifyValueWrite("write number");
    if (this._cfgNumbersAsStrings)
    {
      _writeQuotedInt(paramInt);
      return;
    }
    if (this._outputTail + 11 >= this._outputEnd) {
      _flushBuffer();
    }
    this._outputTail = NumberOutput.outputInt(paramInt, this._outputBuffer, this._outputTail);
  }
  
  public void writeNumber(long paramLong)
  {
    _verifyValueWrite("write number");
    if (this._cfgNumbersAsStrings)
    {
      _writeQuotedLong(paramLong);
      return;
    }
    if (this._outputTail + 21 >= this._outputEnd) {
      _flushBuffer();
    }
    this._outputTail = NumberOutput.outputLong(paramLong, this._outputBuffer, this._outputTail);
  }
  
  public void writeNumber(String paramString)
  {
    _verifyValueWrite("write number");
    if (this._cfgNumbersAsStrings)
    {
      _writeQuotedRaw(paramString);
      return;
    }
    writeRaw(paramString);
  }
  
  public void writeNumber(BigDecimal paramBigDecimal)
  {
    _verifyValueWrite("write number");
    if (paramBigDecimal == null)
    {
      _writeNull();
      return;
    }
    if (this._cfgNumbersAsStrings)
    {
      _writeQuotedRaw(paramBigDecimal);
      return;
    }
    writeRaw(paramBigDecimal.toString());
  }
  
  public void writeNumber(BigInteger paramBigInteger)
  {
    _verifyValueWrite("write number");
    if (paramBigInteger == null)
    {
      _writeNull();
      return;
    }
    if (this._cfgNumbersAsStrings)
    {
      _writeQuotedRaw(paramBigInteger);
      return;
    }
    writeRaw(paramBigInteger.toString());
  }
  
  public void writeRaw(char paramChar)
  {
    if (this._outputTail >= this._outputEnd) {
      _flushBuffer();
    }
    char[] arrayOfChar = this._outputBuffer;
    int i = this._outputTail;
    this._outputTail = (i + 1);
    arrayOfChar[i] = paramChar;
  }
  
  public void writeRaw(String paramString)
  {
    int k = paramString.length();
    int j = this._outputEnd - this._outputTail;
    int i = j;
    if (j == 0)
    {
      _flushBuffer();
      i = this._outputEnd - this._outputTail;
    }
    if (i >= k)
    {
      paramString.getChars(0, k, this._outputBuffer, this._outputTail);
      this._outputTail += k;
      return;
    }
    writeRawLong(paramString);
  }
  
  public void writeRaw(String paramString, int paramInt1, int paramInt2)
  {
    int j = this._outputEnd - this._outputTail;
    int i = j;
    if (j < paramInt2)
    {
      _flushBuffer();
      i = this._outputEnd - this._outputTail;
    }
    if (i >= paramInt2)
    {
      paramString.getChars(paramInt1, paramInt1 + paramInt2, this._outputBuffer, this._outputTail);
      this._outputTail += paramInt2;
      return;
    }
    writeRawLong(paramString.substring(paramInt1, paramInt1 + paramInt2));
  }
  
  public void writeRaw(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (paramInt2 < 32)
    {
      if (paramInt2 > this._outputEnd - this._outputTail) {
        _flushBuffer();
      }
      System.arraycopy(paramArrayOfChar, paramInt1, this._outputBuffer, this._outputTail, paramInt2);
      this._outputTail += paramInt2;
      return;
    }
    _flushBuffer();
    this._writer.write(paramArrayOfChar, paramInt1, paramInt2);
  }
  
  public void writeRawUTF8String(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    _reportUnsupportedOperation();
  }
  
  public final void writeStartArray()
  {
    _verifyValueWrite("start an array");
    this._writeContext = this._writeContext.createChildArrayContext();
    if (this._cfgPrettyPrinter != null)
    {
      this._cfgPrettyPrinter.writeStartArray(this);
      return;
    }
    if (this._outputTail >= this._outputEnd) {
      _flushBuffer();
    }
    char[] arrayOfChar = this._outputBuffer;
    int i = this._outputTail;
    this._outputTail = (i + 1);
    arrayOfChar[i] = '[';
  }
  
  public final void writeStartObject()
  {
    _verifyValueWrite("start an object");
    this._writeContext = this._writeContext.createChildObjectContext();
    if (this._cfgPrettyPrinter != null)
    {
      this._cfgPrettyPrinter.writeStartObject(this);
      return;
    }
    if (this._outputTail >= this._outputEnd) {
      _flushBuffer();
    }
    char[] arrayOfChar = this._outputBuffer;
    int i = this._outputTail;
    this._outputTail = (i + 1);
    arrayOfChar[i] = '{';
  }
  
  public void writeString(String paramString)
  {
    _verifyValueWrite("write text value");
    if (paramString == null)
    {
      _writeNull();
      return;
    }
    if (this._outputTail >= this._outputEnd) {
      _flushBuffer();
    }
    char[] arrayOfChar = this._outputBuffer;
    int i = this._outputTail;
    this._outputTail = (i + 1);
    arrayOfChar[i] = '"';
    _writeString(paramString);
    if (this._outputTail >= this._outputEnd) {
      _flushBuffer();
    }
    paramString = this._outputBuffer;
    i = this._outputTail;
    this._outputTail = (i + 1);
    paramString[i] = 34;
  }
  
  public final void writeString(SerializableString paramSerializableString)
  {
    _verifyValueWrite("write text value");
    if (this._outputTail >= this._outputEnd) {
      _flushBuffer();
    }
    char[] arrayOfChar = this._outputBuffer;
    int i = this._outputTail;
    this._outputTail = (i + 1);
    arrayOfChar[i] = '"';
    paramSerializableString = paramSerializableString.asQuotedChars();
    i = paramSerializableString.length;
    if (i < 32)
    {
      if (i > this._outputEnd - this._outputTail) {
        _flushBuffer();
      }
      System.arraycopy(paramSerializableString, 0, this._outputBuffer, this._outputTail, i);
      this._outputTail += i;
    }
    for (;;)
    {
      if (this._outputTail >= this._outputEnd) {
        _flushBuffer();
      }
      paramSerializableString = this._outputBuffer;
      i = this._outputTail;
      this._outputTail = (i + 1);
      paramSerializableString[i] = 34;
      return;
      _flushBuffer();
      this._writer.write(paramSerializableString, 0, i);
    }
  }
  
  public void writeString(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    _verifyValueWrite("write text value");
    if (this._outputTail >= this._outputEnd) {
      _flushBuffer();
    }
    char[] arrayOfChar = this._outputBuffer;
    int i = this._outputTail;
    this._outputTail = (i + 1);
    arrayOfChar[i] = '"';
    _writeString(paramArrayOfChar, paramInt1, paramInt2);
    if (this._outputTail >= this._outputEnd) {
      _flushBuffer();
    }
    paramArrayOfChar = this._outputBuffer;
    paramInt1 = this._outputTail;
    this._outputTail = (paramInt1 + 1);
    paramArrayOfChar[paramInt1] = '"';
  }
  
  public final void writeStringField(String paramString1, String paramString2)
  {
    writeFieldName(paramString1);
    writeString(paramString2);
  }
  
  public void writeUTF8String(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    _reportUnsupportedOperation();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/impl/WriterBasedGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */