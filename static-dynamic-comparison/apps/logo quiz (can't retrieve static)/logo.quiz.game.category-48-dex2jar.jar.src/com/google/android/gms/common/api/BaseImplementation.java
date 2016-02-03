package com.google.android.gms.common.api;

import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.i;
import com.google.android.gms.common.internal.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class BaseImplementation
{
  static void a(Result paramResult)
  {
    if ((paramResult instanceof Releasable)) {}
    try
    {
      ((Releasable)paramResult).release();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      Log.w("GoogleApi", "Unable to release " + paramResult, localRuntimeException);
    }
  }
  
  public static abstract class AbstractPendingResult<R extends Result>
    implements BaseImplementation.b<R>, PendingResult<R>
  {
    private final Object Im = new Object();
    private final ArrayList<PendingResult.a> In = new ArrayList();
    private ResultCallback<R> Io;
    private volatile R Ip;
    private volatile boolean Iq;
    private boolean Ir;
    private boolean Is;
    private i It;
    protected BaseImplementation.CallbackHandler<R> mHandler;
    private final CountDownLatch mg = new CountDownLatch(1);
    
    AbstractPendingResult() {}
    
    public AbstractPendingResult(Looper paramLooper)
    {
      this.mHandler = new BaseImplementation.CallbackHandler(paramLooper);
    }
    
    public AbstractPendingResult(BaseImplementation.CallbackHandler<R> paramCallbackHandler)
    {
      this.mHandler = paramCallbackHandler;
    }
    
    private void c(R paramR)
    {
      this.Ip = paramR;
      this.It = null;
      this.mg.countDown();
      paramR = this.Ip.getStatus();
      if (this.Io != null)
      {
        this.mHandler.removeTimeoutMessages();
        if (!this.Ir) {
          this.mHandler.sendResultCallback(this.Io, gg());
        }
      }
      Iterator localIterator = this.In.iterator();
      while (localIterator.hasNext()) {
        ((PendingResult.a)localIterator.next()).n(paramR);
      }
      this.In.clear();
    }
    
    private R gg()
    {
      for (;;)
      {
        synchronized (this.Im)
        {
          if (!this.Iq)
          {
            bool = true;
            n.a(bool, "Result has already been consumed.");
            n.a(isReady(), "Result is not ready.");
            Result localResult = this.Ip;
            gh();
            return localResult;
          }
        }
        boolean bool = false;
      }
    }
    
    private void gi()
    {
      synchronized (this.Im)
      {
        if (!isReady())
        {
          b(c(Status.Jp));
          this.Is = true;
        }
        return;
      }
    }
    
    private void gj()
    {
      synchronized (this.Im)
      {
        if (!isReady())
        {
          b(c(Status.Jr));
          this.Is = true;
        }
        return;
      }
    }
    
    protected void a(BaseImplementation.CallbackHandler<R> paramCallbackHandler)
    {
      this.mHandler = paramCallbackHandler;
    }
    
    public final void a(PendingResult.a parama)
    {
      if (!this.Iq) {}
      for (boolean bool = true;; bool = false)
      {
        n.a(bool, "Result has already been consumed.");
        synchronized (this.Im)
        {
          if (isReady())
          {
            parama.n(this.Ip.getStatus());
            return;
          }
          this.In.add(parama);
        }
      }
    }
    
    protected final void a(i parami)
    {
      synchronized (this.Im)
      {
        this.It = parami;
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
        n.a(bool1, "await must not be called on the UI thread");
        if (!this.Iq)
        {
          bool1 = bool2;
          n.a(bool1, "Result has already been consumed");
        }
        try
        {
          this.mg.await();
          n.a(isReady(), "Result is not ready.");
          return gg();
          bool1 = false;
          continue;
          bool1 = false;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            gi();
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
        n.a(bool1, "await must not be called on the UI thread when time is greater than zero.");
        if (!this.Iq)
        {
          bool1 = bool2;
          n.a(bool1, "Result has already been consumed.");
        }
        try
        {
          if (!this.mg.await(paramLong, paramTimeUnit)) {
            gj();
          }
          n.a(isReady(), "Result is not ready.");
          return gg();
          bool1 = false;
          continue;
          bool1 = false;
        }
        catch (InterruptedException paramTimeUnit)
        {
          for (;;)
          {
            gi();
          }
        }
      }
    }
    
    public final void b(R paramR)
    {
      boolean bool2 = true;
      for (;;)
      {
        synchronized (this.Im)
        {
          if ((this.Is) || (this.Ir))
          {
            BaseImplementation.a(paramR);
            return;
          }
          if (!isReady())
          {
            bool1 = true;
            n.a(bool1, "Results have already been set");
            if (this.Iq) {
              break label83;
            }
            bool1 = bool2;
            n.a(bool1, "Result has already been consumed");
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
      synchronized (this.Im)
      {
        if ((this.Ir) || (this.Iq)) {
          return;
        }
        i locali = this.It;
        if (locali == null) {}
      }
      try
      {
        this.It.cancel();
        BaseImplementation.a(this.Ip);
        this.Io = null;
        this.Ir = true;
        c(c(Status.Js));
        return;
        localObject2 = finally;
        throw ((Throwable)localObject2);
      }
      catch (RemoteException localRemoteException)
      {
        for (;;) {}
      }
    }
    
    protected void gh()
    {
      this.Iq = true;
      this.Ip = null;
      this.Io = null;
    }
    
    public boolean isCanceled()
    {
      synchronized (this.Im)
      {
        boolean bool = this.Ir;
        return bool;
      }
    }
    
    public final boolean isReady()
    {
      return this.mg.getCount() == 0L;
    }
    
    public final void setResultCallback(ResultCallback<R> paramResultCallback)
    {
      if (!this.Iq) {}
      for (boolean bool = true;; bool = false)
      {
        n.a(bool, "Result has already been consumed.");
        for (;;)
        {
          synchronized (this.Im)
          {
            if (isCanceled()) {
              return;
            }
            if (isReady())
            {
              this.mHandler.sendResultCallback(paramResultCallback, gg());
              return;
            }
          }
          this.Io = paramResultCallback;
        }
      }
    }
    
    public final void setResultCallback(ResultCallback<R> paramResultCallback, long paramLong, TimeUnit paramTimeUnit)
    {
      boolean bool2 = true;
      if (!this.Iq)
      {
        bool1 = true;
        n.a(bool1, "Result has already been consumed.");
        if (this.mHandler == null) {
          break label115;
        }
      }
      label115:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        n.a(bool1, "CallbackHandler has not been set before calling setResultCallback.");
        for (;;)
        {
          synchronized (this.Im)
          {
            if (isCanceled()) {
              return;
            }
            if (isReady())
            {
              this.mHandler.sendResultCallback(paramResultCallback, gg());
              return;
            }
          }
          this.Io = paramResultCallback;
          this.mHandler.sendTimeoutResultCallback(this, paramTimeUnit.toMillis(paramLong));
        }
        bool1 = false;
        break;
      }
    }
  }
  
  public static class CallbackHandler<R extends Result>
    extends Handler
  {
    public static final int CALLBACK_ON_COMPLETE = 1;
    public static final int CALLBACK_ON_TIMEOUT = 2;
    
    public CallbackHandler()
    {
      this(Looper.getMainLooper());
    }
    
    public CallbackHandler(Looper paramLooper)
    {
      super();
    }
    
    protected void deliverResultCallback(ResultCallback<R> paramResultCallback, R paramR)
    {
      try
      {
        paramResultCallback.onResult(paramR);
        return;
      }
      catch (RuntimeException paramResultCallback)
      {
        BaseImplementation.a(paramR);
        throw paramResultCallback;
      }
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
        deliverResultCallback((ResultCallback)paramMessage.first, (Result)paramMessage.second);
        return;
      }
      BaseImplementation.AbstractPendingResult.a((BaseImplementation.AbstractPendingResult)paramMessage.obj);
    }
    
    public void removeTimeoutMessages()
    {
      removeMessages(2);
    }
    
    public void sendResultCallback(ResultCallback<R> paramResultCallback, R paramR)
    {
      sendMessage(obtainMessage(1, new Pair(paramResultCallback, paramR)));
    }
    
    public void sendTimeoutResultCallback(BaseImplementation.AbstractPendingResult<R> paramAbstractPendingResult, long paramLong)
    {
      sendMessageDelayed(obtainMessage(2, paramAbstractPendingResult), paramLong);
    }
  }
  
  public static abstract class a<R extends Result, A extends Api.a>
    extends BaseImplementation.AbstractPendingResult<R>
    implements b.c<A>
  {
    private final Api.c<A> Ik;
    private b.a Iu;
    
    protected a(Api.c<A> paramc)
    {
      this.Ik = ((Api.c)n.i(paramc));
    }
    
    private void a(RemoteException paramRemoteException)
    {
      m(new Status(8, paramRemoteException.getLocalizedMessage(), null));
    }
    
    protected abstract void a(A paramA)
      throws RemoteException;
    
    public void a(b.a parama)
    {
      this.Iu = parama;
    }
    
    public final void b(A paramA)
      throws DeadObjectException
    {
      if (this.mHandler == null) {
        a(new BaseImplementation.CallbackHandler(paramA.getLooper()));
      }
      try
      {
        a(paramA);
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
    
    public final Api.c<A> gf()
    {
      return this.Ik;
    }
    
    protected void gh()
    {
      super.gh();
      if (this.Iu != null)
      {
        this.Iu.b(this);
        this.Iu = null;
      }
    }
    
    public int gk()
    {
      return 0;
    }
    
    public final void m(Status paramStatus)
    {
      if (!paramStatus.isSuccess()) {}
      for (boolean bool = true;; bool = false)
      {
        n.b(bool, "Failed result must not be success");
        b(c(paramStatus));
        return;
      }
    }
  }
  
  public static abstract interface b<R>
  {
    public abstract void b(R paramR);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/common/api/BaseImplementation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */