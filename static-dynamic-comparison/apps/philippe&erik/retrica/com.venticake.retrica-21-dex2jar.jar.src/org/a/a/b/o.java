package org.a.a.b;

import java.util.Locale;
import org.a.a.c.b;
import org.a.a.c.g;
import org.a.a.c.r;
import org.a.a.j;
import org.a.a.k;

final class o
  extends b
{
  private final d a;
  
  o(d paramd)
  {
    super(org.a.a.d.w());
    this.a = paramd;
  }
  
  public int a(long paramLong)
  {
    if (this.a.a(paramLong) <= 0) {
      return 0;
    }
    return 1;
  }
  
  public int a(Locale paramLocale)
  {
    return p.a(paramLocale).a();
  }
  
  public long a(long paramLong, String paramString, Locale paramLocale)
  {
    return b(paramLong, p.a(paramLocale).a(paramString));
  }
  
  public String a(int paramInt, Locale paramLocale)
  {
    return p.a(paramLocale).a(paramInt);
  }
  
  public long b(long paramLong, int paramInt)
  {
    g.a(this, paramInt, 0, 1);
    long l = paramLong;
    if (a(paramLong) != paramInt)
    {
      paramInt = this.a.a(paramLong);
      l = this.a.f(paramLong, -paramInt);
    }
    return l;
  }
  
  public long d(long paramLong)
  {
    if (a(paramLong) == 1) {
      return this.a.f(0L, 1);
    }
    return Long.MIN_VALUE;
  }
  
  public j d()
  {
    return r.a(k.l());
  }
  
  public long e(long paramLong)
  {
    if (a(paramLong) == 0) {
      return this.a.f(0L, 1);
    }
    return Long.MAX_VALUE;
  }
  
  public j e()
  {
    return null;
  }
  
  public long f(long paramLong)
  {
    return d(paramLong);
  }
  
  public int g()
  {
    return 0;
  }
  
  public long g(long paramLong)
  {
    return d(paramLong);
  }
  
  public int h()
  {
    return 1;
  }
  
  public long h(long paramLong)
  {
    return d(paramLong);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/a/a/b/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */