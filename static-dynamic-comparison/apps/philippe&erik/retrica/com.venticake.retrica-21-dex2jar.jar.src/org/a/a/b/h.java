package org.a.a.b;

import org.a.a.c.m;
import org.a.a.j;

final class h
  extends m
{
  private final d b;
  
  h(d paramd, j paramj)
  {
    super(org.a.a.d.n(), paramj);
    this.b = paramd;
  }
  
  public int a(long paramLong)
  {
    return this.b.d(paramLong);
  }
  
  public int c(long paramLong)
  {
    int i = this.b.a(paramLong);
    return this.b.a(i);
  }
  
  protected int c(long paramLong, int paramInt)
  {
    int i = this.b.O() - 1;
    if ((paramInt > i) || (paramInt < 1)) {
      i = c(paramLong);
    }
    return i;
  }
  
  public j e()
  {
    return this.b.D();
  }
  
  public int g()
  {
    return 1;
  }
  
  public int h()
  {
    return this.b.O();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/a/a/b/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */