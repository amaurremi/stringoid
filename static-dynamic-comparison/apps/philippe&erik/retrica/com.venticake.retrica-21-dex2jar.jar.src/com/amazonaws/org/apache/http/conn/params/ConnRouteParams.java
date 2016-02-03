package com.amazonaws.org.apache.http.conn.params;

import com.amazonaws.org.apache.http.HttpHost;
import com.amazonaws.org.apache.http.conn.routing.HttpRoute;
import com.amazonaws.org.apache.http.params.HttpParams;
import java.net.InetAddress;
import org.apache.http.annotation.Immutable;

@Immutable
public class ConnRouteParams
{
  public static final HttpHost NO_HOST = new HttpHost("127.0.0.255", 0, "no-host");
  public static final HttpRoute NO_ROUTE = new HttpRoute(NO_HOST);
  
  public static HttpHost getDefaultProxy(HttpParams paramHttpParams)
  {
    if (paramHttpParams == null) {
      throw new IllegalArgumentException("Parameters must not be null.");
    }
    HttpHost localHttpHost = (HttpHost)paramHttpParams.getParameter("http.route.default-proxy");
    paramHttpParams = localHttpHost;
    if (localHttpHost != null)
    {
      paramHttpParams = localHttpHost;
      if (NO_HOST.equals(localHttpHost)) {
        paramHttpParams = null;
      }
    }
    return paramHttpParams;
  }
  
  public static HttpRoute getForcedRoute(HttpParams paramHttpParams)
  {
    if (paramHttpParams == null) {
      throw new IllegalArgumentException("Parameters must not be null.");
    }
    HttpRoute localHttpRoute = (HttpRoute)paramHttpParams.getParameter("http.route.forced-route");
    paramHttpParams = localHttpRoute;
    if (localHttpRoute != null)
    {
      paramHttpParams = localHttpRoute;
      if (NO_ROUTE.equals(localHttpRoute)) {
        paramHttpParams = null;
      }
    }
    return paramHttpParams;
  }
  
  public static InetAddress getLocalAddress(HttpParams paramHttpParams)
  {
    if (paramHttpParams == null) {
      throw new IllegalArgumentException("Parameters must not be null.");
    }
    return (InetAddress)paramHttpParams.getParameter("http.route.local-address");
  }
  
  public static void setLocalAddress(HttpParams paramHttpParams, InetAddress paramInetAddress)
  {
    if (paramHttpParams == null) {
      throw new IllegalArgumentException("Parameters must not be null.");
    }
    paramHttpParams.setParameter("http.route.local-address", paramInetAddress);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/conn/params/ConnRouteParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */