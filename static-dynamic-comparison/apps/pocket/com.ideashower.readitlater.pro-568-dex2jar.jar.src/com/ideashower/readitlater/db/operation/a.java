package com.ideashower.readitlater.db.operation;

import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.db.operation.action.UiContext;
import com.ideashower.readitlater.db.operation.action.UiTrigger;
import com.ideashower.readitlater.db.operation.action.d;
import com.ideashower.readitlater.h.i;
import com.pocket.oauth.q;
import twitter4j.Status;
import twitter4j.Twitter;

public class a
  extends j
{
  private int e;
  private final d p;
  private final boolean q;
  private String r;
  
  public a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (i.a(com.ideashower.readitlater.h.a.bn)) {}
    for (UiTrigger localUiTrigger = UiTrigger.c;; localUiTrigger = UiTrigger.b)
    {
      this.p = new d(false, paramString1, null, UiContext.a(localUiTrigger));
      if (paramString2 != null)
      {
        this.r = paramString2;
        this.p.a(paramString2);
      }
      this.q = paramBoolean;
      this.b = true;
      return;
    }
  }
  
  protected void b(boolean paramBoolean, Throwable paramThrowable)
  {
    super.b(paramBoolean, paramThrowable);
    if (!paramBoolean) {
      this.e = -4;
    }
  }
  
  protected void c_()
  {
    Object localObject;
    if ((this.r != null) && (this.q)) {
      localObject = q.a(g.c());
    }
    try
    {
      localObject = ((Twitter)localObject).showStatus(Long.valueOf(this.r).longValue());
      String str = com.ideashower.readitlater.util.y.b(((Status)localObject).getText());
      if (str != null)
      {
        this.p.b(str);
        c(str);
      }
      this.p.a(com.ideashower.readitlater.e.y.a((Status)localObject, true));
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.ideashower.readitlater.util.e.a(localException);
      }
    }
    this.p.b(this);
    this.e = this.p.k();
    if (this.e > 0) {
      com.pocket.gsf.e.a(i.a(com.ideashower.readitlater.h.a.bT, 1));
    }
  }
  
  public int d_()
  {
    d();
    return this.e;
  }
  
  public int e()
  {
    return this.e;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/db/operation/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */