package com.amazonaws.org.apache.http.impl.client;

import com.amazonaws.org.apache.http.auth.AuthScheme;
import com.amazonaws.org.apache.http.auth.AuthState;
import com.amazonaws.org.apache.http.auth.Credentials;
import com.amazonaws.org.apache.http.client.UserTokenHandler;
import com.amazonaws.org.apache.http.conn.HttpRoutedConnection;
import com.amazonaws.org.apache.http.protocol.HttpContext;
import java.security.Principal;
import javax.net.ssl.SSLSession;
import org.apache.http.annotation.Immutable;

@Immutable
public class DefaultUserTokenHandler
  implements UserTokenHandler
{
  private static Principal getAuthPrincipal(AuthState paramAuthState)
  {
    AuthScheme localAuthScheme = paramAuthState.getAuthScheme();
    if ((localAuthScheme != null) && (localAuthScheme.isComplete()) && (localAuthScheme.isConnectionBased()))
    {
      paramAuthState = paramAuthState.getCredentials();
      if (paramAuthState != null) {
        return paramAuthState.getUserPrincipal();
      }
    }
    return null;
  }
  
  public Object getUserToken(HttpContext paramHttpContext)
  {
    Object localObject1 = null;
    Object localObject2 = (AuthState)paramHttpContext.getAttribute("http.auth.target-scope");
    if (localObject2 != null)
    {
      localObject2 = getAuthPrincipal((AuthState)localObject2);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = getAuthPrincipal((AuthState)paramHttpContext.getAttribute("http.auth.proxy-scope"));
      }
    }
    if (localObject1 == null)
    {
      paramHttpContext = (HttpRoutedConnection)paramHttpContext.getAttribute("http.connection");
      if (paramHttpContext.isOpen())
      {
        paramHttpContext = paramHttpContext.getSSLSession();
        if (paramHttpContext != null) {
          return paramHttpContext.getLocalPrincipal();
        }
      }
    }
    return localObject1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/client/DefaultUserTokenHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */