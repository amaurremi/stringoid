package com.ideashower.readitlater.db.operation.action;

import com.ideashower.readitlater.db.operation.j;
import com.ideashower.readitlater.e.o;

public class al
  extends s
{
  public al(o paramo, UiContext paramUiContext)
  {
    super("undo_archive", paramo, true, true, paramUiContext);
  }
  
  protected int a()
  {
    this.d.k(0);
    return 4;
  }
  
  public void a(j paramj)
  {
    paramj.a(o().f(), 0);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/db/operation/action/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */