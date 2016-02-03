package com.amazonaws.org.apache.http.impl.client;

import com.amazonaws.org.apache.http.HttpRequest;
import com.amazonaws.org.apache.http.HttpResponse;
import com.amazonaws.org.apache.http.RequestLine;
import com.amazonaws.org.apache.http.client.RedirectHandler;
import com.amazonaws.org.apache.http.client.RedirectStrategy;
import com.amazonaws.org.apache.http.client.methods.HttpGet;
import com.amazonaws.org.apache.http.client.methods.HttpHead;
import com.amazonaws.org.apache.http.client.methods.HttpUriRequest;
import com.amazonaws.org.apache.http.protocol.HttpContext;
import org.apache.http.annotation.Immutable;

@Deprecated
@Immutable
class DefaultRedirectStrategyAdaptor
  implements RedirectStrategy
{
  private final RedirectHandler handler;
  
  public RedirectHandler getHandler()
  {
    return this.handler;
  }
  
  public HttpUriRequest getRedirect(HttpRequest paramHttpRequest, HttpResponse paramHttpResponse, HttpContext paramHttpContext)
  {
    paramHttpResponse = this.handler.getLocationURI(paramHttpResponse, paramHttpContext);
    if (paramHttpRequest.getRequestLine().getMethod().equalsIgnoreCase("HEAD")) {
      return new HttpHead(paramHttpResponse);
    }
    return new HttpGet(paramHttpResponse);
  }
  
  public boolean isRedirected(HttpRequest paramHttpRequest, HttpResponse paramHttpResponse, HttpContext paramHttpContext)
  {
    return this.handler.isRedirectRequested(paramHttpResponse, paramHttpContext);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/client/DefaultRedirectStrategyAdaptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */