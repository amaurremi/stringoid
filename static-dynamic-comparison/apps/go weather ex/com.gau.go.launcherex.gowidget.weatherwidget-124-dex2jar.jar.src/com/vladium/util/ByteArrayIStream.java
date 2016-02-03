package com.vladium.util;

import java.io.InputStream;

public final class ByteArrayIStream
  extends InputStream
{
  private static final int NATIVE_COPY_THRESHOLD = 9;
  private final byte[] m_buf;
  private final int m_max;
  private int m_pos;
  
  public ByteArrayIStream(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, paramArrayOfByte.length);
  }
  
  public ByteArrayIStream(byte[] paramArrayOfByte, int paramInt)
  {
    this.m_buf = paramArrayOfByte;
    this.m_max = paramInt;
  }
  
  public final int available()
  {
    return this.m_max - this.m_pos;
  }
  
  public final void close()
  {
    reset();
  }
  
  public final int read()
  {
    if (this.m_pos >= this.m_max) {
      return -1;
    }
    byte[] arrayOfByte = this.m_buf;
    int i = this.m_pos;
    this.m_pos = (i + 1);
    return arrayOfByte[i] & 0xFF;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int j = this.m_pos;
    int k = this.m_max;
    if (j >= k) {
      return -1;
    }
    int i = paramInt2;
    if (j + paramInt2 > k) {
      i = k - j;
    }
    if (i <= 0) {
      return 0;
    }
    byte[] arrayOfByte = this.m_buf;
    if (i < 9)
    {
      paramInt2 = 0;
      while (paramInt2 < i)
      {
        paramArrayOfByte[(paramInt1 + paramInt2)] = arrayOfByte[(j + paramInt2)];
        paramInt2 += 1;
      }
    }
    System.arraycopy(arrayOfByte, j, paramArrayOfByte, paramInt1, i);
    this.m_pos += i;
    return i;
  }
  
  public final void reset()
  {
    this.m_pos = 0;
  }
  
  public final long skip(long paramLong)
  {
    long l = paramLong;
    if (this.m_pos + paramLong > this.m_max) {
      l = this.m_max - this.m_pos;
    }
    if (l < 0L) {
      return 0L;
    }
    this.m_pos = ((int)(this.m_pos + l));
    return l;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/util/ByteArrayIStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */