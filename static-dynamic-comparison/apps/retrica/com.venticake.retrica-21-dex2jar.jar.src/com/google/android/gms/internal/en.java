package com.google.android.gms.internal;

import android.os.Process;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class en
{
  private static final ThreadFactory sh = new ThreadFactory()
  {
    private final AtomicInteger a = new AtomicInteger(1);
    
    public Thread newThread(Runnable paramAnonymousRunnable)
    {
      return new Thread(paramAnonymousRunnable, "AdWorker #" + this.a.getAndIncrement());
    }
  };
  private static final ThreadPoolExecutor si = new ThreadPoolExecutor(0, 10, 65L, TimeUnit.SECONDS, new SynchronousQueue(true), sh);
  
  public static void execute(Runnable paramRunnable)
  {
    try
    {
      si.execute(new Runnable()
      {
        public void run()
        {
          Process.setThreadPriority(10);
          en.this.run();
        }
      });
      return;
    }
    catch (RejectedExecutionException paramRunnable)
    {
      eu.c("Too many background threads already running. Aborting task.  Current pool size: " + getPoolSize(), paramRunnable);
    }
  }
  
  public static int getPoolSize()
  {
    return si.getPoolSize();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/en.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */