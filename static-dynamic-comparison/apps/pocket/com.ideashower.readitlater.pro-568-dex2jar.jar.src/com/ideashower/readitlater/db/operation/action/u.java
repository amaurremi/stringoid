package com.ideashower.readitlater.db.operation.action;

import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.db.operation.j;
import com.ideashower.readitlater.e.o;

public class u
  extends s
{
  public u(int paramInt, o paramo, String paramString, UiContext paramUiContext)
  {
    super(b(paramInt), paramo, false, false, paramUiContext);
    b(paramString);
  }
  
  public u(int paramInt, String paramString, UiContext paramUiContext)
  {
    super(b(paramInt), paramString, false, false, paramUiContext);
  }
  
  public static String b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      if (g.y()) {
        throw new RuntimeException("unsupported view type " + paramInt);
      }
      break;
    case 1: 
      return "opened_article";
    case 2: 
      return "opened_web";
    case 3: 
      return "opened_video";
    }
    return "unknown";
  }
  
  protected int a()
  {
    return 1;
  }
  
  public void a(j paramj) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/db/operation/action/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */