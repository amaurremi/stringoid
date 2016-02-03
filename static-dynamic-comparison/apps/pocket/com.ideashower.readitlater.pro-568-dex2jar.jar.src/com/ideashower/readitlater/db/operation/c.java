package com.ideashower.readitlater.db.operation;

import com.ideashower.readitlater.g.k;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class c
  extends k
{
  public int d()
  {
    if (this.j.get() == 1) {
      f();
    }
    return super.d();
  }
  
  public c f()
  {
    if (this.j.getAndSet(2) == 1) {
      d.a(this);
    }
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/db/operation/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */