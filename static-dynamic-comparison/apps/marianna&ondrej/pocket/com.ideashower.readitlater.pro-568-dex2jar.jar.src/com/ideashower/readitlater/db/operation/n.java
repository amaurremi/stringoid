package com.ideashower.readitlater.db.operation;

import android.os.Handler;
import com.ideashower.readitlater.a.g;

public abstract class n
  extends j
{
  protected boolean e = false;
  
  public n()
  {
    h(1);
  }
  
  protected abstract void A();
  
  protected abstract n a(boolean paramBoolean);
  
  protected final void c_()
  {
    for (boolean bool = true; bool; bool = z()) {
      if ((e()) || (a_()))
      {
        final n localn = a(a_());
        if (localn != null) {
          g.o().postDelayed(new Runnable()
          {
            public void run()
            {
              localn.f();
            }
          }, 1000L);
        }
        return;
      }
    }
    this.e = true;
    A();
  }
  
  public boolean e()
  {
    return d.i() > 1;
  }
  
  public boolean g()
  {
    return this.e;
  }
  
  protected abstract boolean z();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/db/operation/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */