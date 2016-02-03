package com.google.api.client.http;

public final class r
{
  private final w ZP;
  private final s abH;
  
  r(w paramw, s params)
  {
    this.ZP = paramw;
    this.abH = params;
  }
  
  public q a(i parami, j paramj)
  {
    return a("PUT", parami, paramj);
  }
  
  public q a(String paramString, i parami, j paramj)
  {
    q localq = this.ZP.xT();
    if (this.abH != null) {
      this.abH.a(localq);
    }
    localq.cf(paramString);
    if (parami != null) {
      localq.e(parami);
    }
    if (paramj != null) {
      localq.c(paramj);
    }
    return localq;
  }
  
  public q f(i parami)
  {
    return a("GET", parami, null);
  }
  
  public s xK()
  {
    return this.abH;
  }
  
  public w xx()
  {
    return this.ZP;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/http/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */