package com.ideashower.readitlater.g;

import java.util.concurrent.FutureTask;

public class h
  extends FutureTask
{
  protected final Object a = new Object();
  protected k b;
  protected boolean c = false;
  
  public h(k paramk)
  {
    super(paramk, null);
    this.b = paramk;
  }
  
  public void d()
  {
    synchronized (this.a)
    {
      if (this.b == null) {
        return;
      }
      this.b.D();
      return;
    }
  }
  
  protected void done()
  {
    synchronized (this.a)
    {
      this.c = this.b.F();
      this.b = null;
      super.done();
      return;
    }
  }
  
  public boolean e()
  {
    synchronized (this.a)
    {
      if (this.b != null)
      {
        bool = this.b.F();
        return bool;
      }
      boolean bool = this.c;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/g/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */