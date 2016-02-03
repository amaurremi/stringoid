package com.mapbar.android.location;

import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class q<Params, Progress, Result>
{
  private static final LinkedBlockingQueue<Runnable> a = new LinkedBlockingQueue();
  private static final ThreadFactory b = new r();
  private static final ThreadPoolExecutor c = new ThreadPoolExecutor(2, 2, 10L, TimeUnit.SECONDS, a, b);
  private static final a d = new a();
  private final c<Params, Result> e = new c()
  {
    public final Result call()
    {
      try
      {
        Process.setThreadPriority(10);
        q localq = q.this;
        Object[] arrayOfObject = this.a;
        localq.a();
        return null;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  };
  private final FutureTask<Result> f = new FutureTask(this.e)
  {
    protected final void done()
    {
      Object localObject1 = null;
      try
      {
        Object localObject2 = get();
        localObject1 = localObject2;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          Log.w("CellTaskEx", localInterruptedException);
        }
      }
      catch (ExecutionException localExecutionException)
      {
        throw new RuntimeException("An error occured while executing doInBackground()", localExecutionException.getCause());
      }
      catch (CancellationException localCancellationException)
      {
        q.d().obtainMessage(3, new p(q.this, null)).sendToTarget();
        return;
      }
      catch (Throwable localThrowable)
      {
        throw new RuntimeException("An error occured while executing doInBackground()", localThrowable);
      }
      q.d().obtainMessage(1, new p(q.this, new Object[] { localObject1 })).sendToTarget();
    }
  };
  private volatile b g = b.a;
  
  protected static void b() {}
  
  protected static void c() {}
  
  public final q<Params, Progress, Result> a(Params... paramVarArgs)
  {
    if (this.g != b.a) {}
    switch (3.a[this.g.ordinal()])
    {
    default: 
      this.g = b.b;
      this.e.a = paramVarArgs;
      c.execute(this.f);
      return this;
    case 1: 
      throw new IllegalStateException("Cannot execute task: the task is already running.");
    }
    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
  }
  
  protected abstract Result a();
  
  public final boolean a(boolean paramBoolean)
  {
    try
    {
      paramBoolean = this.f.cancel(true);
      return paramBoolean;
    }
    catch (Exception localException) {}
    return false;
  }
  
  static final class a
    extends Handler
  {
    private a(byte paramByte) {}
    
    public final void handleMessage(Message paramMessage)
    {
      p localp = (p)paramMessage.obj;
      switch (paramMessage.what)
      {
      default: 
        return;
      case 1: 
        q.a(localp.a, localp.b[0]);
        return;
      case 2: 
        paramMessage = localp.a;
        paramMessage = localp.b;
        q.b();
        return;
      }
      paramMessage = localp.a;
      q.c();
    }
  }
  
  public static enum b
  {
    private b() {}
    
    public static b[] a()
    {
      return (b[])d.clone();
    }
  }
  
  static abstract class c<Params, Result>
    implements Callable<Result>
  {
    Params[] a;
    
    private c(byte paramByte) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/mapbar/android/location/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */