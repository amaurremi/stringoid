package org.a.a.c;

import java.util.Locale;
import org.a.a.c;
import org.a.a.d;
import org.a.a.j;
import org.a.a.m;

public abstract class b
  extends c
{
  private final d a;
  
  protected b(d paramd)
  {
    if (paramd == null) {
      throw new IllegalArgumentException("The type must not be null");
    }
    this.a = paramd;
  }
  
  public abstract int a(long paramLong);
  
  protected int a(String paramString, Locale paramLocale)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException paramLocale)
    {
      throw new m(a(), paramString);
    }
  }
  
  public int a(Locale paramLocale)
  {
    int i = h();
    if (i >= 0)
    {
      if (i < 10) {
        return 1;
      }
      if (i < 100) {
        return 2;
      }
      if (i < 1000) {
        return 3;
      }
    }
    return Integer.toString(i).length();
  }
  
  public long a(long paramLong, int paramInt)
  {
    return d().a(paramLong, paramInt);
  }
  
  public long a(long paramLong1, long paramLong2)
  {
    return d().a(paramLong1, paramLong2);
  }
  
  public long a(long paramLong, String paramString, Locale paramLocale)
  {
    return b(paramLong, a(paramString, paramLocale));
  }
  
  public String a(int paramInt, Locale paramLocale)
  {
    return Integer.toString(paramInt);
  }
  
  public String a(long paramLong, Locale paramLocale)
  {
    return a(a(paramLong), paramLocale);
  }
  
  public final d a()
  {
    return this.a;
  }
  
  public abstract long b(long paramLong, int paramInt);
  
  public final String b()
  {
    return this.a.x();
  }
  
  public String b(int paramInt, Locale paramLocale)
  {
    return a(paramInt, paramLocale);
  }
  
  public String b(long paramLong, Locale paramLocale)
  {
    return b(a(paramLong), paramLocale);
  }
  
  public boolean b(long paramLong)
  {
    return false;
  }
  
  public int c(long paramLong)
  {
    return h();
  }
  
  public final boolean c()
  {
    return true;
  }
  
  public abstract long d(long paramLong);
  
  public abstract j d();
  
  public long e(long paramLong)
  {
    long l2 = d(paramLong);
    long l1 = paramLong;
    if (l2 != paramLong) {
      l1 = a(l2, 1);
    }
    return l1;
  }
  
  public long f(long paramLong)
  {
    long l1 = d(paramLong);
    long l2 = e(paramLong);
    if (paramLong - l1 <= l2 - paramLong) {
      return l1;
    }
    return l2;
  }
  
  public j f()
  {
    return null;
  }
  
  public long g(long paramLong)
  {
    long l1 = d(paramLong);
    long l2 = e(paramLong);
    if (l2 - paramLong <= paramLong - l1) {
      return l2;
    }
    return l1;
  }
  
  public abstract int h();
  
  public long h(long paramLong)
  {
    long l1 = d(paramLong);
    long l2 = e(paramLong);
    long l3 = paramLong - l1;
    paramLong = l2 - paramLong;
    if (l3 < paramLong) {}
    do
    {
      return l1;
      if (paramLong < l3) {
        return l2;
      }
    } while ((a(l2) & 0x1) != 0);
    return l2;
  }
  
  public long i(long paramLong)
  {
    return paramLong - d(paramLong);
  }
  
  public String toString()
  {
    return "DateTimeField[" + b() + ']';
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/a/a/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */