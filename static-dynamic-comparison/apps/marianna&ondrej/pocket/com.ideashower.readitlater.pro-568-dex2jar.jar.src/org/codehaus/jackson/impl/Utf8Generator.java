package org.codehaus.jackson.impl;

import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.codehaus.jackson.Base64Variant;
import org.codehaus.jackson.JsonGenerationException;
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

public class Utf8Generator
  extends JsonGeneratorBase
{
  private static final byte BYTE_0 = 48;
  private static final byte BYTE_BACKSLASH = 92;
  private static final byte BYTE_COLON = 58;
  private static final byte BYTE_COMMA = 44;
  private static final byte BYTE_LBRACKET = 91;
  private static final byte BYTE_LCURLY = 123;
  private static final byte BYTE_QUOTE = 34;
  private static final byte BYTE_RBRACKET = 93;
  private static final byte BYTE_RCURLY = 125;
  private static final byte BYTE_SPACE = 32;
  private static final byte BYTE_u = 117;
  private static final byte[] FALSE_BYTES = { 102, 97, 108, 115, 101 };
  static final byte[] HEX_CHARS = ;
  private static final int MAX_BYTES_TO_BUFFER = 512;
  private static final byte[] NULL_BYTES = { 110, 117, 108, 108 };
  protected static final int SURR1_FIRST = 55296;
  protected static final int SURR1_LAST = 56319;
  protected static final int SURR2_FIRST = 56320;
  protected static final int SURR2_LAST = 57343;
  private static final byte[] TRUE_BYTES = { 116, 114, 117, 101 };
  protected static final int[] sOutputEscapes = CharTypes.get7BitOutputEscapes();
  protected boolean _bufferRecyclable;
  protected char[] _charBuffer;
  protected final int _charBufferLength;
  protected CharacterEscapes _characterEscapes;
  protected byte[] _entityBuffer;
  protected final IOContext _ioContext;
  protected int _maximumNonEscapedChar;
  protected byte[] _outputBuffer;
  protected final int _outputEnd;
  protected int[] _outputEscapes = sOutputEscapes;
  protected final int _outputMaxContiguous;
  protected final OutputStream _outputStream;
  protected int _outputTail = 0;
  
  public Utf8Generator(IOContext paramIOContext, int paramInt, ObjectCodec paramObjectCodec, OutputStream paramOutputStream)
  {
    super(paramInt, paramObjectCodec);
    this._ioContext = paramIOContext;
    this._outputStream = paramOutputStream;
    this._bufferRecyclable = true;
    this._outputBuffer = paramIOContext.allocWriteEncodingBuffer();
    this._outputEnd = this._outputBuffer.length;
    this._outputMaxContiguous = (this._outputEnd >> 3);
    this._charBuffer = paramIOContext.allocConcatBuffer();
    this._charBufferLength = this._charBuffer.length;
    if (isEnabled(JsonGenerator.Feature.ESCAPE_NON_ASCII)) {
      setHighestNonEscapedChar(127);
    }
  }
  
  public Utf8Generator(IOContext paramIOContext, int paramInt1, ObjectCodec paramObjectCodec, OutputStream paramOutputStream, byte[] paramArrayOfByte, int paramInt2, boolean paramBoolean)
  {
    super(paramInt1, paramObjectCodec);
    this._ioContext = paramIOContext;
    this._outputStream = paramOutputStream;
    this._bufferRecyclable = paramBoolean;
    this._outputTail = paramInt2;
    this._outputBuffer = paramArrayOfByte;
    this._outputEnd = this._outputBuffer.length;
    this._outputMaxContiguous = (this._outputEnd >> 3);
    this._charBuffer = paramIOContext.allocConcatBuffer();
    this._charBufferLength = this._charBuffer.length;
    if (isEnabled(JsonGenerator.Feature.ESCAPE_NON_ASCII)) {
      setHighestNonEscapedChar(127);
    }
  }
  
  private int _handleLongCustomEscape(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
  {
    int j = paramArrayOfByte2.length;
    int i;
    if (paramInt1 + j > paramInt2)
    {
      this._outputTail = paramInt1;
      _flushBuffer();
      i = this._outputTail;
      if (j > paramArrayOfByte1.length)
      {
        this._outputStream.write(paramArrayOfByte2, 0, j);
        return i;
      }
      System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte1, i, j);
      paramInt1 = i + j;
    }
    for (;;)
    {
      i = paramInt1;
      if (paramInt3 * 6 + paramInt1 <= paramInt2) {
        break;
      }
      _flushBuffer();
      return this._outputTail;
    }
  }
  
  private final int _outputMultiByteChar(int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = this._outputBuffer;
    if ((paramInt1 >= 55296) && (paramInt1 <= 57343))
    {
      i = paramInt2 + 1;
      arrayOfByte[paramInt2] = 92;
      paramInt2 = i + 1;
      arrayOfByte[i] = 117;
      i = paramInt2 + 1;
      arrayOfByte[paramInt2] = HEX_CHARS[(paramInt1 >> 12 & 0xF)];
      paramInt2 = i + 1;
      arrayOfByte[i] = HEX_CHARS[(paramInt1 >> 8 & 0xF)];
      i = paramInt2 + 1;
      arrayOfByte[paramInt2] = HEX_CHARS[(paramInt1 >> 4 & 0xF)];
      arrayOfByte[i] = HEX_CHARS[(paramInt1 & 0xF)];
      return i + 1;
    }
    int i = paramInt2 + 1;
    arrayOfByte[paramInt2] = ((byte)(paramInt1 >> 12 | 0xE0));
    paramInt2 = i + 1;
    arrayOfByte[i] = ((byte)(paramInt1 >> 6 & 0x3F | 0x80));
    arrayOfByte[paramInt2] = ((byte)(paramInt1 & 0x3F | 0x80));
    return paramInt2 + 1;
  }
  
  private final int _outputRawMultiByteChar(int paramInt1, char[] paramArrayOfChar, int paramInt2, int paramInt3)
  {
    if ((paramInt1 >= 55296) && (paramInt1 <= 57343))
    {
      if (paramInt2 >= paramInt3) {
        _reportError("Split surrogate on writeRaw() input (last character)");
      }
      _outputSurrogates(paramInt1, paramArrayOfChar[paramInt2]);
      return paramInt2 + 1;
    }
    paramArrayOfChar = this._outputBuffer;
    paramInt3 = this._outputTail;
    this._outputTail = (paramInt3 + 1);
    paramArrayOfChar[paramInt3] = ((byte)(paramInt1 >> 12 | 0xE0));
    paramInt3 = this._outputTail;
    this._outputTail = (paramInt3 + 1);
    paramArrayOfChar[paramInt3] = ((byte)(paramInt1 >> 6 & 0x3F | 0x80));
    paramInt3 = this._outputTail;
    this._outputTail = (paramInt3 + 1);
    paramArrayOfChar[paramInt3] = ((byte)(paramInt1 & 0x3F | 0x80));
    return paramInt2;
  }
  
  private final void _writeBytes(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    if (this._outputTail + i > this._outputEnd)
    {
      _flushBuffer();
      if (i > 512)
      {
        this._outputStream.write(paramArrayOfByte, 0, i);
        return;
      }
    }
    System.arraycopy(paramArrayOfByte, 0, this._outputBuffer, this._outputTail, i);
    this._outputTail = (i + this._outputTail);
  }
  
  private final void _writeBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this._outputTail + paramInt2 > this._outputEnd)
    {
      _flushBuffer();
      if (paramInt2 > 512)
      {
        this._outputStream.write(paramArrayOfByte, paramInt1, paramInt2);
        return;
      }
    }
    System.arraycopy(paramArrayOfByte, paramInt1, this._outputBuffer, this._outputTail, paramInt2);
    this._outputTail += paramInt2;
  }
  
  private int _writeCustomEscape(byte[] paramArrayOfByte, int paramInt1, SerializableString paramSerializableString, int paramInt2)
  {
    paramSerializableString = paramSerializableString.asUnquotedUTF8();
    int i = paramSerializableString.length;
    if (i > 6) {
      return _handleLongCustomEscape(paramArrayOfByte, paramInt1, this._outputEnd, paramSerializableString, paramInt2);
    }
    System.arraycopy(paramSerializableString, 0, paramArrayOfByte, paramInt1, i);
    return i + paramInt1;
  }
  
  private final void _writeCustomStringSegment2(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (this._outputTail + (paramInt2 - paramInt1) * 6 > this._outputEnd) {
      _flushBuffer();
    }
    int j = this._outputTail;
    byte[] arrayOfByte = this._outputBuffer;
    int[] arrayOfInt = this._outputEscapes;
    int k;
    CharacterEscapes localCharacterEscapes;
    int i;
    if (this._maximumNonEscapedChar <= 0)
    {
      k = 65535;
      localCharacterEscapes = this._characterEscapes;
      i = paramInt1;
      paramInt1 = j;
    }
    for (;;)
    {
      if (i < paramInt2)
      {
        j = i + 1;
        i = paramArrayOfChar[i];
        int m;
        SerializableString localSerializableString;
        if (i <= 127)
        {
          if (arrayOfInt[i] == 0)
          {
            arrayOfByte[paramInt1] = ((byte)i);
            paramInt1 += 1;
            i = j;
            continue;
            k = this._maximumNonEscapedChar;
            break;
          }
          m = arrayOfInt[i];
          if (m > 0)
          {
            i = paramInt1 + 1;
            arrayOfByte[paramInt1] = 92;
            paramInt1 = i + 1;
            arrayOfByte[i] = ((byte)m);
            i = j;
            continue;
          }
          if (m == -2)
          {
            localSerializableString = localCharacterEscapes.getEscapeSequence(i);
            if (localSerializableString == null) {
              throw new JsonGenerationException("Invalid custom escape definitions; custom escape not found for character code 0x" + Integer.toHexString(i) + ", although was supposed to have one");
            }
            paramInt1 = _writeCustomEscape(arrayOfByte, paramInt1, localSerializableString, paramInt2 - j);
            i = j;
            continue;
          }
          paramInt1 = _writeGenericEscape(i, paramInt1);
          i = j;
          continue;
        }
        if (i > k)
        {
          paramInt1 = _writeGenericEscape(i, paramInt1);
          i = j;
        }
        else
        {
          localSerializableString = localCharacterEscapes.getEscapeSequence(i);
          if (localSerializableString != null)
          {
            paramInt1 = _writeCustomEscape(arrayOfByte, paramInt1, localSerializableString, paramInt2 - j);
            i = j;
          }
          else
          {
            if (i <= 2047)
            {
              m = paramInt1 + 1;
              arrayOfByte[paramInt1] = ((byte)(i >> 6 | 0xC0));
              paramInt1 = m + 1;
              arrayOfByte[m] = ((byte)(i & 0x3F | 0x80));
            }
            for (;;)
            {
              i = j;
              break;
              paramInt1 = _outputMultiByteChar(i, paramInt1);
            }
          }
        }
      }
    }
    this._outputTail = paramInt1;
  }
  
  private int _writeGenericEscape(int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = this._outputBuffer;
    int i = paramInt2 + 1;
    arrayOfByte[paramInt2] = 92;
    paramInt2 = i + 1;
    arrayOfByte[i] = 117;
    if (paramInt1 > 255)
    {
      i = paramInt1 >> 8 & 0xFF;
      int j = paramInt2 + 1;
      arrayOfByte[paramInt2] = HEX_CHARS[(i >> 4)];
      paramInt2 = j + 1;
      arrayOfByte[j] = HEX_CHARS[(i & 0xF)];
      paramInt1 &= 0xFF;
    }
    for (;;)
    {
      i = paramInt2 + 1;
      arrayOfByte[paramInt2] = HEX_CHARS[(paramInt1 >> 4)];
      arrayOfByte[i] = HEX_CHARS[(paramInt1 & 0xF)];
      return i + 1;
      i = paramInt2 + 1;
      arrayOfByte[paramInt2] = 48;
      paramInt2 = i + 1;
      arrayOfByte[i] = 48;
    }
  }
  
  private final void _writeLongString(String paramString)
  {
    if (this._outputTail >= this._outputEnd) {
      _flushBuffer();
    }
    byte[] arrayOfByte = this._outputBuffer;
    int i = this._outputTail;
    this._outputTail = (i + 1);
    arrayOfByte[i] = 34;
    _writeStringSegments(paramString);
    if (this._outputTail >= this._outputEnd) {
      _flushBuffer();
    }
    paramString = this._outputBuffer;
    i = this._outputTail;
    this._outputTail = (i + 1);
    paramString[i] = 34;
  }
  
  private final void _writeLongString(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (this._outputTail >= this._outputEnd) {
      _flushBuffer();
    }
    paramArrayOfChar = this._outputBuffer;
    paramInt1 = this._outputTail;
    this._outputTail = (paramInt1 + 1);
    paramArrayOfChar[paramInt1] = '"';
    _writeStringSegments(this._charBuffer, 0, paramInt2);
    if (this._outputTail >= this._outputEnd) {
      _flushBuffer();
    }
    paramArrayOfChar = this._outputBuffer;
    paramInt1 = this._outputTail;
    this._outputTail = (paramInt1 + 1);
    paramArrayOfChar[paramInt1] = '"';
  }
  
  private final void _writeNull()
  {
    if (this._outputTail + 4 >= this._outputEnd) {
      _flushBuffer();
    }
    System.arraycopy(NULL_BYTES, 0, this._outputBuffer, this._outputTail, 4);
    this._outputTail += 4;
  }
  
  private final void _writeQuotedInt(int paramInt)
  {
    if (this._outputTail + 13 >= this._outputEnd) {
      _flushBuffer();
    }
    byte[] arrayOfByte = this._outputBuffer;
    int i = this._outputTail;
    this._outputTail = (i + 1);
    arrayOfByte[i] = 34;
    this._outputTail = NumberOutput.outputInt(paramInt, this._outputBuffer, this._outputTail);
    arrayOfByte = this._outputBuffer;
    paramInt = this._outputTail;
    this._outputTail = (paramInt + 1);
    arrayOfByte[paramInt] = 34;
  }
  
  private final void _writeQuotedLong(long paramLong)
  {
    if (this._outputTail + 23 >= this._outputEnd) {
      _flushBuffer();
    }
    byte[] arrayOfByte = this._outputBuffer;
    int i = this._outputTail;
    this._outputTail = (i + 1);
    arrayOfByte[i] = 34;
    this._outputTail = NumberOutput.outputLong(paramLong, this._outputBuffer, this._outputTail);
    arrayOfByte = this._outputBuffer;
    i = this._outputTail;
    this._outputTail = (i + 1);
    arrayOfByte[i] = 34;
  }
  
  private final void _writeQuotedRaw(Object paramObject)
  {
    if (this._outputTail >= this._outputEnd) {
      _flushBuffer();
    }
    byte[] arrayOfByte = this._outputBuffer;
    int i = this._outputTail;
    this._outputTail = (i + 1);
    arrayOfByte[i] = 34;
    writeRaw(paramObject.toString());
    if (this._outputTail >= this._outputEnd) {
      _flushBuffer();
    }
    paramObject = this._outputBuffer;
    i = this._outputTail;
    this._outputTail = (i + 1);
    paramObject[i] = 34;
  }
  
  private final void _writeSegmentedRaw(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int j = this._outputEnd;
    byte[] arrayOfByte = this._outputBuffer;
    label17:
    int i;
    int k;
    if (paramInt1 < paramInt2)
    {
      i = paramArrayOfChar[paramInt1];
      if (i >= 128)
      {
        if (this._outputTail + 3 >= this._outputEnd) {
          _flushBuffer();
        }
        i = paramInt1 + 1;
        paramInt1 = paramArrayOfChar[paramInt1];
        if (paramInt1 >= 2048) {
          break label175;
        }
        k = this._outputTail;
        this._outputTail = (k + 1);
        arrayOfByte[k] = ((byte)(paramInt1 >> 6 | 0xC0));
        k = this._outputTail;
        this._outputTail = (k + 1);
        arrayOfByte[k] = ((byte)(paramInt1 & 0x3F | 0x80));
      }
    }
    for (;;)
    {
      paramInt1 = i;
      break;
      if (this._outputTail >= j) {
        _flushBuffer();
      }
      k = this._outputTail;
      this._outputTail = (k + 1);
      arrayOfByte[k] = ((byte)i);
      i = paramInt1 + 1;
      paramInt1 = i;
      if (i < paramInt2) {
        break label17;
      }
      return;
      label175:
      _outputRawMultiByteChar(paramInt1, paramArrayOfChar, i, paramInt2);
    }
  }
  
  private final void _writeStringSegment(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int j = paramInt2 + paramInt1;
    int i = this._outputTail;
    byte[] arrayOfByte = this._outputBuffer;
    int[] arrayOfInt = this._outputEscapes;
    paramInt2 = paramInt1;
    paramInt1 = i;
    for (;;)
    {
      if (paramInt2 < j)
      {
        i = paramArrayOfChar[paramInt2];
        if ((i <= 127) && (arrayOfInt[i] == 0)) {}
      }
      else
      {
        this._outputTail = paramInt1;
        if (paramInt2 < j)
        {
          if (this._characterEscapes == null) {
            break;
          }
          _writeCustomStringSegment2(paramArrayOfChar, paramInt2, j);
        }
        return;
      }
      arrayOfByte[paramInt1] = ((byte)i);
      paramInt2 += 1;
      paramInt1 += 1;
    }
    if (this._maximumNonEscapedChar == 0)
    {
      _writeStringSegment2(paramArrayOfChar, paramInt2, j);
      return;
    }
    _writeStringSegmentASCII2(paramArrayOfChar, paramInt2, j);
  }
  
  private final void _writeStringSegment2(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (this._outputTail + (paramInt2 - paramInt1) * 6 > this._outputEnd) {
      _flushBuffer();
    }
    int j = this._outputTail;
    byte[] arrayOfByte = this._outputBuffer;
    int[] arrayOfInt = this._outputEscapes;
    int i = paramInt1;
    paramInt1 = j;
    while (i < paramInt2)
    {
      j = i + 1;
      i = paramArrayOfChar[i];
      int k;
      if (i <= 127)
      {
        if (arrayOfInt[i] == 0)
        {
          arrayOfByte[paramInt1] = ((byte)i);
          paramInt1 += 1;
          i = j;
        }
        else
        {
          k = arrayOfInt[i];
          if (k > 0)
          {
            i = paramInt1 + 1;
            arrayOfByte[paramInt1] = 92;
            paramInt1 = i + 1;
            arrayOfByte[i] = ((byte)k);
            i = j;
          }
          else
          {
            paramInt1 = _writeGenericEscape(i, paramInt1);
            i = j;
          }
        }
      }
      else
      {
        if (i <= 2047)
        {
          k = paramInt1 + 1;
          arrayOfByte[paramInt1] = ((byte)(i >> 6 | 0xC0));
          paramInt1 = k + 1;
          arrayOfByte[k] = ((byte)(i & 0x3F | 0x80));
        }
        for (;;)
        {
          i = j;
          break;
          paramInt1 = _outputMultiByteChar(i, paramInt1);
        }
      }
    }
    this._outputTail = paramInt1;
  }
  
  private final void _writeStringSegmentASCII2(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (this._outputTail + (paramInt2 - paramInt1) * 6 > this._outputEnd) {
      _flushBuffer();
    }
    int j = this._outputTail;
    byte[] arrayOfByte = this._outputBuffer;
    int[] arrayOfInt = this._outputEscapes;
    int k = this._maximumNonEscapedChar;
    int i = paramInt1;
    paramInt1 = j;
    while (i < paramInt2)
    {
      j = i + 1;
      i = paramArrayOfChar[i];
      int m;
      if (i <= 127)
      {
        if (arrayOfInt[i] == 0)
        {
          arrayOfByte[paramInt1] = ((byte)i);
          paramInt1 += 1;
          i = j;
        }
        else
        {
          m = arrayOfInt[i];
          if (m > 0)
          {
            i = paramInt1 + 1;
            arrayOfByte[paramInt1] = 92;
            paramInt1 = i + 1;
            arrayOfByte[i] = ((byte)m);
            i = j;
          }
          else
          {
            paramInt1 = _writeGenericEscape(i, paramInt1);
            i = j;
          }
        }
      }
      else if (i > k)
      {
        paramInt1 = _writeGenericEscape(i, paramInt1);
        i = j;
      }
      else
      {
        if (i <= 2047)
        {
          m = paramInt1 + 1;
          arrayOfByte[paramInt1] = ((byte)(i >> 6 | 0xC0));
          paramInt1 = m + 1;
          arrayOfByte[m] = ((byte)(i & 0x3F | 0x80));
        }
        for (;;)
        {
          i = j;
          break;
          paramInt1 = _outputMultiByteChar(i, paramInt1);
        }
      }
    }
    this._outputTail = paramInt1;
  }
  
  private final void _writeStringSegments(String paramString)
  {
    int i = paramString.length();
    char[] arrayOfChar = this._charBuffer;
    int j = 0;
    while (i > 0)
    {
      int k = Math.min(this._outputMaxContiguous, i);
      paramString.getChars(j, j + k, arrayOfChar, 0);
      if (this._outputTail + k > this._outputEnd) {
        _flushBuffer();
      }
      _writeStringSegment(arrayOfChar, 0, k);
      j += k;
      i -= k;
    }
  }
  
  private final void _writeStringSegments(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int i;
    do
    {
      i = Math.min(this._outputMaxContiguous, paramInt2);
      if (this._outputTail + i > this._outputEnd) {
        _flushBuffer();
      }
      _writeStringSegment(paramArrayOfChar, paramInt1, i);
      paramInt1 += i;
      i = paramInt2 - i;
      paramInt2 = i;
    } while (i > 0);
  }
  
  private final void _writeUTF8Segment(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = this._outputEscapes;
    int i = paramInt1;
    while (i < paramInt1 + paramInt2)
    {
      int j = paramArrayOfByte[i];
      if ((j >= 0) && (arrayOfInt[j] != 0))
      {
        _writeUTF8Segment2(paramArrayOfByte, paramInt1, paramInt2);
        return;
      }
      i += 1;
    }
    if (this._outputTail + paramInt2 > this._outputEnd) {
      _flushBuffer();
    }
    System.arraycopy(paramArrayOfByte, paramInt1, this._outputBuffer, this._outputTail, paramInt2);
    this._outputTail += paramInt2;
  }
  
  private final void _writeUTF8Segment2(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int j = this._outputTail;
    int k = j;
    if (paramInt2 * 6 + j > this._outputEnd)
    {
      _flushBuffer();
      k = this._outputTail;
    }
    byte[] arrayOfByte = this._outputBuffer;
    int[] arrayOfInt = this._outputEscapes;
    j = paramInt1;
    int i;
    for (;;)
    {
      m = j;
      if (m >= paramInt2 + paramInt1) {
        break label157;
      }
      j = m + 1;
      i = paramArrayOfByte[m];
      if ((i >= 0) && (arrayOfInt[i] != 0)) {
        break;
      }
      arrayOfByte[k] = i;
      k += 1;
    }
    int m = arrayOfInt[i];
    if (m > 0)
    {
      int n = k + 1;
      arrayOfByte[k] = 92;
      k = n + 1;
      arrayOfByte[n] = ((byte)m);
    }
    for (;;)
    {
      break;
      k = _writeGenericEscape(i, k);
    }
    label157:
    this._outputTail = k;
  }
  
  private final void _writeUTF8Segments(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i;
    do
    {
      i = Math.min(this._outputMaxContiguous, paramInt2);
      _writeUTF8Segment(paramArrayOfByte, paramInt1, i);
      paramInt1 += i;
      i = paramInt2 - i;
      paramInt2 = i;
    } while (i > 0);
  }
  
  protected final int _decodeSurrogate(int paramInt1, int paramInt2)
  {
    if ((paramInt2 < 56320) || (paramInt2 > 57343)) {
      _reportError("Incomplete surrogate pair: first char 0x" + Integer.toHexString(paramInt1) + ", second 0x" + Integer.toHexString(paramInt2));
    }
    return 65536 + (paramInt1 - 55296 << 10) + (paramInt2 - 56320);
  }
  
  protected final void _flushBuffer()
  {
    int i = this._outputTail;
    if (i > 0)
    {
      this._outputTail = 0;
      this._outputStream.write(this._outputBuffer, 0, i);
    }
  }
  
  protected final void _outputSurrogates(int paramInt1, int paramInt2)
  {
    paramInt1 = _decodeSurrogate(paramInt1, paramInt2);
    if (this._outputTail + 4 > this._outputEnd) {
      _flushBuffer();
    }
    byte[] arrayOfByte = this._outputBuffer;
    paramInt2 = this._outputTail;
    this._outputTail = (paramInt2 + 1);
    arrayOfByte[paramInt2] = ((byte)(paramInt1 >> 18 | 0xF0));
    paramInt2 = this._outputTail;
    this._outputTail = (paramInt2 + 1);
    arrayOfByte[paramInt2] = ((byte)(paramInt1 >> 12 & 0x3F | 0x80));
    paramInt2 = this._outputTail;
    this._outputTail = (paramInt2 + 1);
    arrayOfByte[paramInt2] = ((byte)(paramInt1 >> 6 & 0x3F | 0x80));
    paramInt2 = this._outputTail;
    this._outputTail = (paramInt2 + 1);
    arrayOfByte[paramInt2] = ((byte)(paramInt1 & 0x3F | 0x80));
  }
  
  protected void _releaseBuffers()
  {
    Object localObject = this._outputBuffer;
    if ((localObject != null) && (this._bufferRecyclable))
    {
      this._outputBuffer = null;
      this._ioContext.releaseWriteEncodingBuffer((byte[])localObject);
    }
    localObject = this._charBuffer;
    if (localObject != null)
    {
      this._charBuffer = null;
      this._ioContext.releaseConcatBuffer((char[])localObject);
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
        byte[] arrayOfByte = this._outputBuffer;
        paramInt1 = this._outputTail;
        this._outputTail = (paramInt1 + 1);
        arrayOfByte[paramInt1] = 92;
        arrayOfByte = this._outputBuffer;
        paramInt1 = this._outputTail;
        this._outputTail = (paramInt1 + 1);
        arrayOfByte[paramInt1] = 110;
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
  
  protected final void _writeFieldName(String paramString)
  {
    if (!isEnabled(JsonGenerator.Feature.QUOTE_FIELD_NAMES))
    {
      _writeStringSegments(paramString);
      return;
    }
    if (this._outputTail >= this._outputEnd) {
      _flushBuffer();
    }
    byte[] arrayOfByte = this._outputBuffer;
    int i = this._outputTail;
    this._outputTail = (i + 1);
    arrayOfByte[i] = 34;
    i = paramString.length();
    if (i <= this._charBufferLength)
    {
      paramString.getChars(0, i, this._charBuffer, 0);
      if (i <= this._outputMaxContiguous)
      {
        if (this._outputTail + i > this._outputEnd) {
          _flushBuffer();
        }
        _writeStringSegment(this._charBuffer, 0, i);
      }
    }
    for (;;)
    {
      if (this._outputTail >= this._outputEnd) {
        _flushBuffer();
      }
      paramString = this._outputBuffer;
      i = this._outputTail;
      this._outputTail = (i + 1);
      paramString[i] = 34;
      return;
      _writeStringSegments(this._charBuffer, 0, i);
      continue;
      _writeStringSegments(paramString);
    }
  }
  
  protected final void _writeFieldName(SerializableString paramSerializableString)
  {
    paramSerializableString = paramSerializableString.asQuotedUTF8();
    if (!isEnabled(JsonGenerator.Feature.QUOTE_FIELD_NAMES))
    {
      _writeBytes(paramSerializableString);
      return;
    }
    if (this._outputTail >= this._outputEnd) {
      _flushBuffer();
    }
    byte[] arrayOfByte = this._outputBuffer;
    int i = this._outputTail;
    this._outputTail = (i + 1);
    arrayOfByte[i] = 34;
    i = paramSerializableString.length;
    if (this._outputTail + i + 1 < this._outputEnd)
    {
      System.arraycopy(paramSerializableString, 0, this._outputBuffer, this._outputTail, i);
      this._outputTail += i;
      paramSerializableString = this._outputBuffer;
      i = this._outputTail;
      this._outputTail = (i + 1);
      paramSerializableString[i] = 34;
      return;
    }
    _writeBytes(paramSerializableString);
    if (this._outputTail >= this._outputEnd) {
      _flushBuffer();
    }
    paramSerializableString = this._outputBuffer;
    i = this._outputTail;
    this._outputTail = (i + 1);
    paramSerializableString[i] = 34;
  }
  
  protected final void _writePPFieldName(String paramString, boolean paramBoolean)
  {
    int i;
    if (paramBoolean)
    {
      this._cfgPrettyPrinter.writeObjectEntrySeparator(this);
      if (!isEnabled(JsonGenerator.Feature.QUOTE_FIELD_NAMES)) {
        break label194;
      }
      if (this._outputTail >= this._outputEnd) {
        _flushBuffer();
      }
      byte[] arrayOfByte = this._outputBuffer;
      i = this._outputTail;
      this._outputTail = (i + 1);
      arrayOfByte[i] = 34;
      i = paramString.length();
      if (i > this._charBufferLength) {
        break label186;
      }
      paramString.getChars(0, i, this._charBuffer, 0);
      if (i > this._outputMaxContiguous) {
        break label173;
      }
      if (this._outputTail + i > this._outputEnd) {
        _flushBuffer();
      }
      _writeStringSegment(this._charBuffer, 0, i);
    }
    for (;;)
    {
      if (this._outputTail >= this._outputEnd) {
        _flushBuffer();
      }
      paramString = this._outputBuffer;
      i = this._outputTail;
      this._outputTail = (i + 1);
      paramString[i] = 34;
      return;
      this._cfgPrettyPrinter.beforeObjectEntries(this);
      break;
      label173:
      _writeStringSegments(this._charBuffer, 0, i);
      continue;
      label186:
      _writeStringSegments(paramString);
    }
    label194:
    _writeStringSegments(paramString);
  }
  
  protected final void _writePPFieldName(SerializableString paramSerializableString, boolean paramBoolean)
  {
    if (paramBoolean) {
      this._cfgPrettyPrinter.writeObjectEntrySeparator(this);
    }
    for (;;)
    {
      paramBoolean = isEnabled(JsonGenerator.Feature.QUOTE_FIELD_NAMES);
      int i;
      if (paramBoolean)
      {
        if (this._outputTail >= this._outputEnd) {
          _flushBuffer();
        }
        byte[] arrayOfByte = this._outputBuffer;
        i = this._outputTail;
        this._outputTail = (i + 1);
        arrayOfByte[i] = 34;
      }
      _writeBytes(paramSerializableString.asQuotedUTF8());
      if (paramBoolean)
      {
        if (this._outputTail >= this._outputEnd) {
          _flushBuffer();
        }
        paramSerializableString = this._outputBuffer;
        i = this._outputTail;
        this._outputTail = (i + 1);
        paramSerializableString[i] = 34;
      }
      return;
      this._cfgPrettyPrinter.beforeObjectEntries(this);
    }
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
    if (this._outputStream != null)
    {
      if ((!this._ioContext.isResourceManaged()) && (!isEnabled(JsonGenerator.Feature.AUTO_CLOSE_TARGET))) {
        break label97;
      }
      this._outputStream.close();
    }
    for (;;)
    {
      _releaseBuffers();
      return;
      label97:
      if (isEnabled(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM)) {
        this._outputStream.flush();
      }
    }
  }
  
  public final void flush()
  {
    _flushBuffer();
    if ((this._outputStream != null) && (isEnabled(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM))) {
      this._outputStream.flush();
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
    return this._outputStream;
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
    byte[] arrayOfByte = this._outputBuffer;
    int i = this._outputTail;
    this._outputTail = (i + 1);
    arrayOfByte[i] = 34;
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
    if (paramBoolean) {}
    for (byte[] arrayOfByte = TRUE_BYTES;; arrayOfByte = FALSE_BYTES)
    {
      int i = arrayOfByte.length;
      System.arraycopy(arrayOfByte, 0, this._outputBuffer, this._outputTail, i);
      this._outputTail += i;
      return;
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
      byte[] arrayOfByte = this._outputBuffer;
      int i = this._outputTail;
      this._outputTail = (i + 1);
      arrayOfByte[i] = 93;
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
    byte[] arrayOfByte = this._outputBuffer;
    int i = this._outputTail;
    this._outputTail = (i + 1);
    arrayOfByte[i] = 125;
  }
  
  public final void writeFieldName(String paramString)
  {
    boolean bool = true;
    int i = this._writeContext.writeFieldName(paramString);
    if (i == 4) {
      _reportError("Can not write a field name, expecting a value");
    }
    if (this._cfgPrettyPrinter != null)
    {
      if (i == 1) {}
      for (;;)
      {
        _writePPFieldName(paramString, bool);
        return;
        bool = false;
      }
    }
    if (i == 1)
    {
      if (this._outputTail >= this._outputEnd) {
        _flushBuffer();
      }
      byte[] arrayOfByte = this._outputBuffer;
      i = this._outputTail;
      this._outputTail = (i + 1);
      arrayOfByte[i] = 44;
    }
    _writeFieldName(paramString);
  }
  
  public final void writeFieldName(SerializableString paramSerializableString)
  {
    boolean bool = true;
    int i = this._writeContext.writeFieldName(paramSerializableString.getValue());
    if (i == 4) {
      _reportError("Can not write a field name, expecting a value");
    }
    if (this._cfgPrettyPrinter != null)
    {
      if (i == 1) {}
      for (;;)
      {
        _writePPFieldName(paramSerializableString, bool);
        return;
        bool = false;
      }
    }
    if (i == 1)
    {
      if (this._outputTail >= this._outputEnd) {
        _flushBuffer();
      }
      byte[] arrayOfByte = this._outputBuffer;
      i = this._outputTail;
      this._outputTail = (i + 1);
      arrayOfByte[i] = 44;
    }
    _writeFieldName(paramSerializableString);
  }
  
  public final void writeFieldName(SerializedString paramSerializedString)
  {
    boolean bool = true;
    int i = this._writeContext.writeFieldName(paramSerializedString.getValue());
    if (i == 4) {
      _reportError("Can not write a field name, expecting a value");
    }
    if (this._cfgPrettyPrinter != null)
    {
      if (i == 1) {}
      for (;;)
      {
        _writePPFieldName(paramSerializedString, bool);
        return;
        bool = false;
      }
    }
    if (i == 1)
    {
      if (this._outputTail >= this._outputEnd) {
        _flushBuffer();
      }
      byte[] arrayOfByte = this._outputBuffer;
      i = this._outputTail;
      this._outputTail = (i + 1);
      arrayOfByte[i] = 44;
    }
    _writeFieldName(paramSerializedString);
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
    if (this._outputTail + 11 >= this._outputEnd) {
      _flushBuffer();
    }
    if (this._cfgNumbersAsStrings)
    {
      _writeQuotedInt(paramInt);
      return;
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
    if (this._outputTail + 3 >= this._outputEnd) {
      _flushBuffer();
    }
    byte[] arrayOfByte = this._outputBuffer;
    int i;
    if (paramChar <= '')
    {
      i = this._outputTail;
      this._outputTail = (i + 1);
      arrayOfByte[i] = ((byte)paramChar);
      return;
    }
    if (paramChar < 'ࠀ')
    {
      i = this._outputTail;
      this._outputTail = (i + 1);
      arrayOfByte[i] = ((byte)(paramChar >> '\006' | 0xC0));
      i = this._outputTail;
      this._outputTail = (i + 1);
      arrayOfByte[i] = ((byte)(paramChar & 0x3F | 0x80));
      return;
    }
    _outputRawMultiByteChar(paramChar, null, 0, 0);
  }
  
  public void writeRaw(String paramString)
  {
    int i = paramString.length();
    int j = 0;
    while (i > 0)
    {
      char[] arrayOfChar = this._charBuffer;
      int m = arrayOfChar.length;
      int k = m;
      if (i < m) {
        k = i;
      }
      paramString.getChars(j, j + k, arrayOfChar, 0);
      writeRaw(arrayOfChar, 0, k);
      j += k;
      i -= k;
    }
  }
  
  public void writeRaw(String paramString, int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    paramInt2 = paramInt1;
    paramInt1 = i;
    while (paramInt1 > 0)
    {
      char[] arrayOfChar = this._charBuffer;
      int j = arrayOfChar.length;
      i = j;
      if (paramInt1 < j) {
        i = paramInt1;
      }
      paramString.getChars(paramInt2, paramInt2 + i, arrayOfChar, 0);
      writeRaw(arrayOfChar, 0, i);
      paramInt2 += i;
      paramInt1 -= i;
    }
  }
  
  public final void writeRaw(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int i = paramInt2 + paramInt2 + paramInt2;
    if (this._outputTail + i > this._outputEnd)
    {
      if (this._outputEnd < i)
      {
        _writeSegmentedRaw(paramArrayOfChar, paramInt1, paramInt2);
        return;
      }
      _flushBuffer();
    }
    i = paramInt2 + paramInt1;
    label47:
    label53:
    byte[] arrayOfByte;
    int j;
    if (paramInt1 < i)
    {
      paramInt2 = paramArrayOfChar[paramInt1];
      if (paramInt2 <= 127) {
        break label151;
      }
      paramInt2 = paramInt1 + 1;
      paramInt1 = paramArrayOfChar[paramInt1];
      if (paramInt1 >= 2048) {
        break label191;
      }
      arrayOfByte = this._outputBuffer;
      j = this._outputTail;
      this._outputTail = (j + 1);
      arrayOfByte[j] = ((byte)(paramInt1 >> 6 | 0xC0));
      arrayOfByte = this._outputBuffer;
      j = this._outputTail;
      this._outputTail = (j + 1);
      arrayOfByte[j] = ((byte)(paramInt1 & 0x3F | 0x80));
    }
    for (;;)
    {
      paramInt1 = paramInt2;
      break label47;
      break;
      label151:
      arrayOfByte = this._outputBuffer;
      j = this._outputTail;
      this._outputTail = (j + 1);
      arrayOfByte[j] = ((byte)paramInt2);
      paramInt2 = paramInt1 + 1;
      paramInt1 = paramInt2;
      if (paramInt2 < i) {
        break label53;
      }
      return;
      label191:
      _outputRawMultiByteChar(paramInt1, paramArrayOfChar, paramInt2, i);
    }
  }
  
  public void writeRawUTF8String(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    _verifyValueWrite("write text value");
    if (this._outputTail >= this._outputEnd) {
      _flushBuffer();
    }
    byte[] arrayOfByte = this._outputBuffer;
    int i = this._outputTail;
    this._outputTail = (i + 1);
    arrayOfByte[i] = 34;
    _writeBytes(paramArrayOfByte, paramInt1, paramInt2);
    if (this._outputTail >= this._outputEnd) {
      _flushBuffer();
    }
    paramArrayOfByte = this._outputBuffer;
    paramInt1 = this._outputTail;
    this._outputTail = (paramInt1 + 1);
    paramArrayOfByte[paramInt1] = 34;
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
    byte[] arrayOfByte = this._outputBuffer;
    int i = this._outputTail;
    this._outputTail = (i + 1);
    arrayOfByte[i] = 91;
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
    byte[] arrayOfByte = this._outputBuffer;
    int i = this._outputTail;
    this._outputTail = (i + 1);
    arrayOfByte[i] = 123;
  }
  
  public void writeString(String paramString)
  {
    _verifyValueWrite("write text value");
    if (paramString == null)
    {
      _writeNull();
      return;
    }
    int i = paramString.length();
    if (i > this._charBufferLength)
    {
      _writeLongString(paramString);
      return;
    }
    paramString.getChars(0, i, this._charBuffer, 0);
    if (i > this._outputMaxContiguous)
    {
      _writeLongString(this._charBuffer, 0, i);
      return;
    }
    if (this._outputTail + i >= this._outputEnd) {
      _flushBuffer();
    }
    paramString = this._outputBuffer;
    int j = this._outputTail;
    this._outputTail = (j + 1);
    paramString[j] = 34;
    _writeStringSegment(this._charBuffer, 0, i);
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
    byte[] arrayOfByte = this._outputBuffer;
    int i = this._outputTail;
    this._outputTail = (i + 1);
    arrayOfByte[i] = 34;
    _writeBytes(paramSerializableString.asQuotedUTF8());
    if (this._outputTail >= this._outputEnd) {
      _flushBuffer();
    }
    paramSerializableString = this._outputBuffer;
    i = this._outputTail;
    this._outputTail = (i + 1);
    paramSerializableString[i] = 34;
  }
  
  public void writeString(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    _verifyValueWrite("write text value");
    if (this._outputTail >= this._outputEnd) {
      _flushBuffer();
    }
    byte[] arrayOfByte = this._outputBuffer;
    int i = this._outputTail;
    this._outputTail = (i + 1);
    arrayOfByte[i] = 34;
    if (paramInt2 <= this._outputMaxContiguous)
    {
      if (this._outputTail + paramInt2 > this._outputEnd) {
        _flushBuffer();
      }
      _writeStringSegment(paramArrayOfChar, paramInt1, paramInt2);
    }
    for (;;)
    {
      if (this._outputTail >= this._outputEnd) {
        _flushBuffer();
      }
      paramArrayOfChar = this._outputBuffer;
      paramInt1 = this._outputTail;
      this._outputTail = (paramInt1 + 1);
      paramArrayOfChar[paramInt1] = '"';
      return;
      _writeStringSegments(paramArrayOfChar, paramInt1, paramInt2);
    }
  }
  
  public final void writeStringField(String paramString1, String paramString2)
  {
    writeFieldName(paramString1);
    writeString(paramString2);
  }
  
  public void writeUTF8String(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    _verifyValueWrite("write text value");
    if (this._outputTail >= this._outputEnd) {
      _flushBuffer();
    }
    byte[] arrayOfByte = this._outputBuffer;
    int i = this._outputTail;
    this._outputTail = (i + 1);
    arrayOfByte[i] = 34;
    if (paramInt2 <= this._outputMaxContiguous) {
      _writeUTF8Segment(paramArrayOfByte, paramInt1, paramInt2);
    }
    for (;;)
    {
      if (this._outputTail >= this._outputEnd) {
        _flushBuffer();
      }
      paramArrayOfByte = this._outputBuffer;
      paramInt1 = this._outputTail;
      this._outputTail = (paramInt1 + 1);
      paramArrayOfByte[paramInt1] = 34;
      return;
      _writeUTF8Segments(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/impl/Utf8Generator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */