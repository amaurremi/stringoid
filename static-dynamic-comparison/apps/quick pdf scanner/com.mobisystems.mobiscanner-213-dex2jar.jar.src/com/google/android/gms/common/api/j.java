package com.google.android.gms.common.api;

import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.internal.dc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

public class j
{
  public static abstract class a<R extends f, A extends a.a>
    implements d<R>, j.c<R>, k.c<A>
  {
    private final a.b<A> rh;
    private final Object ri = new Object();
    private j.b<R> rj;
    private final CountDownLatch rk = new CountDownLatch(1);
    private final ArrayList<d.a> rl = new ArrayList();
    private g<R> rm;
    private volatile R rn;
    private volatile boolean ro;
    private boolean rp;
    private boolean rq;
    private k.a rr;
    
    protected a()
    {
      this((a.b)null);
    }
    
    protected a(a.b<A> paramb)
    {
      this.rh = paramb;
    }
    
    private void a(RemoteException paramRemoteException)
    {
      b(b(new Status(8, paramRemoteException.getLocalizedMessage(), null)));
    }
    
    private void mA()
    {
      if ((this.rn != null) && ((this instanceof e))) {}
      try
      {
        ((e)this).release();
        return;
      }
      catch (Exception localException)
      {
        Log.w("GoogleApi", "Unable to release " + this, localException);
      }
    }
    
    private R mx()
    {
      for (;;)
      {
        synchronized (this.ri)
        {
          if (!this.ro)
          {
            bool = true;
            dc.a(bool, "Result has already been consumed.");
            dc.a(mw(), "Result is not ready.");
            f localf = this.rn;
            my();
            return localf;
          }
        }
        boolean bool = false;
      }
    }
    
    public final void a(A paramA)
    {
      this.rj = new j.b(paramA.getLooper());
      try
      {
        b(paramA);
        return;
      }
      catch (DeadObjectException paramA)
      {
        a(paramA);
        throw paramA;
      }
      catch (RemoteException paramA)
      {
        a(paramA);
      }
    }
    
    public final void a(g<R> paramg)
    {
      if (!this.ro) {}
      for (boolean bool = true;; bool = false)
      {
        dc.a(bool, "Result has already been consumed.");
        synchronized (this.ri)
        {
          if (mw())
          {
            this.rj.a(paramg, mx());
            return;
          }
          this.rm = paramg;
        }
      }
    }
    
    public void a(k.a parama)
    {
      this.rr = parama;
    }
    
    protected abstract R b(Status paramStatus);
    
    protected abstract void b(A paramA);
    
    public final void b(R paramR)
    {
      boolean bool2 = true;
      for (;;)
      {
        synchronized (this.ri)
        {
          if (this.rq)
          {
            if ((paramR instanceof e)) {
              ((e)paramR).release();
            }
            return;
          }
          if (!mw())
          {
            bool1 = true;
            dc.a(bool1, "Results have already been set");
            if (this.ro) {
              break label99;
            }
            bool1 = bool2;
            dc.a(bool1, "Result has already been consumed");
            this.rn = paramR;
            if (!this.rp) {
              break;
            }
            mA();
            return;
          }
        }
        boolean bool1 = false;
        continue;
        label99:
        bool1 = false;
      }
      this.rk.countDown();
      paramR = this.rn.mq();
      if (this.rm != null)
      {
        this.rj.mB();
        this.rj.a(this.rm, mx());
      }
      Iterator localIterator = this.rl.iterator();
      while (localIterator.hasNext()) {
        ((d.a)localIterator.next()).a(paramR);
      }
      this.rl.clear();
    }
    
    public final a.b<A> mm()
    {
      return this.rh;
    }
    
    public int mv()
    {
      return 0;
    }
    
    public final boolean mw()
    {
      return this.rk.getCount() == 0L;
    }
    
    void my()
    {
      this.ro = true;
      this.rn = null;
      if (this.rr != null) {
        this.rr.b(this);
      }
    }
    
    public void mz()
    {
      mA();
      this.rp = true;
    }
  }
  
  public static class b<R extends f>
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
    
    public void a(g<R> paramg, R paramR)
    {
      sendMessage(obtainMessage(1, new Pair(paramg, paramR)));
    }
    
    protected void b(g<R> paramg, R paramR)
    {
      paramg.a(paramR);
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        Log.wtf("GoogleApi", "Don't know how to handle this message.");
        return;
      case 1: 
        paramMessage = (Pair)paramMessage.obj;
        b((g)paramMessage.first, (f)paramMessage.second);
        return;
      }
      paramMessage = (j.a)paramMessage.obj;
      paramMessage.b(paramMessage.b(Status.re));
    }
    
    public void mB()
    {
      removeMessages(2);
    }
  }
  
  public static abstract interface c<R>
  {
    public abstract void H(R paramR);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/common/api/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */