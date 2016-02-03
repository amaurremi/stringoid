package com.amazonaws.org.apache.http.client.protocol;

import com.amazonaws.org.apache.http.HttpRequest;
import com.amazonaws.org.apache.http.RequestLine;
import com.amazonaws.org.apache.http.auth.AuthState;
import com.amazonaws.org.apache.http.protocol.HttpContext;
import org.apache.commons.logging.Log;
import org.apache.http.annotation.Immutable;

@Immutable
public class RequestTargetAuthentication
  extends RequestAuthenticationBase
{
  public void process(HttpRequest paramHttpRequest, HttpContext paramHttpContext)
  {
    if (paramHttpRequest == null) {
      throw new IllegalArgumentException("HTTP request may not be null");
    }
    if (paramHttpContext == null) {
      throw new IllegalArgumentException("HTTP context may not be null");
    }
    if (paramHttpRequest.getRequestLine().getMethod().equalsIgnoreCase("CONNECT")) {}
    while (paramHttpRequest.containsHeader("Authorization")) {
      return;
    }
    AuthState localAuthState = (AuthState)paramHttpContext.getAttribute("http.auth.target-scope");
    if (localAuthState == null)
    {
      this.log.debug("Target auth state not set in the context");
      return;
    }
    if (this.log.isDebugEnabled()) {
      this.log.debug("Target auth state: " + localAuthState.getState());
    }
    process(localAuthState, paramHttpRequest, paramHttpContext);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/client/protocol/RequestTargetAuthentication.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */