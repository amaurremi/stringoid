package com.ideashower.readitlater.db.operation.action;

import com.ideashower.readitlater.db.operation.j;
import com.ideashower.readitlater.util.u;
import org.codehaus.jackson.node.ObjectNode;

public class q
  extends f
{
  public q(UiContext paramUiContext, int[] paramArrayOfInt)
  {
    super("highlights_impression", paramUiContext);
    paramUiContext = u.a();
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      if (paramUiContext.length() > 0) {
        paramUiContext.append(",");
      }
      paramUiContext.append(k);
      i += 1;
    }
    this.a.put("ids", paramUiContext.toString());
    u.a(paramUiContext);
  }
  
  protected int a()
  {
    return 1;
  }
  
  public void a(j paramj) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/db/operation/action/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */