package com.amazonaws.org.apache.http.client;

import com.amazonaws.org.apache.http.HttpResponse;
import com.amazonaws.org.apache.http.protocol.HttpContext;
import java.net.URI;

@Deprecated
public abstract interface RedirectHandler
{
  public abstract URI getLocationURI(HttpResponse paramHttpResponse, HttpContext paramHttpContext);
  
  public abstract boolean isRedirectRequested(HttpResponse paramHttpResponse, HttpContext paramHttpContext);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/client/RedirectHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */