package com.amazonaws.org.apache.http.impl.conn;

import com.amazonaws.org.apache.http.HttpEntityEnclosingRequest;
import com.amazonaws.org.apache.http.HttpHost;
import com.amazonaws.org.apache.http.HttpRequest;
import com.amazonaws.org.apache.http.HttpResponse;
import com.amazonaws.org.apache.http.conn.ClientConnectionManager;
import com.amazonaws.org.apache.http.conn.ClientConnectionOperator;
import com.amazonaws.org.apache.http.conn.ManagedClientConnection;
import com.amazonaws.org.apache.http.conn.OperatedClientConnection;
import com.amazonaws.org.apache.http.conn.routing.HttpRoute;
import com.amazonaws.org.apache.http.conn.routing.RouteTracker;
import com.amazonaws.org.apache.http.params.HttpParams;
import com.amazonaws.org.apache.http.protocol.HttpContext;
import java.io.InterruptedIOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
class ManagedClientConnectionImpl
  implements ManagedClientConnection
{
  private volatile long duration;
  private final ClientConnectionManager manager;
  private final ClientConnectionOperator operator;
  private volatile HttpPoolEntry poolEntry;
  private volatile boolean reusable;
  
  ManagedClientConnectionImpl(ClientConnectionManager paramClientConnectionManager, ClientConnectionOperator paramClientConnectionOperator, HttpPoolEntry paramHttpPoolEntry)
  {
    if (paramClientConnectionManager == null) {
      throw new IllegalArgumentException("Connection manager may not be null");
    }
    if (paramClientConnectionOperator == null) {
      throw new IllegalArgumentException("Connection operator may not be null");
    }
    if (paramHttpPoolEntry == null) {
      throw new IllegalArgumentException("HTTP pool entry may not be null");
    }
    this.manager = paramClientConnectionManager;
    this.operator = paramClientConnectionOperator;
    this.poolEntry = paramHttpPoolEntry;
    this.reusable = false;
    this.duration = Long.MAX_VALUE;
  }
  
  private OperatedClientConnection ensureConnection()
  {
    HttpPoolEntry localHttpPoolEntry = this.poolEntry;
    if (localHttpPoolEntry == null) {
      throw new ConnectionShutdownException();
    }
    return (OperatedClientConnection)localHttpPoolEntry.getConnection();
  }
  
  private HttpPoolEntry ensurePoolEntry()
  {
    HttpPoolEntry localHttpPoolEntry = this.poolEntry;
    if (localHttpPoolEntry == null) {
      throw new ConnectionShutdownException();
    }
    return localHttpPoolEntry;
  }
  
  private OperatedClientConnection getConnection()
  {
    HttpPoolEntry localHttpPoolEntry = this.poolEntry;
    if (localHttpPoolEntry == null) {
      return null;
    }
    return (OperatedClientConnection)localHttpPoolEntry.getConnection();
  }
  
  /* Error */
  public void abortConnection()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 39	com/amazonaws/org/apache/http/impl/conn/ManagedClientConnectionImpl:poolEntry	Lcom/amazonaws/org/apache/http/impl/conn/HttpPoolEntry;
    //   6: ifnonnull +6 -> 12
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: aload_0
    //   13: iconst_0
    //   14: putfield 41	com/amazonaws/org/apache/http/impl/conn/ManagedClientConnectionImpl:reusable	Z
    //   17: aload_0
    //   18: getfield 39	com/amazonaws/org/apache/http/impl/conn/ManagedClientConnectionImpl:poolEntry	Lcom/amazonaws/org/apache/http/impl/conn/HttpPoolEntry;
    //   21: invokevirtual 57	com/amazonaws/org/apache/http/impl/conn/HttpPoolEntry:getConnection	()Ljava/lang/Object;
    //   24: checkcast 59	com/amazonaws/org/apache/http/conn/OperatedClientConnection
    //   27: astore_1
    //   28: aload_1
    //   29: invokeinterface 67 1 0
    //   34: aload_0
    //   35: getfield 35	com/amazonaws/org/apache/http/impl/conn/ManagedClientConnectionImpl:manager	Lcom/amazonaws/org/apache/http/conn/ClientConnectionManager;
    //   38: aload_0
    //   39: aload_0
    //   40: getfield 45	com/amazonaws/org/apache/http/impl/conn/ManagedClientConnectionImpl:duration	J
    //   43: getstatic 73	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   46: invokeinterface 79 5 0
    //   51: aload_0
    //   52: aconst_null
    //   53: putfield 39	com/amazonaws/org/apache/http/impl/conn/ManagedClientConnectionImpl:poolEntry	Lcom/amazonaws/org/apache/http/impl/conn/HttpPoolEntry;
    //   56: aload_0
    //   57: monitorexit
    //   58: return
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    //   64: astore_1
    //   65: goto -31 -> 34
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	ManagedClientConnectionImpl
    //   27	2	1	localOperatedClientConnection	OperatedClientConnection
    //   59	4	1	localObject	Object
    //   64	1	1	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   2	11	59	finally
    //   12	28	59	finally
    //   28	34	59	finally
    //   34	58	59	finally
    //   60	62	59	finally
    //   28	34	64	java/io/IOException
  }
  
  public void close()
  {
    HttpPoolEntry localHttpPoolEntry = this.poolEntry;
    if (localHttpPoolEntry != null)
    {
      OperatedClientConnection localOperatedClientConnection = (OperatedClientConnection)localHttpPoolEntry.getConnection();
      localHttpPoolEntry.getTracker().reset();
      localOperatedClientConnection.close();
    }
  }
  
  HttpPoolEntry detach()
  {
    HttpPoolEntry localHttpPoolEntry = this.poolEntry;
    this.poolEntry = null;
    return localHttpPoolEntry;
  }
  
  public void flush()
  {
    ensureConnection().flush();
  }
  
  public ClientConnectionManager getManager()
  {
    return this.manager;
  }
  
  HttpPoolEntry getPoolEntry()
  {
    return this.poolEntry;
  }
  
  public InetAddress getRemoteAddress()
  {
    return ensureConnection().getRemoteAddress();
  }
  
  public int getRemotePort()
  {
    return ensureConnection().getRemotePort();
  }
  
  public HttpRoute getRoute()
  {
    return ensurePoolEntry().getEffectiveRoute();
  }
  
  public SSLSession getSSLSession()
  {
    Socket localSocket = ensureConnection().getSocket();
    if ((localSocket instanceof SSLSocket)) {
      return ((SSLSocket)localSocket).getSession();
    }
    return null;
  }
  
  public boolean isMarkedReusable()
  {
    return this.reusable;
  }
  
  public boolean isOpen()
  {
    OperatedClientConnection localOperatedClientConnection = getConnection();
    if (localOperatedClientConnection != null) {
      return localOperatedClientConnection.isOpen();
    }
    return false;
  }
  
  public boolean isResponseAvailable(int paramInt)
  {
    return ensureConnection().isResponseAvailable(paramInt);
  }
  
  public boolean isSecure()
  {
    return ensureConnection().isSecure();
  }
  
  public boolean isStale()
  {
    OperatedClientConnection localOperatedClientConnection = getConnection();
    if (localOperatedClientConnection != null) {
      return localOperatedClientConnection.isStale();
    }
    return true;
  }
  
  public void layerProtocol(HttpContext paramHttpContext, HttpParams paramHttpParams)
  {
    if (paramHttpParams == null) {
      throw new IllegalArgumentException("HTTP parameters may not be null");
    }
    try
    {
      if (this.poolEntry == null) {
        throw new ConnectionShutdownException();
      }
    }
    finally {}
    Object localObject = this.poolEntry.getTracker();
    if (!((RouteTracker)localObject).isConnected()) {
      throw new IllegalStateException("Connection not open");
    }
    if (!((RouteTracker)localObject).isTunnelled()) {
      throw new IllegalStateException("Protocol layering without a tunnel not supported");
    }
    if (((RouteTracker)localObject).isLayered()) {
      throw new IllegalStateException("Multiple protocol layering not supported");
    }
    localObject = ((RouteTracker)localObject).getTargetHost();
    OperatedClientConnection localOperatedClientConnection = (OperatedClientConnection)this.poolEntry.getConnection();
    this.operator.updateSecureConnection(localOperatedClientConnection, (HttpHost)localObject, paramHttpContext, paramHttpParams);
    try
    {
      if (this.poolEntry == null) {
        throw new InterruptedIOException();
      }
    }
    finally {}
    this.poolEntry.getTracker().layerProtocol(localOperatedClientConnection.isSecure());
  }
  
  public void markReusable()
  {
    this.reusable = true;
  }
  
  public void open(HttpRoute paramHttpRoute, HttpContext paramHttpContext, HttpParams paramHttpParams)
  {
    if (paramHttpRoute == null) {
      throw new IllegalArgumentException("Route may not be null");
    }
    if (paramHttpParams == null) {
      throw new IllegalArgumentException("HTTP parameters may not be null");
    }
    try
    {
      if (this.poolEntry == null) {
        throw new ConnectionShutdownException();
      }
    }
    finally {}
    if (this.poolEntry.getTracker().isConnected()) {
      throw new IllegalStateException("Connection already open");
    }
    OperatedClientConnection localOperatedClientConnection = (OperatedClientConnection)this.poolEntry.getConnection();
    HttpHost localHttpHost2 = paramHttpRoute.getProxyHost();
    ClientConnectionOperator localClientConnectionOperator = this.operator;
    if (localHttpHost2 != null) {}
    for (HttpHost localHttpHost1 = localHttpHost2;; localHttpHost1 = paramHttpRoute.getTargetHost())
    {
      localClientConnectionOperator.openConnection(localOperatedClientConnection, localHttpHost1, paramHttpRoute.getLocalAddress(), paramHttpContext, paramHttpParams);
      try
      {
        if (this.poolEntry != null) {
          break;
        }
        throw new InterruptedIOException();
      }
      finally {}
    }
    paramHttpRoute = this.poolEntry.getTracker();
    if (localHttpHost2 == null) {
      paramHttpRoute.connectTarget(localOperatedClientConnection.isSecure());
    }
    for (;;)
    {
      return;
      paramHttpRoute.connectProxy(localHttpHost2, localOperatedClientConnection.isSecure());
    }
  }
  
  public void receiveResponseEntity(HttpResponse paramHttpResponse)
  {
    ensureConnection().receiveResponseEntity(paramHttpResponse);
  }
  
  public HttpResponse receiveResponseHeader()
  {
    return ensureConnection().receiveResponseHeader();
  }
  
  public void releaseConnection()
  {
    try
    {
      if (this.poolEntry == null) {
        return;
      }
      this.manager.releaseConnection(this, this.duration, TimeUnit.MILLISECONDS);
      this.poolEntry = null;
      return;
    }
    finally {}
  }
  
  public void sendRequestEntity(HttpEntityEnclosingRequest paramHttpEntityEnclosingRequest)
  {
    ensureConnection().sendRequestEntity(paramHttpEntityEnclosingRequest);
  }
  
  public void sendRequestHeader(HttpRequest paramHttpRequest)
  {
    ensureConnection().sendRequestHeader(paramHttpRequest);
  }
  
  public void setIdleDuration(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramLong > 0L)
    {
      this.duration = paramTimeUnit.toMillis(paramLong);
      return;
    }
    this.duration = -1L;
  }
  
  public void setSocketTimeout(int paramInt)
  {
    ensureConnection().setSocketTimeout(paramInt);
  }
  
  public void setState(Object paramObject)
  {
    ensurePoolEntry().setState(paramObject);
  }
  
  public void shutdown()
  {
    HttpPoolEntry localHttpPoolEntry = this.poolEntry;
    if (localHttpPoolEntry != null)
    {
      OperatedClientConnection localOperatedClientConnection = (OperatedClientConnection)localHttpPoolEntry.getConnection();
      localHttpPoolEntry.getTracker().reset();
      localOperatedClientConnection.shutdown();
    }
  }
  
  public void tunnelProxy(HttpHost paramHttpHost, boolean paramBoolean, HttpParams paramHttpParams)
  {
    if (paramHttpHost == null) {
      throw new IllegalArgumentException("Next proxy amy not be null");
    }
    if (paramHttpParams == null) {
      throw new IllegalArgumentException("HTTP parameters may not be null");
    }
    try
    {
      if (this.poolEntry == null) {
        throw new ConnectionShutdownException();
      }
    }
    finally {}
    if (!this.poolEntry.getTracker().isConnected()) {
      throw new IllegalStateException("Connection not open");
    }
    OperatedClientConnection localOperatedClientConnection = (OperatedClientConnection)this.poolEntry.getConnection();
    localOperatedClientConnection.update(null, paramHttpHost, paramBoolean, paramHttpParams);
    try
    {
      if (this.poolEntry == null) {
        throw new InterruptedIOException();
      }
    }
    finally {}
    this.poolEntry.getTracker().tunnelProxy(paramHttpHost, paramBoolean);
  }
  
  public void tunnelTarget(boolean paramBoolean, HttpParams paramHttpParams)
  {
    if (paramHttpParams == null) {
      throw new IllegalArgumentException("HTTP parameters may not be null");
    }
    try
    {
      if (this.poolEntry == null) {
        throw new ConnectionShutdownException();
      }
    }
    finally {}
    Object localObject = this.poolEntry.getTracker();
    if (!((RouteTracker)localObject).isConnected()) {
      throw new IllegalStateException("Connection not open");
    }
    if (((RouteTracker)localObject).isTunnelled()) {
      throw new IllegalStateException("Connection is already tunnelled");
    }
    localObject = ((RouteTracker)localObject).getTargetHost();
    OperatedClientConnection localOperatedClientConnection = (OperatedClientConnection)this.poolEntry.getConnection();
    localOperatedClientConnection.update(null, (HttpHost)localObject, paramBoolean, paramHttpParams);
    try
    {
      if (this.poolEntry == null) {
        throw new InterruptedIOException();
      }
    }
    finally {}
    this.poolEntry.getTracker().tunnelTarget(paramBoolean);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/conn/ManagedClientConnectionImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */