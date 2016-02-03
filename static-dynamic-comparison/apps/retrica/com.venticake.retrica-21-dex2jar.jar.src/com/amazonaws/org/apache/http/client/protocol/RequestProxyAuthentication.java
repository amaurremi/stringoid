package com.amazonaws.org.apache.http.client.protocol;

import com.amazonaws.org.apache.http.HttpRequest;
import com.amazonaws.org.apache.http.auth.AuthState;
import com.amazonaws.org.apache.http.conn.HttpRoutedConnection;
import com.amazonaws.org.apache.http.conn.routing.HttpRoute;
import com.amazonaws.org.apache.http.protocol.HttpContext;
import org.apache.commons.logging.Log;
import org.apache.http.annotation.Immutable;

@Immutable
public class RequestProxyAuthentication
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
    if (paramHttpRequest.containsHeader("Proxy-Authorization")) {}
    do
    {
      return;
      localObject = (HttpRoutedConnection)paramHttpContext.getAttribute("http.connection");
      if (localObject == null)
      {
        this.log.debug("HTTP connection not set in the context");
        return;
      }
    } while (((HttpRoutedConnection)localObject).getRoute().isTunnelled());
    Object localObject = (AuthState)paramHttpContext.getAttribute("http.auth.proxy-scope");
    if (localObject == null)
    {
      this.log.debug("Proxy auth state not set in the context");
      return;
    }
    if (this.log.isDebugEnabled()) {
      this.log.debug("Proxy auth state: " + ((AuthState)localObject).getState());
    }
    process((AuthState)localObject, paramHttpRequest, paramHttpContext);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/client/protocol/RequestProxyAuthentication.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */