package com.pocket.m.e;

import com.ideashower.readitlater.g.a;
import com.pocket.m.b.f;
import java.util.concurrent.TimeUnit;

public class c
{
  private final a a;
  private final a b;
  private final Object c = new Object();
  private f d;
  
  public c(int paramInt1, int paramInt2)
  {
    this.a = new a(paramInt1, "off-d-process");
    this.a.a("P");
    this.b = new a(paramInt2, "off-d-write");
    this.b.a("W");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.a.a(paramInt1, paramInt1);
    this.b.a(paramInt2, paramInt2);
  }
  
  public void a(f paramf)
  {
    synchronized (this.c)
    {
      this.d = paramf;
      return;
    }
  }
  
  public boolean a()
  {
    for (;;)
    {
      synchronized (this.c)
      {
        if (this.d == null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public void b()
  {
    this.a.a(false);
    this.b.a(false);
    synchronized (this.c)
    {
      this.d = null;
      return;
    }
  }
  
  public a c()
  {
    this.a.a();
    return this.a;
  }
  
  public a d()
  {
    this.b.a();
    return this.b;
  }
  
  public void e()
  {
    this.a.e();
    this.b.e();
  }
  
  public void f()
  {
    this.a.f();
    this.b.f();
  }
  
  public void g()
  {
    this.a.a(60, TimeUnit.SECONDS);
    this.b.a(60, TimeUnit.SECONDS);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/m/e/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */