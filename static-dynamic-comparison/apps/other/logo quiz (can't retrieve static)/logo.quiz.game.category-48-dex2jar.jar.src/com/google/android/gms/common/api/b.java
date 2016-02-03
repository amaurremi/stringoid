package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.common.internal.e.b;
import com.google.android.gms.common.internal.n;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class b
  implements GoogleApiClient
{
  private final Looper IB;
  private final Lock IO = new ReentrantLock();
  private final Condition IP = this.IO.newCondition();
  private final e IQ = new e(paramContext, paramLooper, this.Ji);
  private final int IR;
  final Queue<c<?>> IS = new LinkedList();
  private ConnectionResult IT;
  private int IU;
  private volatile int IV = 4;
  private volatile int IW;
  private boolean IX = false;
  private int IY;
  private long IZ = 5000L;
  private final a Iu = new a()
  {
    public void b(b.c<?> paramAnonymousc)
    {
      b.this.Jg.remove(paramAnonymousc);
    }
  };
  final Handler Ja;
  private final Bundle Jb = new Bundle();
  private final Map<Api.c<?>, Api.a> Jc = new HashMap();
  private final List<String> Jd;
  private boolean Je;
  private final Set<c<?>> Jf = Collections.newSetFromMap(new WeakHashMap());
  final Set<c<?>> Jg = Collections.newSetFromMap(new ConcurrentHashMap());
  private final GoogleApiClient.ConnectionCallbacks Jh = new GoogleApiClient.ConnectionCallbacks()
  {
    public void onConnected(Bundle paramAnonymousBundle)
    {
      b.a(b.this).lock();
      try
      {
        if (b.b(b.this) == 1)
        {
          if (paramAnonymousBundle != null) {
            b.c(b.this).putAll(paramAnonymousBundle);
          }
          b.d(b.this);
        }
        return;
      }
      finally
      {
        b.a(b.this).unlock();
      }
    }
    
    public void onConnectionSuspended(int paramAnonymousInt)
    {
      b.a(b.this).lock();
      for (;;)
      {
        try
        {
          b.a(b.this, paramAnonymousInt);
          switch (paramAnonymousInt)
          {
          default: 
            return;
          }
        }
        finally
        {
          b.a(b.this).unlock();
        }
        b.this.connect();
        continue;
        boolean bool = b.e(b.this);
        if (bool)
        {
          b.a(b.this).unlock();
          return;
        }
        b.b(b.this, 2);
        b.this.Ja.sendMessageDelayed(b.this.Ja.obtainMessage(1), b.f(b.this));
      }
    }
  };
  private final e.b Ji = new e.b()
  {
    public Bundle fD()
    {
      return null;
    }
    
    public boolean gr()
    {
      return b.g(b.this);
    }
    
    public boolean isConnected()
    {
      return b.this.isConnected();
    }
  };
  
  public b(Context paramContext, Looper paramLooper, ClientSettings paramClientSettings, Map<Api<?>, Api.ApiOptions> paramMap, Set<GoogleApiClient.ConnectionCallbacks> paramSet, Set<GoogleApiClient.OnConnectionFailedListener> paramSet1, int paramInt)
  {
    this.IB = paramLooper;
    this.Ja = new b(paramLooper);
    this.IR = paramInt;
    paramSet = paramSet.iterator();
    final Object localObject1;
    while (paramSet.hasNext())
    {
      localObject1 = (GoogleApiClient.ConnectionCallbacks)paramSet.next();
      this.IQ.registerConnectionCallbacks((GoogleApiClient.ConnectionCallbacks)localObject1);
    }
    paramSet = paramSet1.iterator();
    while (paramSet.hasNext())
    {
      paramSet1 = (GoogleApiClient.OnConnectionFailedListener)paramSet.next();
      this.IQ.registerConnectionFailedListener(paramSet1);
    }
    paramSet = paramMap.keySet().iterator();
    while (paramSet.hasNext())
    {
      paramSet1 = (Api)paramSet.next();
      localObject1 = paramSet1.gd();
      Object localObject2 = paramMap.get(paramSet1);
      this.Jc.put(paramSet1.gf(), a((Api.b)localObject1, localObject2, paramContext, paramLooper, paramClientSettings, this.Jh, new GoogleApiClient.OnConnectionFailedListener()
      {
        public void onConnectionFailed(ConnectionResult paramAnonymousConnectionResult)
        {
          b.a(b.this).lock();
          try
          {
            if ((b.i(b.this) == null) || (localObject1.getPriority() < b.j(b.this)))
            {
              b.a(b.this, paramAnonymousConnectionResult);
              b.c(b.this, localObject1.getPriority());
            }
            b.d(b.this);
            return;
          }
          finally
          {
            b.a(b.this).unlock();
          }
        }
      }));
    }
    this.Jd = Collections.unmodifiableList(paramClientSettings.getScopes());
  }
  
  private static <C extends Api.a, O> C a(Api.b<C, O> paramb, Object paramObject, Context paramContext, Looper paramLooper, ClientSettings paramClientSettings, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    return paramb.a(paramContext, paramLooper, paramClientSettings, paramObject, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  private <A extends Api.a> void a(c<A> paramc)
    throws DeadObjectException
  {
    this.IO.lock();
    try
    {
      if (paramc.gf() != null) {}
      for (boolean bool = true;; bool = false)
      {
        n.b(bool, "This task can not be executed or enqueued (it's probably a Batch or malformed)");
        this.Jg.add(paramc);
        paramc.a(this.Iu);
        if (!gp()) {
          break;
        }
        paramc.m(new Status(8));
        return;
      }
      paramc.b(a(paramc.gf()));
      return;
    }
    finally
    {
      this.IO.unlock();
    }
  }
  
  private void aj(int paramInt)
  {
    this.IO.lock();
    Object localObject2;
    try
    {
      if (this.IV == 3) {
        break label374;
      }
      if (paramInt != -1) {
        break label241;
      }
      if (isConnecting())
      {
        Iterator localIterator1 = this.IS.iterator();
        while (localIterator1.hasNext())
        {
          localObject2 = (c)localIterator1.next();
          if (((c)localObject2).gk() != 1)
          {
            ((c)localObject2).cancel();
            localIterator1.remove();
          }
        }
      }
      this.IS.clear();
    }
    finally
    {
      this.IO.unlock();
    }
    Iterator localIterator2 = this.Jg.iterator();
    while (localIterator2.hasNext()) {
      ((c)localIterator2.next()).cancel();
    }
    this.Jg.clear();
    localIterator2 = this.Jf.iterator();
    while (localIterator2.hasNext()) {
      ((c)localIterator2.next()).clear();
    }
    this.Jf.clear();
    if ((this.IT == null) && (!this.IS.isEmpty()))
    {
      this.IX = true;
      this.IO.unlock();
      return;
    }
    label241:
    boolean bool1 = isConnecting();
    boolean bool2 = isConnected();
    this.IV = 3;
    if (bool1)
    {
      if (paramInt == -1) {
        this.IT = null;
      }
      this.IP.signalAll();
    }
    this.Je = false;
    localIterator2 = this.Jc.values().iterator();
    while (localIterator2.hasNext())
    {
      localObject2 = (Api.a)localIterator2.next();
      if (((Api.a)localObject2).isConnected()) {
        ((Api.a)localObject2).disconnect();
      }
    }
    this.Je = true;
    this.IV = 4;
    if (bool2)
    {
      if (paramInt != -1) {
        this.IQ.aB(paramInt);
      }
      this.Je = false;
    }
    label374:
    this.IO.unlock();
  }
  
  private void gn()
  {
    this.IY -= 1;
    if (this.IY == 0)
    {
      if (this.IT == null) {
        break label81;
      }
      this.IX = false;
      aj(3);
      if (!gp()) {
        break label67;
      }
      this.Ja.sendMessageDelayed(this.Ja.obtainMessage(1), this.IZ);
    }
    for (;;)
    {
      this.Je = false;
      return;
      label67:
      this.IQ.b(this.IT);
    }
    label81:
    this.IV = 2;
    gq();
    this.IP.signalAll();
    go();
    if (this.IX)
    {
      this.IX = false;
      aj(-1);
      return;
    }
    if (this.Jb.isEmpty()) {}
    for (Bundle localBundle = null;; localBundle = this.Jb)
    {
      this.IQ.d(localBundle);
      return;
    }
  }
  
  private void go()
  {
    this.IO.lock();
    for (;;)
    {
      try
      {
        if (isConnected()) {
          break label108;
        }
        if (!gp()) {
          break label93;
        }
      }
      finally
      {
        this.IO.unlock();
      }
      n.a(bool, "GoogleApiClient is not connected yet.");
      boolean bool = this.IS.isEmpty();
      if (!bool)
      {
        try
        {
          a((c)this.IS.remove());
        }
        catch (DeadObjectException localDeadObjectException)
        {
          Log.w("GoogleApiClientImpl", "Service died while flushing queue", localDeadObjectException);
        }
        continue;
        label93:
        bool = false;
      }
      else
      {
        this.IO.unlock();
        return;
        label108:
        bool = true;
      }
    }
  }
  
  private boolean gp()
  {
    return this.IW != 0;
  }
  
  private void gq()
  {
    this.IO.lock();
    try
    {
      this.IW = 0;
      this.Ja.removeMessages(1);
      return;
    }
    finally
    {
      this.IO.unlock();
    }
  }
  
  public <C extends Api.a> C a(Api.c<C> paramc)
  {
    paramc = (Api.a)this.Jc.get(paramc);
    n.b(paramc, "Appropriate Api was not requested.");
    return paramc;
  }
  
  /* Error */
  public <A extends Api.a, R extends Result, T extends BaseImplementation.a<R, A>> T a(T paramT)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 78	com/google/android/gms/common/api/b:IO	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 241 1 0
    //   9: aload_1
    //   10: new 409	com/google/android/gms/common/api/BaseImplementation$CallbackHandler
    //   13: dup
    //   14: aload_0
    //   15: invokevirtual 413	com/google/android/gms/common/api/b:getLooper	()Landroid/os/Looper;
    //   18: invokespecial 416	com/google/android/gms/common/api/BaseImplementation$CallbackHandler:<init>	(Landroid/os/Looper;)V
    //   21: invokevirtual 421	com/google/android/gms/common/api/BaseImplementation$a:a	(Lcom/google/android/gms/common/api/BaseImplementation$CallbackHandler;)V
    //   24: aload_0
    //   25: invokevirtual 312	com/google/android/gms/common/api/b:isConnected	()Z
    //   28: ifeq +20 -> 48
    //   31: aload_0
    //   32: aload_1
    //   33: invokevirtual 423	com/google/android/gms/common/api/b:b	(Lcom/google/android/gms/common/api/BaseImplementation$a;)Lcom/google/android/gms/common/api/BaseImplementation$a;
    //   36: pop
    //   37: aload_0
    //   38: getfield 78	com/google/android/gms/common/api/b:IO	Ljava/util/concurrent/locks/Lock;
    //   41: invokeinterface 271 1 0
    //   46: aload_1
    //   47: areturn
    //   48: aload_0
    //   49: getfield 91	com/google/android/gms/common/api/b:IS	Ljava/util/Queue;
    //   52: aload_1
    //   53: invokeinterface 424 2 0
    //   58: pop
    //   59: goto -22 -> 37
    //   62: astore_1
    //   63: aload_0
    //   64: getfield 78	com/google/android/gms/common/api/b:IO	Ljava/util/concurrent/locks/Lock;
    //   67: invokeinterface 271 1 0
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	b
    //   0	74	1	paramT	T
    // Exception table:
    //   from	to	target	type
    //   9	37	62	finally
    //   48	59	62	finally
  }
  
  public boolean a(Scope paramScope)
  {
    return this.Jd.contains(paramScope.gt());
  }
  
  public <A extends Api.a, T extends BaseImplementation.a<? extends Result, A>> T b(T paramT)
  {
    if ((isConnected()) || (gp())) {}
    for (boolean bool = true;; bool = false)
    {
      n.a(bool, "GoogleApiClient is not connected yet.");
      go();
      try
      {
        a(paramT);
        return paramT;
      }
      catch (DeadObjectException localDeadObjectException)
      {
        aj(1);
      }
    }
    return paramT;
  }
  
  public ConnectionResult blockingConnect()
  {
    boolean bool;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      bool = true;
    }
    for (;;)
    {
      n.a(bool, "blockingConnect must not be called on the UI thread");
      this.IO.lock();
      try
      {
        connect();
        for (;;)
        {
          bool = isConnecting();
          if (!bool) {
            break label86;
          }
          try
          {
            this.IP.await();
          }
          catch (InterruptedException localInterruptedException)
          {
            Thread.currentThread().interrupt();
            localConnectionResult = new ConnectionResult(15, null);
            return localConnectionResult;
          }
        }
        bool = false;
        continue;
        label86:
        if (isConnected())
        {
          localConnectionResult = ConnectionResult.HE;
          return localConnectionResult;
        }
        if (this.IT != null)
        {
          localConnectionResult = this.IT;
          return localConnectionResult;
        }
        ConnectionResult localConnectionResult = new ConnectionResult(13, null);
        return localConnectionResult;
      }
      finally
      {
        this.IO.unlock();
      }
    }
  }
  
  public ConnectionResult blockingConnect(long paramLong, TimeUnit paramTimeUnit)
  {
    boolean bool;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      bool = true;
    }
    for (;;)
    {
      n.a(bool, "blockingConnect must not be called on the UI thread");
      this.IO.lock();
      try
      {
        connect();
        paramLong = paramTimeUnit.toNanos(paramLong);
        for (;;)
        {
          bool = isConnecting();
          if (!bool) {
            break;
          }
          try
          {
            long l = this.IP.awaitNanos(paramLong);
            paramLong = l;
            if (l <= 0L)
            {
              paramTimeUnit = new ConnectionResult(14, null);
              return paramTimeUnit;
            }
          }
          catch (InterruptedException paramTimeUnit)
          {
            Thread.currentThread().interrupt();
            paramTimeUnit = new ConnectionResult(15, null);
            return paramTimeUnit;
          }
        }
        bool = false;
        continue;
        if (isConnected())
        {
          paramTimeUnit = ConnectionResult.HE;
          return paramTimeUnit;
        }
        if (this.IT != null)
        {
          paramTimeUnit = this.IT;
          return paramTimeUnit;
        }
        paramTimeUnit = new ConnectionResult(13, null);
        return paramTimeUnit;
      }
      finally
      {
        this.IO.unlock();
      }
    }
  }
  
  public <L> c<L> c(L paramL)
  {
    n.b(paramL, "Listener must not be null");
    this.IO.lock();
    try
    {
      paramL = new c(this.IB, paramL);
      this.Jf.add(paramL);
      return paramL;
    }
    finally
    {
      this.IO.unlock();
    }
  }
  
  public void connect()
  {
    this.IO.lock();
    try
    {
      this.IX = false;
      if (!isConnected())
      {
        boolean bool = isConnecting();
        if (!bool) {}
      }
      else
      {
        return;
      }
      this.Je = true;
      this.IT = null;
      this.IV = 1;
      this.Jb.clear();
      this.IY = this.Jc.size();
      Iterator localIterator = this.Jc.values().iterator();
      while (localIterator.hasNext()) {
        ((Api.a)localIterator.next()).connect();
      }
    }
    finally
    {
      this.IO.unlock();
    }
  }
  
  public void disconnect()
  {
    gq();
    aj(-1);
  }
  
  public Looper getLooper()
  {
    return this.IB;
  }
  
  public boolean isConnected()
  {
    return this.IV == 2;
  }
  
  public boolean isConnecting()
  {
    return this.IV == 1;
  }
  
  public boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    return this.IQ.isConnectionCallbacksRegistered(paramConnectionCallbacks);
  }
  
  public boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    return this.IQ.isConnectionFailedListenerRegistered(paramOnConnectionFailedListener);
  }
  
  public void reconnect()
  {
    disconnect();
    connect();
  }
  
  public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.IQ.registerConnectionCallbacks(paramConnectionCallbacks);
  }
  
  public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.IQ.registerConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  public void stopAutoManage(FragmentActivity paramFragmentActivity)
  {
    if (this.IR >= 0) {}
    for (boolean bool = true;; bool = false)
    {
      n.a(bool, "Called stopAutoManage but automatic lifecycle management is not enabled.");
      d.a(paramFragmentActivity).al(this.IR);
      return;
    }
  }
  
  public void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.IQ.unregisterConnectionCallbacks(paramConnectionCallbacks);
  }
  
  public void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.IQ.unregisterConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  static abstract interface a
  {
    public abstract void b(b.c<?> paramc);
  }
  
  class b
    extends Handler
  {
    b(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      if (paramMessage.what == 1)
      {
        b.a(b.this).lock();
        try
        {
          if ((!b.this.isConnected()) && (!b.this.isConnecting()))
          {
            boolean bool = b.e(b.this);
            if (bool) {}
          }
          else
          {
            return;
          }
          b.h(b.this);
          b.this.connect();
          return;
        }
        finally
        {
          b.a(b.this).unlock();
        }
      }
      Log.wtf("GoogleApiClientImpl", "Don't know how to handle this message.");
    }
  }
  
  static abstract interface c<A extends Api.a>
  {
    public abstract void a(b.a parama);
    
    public abstract void b(A paramA)
      throws DeadObjectException;
    
    public abstract void cancel();
    
    public abstract Api.c<A> gf();
    
    public abstract int gk();
    
    public abstract void m(Status paramStatus);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/common/api/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */