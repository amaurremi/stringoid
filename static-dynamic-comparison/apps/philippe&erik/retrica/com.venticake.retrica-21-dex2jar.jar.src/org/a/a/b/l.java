package org.a.a.b;

import org.a.a.c;
import org.a.a.c.g;
import org.a.a.c.h;
import org.a.a.j;

final class l
  extends h
{
  private final d a;
  
  l(d paramd)
  {
    super(org.a.a.d.p(), paramd.T());
    this.a = paramd;
  }
  
  public int a(long paramLong)
  {
    return this.a.e(paramLong);
  }
  
  public long a(long paramLong, int paramInt)
  {
    if (paramInt == 0) {
      return paramLong;
    }
    return b(paramLong, a(paramLong) + paramInt);
  }
  
  public long a(long paramLong1, long paramLong2)
  {
    return a(paramLong1, g.a(paramLong2));
  }
  
  public long b(long paramLong, int paramInt)
  {
    g.a(this, Math.abs(paramInt), this.a.Q(), this.a.R());
    int i = a(paramLong);
    if (i == paramInt) {
      return paramLong;
    }
    int k = this.a.g(paramLong);
    i = this.a.b(i);
    int j = this.a.b(paramInt);
    if (j < i)
    {
      i = j;
      j = this.a.f(paramLong);
      if (j <= i) {
        break label185;
      }
    }
    for (;;)
    {
      long l = this.a.f(paramLong, paramInt);
      j = a(l);
      if (j < paramInt) {
        paramLong = l + 604800000L;
      }
      for (;;)
      {
        l = i - this.a.f(paramLong);
        return this.a.t().b(paramLong + l * 604800000L, k);
        break;
        paramLong = l;
        if (j > paramInt) {
          paramLong = l - 604800000L;
        }
      }
      label185:
      i = j;
    }
  }
  
  public boolean b(long paramLong)
  {
    return this.a.b(this.a.e(paramLong)) > 52;
  }
  
  public long d(long paramLong)
  {
    long l = this.a.x().d(paramLong);
    int i = this.a.f(l);
    paramLong = l;
    if (i > 1) {
      paramLong = l - 604800000L * (i - 1);
    }
    return paramLong;
  }
  
  public j e()
  {
    return null;
  }
  
  public j f()
  {
    return this.a.w();
  }
  
  public int g()
  {
    return this.a.Q();
  }
  
  public int h()
  {
    return this.a.R();
  }
  
  public long i(long paramLong)
  {
    return paramLong - d(paramLong);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/a/a/b/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */