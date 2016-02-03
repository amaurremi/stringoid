package com.ideashower.readitlater.db.operation.action;

import com.ideashower.readitlater.db.operation.j;
import com.ideashower.readitlater.e.o;

public class am
  extends s
{
  public int e;
  
  public am(o paramo, UiContext paramUiContext, int paramInt)
  {
    super("undo_delete", paramo, true, false, paramUiContext);
    this.e = paramInt;
  }
  
  protected int a()
  {
    this.d.k(this.e);
    return 4;
  }
  
  public void a(j paramj)
  {
    int i = c(paramj);
    if (o.m(i)) {
      paramj.a(i, this.e);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/db/operation/action/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */