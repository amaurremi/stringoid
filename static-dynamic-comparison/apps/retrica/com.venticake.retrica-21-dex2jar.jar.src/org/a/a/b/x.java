package org.a.a.b;

import org.a.a.c.c;
import org.a.a.i;
import org.a.a.j;

class x
  extends c
{
  final j a;
  final boolean b;
  final i c;
  
  x(j paramj, i parami)
  {
    super(paramj.a());
    if (!paramj.b()) {
      throw new IllegalArgumentException();
    }
    this.a = paramj;
    this.b = v.a(paramj);
    this.c = parami;
  }
  
  private int a(long paramLong)
  {
    int i = this.c.b(paramLong);
    if (((i + paramLong ^ paramLong) < 0L) && ((i ^ paramLong) >= 0L)) {
      throw new ArithmeticException("Adding time zone offset caused overflow");
    }
    return i;
  }
  
  private int b(long paramLong)
  {
    int i = this.c.c(paramLong);
    if (((paramLong - i ^ paramLong) < 0L) && ((i ^ paramLong) < 0L)) {
      throw new ArithmeticException("Subtracting time zone offset caused overflow");
    }
    return i;
  }
  
  public long a(long paramLong, int paramInt)
  {
    int i = a(paramLong);
    paramLong = this.a.a(i + paramLong, paramInt);
    if (this.b) {}
    for (paramInt = i;; paramInt = b(paramLong)) {
      return paramLong - paramInt;
    }
  }
  
  public long a(long paramLong1, long paramLong2)
  {
    int i = a(paramLong1);
    paramLong1 = this.a.a(i + paramLong1, paramLong2);
    if (this.b) {}
    for (;;)
    {
      return paramLong1 - i;
      i = b(paramLong1);
    }
  }
  
  public boolean c()
  {
    if (this.b) {
      return this.a.c();
    }
    return (this.a.c()) && (this.c.d());
  }
  
  public long d()
  {
    return this.a.d();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/a/a/b/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */