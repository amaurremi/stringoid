package com.vungle.publisher;

import android.content.Intent;
import com.vungle.publisher.log.Logger;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class ca
  extends bz<cb>
  implements cb.b
{
  protected final AtomicInteger d = new AtomicInteger();
  protected final AtomicInteger e = new AtomicInteger(-2);
  private final int f;
  private volatile cb g;
  private final Object h = this.e;
  
  public ca(String paramString, int paramInt1, int paramInt2)
  {
    super(paramString, paramInt2);
    this.f = paramInt1;
  }
  
  private cb a()
  {
    cb localcb = this.g;
    for (;;)
    {
      if (!b())
      {
        if (this.e.compareAndSet(-2, -1))
        {
          localcb = new cb(this.f, new ThreadFactory()
          {
            private int b;
            
            public final Thread newThread(Runnable paramAnonymousRunnable)
            {
              Object localObject = new StringBuilder().append(ca.this.a).append("-Thread-");
              int i = this.b;
              this.b = (i + 1);
              localObject = i;
              Logger.v("VungleService", (String)localObject + " starting");
              return new Thread(paramAnonymousRunnable, (String)localObject);
            }
          }, this, this.b);
          int i = 0;
          while (i <= 0)
          {
            ??? = new cb.b[] { this }[0];
            localcb.c.add(???);
            i += 1;
          }
          this.g = localcb;
          if (this.e.compareAndSet(-1, 0))
          {
            c();
            Logger.d("VungleService", this.a + " started: " + this.f + " workers, " + this.b + " second shutdown delay");
            continue;
          }
          Logger.w("VungleService", Thread.currentThread().getName() + " failed to mark started: expected state -1, but is " + this.e.get());
          continue;
        }
        try
        {
          synchronized (this.h)
          {
            if (!b()) {
              this.h.wait();
            }
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          Logger.v("VungleService", Thread.currentThread().getName() + " interrupted - resuming init/wait");
        }
      }
    }
    return localcb;
  }
  
  private void a(Iterable<Runnable> paramIterable)
  {
    if (paramIterable != null)
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext()) {
        a((Runnable)paramIterable.next(), 0, false);
      }
    }
  }
  
  private void a(Runnable paramRunnable, int paramInt, boolean paramBoolean)
  {
    cb localcb = a();
    for (;;)
    {
      int i = this.e.get();
      if (i < 0) {
        break;
      }
      int j = i + 1;
      if (this.e.compareAndSet(i, j))
      {
        if (paramBoolean) {
          this.d.incrementAndGet();
        }
        Logger.v("VungleService", this.a + " queuing runnable " + j + ", runnable className: " + paramRunnable.getClass().getName());
        localcb.schedule(paramRunnable, paramInt, TimeUnit.MILLISECONDS);
        return;
      }
      Logger.v("VungleService", Thread.currentThread().getName() + " retrying queue runnnable: expected " + i + " received tasks, but is " + this.e.get());
    }
  }
  
  private boolean b()
  {
    return this.e.get() >= 0;
  }
  
  private void c()
  {
    synchronized (this.h)
    {
      this.h.notifyAll();
      return;
    }
  }
  
  public abstract Runnable a(Intent paramIntent);
  
  public void a(int paramInt)
  {
    Logger.d("VungleService", this.a + " shutdown scheduled: " + paramInt + " completed tasks");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Logger.d("VungleService", Thread.currentThread().getName() + " shutdown cancelled: " + paramInt1 + " completed tasks, " + this.e.get() + " received tasks");
  }
  
  public void a(int paramInt1, int paramInt2, List<Runnable> paramList)
  {
    Logger.d("VungleService", this.a + " shutdown forced: " + paramInt1 + " completed tasks, " + paramInt2 + " received tasks");
    if (paramList == null) {}
    for (paramInt1 = 0;; paramInt1 = paramList.size())
    {
      if (paramInt1 > 0)
      {
        Logger.w("VungleService", this.a + " transferring " + paramInt1 + " orphaned tasks to new executor");
        a(paramList);
      }
      return;
    }
  }
  
  public void a(int paramInt, ch.a.a parama)
  {
    int i = this.d.get();
    parama.b(paramInt, this.e.getAndSet(-3));
    this.g = null;
    if (this.e.compareAndSet(-3, -2))
    {
      c();
      parama = this.c.iterator();
      while (parama.hasNext()) {
        ((ce.a)parama.next()).a(i);
      }
    }
    Logger.w("VungleService", Thread.currentThread().getName() + " failed to mark stopped: expected state -3, but is " + this.e.get());
  }
  
  public void a(Intent paramIntent, int paramInt)
  {
    try
    {
      a(a(paramIntent), 0, true);
      return;
    }
    catch (IllegalArgumentException paramIntent)
    {
      Logger.w("VungleService", this.a + ": " + paramIntent.getMessage());
    }
  }
  
  protected final void a(Runnable paramRunnable, int paramInt)
  {
    a(paramRunnable, paramInt, false);
  }
  
  public void a(Thread paramThread, Runnable paramRunnable, int paramInt1, int paramInt2)
  {
    Logger.v("VungleService", paramThread.getName() + " task initiated: " + paramInt1 + " completed tasks, " + paramInt2 + " pending tasks");
  }
  
  public void b(int paramInt)
  {
    Logger.d("VungleService", this.a + " shutdown initiated: " + paramInt + " completed tasks");
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    Logger.v("VungleService", Thread.currentThread().getName() + " task completed: " + paramInt1 + " completed tasks, " + paramInt2 + " pending tasks");
  }
  
  public void b(int paramInt, ch.a.a parama)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("invalid number of completed tasks: " + paramInt);
    }
    int i = this.d.get();
    if (this.e.compareAndSet(paramInt, -3))
    {
      parama.a(paramInt);
      this.g = null;
      if (this.e.compareAndSet(-3, -2))
      {
        do
        {
          paramInt = this.d.get();
        } while (!this.d.compareAndSet(paramInt, paramInt - i));
        c();
        parama = this.c.iterator();
        while (parama.hasNext()) {
          ((ce.a)parama.next()).c(i);
        }
      }
      Logger.w("VungleService", Thread.currentThread().getName() + " failed to mark executor stopped: expected state -3, but is " + this.e.get());
      return;
    }
    parama.a(paramInt, this.e.get());
  }
  
  public void c(int paramInt)
  {
    Logger.v("VungleService", this.a + " shutdown completed: " + paramInt + " completed tasks");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/ca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */