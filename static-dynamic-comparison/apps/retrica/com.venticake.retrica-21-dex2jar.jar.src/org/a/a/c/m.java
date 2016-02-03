package org.a.a.c;

import org.a.a.d;
import org.a.a.j;

public abstract class m
  extends b
{
  final long a;
  private final j b;
  
  public m(d paramd, j paramj)
  {
    super(paramd);
    if (!paramj.c()) {
      throw new IllegalArgumentException("Unit duration field must be precise");
    }
    this.a = paramj.d();
    if (this.a < 1L) {
      throw new IllegalArgumentException("The unit milliseconds must be at least 1");
    }
    this.b = paramj;
  }
  
  public long b(long paramLong, int paramInt)
  {
    g.a(this, paramInt, g(), c(paramLong, paramInt));
    return (paramInt - a(paramLong)) * this.a + paramLong;
  }
  
  protected int c(long paramLong, int paramInt)
  {
    return c(paramLong);
  }
  
  public long d(long paramLong)
  {
    if (paramLong >= 0L) {
      return paramLong - paramLong % this.a;
    }
    paramLong = 1L + paramLong;
    return paramLong - paramLong % this.a - this.a;
  }
  
  public j d()
  {
    return this.b;
  }
  
  public long e(long paramLong)
  {
    if (paramLong > 0L)
    {
      paramLong -= 1L;
      return paramLong - paramLong % this.a + this.a;
    }
    return paramLong - paramLong % this.a;
  }
  
  public int g()
  {
    return 0;
  }
  
  public final long i()
  {
    return this.a;
  }
  
  public long i(long paramLong)
  {
    if (paramLong >= 0L) {
      return paramLong % this.a;
    }
    return (paramLong + 1L) % this.a + this.a - 1L;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/a/a/c/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */