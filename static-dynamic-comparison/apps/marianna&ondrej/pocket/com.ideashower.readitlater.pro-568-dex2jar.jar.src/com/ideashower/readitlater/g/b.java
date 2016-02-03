package com.ideashower.readitlater.g;

import com.ideashower.readitlater.util.e;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class b
  extends ThreadPoolExecutor
{
  private final AtomicBoolean a = new AtomicBoolean(false);
  private final ReentrantLock b = new ReentrantLock();
  private final Condition c = this.b.newCondition();
  private c d;
  private final AtomicInteger e = new AtomicInteger();
  
  public b(int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit, BlockingQueue paramBlockingQueue, String paramString)
  {
    super(paramInt1, paramInt2, paramLong, paramTimeUnit, paramBlockingQueue, a(paramString));
  }
  
  private static ThreadFactory a(String paramString)
  {
    return new org.apache.a.c.b.b().a("pkt-" + paramString + "-%d").b();
  }
  
  public void a()
  {
    if (!this.a.get()) {
      this.b.lock();
    }
    try
    {
      this.a.set(true);
      return;
    }
    finally
    {
      this.b.unlock();
    }
  }
  
  protected void a(c paramc)
  {
    this.d = paramc;
  }
  
  protected void afterExecute(Runnable paramRunnable, Throwable paramThrowable)
  {
    this.e.decrementAndGet();
    if (this.d != null) {
      this.d.a(paramRunnable);
    }
    super.afterExecute(paramRunnable, paramThrowable);
    Throwable localThrowable1 = paramThrowable;
    if (paramThrowable == null)
    {
      localThrowable1 = paramThrowable;
      if (!(paramRunnable instanceof Future)) {}
    }
    try
    {
      ((Future)paramRunnable).get();
      localThrowable1 = paramThrowable;
    }
    catch (CancellationException localCancellationException)
    {
      for (;;) {}
    }
    catch (ExecutionException paramRunnable)
    {
      for (;;)
      {
        localThrowable2 = paramRunnable.getCause();
      }
    }
    catch (InterruptedException paramRunnable)
    {
      for (;;)
      {
        Thread.currentThread().interrupt();
        Throwable localThrowable2 = paramThrowable;
      }
    }
    if (localThrowable1 != null) {
      e.a(localThrowable1);
    }
  }
  
  public void b()
  {
    if (this.a.get()) {
      this.b.lock();
    }
    try
    {
      this.a.set(false);
      this.c.signalAll();
      return;
    }
    finally
    {
      this.b.unlock();
    }
  }
  
  /* Error */
  protected void beforeExecute(Thread paramThread, Runnable paramRunnable)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 47	com/ideashower/readitlater/g/b:e	Ljava/util/concurrent/atomic/AtomicInteger;
    //   4: invokevirtual 140	java/util/concurrent/atomic/AtomicInteger:incrementAndGet	()I
    //   7: pop
    //   8: aload_0
    //   9: getfield 88	com/ideashower/readitlater/g/b:d	Lcom/ideashower/readitlater/g/c;
    //   12: ifnull +13 -> 25
    //   15: aload_0
    //   16: getfield 88	com/ideashower/readitlater/g/b:d	Lcom/ideashower/readitlater/g/c;
    //   19: aload_2
    //   20: invokeinterface 142 2 0
    //   25: aload_0
    //   26: aload_1
    //   27: aload_2
    //   28: invokespecial 144	java/util/concurrent/ThreadPoolExecutor:beforeExecute	(Ljava/lang/Thread;Ljava/lang/Runnable;)V
    //   31: aload_0
    //   32: getfield 36	com/ideashower/readitlater/g/b:b	Ljava/util/concurrent/locks/ReentrantLock;
    //   35: invokevirtual 79	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   38: aload_0
    //   39: getfield 29	com/ideashower/readitlater/g/b:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   42: invokevirtual 76	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   45: ifeq +28 -> 73
    //   48: aload_0
    //   49: getfield 42	com/ideashower/readitlater/g/b:c	Ljava/util/concurrent/locks/Condition;
    //   52: invokeinterface 147 1 0
    //   57: goto -19 -> 38
    //   60: astore_2
    //   61: aload_1
    //   62: invokevirtual 130	java/lang/Thread:interrupt	()V
    //   65: aload_0
    //   66: getfield 36	com/ideashower/readitlater/g/b:b	Ljava/util/concurrent/locks/ReentrantLock;
    //   69: invokevirtual 85	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   72: return
    //   73: aload_0
    //   74: getfield 36	com/ideashower/readitlater/g/b:b	Ljava/util/concurrent/locks/ReentrantLock;
    //   77: invokevirtual 85	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   80: return
    //   81: astore_1
    //   82: aload_0
    //   83: getfield 36	com/ideashower/readitlater/g/b:b	Ljava/util/concurrent/locks/ReentrantLock;
    //   86: invokevirtual 85	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   89: aload_1
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	b
    //   0	91	1	paramThread	Thread
    //   0	91	2	paramRunnable	Runnable
    // Exception table:
    //   from	to	target	type
    //   38	57	60	java/lang/InterruptedException
    //   38	57	81	finally
    //   61	65	81	finally
  }
  
  public void shutdown()
  {
    b();
    super.shutdown();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/g/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */