package org.a.a.c;

import org.a.a.c;
import org.a.a.j;

public final class s
  extends d
{
  public s(c paramc, org.a.a.d paramd)
  {
    super(paramc, paramd);
    if (paramc.g() != 0) {
      throw new IllegalArgumentException("Wrapped field's minumum value must be zero");
    }
  }
  
  public int a(long paramLong)
  {
    int j = i().a(paramLong);
    int i = j;
    if (j == 0) {
      i = h();
    }
    return i;
  }
  
  public long a(long paramLong, int paramInt)
  {
    return i().a(paramLong, paramInt);
  }
  
  public long a(long paramLong1, long paramLong2)
  {
    return i().a(paramLong1, paramLong2);
  }
  
  public long b(long paramLong, int paramInt)
  {
    int j = h();
    g.a(this, paramInt, 1, j);
    int i = paramInt;
    if (paramInt == j) {
      i = 0;
    }
    return i().b(paramLong, i);
  }
  
  public boolean b(long paramLong)
  {
    return i().b(paramLong);
  }
  
  public int c(long paramLong)
  {
    return i().c(paramLong) + 1;
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
    return 1;
  }
  
  public long g(long paramLong)
  {
    return i().g(paramLong);
  }
  
  public int h()
  {
    return i().h() + 1;
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/a/a/c/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */