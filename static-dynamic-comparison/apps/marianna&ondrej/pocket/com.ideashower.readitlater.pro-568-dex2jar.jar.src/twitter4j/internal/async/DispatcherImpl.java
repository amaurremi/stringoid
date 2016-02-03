package twitter4j.internal.async;

import java.util.LinkedList;
import java.util.List;
import twitter4j.conf.Configuration;

final class DispatcherImpl
  implements Dispatcher
{
  private boolean active = true;
  private final List q = new LinkedList();
  private ExecuteThread[] threads;
  final Object ticket = new Object();
  
  public DispatcherImpl(Configuration paramConfiguration)
  {
    this.threads = new ExecuteThread[paramConfiguration.getAsyncNumThreads()];
    int i = 0;
    while (i < this.threads.length)
    {
      this.threads[i] = new ExecuteThread("Twitter4J Async Dispatcher", this, i);
      this.threads[i].setDaemon(true);
      this.threads[i].start();
      i += 1;
    }
    Runtime.getRuntime().addShutdownHook(new Thread()
    {
      public void run()
      {
        if (DispatcherImpl.this.active) {
          DispatcherImpl.this.shutdown();
        }
      }
    });
  }
  
  /* Error */
  public void invokeLater(Runnable arg1)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 26	twitter4j/internal/async/DispatcherImpl:q	Ljava/util/List;
    //   6: astore_2
    //   7: aload_2
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 26	twitter4j/internal/async/DispatcherImpl:q	Ljava/util/List;
    //   13: aload_1
    //   14: invokeinterface 76 2 0
    //   19: pop
    //   20: aload_2
    //   21: monitorexit
    //   22: aload_0
    //   23: getfield 28	twitter4j/internal/async/DispatcherImpl:ticket	Ljava/lang/Object;
    //   26: astore_1
    //   27: aload_1
    //   28: monitorenter
    //   29: aload_0
    //   30: getfield 28	twitter4j/internal/async/DispatcherImpl:ticket	Ljava/lang/Object;
    //   33: invokevirtual 79	java/lang/Object:notify	()V
    //   36: aload_1
    //   37: monitorexit
    //   38: aload_0
    //   39: monitorexit
    //   40: return
    //   41: astore_1
    //   42: aload_2
    //   43: monitorexit
    //   44: aload_1
    //   45: athrow
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    //   51: astore_2
    //   52: aload_1
    //   53: monitorexit
    //   54: aload_2
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	DispatcherImpl
    //   51	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	22	41	finally
    //   42	44	41	finally
    //   2	9	46	finally
    //   22	29	46	finally
    //   44	46	46	finally
    //   54	56	46	finally
    //   29	38	51	finally
    //   52	54	51	finally
  }
  
  public Runnable poll()
  {
    if (this.active) {
      synchronized (this.q)
      {
        if (this.q.size() > 0)
        {
          Runnable localRunnable = (Runnable)this.q.remove(0);
          if (localRunnable != null) {
            return localRunnable;
          }
        }
      }
    }
    try
    {
      synchronized (this.ticket)
      {
        this.ticket.wait();
      }
      localObject3 = finally;
      throw ((Throwable)localObject3);
      return null;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
  }
  
  /* Error */
  public void shutdown()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 30	twitter4j/internal/async/DispatcherImpl:active	Z
    //   8: ifeq +50 -> 58
    //   11: aload_0
    //   12: iconst_0
    //   13: putfield 30	twitter4j/internal/async/DispatcherImpl:active	Z
    //   16: aload_0
    //   17: getfield 40	twitter4j/internal/async/DispatcherImpl:threads	[Ltwitter4j/internal/async/ExecuteThread;
    //   20: astore_3
    //   21: aload_3
    //   22: arraylength
    //   23: istore_2
    //   24: iload_1
    //   25: iload_2
    //   26: if_icmpge +16 -> 42
    //   29: aload_3
    //   30: iload_1
    //   31: aaload
    //   32: invokevirtual 98	twitter4j/internal/async/ExecuteThread:shutdown	()V
    //   35: iload_1
    //   36: iconst_1
    //   37: iadd
    //   38: istore_1
    //   39: goto -15 -> 24
    //   42: aload_0
    //   43: getfield 28	twitter4j/internal/async/DispatcherImpl:ticket	Ljava/lang/Object;
    //   46: astore_3
    //   47: aload_3
    //   48: monitorenter
    //   49: aload_0
    //   50: getfield 28	twitter4j/internal/async/DispatcherImpl:ticket	Ljava/lang/Object;
    //   53: invokevirtual 79	java/lang/Object:notify	()V
    //   56: aload_3
    //   57: monitorexit
    //   58: aload_0
    //   59: monitorexit
    //   60: return
    //   61: astore 4
    //   63: aload_3
    //   64: monitorexit
    //   65: aload 4
    //   67: athrow
    //   68: astore_3
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_3
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	DispatcherImpl
    //   1	38	1	i	int
    //   23	4	2	j	int
    //   68	4	3	localObject2	Object
    //   61	5	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   49	58	61	finally
    //   63	65	61	finally
    //   4	24	68	finally
    //   29	35	68	finally
    //   42	49	68	finally
    //   65	68	68	finally
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/internal/async/DispatcherImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */