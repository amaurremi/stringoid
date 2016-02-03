package com.ideashower.readitlater.db.operation.action;

import com.ideashower.readitlater.db.operation.j;
import com.ideashower.readitlater.e.o;
import com.ideashower.readitlater.e.y;
import org.apache.a.c.k;
import org.codehaus.jackson.node.ObjectNode;

public class d
  extends s
{
  private int e;
  private String f;
  private y g;
  
  public d(boolean paramBoolean, o paramo, UiContext paramUiContext) {}
  
  public d(boolean paramBoolean, String paramString1, String paramString2, UiContext paramUiContext) {}
  
  protected int a()
  {
    if (this.d != null)
    {
      this.d.k(0);
      if (c().equals("readd")) {
        this.d.a(0L);
      }
      return 4;
    }
    return 3;
  }
  
  public void a(j paramj)
  {
    o localo = o();
    if (this.g != null) {
      localo.a(this.g);
    }
    for (;;)
    {
      this.e = paramj.a(localo, false);
      return;
      if (k.d(this.f))
      {
        y localy = new y();
        localy.a(Long.valueOf(this.f).longValue());
        localo.a(localy);
      }
    }
  }
  
  public void a(y paramy)
  {
    this.g = paramy;
  }
  
  public void a(String paramString)
  {
    this.f = paramString;
    this.a.put("ref_id", paramString);
  }
  
  public int k()
  {
    return this.e;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/db/operation/action/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */