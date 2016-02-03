package com.google.android.gms.internal;

import android.os.Process;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class bu
{
  private static final ThreadFactory Fn = new ThreadFactory()
  {
    private final AtomicInteger Fq = new AtomicInteger(1);
    
    public Thread newThread(Runnable paramAnonymousRunnable)
    {
      return new Thread(paramAnonymousRunnable, "AdWorker #" + this.Fq.getAndIncrement());
    }
  };
  private static final ThreadPoolExecutor Fo = new ThreadPoolExecutor(0, 10, 65L, TimeUnit.SECONDS, new SynchronousQueue(true), Fn);
  
  public static void execute(Runnable paramRunnable)
  {
    try
    {
      Fo.execute(new Runnable()
      {
        public void run()
        {
          Process.setThreadPriority(10);
          this.Fp.run();
        }
      });
      return;
    }
    catch (RejectedExecutionException paramRunnable)
    {
      ce.c("Too many background threads already running. Aborting task.", paramRunnable);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/bu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */