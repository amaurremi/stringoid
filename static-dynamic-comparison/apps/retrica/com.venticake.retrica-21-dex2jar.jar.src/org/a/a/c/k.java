package org.a.a.c;

import org.a.a.c;
import org.a.a.j;

public class k
  extends d
{
  private final int a;
  private final int b;
  private final int c;
  
  public k(c paramc, int paramInt) {}
  
  public k(c paramc, org.a.a.d paramd, int paramInt)
  {
    this(paramc, paramd, paramInt, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }
  
  public k(c paramc, org.a.a.d paramd, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramc, paramd);
    if (paramInt1 == 0) {
      throw new IllegalArgumentException("The offset cannot be zero");
    }
    this.a = paramInt1;
    if (paramInt2 < paramc.g() + paramInt1) {}
    for (this.b = (paramc.g() + paramInt1); paramInt3 > paramc.h() + paramInt1; this.b = paramInt2)
    {
      this.c = (paramc.h() + paramInt1);
      return;
    }
    this.c = paramInt3;
  }
  
  public int a(long paramLong)
  {
    return super.a(paramLong) + this.a;
  }
  
  public long a(long paramLong, int paramInt)
  {
    paramLong = super.a(paramLong, paramInt);
    g.a(this, a(paramLong), this.b, this.c);
    return paramLong;
  }
  
  public long a(long paramLong1, long paramLong2)
  {
    paramLong1 = super.a(paramLong1, paramLong2);
    g.a(this, a(paramLong1), this.b, this.c);
    return paramLong1;
  }
  
  public long b(long paramLong, int paramInt)
  {
    g.a(this, paramInt, this.b, this.c);
    return super.b(paramLong, paramInt - this.a);
  }
  
  public boolean b(long paramLong)
  {
    return i().b(paramLong);
  }
  
  public long d(long paramLong)
  {
    return i().d(paramLong);
  }
  
  public long e(long paramLong)
  {
    return i().e(paramLong);
  }
  
  public long f(long paramLong)
  {
    return i().f(paramLong);
  }
  
  public j f()
  {
    return i().f();
  }
  
  public int g()
  {
    return this.b;
  }
  
  public long g(long paramLong)
  {
    return i().g(paramLong);
  }
  
  public int h()
  {
    return this.c;
  }
  
  public long h(long paramLong)
  {
    return i().h(paramLong);
  }
  
  public long i(long paramLong)
  {
    return i().i(paramLong);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/a/a/c/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */