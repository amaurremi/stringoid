package com.pocket.m.a;

import com.ideashower.readitlater.db.operation.u;
import com.pocket.c.e;
import com.pocket.m.a;

class m
  extends com.ideashower.readitlater.g.g
{
  private final boolean a;
  private final Runnable b;
  private final boolean c;
  
  public m(boolean paramBoolean1, Runnable paramRunnable, boolean paramBoolean2)
  {
    this.a = paramBoolean1;
    this.b = paramRunnable;
    this.c = paramBoolean2;
  }
  
  private void k()
  {
    if (this.b != null) {
      com.ideashower.readitlater.a.g.a(this.b);
    }
  }
  
  protected void a()
  {
    e.a(false);
    a.d();
    l.g().d();
    if (this.a) {
      l.a(new c());
    }
    new u().d();
    com.ideashower.readitlater.i.c.a();
    if (!this.c) {
      k();
    }
    l.g().e();
    if (this.c) {
      k();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/m/a/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */