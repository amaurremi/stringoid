package com.ideashower.readitlater.db.operation.action;

import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.db.operation.j;
import org.codehaus.jackson.node.ObjectNode;

public class w
  extends f
{
  public w(x paramx, String paramString, UiContext paramUiContext)
  {
    super(a(paramx), paramUiContext);
    if (paramString != null) {
      this.a.put("url", paramString);
    }
  }
  
  public static String a(x paramx)
  {
    switch (1.a[paramx.ordinal()])
    {
    default: 
      if (g.y()) {
        throw new RuntimeException("unsupported type " + paramx);
      }
      break;
    case 1: 
      return "start_listen";
    case 2: 
      return "stop_listen";
    case 3: 
      return "rewind_listen";
    case 4: 
      return "fast_forward_listen";
    }
    return "unknown";
  }
  
  protected int a()
  {
    return 1;
  }
  
  public void a(j paramj) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/db/operation/action/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */