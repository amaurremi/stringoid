package com.ideashower.readitlater.db.operation.action;

import com.ideashower.readitlater.db.operation.j;
import com.ideashower.readitlater.e.o;
import com.ideashower.readitlater.e.t;
import com.ideashower.readitlater.e.v;
import org.codehaus.jackson.node.ObjectNode;

public class af
  extends s
{
  private final v e;
  
  public af(v paramv, o paramo)
  {
    super("scrolled", paramo, true, false, null);
    this.a.putAll(t.a(paramv));
    this.e = paramv;
  }
  
  protected int a()
  {
    this.d.a(this.e);
    return 2;
  }
  
  public void a(j paramj)
  {
    paramj.a(n(), this.e);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/db/operation/action/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */