package com.ideashower.readitlater.db.operation.action;

import com.ideashower.readitlater.e.o;
import com.ideashower.readitlater.e.x;
import org.codehaus.jackson.node.ObjectNode;

public abstract class aj
  extends s
{
  protected x e;
  
  protected aj(String paramString, x paramx, o paramo, boolean paramBoolean, UiContext paramUiContext)
  {
    super(paramString, paramo, true, paramBoolean, paramUiContext);
    this.a.put("share_id", paramx.b());
    this.e = paramx;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/db/operation/action/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */