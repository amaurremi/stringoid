package org.a.a;

import java.io.Serializable;

public abstract class d
  implements Serializable
{
  private static final d a = new e("era", (byte)1, k.l(), null);
  private static final d b = new e("yearOfEra", (byte)2, k.j(), k.l());
  private static final d c = new e("centuryOfEra", (byte)3, k.k(), k.l());
  private static final d d = new e("yearOfCentury", (byte)4, k.j(), k.k());
  private static final d e = new e("year", (byte)5, k.j(), null);
  private static final d f = new e("dayOfYear", (byte)6, k.f(), k.j());
  private static final d g = new e("monthOfYear", (byte)7, k.i(), k.j());
  private static final d h = new e("dayOfMonth", (byte)8, k.f(), k.i());
  private static final d i = new e("weekyearOfCentury", (byte)9, k.h(), k.k());
  private static final d j = new e("weekyear", (byte)10, k.h(), null);
  private static final d k = new e("weekOfWeekyear", (byte)11, k.g(), k.h());
  private static final d l = new e("dayOfWeek", (byte)12, k.f(), k.g());
  private static final d m = new e("halfdayOfDay", (byte)13, k.e(), k.f());
  private static final d n = new e("hourOfHalfday", (byte)14, k.d(), k.e());
  private static final d o = new e("clockhourOfHalfday", (byte)15, k.d(), k.e());
  private static final d p = new e("clockhourOfDay", (byte)16, k.d(), k.f());
  private static final d q = new e("hourOfDay", (byte)17, k.d(), k.f());
  private static final d r = new e("minuteOfDay", (byte)18, k.c(), k.f());
  private static final d s = new e("minuteOfHour", (byte)19, k.c(), k.d());
  private static final d t = new e("secondOfDay", (byte)20, k.b(), k.f());
  private static final d u = new e("secondOfMinute", (byte)21, k.b(), k.c());
  private static final d v = new e("millisOfDay", (byte)22, k.a(), k.f());
  private static final d w = new e("millisOfSecond", (byte)23, k.a(), k.b());
  private final String x;
  
  protected d(String paramString)
  {
    this.x = paramString;
  }
  
  public static d a()
  {
    return w;
  }
  
  public static d b()
  {
    return v;
  }
  
  public static d c()
  {
    return u;
  }
  
  public static d d()
  {
    return t;
  }
  
  public static d e()
  {
    return s;
  }
  
  public static d f()
  {
    return r;
  }
  
  public static d g()
  {
    return q;
  }
  
  public static d h()
  {
    return p;
  }
  
  public static d i()
  {
    return n;
  }
  
  public static d j()
  {
    return o;
  }
  
  public static d k()
  {
    return m;
  }
  
  public static d l()
  {
    return l;
  }
  
  public static d m()
  {
    return h;
  }
  
  public static d n()
  {
    return f;
  }
  
  public static d o()
  {
    return k;
  }
  
  public static d p()
  {
    return j;
  }
  
  public static d q()
  {
    return i;
  }
  
  public static d r()
  {
    return g;
  }
  
  public static d s()
  {
    return e;
  }
  
  public static d t()
  {
    return b;
  }
  
  public static d u()
  {
    return d;
  }
  
  public static d v()
  {
    return c;
  }
  
  public static d w()
  {
    return a;
  }
  
  public abstract c a(a parama);
  
  public String toString()
  {
    return x();
  }
  
  public String x()
  {
    return this.x;
  }
  
  public abstract k y();
  
  public abstract k z();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/a/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */