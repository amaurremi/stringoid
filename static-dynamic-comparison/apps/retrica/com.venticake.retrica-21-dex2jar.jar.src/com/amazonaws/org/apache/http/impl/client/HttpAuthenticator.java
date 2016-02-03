package com.amazonaws.org.apache.http.impl.client;

import com.amazonaws.org.apache.http.Header;
import com.amazonaws.org.apache.http.HttpHost;
import com.amazonaws.org.apache.http.HttpResponse;
import com.amazonaws.org.apache.http.auth.AuthProtocolState;
import com.amazonaws.org.apache.http.auth.AuthScheme;
import com.amazonaws.org.apache.http.auth.AuthState;
import com.amazonaws.org.apache.http.auth.MalformedChallengeException;
import com.amazonaws.org.apache.http.client.AuthenticationStrategy;
import com.amazonaws.org.apache.http.protocol.HttpContext;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HttpAuthenticator
{
  private final Log log;
  
  public HttpAuthenticator()
  {
    this(null);
  }
  
  public HttpAuthenticator(Log paramLog)
  {
    if (paramLog != null) {}
    for (;;)
    {
      this.log = paramLog;
      return;
      paramLog = LogFactory.getLog(getClass());
    }
  }
  
  public boolean authenticate(HttpHost paramHttpHost, HttpResponse paramHttpResponse, AuthenticationStrategy paramAuthenticationStrategy, AuthState paramAuthState, HttpContext paramHttpContext)
  {
    for (;;)
    {
      Map localMap;
      AuthScheme localAuthScheme;
      try
      {
        if (this.log.isDebugEnabled()) {
          this.log.debug(paramHttpHost.toHostString() + " requested authentication");
        }
        localMap = paramAuthenticationStrategy.getChallenges(paramHttpHost, paramHttpResponse, paramHttpContext);
        if (localMap.isEmpty())
        {
          this.log.debug("Response contains no authentication challenges");
          return false;
        }
        localAuthScheme = paramAuthState.getAuthScheme();
        switch (1.$SwitchMap$org$apache$http$auth$AuthProtocolState[paramAuthState.getState().ordinal()])
        {
        case 3: 
          paramHttpHost = paramAuthenticationStrategy.select(localMap, paramHttpHost, paramHttpResponse, paramHttpContext);
          if ((paramHttpHost == null) || (paramHttpHost.isEmpty())) {
            break label437;
          }
          if (this.log.isDebugEnabled()) {
            this.log.debug("Selected authentication options: " + paramHttpHost);
          }
          paramAuthState.setState(AuthProtocolState.CHALLENGED);
          paramAuthState.update(paramHttpHost);
          return true;
        }
      }
      catch (MalformedChallengeException paramHttpHost)
      {
        if (!this.log.isWarnEnabled()) {
          continue;
        }
        this.log.warn("Malformed challenge: " + paramHttpHost.getMessage());
        paramAuthState.reset();
        return false;
      }
      paramAuthState.reset();
      continue;
      if (localAuthScheme == null)
      {
        this.log.debug("Auth scheme is null");
        paramAuthenticationStrategy.authFailed(paramHttpHost, null, paramHttpContext);
        paramAuthState.reset();
        paramAuthState.setState(AuthProtocolState.FAILURE);
        return false;
      }
      if (localAuthScheme != null)
      {
        Header localHeader = (Header)localMap.get(localAuthScheme.getSchemeName().toLowerCase(Locale.US));
        if (localHeader != null)
        {
          this.log.debug("Authorization challenge processed");
          localAuthScheme.processChallenge(localHeader);
          if (localAuthScheme.isComplete())
          {
            this.log.debug("Authentication failed");
            paramAuthenticationStrategy.authFailed(paramHttpHost, paramAuthState.getAuthScheme(), paramHttpContext);
            paramAuthState.reset();
            paramAuthState.setState(AuthProtocolState.FAILURE);
            return false;
          }
          paramAuthState.setState(AuthProtocolState.HANDSHAKE);
          return true;
        }
        paramAuthState.reset();
        continue;
        label437:
        return false;
      }
    }
    return false;
  }
  
  public boolean isAuthenticationRequested(HttpHost paramHttpHost, HttpResponse paramHttpResponse, AuthenticationStrategy paramAuthenticationStrategy, AuthState paramAuthState, HttpContext paramHttpContext)
  {
    if (paramAuthenticationStrategy.isAuthenticationRequested(paramHttpHost, paramHttpResponse, paramHttpContext))
    {
      this.log.debug("Authentication required");
      return true;
    }
    switch (1.$SwitchMap$org$apache$http$auth$AuthProtocolState[paramAuthState.getState().ordinal()])
    {
    default: 
      paramAuthState.setState(AuthProtocolState.UNCHALLENGED);
    }
    for (;;)
    {
      return false;
      this.log.debug("Authentication succeeded");
      paramAuthState.setState(AuthProtocolState.SUCCESS);
      paramAuthenticationStrategy.authSucceeded(paramHttpHost, paramAuthState.getAuthScheme(), paramHttpContext);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/client/HttpAuthenticator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */