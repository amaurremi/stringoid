package com.pocket.c;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class an
  extends f
{
  public an(int paramInt1, int paramInt2)
  {
    super(paramInt1);
  }
  
  public int d()
  {
    if (this.j.get() == 1) {
      q();
    }
    return super.d();
  }
  
  public an q()
  {
    if (this.j.getAndSet(2) == 1) {
      e.a(this);
    }
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/c/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */