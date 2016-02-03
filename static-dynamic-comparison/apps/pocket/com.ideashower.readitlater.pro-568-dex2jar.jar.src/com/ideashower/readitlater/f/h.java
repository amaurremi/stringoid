package com.ideashower.readitlater.f;

import com.ideashower.readitlater.a.x;
import com.ideashower.readitlater.util.a.b;

public abstract class h
  implements g
{
  private e a;
  
  public void a()
  {
    this.a = null;
  }
  
  public void a(e parame, b paramb)
  {
    if (a(parame))
    {
      a(paramb);
      this.a = null;
    }
    for (;;)
    {
      parame.m();
      return;
      paramb.b(false);
    }
  }
  
  protected abstract void a(b paramb);
  
  public boolean a(e parame)
  {
    return parame.equals(this.a);
  }
  
  public void b(final e parame)
  {
    this.a = parame;
    parame = x.a(parame);
    if (parame != null)
    {
      this.a = null;
      if (com.ideashower.readitlater.a.g.q()) {
        a(parame);
      }
    }
    else
    {
      return;
    }
    com.ideashower.readitlater.a.g.a(new Runnable()
    {
      public void run()
      {
        h.this.a(parame);
      }
    });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/f/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */