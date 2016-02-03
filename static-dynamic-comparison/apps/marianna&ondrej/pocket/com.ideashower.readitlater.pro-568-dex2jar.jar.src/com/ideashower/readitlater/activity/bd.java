package com.ideashower.readitlater.activity;

import com.ideashower.readitlater.a.a.a;
import com.ideashower.readitlater.a.l;

class bd
  extends com.ideashower.readitlater.g.g
{
  private final String b;
  
  public bd(SubscriptionCustomWebActivity paramSubscriptionCustomWebActivity, String paramString)
  {
    this.b = paramString;
  }
  
  protected void a()
  {
    l.b(this.b);
  }
  
  protected void a(boolean paramBoolean, Throwable paramThrowable)
  {
    if ((SubscriptionCustomWebActivity.b(this.a) == null) || (SubscriptionCustomWebActivity.b(this.a) != this)) {
      return;
    }
    a.b(com.ideashower.readitlater.util.g.a(this.b));
    if (SubscriptionCustomWebActivity.c(this.a) != null)
    {
      this.a.removeDialog(23);
      SubscriptionCustomWebActivity.a(this.a, null);
    }
    this.a.showDialog(22);
  }
  
  protected boolean b()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */