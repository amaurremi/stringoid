package com.ideashower.readitlater.objects;

import com.ideashower.readitlater.g.g;

class m
  implements Runnable
{
  private boolean b = false;
  private g c;
  
  public m(l paraml, g paramg)
  {
    this.c = paramg;
  }
  
  public void a()
  {
    this.b = true;
  }
  
  public void run()
  {
    if (!this.b) {
      this.c.h();
    }
    this.c = null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/objects/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */