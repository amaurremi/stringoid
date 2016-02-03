package com.amazonaws.org.apache.http.impl.client;

import com.amazonaws.org.apache.http.FormattedHeader;
import com.amazonaws.org.apache.http.Header;
import com.amazonaws.org.apache.http.HttpHost;
import com.amazonaws.org.apache.http.HttpResponse;
import com.amazonaws.org.apache.http.StatusLine;
import com.amazonaws.org.apache.http.auth.AuthOption;
import com.amazonaws.org.apache.http.auth.AuthScheme;
import com.amazonaws.org.apache.http.auth.AuthSchemeRegistry;
import com.amazonaws.org.apache.http.auth.AuthScope;
import com.amazonaws.org.apache.http.auth.Credentials;
import com.amazonaws.org.apache.http.auth.MalformedChallengeException;
import com.amazonaws.org.apache.http.client.AuthCache;
import com.amazonaws.org.apache.http.client.AuthenticationStrategy;
import com.amazonaws.org.apache.http.client.CredentialsProvider;
import com.amazonaws.org.apache.http.params.HttpParams;
import com.amazonaws.org.apache.http.protocol.HTTP;
import com.amazonaws.org.apache.http.protocol.HttpContext;
import com.amazonaws.org.apache.http.util.CharArrayBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.annotation.Immutable;

@Immutable
class AuthenticationStrategyImpl
  implements AuthenticationStrategy
{
  private static final List<String> DEFAULT_SCHEME_PRIORITY = Collections.unmodifiableList(Arrays.asList(new String[] { "negotiate", "Kerberos", "NTLM", "Digest", "Basic" }));
  private final int challengeCode;
  private final String headerName;
  private final Log log = LogFactory.getLog(getClass());
  private final String prefParamName;
  
  AuthenticationStrategyImpl(int paramInt, String paramString1, String paramString2)
  {
    this.challengeCode = paramInt;
    this.headerName = paramString1;
    this.prefParamName = paramString2;
  }
  
  public void authFailed(HttpHost paramHttpHost, AuthScheme paramAuthScheme, HttpContext paramHttpContext)
  {
    if (paramHttpHost == null) {
      throw new IllegalArgumentException("Host may not be null");
    }
    if (paramHttpContext == null) {
      throw new IllegalArgumentException("HTTP context may not be null");
    }
    paramAuthScheme = (AuthCache)paramHttpContext.getAttribute("http.auth.auth-cache");
    if (paramAuthScheme != null)
    {
      if (this.log.isDebugEnabled()) {
        this.log.debug("Clearing cached auth scheme for " + paramHttpHost);
      }
      paramAuthScheme.remove(paramHttpHost);
    }
  }
  
  public void authSucceeded(HttpHost paramHttpHost, AuthScheme paramAuthScheme, HttpContext paramHttpContext)
  {
    if (paramHttpHost == null) {
      throw new IllegalArgumentException("Host may not be null");
    }
    if (paramAuthScheme == null) {
      throw new IllegalArgumentException("Auth scheme may not be null");
    }
    if (paramHttpContext == null) {
      throw new IllegalArgumentException("HTTP context may not be null");
    }
    if (isCachable(paramAuthScheme))
    {
      AuthCache localAuthCache = (AuthCache)paramHttpContext.getAttribute("http.auth.auth-cache");
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
    if (paramHttpResponse == null) {
      throw new IllegalArgumentException("HTTP response may not be null");
    }
    paramHttpResponse = paramHttpResponse.getHeaders(this.headerName);
    paramHttpContext = new HashMap(paramHttpResponse.length);
    int m = paramHttpResponse.length;
    int j = 0;
    while (j < m)
    {
      Object localObject = paramHttpResponse[j];
      int i;
      if ((localObject instanceof FormattedHeader))
      {
        paramHttpHost = ((FormattedHeader)localObject).getBuffer();
        i = ((FormattedHeader)localObject).getValuePos();
      }
      while ((i < paramHttpHost.length()) && (HTTP.isWhitespace(paramHttpHost.charAt(i))))
      {
        i += 1;
        continue;
        String str = ((Header)localObject).getValue();
        if (str == null) {
          throw new MalformedChallengeException("Header value is null");
        }
        paramHttpHost = new CharArrayBuffer(str.length());
        paramHttpHost.append(str);
        i = 0;
      }
      int k = i;
      while ((k < paramHttpHost.length()) && (!HTTP.isWhitespace(paramHttpHost.charAt(k)))) {
        k += 1;
      }
      paramHttpContext.put(paramHttpHost.substring(i, k).toLowerCase(Locale.US), localObject);
      j += 1;
    }
    return paramHttpContext;
  }
  
  public boolean isAuthenticationRequested(HttpHost paramHttpHost, HttpResponse paramHttpResponse, HttpContext paramHttpContext)
  {
    if (paramHttpResponse == null) {
      throw new IllegalArgumentException("HTTP response may not be null");
    }
    return paramHttpResponse.getStatusLine().getStatusCode() == this.challengeCode;
  }
  
  protected boolean isCachable(AuthScheme paramAuthScheme)
  {
    if ((paramAuthScheme == null) || (!paramAuthScheme.isComplete())) {}
    do
    {
      return false;
      paramAuthScheme = paramAuthScheme.getSchemeName();
    } while ((!paramAuthScheme.equalsIgnoreCase("Basic")) && (!paramAuthScheme.equalsIgnoreCase("Digest")));
    return true;
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
    AuthSchemeRegistry localAuthSchemeRegistry = (AuthSchemeRegistry)paramHttpContext.getAttribute("http.authscheme-registry");
    if (localAuthSchemeRegistry == null)
    {
      this.log.debug("Auth scheme registry not set in the context");
      return localLinkedList;
    }
    CredentialsProvider localCredentialsProvider = (CredentialsProvider)paramHttpContext.getAttribute("http.auth.credentials-provider");
    if (localCredentialsProvider == null)
    {
      this.log.debug("Credentials provider not set in the context");
      return localLinkedList;
    }
    Object localObject1 = (List)paramHttpResponse.getParams().getParameter(this.prefParamName);
    paramHttpContext = (HttpContext)localObject1;
    if (localObject1 == null) {
      paramHttpContext = DEFAULT_SCHEME_PRIORITY;
    }
    if (this.log.isDebugEnabled()) {
      this.log.debug("Authentication schemes in the order of preference: " + paramHttpContext);
    }
    paramHttpContext = paramHttpContext.iterator();
    while (paramHttpContext.hasNext())
    {
      localObject1 = (String)paramHttpContext.next();
      Object localObject2 = (Header)paramMap.get(((String)localObject1).toLowerCase(Locale.US));
      if (localObject2 != null)
      {
        try
        {
          AuthScheme localAuthScheme = localAuthSchemeRegistry.getAuthScheme((String)localObject1, paramHttpResponse.getParams());
          localAuthScheme.processChallenge((Header)localObject2);
          localObject2 = localCredentialsProvider.getCredentials(new AuthScope(paramHttpHost.getHostName(), paramHttpHost.getPort(), localAuthScheme.getRealm(), localAuthScheme.getSchemeName()));
          if (localObject2 == null) {
            continue;
          }
          localLinkedList.add(new AuthOption(localAuthScheme, (Credentials)localObject2));
        }
        catch (IllegalStateException localIllegalStateException) {}
        if (this.log.isWarnEnabled()) {
          this.log.warn("Authentication scheme " + (String)localObject1 + " not supported");
        }
      }
      else if (this.log.isDebugEnabled())
      {
        this.log.debug("Challenge for " + (String)localObject1 + " authentication scheme not available");
      }
    }
    return localLinkedList;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/client/AuthenticationStrategyImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */