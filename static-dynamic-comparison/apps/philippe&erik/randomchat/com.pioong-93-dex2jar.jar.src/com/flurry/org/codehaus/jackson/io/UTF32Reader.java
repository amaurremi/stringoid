package com.flurry.org.codehaus.jackson.io;

import java.io.CharConversionException;
import java.io.IOException;
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
    throws IOException
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
      this._length += paramInt;
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
    throws IOException
  {
    int i = this.mByteCount;
    int j = this._ptr;
    int k = this.mCharCount;
    throw new CharConversionException("Invalid UTF-32 character 0x" + Integer.toHexString(paramInt1) + paramString + " at char #" + (k + paramInt2) + ", byte #" + (i + j - 1) + ")");
  }
  
  private void reportUnexpectedEOF(int paramInt1, int paramInt2)
    throws IOException
  {
    int i = this.mByteCount;
    int j = this.mCharCount;
    throw new CharConversionException("Unexpected EOF in the middle of a 4-byte UTF-32 char: got " + paramInt1 + ", needed " + paramInt2 + ", at char #" + j + ", byte #" + (i + paramInt1) + ")");
  }
  
  public int read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this._buffer == null) {
      return -1;
    }
    if (paramInt2 < 1) {
      return paramInt2;
    }
    if ((paramInt1 < 0) || (paramInt1 + paramInt2 > paramArrayOfChar.length)) {
      reportBounds(paramArrayOfChar, paramInt1, paramInt2);
    }
    int m = paramInt2 + paramInt1;
    label63:
    int i;
    label142:
    int j;
    if (this.mSurrogate != 0)
    {
      paramInt2 = paramInt1 + 1;
      paramArrayOfChar[paramInt1] = this.mSurrogate;
      this.mSurrogate = '\000';
      if (paramInt2 >= m) {
        break label404;
      }
      i = this._ptr;
      if (!this.mBigEndian) {
        break label306;
      }
      i = this._buffer[i] << 24 | (this._buffer[(i + 1)] & 0xFF) << 16 | (this._buffer[(i + 2)] & 0xFF) << 8 | this._buffer[(i + 3)] & 0xFF;
      this._ptr += 4;
      if (i <= 65535) {
        break label369;
      }
      if (i > 1114111) {
        reportInvalid(i, paramInt2 - paramInt1, "(above " + Integer.toHexString(1114111) + ") ");
      }
      j = i - 65536;
      i = paramInt2 + 1;
      paramArrayOfChar[paramInt2] = ((char)(55296 + (j >> 10)));
      int k = 0xDC00 | j & 0x3FF;
      j = k;
      paramInt2 = i;
      if (i < m) {
        break label373;
      }
      this.mSurrogate = ((char)k);
      paramInt2 = i;
    }
    label306:
    label369:
    label373:
    label404:
    for (;;)
    {
      paramInt1 = paramInt2 - paramInt1;
      this.mCharCount += paramInt1;
      return paramInt1;
      paramInt2 = this._length - this._ptr;
      if ((paramInt2 < 4) && (!loadMore(paramInt2))) {
        break;
      }
      paramInt2 = paramInt1;
      break label63;
      i = this._buffer[i] & 0xFF | (this._buffer[(i + 1)] & 0xFF) << 8 | (this._buffer[(i + 2)] & 0xFF) << 16 | this._buffer[(i + 3)] << 24;
      break label142;
      j = i;
      i = paramInt2 + 1;
      paramArrayOfChar[paramInt2] = ((char)j);
      paramInt2 = i;
      if (this._ptr < this._length) {
        break label63;
      }
      paramInt2 = i;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/io/UTF32Reader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */