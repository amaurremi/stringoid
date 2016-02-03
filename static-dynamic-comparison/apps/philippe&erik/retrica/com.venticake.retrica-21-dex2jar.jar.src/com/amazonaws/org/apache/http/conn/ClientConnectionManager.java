package com.amazonaws.org.apache.http.conn;

import com.amazonaws.org.apache.http.conn.routing.HttpRoute;
import com.amazonaws.org.apache.http.conn.scheme.SchemeRegistry;
import java.util.concurrent.TimeUnit;

public abstract interface ClientConnectionManager
{
  public abstract void closeIdleConnections(long paramLong, TimeUnit paramTimeUnit);
  
  public abstract SchemeRegistry getSchemeRegistry();
  
  public abstract void releaseConnection(ManagedClientConnection paramManagedClientConnection, long paramLong, TimeUnit paramTimeUnit);
  
  public abstract ClientConnectionRequest requestConnection(HttpRoute paramHttpRoute, Object paramObject);
  
  public abstract void shutdown();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/conn/ClientConnectionManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */