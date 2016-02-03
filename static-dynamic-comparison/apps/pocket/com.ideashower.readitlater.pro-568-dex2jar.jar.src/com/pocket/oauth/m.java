package com.pocket.oauth;

import b.a.a.a;
import b.a.a.b;

class m
  extends com.ideashower.readitlater.g.m
{
  private final a b;
  private final b c;
  private final String d;
  private String e;
  
  private m(k paramk, a parama, b paramb, String paramString)
  {
    this.b = parama;
    this.c = paramb;
    this.d = paramString;
  }
  
  protected void a()
  {
    this.e = this.c.a(this.b, this.d, new String[0]);
  }
  
  protected void a(boolean paramBoolean, Throwable paramThrowable)
  {
    if ((paramBoolean) && (this.e != null))
    {
      this.a.a(this.e);
      return;
    }
    this.a.a(paramThrowable);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/oauth/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */