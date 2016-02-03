package org.apache.b.a.a;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Set;

public class b
  extends FilterOutputStream
{
  static final byte[] a;
  private static final byte[] c;
  private static final Set d;
  private final byte[] e;
  private final int f;
  private final byte[] g;
  private boolean h;
  private final byte[] i;
  private int j;
  private int k;
  private int l;
  private int m;
  
  static
  {
    int n = 0;
    if (!b.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      b = bool;
      c = new byte[] { 13, 10 };
      a = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
      d = new HashSet();
      byte[] arrayOfByte = a;
      int i1 = arrayOfByte.length;
      while (n < i1)
      {
        byte b1 = arrayOfByte[n];
        d.add(Byte.valueOf(b1));
        n += 1;
      }
    }
    d.add(Byte.valueOf((byte)61));
  }
  
  private void a()
  {
    if (this.j > 0)
    {
      this.out.write(this.i, 0, this.j);
      this.j = 0;
    }
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    while (paramInt1 < paramInt2)
    {
      this.k = (this.k << 8 | paramArrayOfByte[paramInt1] & 0xFF);
      int i1 = this.l + 1;
      this.l = i1;
      if (i1 == 3)
      {
        this.l = 0;
        if ((this.f > 0) && (this.m >= this.f))
        {
          this.m = 0;
          if (this.i.length - this.j < this.g.length) {
            a();
          }
          arrayOfByte1 = this.g;
          int i2 = arrayOfByte1.length;
          i1 = 0;
          while (i1 < i2)
          {
            int n = arrayOfByte1[i1];
            byte[] arrayOfByte2 = this.i;
            int i3 = this.j;
            this.j = (i3 + 1);
            arrayOfByte2[i3] = n;
            i1 += 1;
          }
        }
        if (this.i.length - this.j < 4) {
          a();
        }
        byte[] arrayOfByte1 = this.i;
        i1 = this.j;
        this.j = (i1 + 1);
        arrayOfByte1[i1] = a[(this.k >> 18 & 0x3F)];
        arrayOfByte1 = this.i;
        i1 = this.j;
        this.j = (i1 + 1);
        arrayOfByte1[i1] = a[(this.k >> 12 & 0x3F)];
        arrayOfByte1 = this.i;
        i1 = this.j;
        this.j = (i1 + 1);
        arrayOfByte1[i1] = a[(this.k >> 6 & 0x3F)];
        arrayOfByte1 = this.i;
        i1 = this.j;
        this.j = (i1 + 1);
        arrayOfByte1[i1] = a[(this.k & 0x3F)];
        this.m += 4;
      }
      paramInt1 += 1;
    }
  }
  
  private void b()
  {
    if (this.l != 0) {
      c();
    }
    if ((this.f > 0) && (this.m > 0)) {
      d();
    }
    a();
  }
  
  private void c()
  {
    if ((this.f > 0) && (this.m >= this.f)) {
      d();
    }
    if (this.i.length - this.j < 4) {
      a();
    }
    byte[] arrayOfByte;
    int n;
    if (this.l == 1)
    {
      arrayOfByte = this.i;
      n = this.j;
      this.j = (n + 1);
      arrayOfByte[n] = a[(this.k >> 2 & 0x3F)];
      arrayOfByte = this.i;
      n = this.j;
      this.j = (n + 1);
      arrayOfByte[n] = a[(this.k << 4 & 0x3F)];
      arrayOfByte = this.i;
      n = this.j;
      this.j = (n + 1);
      arrayOfByte[n] = 61;
      arrayOfByte = this.i;
      n = this.j;
      this.j = (n + 1);
      arrayOfByte[n] = 61;
    }
    for (;;)
    {
      this.m += 4;
      return;
      if ((!b) && (this.l != 2)) {
        throw new AssertionError();
      }
      arrayOfByte = this.i;
      n = this.j;
      this.j = (n + 1);
      arrayOfByte[n] = a[(this.k >> 10 & 0x3F)];
      arrayOfByte = this.i;
      n = this.j;
      this.j = (n + 1);
      arrayOfByte[n] = a[(this.k >> 4 & 0x3F)];
      arrayOfByte = this.i;
      n = this.j;
      this.j = (n + 1);
      arrayOfByte[n] = a[(this.k << 2 & 0x3F)];
      arrayOfByte = this.i;
      n = this.j;
      this.j = (n + 1);
      arrayOfByte[n] = 61;
    }
  }
  
  private void d()
  {
    int i1 = 0;
    this.m = 0;
    if (this.i.length - this.j < this.g.length) {
      a();
    }
    byte[] arrayOfByte1 = this.g;
    int i2 = arrayOfByte1.length;
    while (i1 < i2)
    {
      int n = arrayOfByte1[i1];
      byte[] arrayOfByte2 = this.i;
      int i3 = this.j;
      this.j = (i3 + 1);
      arrayOfByte2[i3] = n;
      i1 += 1;
    }
  }
  
  public void close()
  {
    if (this.h) {
      return;
    }
    this.h = true;
    b();
  }
  
  public void flush()
  {
    if (this.h) {
      throw new IOException("Base64OutputStream has been closed");
    }
    a();
  }
  
  public final void write(int paramInt)
  {
    if (this.h) {
      throw new IOException("Base64OutputStream has been closed");
    }
    this.e[0] = ((byte)paramInt);
    a(this.e, 0, 1);
  }
  
  public final void write(byte[] paramArrayOfByte)
  {
    if (this.h) {
      throw new IOException("Base64OutputStream has been closed");
    }
    if (paramArrayOfByte == null) {
      throw new NullPointerException();
    }
    if (paramArrayOfByte.length == 0) {
      return;
    }
    a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.h) {
      throw new IOException("Base64OutputStream has been closed");
    }
    if (paramArrayOfByte == null) {
      throw new NullPointerException();
    }
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt1 + paramInt2 > paramArrayOfByte.length)) {
      throw new IndexOutOfBoundsException();
    }
    if (paramInt2 == 0) {
      return;
    }
    a(paramArrayOfByte, paramInt1, paramInt1 + paramInt2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/apache/b/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */