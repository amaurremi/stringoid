package com.ideashower.readitlater.db.operation.action;

import com.ideashower.readitlater.db.operation.j;
import com.ideashower.readitlater.e.o;
import com.ideashower.readitlater.h.a;
import com.ideashower.readitlater.h.l;

public class i
  extends s
{
  public i(o paramo, UiContext paramUiContext)
  {
    super("archive", paramo, true, false, paramUiContext);
  }
  
  public i(String paramString, UiContext paramUiContext)
  {
    super("archive", paramString, true, false, paramUiContext);
  }
  
  protected int a()
  {
    if (com.ideashower.readitlater.h.i.a(a.bU) == 0) {
      com.ideashower.readitlater.h.i.b().a(a.bU, 1).a();
    }
    if (this.d != null)
    {
      this.d.k(1);
      return 4;
    }
    return 3;
  }
  
  public void a(j paramj)
  {
    int i = c(paramj);
    if (o.m(i)) {
      paramj.b(i);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/db/operation/action/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */