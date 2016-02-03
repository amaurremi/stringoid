package com.amazonaws.javax.xml.stream.xerces.impl.io;

import com.amazonaws.javax.xml.stream.util.BufferAllocator;
import com.amazonaws.javax.xml.stream.util.ThreadLocalBufferAllocator;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.Reader;

public class UCSReader
  extends Reader
{
  protected byte[] fBuffer;
  protected short fEncoding;
  protected InputStream fInputStream;
  
  public UCSReader(InputStream paramInputStream, int paramInt, short paramShort)
  {
    this.fInputStream = paramInputStream;
    this.fBuffer = ThreadLocalBufferAllocator.getBufferAllocator().getByteBuffer(paramInt);
    if (this.fBuffer == null) {
      this.fBuffer = new byte[paramInt];
    }
    this.fEncoding = paramShort;
  }
  
  public UCSReader(InputStream paramInputStream, short paramShort)
  {
    this(paramInputStream, 8192, paramShort);
  }
  
  public void close()
  {
    ThreadLocalBufferAllocator.getBufferAllocator().returnByteBuffer(this.fBuffer);
    this.fBuffer = null;
    this.fInputStream.close();
  }
  
  public void mark(int paramInt)
  {
    this.fInputStream.mark(paramInt);
  }
  
  public boolean markSupported()
  {
    return this.fInputStream.markSupported();
  }
  
  public int read()
  {
    int i = this.fInputStream.read() & 0xFF;
    if (i == 255) {}
    int j;
    int k;
    int m;
    do
    {
      do
      {
        do
        {
          return -1;
          j = this.fInputStream.read() & 0xFF;
        } while (j == 255);
        if (this.fEncoding < 4) {
          break;
        }
        k = this.fInputStream.read() & 0xFF;
      } while (k == 255);
      m = this.fInputStream.read() & 0xFF;
    } while (m == 255);
    System.err.println("b0 is " + (i & 0xFF) + " b1 " + (j & 0xFF) + " b2 " + (k & 0xFF) + " b3 " + (m & 0xFF));
    if (this.fEncoding == 8) {
      return (i << 24) + (j << 16) + (k << 8) + m;
    }
    return (m << 24) + (k << 16) + (j << 8) + i;
    if (this.fEncoding == 2) {
      return (i << 8) + j;
    }
    return (j << 8) + i;
  }
  
  public int read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int k = 1;
    int j = 0;
    if (this.fEncoding >= 4) {}
    for (int i = 2;; i = 1)
    {
      i = paramInt2 << i;
      paramInt2 = i;
      if (i > this.fBuffer.length) {
        paramInt2 = this.fBuffer.length;
      }
      i = this.fInputStream.read(this.fBuffer, 0, paramInt2);
      if (i != -1) {
        break;
      }
      return -1;
    }
    int m;
    int n;
    label187:
    int i1;
    if (this.fEncoding >= 4)
    {
      m = 4 - (i & 0x3) & 0x3;
      paramInt2 = 0;
      while (paramInt2 < m)
      {
        n = this.fInputStream.read();
        if (n == -1) {
          while (paramInt2 < m)
          {
            this.fBuffer[(i + paramInt2)] = 0;
            paramInt2 += 1;
          }
        }
        this.fBuffer[(i + paramInt2)] = ((byte)n);
        paramInt2 += 1;
      }
      paramInt2 = i + m;
      i = k;
      if (this.fEncoding >= 4) {
        i = 2;
      }
      k = paramInt2 >> i;
      i = 0;
      paramInt2 = j;
      if (i >= k) {
        break label459;
      }
      byte[] arrayOfByte = this.fBuffer;
      m = paramInt2 + 1;
      j = arrayOfByte[paramInt2] & 0xFF;
      arrayOfByte = this.fBuffer;
      paramInt2 = m + 1;
      m = arrayOfByte[m] & 0xFF;
      if (this.fEncoding < 4) {
        break label415;
      }
      arrayOfByte = this.fBuffer;
      n = paramInt2 + 1;
      i1 = arrayOfByte[paramInt2] & 0xFF;
      arrayOfByte = this.fBuffer;
      paramInt2 = n + 1;
      n = arrayOfByte[n] & 0xFF;
      if (this.fEncoding != 8) {
        break label385;
      }
      paramArrayOfChar[(paramInt1 + i)] = ((char)((j << 24) + (m << 16) + (i1 << 8) + n));
    }
    for (;;)
    {
      i += 1;
      break label187;
      paramInt2 = i;
      if ((i & 0x1) == 0) {
        break;
      }
      paramInt2 = i + 1;
      i = this.fInputStream.read();
      if (i == -1)
      {
        this.fBuffer[paramInt2] = 0;
        break;
      }
      this.fBuffer[paramInt2] = ((byte)i);
      break;
      label385:
      paramArrayOfChar[(paramInt1 + i)] = ((char)(j + ((m << 8) + ((i1 << 16) + (n << 24)))));
      continue;
      label415:
      if (this.fEncoding == 2) {
        paramArrayOfChar[(paramInt1 + i)] = ((char)((j << 8) + m));
      } else {
        paramArrayOfChar[(paramInt1 + i)] = ((char)(j + (m << 8)));
      }
    }
    label459:
    return k;
  }
  
  public boolean ready()
  {
    return false;
  }
  
  public void reset()
  {
    this.fInputStream.reset();
  }
  
  public long skip(long paramLong)
  {
    if (this.fEncoding >= 4) {}
    for (int i = 2;; i = 1)
    {
      paramLong = this.fInputStream.skip(paramLong << i);
      if (((i | 0x1) & paramLong) != 0L) {
        break;
      }
      return paramLong >> i;
    }
    return (paramLong >> i) + 1L;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/xerces/impl/io/UCSReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */