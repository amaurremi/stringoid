package com.flurry.android.monolithic.sdk.impl;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class ll
  extends lx
{
  private lp a = null;
  private byte[] b = null;
  private int c = 0;
  private int d = 0;
  private int e = 0;
  private final nw f = new nw();
  
  protected ll() {}
  
  ll(InputStream paramInputStream, int paramInt)
  {
    a(paramInputStream, paramInt);
  }
  
  ll(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    a(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  private void a(int paramInt, lp paramlp)
  {
    if (this.a != null) {
      this.a.a();
    }
    paramlp.a(paramInt, this);
    this.a = paramlp;
  }
  
  private long b(long paramLong)
    throws IOException
  {
    int i = this.b[this.d] & 0xFF;
    paramLong = (i & 0x7F) << 28 ^ paramLong;
    if (i > 127)
    {
      byte[] arrayOfByte = this.b;
      int j = this.d;
      i = 2;
      j = arrayOfByte[(1 + j)] & 0xFF;
      long l = paramLong ^ (j & 0x7F) << 35;
      paramLong = l;
      if (j > 127)
      {
        arrayOfByte = this.b;
        j = this.d;
        i = 3;
        j = arrayOfByte[(j + 2)] & 0xFF;
        l ^= (j & 0x7F) << 42;
        paramLong = l;
        if (j > 127)
        {
          arrayOfByte = this.b;
          j = this.d;
          i = 4;
          j = arrayOfByte[(j + 3)] & 0xFF;
          l ^= (j & 0x7F) << 49;
          paramLong = l;
          if (j > 127)
          {
            arrayOfByte = this.b;
            j = this.d;
            i = 5;
            j = arrayOfByte[(j + 4)] & 0xFF;
            l ^= (j & 0x7F) << 56;
            paramLong = l;
            if (j > 127)
            {
              arrayOfByte = this.b;
              j = this.d;
              i = 6;
              j = arrayOfByte[(j + 5)] & 0xFF;
              paramLong = l ^ (j & 0x7F) << 63;
              if (j > 127) {
                throw new IOException("Invalid long encoding");
              }
            }
          }
        }
      }
    }
    else
    {
      i = 1;
    }
    this.d = (i + this.d);
    return paramLong;
  }
  
  private void b(int paramInt)
    throws IOException
  {
    int i = this.e - this.d;
    if (i < paramInt) {
      this.a.a(this.b, this.d, this.c, i);
    }
  }
  
  private long t()
    throws IOException
  {
    for (long l = d(); l < 0L; l = d()) {
      a(e());
    }
    return l;
  }
  
  ll a(InputStream paramInputStream, int paramInt)
  {
    a(paramInt, new lq(paramInputStream, null));
    return this;
  }
  
  ll a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    a(8192, new lo(paramArrayOfByte, paramInt1, paramInt2, null));
    return this;
  }
  
  ln a()
  {
    return new ln(this, null);
  }
  
  public nw a(nw paramnw)
    throws IOException
  {
    int i = d();
    if (paramnw != null) {}
    for (;;)
    {
      paramnw.a(i);
      if (i != 0) {
        c(paramnw.a(), 0, i);
      }
      return paramnw;
      paramnw = new nw();
    }
  }
  
  public ByteBuffer a(ByteBuffer paramByteBuffer)
    throws IOException
  {
    int i = d();
    if ((paramByteBuffer != null) && (i <= paramByteBuffer.capacity())) {
      paramByteBuffer.clear();
    }
    for (;;)
    {
      c(paramByteBuffer.array(), paramByteBuffer.position(), i);
      paramByteBuffer.limit(i);
      return paramByteBuffer;
      paramByteBuffer = ByteBuffer.allocate(i);
    }
  }
  
  public void a(int paramInt)
    throws IOException
  {
    a(paramInt);
  }
  
  protected void a(long paramLong)
    throws IOException
  {
    int i = this.e - this.d;
    if (paramLong <= i)
    {
      this.d = ((int)(this.d + paramLong));
      return;
    }
    this.d = 0;
    this.e = 0;
    long l = i;
    this.a.a(paramLong - l);
  }
  
  public void b()
    throws IOException
  {}
  
  public void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    c(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  protected void c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int i = this.e - this.d;
    if (paramInt2 <= i)
    {
      System.arraycopy(this.b, this.d, paramArrayOfByte, paramInt1, paramInt2);
      this.d += paramInt2;
      return;
    }
    System.arraycopy(this.b, this.d, paramArrayOfByte, paramInt1, i);
    this.d = this.e;
    this.a.a(paramArrayOfByte, paramInt1 + i, paramInt2 - i);
  }
  
  public boolean c()
    throws IOException
  {
    if (this.e == this.d)
    {
      this.e = this.a.b(this.b, 0, this.b.length);
      this.d = 0;
      if (this.e == 0) {
        throw new EOFException();
      }
    }
    byte[] arrayOfByte = this.b;
    int i = this.d;
    this.d = (i + 1);
    return (arrayOfByte[i] & 0xFF) == 1;
  }
  
  public int d()
    throws IOException
  {
    int k = 5;
    b(5);
    int j = this.b[this.d] & 0xFF;
    int i = j & 0x7F;
    if (j > 127)
    {
      byte[] arrayOfByte = this.b;
      int m = this.d;
      j = 2;
      int n = arrayOfByte[(1 + m)] & 0xFF;
      m = i ^ (n & 0x7F) << 7;
      i = m;
      if (n > 127)
      {
        arrayOfByte = this.b;
        i = this.d;
        j = 3;
        n = arrayOfByte[(i + 2)] & 0xFF;
        m ^= (n & 0x7F) << 14;
        i = m;
        if (n > 127)
        {
          arrayOfByte = this.b;
          i = this.d;
          j = 4;
          n = arrayOfByte[(i + 3)] & 0xFF;
          m ^= (n & 0x7F) << 21;
          i = m;
          if (n > 127)
          {
            n = this.b[(this.d + 4)] & 0xFF;
            i = m ^ (n & 0x7F) << 28;
            j = k;
            if (n > 127) {
              throw new IOException("Invalid int encoding");
            }
          }
        }
      }
    }
    for (;;)
    {
      this.d = (j + this.d);
      if (this.d > this.e) {
        throw new EOFException();
      }
      return -(i & 0x1) ^ i >>> 1;
      j = 1;
    }
  }
  
  public long e()
    throws IOException
  {
    b(10);
    byte[] arrayOfByte = this.b;
    int i = this.d;
    this.d = (i + 1);
    int j = arrayOfByte[i] & 0xFF;
    i = j & 0x7F;
    long l;
    if (j > 127)
    {
      arrayOfByte = this.b;
      j = this.d;
      this.d = (j + 1);
      j = arrayOfByte[j] & 0xFF;
      i ^= (j & 0x7F) << 7;
      if (j > 127)
      {
        arrayOfByte = this.b;
        j = this.d;
        this.d = (j + 1);
        j = arrayOfByte[j] & 0xFF;
        i ^= (j & 0x7F) << 14;
        if (j > 127)
        {
          arrayOfByte = this.b;
          j = this.d;
          this.d = (j + 1);
          j = arrayOfByte[j] & 0xFF;
          i ^= (j & 0x7F) << 21;
          if (j > 127) {
            l = b(i);
          }
        }
      }
    }
    while (this.d > this.e)
    {
      throw new EOFException();
      l = i;
      continue;
      l = i;
      continue;
      l = i;
      continue;
      l = i;
    }
    return -(l & 1L) ^ l >>> 1;
  }
  
  public float f()
    throws IOException
  {
    b(4);
    int i = this.b[this.d];
    int j = this.b[(1 + this.d)];
    int k = this.b[(this.d + 2)];
    int m = this.b[(this.d + 3)];
    if (this.d + 4 > this.e) {
      throw new EOFException();
    }
    this.d += 4;
    return Float.intBitsToFloat((j & 0xFF) << 8 | i & 0xFF | (k & 0xFF) << 16 | (m & 0xFF) << 24);
  }
  
  public double g()
    throws IOException
  {
    b(8);
    int i = this.b[this.d];
    int j = this.b[(1 + this.d)];
    int k = this.b[(this.d + 2)];
    int m = this.b[(this.d + 3)];
    int n = this.b[(this.d + 4)];
    int i1 = this.b[(this.d + 5)];
    int i2 = this.b[(this.d + 6)];
    int i3 = this.b[(this.d + 7)];
    if (this.d + 8 > this.e) {
      throw new EOFException();
    }
    this.d += 8;
    long l = (j & 0xFF) << 8 | i & 0xFF | (k & 0xFF) << 16 | (m & 0xFF) << 24;
    return Double.longBitsToDouble((n & 0xFF | (i1 & 0xFF) << 8 | (i2 & 0xFF) << 16 | (i3 & 0xFF) << 24) << 32 | l & 0xFFFFFFFF);
  }
  
  public String h()
    throws IOException
  {
    return a(this.f).toString();
  }
  
  public void i()
    throws IOException
  {
    a(d());
  }
  
  public void j()
    throws IOException
  {
    a(d());
  }
  
  public int k()
    throws IOException
  {
    return d();
  }
  
  protected long l()
    throws IOException
  {
    long l2 = e();
    long l1 = l2;
    if (l2 < 0L)
    {
      e();
      l1 = -l2;
    }
    return l1;
  }
  
  public long m()
    throws IOException
  {
    return l();
  }
  
  public long n()
    throws IOException
  {
    return l();
  }
  
  public long o()
    throws IOException
  {
    return t();
  }
  
  public long p()
    throws IOException
  {
    return l();
  }
  
  public long q()
    throws IOException
  {
    return l();
  }
  
  public long r()
    throws IOException
  {
    return t();
  }
  
  public int s()
    throws IOException
  {
    return d();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ll.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */