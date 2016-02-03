package com.amazonaws.org.apache.http.client;

import com.amazonaws.org.apache.http.Header;
import com.amazonaws.org.apache.http.HttpResponse;
import com.amazonaws.org.apache.http.auth.AuthScheme;
import com.amazonaws.org.apache.http.protocol.HttpContext;
import java.util.Map;

@Deprecated
public abstract interface AuthenticationHandler
{
  public abstract Map<String, Header> getChallenges(HttpResponse paramHttpResponse, HttpContext paramHttpContext);
  
  public abstract boolean isAuthenticationRequested(HttpResponse paramHttpResponse, HttpContext paramHttpContext);
  
  public abstract AuthScheme selectScheme(Map<String, Header> paramMap, HttpResponse paramHttpResponse, HttpContext paramHttpContext);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/client/AuthenticationHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */