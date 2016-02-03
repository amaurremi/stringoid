package com.amazonaws.http;

import com.amazonaws.org.apache.http.HttpHost;
import com.amazonaws.org.apache.http.HttpRequest;
import com.amazonaws.org.apache.http.HttpRequestInterceptor;
import com.amazonaws.org.apache.http.auth.ChallengeState;
import com.amazonaws.org.apache.http.client.AuthCache;
import com.amazonaws.org.apache.http.impl.auth.BasicScheme;
import com.amazonaws.org.apache.http.impl.client.BasicAuthCache;
import com.amazonaws.org.apache.http.protocol.HttpContext;

class HttpClientFactory$PreemptiveProxyAuth
  implements HttpRequestInterceptor
{
  private final HttpHost proxyHost;
  
  public HttpClientFactory$PreemptiveProxyAuth(HttpHost paramHttpHost)
  {
    this.proxyHost = paramHttpHost;
  }
  
  public void process(HttpRequest paramHttpRequest, HttpContext paramHttpContext)
  {
    paramHttpRequest = new BasicScheme(ChallengeState.PROXY);
    if (paramHttpContext.getAttribute("http.auth.auth-cache") == null)
    {
      BasicAuthCache localBasicAuthCache = new BasicAuthCache();
      localBasicAuthCache.put(this.proxyHost, paramHttpRequest);
      paramHttpContext.setAttribute("http.auth.auth-cache", localBasicAuthCache);
      return;
    }
    ((AuthCache)paramHttpContext.getAttribute("http.auth.auth-cache")).put(this.proxyHost, paramHttpRequest);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/http/HttpClientFactory$PreemptiveProxyAuth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */