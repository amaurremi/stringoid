package com.e.a.b.a;

import com.e.a.n;
import com.e.a.o;
import java.net.CacheRequest;
import java.net.CacheResponse;
import java.net.HttpURLConnection;
import java.net.ResponseCache;
import java.net.URI;
import java.net.URLConnection;
import java.util.Map;

public final class q
  implements n
{
  private final ResponseCache a;
  
  public q(ResponseCache paramResponseCache)
  {
    this.a = paramResponseCache;
  }
  
  public CacheRequest a(URI paramURI, URLConnection paramURLConnection)
  {
    return this.a.put(paramURI, paramURLConnection);
  }
  
  public CacheResponse a(URI paramURI, String paramString, Map paramMap)
  {
    return this.a.get(paramURI, paramString, paramMap);
  }
  
  public void a() {}
  
  public void a(o paramo) {}
  
  public void a(String paramString, URI paramURI) {}
  
  public void a(CacheResponse paramCacheResponse, HttpURLConnection paramHttpURLConnection) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/a/b/a/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */