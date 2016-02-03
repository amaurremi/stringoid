package com.ideashower.readitlater.db.operation.action;

import com.ideashower.readitlater.db.operation.j;
import com.ideashower.readitlater.e.o;
import com.ideashower.readitlater.e.x;

public class b
  extends aj
{
  private boolean f;
  
  public b(x paramx, o paramo, UiContext paramUiContext) {}
  
  protected int a()
  {
    this.e.a(1);
    if (this.d.al() == 3)
    {
      this.f = true;
      this.d.k(0);
      return 3;
    }
    this.d.a(b((System.currentTimeMillis() / 1000.0D)));
    return 2;
  }
  
  public void a(j paramj)
  {
    if (this.f)
    {
      paramj.a(this.d, false);
      return;
    }
    paramj.a(this.e, this.d);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/db/operation/action/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */