package com.amazonaws.org.apache.http.impl.conn;

import com.amazonaws.org.apache.http.HttpClientConnection;
import com.amazonaws.org.apache.http.conn.ClientConnectionManager;
import com.amazonaws.org.apache.http.conn.ClientConnectionOperator;
import com.amazonaws.org.apache.http.conn.ClientConnectionRequest;
import com.amazonaws.org.apache.http.conn.ManagedClientConnection;
import com.amazonaws.org.apache.http.conn.OperatedClientConnection;
import com.amazonaws.org.apache.http.conn.routing.HttpRoute;
import com.amazonaws.org.apache.http.conn.routing.RouteTracker;
import com.amazonaws.org.apache.http.conn.scheme.SchemeRegistry;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.annotation.GuardedBy;
import org.apache.http.annotation.ThreadSafe;

@ThreadSafe
public class BasicClientConnectionManager
  implements ClientConnectionManager
{
  private static final AtomicLong COUNTER = new AtomicLong();
  @GuardedBy("this")
  private ManagedClientConnectionImpl conn;
  private final ClientConnectionOperator connOperator;
  private final Log log = LogFactory.getLog(getClass());
  @GuardedBy("this")
  private HttpPoolEntry poolEntry;
  private final SchemeRegistry schemeRegistry;
  @GuardedBy("this")
  private volatile boolean shutdown;
  
  public BasicClientConnectionManager()
  {
    this(SchemeRegistryFactory.createDefault());
  }
  
  public BasicClientConnectionManager(SchemeRegistry paramSchemeRegistry)
  {
    if (paramSchemeRegistry == null) {
      throw new IllegalArgumentException("Scheme registry may not be null");
    }
    this.schemeRegistry = paramSchemeRegistry;
    this.connOperator = createConnectionOperator(paramSchemeRegistry);
  }
  
  private void assertNotShutdown()
  {
    if (this.shutdown) {
      throw new IllegalStateException("Connection manager has been shut down");
    }
  }
  
  private void shutdownConnection(HttpClientConnection paramHttpClientConnection)
  {
    try
    {
      paramHttpClientConnection.shutdown();
      return;
    }
    catch (IOException paramHttpClientConnection)
    {
      while (!this.log.isDebugEnabled()) {}
      this.log.debug("I/O exception shutting down connection", paramHttpClientConnection);
    }
  }
  
  public void closeIdleConnections(long paramLong, TimeUnit paramTimeUnit)
  {
    long l = 0L;
    if (paramTimeUnit == null) {
      throw new IllegalArgumentException("Time unit must not be null.");
    }
    for (;;)
    {
      try
      {
        assertNotShutdown();
        paramLong = paramTimeUnit.toMillis(paramLong);
        if (paramLong < 0L)
        {
          paramLong = l;
          l = System.currentTimeMillis();
          if ((this.poolEntry != null) && (this.poolEntry.getUpdated() <= l - paramLong))
          {
            this.poolEntry.close();
            this.poolEntry.getTracker().reset();
          }
          return;
        }
      }
      finally {}
    }
  }
  
  protected ClientConnectionOperator createConnectionOperator(SchemeRegistry paramSchemeRegistry)
  {
    return new DefaultClientConnectionOperator(paramSchemeRegistry);
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
  
  ManagedClientConnection getConnection(HttpRoute paramHttpRoute, Object paramObject)
  {
    if (paramHttpRoute == null) {
      throw new IllegalArgumentException("Route may not be null.");
    }
    try
    {
      assertNotShutdown();
      if (this.log.isDebugEnabled()) {
        this.log.debug("Get connection for route " + paramHttpRoute);
      }
      if (this.conn != null) {
        throw new IllegalStateException("Invalid use of BasicClientConnManager: connection still allocated.\nMake sure to release the connection before allocating another one.");
      }
    }
    finally {}
    if ((this.poolEntry != null) && (!this.poolEntry.getPlannedRoute().equals(paramHttpRoute)))
    {
      this.poolEntry.close();
      this.poolEntry = null;
    }
    if (this.poolEntry == null)
    {
      paramObject = Long.toString(COUNTER.getAndIncrement());
      OperatedClientConnection localOperatedClientConnection = this.connOperator.createConnection();
      this.poolEntry = new HttpPoolEntry(this.log, (String)paramObject, paramHttpRoute, localOperatedClientConnection, 0L, TimeUnit.MILLISECONDS);
    }
    long l = System.currentTimeMillis();
    if (this.poolEntry.isExpired(l))
    {
      this.poolEntry.close();
      this.poolEntry.getTracker().reset();
    }
    this.conn = new ManagedClientConnectionImpl(this, this.connOperator, this.poolEntry);
    paramHttpRoute = this.conn;
    return paramHttpRoute;
  }
  
  public SchemeRegistry getSchemeRegistry()
  {
    return this.schemeRegistry;
  }
  
  /* Error */
  public void releaseConnection(ManagedClientConnection paramManagedClientConnection, long paramLong, TimeUnit paramTimeUnit)
  {
    // Byte code:
    //   0: aload_1
    //   1: instanceof 209
    //   4: ifne +13 -> 17
    //   7: new 60	java/lang/IllegalArgumentException
    //   10: dup
    //   11: ldc -39
    //   13: invokespecial 65	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   16: athrow
    //   17: aload_1
    //   18: checkcast 209	com/amazonaws/org/apache/http/impl/conn/ManagedClientConnectionImpl
    //   21: astore 5
    //   23: aload 5
    //   25: monitorenter
    //   26: aload_0
    //   27: getfield 58	com/amazonaws/org/apache/http/impl/conn/BasicClientConnectionManager:log	Lorg/apache/commons/logging/Log;
    //   30: invokeinterface 95 1 0
    //   35: ifeq +31 -> 66
    //   38: aload_0
    //   39: getfield 58	com/amazonaws/org/apache/http/impl/conn/BasicClientConnectionManager:log	Lorg/apache/commons/logging/Log;
    //   42: new 151	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   49: ldc -37
    //   51: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload_1
    //   55: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokeinterface 168 2 0
    //   66: aload 5
    //   68: invokevirtual 223	com/amazonaws/org/apache/http/impl/conn/ManagedClientConnectionImpl:getPoolEntry	()Lcom/amazonaws/org/apache/http/impl/conn/HttpPoolEntry;
    //   71: ifnonnull +7 -> 78
    //   74: aload 5
    //   76: monitorexit
    //   77: return
    //   78: aload 5
    //   80: invokevirtual 227	com/amazonaws/org/apache/http/impl/conn/ManagedClientConnectionImpl:getManager	()Lcom/amazonaws/org/apache/http/conn/ClientConnectionManager;
    //   83: astore_1
    //   84: aload_1
    //   85: ifnull +24 -> 109
    //   88: aload_1
    //   89: aload_0
    //   90: if_acmpeq +19 -> 109
    //   93: new 78	java/lang/IllegalStateException
    //   96: dup
    //   97: ldc -27
    //   99: invokespecial 81	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   102: athrow
    //   103: astore_1
    //   104: aload 5
    //   106: monitorexit
    //   107: aload_1
    //   108: athrow
    //   109: aload_0
    //   110: monitorenter
    //   111: aload_0
    //   112: getfield 76	com/amazonaws/org/apache/http/impl/conn/BasicClientConnectionManager:shutdown	Z
    //   115: ifeq +15 -> 130
    //   118: aload_0
    //   119: aload 5
    //   121: invokespecial 231	com/amazonaws/org/apache/http/impl/conn/BasicClientConnectionManager:shutdownConnection	(Lcom/amazonaws/org/apache/http/HttpClientConnection;)V
    //   124: aload_0
    //   125: monitorexit
    //   126: aload 5
    //   128: monitorexit
    //   129: return
    //   130: aload 5
    //   132: invokevirtual 234	com/amazonaws/org/apache/http/impl/conn/ManagedClientConnectionImpl:isOpen	()Z
    //   135: ifeq +17 -> 152
    //   138: aload 5
    //   140: invokevirtual 237	com/amazonaws/org/apache/http/impl/conn/ManagedClientConnectionImpl:isMarkedReusable	()Z
    //   143: ifne +9 -> 152
    //   146: aload_0
    //   147: aload 5
    //   149: invokespecial 231	com/amazonaws/org/apache/http/impl/conn/BasicClientConnectionManager:shutdownConnection	(Lcom/amazonaws/org/apache/http/HttpClientConnection;)V
    //   152: aload_0
    //   153: getfield 121	com/amazonaws/org/apache/http/impl/conn/BasicClientConnectionManager:poolEntry	Lcom/amazonaws/org/apache/http/impl/conn/HttpPoolEntry;
    //   156: astore 6
    //   158: aload 4
    //   160: ifnull +121 -> 281
    //   163: aload 4
    //   165: astore_1
    //   166: aload 6
    //   168: lload_2
    //   169: aload_1
    //   170: invokevirtual 240	com/amazonaws/org/apache/http/impl/conn/HttpPoolEntry:updateExpiry	(JLjava/util/concurrent/TimeUnit;)V
    //   173: aload_0
    //   174: getfield 58	com/amazonaws/org/apache/http/impl/conn/BasicClientConnectionManager:log	Lorg/apache/commons/logging/Log;
    //   177: invokeinterface 95 1 0
    //   182: ifeq +67 -> 249
    //   185: lload_2
    //   186: lconst_0
    //   187: lcmp
    //   188: ifle +100 -> 288
    //   191: new 151	java/lang/StringBuilder
    //   194: dup
    //   195: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   198: ldc -14
    //   200: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: lload_2
    //   204: invokevirtual 245	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   207: ldc -9
    //   209: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: aload 4
    //   214: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   217: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: astore_1
    //   221: aload_0
    //   222: getfield 58	com/amazonaws/org/apache/http/impl/conn/BasicClientConnectionManager:log	Lorg/apache/commons/logging/Log;
    //   225: new 151	java/lang/StringBuilder
    //   228: dup
    //   229: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   232: ldc -7
    //   234: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: aload_1
    //   238: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: invokeinterface 168 2 0
    //   249: aload 5
    //   251: invokevirtual 252	com/amazonaws/org/apache/http/impl/conn/ManagedClientConnectionImpl:detach	()Lcom/amazonaws/org/apache/http/impl/conn/HttpPoolEntry;
    //   254: pop
    //   255: aload_0
    //   256: aconst_null
    //   257: putfield 170	com/amazonaws/org/apache/http/impl/conn/BasicClientConnectionManager:conn	Lcom/amazonaws/org/apache/http/impl/conn/ManagedClientConnectionImpl;
    //   260: aload_0
    //   261: getfield 121	com/amazonaws/org/apache/http/impl/conn/BasicClientConnectionManager:poolEntry	Lcom/amazonaws/org/apache/http/impl/conn/HttpPoolEntry;
    //   264: invokevirtual 255	com/amazonaws/org/apache/http/impl/conn/HttpPoolEntry:isClosed	()Z
    //   267: ifeq +8 -> 275
    //   270: aload_0
    //   271: aconst_null
    //   272: putfield 121	com/amazonaws/org/apache/http/impl/conn/BasicClientConnectionManager:poolEntry	Lcom/amazonaws/org/apache/http/impl/conn/HttpPoolEntry;
    //   275: aload_0
    //   276: monitorexit
    //   277: aload 5
    //   279: monitorexit
    //   280: return
    //   281: getstatic 200	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   284: astore_1
    //   285: goto -119 -> 166
    //   288: ldc_w 257
    //   291: astore_1
    //   292: goto -71 -> 221
    //   295: astore_1
    //   296: aload 5
    //   298: invokevirtual 252	com/amazonaws/org/apache/http/impl/conn/ManagedClientConnectionImpl:detach	()Lcom/amazonaws/org/apache/http/impl/conn/HttpPoolEntry;
    //   301: pop
    //   302: aload_0
    //   303: aconst_null
    //   304: putfield 170	com/amazonaws/org/apache/http/impl/conn/BasicClientConnectionManager:conn	Lcom/amazonaws/org/apache/http/impl/conn/ManagedClientConnectionImpl;
    //   307: aload_0
    //   308: getfield 121	com/amazonaws/org/apache/http/impl/conn/BasicClientConnectionManager:poolEntry	Lcom/amazonaws/org/apache/http/impl/conn/HttpPoolEntry;
    //   311: invokevirtual 255	com/amazonaws/org/apache/http/impl/conn/HttpPoolEntry:isClosed	()Z
    //   314: ifeq +8 -> 322
    //   317: aload_0
    //   318: aconst_null
    //   319: putfield 121	com/amazonaws/org/apache/http/impl/conn/BasicClientConnectionManager:poolEntry	Lcom/amazonaws/org/apache/http/impl/conn/HttpPoolEntry;
    //   322: aload_1
    //   323: athrow
    //   324: astore_1
    //   325: aload_0
    //   326: monitorexit
    //   327: aload_1
    //   328: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	329	0	this	BasicClientConnectionManager
    //   0	329	1	paramManagedClientConnection	ManagedClientConnection
    //   0	329	2	paramLong	long
    //   0	329	4	paramTimeUnit	TimeUnit
    //   21	276	5	localManagedClientConnectionImpl	ManagedClientConnectionImpl
    //   156	11	6	localHttpPoolEntry	HttpPoolEntry
    // Exception table:
    //   from	to	target	type
    //   26	66	103	finally
    //   66	77	103	finally
    //   78	84	103	finally
    //   93	103	103	finally
    //   104	107	103	finally
    //   109	111	103	finally
    //   126	129	103	finally
    //   277	280	103	finally
    //   327	329	103	finally
    //   130	152	295	finally
    //   152	158	295	finally
    //   166	185	295	finally
    //   191	221	295	finally
    //   221	249	295	finally
    //   281	285	295	finally
    //   111	126	324	finally
    //   249	275	324	finally
    //   275	277	324	finally
    //   296	322	324	finally
    //   322	324	324	finally
    //   325	327	324	finally
  }
  
  public final ClientConnectionRequest requestConnection(final HttpRoute paramHttpRoute, final Object paramObject)
  {
    new ClientConnectionRequest()
    {
      public void abortRequest() {}
      
      public ManagedClientConnection getConnection(long paramAnonymousLong, TimeUnit paramAnonymousTimeUnit)
      {
        return BasicClientConnectionManager.this.getConnection(paramHttpRoute, paramObject);
      }
    };
  }
  
  /* Error */
  public void shutdown()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield 76	com/amazonaws/org/apache/http/impl/conn/BasicClientConnectionManager:shutdown	Z
    //   7: aload_0
    //   8: getfield 121	com/amazonaws/org/apache/http/impl/conn/BasicClientConnectionManager:poolEntry	Lcom/amazonaws/org/apache/http/impl/conn/HttpPoolEntry;
    //   11: ifnull +10 -> 21
    //   14: aload_0
    //   15: getfield 121	com/amazonaws/org/apache/http/impl/conn/BasicClientConnectionManager:poolEntry	Lcom/amazonaws/org/apache/http/impl/conn/HttpPoolEntry;
    //   18: invokevirtual 129	com/amazonaws/org/apache/http/impl/conn/HttpPoolEntry:close	()V
    //   21: aload_0
    //   22: aconst_null
    //   23: putfield 121	com/amazonaws/org/apache/http/impl/conn/BasicClientConnectionManager:poolEntry	Lcom/amazonaws/org/apache/http/impl/conn/HttpPoolEntry;
    //   26: aload_0
    //   27: aconst_null
    //   28: putfield 170	com/amazonaws/org/apache/http/impl/conn/BasicClientConnectionManager:conn	Lcom/amazonaws/org/apache/http/impl/conn/ManagedClientConnectionImpl;
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: astore_1
    //   35: aload_0
    //   36: aconst_null
    //   37: putfield 121	com/amazonaws/org/apache/http/impl/conn/BasicClientConnectionManager:poolEntry	Lcom/amazonaws/org/apache/http/impl/conn/HttpPoolEntry;
    //   40: aload_0
    //   41: aconst_null
    //   42: putfield 170	com/amazonaws/org/apache/http/impl/conn/BasicClientConnectionManager:conn	Lcom/amazonaws/org/apache/http/impl/conn/ManagedClientConnectionImpl;
    //   45: aload_1
    //   46: athrow
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	BasicClientConnectionManager
    //   34	12	1	localObject1	Object
    //   47	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   7	21	34	finally
    //   2	7	47	finally
    //   21	33	47	finally
    //   35	47	47	finally
    //   48	50	47	finally
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/conn/BasicClientConnectionManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */