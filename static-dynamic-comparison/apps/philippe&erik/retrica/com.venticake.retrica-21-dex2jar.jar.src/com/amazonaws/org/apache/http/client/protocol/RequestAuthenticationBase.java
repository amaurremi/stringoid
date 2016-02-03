package com.amazonaws.org.apache.http.client.protocol;

import com.amazonaws.org.apache.http.Header;
import com.amazonaws.org.apache.http.HttpRequest;
import com.amazonaws.org.apache.http.HttpRequestInterceptor;
import com.amazonaws.org.apache.http.auth.AuthOption;
import com.amazonaws.org.apache.http.auth.AuthScheme;
import com.amazonaws.org.apache.http.auth.AuthState;
import com.amazonaws.org.apache.http.auth.AuthenticationException;
import com.amazonaws.org.apache.http.auth.ContextAwareAuthScheme;
import com.amazonaws.org.apache.http.auth.Credentials;
import com.amazonaws.org.apache.http.protocol.HttpContext;
import java.util.Queue;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

abstract class RequestAuthenticationBase
  implements HttpRequestInterceptor
{
  final Log log = LogFactory.getLog(getClass());
  
  private Header authenticate(AuthScheme paramAuthScheme, Credentials paramCredentials, HttpRequest paramHttpRequest, HttpContext paramHttpContext)
  {
    if (paramAuthScheme == null) {
      throw new IllegalStateException("Auth state object is null");
    }
    if ((paramAuthScheme instanceof ContextAwareAuthScheme)) {
      return ((ContextAwareAuthScheme)paramAuthScheme).authenticate(paramCredentials, paramHttpRequest, paramHttpContext);
    }
    return paramAuthScheme.authenticate(paramCredentials, paramHttpRequest);
  }
  
  private void ensureAuthScheme(AuthScheme paramAuthScheme)
  {
    if (paramAuthScheme == null) {
      throw new IllegalStateException("Auth scheme is not set");
    }
  }
  
  void process(AuthState paramAuthState, HttpRequest paramHttpRequest, HttpContext paramHttpContext)
  {
    AuthScheme localAuthScheme = paramAuthState.getAuthScheme();
    Object localObject = paramAuthState.getCredentials();
    switch (1.$SwitchMap$org$apache$http$auth$AuthProtocolState[paramAuthState.getState().ordinal()])
    {
    }
    for (;;)
    {
      if (localAuthScheme != null) {}
      try
      {
        paramHttpRequest.addHeader(authenticate(localAuthScheme, (Credentials)localObject, paramHttpRequest, paramHttpContext));
        for (;;)
        {
          return;
          ensureAuthScheme(localAuthScheme);
          if (!localAuthScheme.isConnectionBased()) {
            break;
          }
          return;
          Queue localQueue = paramAuthState.getAuthOptions();
          if (localQueue == null) {
            break label264;
          }
          while (!localQueue.isEmpty())
          {
            localObject = (AuthOption)localQueue.remove();
            localAuthScheme = ((AuthOption)localObject).getAuthScheme();
            localObject = ((AuthOption)localObject).getCredentials();
            paramAuthState.update(localAuthScheme, (Credentials)localObject);
            if (this.log.isDebugEnabled()) {
              this.log.debug("Generating response to an authentication challenge using " + localAuthScheme.getSchemeName() + " scheme");
            }
            try
            {
              paramHttpRequest.addHeader(authenticate(localAuthScheme, (Credentials)localObject, paramHttpRequest, paramHttpContext));
              return;
            }
            catch (AuthenticationException localAuthenticationException) {}
            if (this.log.isWarnEnabled()) {
              this.log.warn(localAuthScheme + " authentication error: " + localAuthenticationException.getMessage());
            }
          }
        }
        label264:
        ensureAuthScheme(localAuthScheme);
      }
      catch (AuthenticationException paramAuthState)
      {
        while (!this.log.isErrorEnabled()) {}
        this.log.error(localAuthScheme + " authentication error: " + paramAuthState.getMessage());
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/client/protocol/RequestAuthenticationBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */