package com.amazonaws.org.apache.http.impl.client;

import com.amazonaws.org.apache.http.conn.routing.HttpRoute;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class RoutedRequest
{
  protected final RequestWrapper request;
  protected final HttpRoute route;
  
  public RoutedRequest(RequestWrapper paramRequestWrapper, HttpRoute paramHttpRoute)
  {
    this.request = paramRequestWrapper;
    this.route = paramHttpRoute;
  }
  
  public final RequestWrapper getRequest()
  {
    return this.request;
  }
  
  public final HttpRoute getRoute()
  {
    return this.route;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/client/RoutedRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */