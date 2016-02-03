package com.e.a;

import com.e.a.b.a.s;
import java.io.InputStream;
import java.net.CacheResponse;
import java.util.Map;

class h
  extends CacheResponse
{
  private final g a;
  private final com.e.a.b.g b;
  private final InputStream c;
  
  public h(g paramg, com.e.a.b.g paramg1)
  {
    this.a = paramg;
    this.b = paramg1;
    this.c = e.a(paramg1);
  }
  
  public InputStream getBody()
  {
    return this.c;
  }
  
  public Map getHeaders()
  {
    return g.b(this.a).a(true);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */