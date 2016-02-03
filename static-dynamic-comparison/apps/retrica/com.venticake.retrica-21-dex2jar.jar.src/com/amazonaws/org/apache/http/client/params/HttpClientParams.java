package com.amazonaws.org.apache.http.client.params;

import com.amazonaws.org.apache.http.params.HttpConnectionParams;
import com.amazonaws.org.apache.http.params.HttpParams;
import org.apache.http.annotation.Immutable;

@Immutable
public class HttpClientParams
{
  public static long getConnectionManagerTimeout(HttpParams paramHttpParams)
  {
    if (paramHttpParams == null) {
      throw new IllegalArgumentException("HTTP parameters may not be null");
    }
    Long localLong = (Long)paramHttpParams.getParameter("http.conn-manager.timeout");
    if (localLong != null) {
      return localLong.longValue();
    }
    return HttpConnectionParams.getConnectionTimeout(paramHttpParams);
  }
  
  public static String getCookiePolicy(HttpParams paramHttpParams)
  {
    if (paramHttpParams == null) {
      throw new IllegalArgumentException("HTTP parameters may not be null");
    }
    String str = (String)paramHttpParams.getParameter("http.protocol.cookie-policy");
    paramHttpParams = str;
    if (str == null) {
      paramHttpParams = "best-match";
    }
    return paramHttpParams;
  }
  
  public static boolean isAuthenticating(HttpParams paramHttpParams)
  {
    if (paramHttpParams == null) {
      throw new IllegalArgumentException("HTTP parameters may not be null");
    }
    return paramHttpParams.getBooleanParameter("http.protocol.handle-authentication", true);
  }
  
  public static boolean isRedirecting(HttpParams paramHttpParams)
  {
    if (paramHttpParams == null) {
      throw new IllegalArgumentException("HTTP parameters may not be null");
    }
    return paramHttpParams.getBooleanParameter("http.protocol.handle-redirects", true);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/client/params/HttpClientParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */