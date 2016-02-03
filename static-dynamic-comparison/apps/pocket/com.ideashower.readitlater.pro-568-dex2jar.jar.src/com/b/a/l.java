package com.b.a;

import com.b.b.a;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class l
  implements Cloneable
{
  private static final o i = new f();
  private static final o j = new d();
  private static Class[] k = { Float.TYPE, Float.class, Double.TYPE, Integer.TYPE, Double.class, Integer.class };
  private static Class[] l = { Integer.TYPE, Integer.class, Float.TYPE, Double.TYPE, Float.class, Double.class };
  private static Class[] m = { Double.TYPE, Double.class, Float.TYPE, Integer.TYPE, Float.class, Integer.class };
  private static final HashMap n = new HashMap();
  private static final HashMap o = new HashMap();
  String a;
  protected a b;
  Method c = null;
  Class d;
  k e = null;
  final ReentrantReadWriteLock f = new ReentrantReadWriteLock();
  final Object[] g = new Object[1];
  private Method h = null;
  private o p;
  private Object q;
  
  private l(String paramString)
  {
    this.a = paramString;
  }
  
  public static l a(String paramString, float... paramVarArgs)
  {
    return new m(paramString, paramVarArgs);
  }
  
  public static l a(String paramString, int... paramVarArgs)
  {
    return new n(paramString, paramVarArgs);
  }
  
  public l a()
  {
    try
    {
      l locall = (l)super.clone();
      locall.a = this.a;
      locall.b = this.b;
      locall.e = this.e.b();
      locall.p = this.p;
      return locall;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
  
  void a(float paramFloat)
  {
    this.q = this.e.a(paramFloat);
  }
  
  public void a(float... paramVarArgs)
  {
    this.d = Float.TYPE;
    this.e = k.a(paramVarArgs);
  }
  
  public void a(int... paramVarArgs)
  {
    this.d = Integer.TYPE;
    this.e = k.a(paramVarArgs);
  }
  
  void b()
  {
    o localo;
    if (this.p == null)
    {
      if (this.d != Integer.class) {
        break label44;
      }
      localo = i;
    }
    for (;;)
    {
      this.p = localo;
      if (this.p != null) {
        this.e.a(this.p);
      }
      return;
      label44:
      if (this.d == Float.class) {
        localo = j;
      } else {
        localo = null;
      }
    }
  }
  
  public String c()
  {
    return this.a;
  }
  
  Object d()
  {
    return this.q;
  }
  
  public String toString()
  {
    return this.a + ": " + this.e.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/b/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */