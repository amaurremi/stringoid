package org.a.a.e;

import org.a.a.i;

public class a
  extends i
{
  private static final int b;
  private final i c;
  private final b[] d = new b[b + 1];
  
  static
  {
    try
    {
      Integer localInteger = Integer.getInteger("org.joda.time.tz.CachedDateTimeZone.size");
      if (localInteger == null)
      {
        i = 512;
        b = i - 1;
        return;
      }
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        Object localObject = null;
        continue;
        int i = ((Integer)localObject).intValue() - 1;
        int j = 0;
        while (i > 0)
        {
          j += 1;
          i >>= 1;
        }
        i = 1 << j;
      }
    }
  }
  
  private a(i parami)
  {
    super(parami.c());
    this.c = parami;
  }
  
  public static a a(i parami)
  {
    if ((parami instanceof a)) {
      return (a)parami;
    }
    return new a(parami);
  }
  
  private b g(long paramLong)
  {
    int i = (int)(paramLong >> 32);
    b[] arrayOfb = this.d;
    int j = i & b;
    b localb2 = arrayOfb[j];
    b localb1;
    if (localb2 != null)
    {
      localb1 = localb2;
      if ((int)(localb2.a >> 32) == i) {}
    }
    else
    {
      localb1 = h(paramLong);
      arrayOfb[j] = localb1;
    }
    return localb1;
  }
  
  private b h(long paramLong)
  {
    long l1 = paramLong & 0xFFFFFFFF00000000;
    b localb1 = new b(this.c, l1);
    Object localObject = localb1;
    long l2;
    for (paramLong = l1;; paramLong = l2)
    {
      l2 = this.c.e(paramLong);
      if ((l2 == paramLong) || (l2 > (l1 | 0xFFFFFFFF))) {
        return localb1;
      }
      b localb2 = new b(this.c, l2);
      ((b)localObject).c = localb2;
      localObject = localb2;
    }
  }
  
  public String a(long paramLong)
  {
    return g(paramLong).a(paramLong);
  }
  
  public int b(long paramLong)
  {
    return g(paramLong).b(paramLong);
  }
  
  public boolean d()
  {
    return this.c.d();
  }
  
  public long e(long paramLong)
  {
    return this.c.e(paramLong);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject instanceof a)) {
      return this.c.equals(((a)paramObject).c);
    }
    return false;
  }
  
  public long f(long paramLong)
  {
    return this.c.f(paramLong);
  }
  
  public int hashCode()
  {
    return this.c.hashCode();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/a/a/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */