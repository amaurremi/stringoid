package com.flurry.org.codehaus.jackson.io;

import com.flurry.org.codehaus.jackson.util.ByteArrayBuilder;
import com.flurry.org.codehaus.jackson.util.CharTypes;
import com.flurry.org.codehaus.jackson.util.TextBuffer;
import java.lang.ref.SoftReference;

public final class JsonStringEncoder
{
  private static final byte[] HEX_BYTES = CharTypes.copyHexBytes();
  private static final char[] HEX_CHARS = ;
  private static final int INT_0 = 48;
  private static final int INT_BACKSLASH = 92;
  private static final int INT_U = 117;
  private static final int SURR1_FIRST = 55296;
  private static final int SURR1_LAST = 56319;
  private static final int SURR2_FIRST = 56320;
  private static final int SURR2_LAST = 57343;
  protected static final ThreadLocal<SoftReference<JsonStringEncoder>> _threadEncoder = new ThreadLocal();
  protected ByteArrayBuilder _byteBuilder;
  protected final char[] _quoteBuffer = new char[6];
  protected TextBuffer _textBuffer;
  
  public JsonStringEncoder()
  {
    this._quoteBuffer[0] = '\\';
    this._quoteBuffer[2] = '0';
    this._quoteBuffer[3] = '0';
  }
  
  private int _appendByteEscape(int paramInt1, int paramInt2, ByteArrayBuilder paramByteArrayBuilder, int paramInt3)
  {
    paramByteArrayBuilder.setCurrentSegmentLength(paramInt3);
    paramByteArrayBuilder.append(92);
    if (paramInt2 < 0)
    {
      paramByteArrayBuilder.append(117);
      if (paramInt1 > 255)
      {
        paramInt2 = paramInt1 >> 8;
        paramByteArrayBuilder.append(HEX_BYTES[(paramInt2 >> 4)]);
        paramByteArrayBuilder.append(HEX_BYTES[(paramInt2 & 0xF)]);
        paramInt1 &= 0xFF;
        paramByteArrayBuilder.append(HEX_BYTES[(paramInt1 >> 4)]);
        paramByteArrayBuilder.append(HEX_BYTES[(paramInt1 & 0xF)]);
      }
    }
    for (;;)
    {
      return paramByteArrayBuilder.getCurrentSegmentLength();
      paramByteArrayBuilder.append(48);
      paramByteArrayBuilder.append(48);
      break;
      paramByteArrayBuilder.append((byte)paramInt2);
    }
  }
  
  private int _appendSingleEscape(int paramInt, char[] paramArrayOfChar)
  {
    if (paramInt < 0)
    {
      paramInt = -(paramInt + 1);
      paramArrayOfChar[1] = 'u';
      paramArrayOfChar[4] = HEX_CHARS[(paramInt >> 4)];
      paramArrayOfChar[5] = HEX_CHARS[(paramInt & 0xF)];
      return 6;
    }
    paramArrayOfChar[1] = ((char)paramInt);
    return 2;
  }
  
  private int _convertSurrogate(int paramInt1, int paramInt2)
  {
    if ((paramInt2 < 56320) || (paramInt2 > 57343)) {
      throw new IllegalArgumentException("Broken surrogate pair: first char 0x" + Integer.toHexString(paramInt1) + ", second 0x" + Integer.toHexString(paramInt2) + "; illegal combination");
    }
    return 65536 + (paramInt1 - 55296 << 10) + (paramInt2 - 56320);
  }
  
  private void _throwIllegalSurrogate(int paramInt)
  {
    if (paramInt > 1114111) {
      throw new IllegalArgumentException("Illegal character point (0x" + Integer.toHexString(paramInt) + ") to output; max is 0x10FFFF as per RFC 4627");
    }
    if (paramInt >= 55296)
    {
      if (paramInt <= 56319) {
        throw new IllegalArgumentException("Unmatched first part of surrogate pair (0x" + Integer.toHexString(paramInt) + ")");
      }
      throw new IllegalArgumentException("Unmatched second part of surrogate pair (0x" + Integer.toHexString(paramInt) + ")");
    }
    throw new IllegalArgumentException("Illegal character point (0x" + Integer.toHexString(paramInt) + ") to output");
  }
  
  public static JsonStringEncoder getInstance()
  {
    Object localObject1 = (SoftReference)_threadEncoder.get();
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = (JsonStringEncoder)((SoftReference)localObject1).get())
    {
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = new JsonStringEncoder();
        _threadEncoder.set(new SoftReference(localObject2));
      }
      return (JsonStringEncoder)localObject2;
    }
  }
  
  public byte[] encodeAsUTF8(String paramString)
  {
    Object localObject1 = this._byteBuilder;
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = new ByteArrayBuilder(null);
      this._byteBuilder = ((ByteArrayBuilder)localObject2);
    }
    int i2 = paramString.length();
    int i = 0;
    localObject1 = ((ByteArrayBuilder)localObject2).resetAndGetFirstSegment();
    int k = localObject1.length;
    int j = 0;
    int m;
    label70:
    int n;
    int i1;
    if (j < i2)
    {
      m = paramString.charAt(j);
      j += 1;
      if (m <= 127)
      {
        n = k;
        i1 = i;
        if (i >= k)
        {
          localObject1 = ((ByteArrayBuilder)localObject2).finishCurrentSegment();
          n = localObject1.length;
          i1 = 0;
        }
        i = i1 + 1;
        localObject1[i1] = ((byte)m);
        if (j < i2) {}
      }
    }
    for (;;)
    {
      return this._byteBuilder.completeAndCoalesce(i);
      m = paramString.charAt(j);
      j += 1;
      k = n;
      break label70;
      if (i >= k)
      {
        localObject1 = ((ByteArrayBuilder)localObject2).finishCurrentSegment();
        i = localObject1.length;
      }
      for (k = 0;; k = n)
      {
        if (m < 2048)
        {
          i1 = k + 1;
          localObject1[k] = ((byte)(m >> 6 | 0xC0));
          n = j;
          k = i1;
          j = i;
          i = n;
          n = m;
        }
        for (;;)
        {
          m = j;
          i1 = k;
          if (k >= j)
          {
            localObject1 = ((ByteArrayBuilder)localObject2).finishCurrentSegment();
            m = localObject1.length;
            i1 = 0;
          }
          localObject1[i1] = ((byte)(n & 0x3F | 0x80));
          n = i1 + 1;
          j = i;
          k = m;
          i = n;
          break;
          if ((m >= 55296) && (m <= 57343)) {
            break label380;
          }
          i1 = k + 1;
          localObject1[k] = ((byte)(m >> 12 | 0xE0));
          k = i;
          n = i1;
          if (i1 >= i)
          {
            localObject1 = ((ByteArrayBuilder)localObject2).finishCurrentSegment();
            k = localObject1.length;
            n = 0;
          }
          localObject1[n] = ((byte)(m >> 6 & 0x3F | 0x80));
          i1 = n + 1;
          i = j;
          n = m;
          j = k;
          k = i1;
        }
        label380:
        if (m > 56319) {
          _throwIllegalSurrogate(m);
        }
        if (j >= i2) {
          _throwIllegalSurrogate(m);
        }
        i1 = j + 1;
        n = _convertSurrogate(m, paramString.charAt(j));
        if (n > 1114111) {
          _throwIllegalSurrogate(n);
        }
        m = k + 1;
        localObject1[k] = ((byte)(n >> 18 | 0xF0));
        j = i;
        k = m;
        if (m >= i)
        {
          localObject1 = ((ByteArrayBuilder)localObject2).finishCurrentSegment();
          j = localObject1.length;
          k = 0;
        }
        i = k + 1;
        localObject1[k] = ((byte)(n >> 12 & 0x3F | 0x80));
        if (i >= j)
        {
          localObject1 = ((ByteArrayBuilder)localObject2).finishCurrentSegment();
          j = localObject1.length;
          i = 0;
        }
        for (;;)
        {
          localObject1[i] = ((byte)(n >> 6 & 0x3F | 0x80));
          k = i + 1;
          i = i1;
          break;
        }
        n = i;
        i = k;
      }
    }
  }
  
  public char[] quoteAsString(String paramString)
  {
    Object localObject1 = this._textBuffer;
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = new TextBuffer(null);
      this._textBuffer = ((TextBuffer)localObject2);
    }
    localObject1 = ((TextBuffer)localObject2).emptyAndGetCurrentSegment();
    int[] arrayOfInt = CharTypes.get7BitOutputEscapes();
    int n = arrayOfInt.length;
    int k = 0;
    int i1 = paramString.length();
    int j = 0;
    int m = j;
    label69:
    int i;
    int i2;
    if (k < i1)
    {
      i = paramString.charAt(k);
      if ((i < n) && (arrayOfInt[i] != 0))
      {
        i2 = _appendSingleEscape(arrayOfInt[paramString.charAt(k)], this._quoteBuffer);
        if (j + i2 <= localObject1.length) {
          break label256;
        }
        m = localObject1.length - j;
        if (m > 0) {
          System.arraycopy(this._quoteBuffer, 0, localObject1, j, m);
        }
        localObject1 = ((TextBuffer)localObject2).finishCurrentSegment();
        i2 -= m;
        System.arraycopy(this._quoteBuffer, m, localObject1, j, i2);
        j += i2;
      }
    }
    for (;;)
    {
      k += 1;
      break;
      m = j;
      Object localObject3 = localObject1;
      if (j >= localObject1.length)
      {
        localObject3 = ((TextBuffer)localObject2).finishCurrentSegment();
        m = 0;
      }
      j = m + 1;
      localObject3[m] = i;
      k += 1;
      if (k >= i1)
      {
        m = j;
        ((TextBuffer)localObject2).setCurrentLength(m);
        return ((TextBuffer)localObject2).contentsAsArray();
      }
      localObject1 = localObject3;
      break label69;
      label256:
      System.arraycopy(this._quoteBuffer, 0, localObject1, j, i2);
      j += i2;
    }
  }
  
  public byte[] quoteAsUTF8(String paramString)
  {
    Object localObject1 = this._byteBuilder;
    Object localObject3 = localObject1;
    if (localObject1 == null)
    {
      localObject3 = new ByteArrayBuilder(null);
      this._byteBuilder = ((ByteArrayBuilder)localObject3);
    }
    int j = 0;
    int n = paramString.length();
    int i = 0;
    localObject1 = ((ByteArrayBuilder)localObject3).resetAndGetFirstSegment();
    int k;
    int m;
    for (;;)
    {
      k = i;
      int[] arrayOfInt;
      if (j < n) {
        arrayOfInt = CharTypes.get7BitOutputEscapes();
      }
      for (Object localObject2 = localObject1;; localObject2 = localObject1)
      {
        m = paramString.charAt(j);
        if ((m > 127) || (arrayOfInt[m] != 0))
        {
          localObject1 = localObject2;
          k = i;
          if (i >= localObject2.length)
          {
            localObject1 = ((ByteArrayBuilder)localObject3).finishCurrentSegment();
            k = 0;
          }
          i = j + 1;
          m = paramString.charAt(j);
          if (m > 127) {
            break label229;
          }
          k = _appendByteEscape(m, arrayOfInt[m], (ByteArrayBuilder)localObject3, k);
          localObject1 = ((ByteArrayBuilder)localObject3).getCurrentSegment();
          j = i;
          i = k;
          break;
        }
        localObject1 = localObject2;
        k = i;
        if (i >= localObject2.length)
        {
          localObject1 = ((ByteArrayBuilder)localObject3).finishCurrentSegment();
          k = 0;
        }
        i = k + 1;
        localObject1[k] = ((byte)m);
        j += 1;
        if (j >= n)
        {
          k = i;
          return this._byteBuilder.completeAndCoalesce(k);
        }
      }
      label229:
      if (m > 2047) {
        break;
      }
      localObject1[k] = ((byte)(m >> 6 | 0xC0));
      m = m & 0x3F | 0x80;
      j = k + 1;
      k = m;
      localObject2 = localObject1;
      m = j;
      if (j >= localObject1.length)
      {
        localObject2 = ((ByteArrayBuilder)localObject3).finishCurrentSegment();
        m = 0;
      }
      localObject2[m] = ((byte)k);
      k = m + 1;
      j = i;
      localObject1 = localObject2;
      i = k;
    }
    if ((m < 55296) || (m > 57343))
    {
      j = k + 1;
      localObject1[k] = ((byte)(m >> 12 | 0xE0));
      if (j < localObject1.length) {
        break label587;
      }
      localObject1 = ((ByteArrayBuilder)localObject3).finishCurrentSegment();
      j = 0;
    }
    label587:
    for (;;)
    {
      localObject1[j] = ((byte)(m >> 6 & 0x3F | 0x80));
      k = m & 0x3F | 0x80;
      j += 1;
      break;
      if (m > 56319) {
        _throwIllegalSurrogate(m);
      }
      if (i >= n) {
        _throwIllegalSurrogate(m);
      }
      j = i + 1;
      m = _convertSurrogate(m, paramString.charAt(i));
      if (m > 1114111) {
        _throwIllegalSurrogate(m);
      }
      i = k + 1;
      localObject1[k] = ((byte)(m >> 18 | 0xF0));
      if (i >= localObject1.length)
      {
        localObject1 = ((ByteArrayBuilder)localObject3).finishCurrentSegment();
        i = 0;
      }
      for (;;)
      {
        k = i + 1;
        localObject1[i] = ((byte)(m >> 12 & 0x3F | 0x80));
        if (k >= localObject1.length) {
          localObject1 = ((ByteArrayBuilder)localObject3).finishCurrentSegment();
        }
        for (i = 0;; i = k)
        {
          localObject1[i] = ((byte)(m >> 6 & 0x3F | 0x80));
          k = m & 0x3F | 0x80;
          m = i + 1;
          i = j;
          j = m;
          break;
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/io/JsonStringEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */