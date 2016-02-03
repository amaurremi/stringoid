package com.vungle.publisher;

import android.content.Intent;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.vungle.publisher.log.Logger;
import com.vungle.publisher.service.BaseHandler;
import com.vungle.publisher.service.BaseHandler.a;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

abstract class cc<T extends BaseHandler>
  extends bz<T>
  implements BaseHandler.a
{
  volatile T d;
  protected volatile int e;
  private final AtomicInteger f = new AtomicInteger(-2);
  private final Object g = this.f;
  
  protected cc(String paramString)
  {
    super(paramString, 30);
  }
  
  private void a(Message paramMessage, int paramInt)
  {
    for (;;)
    {
      Logger.v("VungleService", this.a + " message (ID: " + paramMessage.arg1 + ", type: " + paramMessage.obj + ")");
      ??? = a();
      ((BaseHandler)???).removeMessages(-1);
      if (b())
      {
        Logger.d("VungleService", this.a + " queuing message (ID: " + paramMessage.arg1 + ", type: " + paramMessage.obj + ", delay seconds: " + paramInt + ")");
        if (paramInt < 0)
        {
          ((BaseHandler)???).sendMessageAtFrontOfQueue(paramMessage);
          return;
        }
        if (paramInt == 0)
        {
          ((BaseHandler)???).sendMessage(paramMessage);
          return;
        }
        ((BaseHandler)???).sendMessageDelayed(paramMessage, paramInt * 1000);
        return;
      }
      try
      {
        synchronized (this.g)
        {
          if (!b())
          {
            Logger.d("VungleService", Thread.currentThread().getName() + " waiting");
            this.g.wait();
          }
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        Logger.v("VungleService", Thread.currentThread().getName() + " interrupted - resuming init/wait");
      }
    }
  }
  
  private boolean b()
  {
    return this.f.get() == 0;
  }
  
  private void c()
  {
    synchronized (this.g)
    {
      this.g.notifyAll();
      return;
    }
  }
  
  protected final T a()
  {
    Object localObject1 = this.d;
    for (;;)
    {
      if (!b())
      {
        if (this.f.compareAndSet(-2, -1))
        {
          localObject1 = new HandlerThread(this.a + "-Thread");
          ((HandlerThread)localObject1).start();
          localObject1 = a(((HandlerThread)localObject1).getLooper());
          ((BaseHandler)localObject1).a(new BaseHandler.a[] { this });
          this.d = ((BaseHandler)localObject1);
          if (this.f.compareAndSet(-1, 0))
          {
            c();
            Logger.d("VungleService", this.a + " started: " + this.b + " second shutdown delay");
            continue;
          }
          Logger.w("VungleService", Thread.currentThread().getName() + " failed to mark handler started: expected state -1, but is " + this.f.get());
          continue;
        }
        try
        {
          synchronized (this.g)
          {
            if (!b()) {
              this.g.wait();
            }
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          Logger.v("VungleService", Thread.currentThread().getName() + " interrupted - resuming init/wait");
        }
      }
    }
    return (T)localObject1;
  }
  
  protected abstract T a(Looper paramLooper);
  
  public void a(int paramInt)
  {
    Logger.v("VungleService", this.a + " shutdown completed: " + paramInt + " completed tasks");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Logger.d("VungleService", Thread.currentThread().getName() + " shutdown cancelled: " + paramInt1 + " completed tasks, " + paramInt2 + " received tasks");
  }
  
  public void a(int paramInt, ch.a.a parama)
  {
    throw new UnsupportedOperationException();
  }
  
  public void a(Intent paramIntent, int paramInt)
  {
    this.e = paramInt;
    try
    {
      b(paramIntent, paramInt);
      return;
    }
    catch (Exception paramIntent)
    {
      Logger.e("VungleService", paramIntent);
    }
  }
  
  protected final void a(Message paramMessage)
  {
    a(paramMessage, 0);
  }
  
  public void b(int paramInt)
  {
    Logger.d("VungleService", this.a + " shutdown initiated: " + paramInt + " completed tasks");
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    Logger.d("VungleService", this.a + " shutdown forced: " + paramInt1 + " completed tasks, " + paramInt2 + " received tasks");
  }
  
  public void b(int paramInt, ch.a.a parama)
  {
    if (paramInt == this.e)
    {
      if (this.f.compareAndSet(0, -3))
      {
        parama.a(paramInt);
        this.d = null;
        if (this.f.compareAndSet(-3, -2))
        {
          c();
          parama = this.c.iterator();
          while (parama.hasNext()) {
            ((ce.a)parama.next()).c(paramInt);
          }
        }
        Logger.w("VungleService", Thread.currentThread().getName() + " failed to set state stopped: expected state -3, but is " + this.f.get());
        return;
      }
      Logger.w("VungleService", Thread.currentThread().getName() + " failed to set state stopping: expected state 0, but is " + this.f.get());
      return;
    }
    parama.a(paramInt, this.e);
  }
  
  protected abstract void b(Intent paramIntent, int paramInt);
  
  protected final void b(Message paramMessage)
  {
    a(paramMessage, 10);
  }
  
  public void c(int paramInt)
  {
    Logger.d("VungleService", this.a + " shutdown pending: " + paramInt + " completed tasks");
  }
  
  public void d(int paramInt)
  {
    Logger.v("VungleService", Thread.currentThread().getName() + " task ID " + paramInt + " initiated");
  }
  
  public void e(int paramInt)
  {
    Logger.v("VungleService", Thread.currentThread().getName() + " task ID " + paramInt + " completed");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/cc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */