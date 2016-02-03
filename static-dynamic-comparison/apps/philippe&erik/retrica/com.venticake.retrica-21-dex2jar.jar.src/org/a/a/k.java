package org.a.a;

import java.io.Serializable;

public abstract class k
  implements Serializable
{
  static final k a = new l("eras", (byte)1);
  static final k b = new l("centuries", (byte)2);
  static final k c = new l("weekyears", (byte)3);
  static final k d = new l("years", (byte)4);
  static final k e = new l("months", (byte)5);
  static final k f = new l("weeks", (byte)6);
  static final k g = new l("days", (byte)7);
  static final k h = new l("halfdays", (byte)8);
  static final k i = new l("hours", (byte)9);
  static final k j = new l("minutes", (byte)10);
  static final k k = new l("seconds", (byte)11);
  static final k l = new l("millis", (byte)12);
  private final String m;
  
  protected k(String paramString)
  {
    this.m = paramString;
  }
  
  public static k a()
  {
    return l;
  }
  
  public static k b()
  {
    return k;
  }
  
  public static k c()
  {
    return j;
  }
  
  public static k d()
  {
    return i;
  }
  
  public static k e()
  {
    return h;
  }
  
  public static k f()
  {
    return g;
  }
  
  public static k g()
  {
    return f;
  }
  
  public static k h()
  {
    return c;
  }
  
  public static k i()
  {
    return e;
  }
  
  public static k j()
  {
    return d;
  }
  
  public static k k()
  {
    return b;
  }
  
  public static k l()
  {
    return a;
  }
  
  public abstract j a(a parama);
  
  public String m()
  {
    return this.m;
  }
  
  public String toString()
  {
    return m();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/a/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */