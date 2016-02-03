package com.ideashower.readitlater.db.operation.action;

import com.ideashower.readitlater.db.operation.j;
import org.codehaus.jackson.node.ObjectNode;

public class ab
  extends c
{
  public ab(int paramInt, UiContext paramUiContext)
  {
    super("refresh_library", true, paramUiContext);
    this.a.put("item_id", paramInt);
  }
  
  protected int a()
  {
    return 1;
  }
  
  public void a(j paramj) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/db/operation/action/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */