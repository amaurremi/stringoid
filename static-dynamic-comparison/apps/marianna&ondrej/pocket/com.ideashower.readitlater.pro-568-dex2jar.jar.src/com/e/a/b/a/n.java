package com.e.a.b.a;

import com.e.a.b;
import com.e.a.b.q;
import com.e.a.m;
import java.net.CacheResponse;
import java.net.SecureCacheResponse;
import java.net.URL;
import javax.net.ssl.SSLSocket;

public final class n
  extends f
{
  private SSLSocket j;
  
  public n(m paramm, r paramr, String paramString, s params, b paramb, v paramv)
  {
    super(paramm, paramr, paramString, params, paramb, paramv);
    if (paramb != null) {}
    for (paramm = (SSLSocket)paramb.c();; paramm = null)
    {
      this.j = paramm;
      return;
    }
  }
  
  protected void a(b paramb)
  {
    this.j = ((SSLSocket)paramb.c());
  }
  
  protected boolean a(CacheResponse paramCacheResponse)
  {
    return paramCacheResponse instanceof SecureCacheResponse;
  }
  
  protected boolean p()
  {
    return false;
  }
  
  protected com.e.a.r s()
  {
    Object localObject2 = this.h.k();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = q();
    }
    localObject2 = this.a.getURL();
    return new com.e.a.r(((URL)localObject2).getHost(), q.a((URL)localObject2), (String)localObject1, this.h.p());
  }
  
  public SSLSocket t()
  {
    return this.j;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/a/b/a/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */