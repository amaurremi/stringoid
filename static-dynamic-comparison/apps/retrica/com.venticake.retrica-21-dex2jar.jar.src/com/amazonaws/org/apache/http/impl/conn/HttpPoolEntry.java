package com.amazonaws.org.apache.http.impl.conn;

import com.amazonaws.org.apache.http.conn.OperatedClientConnection;
import com.amazonaws.org.apache.http.conn.routing.HttpRoute;
import com.amazonaws.org.apache.http.conn.routing.RouteTracker;
import com.amazonaws.org.apache.http.pool.PoolEntry;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.logging.Log;

class HttpPoolEntry
  extends PoolEntry<HttpRoute, OperatedClientConnection>
{
  private final Log log;
  private final RouteTracker tracker;
  
  public HttpPoolEntry(Log paramLog, String paramString, HttpRoute paramHttpRoute, OperatedClientConnection paramOperatedClientConnection, long paramLong, TimeUnit paramTimeUnit)
  {
    super(paramString, paramHttpRoute, paramOperatedClientConnection, paramLong, paramTimeUnit);
    this.log = paramLog;
    this.tracker = new RouteTracker(paramHttpRoute);
  }
  
  public void close()
  {
    OperatedClientConnection localOperatedClientConnection = (OperatedClientConnection)getConnection();
    try
    {
      localOperatedClientConnection.close();
      return;
    }
    catch (IOException localIOException)
    {
      this.log.debug("I/O error closing connection", localIOException);
    }
  }
  
  HttpRoute getEffectiveRoute()
  {
    return this.tracker.toRoute();
  }
  
  HttpRoute getPlannedRoute()
  {
    return (HttpRoute)getRoute();
  }
  
  RouteTracker getTracker()
  {
    return this.tracker;
  }
  
  public boolean isClosed()
  {
    return !((OperatedClientConnection)getConnection()).isOpen();
  }
  
  public boolean isExpired(long paramLong)
  {
    boolean bool = super.isExpired(paramLong);
    if ((bool) && (this.log.isDebugEnabled())) {
      this.log.debug("Connection " + this + " expired @ " + new Date(getExpiry()));
    }
    return bool;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/conn/HttpPoolEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */