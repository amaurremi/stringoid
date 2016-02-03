package org.a.a.c;

import org.a.a.c;
import org.a.a.j;

public class f
  extends d
{
  final int a;
  final j b;
  private final int c;
  private final int d;
  
  public f(c paramc, org.a.a.d paramd, int paramInt)
  {
    super(paramc, paramd);
    if (paramInt < 2) {
      throw new IllegalArgumentException("The divisor must be at least 2");
    }
    j localj = paramc.d();
    int i;
    label59:
    int j;
    if (localj == null)
    {
      this.b = null;
      this.a = paramInt;
      i = paramc.g();
      if (i < 0) {
        break label108;
      }
      i /= paramInt;
      j = paramc.h();
      if (j < 0) {
        break label121;
      }
    }
    label108:
    label121:
    for (paramInt = j / paramInt;; paramInt = (j + 1) / paramInt - 1)
    {
      this.c = i;
      this.d = paramInt;
      return;
      this.b = new p(localj, paramd.y(), paramInt);
      break;
      i = (i + 1) / paramInt - 1;
      break label59;
    }
  }
  
  private int a(int paramInt)
  {
    if (paramInt >= 0) {
      return paramInt % this.a;
    }
    return this.a - 1 + (paramInt + 1) % this.a;
  }
  
  public int a(long paramLong)
  {
    int i = i().a(paramLong);
    if (i >= 0) {
      return i / this.a;
    }
    return (i + 1) / this.a - 1;
  }
  
  public long a(long paramLong, int paramInt)
  {
    return i().a(paramLong, this.a * paramInt);
  }
  
  public long a(long paramLong1, long paramLong2)
  {
    return i().a(paramLong1, this.a * paramLong2);
  }
  
  public long b(long paramLong, int paramInt)
  {
    g.a(this, paramInt, this.c, this.d);
    int i = a(i().a(paramLong));
    return i().b(paramLong, i + this.a * paramInt);
  }
  
  public long d(long paramLong)
  {
    c localc = i();
    return localc.d(localc.b(paramLong, a(paramLong) * this.a));
  }
  
  public j d()
  {
    return this.b;
  }
  
  public int g()
  {
    return this.c;
  }
  
  public int h()
  {
    return this.d;
  }
  
  public long i(long paramLong)
  {
    return b(paramLong, a(i().i(paramLong)));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/a/a/c/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */