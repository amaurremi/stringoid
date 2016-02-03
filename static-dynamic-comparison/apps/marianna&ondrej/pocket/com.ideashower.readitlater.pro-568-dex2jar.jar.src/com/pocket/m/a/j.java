package com.pocket.m.a;

import com.ideashower.readitlater.h.b;
import com.ideashower.readitlater.h.i;

public class j
{
  private final b a = com.ideashower.readitlater.h.a.V;
  private boolean b = false;
  private boolean c = false;
  private boolean d = false;
  
  private void a(boolean paramBoolean)
  {
    i.a(this.a, paramBoolean);
    if (!c()) {
      f();
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.b)
    {
      this.c = paramBoolean1;
      this.d = paramBoolean2;
      this.b = true;
    }
    do
    {
      do
      {
        do
        {
          return;
        } while ((paramBoolean1 == this.c) && (paramBoolean2 == this.d));
        this.c = paramBoolean1;
        this.d = paramBoolean2;
        if (paramBoolean1) {
          break;
        }
      } while (c());
      f();
      return;
      a(true);
    } while (e.f() < e.b * 0.75D);
    g.a();
  }
  
  private void f()
  {
    com.pocket.m.a.b(false);
  }
  
  protected void a()
  {
    boolean bool2 = true;
    for (;;)
    {
      long l1;
      boolean bool1;
      try
      {
        l1 = e.g();
        if (l1 == 0L)
        {
          bool1 = true;
          break label57;
          a(bool1, bool2);
        }
        else
        {
          bool1 = false;
        }
      }
      finally {}
      long l2 = e.c;
      if (l1 >= l2)
      {
        bool2 = false;
        continue;
        label57:
        if (!bool1) {}
      }
    }
  }
  
  protected boolean b()
  {
    return this.c;
  }
  
  protected boolean c()
  {
    if (!e.i()) {}
    while ((!b()) && (!i.a(this.a)) && (e.g() >= e.c)) {
      return false;
    }
    return true;
  }
  
  protected void d()
  {
    if (!b()) {
      a(false);
    }
  }
  
  protected void e()
  {
    if (!b()) {
      a(false);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/m/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */