package com.ideashower.readitlater.db.operation.action;

import com.ideashower.readitlater.db.operation.j;
import org.codehaus.jackson.node.ObjectNode;

public class l
  extends c
{
  public l(String paramString, UiContext paramUiContext)
  {
    super("tag_delete", true, paramUiContext);
    this.a.put("tag", paramString);
  }
  
  protected int a()
  {
    return 3;
  }
  
  public void a(j paramj)
  {
    paramj.a(k());
  }
  
  public String k()
  {
    return com.ideashower.readitlater.util.l.a(this.a, "tag", null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/db/operation/action/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */