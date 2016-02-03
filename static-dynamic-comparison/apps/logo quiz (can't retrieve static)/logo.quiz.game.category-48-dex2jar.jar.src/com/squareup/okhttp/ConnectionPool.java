package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class ConnectionPool
{
  private static final long DEFAULT_KEEP_ALIVE_DURATION_MS = 300000L;
  private static final int MAX_CONNECTIONS_TO_CLEANUP = 2;
  private static final ConnectionPool systemDefault;
  private final LinkedList<Connection> connections = new LinkedList();
  private final Runnable connectionsCleanupRunnable = new Runnable()
  {
    public void run()
    {
      ArrayList localArrayList = new ArrayList(2);
      int i = 0;
      synchronized (ConnectionPool.this)
      {
        ListIterator localListIterator = ConnectionPool.this.connections.listIterator(ConnectionPool.this.connections.size());
        for (;;)
        {
          Connection localConnection;
          if (localListIterator.hasPrevious())
          {
            localConnection = (Connection)localListIterator.previous();
            if ((!localConnection.isAlive()) || (localConnection.isExpired(ConnectionPool.this.keepAliveDurationNs)))
            {
              localListIterator.remove();
              localArrayList.add(localConnection);
              if (localArrayList.size() != 2) {
                continue;
              }
            }
          }
          else
          {
            localListIterator = ConnectionPool.this.connections.listIterator(ConnectionPool.this.connections.size());
            while ((localListIterator.hasPrevious()) && (i > ConnectionPool.this.maxIdleConnections))
            {
              localConnection = (Connection)localListIterator.previous();
              if (localConnection.isIdle())
              {
                localArrayList.add(localConnection);
                localListIterator.remove();
                i -= 1;
              }
            }
          }
          if (localConnection.isIdle()) {
            i += 1;
          }
        }
        ??? = localArrayList.iterator();
        if (((Iterator)???).hasNext()) {
          Util.closeQuietly(((Connection)((Iterator)???).next()).getSocket());
        }
      }
    }
  };
  private final ExecutorService executorService = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory("OkHttp ConnectionPool", true));
  private final long keepAliveDurationNs;
  private final int maxIdleConnections;
  
  static
  {
    String str1 = System.getProperty("http.keepAlive");
    String str2 = System.getProperty("http.keepAliveDuration");
    String str3 = System.getProperty("http.maxConnections");
    if (str2 != null) {}
    for (long l = Long.parseLong(str2); (str1 != null) && (!Boolean.parseBoolean(str1)); l = 300000L)
    {
      systemDefault = new ConnectionPool(0, l);
      return;
    }
    if (str3 != null)
    {
      systemDefault = new ConnectionPool(Integer.parseInt(str3), l);
      return;
    }
    systemDefault = new ConnectionPool(5, l);
  }
  
  public ConnectionPool(int paramInt, long paramLong)
  {
    this.maxIdleConnections = paramInt;
    this.keepAliveDurationNs = (paramLong * 1000L * 1000L);
  }
  
  public static ConnectionPool getDefault()
  {
    return systemDefault;
  }
  
  private void waitForCleanupCallableToRun()
  {
    try
    {
      this.executorService.submit(new Runnable()
      {
        public void run() {}
      }).get();
      return;
    }
    catch (Exception localException)
    {
      throw new AssertionError();
    }
  }
  
  public void evictAll()
  {
    try
    {
      ArrayList localArrayList = new ArrayList(this.connections);
      this.connections.clear();
      int i = 0;
      int j = localArrayList.size();
      while (i < j)
      {
        Util.closeQuietly(((Connection)localArrayList.get(i)).getSocket());
        i += 1;
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public Connection get(Address paramAddress)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_0
    //   6: getfield 72	com/squareup/okhttp/ConnectionPool:connections	Ljava/util/LinkedList;
    //   9: aload_0
    //   10: getfield 72	com/squareup/okhttp/ConnectionPool:connections	Ljava/util/LinkedList;
    //   13: invokevirtual 168	java/util/LinkedList:size	()I
    //   16: invokevirtual 172	java/util/LinkedList:listIterator	(I)Ljava/util/ListIterator;
    //   19: astore 5
    //   21: aload 4
    //   23: astore_3
    //   24: aload 5
    //   26: invokeinterface 178 1 0
    //   31: ifeq +77 -> 108
    //   34: aload 5
    //   36: invokeinterface 181 1 0
    //   41: checkcast 156	com/squareup/okhttp/Connection
    //   44: astore_3
    //   45: aload_3
    //   46: invokevirtual 185	com/squareup/okhttp/Connection:getRoute	()Lcom/squareup/okhttp/Route;
    //   49: invokevirtual 191	com/squareup/okhttp/Route:getAddress	()Lcom/squareup/okhttp/Address;
    //   52: aload_1
    //   53: invokevirtual 197	com/squareup/okhttp/Address:equals	(Ljava/lang/Object;)Z
    //   56: ifeq -35 -> 21
    //   59: aload_3
    //   60: invokevirtual 200	com/squareup/okhttp/Connection:isAlive	()Z
    //   63: ifeq -42 -> 21
    //   66: invokestatic 204	java/lang/System:nanoTime	()J
    //   69: aload_3
    //   70: invokevirtual 207	com/squareup/okhttp/Connection:getIdleStartTimeNs	()J
    //   73: lsub
    //   74: aload_0
    //   75: getfield 109	com/squareup/okhttp/ConnectionPool:keepAliveDurationNs	J
    //   78: lcmp
    //   79: ifge -58 -> 21
    //   82: aload 5
    //   84: invokeinterface 210 1 0
    //   89: aload_3
    //   90: invokevirtual 213	com/squareup/okhttp/Connection:isSpdy	()Z
    //   93: istore_2
    //   94: iload_2
    //   95: ifne +13 -> 108
    //   98: invokestatic 218	com/squareup/okhttp/internal/Platform:get	()Lcom/squareup/okhttp/internal/Platform;
    //   101: aload_3
    //   102: invokevirtual 160	com/squareup/okhttp/Connection:getSocket	()Ljava/net/Socket;
    //   105: invokevirtual 221	com/squareup/okhttp/internal/Platform:tagSocket	(Ljava/net/Socket;)V
    //   108: aload_3
    //   109: ifnull +18 -> 127
    //   112: aload_3
    //   113: invokevirtual 213	com/squareup/okhttp/Connection:isSpdy	()Z
    //   116: ifeq +11 -> 127
    //   119: aload_0
    //   120: getfield 72	com/squareup/okhttp/ConnectionPool:connections	Ljava/util/LinkedList;
    //   123: aload_3
    //   124: invokevirtual 225	java/util/LinkedList:addFirst	(Ljava/lang/Object;)V
    //   127: aload_0
    //   128: getfield 98	com/squareup/okhttp/ConnectionPool:executorService	Ljava/util/concurrent/ExecutorService;
    //   131: aload_0
    //   132: getfield 103	com/squareup/okhttp/ConnectionPool:connectionsCleanupRunnable	Ljava/lang/Runnable;
    //   135: invokeinterface 229 2 0
    //   140: aload_0
    //   141: monitorexit
    //   142: aload_3
    //   143: areturn
    //   144: astore 6
    //   146: aload_3
    //   147: invokevirtual 160	com/squareup/okhttp/Connection:getSocket	()Ljava/net/Socket;
    //   150: invokestatic 164	com/squareup/okhttp/internal/Util:closeQuietly	(Ljava/net/Socket;)V
    //   153: invokestatic 218	com/squareup/okhttp/internal/Platform:get	()Lcom/squareup/okhttp/internal/Platform;
    //   156: new 231	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   163: ldc -22
    //   165: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: aload 6
    //   170: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   173: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokevirtual 249	com/squareup/okhttp/internal/Platform:logW	(Ljava/lang/String;)V
    //   179: goto -158 -> 21
    //   182: astore_1
    //   183: aload_0
    //   184: monitorexit
    //   185: aload_1
    //   186: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	187	0	this	ConnectionPool
    //   0	187	1	paramAddress	Address
    //   93	2	2	bool	boolean
    //   23	124	3	localObject1	Object
    //   3	19	4	localObject2	Object
    //   19	64	5	localListIterator	ListIterator
    //   144	25	6	localSocketException	java.net.SocketException
    // Exception table:
    //   from	to	target	type
    //   98	108	144	java/net/SocketException
    //   5	21	182	finally
    //   24	94	182	finally
    //   98	108	182	finally
    //   112	127	182	finally
    //   127	140	182	finally
    //   146	179	182	finally
  }
  
  public int getConnectionCount()
  {
    try
    {
      int i = this.connections.size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  List<Connection> getConnections()
  {
    waitForCleanupCallableToRun();
    try
    {
      ArrayList localArrayList = new ArrayList(this.connections);
      return localArrayList;
    }
    finally {}
  }
  
  public int getHttpConnectionCount()
  {
    int i = 0;
    try
    {
      Iterator localIterator = this.connections.iterator();
      while (localIterator.hasNext())
      {
        boolean bool = ((Connection)localIterator.next()).isSpdy();
        if (!bool) {
          i += 1;
        }
      }
      return i;
    }
    finally {}
  }
  
  public int getSpdyConnectionCount()
  {
    int i = 0;
    try
    {
      Iterator localIterator = this.connections.iterator();
      while (localIterator.hasNext())
      {
        boolean bool = ((Connection)localIterator.next()).isSpdy();
        if (bool) {
          i += 1;
        }
      }
      return i;
    }
    finally {}
  }
  
  /* Error */
  void recycle(Connection paramConnection)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 213	com/squareup/okhttp/Connection:isSpdy	()Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aload_1
    //   9: invokevirtual 275	com/squareup/okhttp/Connection:clearOwner	()Z
    //   12: ifeq -5 -> 7
    //   15: aload_1
    //   16: invokevirtual 200	com/squareup/okhttp/Connection:isAlive	()Z
    //   19: ifne +11 -> 30
    //   22: aload_1
    //   23: invokevirtual 160	com/squareup/okhttp/Connection:getSocket	()Ljava/net/Socket;
    //   26: invokestatic 164	com/squareup/okhttp/internal/Util:closeQuietly	(Ljava/net/Socket;)V
    //   29: return
    //   30: invokestatic 218	com/squareup/okhttp/internal/Platform:get	()Lcom/squareup/okhttp/internal/Platform;
    //   33: aload_1
    //   34: invokevirtual 160	com/squareup/okhttp/Connection:getSocket	()Ljava/net/Socket;
    //   37: invokevirtual 278	com/squareup/okhttp/internal/Platform:untagSocket	(Ljava/net/Socket;)V
    //   40: aload_0
    //   41: monitorenter
    //   42: aload_0
    //   43: getfield 72	com/squareup/okhttp/ConnectionPool:connections	Ljava/util/LinkedList;
    //   46: aload_1
    //   47: invokevirtual 225	java/util/LinkedList:addFirst	(Ljava/lang/Object;)V
    //   50: aload_1
    //   51: invokevirtual 281	com/squareup/okhttp/Connection:incrementRecycleCount	()V
    //   54: aload_1
    //   55: invokevirtual 284	com/squareup/okhttp/Connection:resetIdleStartTime	()V
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_0
    //   61: getfield 98	com/squareup/okhttp/ConnectionPool:executorService	Ljava/util/concurrent/ExecutorService;
    //   64: aload_0
    //   65: getfield 103	com/squareup/okhttp/ConnectionPool:connectionsCleanupRunnable	Ljava/lang/Runnable;
    //   68: invokeinterface 229 2 0
    //   73: return
    //   74: astore_2
    //   75: invokestatic 218	com/squareup/okhttp/internal/Platform:get	()Lcom/squareup/okhttp/internal/Platform;
    //   78: new 231	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   85: ldc_w 286
    //   88: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload_2
    //   92: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   95: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokevirtual 249	com/squareup/okhttp/internal/Platform:logW	(Ljava/lang/String;)V
    //   101: aload_1
    //   102: invokevirtual 160	com/squareup/okhttp/Connection:getSocket	()Ljava/net/Socket;
    //   105: invokestatic 164	com/squareup/okhttp/internal/Util:closeQuietly	(Ljava/net/Socket;)V
    //   108: return
    //   109: astore_1
    //   110: aload_0
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	this	ConnectionPool
    //   0	114	1	paramConnection	Connection
    //   74	18	2	localSocketException	java.net.SocketException
    // Exception table:
    //   from	to	target	type
    //   30	40	74	java/net/SocketException
    //   42	60	109	finally
    //   110	112	109	finally
  }
  
  void share(Connection paramConnection)
  {
    if (!paramConnection.isSpdy()) {
      throw new IllegalArgumentException();
    }
    this.executorService.execute(this.connectionsCleanupRunnable);
    if (paramConnection.isAlive()) {
      try
      {
        this.connections.addFirst(paramConnection);
        return;
      }
      finally {}
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/squareup/okhttp/ConnectionPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */