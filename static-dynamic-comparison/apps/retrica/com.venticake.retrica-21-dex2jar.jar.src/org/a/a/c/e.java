package org.a.a.c;

import org.a.a.j;
import org.a.a.k;

public class e
  extends c
{
  private final j a;
  
  public e(j paramj, k paramk)
  {
    super(paramk);
    if (paramj == null) {
      throw new IllegalArgumentException("The field must not be null");
    }
    if (!paramj.b()) {
      throw new IllegalArgumentException("The field must be supported");
    }
    this.a = paramj;
  }
  
  public long a(long paramLong, int paramInt)
  {
    return this.a.a(paramLong, paramInt);
  }
  
  public long a(long paramLong1, long paramLong2)
  {
    return this.a.a(paramLong1, paramLong2);
  }
  
  public boolean c()
  {
    return this.a.c();
  }
  
  public long d()
  {
    return this.a.d();
  }
  
  public final j f()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/a/a/c/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */