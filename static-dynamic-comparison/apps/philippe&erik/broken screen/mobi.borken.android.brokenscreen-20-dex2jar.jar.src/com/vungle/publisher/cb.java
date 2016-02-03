package com.vungle.publisher;

import com.vungle.publisher.log.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class cb
  extends ScheduledThreadPoolExecutor
  implements ch, ch.a.a
{
  final ch.a a;
  final int b;
  final List<b> c = new ArrayList();
  final AtomicBoolean d = new AtomicBoolean(false);
  final AtomicInteger e = new AtomicInteger();
  
  public cb(int paramInt1, ThreadFactory paramThreadFactory, ch.a parama, int paramInt2)
  {
    super(paramInt1, paramThreadFactory);
    this.a = parama;
    this.b = paramInt2;
  }
  
  private int a()
  {
    return getQueue().size();
  }
  
  public final void a(int paramInt)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).b(paramInt);
    }
    super.shutdown();
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).a(paramInt1, paramInt2);
    }
  }
  
  protected final void afterExecute(Runnable paramRunnable, Throwable paramThrowable)
  {
    super.afterExecute(paramRunnable, paramThrowable);
    if (paramThrowable == null)
    {
      paramRunnable = (a)paramRunnable;
      if (paramRunnable.isDone()) {
        try
        {
          paramRunnable.get();
          if ((paramRunnable.a != null) && ((paramRunnable.a instanceof c)))
          {
            i = 1;
            if (i == 0) {
              break label211;
            }
            i = this.e.get();
            j = a();
            paramRunnable = this.c.iterator();
            while (paramRunnable.hasNext()) {
              ((b)paramRunnable.next()).b(i, j);
            }
          }
        }
        catch (CancellationException paramThrowable)
        {
          for (;;)
          {
            Logger.d("VungleService", Thread.currentThread().getName() + " cancelled: continuing post execution");
          }
        }
        catch (InterruptedException paramThrowable)
        {
          for (;;)
          {
            Logger.w("VungleService", Thread.currentThread().getName() + " interrupted: continuing post execution");
          }
        }
        catch (ExecutionException paramThrowable)
        {
          int i;
          int j;
          for (;;)
          {
            Logger.e("VungleService", Thread.currentThread().getName() + " exception", paramThrowable.getCause());
            continue;
            i = 0;
            continue;
            label211:
            i = this.e.incrementAndGet();
          }
          if ((j == 0) && (!isShutdown()) && (this.d.compareAndSet(false, true)))
          {
            paramRunnable = this.c.iterator();
            while (paramRunnable.hasNext()) {
              ((b)paramRunnable.next()).a(i);
            }
          }
          try
          {
            schedule(new c(i), this.b, TimeUnit.SECONDS);
            return;
          }
          finally
          {
            this.d.set(false);
          }
        }
      }
      Logger.w("VungleService", Thread.currentThread().getName() + " afterExecute() called before task done");
      return;
    }
    Logger.e("VungleService", Thread.currentThread().getName() + " exception", paramThrowable);
  }
  
  public final void b(int paramInt1, int paramInt2)
  {
    List localList = super.shutdownNow();
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).a(paramInt1, paramInt2, localList);
    }
  }
  
  protected final void beforeExecute(Thread paramThread, Runnable paramRunnable)
  {
    super.beforeExecute(paramThread, paramRunnable);
    int i = this.e.get();
    int j = a();
    Runnable localRunnable = paramRunnable;
    if (paramRunnable != null)
    {
      localRunnable = paramRunnable;
      if ((paramRunnable instanceof a)) {
        localRunnable = a.a((a)paramRunnable);
      }
    }
    paramRunnable = this.c.iterator();
    while (paramRunnable.hasNext()) {
      ((b)paramRunnable.next()).a(paramThread, localRunnable, i, j);
    }
  }
  
  protected final <V> RunnableScheduledFuture<V> decorateTask(Runnable paramRunnable, RunnableScheduledFuture<V> paramRunnableScheduledFuture)
  {
    return new a(paramRunnable, paramRunnableScheduledFuture);
  }
  
  protected final <V> RunnableScheduledFuture<V> decorateTask(Callable<V> paramCallable, RunnableScheduledFuture<V> paramRunnableScheduledFuture)
  {
    throw new UnsupportedOperationException();
  }
  
  protected final void finalize()
  {
    int i = this.e.get();
    this.a.a(i, this);
  }
  
  protected final void terminated()
  {
    super.terminated();
    int i = this.e.get();
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).c(i);
    }
  }
  
  static final class a<V>
    implements RunnableScheduledFuture<V>
  {
    Runnable a;
    private final RunnableScheduledFuture<V> b;
    
    a(Runnable paramRunnable, RunnableScheduledFuture<V> paramRunnableScheduledFuture)
    {
      this.a = paramRunnable;
      this.b = paramRunnableScheduledFuture;
    }
    
    public final boolean cancel(boolean paramBoolean)
    {
      return this.b.cancel(paramBoolean);
    }
    
    public final V get()
      throws InterruptedException, ExecutionException
    {
      return (V)this.b.get();
    }
    
    public final V get(long paramLong, TimeUnit paramTimeUnit)
      throws InterruptedException, ExecutionException, TimeoutException
    {
      return (V)this.b.get(paramLong, paramTimeUnit);
    }
    
    public final long getDelay(TimeUnit paramTimeUnit)
    {
      return this.b.getDelay(paramTimeUnit);
    }
    
    public final boolean isCancelled()
    {
      return this.b.isCancelled();
    }
    
    public final boolean isDone()
    {
      return this.b.isDone();
    }
    
    public final boolean isPeriodic()
    {
      return this.b.isPeriodic();
    }
    
    public final void run()
    {
      this.b.run();
    }
  }
  
  static abstract interface b
  {
    public abstract void a(int paramInt);
    
    public abstract void a(int paramInt1, int paramInt2);
    
    public abstract void a(int paramInt1, int paramInt2, List<Runnable> paramList);
    
    public abstract void a(Thread paramThread, Runnable paramRunnable, int paramInt1, int paramInt2);
    
    public abstract void b(int paramInt);
    
    public abstract void b(int paramInt1, int paramInt2);
    
    public abstract void c(int paramInt);
  }
  
  final class c
    implements Runnable
  {
    private final int b;
    
    c(int paramInt)
    {
      this.b = paramInt;
    }
    
    public final void run()
    {
      cb.this.a.b(this.b, cb.this);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/cb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */