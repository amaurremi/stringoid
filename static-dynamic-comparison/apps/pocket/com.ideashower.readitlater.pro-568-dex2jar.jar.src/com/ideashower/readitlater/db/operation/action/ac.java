package com.ideashower.readitlater.db.operation.action;

import com.ideashower.readitlater.db.operation.j;
import com.ideashower.readitlater.util.l;
import org.codehaus.jackson.node.ObjectNode;

public class ac
  extends c
{
  public ac(String paramString1, String paramString2, UiContext paramUiContext)
  {
    super("tag_rename", true, paramUiContext);
    this.a.put("old_tag", paramString1);
    this.a.put("new_tag", paramString2);
  }
  
  protected int a()
  {
    return 4;
  }
  
  public void a(j paramj)
  {
    paramj.a(k(), l());
  }
  
  public String k()
  {
    return l.a(this.a, "old_tag", null);
  }
  
  public String l()
  {
    return l.a(this.a, "new_tag", null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/db/operation/action/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */