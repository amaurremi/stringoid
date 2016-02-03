package com.google.android.gms.internal;

import android.os.Process;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class eo
{
  private static final ThreadFactory se = new ThreadFactory()
  {
    private final AtomicInteger sh = new AtomicInteger(1);
    
    public Thread newThread(Runnable paramAnonymousRunnable)
    {
      return new Thread(paramAnonymousRunnable, "AdWorker #" + this.sh.getAndIncrement());
    }
  };
  private static final ThreadPoolExecutor sf = new ThreadPoolExecutor(0, 10, 65L, TimeUnit.SECONDS, new SynchronousQueue(true), se);
  
  public static void execute(Runnable paramRunnable)
  {
    try
    {
      sf.execute(new Runnable()
      {
        public void run()
        {
          Process.setThreadPriority(10);
          this.sg.run();
        }
      });
      return;
    }
    catch (RejectedExecutionException paramRunnable)
    {
      ev.c("Too many background threads already running. Aborting task.  Current pool size: " + getPoolSize(), paramRunnable);
    }
  }
  
  public static int getPoolSize()
  {
    return sf.getPoolSize();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/eo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */