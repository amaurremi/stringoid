package com.ideashower.readitlater.views;

import com.ideashower.readitlater.views.toolbars.StyledToolbar;
import com.pocket.c.am;
import com.pocket.m.a;

public class an
{
  private final StyledToolbar a;
  private final am b;
  private final com.pocket.m.e c;
  private boolean d;
  private ao e;
  
  public an(StyledToolbar paramStyledToolbar)
  {
    this.a = paramStyledToolbar;
    this.d = false;
    this.b = new am()
    {
      public void a()
      {
        an.this.b();
      }
      
      public void a(float paramAnonymousFloat) {}
      
      public void b()
      {
        an.this.b();
      }
      
      public void c() {}
      
      public void d() {}
    };
    com.pocket.c.e.a(this.b);
    this.c = new com.pocket.m.e()
    {
      public void a()
      {
        an.this.b();
      }
    };
    a.a(this.c);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean == this.d) {}
    for (;;)
    {
      return;
      if (paramBoolean)
      {
        this.d = true;
        this.a.d();
      }
      while (this.e != null)
      {
        this.e.a(paramBoolean);
        return;
        this.d = false;
        this.a.e();
      }
    }
  }
  
  public void a()
  {
    if (this.d)
    {
      com.pocket.c.e.a(false);
      a.d();
      a(false);
    }
    while (!com.pocket.c.e.l()) {
      return;
    }
    a.c(true);
    a(true);
  }
  
  public void a(ao paramao)
  {
    this.e = paramao;
  }
  
  public void b()
  {
    boolean bool = false;
    if ((com.pocket.c.e.d()) || (a.a(false))) {
      bool = true;
    }
    a(bool);
  }
  
  public boolean c()
  {
    return this.d;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */