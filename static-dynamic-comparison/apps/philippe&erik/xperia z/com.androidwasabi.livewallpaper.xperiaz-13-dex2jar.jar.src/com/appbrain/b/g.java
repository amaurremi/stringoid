package com.appbrain.b;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class g
{
  private final byte[] a;
  private int b;
  private int c;
  private int d;
  private final InputStream e;
  private int f;
  private int g;
  private int h = Integer.MAX_VALUE;
  private int i;
  private int j = 64;
  private int k = 67108864;
  
  private g(byte[] paramArrayOfByte, int paramInt)
  {
    this.a = paramArrayOfByte;
    this.b = (paramInt + 0);
    this.d = 0;
    this.g = 0;
    this.e = null;
  }
  
  public static g a(byte[] paramArrayOfByte, int paramInt)
  {
    paramArrayOfByte = new g(paramArrayOfByte, paramInt);
    try
    {
      paramArrayOfByte.c(paramInt);
      return paramArrayOfByte;
    }
    catch (o paramArrayOfByte)
    {
      throw new IllegalArgumentException(paramArrayOfByte);
    }
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (this.d < this.b) {
      throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
    }
    if (this.g + this.b == this.h)
    {
      if (paramBoolean) {
        throw o.a();
      }
      return false;
    }
    this.g += this.b;
    this.d = 0;
    if (this.e == null) {}
    for (int m = -1;; m = this.e.read(this.a))
    {
      this.b = m;
      if ((this.b != 0) && (this.b >= -1)) {
        break;
      }
      throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + this.b + "\nThe InputStream implementation is buggy.");
    }
    if (this.b == -1)
    {
      this.b = 0;
      if (paramBoolean) {
        throw o.a();
      }
      return false;
    }
    i();
    m = this.g + this.b + this.c;
    if ((m > this.k) || (m < 0)) {
      throw o.h();
    }
    return true;
  }
  
  private void e(int paramInt)
  {
    if (paramInt < 0) {
      throw o.b();
    }
    if (this.g + this.d + paramInt > this.h)
    {
      e(this.h - this.g - this.d);
      throw o.a();
    }
    if (paramInt <= this.b - this.d)
    {
      this.d += paramInt;
      return;
    }
    int m = this.b - this.d;
    this.d = this.b;
    a(true);
    while (paramInt - m > this.b)
    {
      m += this.b;
      this.d = this.b;
      a(true);
    }
    this.d = (paramInt - m);
  }
  
  private void i()
  {
    this.b += this.c;
    int m = this.g + this.b;
    if (m > this.h)
    {
      this.c = (m - this.h);
      this.b -= this.c;
      return;
    }
    this.c = 0;
  }
  
  private byte j()
  {
    if (this.d == this.b) {
      a(true);
    }
    byte[] arrayOfByte = this.a;
    int m = this.d;
    this.d = (m + 1);
    return arrayOfByte[m];
  }
  
  public final int a()
  {
    if ((this.d == this.b) && (!a(false))) {}
    for (int m = 1; m != 0; m = 0)
    {
      this.f = 0;
      return 0;
    }
    this.f = g();
    if (ag.b(this.f) == 0) {
      throw o.d();
    }
    return this.f;
  }
  
  public final t a(w paramw, j paramj)
  {
    int m = g();
    if (this.i >= this.j) {
      throw o.g();
    }
    m = c(m);
    this.i += 1;
    paramw = (t)paramw.a(this, paramj);
    a(0);
    this.i -= 1;
    d(m);
    return paramw;
  }
  
  public final void a(int paramInt)
  {
    if (this.f != paramInt) {
      throw o.e();
    }
  }
  
  public final long b()
  {
    int m = 0;
    long l = 0L;
    while (m < 64)
    {
      int n = j();
      l |= (n & 0x7F) << m;
      if ((n & 0x80) == 0) {
        return l;
      }
      m += 7;
    }
    throw o.c();
  }
  
  public final boolean b(int paramInt)
  {
    switch (ag.a(paramInt))
    {
    default: 
      throw o.f();
    case 0: 
      g();
      return true;
    case 1: 
      j();
      j();
      j();
      j();
      j();
      j();
      j();
      j();
      return true;
    case 2: 
      e(g());
      return true;
    case 3: 
      int m;
      do
      {
        m = a();
      } while ((m != 0) && (b(m)));
      a(ag.a(ag.b(paramInt), 4));
      return true;
    case 4: 
      return false;
    }
    j();
    j();
    j();
    j();
    return true;
  }
  
  public final int c()
  {
    return g();
  }
  
  public final int c(int paramInt)
  {
    if (paramInt < 0) {
      throw o.b();
    }
    paramInt = this.g + this.d + paramInt;
    int m = this.h;
    if (paramInt > m) {
      throw o.a();
    }
    this.h = paramInt;
    i();
    return m;
  }
  
  public final void d(int paramInt)
  {
    this.h = paramInt;
    i();
  }
  
  public final boolean d()
  {
    return g() != 0;
  }
  
  public final d e()
  {
    int i2 = g();
    if (i2 == 0) {
      return d.a;
    }
    Object localObject1;
    if ((i2 <= this.b - this.d) && (i2 > 0))
    {
      localObject1 = d.a(this.a, this.d, i2);
      this.d += i2;
      return (d)localObject1;
    }
    if (i2 < 0) {
      throw o.b();
    }
    if (this.g + this.d + i2 > this.h)
    {
      e(this.h - this.g - this.d);
      throw o.a();
    }
    if (i2 <= this.b - this.d)
    {
      localObject1 = new byte[i2];
      System.arraycopy(this.a, this.d, localObject1, 0, i2);
      this.d += i2;
    }
    for (;;)
    {
      return d.a((byte[])localObject1);
      int m;
      if (i2 < 4096)
      {
        localObject1 = new byte[i2];
        m = this.b - this.d;
        System.arraycopy(this.a, this.d, localObject1, 0, m);
        this.d = this.b;
        a(true);
        while (i2 - m > this.b)
        {
          System.arraycopy(this.a, 0, localObject1, m, this.b);
          m += this.b;
          this.d = this.b;
          a(true);
        }
        System.arraycopy(this.a, 0, localObject1, m, i2 - m);
        this.d = (i2 - m);
      }
      else
      {
        int i3 = this.d;
        int i4 = this.b;
        this.g += this.b;
        this.d = 0;
        this.b = 0;
        Object localObject2 = new ArrayList();
        m = i2 - (i4 - i3);
        while (m > 0)
        {
          localObject1 = new byte[Math.min(m, 4096)];
          int n = 0;
          while (n < localObject1.length)
          {
            if (this.e == null) {}
            for (int i1 = -1; i1 == -1; i1 = this.e.read((byte[])localObject1, n, localObject1.length - n)) {
              throw o.a();
            }
            this.g += i1;
            n += i1;
          }
          n = localObject1.length;
          ((List)localObject2).add(localObject1);
          m -= n;
        }
        localObject1 = new byte[i2];
        m = i4 - i3;
        System.arraycopy(this.a, i3, localObject1, 0, m);
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          byte[] arrayOfByte = (byte[])((Iterator)localObject2).next();
          System.arraycopy(arrayOfByte, 0, localObject1, m, arrayOfByte.length);
          m = arrayOfByte.length + m;
        }
      }
    }
  }
  
  public final int f()
  {
    return g();
  }
  
  public final int g()
  {
    int m = j();
    if (m >= 0) {}
    int i1;
    do
    {
      return m;
      m &= 0x7F;
      n = j();
      if (n >= 0) {
        return m | n << 7;
      }
      m |= (n & 0x7F) << 7;
      n = j();
      if (n >= 0) {
        return m | n << 14;
      }
      m |= (n & 0x7F) << 14;
      i1 = j();
      if (i1 >= 0) {
        return m | i1 << 21;
      }
      n = j();
      i1 = m | (i1 & 0x7F) << 21 | n << 28;
      m = i1;
    } while (n >= 0);
    int n = 0;
    for (;;)
    {
      if (n >= 5) {
        break label133;
      }
      m = i1;
      if (j() >= 0) {
        break;
      }
      n += 1;
    }
    label133:
    throw o.c();
  }
  
  public final int h()
  {
    if (this.h == Integer.MAX_VALUE) {
      return -1;
    }
    int m = this.g;
    int n = this.d;
    return this.h - (m + n);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/b/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */