package com.ideashower.readitlater.a;

import android.content.Context;
import android.content.Intent;
import com.google.android.a.c;
import com.ideashower.readitlater.db.operation.action.UiContext;
import com.ideashower.readitlater.db.operation.action.UiTrigger;
import com.ideashower.readitlater.db.operation.action.n;
import com.ideashower.readitlater.service.PushSyncService;
import com.ideashower.readitlater.util.e;

public class an
  extends ap
{
  public static String a = "638773995762";
  private aq b;
  private UiTrigger c;
  
  private void a(boolean paramBoolean, String paramString)
  {
    if (this.b != null) {
      this.b.a(paramBoolean, paramString);
    }
    this.b = null;
  }
  
  public static boolean a()
  {
    try
    {
      c.a(g.c());
      return true;
    }
    catch (Throwable localThrowable)
    {
      e.a(localThrowable);
    }
    return false;
  }
  
  public String a(Context paramContext)
  {
    String str = c.f(paramContext);
    if (str != null)
    {
      paramContext = str;
      if (!"".equals(str)) {}
    }
    else
    {
      paramContext = null;
    }
    return paramContext;
  }
  
  public void a(Context paramContext, Intent paramIntent)
  {
    paramContext.startService(new Intent(paramContext, PushSyncService.class));
  }
  
  public void a(Context paramContext, aq paramaq, UiTrigger paramUiTrigger)
  {
    if (paramaq != null) {
      this.b = paramaq;
    }
    this.c = paramUiTrigger;
    c.b(paramContext);
    c.a(paramContext, new String[] { a });
  }
  
  public void a(Context paramContext, UiTrigger paramUiTrigger)
  {
    String str = a(paramContext);
    am.e();
    this.b = null;
    c.c(paramContext);
    new n(str, false, UiContext.a(paramUiTrigger)).j();
  }
  
  public void a(Context paramContext, String paramString)
  {
    if (paramString.equals("ACCOUNT_MISSING")) {
      paramContext = g.a(2131493050);
    }
    for (;;)
    {
      a(false, paramContext);
      return;
      if (paramString.equals("AUTHENTICATION_FAILED")) {
        paramContext = g.a(2131493051);
      } else {
        paramContext = g.a(2131493052);
      }
    }
  }
  
  public void a(String paramString)
  {
    new ao(this, paramString).h();
  }
  
  public ag b()
  {
    new ag()
    {
      public void a() {}
      
      public void b()
      {
        an.this.a(g.c(), UiTrigger.A);
      }
      
      public void c() {}
    };
  }
  
  public void b(Context paramContext, String paramString)
  {
    a(paramString);
  }
  
  public void c(Context paramContext, String paramString) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/a/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */