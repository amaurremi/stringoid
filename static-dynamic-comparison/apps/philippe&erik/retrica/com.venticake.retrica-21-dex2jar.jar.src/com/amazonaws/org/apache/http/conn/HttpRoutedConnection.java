package com.amazonaws.org.apache.http.conn;

import com.amazonaws.org.apache.http.HttpInetConnection;
import com.amazonaws.org.apache.http.conn.routing.HttpRoute;
import javax.net.ssl.SSLSession;

public abstract interface HttpRoutedConnection
  extends HttpInetConnection
{
  public abstract HttpRoute getRoute();
  
  public abstract SSLSession getSSLSession();
  
  public abstract boolean isSecure();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/conn/HttpRoutedConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */