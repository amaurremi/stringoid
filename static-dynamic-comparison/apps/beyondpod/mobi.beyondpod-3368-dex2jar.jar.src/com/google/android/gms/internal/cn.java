package com.google.android.gms.internal;

import android.os.Process;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class cn
{
  private static final ThreadPoolExecutor iA = new ThreadPoolExecutor(0, 10, 65L, TimeUnit.SECONDS, new SynchronousQueue(true), iz);
  private static final ThreadFactory iz = new ThreadFactory()
  {
    private final AtomicInteger iC = new AtomicInteger(1);
    
    public Thread newThread(Runnable paramAnonymousRunnable)
    {
      return new Thread(paramAnonymousRunnable, "AdWorker #" + this.iC.getAndIncrement());
    }
  };
  
  public static void execute(Runnable paramRunnable)
  {
    try
    {
      iA.execute(new Runnable()
      {
        public void run()
        {
          Process.setThreadPriority(10);
          this.iB.run();
        }
      });
      return;
    }
    catch (RejectedExecutionException paramRunnable)
    {
      ct.b("Too many background threads already running. Aborting task.", paramRunnable);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/cn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */