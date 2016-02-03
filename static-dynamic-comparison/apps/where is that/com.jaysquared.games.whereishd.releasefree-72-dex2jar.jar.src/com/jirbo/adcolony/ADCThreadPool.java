package com.jirbo.adcolony;

import java.util.ArrayList;
import java.util.Iterator;

class ADCThreadPool
{
  static ArrayList<ReusableThread> all_threads = new ArrayList();
  static ArrayList<ReusableThread> idle_threads;
  static String mutex = new String("mutex");
  static ArrayList<Runnable> pending_runnables = new ArrayList();
  static volatile boolean shutting_down;
  static ArrayList<Runnable> working_runnables = new ArrayList();
  
  static
  {
    idle_threads = new ArrayList();
  }
  
  static void reset()
  {
    
    synchronized (mutex)
    {
      pending_runnables.clear();
      start();
      return;
    }
  }
  
  static void run(Runnable paramRunnable)
  {
    ??? = null;
    synchronized (mutex)
    {
      if (shutting_down)
      {
        pending_runnables.add(paramRunnable);
        return;
      }
      int i = idle_threads.size();
      if (i > 0) {
        ??? = (ReusableThread)idle_threads.remove(i - 1);
      }
      if (??? != null) {
        break label99;
      }
      ??? = new ReusableThread();
    }
    synchronized (mutex)
    {
      all_threads.add(???);
      ((ReusableThread)???).target = paramRunnable;
      ((ReusableThread)???).start();
      return;
      paramRunnable = finally;
      throw paramRunnable;
    }
    try
    {
      label99:
      ((ReusableThread)???).target = paramRunnable;
      ???.notify();
      return;
    }
    finally {}
  }
  
  static void start()
  {
    synchronized (mutex)
    {
      shutting_down = false;
      working_runnables.clear();
      working_runnables.addAll(pending_runnables);
      pending_runnables.clear();
      all_threads.clear();
      ??? = working_runnables.iterator();
      if (((Iterator)???).hasNext()) {
        run((Runnable)((Iterator)???).next());
      }
    }
  }
  
  static void stop()
  {
    synchronized (mutex)
    {
      shutting_down = true;
      Iterator localIterator = idle_threads.iterator();
      while (localIterator.hasNext()) {
        synchronized ((ReusableThread)localIterator.next())
        {
          ???.notify();
        }
      }
    }
    synchronized (mutex)
    {
      idle_threads.clear();
      return;
    }
  }
  
  static class ReusableThread
    extends Thread
  {
    Runnable target;
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 21	com/jirbo/adcolony/ADCThreadPool$ReusableThread:target	Ljava/lang/Runnable;
      //   4: ifnull +17 -> 21
      //   7: aload_0
      //   8: getfield 21	com/jirbo/adcolony/ADCThreadPool$ReusableThread:target	Ljava/lang/Runnable;
      //   11: invokeinterface 25 1 0
      //   16: aload_0
      //   17: aconst_null
      //   18: putfield 21	com/jirbo/adcolony/ADCThreadPool$ReusableThread:target	Ljava/lang/Runnable;
      //   21: getstatic 29	com/jirbo/adcolony/ADCThreadPool:shutting_down	Z
      //   24: ifeq +39 -> 63
      //   27: return
      //   28: astore_1
      //   29: ldc 31
      //   31: invokestatic 37	com/jirbo/adcolony/ADC:log_error	(Ljava/lang/String;)V
      //   34: new 39	java/lang/StringBuilder
      //   37: dup
      //   38: invokespecial 40	java/lang/StringBuilder:<init>	()V
      //   41: aload_1
      //   42: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   45: ldc 46
      //   47: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   50: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   53: invokestatic 37	com/jirbo/adcolony/ADC:log_error	(Ljava/lang/String;)V
      //   56: aload_1
      //   57: invokevirtual 56	java/lang/RuntimeException:printStackTrace	()V
      //   60: goto -44 -> 16
      //   63: aload_0
      //   64: monitorenter
      //   65: getstatic 60	com/jirbo/adcolony/ADCThreadPool:mutex	Ljava/lang/String;
      //   68: astore_1
      //   69: aload_1
      //   70: monitorenter
      //   71: getstatic 64	com/jirbo/adcolony/ADCThreadPool:idle_threads	Ljava/util/ArrayList;
      //   74: aload_0
      //   75: invokevirtual 70	java/util/ArrayList:add	(Ljava/lang/Object;)Z
      //   78: pop
      //   79: aload_1
      //   80: monitorexit
      //   81: aload_0
      //   82: invokevirtual 75	java/lang/Object:wait	()V
      //   85: aload_0
      //   86: monitorexit
      //   87: goto -87 -> 0
      //   90: astore_1
      //   91: aload_0
      //   92: monitorexit
      //   93: aload_1
      //   94: athrow
      //   95: astore_2
      //   96: aload_1
      //   97: monitorexit
      //   98: aload_2
      //   99: athrow
      //   100: astore_1
      //   101: goto -16 -> 85
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	104	0	this	ReusableThread
      //   28	29	1	localRuntimeException	RuntimeException
      //   90	7	1	localObject1	Object
      //   100	1	1	localInterruptedException	InterruptedException
      //   95	4	2	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   7	16	28	java/lang/RuntimeException
      //   65	71	90	finally
      //   81	85	90	finally
      //   85	87	90	finally
      //   91	93	90	finally
      //   98	100	90	finally
      //   71	81	95	finally
      //   96	98	95	finally
      //   81	85	100	java/lang/InterruptedException
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jirbo/adcolony/ADCThreadPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */