package com.amazonaws.org.apache.http.client;

import com.amazonaws.org.apache.http.HttpHost;
import com.amazonaws.org.apache.http.auth.AuthScheme;

public abstract interface AuthCache
{
  public abstract AuthScheme get(HttpHost paramHttpHost);
  
  public abstract void put(HttpHost paramHttpHost, AuthScheme paramAuthScheme);
  
  public abstract void remove(HttpHost paramHttpHost);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/client/AuthCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */