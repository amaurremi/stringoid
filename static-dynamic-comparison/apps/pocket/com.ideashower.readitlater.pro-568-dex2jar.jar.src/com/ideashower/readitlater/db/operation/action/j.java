package com.ideashower.readitlater.db.operation.action;

import com.ideashower.readitlater.e.o;
import org.codehaus.jackson.node.ObjectNode;

public class j
  extends f
{
  private final int d;
  
  public j(o paramo, UiContext paramUiContext)
  {
    super("item_impression", paramUiContext);
    this.d = paramo.f();
    this.a.put("item_id", paramo.c());
    this.a.put("url", paramo.k());
  }
  
  protected int a()
  {
    return 1;
  }
  
  public void a(com.ideashower.readitlater.db.operation.j paramj)
  {
    paramj.e(this.d);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/db/operation/action/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */