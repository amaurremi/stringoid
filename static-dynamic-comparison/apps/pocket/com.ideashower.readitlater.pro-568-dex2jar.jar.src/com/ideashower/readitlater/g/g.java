package com.ideashower.readitlater.g;

import com.ideashower.readitlater.a.ag;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class g
  extends k
{
  private static i a;
  private static final Object b = new Object();
  
  public g()
  {
    this.n = a;
  }
  
  public static void e() {}
  
  public static void f() {}
  
  public static ag g()
  {
    new ag()
    {
      public void a() {}
      
      public void b() {}
      
      public void c() {}
    };
  }
  
  private static void k()
  {
    synchronized (b)
    {
      if (a != null) {
        l();
      }
      a = new i(5, 128, "task");
      return;
    }
  }
  
  private static void l()
  {
    synchronized (b)
    {
      if (a != null) {
        a.a(20, TimeUnit.SECONDS);
      }
      return;
    }
  }
  
  public g a(i parami)
  {
    this.n = parami;
    if (this.j.getAndSet(2) == 1) {
      parami.a(this);
    }
    return this;
  }
  
  public int d()
  {
    if (this.j.get() == 1) {
      h();
    }
    return super.d();
  }
  
  public g h()
  {
    return a(this.n);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/g/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */