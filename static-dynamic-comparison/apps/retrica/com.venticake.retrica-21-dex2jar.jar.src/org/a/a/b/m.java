package org.a.a.b;

import org.a.a.c.g;
import org.a.a.c.h;
import org.a.a.j;

class m
  extends h
{
  protected final d a;
  
  m(d paramd)
  {
    super(org.a.a.d.s(), paramd.T());
    this.a = paramd;
  }
  
  public int a(long paramLong)
  {
    return this.a.a(paramLong);
  }
  
  public long a(long paramLong, int paramInt)
  {
    if (paramInt == 0) {
      return paramLong;
    }
    return b(paramLong, g.a(a(paramLong), paramInt));
  }
  
  public long a(long paramLong1, long paramLong2)
  {
    return a(paramLong1, g.a(paramLong2));
  }
  
  public long b(long paramLong, int paramInt)
  {
    g.a(this, paramInt, this.a.Q(), this.a.R());
    return this.a.f(paramLong, paramInt);
  }
  
  public boolean b(long paramLong)
  {
    return this.a.e(a(paramLong));
  }
  
  public long d(long paramLong)
  {
    return this.a.d(a(paramLong));
  }
  
  public long e(long paramLong)
  {
    int i = a(paramLong);
    long l = paramLong;
    if (paramLong != this.a.d(i)) {
      l = this.a.d(i + 1);
    }
    return l;
  }
  
  public j e()
  {
    return null;
  }
  
  public j f()
  {
    return this.a.s();
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/a/a/b/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */