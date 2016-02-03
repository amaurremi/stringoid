package com.amazonaws.org.apache.http.impl.client;

import com.amazonaws.org.apache.http.HttpHost;
import com.amazonaws.org.apache.http.auth.AuthScheme;
import com.amazonaws.org.apache.http.client.AuthCache;
import java.util.HashMap;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class BasicAuthCache
  implements AuthCache
{
  private final HashMap<HttpHost, AuthScheme> map = new HashMap();
  
  public AuthScheme get(HttpHost paramHttpHost)
  {
    if (paramHttpHost == null) {
      throw new IllegalArgumentException("HTTP host may not be null");
    }
    return (AuthScheme)this.map.get(getKey(paramHttpHost));
  }
  
  protected HttpHost getKey(HttpHost paramHttpHost)
  {
    HttpHost localHttpHost = paramHttpHost;
    if (paramHttpHost.getPort() <= 0) {
      if (!paramHttpHost.getSchemeName().equalsIgnoreCase("https")) {
        break label44;
      }
    }
    label44:
    for (int i = 443;; i = 80)
    {
      localHttpHost = new HttpHost(paramHttpHost.getHostName(), i, paramHttpHost.getSchemeName());
      return localHttpHost;
    }
  }
  
  public void put(HttpHost paramHttpHost, AuthScheme paramAuthScheme)
  {
    if (paramHttpHost == null) {
      throw new IllegalArgumentException("HTTP host may not be null");
    }
    this.map.put(getKey(paramHttpHost), paramAuthScheme);
  }
  
  public void remove(HttpHost paramHttpHost)
  {
    if (paramHttpHost == null) {
      throw new IllegalArgumentException("HTTP host may not be null");
    }
    this.map.remove(getKey(paramHttpHost));
  }
  
  public String toString()
  {
    return this.map.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/client/BasicAuthCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */