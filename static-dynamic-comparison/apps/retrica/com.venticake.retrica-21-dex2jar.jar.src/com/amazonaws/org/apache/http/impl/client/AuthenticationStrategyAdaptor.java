package com.amazonaws.org.apache.http.impl.client;

import com.amazonaws.org.apache.http.Header;
import com.amazonaws.org.apache.http.HttpHost;
import com.amazonaws.org.apache.http.HttpResponse;
import com.amazonaws.org.apache.http.auth.AuthOption;
import com.amazonaws.org.apache.http.auth.AuthScheme;
import com.amazonaws.org.apache.http.auth.AuthScope;
import com.amazonaws.org.apache.http.auth.AuthenticationException;
import com.amazonaws.org.apache.http.client.AuthCache;
import com.amazonaws.org.apache.http.client.AuthenticationHandler;
import com.amazonaws.org.apache.http.client.AuthenticationStrategy;
import com.amazonaws.org.apache.http.client.CredentialsProvider;
import com.amazonaws.org.apache.http.protocol.HttpContext;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import org.apache.commons.logging.Log;
import org.apache.http.annotation.Immutable;

@Deprecated
@Immutable
class AuthenticationStrategyAdaptor
  implements AuthenticationStrategy
{
  private final AuthenticationHandler handler;
  private final Log log;
  
  private boolean isCachable(AuthScheme paramAuthScheme)
  {
    if ((paramAuthScheme == null) || (!paramAuthScheme.isComplete())) {}
    do
    {
      return false;
      paramAuthScheme = paramAuthScheme.getSchemeName();
    } while ((!paramAuthScheme.equalsIgnoreCase("Basic")) && (!paramAuthScheme.equalsIgnoreCase("Digest")));
    return true;
  }
  
  public void authFailed(HttpHost paramHttpHost, AuthScheme paramAuthScheme, HttpContext paramHttpContext)
  {
    paramHttpContext = (AuthCache)paramHttpContext.getAttribute("http.auth.auth-cache");
    if (paramHttpContext == null) {
      return;
    }
    if (this.log.isDebugEnabled()) {
      this.log.debug("Removing from cache '" + paramAuthScheme.getSchemeName() + "' auth scheme for " + paramHttpHost);
    }
    paramHttpContext.remove(paramHttpHost);
  }
  
  public void authSucceeded(HttpHost paramHttpHost, AuthScheme paramAuthScheme, HttpContext paramHttpContext)
  {
    AuthCache localAuthCache = (AuthCache)paramHttpContext.getAttribute("http.auth.auth-cache");
    if (isCachable(paramAuthScheme))
    {
      Object localObject = localAuthCache;
      if (localAuthCache == null)
      {
        localObject = new BasicAuthCache();
        paramHttpContext.setAttribute("http.auth.auth-cache", localObject);
      }
      if (this.log.isDebugEnabled()) {
        this.log.debug("Caching '" + paramAuthScheme.getSchemeName() + "' auth scheme for " + paramHttpHost);
      }
      ((AuthCache)localObject).put(paramHttpHost, paramAuthScheme);
    }
  }
  
  public Map<String, Header> getChallenges(HttpHost paramHttpHost, HttpResponse paramHttpResponse, HttpContext paramHttpContext)
  {
    return this.handler.getChallenges(paramHttpResponse, paramHttpContext);
  }
  
  public AuthenticationHandler getHandler()
  {
    return this.handler;
  }
  
  public boolean isAuthenticationRequested(HttpHost paramHttpHost, HttpResponse paramHttpResponse, HttpContext paramHttpContext)
  {
    return this.handler.isAuthenticationRequested(paramHttpResponse, paramHttpContext);
  }
  
  public Queue<AuthOption> select(Map<String, Header> paramMap, HttpHost paramHttpHost, HttpResponse paramHttpResponse, HttpContext paramHttpContext)
  {
    if (paramMap == null) {
      throw new IllegalArgumentException("Map of auth challenges may not be null");
    }
    if (paramHttpHost == null) {
      throw new IllegalArgumentException("Host may not be null");
    }
    if (paramHttpResponse == null) {
      throw new IllegalArgumentException("HTTP response may not be null");
    }
    if (paramHttpContext == null) {
      throw new IllegalArgumentException("HTTP context may not be null");
    }
    LinkedList localLinkedList = new LinkedList();
    CredentialsProvider localCredentialsProvider = (CredentialsProvider)paramHttpContext.getAttribute("http.auth.credentials-provider");
    if (localCredentialsProvider == null)
    {
      this.log.debug("Credentials provider not set in the context");
      return localLinkedList;
    }
    try
    {
      paramHttpResponse = this.handler.selectScheme(paramMap, paramHttpResponse, paramHttpContext);
      paramHttpResponse.processChallenge((Header)paramMap.get(paramHttpResponse.getSchemeName().toLowerCase(Locale.US)));
      paramMap = localCredentialsProvider.getCredentials(new AuthScope(paramHttpHost.getHostName(), paramHttpHost.getPort(), paramHttpResponse.getRealm(), paramHttpResponse.getSchemeName()));
      if (paramMap != null) {
        localLinkedList.add(new AuthOption(paramHttpResponse, paramMap));
      }
      return localLinkedList;
    }
    catch (AuthenticationException paramMap)
    {
      if (this.log.isWarnEnabled()) {
        this.log.warn(paramMap.getMessage(), paramMap);
      }
    }
    return localLinkedList;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/client/AuthenticationStrategyAdaptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */