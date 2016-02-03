package org.a.a.c;

import org.a.a.d;
import org.a.a.j;

public class l
  extends m
{
  private final int b;
  private final j c;
  
  public l(d paramd, j paramj1, j paramj2)
  {
    super(paramd, paramj1);
    if (!paramj2.c()) {
      throw new IllegalArgumentException("Range duration field must be precise");
    }
    this.b = ((int)(paramj2.d() / i()));
    if (this.b < 2) {
      throw new IllegalArgumentException("The effective range must be at least 2");
    }
    this.c = paramj2;
  }
  
  public int a(long paramLong)
  {
    if (paramLong >= 0L) {
      return (int)(paramLong / i() % this.b);
    }
    return this.b - 1 + (int)((1L + paramLong) / i() % this.b);
  }
  
  public long b(long paramLong, int paramInt)
  {
    g.a(this, paramInt, g(), h());
    return (paramInt - a(paramLong)) * this.a + paramLong;
  }
  
  public j e()
  {
    return this.c;
  }
  
  public int h()
  {
    return this.b - 1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/a/a/c/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */