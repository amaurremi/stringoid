package com.e.a;

import java.net.CacheRequest;
import java.net.CacheResponse;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URLConnection;
import java.util.Map;

public abstract interface n
{
  public abstract CacheRequest a(URI paramURI, URLConnection paramURLConnection);
  
  public abstract CacheResponse a(URI paramURI, String paramString, Map paramMap);
  
  public abstract void a();
  
  public abstract void a(o paramo);
  
  public abstract void a(String paramString, URI paramURI);
  
  public abstract void a(CacheResponse paramCacheResponse, HttpURLConnection paramHttpURLConnection);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/a/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */