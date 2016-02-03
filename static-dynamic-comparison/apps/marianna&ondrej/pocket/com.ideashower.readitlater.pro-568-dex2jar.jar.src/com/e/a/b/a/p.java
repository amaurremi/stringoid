package com.e.a.b.a;

import com.e.a.m;
import java.net.HttpURLConnection;
import java.net.SecureCacheResponse;
import java.net.URL;

final class p
  extends l
{
  private p(o paramo, URL paramURL, m paramm)
  {
    super(paramURL, paramm);
  }
  
  public HttpURLConnection a()
  {
    return this.d;
  }
  
  public SecureCacheResponse e()
  {
    if ((this.c instanceof n)) {
      return (SecureCacheResponse)this.c.k();
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/a/b/a/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */