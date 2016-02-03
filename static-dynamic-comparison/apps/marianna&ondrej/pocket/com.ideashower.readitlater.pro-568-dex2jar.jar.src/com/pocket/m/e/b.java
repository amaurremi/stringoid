package com.pocket.m.e;

import com.ideashower.readitlater.g.g;
import java.util.ArrayList;
import java.util.Iterator;

class b
  extends g
{
  private boolean b;
  
  public b(a parama, boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  protected void a()
  {
    for (;;)
    {
      c localc;
      synchronized (a.a(this.a))
      {
        Iterator localIterator = a.a(this.a).iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localc = (c)localIterator.next();
        if (this.b) {
          localc.e();
        }
      }
      localc.f();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/m/e/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */