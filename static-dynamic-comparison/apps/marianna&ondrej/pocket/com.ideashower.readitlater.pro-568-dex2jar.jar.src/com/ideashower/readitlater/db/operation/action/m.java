package com.ideashower.readitlater.db.operation.action;

import com.ideashower.readitlater.db.operation.j;
import com.ideashower.readitlater.e.o;

public class m
  extends s
{
  private final boolean e;
  
  public m(boolean paramBoolean, o paramo, UiContext paramUiContext) {}
  
  public m(boolean paramBoolean, String paramString, UiContext paramUiContext) {}
  
  protected int a()
  {
    if (this.d != null)
    {
      this.d.g(this.e);
      return 4;
    }
    return 3;
  }
  
  public void a(j paramj)
  {
    int i = c(paramj);
    if (o.m(i)) {
      paramj.a(this.e, i);
    }
    while (!this.e) {
      return;
    }
    o localo = o();
    localo.g(true);
    paramj.a(localo, true);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/db/operation/action/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */