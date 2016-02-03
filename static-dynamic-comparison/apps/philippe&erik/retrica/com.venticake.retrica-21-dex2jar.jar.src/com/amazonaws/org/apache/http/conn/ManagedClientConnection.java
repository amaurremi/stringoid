package com.amazonaws.org.apache.http.conn;

import com.amazonaws.org.apache.http.HttpClientConnection;
import com.amazonaws.org.apache.http.HttpHost;
import com.amazonaws.org.apache.http.conn.routing.HttpRoute;
import com.amazonaws.org.apache.http.params.HttpParams;
import com.amazonaws.org.apache.http.protocol.HttpContext;
import java.util.concurrent.TimeUnit;

public abstract interface ManagedClientConnection
  extends HttpClientConnection, ConnectionReleaseTrigger, HttpRoutedConnection
{
  public abstract HttpRoute getRoute();
  
  public abstract void layerProtocol(HttpContext paramHttpContext, HttpParams paramHttpParams);
  
  public abstract void markReusable();
  
  public abstract void open(HttpRoute paramHttpRoute, HttpContext paramHttpContext, HttpParams paramHttpParams);
  
  public abstract void setIdleDuration(long paramLong, TimeUnit paramTimeUnit);
  
  public abstract void setState(Object paramObject);
  
  public abstract void tunnelProxy(HttpHost paramHttpHost, boolean paramBoolean, HttpParams paramHttpParams);
  
  public abstract void tunnelTarget(boolean paramBoolean, HttpParams paramHttpParams);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/conn/ManagedClientConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */