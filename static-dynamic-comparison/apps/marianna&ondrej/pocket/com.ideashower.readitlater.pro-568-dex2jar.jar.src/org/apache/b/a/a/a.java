package org.apache.b.a.a;

import java.io.IOException;
import java.io.InputStream;

public class a
  extends InputStream
{
  private static final int[] b;
  private final byte[] c = new byte[1];
  private final InputStream d;
  private final byte[] e;
  private final org.apache.b.a.b.a f;
  private int g = 0;
  private int h = 0;
  private boolean i = false;
  private boolean j;
  private final c k;
  
  static
  {
    int i1 = 0;
    if (!a.class.desiredAssertionStatus()) {}
    int n;
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      b = new int['Ā'];
      int m = 0;
      for (;;)
      {
        n = i1;
        if (m >= 256) {
          break;
        }
        b[m] = -1;
        m += 1;
      }
    }
    while (n < b.a.length)
    {
      b[(b.a[n] & 0xFF)] = n;
      n += 1;
    }
  }
  
  protected a(int paramInt, InputStream paramInputStream, c paramc)
  {
    if (paramInputStream == null) {
      throw new IllegalArgumentException();
    }
    this.e = new byte[paramInt];
    this.f = new org.apache.b.a.b.a(512);
    this.d = paramInputStream;
    this.k = paramc;
  }
  
  public a(InputStream paramInputStream, c paramc)
  {
    this(1536, paramInputStream, paramc);
  }
  
  private int a(int paramInt1, int paramInt2, byte[] paramArrayOfByte, int paramInt3, int paramInt4)
  {
    this.j = true;
    int m;
    if (paramInt2 == 2)
    {
      m = (byte)(paramInt1 >>> 4);
      if (paramInt3 < paramInt4)
      {
        paramArrayOfByte[paramInt3] = m;
        return paramInt3 + 1;
      }
      this.f.a(m);
      return paramInt3;
    }
    if (paramInt2 == 3)
    {
      m = (byte)(paramInt1 >>> 10);
      int n = (byte)(paramInt1 >>> 2 & 0xFF);
      if (paramInt3 < paramInt4 - 1)
      {
        paramInt1 = paramInt3 + 1;
        paramArrayOfByte[paramInt3] = m;
        paramArrayOfByte[paramInt1] = n;
        return paramInt1 + 1;
      }
      if (paramInt3 < paramInt4)
      {
        paramArrayOfByte[paramInt3] = m;
        this.f.a(n);
        return paramInt3 + 1;
      }
      this.f.a(m);
      this.f.a(n);
      return paramInt3;
    }
    b(paramInt2);
    return paramInt3;
  }
  
  private int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i7 = -1;
    int i8 = paramInt1 + paramInt2;
    if (this.f.c() > 0)
    {
      paramInt2 = Math.min(this.f.c(), paramInt2);
      System.arraycopy(this.f.d(), 0, paramArrayOfByte, paramInt1, paramInt2);
      this.f.a(0, paramInt2);
      paramInt2 += paramInt1;
    }
    for (;;)
    {
      if (this.j)
      {
        if (paramInt2 == paramInt1) {
          return -1;
        }
        return paramInt2 - paramInt1;
      }
      int i5 = 0;
      int i6 = 0;
      int i4 = paramInt2;
      if (i4 < i8)
      {
        do
        {
          for (;;)
          {
            i3 = i6;
            i2 = i5;
            paramInt2 = i4;
            if (this.g != this.h) {
              break label305;
            }
            paramInt2 = this.d.read(this.e, 0, this.e.length);
            if (paramInt2 == -1)
            {
              this.j = true;
              if (i5 != 0) {
                a(i5);
              }
              if (i4 == paramInt1) {}
              for (paramInt1 = i7;; paramInt1 = i4 - paramInt1) {
                return paramInt1;
              }
            }
            if (paramInt2 <= 0) {
              break;
            }
            this.g = 0;
            this.h = paramInt2;
          }
        } while ((a) || (paramInt2 == 0));
        throw new AssertionError();
        label206:
        i4 = i3 << 6 | i5;
        i5 = i2 + 1;
        int i3 = i4;
        int i2 = i5;
        int m;
        int n;
        int i1;
        if (i5 == 4)
        {
          m = (byte)(i4 >>> 16);
          n = (byte)(i4 >>> 8);
          i1 = (byte)i4;
          if (paramInt2 < i8 - 2)
          {
            i2 = paramInt2 + 1;
            paramArrayOfByte[paramInt2] = m;
            i3 = i2 + 1;
            paramArrayOfByte[i2] = n;
            paramInt2 = i3 + 1;
            paramArrayOfByte[i3] = i1;
            i2 = 0;
            i3 = i4;
          }
        }
        else
        {
          label305:
          do
          {
            i6 = i3;
            i5 = i2;
            i4 = paramInt2;
            if (this.g >= this.h) {
              break;
            }
            i6 = i3;
            i5 = i2;
            i4 = paramInt2;
            if (paramInt2 >= i8) {
              break;
            }
            byte[] arrayOfByte = this.e;
            i4 = this.g;
            this.g = (i4 + 1);
            i4 = arrayOfByte[i4] & 0xFF;
            if (i4 == 61) {
              return a(i3, i2, paramArrayOfByte, paramInt2, i8) - paramInt1;
            }
            i5 = b[i4];
            if (i5 >= 0) {
              break label206;
            }
          } while ((i4 == 13) || (i4 == 10) || (i4 == 32) || (!this.k.a("Unexpected base64 byte: " + (byte)i4, "ignoring.")));
          throw new IOException("Unexpected base64 byte");
        }
        if (paramInt2 < i8 - 1)
        {
          i2 = paramInt2 + 1;
          paramArrayOfByte[paramInt2] = m;
          paramInt2 = i2 + 1;
          paramArrayOfByte[i2] = n;
          this.f.a(i1);
        }
        while ((!a) && (paramInt2 != i8))
        {
          throw new AssertionError();
          if (paramInt2 < i8)
          {
            paramArrayOfByte[paramInt2] = m;
            this.f.a(n);
            this.f.a(i1);
            paramInt2 += 1;
          }
          else
          {
            this.f.a(m);
            this.f.a(n);
            this.f.a(i1);
          }
        }
        return i8 - paramInt1;
      }
      if ((!a) && (i5 != 0)) {
        throw new AssertionError();
      }
      if ((!a) && (i4 != i8)) {
        throw new AssertionError();
      }
      return i8 - paramInt1;
      paramInt2 = paramInt1;
    }
  }
  
  private void a(int paramInt)
  {
    if (this.k.a("Unexpected end of BASE64 stream", "dropping " + paramInt + " sextet(s)")) {
      throw new IOException("Unexpected end of BASE64 stream");
    }
  }
  
  private void b(int paramInt)
  {
    if (this.k.a("Unexpected padding character", "dropping " + paramInt + " sextet(s)")) {
      throw new IOException("Unexpected padding character");
    }
  }
  
  public void close()
  {
    if (this.i) {
      return;
    }
    this.i = true;
  }
  
  public int read()
  {
    if (this.i) {
      throw new IOException("Stream has been closed");
    }
    int m;
    do
    {
      m = a(this.c, 0, 1);
      if (m == -1) {
        return -1;
      }
    } while (m != 1);
    return this.c[0] & 0xFF;
  }
  
  public int read(byte[] paramArrayOfByte)
  {
    if (this.i) {
      throw new IOException("Stream has been closed");
    }
    if (paramArrayOfByte == null) {
      throw new NullPointerException();
    }
    if (paramArrayOfByte.length == 0) {
      return 0;
    }
    return a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.i) {
      throw new IOException("Stream has been closed");
    }
    if (paramArrayOfByte == null) {
      throw new NullPointerException();
    }
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt1 + paramInt2 > paramArrayOfByte.length)) {
      throw new IndexOutOfBoundsException();
    }
    if (paramInt2 == 0) {
      return 0;
    }
    return a(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/apache/b/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */