package org.a.a.b;

import java.util.Locale;
import org.a.a.c;
import org.a.a.c.b;
import org.a.a.i;
import org.a.a.j;
import org.a.a.m;
import org.a.a.n;

final class w
  extends b
{
  final c a;
  final i b;
  final j c;
  final boolean d;
  final j e;
  final j f;
  
  w(c paramc, i parami, j paramj1, j paramj2, j paramj3)
  {
    super(paramc.a());
    if (!paramc.c()) {
      throw new IllegalArgumentException();
    }
    this.a = paramc;
    this.b = parami;
    this.c = paramj1;
    this.d = v.a(paramj1);
    this.e = paramj2;
    this.f = paramj3;
  }
  
  private int j(long paramLong)
  {
    int i = this.b.b(paramLong);
    if (((i + paramLong ^ paramLong) < 0L) && ((i ^ paramLong) >= 0L)) {
      throw new ArithmeticException("Adding time zone offset caused overflow");
    }
    return i;
  }
  
  public int a(long paramLong)
  {
    paramLong = this.b.d(paramLong);
    return this.a.a(paramLong);
  }
  
  public int a(Locale paramLocale)
  {
    return this.a.a(paramLocale);
  }
  
  public long a(long paramLong, int paramInt)
  {
    if (this.d)
    {
      int i = j(paramLong);
      return this.a.a(i + paramLong, paramInt) - i;
    }
    long l = this.b.d(paramLong);
    l = this.a.a(l, paramInt);
    return this.b.a(l, false, paramLong);
  }
  
  public long a(long paramLong1, long paramLong2)
  {
    if (this.d)
    {
      int i = j(paramLong1);
      return this.a.a(i + paramLong1, paramLong2) - i;
    }
    long l = this.b.d(paramLong1);
    paramLong2 = this.a.a(l, paramLong2);
    return this.b.a(paramLong2, false, paramLong1);
  }
  
  public long a(long paramLong, String paramString, Locale paramLocale)
  {
    long l = this.b.d(paramLong);
    l = this.a.a(l, paramString, paramLocale);
    return this.b.a(l, false, paramLong);
  }
  
  public String a(int paramInt, Locale paramLocale)
  {
    return this.a.a(paramInt, paramLocale);
  }
  
  public String a(long paramLong, Locale paramLocale)
  {
    paramLong = this.b.d(paramLong);
    return this.a.a(paramLong, paramLocale);
  }
  
  public long b(long paramLong, int paramInt)
  {
    long l = this.b.d(paramLong);
    l = this.a.b(l, paramInt);
    paramLong = this.b.a(l, false, paramLong);
    if (a(paramLong) != paramInt)
    {
      n localn = new n(l, this.b.c());
      m localm = new m(this.a.a(), Integer.valueOf(paramInt), localn.getMessage());
      localm.initCause(localn);
      throw localm;
    }
    return paramLong;
  }
  
  public String b(int paramInt, Locale paramLocale)
  {
    return this.a.b(paramInt, paramLocale);
  }
  
  public String b(long paramLong, Locale paramLocale)
  {
    paramLong = this.b.d(paramLong);
    return this.a.b(paramLong, paramLocale);
  }
  
  public boolean b(long paramLong)
  {
    paramLong = this.b.d(paramLong);
    return this.a.b(paramLong);
  }
  
  public int c(long paramLong)
  {
    paramLong = this.b.d(paramLong);
    return this.a.c(paramLong);
  }
  
  public long d(long paramLong)
  {
    if (this.d)
    {
      int i = j(paramLong);
      return this.a.d(i + paramLong) - i;
    }
    long l = this.b.d(paramLong);
    l = this.a.d(l);
    return this.b.a(l, false, paramLong);
  }
  
  public final j d()
  {
    return this.c;
  }
  
  public long e(long paramLong)
  {
    if (this.d)
    {
      int i = j(paramLong);
      return this.a.e(i + paramLong) - i;
    }
    long l = this.b.d(paramLong);
    l = this.a.e(l);
    return this.b.a(l, false, paramLong);
  }
  
  public final j e()
  {
    return this.e;
  }
  
  public final j f()
  {
    return this.f;
  }
  
  public int g()
  {
    return this.a.g();
  }
  
  public int h()
  {
    return this.a.h();
  }
  
  public long i(long paramLong)
  {
    paramLong = this.b.d(paramLong);
    return this.a.i(paramLong);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/a/a/b/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */