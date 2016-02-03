package com.pocket.m.b;

import java.util.concurrent.atomic.AtomicBoolean;

public abstract class e
  extends com.ideashower.readitlater.g.k
{
  protected boolean a = false;
  protected AtomicBoolean b = new AtomicBoolean(false);
  protected AtomicBoolean c = new AtomicBoolean(false);
  protected boolean d;
  protected int e;
  private final com.pocket.m.a.k f;
  
  public e(int paramInt, com.pocket.m.a.k paramk)
  {
    super(paramInt);
    this.f = paramk;
  }
  
  public boolean a_()
  {
    return (super.a_()) || (!com.pocket.m.a.e.a(k()));
  }
  
  public boolean e()
  {
    return this.c.get();
  }
  
  public boolean f()
  {
    return this.a;
  }
  
  public boolean g()
  {
    return this.d;
  }
  
  public int h()
  {
    return this.e;
  }
  
  public boolean i()
  {
    return (a_()) || (H());
  }
  
  public boolean j()
  {
    return this.e == 1;
  }
  
  public com.pocket.m.a.k k()
  {
    return this.f;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/m/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */