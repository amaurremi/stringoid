package com.ideashower.readitlater.service;

import com.ideashower.readitlater.db.operation.action.UiContext;
import com.ideashower.readitlater.db.operation.action.UiTrigger;
import com.ideashower.readitlater.db.operation.action.b;
import com.ideashower.readitlater.db.operation.j;
import com.ideashower.readitlater.e.e;
import com.ideashower.readitlater.e.o;
import com.ideashower.readitlater.e.x;

public class c
  extends j
{
  private final String p;
  private final int q;
  private final int r;
  
  public c(RespondToShareService paramRespondToShareService, String paramString, int paramInt1, int paramInt2)
  {
    this.p = paramString;
    this.q = paramInt1;
    this.r = paramInt2;
  }
  
  protected void c_()
  {
    e locale = com.ideashower.readitlater.e.r.a(this.r, this.h);
    x localx = locale.j(this.q);
    Object localObject = null;
    if ("share_added".equals(this.p)) {
      localObject = new b(localx, locale, UiContext.a(UiTrigger.C));
    }
    for (;;)
    {
      ((com.ideashower.readitlater.db.operation.action.c)localObject).b(this);
      return;
      if ("share_ignored".equals(this.p)) {
        localObject = new com.ideashower.readitlater.db.operation.action.r(localx, locale, UiContext.a(UiTrigger.C));
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/service/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */