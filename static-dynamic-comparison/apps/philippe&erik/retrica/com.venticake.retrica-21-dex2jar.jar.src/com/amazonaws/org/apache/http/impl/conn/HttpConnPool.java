package com.amazonaws.org.apache.http.impl.conn;

import com.amazonaws.org.apache.http.conn.OperatedClientConnection;
import com.amazonaws.org.apache.http.conn.routing.HttpRoute;
import com.amazonaws.org.apache.http.pool.AbstractConnPool;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.commons.logging.Log;

class HttpConnPool
  extends AbstractConnPool<HttpRoute, OperatedClientConnection, HttpPoolEntry>
{
  private static AtomicLong COUNTER = new AtomicLong();
  private final Log log;
  private final long timeToLive;
  private final TimeUnit tunit;
  
  public HttpConnPool(Log paramLog, int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit)
  {
    super(new HttpConnPool.InternalConnFactory(), paramInt1, paramInt2);
    this.log = paramLog;
    this.timeToLive = paramLong;
    this.tunit = paramTimeUnit;
  }
  
  protected HttpPoolEntry createEntry(HttpRoute paramHttpRoute, OperatedClientConnection paramOperatedClientConnection)
  {
    String str = Long.toString(COUNTER.getAndIncrement());
    return new HttpPoolEntry(this.log, str, paramHttpRoute, paramOperatedClientConnection, this.timeToLive, this.tunit);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/conn/HttpConnPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */