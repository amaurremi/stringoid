package com.fasterxml.jackson.core.io;

import java.io.CharConversionException;
import java.io.InputStream;

public final class UTF32Reader
  extends BaseReader
{
  final boolean mBigEndian;
  int mByteCount = 0;
  int mCharCount = 0;
  char mSurrogate = '\000';
  
  public UTF32Reader(IOContext paramIOContext, InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramIOContext, paramInputStream, paramArrayOfByte, paramInt1, paramInt2);
    this.mBigEndian = paramBoolean;
  }
  
  private boolean loadMore(int paramInt)
  {
    this.mByteCount += this._length - paramInt;
    if (paramInt > 0)
    {
      if (this._ptr > 0)
      {
        int i = 0;
        while (i < paramInt)
        {
          this._buffer[i] = this._buffer[(this._ptr + i)];
          i += 1;
        }
        this._ptr = 0;
      }
      this._length = paramInt;
    }
    while (this._length < 4)
    {
      paramInt = this._in.read(this._buffer, this._length, this._buffer.length - this._length);
      if (paramInt < 1)
      {
        if (paramInt < 0)
        {
          freeBuffers();
          reportUnexpectedEOF(this._length, 4);
        }
        reportStrangeStream();
      }
      this._length = (paramInt + this._length);
      continue;
      this._ptr = 0;
      paramInt = this._in.read(this._buffer);
      if (paramInt < 1)
      {
        this._length = 0;
        if (paramInt < 0)
        {
          freeBuffers();
          return false;
        }
        reportStrangeStream();
      }
      this._length = paramInt;
    }
    return true;
  }
  
  private void reportInvalid(int paramInt1, int paramInt2, String paramString)
  {
    int i = this.mByteCount;
    int j = this._ptr;
    int k = this.mCharCount;
    throw new CharConversionException("Invalid UTF-32 character 0x" + Integer.toHexString(paramInt1) + paramString + " at char #" + (k + paramInt2) + ", byte #" + (i + j - 1) + ")");
  }
  
  private void reportUnexpectedEOF(int paramInt1, int paramInt2)
  {
    int i = this.mByteCount;
    int j = this.mCharCount;
    throw new CharConversionException("Unexpected EOF in the middle of a 4-byte UTF-32 char: got " + paramInt1 + ", needed " + paramInt2 + ", at char #" + j + ", byte #" + (i + paramInt1) + ")");
  }
  
  public int read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int i;
    if (this._buffer == null) {
      i = -1;
    }
    do
    {
      return i;
      i = paramInt2;
    } while (paramInt2 < 1);
    if ((paramInt1 < 0) || (paramInt1 + paramInt2 > paramArrayOfChar.length)) {
      reportBounds(paramArrayOfChar, paramInt1, paramInt2);
    }
    int m = paramInt2 + paramInt1;
    if (this.mSurrogate != 0)
    {
      paramInt2 = paramInt1 + 1;
      paramArrayOfChar[paramInt1] = this.mSurrogate;
      this.mSurrogate = '\000';
    }
    for (;;)
    {
      int j;
      int k;
      int n;
      if (paramInt2 < m)
      {
        i = this._ptr;
        if (this.mBigEndian)
        {
          j = this._buffer[i];
          k = this._buffer[(i + 1)];
          n = this._buffer[(i + 2)];
          i = this._buffer[(i + 3)] & 0xFF | j << 24 | (k & 0xFF) << 16 | (n & 0xFF) << 8;
          label159:
          this._ptr += 4;
          if (i <= 65535) {
            break label395;
          }
          if (i > 1114111) {
            reportInvalid(i, paramInt2 - paramInt1, "(above " + Integer.toHexString(1114111) + ") ");
          }
          j = i - 65536;
          i = paramInt2 + 1;
          paramArrayOfChar[paramInt2] = ((char)(55296 + (j >> 10)));
          k = j & 0x3FF | 0xDC00;
          j = k;
          paramInt2 = i;
          if (i < m) {
            break label399;
          }
          this.mSurrogate = ((char)k);
          paramInt2 = i;
        }
      }
      for (;;)
      {
        paramInt1 = paramInt2 - paramInt1;
        this.mCharCount += paramInt1;
        return paramInt1;
        paramInt2 = this._length - this._ptr;
        if ((paramInt2 >= 4) || (loadMore(paramInt2))) {
          break label433;
        }
        return -1;
        j = this._buffer[i];
        k = this._buffer[(i + 1)];
        n = this._buffer[(i + 2)];
        i = this._buffer[(i + 3)] << 24 | j & 0xFF | (k & 0xFF) << 8 | (n & 0xFF) << 16;
        break label159;
        label395:
        j = i;
        label399:
        i = paramInt2 + 1;
        paramArrayOfChar[paramInt2] = ((char)j);
        paramInt2 = i;
        if (this._ptr < this._length) {
          break;
        }
        paramInt2 = i;
      }
      label433:
      paramInt2 = paramInt1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/core/io/UTF32Reader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */