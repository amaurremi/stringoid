package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.h;
import android.support.v4.app.l;
import android.support.v4.app.p;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.gy;
import com.google.android.gms.internal.hc;
import com.google.android.gms.internal.hc.b;
import com.google.android.gms.internal.hm;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class c
  implements GoogleApiClient
{
  final Queue<g<?>> a = new LinkedList();
  final Handler b;
  final Set<g<?>> c = Collections.newSetFromMap(new ConcurrentHashMap());
  final GoogleApiClient.ConnectionCallbacks d = new GoogleApiClient.ConnectionCallbacks()
  {
    public void onConnected(Bundle paramAnonymousBundle)
    {
      c.a(c.this).lock();
      try
      {
        if (c.b(c.this) == 1)
        {
          if (paramAnonymousBundle != null) {
            c.c(c.this).putAll(paramAnonymousBundle);
          }
          c.d(c.this);
        }
        return;
      }
      finally
      {
        c.a(c.this).unlock();
      }
    }
    
    public void onConnectionSuspended(int paramAnonymousInt)
    {
      c.a(c.this).lock();
      for (;;)
      {
        try
        {
          c.a(c.this, paramAnonymousInt);
          switch (paramAnonymousInt)
          {
          default: 
            return;
          }
        }
        finally
        {
          c.a(c.this).unlock();
        }
        c.this.connect();
        continue;
        boolean bool = c.e(c.this);
        if (bool)
        {
          c.a(c.this).unlock();
          return;
        }
        c.b(c.this, 2);
        c.this.b.sendMessageDelayed(c.this.b.obtainMessage(1), c.f(c.this));
      }
    }
  };
  private final Lock e = new ReentrantLock();
  private final Condition f = this.e.newCondition();
  private final hc g = new hc(paramContext, paramLooper, this.v);
  private final Fragment h;
  private final Looper i;
  private ConnectionResult j;
  private int k;
  private int l = 4;
  private int m = 0;
  private boolean n = false;
  private int o;
  private long p = 5000L;
  private final Bundle q = new Bundle();
  private final Map<Api.c<?>, Api.a> r = new HashMap();
  private final List<String> s;
  private boolean t;
  private final e u = new e()
  {
    public void a(g<?> paramAnonymousg)
    {
      c.this.c.remove(paramAnonymousg);
    }
  };
  private final hc.b v = new hc.b()
  {
    public boolean eO()
    {
      return c.g(c.this);
    }
    
    public Bundle ef()
    {
      return null;
    }
    
    public boolean isConnected()
    {
      return c.this.isConnected();
    }
  };
  
  public c(Context paramContext, Looper paramLooper, gy paramgy, Map<Api<?>, Api.ApiOptions> paramMap, Fragment paramFragment, Set<GoogleApiClient.ConnectionCallbacks> paramSet, final Set<GoogleApiClient.OnConnectionFailedListener> paramSet1)
  {
    this.h = paramFragment;
    this.i = paramLooper;
    this.b = new f(this, paramLooper);
    paramFragment = paramSet.iterator();
    while (paramFragment.hasNext())
    {
      paramSet = (GoogleApiClient.ConnectionCallbacks)paramFragment.next();
      this.g.registerConnectionCallbacks(paramSet);
    }
    paramFragment = paramSet1.iterator();
    while (paramFragment.hasNext())
    {
      paramSet = (GoogleApiClient.OnConnectionFailedListener)paramFragment.next();
      this.g.registerConnectionFailedListener(paramSet);
    }
    paramFragment = paramMap.keySet().iterator();
    while (paramFragment.hasNext())
    {
      paramSet = (Api)paramFragment.next();
      paramSet1 = paramSet.ez();
      Object localObject = paramMap.get(paramSet);
      this.r.put(paramSet.eB(), a(paramSet1, localObject, paramContext, paramLooper, paramgy, this.d, new GoogleApiClient.OnConnectionFailedListener()
      {
        public void onConnectionFailed(ConnectionResult paramAnonymousConnectionResult)
        {
          c.a(c.this).lock();
          try
          {
            if ((c.h(c.this) == null) || (paramSet1.getPriority() < c.i(c.this)))
            {
              c.a(c.this, paramAnonymousConnectionResult);
              c.c(c.this, paramSet1.getPriority());
            }
            c.d(c.this);
            return;
          }
          finally
          {
            c.a(c.this).unlock();
          }
        }
      }));
    }
    this.s = Collections.unmodifiableList(paramgy.fl());
  }
  
  private static <C extends Api.a, O> C a(Api.b<C, O> paramb, Object paramObject, Context paramContext, Looper paramLooper, gy paramgy, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    return paramb.a(paramContext, paramLooper, paramgy, paramObject, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  private void a()
  {
    this.e.lock();
    for (;;)
    {
      try
      {
        this.o -= 1;
        if (this.o == 0)
        {
          if (this.j == null) {
            break label128;
          }
          this.n = false;
          a(3);
          if (c()) {
            this.m -= 1;
          }
          if (c())
          {
            this.b.sendMessageDelayed(this.b.obtainMessage(1), this.p);
            this.t = false;
          }
        }
        else
        {
          return;
        }
        this.g.a(this.j);
        continue;
        this.l = 2;
      }
      finally
      {
        this.e.unlock();
      }
      label128:
      d();
      this.f.signalAll();
      b();
      if (!this.n) {
        break;
      }
      this.n = false;
      a(-1);
    }
    if (this.q.isEmpty()) {}
    for (Bundle localBundle = null;; localBundle = this.q)
    {
      this.g.c(localBundle);
      break;
    }
  }
  
  private void a(int paramInt)
  {
    this.e.lock();
    Object localObject2;
    try
    {
      if (this.l == 3) {
        break label328;
      }
      if (paramInt != -1) {
        break label195;
      }
      if (isConnecting())
      {
        Iterator localIterator1 = this.a.iterator();
        while (localIterator1.hasNext())
        {
          localObject2 = (g)localIterator1.next();
          if (((g)localObject2).eG() != 1)
          {
            ((g)localObject2).cancel();
            localIterator1.remove();
          }
        }
      }
      this.a.clear();
    }
    finally
    {
      this.e.unlock();
    }
    Iterator localIterator2 = this.c.iterator();
    while (localIterator2.hasNext()) {
      ((g)localIterator2.next()).cancel();
    }
    this.c.clear();
    if ((this.j == null) && (!this.a.isEmpty()))
    {
      this.n = true;
      this.e.unlock();
      return;
    }
    label195:
    boolean bool1 = isConnecting();
    boolean bool2 = isConnected();
    this.l = 3;
    if (bool1)
    {
      if (paramInt == -1) {
        this.j = null;
      }
      this.f.signalAll();
    }
    this.t = false;
    localIterator2 = this.r.values().iterator();
    while (localIterator2.hasNext())
    {
      localObject2 = (Api.a)localIterator2.next();
      if (((Api.a)localObject2).isConnected()) {
        ((Api.a)localObject2).disconnect();
      }
    }
    this.t = true;
    this.l = 4;
    if (bool2)
    {
      if (paramInt != -1) {
        this.g.ao(paramInt);
      }
      this.t = false;
    }
    label328:
    this.e.unlock();
  }
  
  private <A extends Api.a> void a(g<A> paramg)
  {
    boolean bool2 = true;
    this.e.lock();
    for (;;)
    {
      try
      {
        if (!isConnected())
        {
          if (c())
          {
            break label154;
            hm.a(bool1, "GoogleApiClient is not connected yet.");
            if (paramg.eB() != null)
            {
              bool1 = bool2;
              hm.b(bool1, "This task can not be executed or enqueued (it's probably a Batch or malformed)");
              this.c.add(paramg);
              paramg.a(this.u);
              if (!c()) {
                continue;
              }
              paramg.m(new Status(8));
            }
          }
          else
          {
            bool1 = false;
            continue;
          }
          bool1 = false;
          continue;
          paramg.b(a(paramg.eB()));
          return;
        }
      }
      finally
      {
        this.e.unlock();
      }
      label154:
      boolean bool1 = true;
    }
  }
  
  private void b()
  {
    boolean bool;
    if ((isConnected()) || (c())) {
      bool = true;
    }
    for (;;)
    {
      hm.a(bool, "GoogleApiClient is not connected yet.");
      this.e.lock();
      try
      {
        for (;;)
        {
          bool = this.a.isEmpty();
          if (bool) {
            break;
          }
          try
          {
            a((g)this.a.remove());
          }
          catch (DeadObjectException localDeadObjectException)
          {
            Log.w("GoogleApiClientImpl", "Service died while flushing queue", localDeadObjectException);
          }
        }
        bool = false;
      }
      finally
      {
        this.e.unlock();
      }
    }
    this.e.unlock();
  }
  
  /* Error */
  private boolean c()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 68	com/google/android/gms/common/api/c:e	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 227 1 0
    //   9: aload_0
    //   10: getfield 85	com/google/android/gms/common/api/c:m	I
    //   13: istore_1
    //   14: iload_1
    //   15: ifeq +16 -> 31
    //   18: iconst_1
    //   19: istore_2
    //   20: aload_0
    //   21: getfield 68	com/google/android/gms/common/api/c:e	Ljava/util/concurrent/locks/Lock;
    //   24: invokeinterface 249 1 0
    //   29: iload_2
    //   30: ireturn
    //   31: iconst_0
    //   32: istore_2
    //   33: goto -13 -> 20
    //   36: astore_3
    //   37: aload_0
    //   38: getfield 68	com/google/android/gms/common/api/c:e	Ljava/util/concurrent/locks/Lock;
    //   41: invokeinterface 249 1 0
    //   46: aload_3
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	c
    //   13	2	1	i1	int
    //   19	14	2	bool	boolean
    //   36	11	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	14	36	finally
  }
  
  private void d()
  {
    this.e.lock();
    try
    {
      this.m = 0;
      this.b.removeMessages(1);
      return;
    }
    finally
    {
      this.e.unlock();
    }
  }
  
  public <C extends Api.a> C a(Api.c<C> paramc)
  {
    paramc = (Api.a)this.r.get(paramc);
    hm.b(paramc, "Appropriate Api was not requested.");
    return paramc;
  }
  
  /* Error */
  public <A extends Api.a, T extends a.b<? extends Result, A>> T a(T paramT)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 68	com/google/android/gms/common/api/c:e	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 227 1 0
    //   9: aload_0
    //   10: invokevirtual 293	com/google/android/gms/common/api/c:isConnected	()Z
    //   13: ifeq +20 -> 33
    //   16: aload_0
    //   17: aload_1
    //   18: invokevirtual 381	com/google/android/gms/common/api/c:b	(Lcom/google/android/gms/common/api/a$b;)Lcom/google/android/gms/common/api/a$b;
    //   21: pop
    //   22: aload_0
    //   23: getfield 68	com/google/android/gms/common/api/c:e	Ljava/util/concurrent/locks/Lock;
    //   26: invokeinterface 249 1 0
    //   31: aload_1
    //   32: areturn
    //   33: aload_0
    //   34: getfield 81	com/google/android/gms/common/api/c:a	Ljava/util/Queue;
    //   37: aload_1
    //   38: invokeinterface 382 2 0
    //   43: pop
    //   44: goto -22 -> 22
    //   47: astore_1
    //   48: aload_0
    //   49: getfield 68	com/google/android/gms/common/api/c:e	Ljava/util/concurrent/locks/Lock;
    //   52: invokeinterface 249 1 0
    //   57: aload_1
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	c
    //   0	59	1	paramT	T
    // Exception table:
    //   from	to	target	type
    //   9	22	47	finally
    //   33	44	47	finally
  }
  
  public <A extends Api.a, T extends a.b<? extends Result, A>> T b(T paramT)
  {
    if ((isConnected()) || (c())) {}
    for (boolean bool = true;; bool = false)
    {
      hm.a(bool, "GoogleApiClient is not connected yet.");
      b();
      try
      {
        a(paramT);
        return paramT;
      }
      catch (DeadObjectException localDeadObjectException)
      {
        a(1);
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
      hm.a(bool, "blockingConnect must not be called on the UI thread");
      this.e.lock();
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
            this.f.await();
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
          localConnectionResult = ConnectionResult.CS;
          return localConnectionResult;
        }
        if (this.j != null)
        {
          localConnectionResult = this.j;
          return localConnectionResult;
        }
        ConnectionResult localConnectionResult = new ConnectionResult(13, null);
        return localConnectionResult;
      }
      finally
      {
        this.e.unlock();
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
      hm.a(bool, "blockingConnect must not be called on the UI thread");
      this.e.lock();
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
            long l1 = this.f.awaitNanos(paramLong);
            paramLong = l1;
            if (l1 <= 0L)
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
          paramTimeUnit = ConnectionResult.CS;
          return paramTimeUnit;
        }
        if (this.j != null)
        {
          paramTimeUnit = this.j;
          return paramTimeUnit;
        }
        paramTimeUnit = new ConnectionResult(13, null);
        return paramTimeUnit;
      }
      finally
      {
        this.e.unlock();
      }
    }
  }
  
  public void connect()
  {
    this.e.lock();
    try
    {
      this.n = false;
      if (!isConnected())
      {
        boolean bool = isConnecting();
        if (!bool) {}
      }
      else
      {
        return;
      }
      this.t = true;
      this.j = null;
      this.l = 1;
      this.q.clear();
      this.o = this.r.size();
      Iterator localIterator = this.r.values().iterator();
      while (localIterator.hasNext()) {
        ((Api.a)localIterator.next()).connect();
      }
    }
    finally
    {
      this.e.unlock();
    }
  }
  
  public void disconnect()
  {
    d();
    a(-1);
  }
  
  public Looper getLooper()
  {
    return this.i;
  }
  
  /* Error */
  public boolean isConnected()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 68	com/google/android/gms/common/api/c:e	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 227 1 0
    //   9: aload_0
    //   10: getfield 83	com/google/android/gms/common/api/c:l	I
    //   13: istore_1
    //   14: iload_1
    //   15: iconst_2
    //   16: if_icmpne +16 -> 32
    //   19: iconst_1
    //   20: istore_2
    //   21: aload_0
    //   22: getfield 68	com/google/android/gms/common/api/c:e	Ljava/util/concurrent/locks/Lock;
    //   25: invokeinterface 249 1 0
    //   30: iload_2
    //   31: ireturn
    //   32: iconst_0
    //   33: istore_2
    //   34: goto -13 -> 21
    //   37: astore_3
    //   38: aload_0
    //   39: getfield 68	com/google/android/gms/common/api/c:e	Ljava/util/concurrent/locks/Lock;
    //   42: invokeinterface 249 1 0
    //   47: aload_3
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	c
    //   13	4	1	i1	int
    //   20	14	2	bool	boolean
    //   37	11	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	14	37	finally
  }
  
  /* Error */
  public boolean isConnecting()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: getfield 68	com/google/android/gms/common/api/c:e	Ljava/util/concurrent/locks/Lock;
    //   6: invokeinterface 227 1 0
    //   11: aload_0
    //   12: getfield 83	com/google/android/gms/common/api/c:l	I
    //   15: istore_1
    //   16: iload_1
    //   17: iconst_1
    //   18: if_icmpne +14 -> 32
    //   21: aload_0
    //   22: getfield 68	com/google/android/gms/common/api/c:e	Ljava/util/concurrent/locks/Lock;
    //   25: invokeinterface 249 1 0
    //   30: iload_2
    //   31: ireturn
    //   32: iconst_0
    //   33: istore_2
    //   34: goto -13 -> 21
    //   37: astore_3
    //   38: aload_0
    //   39: getfield 68	com/google/android/gms/common/api/c:e	Ljava/util/concurrent/locks/Lock;
    //   42: invokeinterface 249 1 0
    //   47: aload_3
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	c
    //   15	4	1	i1	int
    //   1	33	2	bool	boolean
    //   37	11	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	16	37	finally
  }
  
  public boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    return this.g.isConnectionCallbacksRegistered(paramConnectionCallbacks);
  }
  
  public boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    return this.g.isConnectionFailedListenerRegistered(paramOnConnectionFailedListener);
  }
  
  public void reconnect()
  {
    disconnect();
    connect();
  }
  
  public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.g.registerConnectionCallbacks(paramConnectionCallbacks);
  }
  
  public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.g.registerConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  public void stopAutoManage()
  {
    if (this.h != null) {}
    for (boolean bool = true;; bool = false)
    {
      hm.a(bool, "Called stopAutoManage but automatic lifecycle management is not enabled.");
      if (this.h.getActivity() != null)
      {
        this.h.getActivity().e().a().a(this.h).a();
        disconnect();
      }
      return;
    }
  }
  
  public void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.g.unregisterConnectionCallbacks(paramConnectionCallbacks);
  }
  
  public void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.g.unregisterConnectionFailedListener(paramOnConnectionFailedListener);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/common/api/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */