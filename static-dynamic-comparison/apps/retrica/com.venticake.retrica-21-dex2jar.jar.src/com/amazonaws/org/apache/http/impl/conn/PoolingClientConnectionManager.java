package com.amazonaws.org.apache.http.impl.conn;

import com.amazonaws.org.apache.http.conn.ClientConnectionManager;
import com.amazonaws.org.apache.http.conn.ClientConnectionOperator;
import com.amazonaws.org.apache.http.conn.ClientConnectionRequest;
import com.amazonaws.org.apache.http.conn.ConnectionPoolTimeoutException;
import com.amazonaws.org.apache.http.conn.DnsResolver;
import com.amazonaws.org.apache.http.conn.ManagedClientConnection;
import com.amazonaws.org.apache.http.conn.routing.HttpRoute;
import com.amazonaws.org.apache.http.conn.scheme.SchemeRegistry;
import com.amazonaws.org.apache.http.pool.ConnPoolControl;
import com.amazonaws.org.apache.http.pool.PoolStats;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.annotation.ThreadSafe;

@ThreadSafe
public class PoolingClientConnectionManager
  implements ClientConnectionManager, ConnPoolControl<HttpRoute>
{
  private final DnsResolver dnsResolver;
  private final Log log = LogFactory.getLog(getClass());
  private final ClientConnectionOperator operator;
  private final HttpConnPool pool;
  private final SchemeRegistry schemeRegistry;
  
  public PoolingClientConnectionManager()
  {
    this(SchemeRegistryFactory.createDefault());
  }
  
  public PoolingClientConnectionManager(SchemeRegistry paramSchemeRegistry)
  {
    this(paramSchemeRegistry, -1L, TimeUnit.MILLISECONDS);
  }
  
  public PoolingClientConnectionManager(SchemeRegistry paramSchemeRegistry, long paramLong, TimeUnit paramTimeUnit)
  {
    this(paramSchemeRegistry, paramLong, paramTimeUnit, new SystemDefaultDnsResolver());
  }
  
  public PoolingClientConnectionManager(SchemeRegistry paramSchemeRegistry, long paramLong, TimeUnit paramTimeUnit, DnsResolver paramDnsResolver)
  {
    if (paramSchemeRegistry == null) {
      throw new IllegalArgumentException("Scheme registry may not be null");
    }
    if (paramDnsResolver == null) {
      throw new IllegalArgumentException("DNS resolver may not be null");
    }
    this.schemeRegistry = paramSchemeRegistry;
    this.dnsResolver = paramDnsResolver;
    this.operator = createConnectionOperator(paramSchemeRegistry);
    this.pool = new HttpConnPool(this.log, 2, 20, paramLong, paramTimeUnit);
  }
  
  private String format(HttpRoute paramHttpRoute, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[route: ").append(paramHttpRoute).append("]");
    if (paramObject != null) {
      localStringBuilder.append("[state: ").append(paramObject).append("]");
    }
    return localStringBuilder.toString();
  }
  
  private String format(HttpPoolEntry paramHttpPoolEntry)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[id: ").append(paramHttpPoolEntry.getId()).append("]");
    localStringBuilder.append("[route: ").append(paramHttpPoolEntry.getRoute()).append("]");
    paramHttpPoolEntry = paramHttpPoolEntry.getState();
    if (paramHttpPoolEntry != null) {
      localStringBuilder.append("[state: ").append(paramHttpPoolEntry).append("]");
    }
    return localStringBuilder.toString();
  }
  
  private String formatStats(HttpRoute paramHttpRoute)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    PoolStats localPoolStats = this.pool.getTotalStats();
    paramHttpRoute = this.pool.getStats(paramHttpRoute);
    localStringBuilder.append("[total kept alive: ").append(localPoolStats.getAvailable()).append("; ");
    localStringBuilder.append("route allocated: ").append(paramHttpRoute.getLeased() + paramHttpRoute.getAvailable());
    localStringBuilder.append(" of ").append(paramHttpRoute.getMax()).append("; ");
    localStringBuilder.append("total allocated: ").append(localPoolStats.getLeased() + localPoolStats.getAvailable());
    localStringBuilder.append(" of ").append(localPoolStats.getMax()).append("]");
    return localStringBuilder.toString();
  }
  
  public void closeIdleConnections(long paramLong, TimeUnit paramTimeUnit)
  {
    if (this.log.isDebugEnabled()) {
      this.log.debug("Closing connections idle longer than " + paramLong + " " + paramTimeUnit);
    }
    this.pool.closeIdle(paramLong, paramTimeUnit);
  }
  
  protected ClientConnectionOperator createConnectionOperator(SchemeRegistry paramSchemeRegistry)
  {
    return new DefaultClientConnectionOperator(paramSchemeRegistry, this.dnsResolver);
  }
  
  protected void finalize()
  {
    try
    {
      shutdown();
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public SchemeRegistry getSchemeRegistry()
  {
    return this.schemeRegistry;
  }
  
  public PoolStats getTotalStats()
  {
    return this.pool.getTotalStats();
  }
  
  ManagedClientConnection leaseConnection(Future<HttpPoolEntry> paramFuture, long paramLong, TimeUnit paramTimeUnit)
  {
    for (;;)
    {
      try
      {
        paramTimeUnit = (HttpPoolEntry)paramFuture.get(paramLong, paramTimeUnit);
        if ((paramTimeUnit == null) || (paramFuture.isCancelled())) {
          throw new InterruptedException();
        }
      }
      catch (ExecutionException paramFuture)
      {
        paramTimeUnit = paramFuture.getCause();
        if (paramTimeUnit != null) {
          break label174;
        }
        this.log.error("Unexpected exception leasing connection from pool", paramFuture);
        throw new InterruptedException();
        if (paramTimeUnit.getConnection() == null) {
          throw new IllegalStateException("Pool entry with no connection");
        }
      }
      catch (TimeoutException paramFuture)
      {
        throw new ConnectionPoolTimeoutException("Timeout waiting for connection from pool");
      }
      if (this.log.isDebugEnabled()) {
        this.log.debug("Connection leased: " + format(paramTimeUnit) + formatStats((HttpRoute)paramTimeUnit.getRoute()));
      }
      paramFuture = new ManagedClientConnectionImpl(this, this.operator, paramTimeUnit);
      return paramFuture;
      label174:
      paramFuture = paramTimeUnit;
    }
  }
  
  /* Error */
  public void releaseConnection(ManagedClientConnection paramManagedClientConnection, long paramLong, TimeUnit paramTimeUnit)
  {
    // Byte code:
    //   0: aload_1
    //   1: instanceof 248
    //   4: ifne +14 -> 18
    //   7: new 67	java/lang/IllegalArgumentException
    //   10: dup
    //   11: ldc_w 259
    //   14: invokespecial 72	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   17: athrow
    //   18: aload_1
    //   19: checkcast 248	com/amazonaws/org/apache/http/impl/conn/ManagedClientConnectionImpl
    //   22: astore 6
    //   24: aload 6
    //   26: invokevirtual 263	com/amazonaws/org/apache/http/impl/conn/ManagedClientConnectionImpl:getManager	()Lcom/amazonaws/org/apache/http/conn/ClientConnectionManager;
    //   29: aload_0
    //   30: if_acmpeq +14 -> 44
    //   33: new 230	java/lang/IllegalStateException
    //   36: dup
    //   37: ldc_w 265
    //   40: invokespecial 233	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   43: athrow
    //   44: aload 6
    //   46: monitorenter
    //   47: aload 6
    //   49: invokevirtual 269	com/amazonaws/org/apache/http/impl/conn/ManagedClientConnectionImpl:detach	()Lcom/amazonaws/org/apache/http/impl/conn/HttpPoolEntry;
    //   52: astore 7
    //   54: aload 7
    //   56: ifnonnull +7 -> 63
    //   59: aload 6
    //   61: monitorexit
    //   62: return
    //   63: aload 6
    //   65: invokevirtual 272	com/amazonaws/org/apache/http/impl/conn/ManagedClientConnectionImpl:isOpen	()Z
    //   68: ifeq +20 -> 88
    //   71: aload 6
    //   73: invokevirtual 275	com/amazonaws/org/apache/http/impl/conn/ManagedClientConnectionImpl:isMarkedReusable	()Z
    //   76: istore 5
    //   78: iload 5
    //   80: ifne +8 -> 88
    //   83: aload 6
    //   85: invokevirtual 276	com/amazonaws/org/apache/http/impl/conn/ManagedClientConnectionImpl:shutdown	()V
    //   88: aload 6
    //   90: invokevirtual 275	com/amazonaws/org/apache/http/impl/conn/ManagedClientConnectionImpl:isMarkedReusable	()Z
    //   93: ifeq +111 -> 204
    //   96: aload 4
    //   98: ifnull +237 -> 335
    //   101: aload 4
    //   103: astore_1
    //   104: aload 7
    //   106: lload_2
    //   107: aload_1
    //   108: invokevirtual 279	com/amazonaws/org/apache/http/impl/conn/HttpPoolEntry:updateExpiry	(JLjava/util/concurrent/TimeUnit;)V
    //   111: aload_0
    //   112: getfield 65	com/amazonaws/org/apache/http/impl/conn/PoolingClientConnectionManager:log	Lorg/apache/commons/logging/Log;
    //   115: invokeinterface 171 1 0
    //   120: ifeq +84 -> 204
    //   123: lload_2
    //   124: lconst_0
    //   125: lcmp
    //   126: ifle +216 -> 342
    //   129: new 95	java/lang/StringBuilder
    //   132: dup
    //   133: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   136: ldc_w 281
    //   139: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: lload_2
    //   143: invokevirtual 176	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   146: ldc -78
    //   148: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: aload 4
    //   153: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   156: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: astore_1
    //   160: aload_0
    //   161: getfield 65	com/amazonaws/org/apache/http/impl/conn/PoolingClientConnectionManager:log	Lorg/apache/commons/logging/Log;
    //   164: new 95	java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   171: ldc_w 283
    //   174: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: aload_0
    //   178: aload 7
    //   180: invokespecial 242	com/amazonaws/org/apache/http/impl/conn/PoolingClientConnectionManager:format	(Lcom/amazonaws/org/apache/http/impl/conn/HttpPoolEntry;)Ljava/lang/String;
    //   183: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: ldc_w 285
    //   189: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: aload_1
    //   193: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: invokeinterface 182 2 0
    //   204: aload_0
    //   205: getfield 91	com/amazonaws/org/apache/http/impl/conn/PoolingClientConnectionManager:pool	Lcom/amazonaws/org/apache/http/impl/conn/HttpConnPool;
    //   208: aload 7
    //   210: aload 6
    //   212: invokevirtual 275	com/amazonaws/org/apache/http/impl/conn/ManagedClientConnectionImpl:isMarkedReusable	()Z
    //   215: invokevirtual 289	com/amazonaws/org/apache/http/impl/conn/HttpConnPool:release	(Lcom/amazonaws/org/apache/http/pool/PoolEntry;Z)V
    //   218: aload_0
    //   219: getfield 65	com/amazonaws/org/apache/http/impl/conn/PoolingClientConnectionManager:log	Lorg/apache/commons/logging/Log;
    //   222: invokeinterface 171 1 0
    //   227: ifeq +52 -> 279
    //   230: aload_0
    //   231: getfield 65	com/amazonaws/org/apache/http/impl/conn/PoolingClientConnectionManager:log	Lorg/apache/commons/logging/Log;
    //   234: new 95	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   241: ldc_w 291
    //   244: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: aload_0
    //   248: aload 7
    //   250: invokespecial 242	com/amazonaws/org/apache/http/impl/conn/PoolingClientConnectionManager:format	(Lcom/amazonaws/org/apache/http/impl/conn/HttpPoolEntry;)Ljava/lang/String;
    //   253: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: aload_0
    //   257: aload 7
    //   259: invokevirtual 125	com/amazonaws/org/apache/http/impl/conn/HttpPoolEntry:getRoute	()Ljava/lang/Object;
    //   262: checkcast 244	com/amazonaws/org/apache/http/conn/routing/HttpRoute
    //   265: invokespecial 246	com/amazonaws/org/apache/http/impl/conn/PoolingClientConnectionManager:formatStats	(Lcom/amazonaws/org/apache/http/conn/routing/HttpRoute;)Ljava/lang/String;
    //   268: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   274: invokeinterface 182 2 0
    //   279: aload 6
    //   281: monitorexit
    //   282: return
    //   283: astore_1
    //   284: aload 6
    //   286: monitorexit
    //   287: aload_1
    //   288: athrow
    //   289: astore_1
    //   290: aload_0
    //   291: getfield 65	com/amazonaws/org/apache/http/impl/conn/PoolingClientConnectionManager:log	Lorg/apache/commons/logging/Log;
    //   294: invokeinterface 171 1 0
    //   299: ifeq -211 -> 88
    //   302: aload_0
    //   303: getfield 65	com/amazonaws/org/apache/http/impl/conn/PoolingClientConnectionManager:log	Lorg/apache/commons/logging/Log;
    //   306: ldc_w 293
    //   309: aload_1
    //   310: invokeinterface 295 3 0
    //   315: goto -227 -> 88
    //   318: astore_1
    //   319: aload_0
    //   320: getfield 91	com/amazonaws/org/apache/http/impl/conn/PoolingClientConnectionManager:pool	Lcom/amazonaws/org/apache/http/impl/conn/HttpConnPool;
    //   323: aload 7
    //   325: aload 6
    //   327: invokevirtual 275	com/amazonaws/org/apache/http/impl/conn/ManagedClientConnectionImpl:isMarkedReusable	()Z
    //   330: invokevirtual 289	com/amazonaws/org/apache/http/impl/conn/HttpConnPool:release	(Lcom/amazonaws/org/apache/http/pool/PoolEntry;Z)V
    //   333: aload_1
    //   334: athrow
    //   335: getstatic 42	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   338: astore_1
    //   339: goto -235 -> 104
    //   342: ldc_w 297
    //   345: astore_1
    //   346: goto -186 -> 160
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	349	0	this	PoolingClientConnectionManager
    //   0	349	1	paramManagedClientConnection	ManagedClientConnection
    //   0	349	2	paramLong	long
    //   0	349	4	paramTimeUnit	TimeUnit
    //   76	3	5	bool	boolean
    //   22	304	6	localManagedClientConnectionImpl	ManagedClientConnectionImpl
    //   52	272	7	localHttpPoolEntry	HttpPoolEntry
    // Exception table:
    //   from	to	target	type
    //   47	54	283	finally
    //   59	62	283	finally
    //   204	279	283	finally
    //   279	282	283	finally
    //   284	287	283	finally
    //   319	335	283	finally
    //   83	88	289	java/io/IOException
    //   63	78	318	finally
    //   83	88	318	finally
    //   88	96	318	finally
    //   104	123	318	finally
    //   129	160	318	finally
    //   160	204	318	finally
    //   290	315	318	finally
    //   335	339	318	finally
  }
  
  public ClientConnectionRequest requestConnection(HttpRoute paramHttpRoute, Object paramObject)
  {
    if (paramHttpRoute == null) {
      throw new IllegalArgumentException("HTTP route may not be null");
    }
    if (this.log.isDebugEnabled()) {
      this.log.debug("Connection request: " + format(paramHttpRoute, paramObject) + formatStats(paramHttpRoute));
    }
    new ClientConnectionRequest()
    {
      public void abortRequest()
      {
        this.val$future.cancel(true);
      }
      
      public ManagedClientConnection getConnection(long paramAnonymousLong, TimeUnit paramAnonymousTimeUnit)
      {
        return PoolingClientConnectionManager.this.leaseConnection(this.val$future, paramAnonymousLong, paramAnonymousTimeUnit);
      }
    };
  }
  
  public void setDefaultMaxPerRoute(int paramInt)
  {
    this.pool.setDefaultMaxPerRoute(paramInt);
  }
  
  public void setMaxTotal(int paramInt)
  {
    this.pool.setMaxTotal(paramInt);
  }
  
  public void shutdown()
  {
    this.log.debug("Connection manager is shutting down");
    try
    {
      this.pool.shutdown();
      this.log.debug("Connection manager shut down");
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        this.log.debug("I/O exception shutting down connection manager", localIOException);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/conn/PoolingClientConnectionManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */