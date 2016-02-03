package org.a.a.c;

import org.a.a.c;
import org.a.a.j;

public class o
  extends d
{
  final int a;
  final j b;
  
  public o(f paramf)
  {
    this(paramf, paramf.a());
  }
  
  public o(f paramf, org.a.a.d paramd)
  {
    super(paramf.i(), paramd);
    this.a = paramf.a;
    this.b = paramf.b;
  }
  
  public o(c paramc, org.a.a.d paramd, int paramInt)
  {
    super(paramc, paramd);
    if (paramInt < 2) {
      throw new IllegalArgumentException("The divisor must be at least 2");
    }
    paramc = paramc.d();
    if (paramc == null) {}
    for (this.b = null;; this.b = new p(paramc, paramd.z(), paramInt))
    {
      this.a = paramInt;
      return;
    }
  }
  
  private int a(int paramInt)
  {
    if (paramInt >= 0) {
      return paramInt / this.a;
    }
    return (paramInt + 1) / this.a - 1;
  }
  
  public int a(long paramLong)
  {
    int i = i().a(paramLong);
    if (i >= 0) {
      return i % this.a;
    }
    int j = this.a;
    return (i + 1) % this.a + (j - 1);
  }
  
  public long b(long paramLong, int paramInt)
  {
    g.a(this, paramInt, 0, this.a - 1);
    int i = a(i().a(paramLong));
    return i().b(paramLong, i * this.a + paramInt);
  }
  
  public long d(long paramLong)
  {
    return i().d(paramLong);
  }
  
  public long e(long paramLong)
  {
    return i().e(paramLong);
  }
  
  public j e()
  {
    return this.b;
  }
  
  public long f(long paramLong)
  {
    return i().f(paramLong);
  }
  
  public int g()
  {
    return 0;
  }
  
  public long g(long paramLong)
  {
    return i().g(paramLong);
  }
  
  public int h()
  {
    return this.a - 1;
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/a/a/c/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */