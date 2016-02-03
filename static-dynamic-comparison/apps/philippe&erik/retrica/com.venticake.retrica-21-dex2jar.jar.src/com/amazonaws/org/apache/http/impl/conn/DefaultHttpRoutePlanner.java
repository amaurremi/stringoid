package com.amazonaws.org.apache.http.impl.conn;

import com.amazonaws.org.apache.http.HttpException;
import com.amazonaws.org.apache.http.HttpHost;
import com.amazonaws.org.apache.http.HttpRequest;
import com.amazonaws.org.apache.http.conn.params.ConnRouteParams;
import com.amazonaws.org.apache.http.conn.routing.HttpRoute;
import com.amazonaws.org.apache.http.conn.routing.HttpRoutePlanner;
import com.amazonaws.org.apache.http.conn.scheme.Scheme;
import com.amazonaws.org.apache.http.conn.scheme.SchemeRegistry;
import com.amazonaws.org.apache.http.protocol.HttpContext;
import org.apache.http.annotation.ThreadSafe;

@ThreadSafe
public class DefaultHttpRoutePlanner
  implements HttpRoutePlanner
{
  protected final SchemeRegistry schemeRegistry;
  
  public DefaultHttpRoutePlanner(SchemeRegistry paramSchemeRegistry)
  {
    if (paramSchemeRegistry == null) {
      throw new IllegalArgumentException("SchemeRegistry must not be null.");
    }
    this.schemeRegistry = paramSchemeRegistry;
  }
  
  public HttpRoute determineRoute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, HttpContext paramHttpContext)
  {
    if (paramHttpRequest == null) {
      throw new IllegalStateException("Request must not be null.");
    }
    paramHttpContext = ConnRouteParams.getForcedRoute(paramHttpRequest.getParams());
    if (paramHttpContext != null) {
      return paramHttpContext;
    }
    if (paramHttpHost == null) {
      throw new IllegalStateException("Target host must not be null.");
    }
    paramHttpContext = ConnRouteParams.getLocalAddress(paramHttpRequest.getParams());
    paramHttpRequest = ConnRouteParams.getDefaultProxy(paramHttpRequest.getParams());
    boolean bool;
    try
    {
      Scheme localScheme = this.schemeRegistry.getScheme(paramHttpHost.getSchemeName());
      bool = localScheme.isLayered();
      if (paramHttpRequest == null) {
        return new HttpRoute(paramHttpHost, paramHttpContext, bool);
      }
    }
    catch (IllegalStateException paramHttpHost)
    {
      throw new HttpException(paramHttpHost.getMessage());
    }
    return new HttpRoute(paramHttpHost, paramHttpContext, paramHttpRequest, bool);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/conn/DefaultHttpRoutePlanner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */