package com.amazonaws.http;

import com.amazonaws.org.apache.http.conn.ClientConnectionManager;
import java.util.ArrayList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public final class IdleConnectionReaper
  extends Thread
{
  private static final ArrayList<ClientConnectionManager> connectionManagers = new ArrayList();
  private static IdleConnectionReaper instance;
  static final Log log = LogFactory.getLog(IdleConnectionReaper.class);
  private volatile boolean shuttingDown;
  
  private IdleConnectionReaper()
  {
    super("java-sdk-http-connection-reaper");
    setDaemon(true);
  }
  
  private void markShuttingDown()
  {
    this.shuttingDown = true;
  }
  
  public static boolean registerConnectionManager(ClientConnectionManager paramClientConnectionManager)
  {
    try
    {
      if (instance == null)
      {
        instance = new IdleConnectionReaper();
        instance.start();
      }
      boolean bool = connectionManagers.add(paramClientConnectionManager);
      return bool;
    }
    finally {}
  }
  
  public static boolean removeConnectionManager(ClientConnectionManager paramClientConnectionManager)
  {
    try
    {
      boolean bool = connectionManagers.remove(paramClientConnectionManager);
      if (connectionManagers.isEmpty()) {
        shutdown();
      }
      return bool;
    }
    finally
    {
      paramClientConnectionManager = finally;
      throw paramClientConnectionManager;
    }
  }
  
  /* Error */
  public static boolean shutdown()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 47	com/amazonaws/http/IdleConnectionReaper:instance	Lcom/amazonaws/http/IdleConnectionReaper;
    //   6: ifnull +32 -> 38
    //   9: getstatic 47	com/amazonaws/http/IdleConnectionReaper:instance	Lcom/amazonaws/http/IdleConnectionReaper;
    //   12: invokespecial 68	com/amazonaws/http/IdleConnectionReaper:markShuttingDown	()V
    //   15: getstatic 47	com/amazonaws/http/IdleConnectionReaper:instance	Lcom/amazonaws/http/IdleConnectionReaper;
    //   18: invokevirtual 71	com/amazonaws/http/IdleConnectionReaper:interrupt	()V
    //   21: getstatic 22	com/amazonaws/http/IdleConnectionReaper:connectionManagers	Ljava/util/ArrayList;
    //   24: invokevirtual 74	java/util/ArrayList:clear	()V
    //   27: aconst_null
    //   28: putstatic 47	com/amazonaws/http/IdleConnectionReaper:instance	Lcom/amazonaws/http/IdleConnectionReaper;
    //   31: iconst_1
    //   32: istore_0
    //   33: ldc 2
    //   35: monitorexit
    //   36: iload_0
    //   37: ireturn
    //   38: iconst_0
    //   39: istore_0
    //   40: goto -7 -> 33
    //   43: astore_1
    //   44: ldc 2
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   32	8	0	bool	boolean
    //   43	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	31	43	finally
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 43	com/amazonaws/http/IdleConnectionReaper:shuttingDown	Z
    //   4: ifeq +14 -> 18
    //   7: getstatic 30	com/amazonaws/http/IdleConnectionReaper:log	Lorg/apache/commons/logging/Log;
    //   10: ldc 81
    //   12: invokeinterface 87 2 0
    //   17: return
    //   18: ldc2_w 88
    //   21: invokestatic 93	java/lang/Thread:sleep	(J)V
    //   24: ldc 2
    //   26: monitorenter
    //   27: getstatic 22	com/amazonaws/http/IdleConnectionReaper:connectionManagers	Ljava/util/ArrayList;
    //   30: invokevirtual 97	java/util/ArrayList:clone	()Ljava/lang/Object;
    //   33: checkcast 99	java/util/List
    //   36: astore_1
    //   37: ldc 2
    //   39: monitorexit
    //   40: aload_1
    //   41: invokeinterface 103 1 0
    //   46: astore_1
    //   47: aload_1
    //   48: invokeinterface 108 1 0
    //   53: ifeq -53 -> 0
    //   56: aload_1
    //   57: invokeinterface 111 1 0
    //   62: checkcast 113	com/amazonaws/org/apache/http/conn/ClientConnectionManager
    //   65: astore_2
    //   66: aload_2
    //   67: ldc2_w 114
    //   70: getstatic 121	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   73: invokeinterface 125 4 0
    //   78: goto -31 -> 47
    //   81: astore_2
    //   82: getstatic 30	com/amazonaws/http/IdleConnectionReaper:log	Lorg/apache/commons/logging/Log;
    //   85: ldc 127
    //   87: aload_2
    //   88: invokeinterface 131 3 0
    //   93: goto -46 -> 47
    //   96: astore_1
    //   97: getstatic 30	com/amazonaws/http/IdleConnectionReaper:log	Lorg/apache/commons/logging/Log;
    //   100: ldc -123
    //   102: aload_1
    //   103: invokeinterface 135 3 0
    //   108: goto -108 -> 0
    //   111: astore_1
    //   112: ldc 2
    //   114: monitorexit
    //   115: aload_1
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	IdleConnectionReaper
    //   36	21	1	localObject1	Object
    //   96	7	1	localThrowable	Throwable
    //   111	5	1	localObject2	Object
    //   65	2	2	localClientConnectionManager	ClientConnectionManager
    //   81	7	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   66	78	81	java/lang/Exception
    //   18	27	96	java/lang/Throwable
    //   40	47	96	java/lang/Throwable
    //   47	66	96	java/lang/Throwable
    //   66	78	96	java/lang/Throwable
    //   82	93	96	java/lang/Throwable
    //   115	117	96	java/lang/Throwable
    //   27	40	111	finally
    //   112	115	111	finally
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/http/IdleConnectionReaper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */