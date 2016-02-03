package com.amazonaws.org.apache.http.client.protocol;

import com.amazonaws.org.apache.http.HttpHost;
import com.amazonaws.org.apache.http.HttpRequest;
import com.amazonaws.org.apache.http.HttpRequestInterceptor;
import com.amazonaws.org.apache.http.auth.AuthProtocolState;
import com.amazonaws.org.apache.http.auth.AuthScheme;
import com.amazonaws.org.apache.http.auth.AuthScope;
import com.amazonaws.org.apache.http.auth.AuthState;
import com.amazonaws.org.apache.http.client.AuthCache;
import com.amazonaws.org.apache.http.client.CredentialsProvider;
import com.amazonaws.org.apache.http.conn.scheme.Scheme;
import com.amazonaws.org.apache.http.conn.scheme.SchemeRegistry;
import com.amazonaws.org.apache.http.protocol.HttpContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.annotation.Immutable;

@Immutable
public class RequestAuthCache
  implements HttpRequestInterceptor
{
  private final Log log = LogFactory.getLog(getClass());
  
  private void doPreemptiveAuth(HttpHost paramHttpHost, AuthScheme paramAuthScheme, AuthState paramAuthState, CredentialsProvider paramCredentialsProvider)
  {
    String str = paramAuthScheme.getSchemeName();
    if (this.log.isDebugEnabled()) {
      this.log.debug("Re-using cached '" + str + "' auth scheme for " + paramHttpHost);
    }
    paramHttpHost = paramCredentialsProvider.getCredentials(new AuthScope(paramHttpHost, AuthScope.ANY_REALM, str));
    if (paramHttpHost != null)
    {
      if ("BASIC".equalsIgnoreCase(paramAuthScheme.getSchemeName())) {
        paramAuthState.setState(AuthProtocolState.CHALLENGED);
      }
      for (;;)
      {
        paramAuthState.update(paramAuthScheme, paramHttpHost);
        return;
        paramAuthState.setState(AuthProtocolState.SUCCESS);
      }
    }
    this.log.debug("No credentials for preemptive authentication");
  }
  
  public void process(HttpRequest paramHttpRequest, HttpContext paramHttpContext)
  {
    if (paramHttpRequest == null) {
      throw new IllegalArgumentException("HTTP request may not be null");
    }
    if (paramHttpContext == null) {
      throw new IllegalArgumentException("HTTP context may not be null");
    }
    Object localObject1 = (AuthCache)paramHttpContext.getAttribute("http.auth.auth-cache");
    if (localObject1 == null)
    {
      this.log.debug("Auth cache not set in the context");
      return;
    }
    CredentialsProvider localCredentialsProvider = (CredentialsProvider)paramHttpContext.getAttribute("http.auth.credentials-provider");
    if (localCredentialsProvider == null)
    {
      this.log.debug("Credentials provider not set in the context");
      return;
    }
    paramHttpRequest = (HttpHost)paramHttpContext.getAttribute("http.target_host");
    Object localObject2;
    if (paramHttpRequest.getPort() < 0)
    {
      localObject2 = ((SchemeRegistry)paramHttpContext.getAttribute("http.scheme-registry")).getScheme(paramHttpRequest);
      paramHttpRequest = new HttpHost(paramHttpRequest.getHostName(), ((Scheme)localObject2).resolvePort(paramHttpRequest.getPort()), paramHttpRequest.getSchemeName());
    }
    for (;;)
    {
      localObject2 = (AuthState)paramHttpContext.getAttribute("http.auth.target-scope");
      if ((paramHttpRequest != null) && (localObject2 != null) && (((AuthState)localObject2).getState() == AuthProtocolState.UNCHALLENGED))
      {
        AuthScheme localAuthScheme = ((AuthCache)localObject1).get(paramHttpRequest);
        if (localAuthScheme != null) {
          doPreemptiveAuth(paramHttpRequest, localAuthScheme, (AuthState)localObject2, localCredentialsProvider);
        }
      }
      paramHttpRequest = (HttpHost)paramHttpContext.getAttribute("http.proxy_host");
      paramHttpContext = (AuthState)paramHttpContext.getAttribute("http.auth.proxy-scope");
      if ((paramHttpRequest == null) || (paramHttpContext == null) || (paramHttpContext.getState() != AuthProtocolState.UNCHALLENGED)) {
        break;
      }
      localObject1 = ((AuthCache)localObject1).get(paramHttpRequest);
      if (localObject1 == null) {
        break;
      }
      doPreemptiveAuth(paramHttpRequest, (AuthScheme)localObject1, paramHttpContext, localCredentialsProvider);
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/client/protocol/RequestAuthCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */