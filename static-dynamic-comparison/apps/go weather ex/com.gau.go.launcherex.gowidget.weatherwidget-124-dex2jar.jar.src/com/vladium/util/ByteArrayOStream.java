package com.vladium.util;

import java.io.IOException;
import java.io.OutputStream;

public final class ByteArrayOStream
  extends OutputStream
{
  private static final int NATIVE_COPY_THRESHOLD = 9;
  private byte[] m_buf;
  private int m_pos;
  
  public ByteArrayOStream(int paramInt)
  {
    this.m_buf = new byte[paramInt];
  }
  
  public final int capacity()
  {
    return this.m_buf.length;
  }
  
  public final void close()
  {
    reset();
  }
  
  public final byte[] copyByteArray()
  {
    int j = this.m_pos;
    byte[] arrayOfByte1 = new byte[j];
    byte[] arrayOfByte2 = this.m_buf;
    if (j < 9)
    {
      int i = 0;
      while (i < j)
      {
        arrayOfByte1[i] = arrayOfByte2[i];
        i += 1;
      }
    }
    System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, j);
    return arrayOfByte1;
  }
  
  public final byte[] getByteArray()
  {
    return this.m_buf;
  }
  
  public final void reset()
  {
    this.m_pos = 0;
  }
  
  public final int size()
  {
    return this.m_pos;
  }
  
  public final ByteArrayIStream toByteIStream()
  {
    return new ByteArrayIStream(this.m_buf, this.m_pos);
  }
  
  public final void write(int paramInt)
  {
    int j = this.m_pos;
    int k = j + 1;
    byte[] arrayOfByte1 = this.m_buf;
    int i = arrayOfByte1.length;
    Object localObject = arrayOfByte1;
    if (i < k)
    {
      byte[] arrayOfByte2 = new byte[Math.max(i << 1, k)];
      if (j < 9)
      {
        i = 0;
        while (i < j)
        {
          arrayOfByte2[i] = arrayOfByte1[i];
          i += 1;
        }
      }
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, j);
      localObject = arrayOfByte2;
      this.m_buf = arrayOfByte2;
    }
    localObject[j] = ((byte)paramInt);
    this.m_pos = k;
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int j = this.m_pos;
    int k = j + paramInt2;
    byte[] arrayOfByte1 = this.m_buf;
    int i = arrayOfByte1.length;
    Object localObject = arrayOfByte1;
    if (i < k)
    {
      byte[] arrayOfByte2 = new byte[Math.max(i << 1, k)];
      if (j < 9)
      {
        i = 0;
        while (i < j)
        {
          arrayOfByte2[i] = arrayOfByte1[i];
          i += 1;
        }
      }
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, j);
      localObject = arrayOfByte2;
      this.m_buf = arrayOfByte2;
    }
    if (paramInt2 < 9)
    {
      i = 0;
      while (i < paramInt2)
      {
        localObject[(j + i)] = paramArrayOfByte[(paramInt1 + i)];
        i += 1;
      }
    }
    System.arraycopy(paramArrayOfByte, paramInt1, localObject, j, paramInt2);
    this.m_pos = k;
  }
  
  public final void write2(int paramInt1, int paramInt2)
  {
    int j = this.m_pos;
    int k = j + 2;
    byte[] arrayOfByte1 = this.m_buf;
    int i = arrayOfByte1.length;
    Object localObject = arrayOfByte1;
    if (i < k)
    {
      byte[] arrayOfByte2 = new byte[Math.max(i << 1, k)];
      if (j < 9)
      {
        i = 0;
        while (i < j)
        {
          arrayOfByte2[i] = arrayOfByte1[i];
          i += 1;
        }
      }
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, j);
      localObject = arrayOfByte2;
      this.m_buf = arrayOfByte2;
    }
    localObject[j] = ((byte)paramInt1);
    localObject[(j + 1)] = ((byte)paramInt2);
    this.m_pos = k;
  }
  
  public final void write3(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = this.m_pos;
    int k = j + 3;
    byte[] arrayOfByte1 = this.m_buf;
    int i = arrayOfByte1.length;
    Object localObject = arrayOfByte1;
    if (i < k)
    {
      byte[] arrayOfByte2 = new byte[Math.max(i << 1, k)];
      if (j < 9)
      {
        i = 0;
        while (i < j)
        {
          arrayOfByte2[i] = arrayOfByte1[i];
          i += 1;
        }
      }
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, j);
      localObject = arrayOfByte2;
      this.m_buf = arrayOfByte2;
    }
    localObject[j] = ((byte)paramInt1);
    localObject[(j + 1)] = ((byte)paramInt2);
    localObject[(j + 2)] = ((byte)paramInt3);
    this.m_pos = k;
  }
  
  public final void write4(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = this.m_pos;
    int k = j + 4;
    byte[] arrayOfByte1 = this.m_buf;
    int i = arrayOfByte1.length;
    Object localObject = arrayOfByte1;
    if (i < k)
    {
      byte[] arrayOfByte2 = new byte[Math.max(i << 1, k)];
      if (j < 9)
      {
        i = 0;
        while (i < j)
        {
          arrayOfByte2[i] = arrayOfByte1[i];
          i += 1;
        }
      }
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, j);
      localObject = arrayOfByte2;
      this.m_buf = arrayOfByte2;
    }
    localObject[j] = ((byte)paramInt1);
    localObject[(j + 1)] = ((byte)paramInt2);
    localObject[(j + 2)] = ((byte)paramInt3);
    localObject[(j + 3)] = ((byte)paramInt4);
    this.m_pos = k;
  }
  
  public final void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream.write(this.m_buf, 0, this.m_pos);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/util/ByteArrayOStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */