package com.google.android.gms.common.api;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.internal.eg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class a
{
  public static abstract class a<R extends Result, A extends Api.a>
    implements GoogleApiClient.b<A>, PendingResult<R>, a.c<R>
  {
    private final Api.b<A> mU;
    private final Object mV = new Object();
    private final a.b<R> mW;
    private final CountDownLatch mX = new CountDownLatch(1);
    private final ArrayList<PendingResult.a> mY = new ArrayList();
    private ResultCallback<R> mZ;
    private R na;
    private boolean nb;
    private GoogleApiClient.a nc;
    
    public a(Api.b<A> paramb)
    {
      this.mU = paramb;
      this.mW = new a.b()
      {
        protected void a(ResultCallback<R> paramAnonymousResultCallback, R paramAnonymousR)
        {
          paramAnonymousResultCallback.onResult(paramAnonymousR);
        }
      };
    }
    
    private R bl()
    {
      for (;;)
      {
        synchronized (this.mV)
        {
          if (!this.nb)
          {
            bool = true;
            eg.a(bool, "Result has already been consumed.");
            eg.a(isReady(), "Result is not ready.");
            Result localResult = this.na;
            bm();
            return localResult;
          }
        }
        boolean bool = false;
      }
    }
    
    protected abstract void a(A paramA);
    
    public void a(GoogleApiClient.a parama)
    {
      this.nc = parama;
    }
    
    public final void a(R paramR)
    {
      boolean bool2 = true;
      if (!isReady())
      {
        bool1 = true;
        eg.a(bool1, "Results have already been set");
        if (this.nb) {
          break label134;
        }
      }
      label134:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        eg.a(bool1, "Result has already been consumed");
        synchronized (this.mV)
        {
          this.na = paramR;
          this.mX.countDown();
          paramR = this.na.getStatus();
          if (this.mZ != null) {
            this.mW.b(this.mZ, bl());
          }
          Iterator localIterator = this.mY.iterator();
          if (!localIterator.hasNext()) {
            break label139;
          }
          ((PendingResult.a)localIterator.next()).l(paramR);
        }
        bool1 = false;
        break;
      }
      label139:
      this.mY.clear();
    }
    
    public final R await()
    {
      boolean bool;
      if (!this.nb) {
        bool = true;
      }
      for (;;)
      {
        eg.a(bool, "Results has already been consumed");
        try
        {
          this.mX.await();
          eg.a(isReady(), "Result is not ready.");
          return bl();
          bool = false;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            a(e(Status.nB));
          }
        }
      }
    }
    
    public final R await(long paramLong, TimeUnit paramTimeUnit)
    {
      boolean bool;
      if (!this.nb) {
        bool = true;
      }
      for (;;)
      {
        eg.a(bool, "Result has already been consumed.");
        try
        {
          if (!this.mX.await(paramLong, paramTimeUnit)) {
            a(e(Status.nC));
          }
          eg.a(isReady(), "Result is not ready.");
          return bl();
          bool = false;
        }
        catch (InterruptedException paramTimeUnit)
        {
          for (;;)
          {
            a(e(Status.nB));
          }
        }
      }
    }
    
    public final void b(A paramA)
    {
      a(paramA);
    }
    
    public final Api.b<A> bj()
    {
      return this.mU;
    }
    
    void bm()
    {
      this.nb = true;
      this.na = null;
      if (this.nc != null) {
        this.nc.b(this);
      }
    }
    
    public final boolean isReady()
    {
      return this.mX.getCount() == 0L;
    }
    
    public final void setResultCallback(ResultCallback<R> paramResultCallback)
    {
      if (!this.nb) {}
      for (boolean bool = true;; bool = false)
      {
        eg.a(bool, "Result has already been consumed.");
        synchronized (this.mV)
        {
          if (isReady())
          {
            this.mW.b(paramResultCallback, bl());
            return;
          }
          this.mZ = paramResultCallback;
        }
      }
    }
  }
  
  static abstract class b<R extends Result>
    extends Handler
  {
    public b()
    {
      this(Looper.getMainLooper());
    }
    
    public b(Looper paramLooper)
    {
      super();
    }
    
    protected abstract void a(ResultCallback<R> paramResultCallback, R paramR);
    
    public void b(ResultCallback<R> paramResultCallback, R paramR)
    {
      sendMessage(obtainMessage(1, new Pair(paramResultCallback, paramR)));
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        Log.wtf("GoogleApi", "Don't know how to handle this message.");
        return;
      }
      paramMessage = (Pair)paramMessage.obj;
      a((ResultCallback)paramMessage.first, (Result)paramMessage.second);
    }
  }
  
  public static abstract interface c<R>
  {
    public abstract void a(R paramR);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/common/api/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */