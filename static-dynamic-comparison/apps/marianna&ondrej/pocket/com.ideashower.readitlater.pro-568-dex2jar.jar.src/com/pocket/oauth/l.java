package com.pocket.oauth;

import b.a.a.a;
import b.a.a.b;
import com.ideashower.readitlater.g.m;

class l
  extends m
{
  private final a b;
  private final b c;
  private final String d;
  private String e;
  private String f;
  
  private l(k paramk, a parama, b paramb, String paramString)
  {
    this.b = parama;
    this.c = paramb;
    this.d = paramString;
  }
  
  protected void a()
  {
    this.c.b(this.b, this.d, new String[0]);
    this.e = this.b.a();
    this.f = this.b.b();
    this.b.a(this.e, this.f);
  }
  
  protected void a(boolean paramBoolean, Throwable paramThrowable)
  {
    if ((paramBoolean) && (this.e != null) && (this.f != null))
    {
      this.a.a(this.e, this.f);
      return;
    }
    this.a.b(paramThrowable);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/oauth/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */