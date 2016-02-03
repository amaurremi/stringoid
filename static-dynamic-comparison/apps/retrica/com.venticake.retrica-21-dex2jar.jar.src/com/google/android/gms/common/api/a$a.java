package com.google.android.gms.common.api;

import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.internal.hg;
import com.google.android.gms.internal.hm;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class a$a<R extends Result>
  implements PendingResult<R>, a.d<R>
{
  private final Object Dp = new Object();
  private a.c<R> Dq;
  private final ArrayList<PendingResult.a> Dr = new ArrayList();
  private ResultCallback<R> Ds;
  private volatile R Dt;
  private volatile boolean Du;
  private boolean Dv;
  private boolean Dw;
  private hg Dx;
  private final CountDownLatch kK = new CountDownLatch(1);
  
  a$a() {}
  
  public a$a(Looper paramLooper)
  {
    this.Dq = new a.c(paramLooper);
  }
  
  public a$a(a.c<R> paramc)
  {
    this.Dq = paramc;
  }
  
  private void c(R paramR)
  {
    this.Dt = paramR;
    this.Dx = null;
    this.kK.countDown();
    paramR = this.Dt.getStatus();
    if (this.Ds != null)
    {
      this.Dq.eH();
      if (!this.Dv) {
        this.Dq.a(this.Ds, eC());
      }
    }
    Iterator localIterator = this.Dr.iterator();
    while (localIterator.hasNext()) {
      ((PendingResult.a)localIterator.next()).n(paramR);
    }
    this.Dr.clear();
  }
  
  private R eC()
  {
    for (;;)
    {
      synchronized (this.Dp)
      {
        if (!this.Du)
        {
          bool = true;
          hm.a(bool, "Result has already been consumed.");
          hm.a(isReady(), "Result is not ready.");
          Result localResult = this.Dt;
          eD();
          return localResult;
        }
      }
      boolean bool = false;
    }
  }
  
  private void eE()
  {
    synchronized (this.Dp)
    {
      if (!isReady())
      {
        b(c(Status.Eo));
        this.Dw = true;
      }
      return;
    }
  }
  
  private void eF()
  {
    synchronized (this.Dp)
    {
      if (!isReady())
      {
        b(c(Status.Eq));
        this.Dw = true;
      }
      return;
    }
  }
  
  public final void a(PendingResult.a parama)
  {
    if (!this.Du) {}
    for (boolean bool = true;; bool = false)
    {
      hm.a(bool, "Result has already been consumed.");
      synchronized (this.Dp)
      {
        if (isReady())
        {
          parama.n(this.Dt.getStatus());
          return;
        }
        this.Dr.add(parama);
      }
    }
  }
  
  protected void a(a.c<R> paramc)
  {
    this.Dq = paramc;
  }
  
  protected final void a(hg paramhg)
  {
    synchronized (this.Dp)
    {
      this.Dx = paramhg;
      return;
    }
  }
  
  public final R await()
  {
    boolean bool2 = true;
    boolean bool1;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      bool1 = true;
    }
    for (;;)
    {
      hm.a(bool1, "await must not be called on the UI thread");
      if (!this.Du)
      {
        bool1 = bool2;
        hm.a(bool1, "Result has already been consumed");
      }
      try
      {
        this.kK.await();
        hm.a(isReady(), "Result is not ready.");
        return eC();
        bool1 = false;
        continue;
        bool1 = false;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          eE();
        }
      }
    }
  }
  
  public final R await(long paramLong, TimeUnit paramTimeUnit)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramLong <= 0L) || (Looper.myLooper() != Looper.getMainLooper())) {
      bool1 = true;
    }
    for (;;)
    {
      hm.a(bool1, "await must not be called on the UI thread when time is greater than zero.");
      if (!this.Du)
      {
        bool1 = bool2;
        hm.a(bool1, "Result has already been consumed.");
      }
      try
      {
        if (!this.kK.await(paramLong, paramTimeUnit)) {
          eF();
        }
        hm.a(isReady(), "Result is not ready.");
        return eC();
        bool1 = false;
        continue;
        bool1 = false;
      }
      catch (InterruptedException paramTimeUnit)
      {
        for (;;)
        {
          eE();
        }
      }
    }
  }
  
  public final void b(R paramR)
  {
    boolean bool2 = true;
    for (;;)
    {
      synchronized (this.Dp)
      {
        if ((this.Dw) || (this.Dv))
        {
          a.a(paramR);
          return;
        }
        if (!isReady())
        {
          bool1 = true;
          hm.a(bool1, "Results have already been set");
          if (this.Du) {
            break label83;
          }
          bool1 = bool2;
          hm.a(bool1, "Result has already been consumed");
          c(paramR);
          return;
        }
      }
      boolean bool1 = false;
      continue;
      label83:
      bool1 = false;
    }
  }
  
  protected abstract R c(Status paramStatus);
  
  public void cancel()
  {
    synchronized (this.Dp)
    {
      if ((this.Dv) || (this.Du)) {
        return;
      }
      hg localhg = this.Dx;
      if (localhg == null) {}
    }
    try
    {
      this.Dx.cancel();
      a.a(this.Dt);
      this.Ds = null;
      this.Dv = true;
      c(c(Status.Er));
      return;
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
    catch (RemoteException localRemoteException)
    {
      for (;;) {}
    }
  }
  
  protected void eD()
  {
    this.Du = true;
    this.Dt = null;
    this.Ds = null;
  }
  
  public boolean isCanceled()
  {
    synchronized (this.Dp)
    {
      boolean bool = this.Dv;
      return bool;
    }
  }
  
  public final boolean isReady()
  {
    return this.kK.getCount() == 0L;
  }
  
  public final void setResultCallback(ResultCallback<R> paramResultCallback)
  {
    if (!this.Du) {}
    for (boolean bool = true;; bool = false)
    {
      hm.a(bool, "Result has already been consumed.");
      for (;;)
      {
        synchronized (this.Dp)
        {
          if (isCanceled()) {
            return;
          }
          if (isReady())
          {
            this.Dq.a(paramResultCallback, eC());
            return;
          }
        }
        this.Ds = paramResultCallback;
      }
    }
  }
  
  public final void setResultCallback(ResultCallback<R> paramResultCallback, long paramLong, TimeUnit paramTimeUnit)
  {
    if (!this.Du) {}
    for (boolean bool = true;; bool = false)
    {
      hm.a(bool, "Result has already been consumed.");
      for (;;)
      {
        synchronized (this.Dp)
        {
          if (isCanceled()) {
            return;
          }
          if (isReady())
          {
            this.Dq.a(paramResultCallback, eC());
            return;
          }
        }
        this.Ds = paramResultCallback;
        this.Dq.a(this, paramTimeUnit.toMillis(paramLong));
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/common/api/a$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */