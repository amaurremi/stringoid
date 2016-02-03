package com.ideashower.readitlater.g;

import com.ideashower.readitlater.util.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class i
  implements c
{
  protected final AtomicBoolean a = new AtomicBoolean(false);
  protected final AtomicBoolean b = new AtomicBoolean(false);
  protected final b c;
  protected final ArrayList d = new ArrayList();
  private final Object e = new Object();
  private long f = 0L;
  private long g = 0L;
  private long h = 0L;
  private j i;
  
  protected i(int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit, BlockingQueue paramBlockingQueue, String paramString)
  {
    this.c = new b(paramInt1, paramInt2, paramLong, paramTimeUnit, paramBlockingQueue, paramString);
    this.c.a(this);
  }
  
  public i(int paramInt1, int paramInt2, String paramString)
  {
    this(paramInt1, paramInt2, new LinkedBlockingQueue(), paramString);
  }
  
  protected i(int paramInt1, int paramInt2, BlockingQueue paramBlockingQueue, String paramString)
  {
    this(paramInt1, paramInt2, 1L, TimeUnit.SECONDS, paramBlockingQueue, paramString);
  }
  
  public i(int paramInt, String paramString)
  {
    this(paramInt, paramInt, paramString);
  }
  
  private boolean b(long paramLong)
  {
    for (;;)
    {
      synchronized (this.e)
      {
        if (paramLong < this.f)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public FutureTask a(k paramk)
  {
    if ((this.b.get()) || (this.a.get())) {
      return null;
    }
    long l = h();
    FutureTask localFutureTask = a(paramk, l);
    paramk.a(this, localFutureTask, l);
    this.c.execute(localFutureTask);
    return localFutureTask;
  }
  
  protected FutureTask a(k paramk, long paramLong)
  {
    return new h(paramk);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.c.setCorePoolSize(paramInt1);
    this.c.setMaximumPoolSize(paramInt2);
  }
  
  public void a(int paramInt, TimeUnit paramTimeUnit)
  {
    this.b.set(true);
    this.c.shutdown();
    try
    {
      this.c.awaitTermination(paramInt, paramTimeUnit);
      this.c.shutdownNow();
      return;
    }
    catch (InterruptedException paramTimeUnit)
    {
      for (;;)
      {
        e.a(paramTimeUnit);
      }
    }
  }
  
  public void a(j paramj)
  {
    this.i = paramj;
  }
  
  public void a(Runnable paramRunnable)
  {
    for (;;)
    {
      synchronized (this.e)
      {
        this.d.remove(paramRunnable);
        i();
        if (this.i != null)
        {
          if (((paramRunnable instanceof h)) && (((h)paramRunnable).e()))
          {
            bool = true;
            this.i.a(bool);
          }
        }
        else {
          return;
        }
      }
      boolean bool = false;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.a.set(paramBoolean);
    synchronized (this.e)
    {
      this.f = j();
      ArrayList localArrayList = new ArrayList(this.d);
      ??? = localArrayList.iterator();
      if (((Iterator)???).hasNext()) {
        ((h)((Iterator)???).next()).d();
      }
    }
  }
  
  protected boolean a(long paramLong)
  {
    return (this.b.get()) || (b(paramLong));
  }
  
  public void b(Runnable paramRunnable)
  {
    synchronized (this.e)
    {
      this.d.add(paramRunnable);
      return;
    }
  }
  
  public boolean d()
  {
    return this.b.get();
  }
  
  public void e()
  {
    this.c.a();
  }
  
  public void f()
  {
    this.c.b();
  }
  
  public boolean g()
  {
    if (d()) {}
    for (;;)
    {
      return false;
      synchronized (this.e)
      {
        long l3 = this.g;
        long l4 = this.f;
        long l2 = this.h - this.f;
        long l1 = l2;
        if (l2 < 0L) {
          l1 = 0L;
        }
        if (l3 - l4 - l1 <= 0L) {
          continue;
        }
        return true;
      }
    }
  }
  
  protected long h()
  {
    synchronized (this.e)
    {
      this.g += 1L;
      long l = this.g;
      return l;
    }
  }
  
  protected long i()
  {
    synchronized (this.e)
    {
      this.h += 1L;
      long l = this.h;
      return l;
    }
  }
  
  protected long j()
  {
    synchronized (this.e)
    {
      long l = this.g;
      return l;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/g/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */