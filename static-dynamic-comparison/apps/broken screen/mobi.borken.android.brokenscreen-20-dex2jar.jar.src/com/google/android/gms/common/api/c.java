package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.gz;
import com.google.android.gms.internal.hd;
import com.google.android.gms.internal.hd.b;
import com.google.android.gms.internal.hn;
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
  private final Looper DC;
  private final Lock DN = new ReentrantLock();
  private final Condition DO = this.DN.newCondition();
  private final hd DP = new hd(paramContext, paramLooper, this.Eg);
  private final Fragment DQ;
  final Queue<c<?>> DR = new LinkedList();
  private ConnectionResult DS;
  private int DT;
  private int DU = 4;
  private int DV = 0;
  private boolean DW = false;
  private int DX;
  private long DY = 5000L;
  final Handler DZ;
  private final a Dv = new a()
  {
    public void b(c.c<?> paramAnonymousc)
    {
      c.this.Ee.remove(paramAnonymousc);
    }
  };
  private final Bundle Ea = new Bundle();
  private final Map<Api.c<?>, Api.a> Eb = new HashMap();
  private final List<String> Ec;
  private boolean Ed;
  final Set<c<?>> Ee = Collections.newSetFromMap(new ConcurrentHashMap());
  final GoogleApiClient.ConnectionCallbacks Ef = new GoogleApiClient.ConnectionCallbacks()
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
        c.this.DZ.sendMessageDelayed(c.this.DZ.obtainMessage(1), c.f(c.this));
      }
    }
  };
  private final hd.b Eg = new hd.b()
  {
    public boolean eJ()
    {
      return c.g(c.this);
    }
    
    public Bundle ea()
    {
      return null;
    }
    
    public boolean isConnected()
    {
      return c.this.isConnected();
    }
  };
  
  public c(Context paramContext, Looper paramLooper, gz paramgz, Map<Api<?>, Api.ApiOptions> paramMap, Fragment paramFragment, Set<GoogleApiClient.ConnectionCallbacks> paramSet, final Set<GoogleApiClient.OnConnectionFailedListener> paramSet1)
  {
    this.DQ = paramFragment;
    this.DC = paramLooper;
    this.DZ = new b(paramLooper);
    paramFragment = paramSet.iterator();
    while (paramFragment.hasNext())
    {
      paramSet = (GoogleApiClient.ConnectionCallbacks)paramFragment.next();
      this.DP.registerConnectionCallbacks(paramSet);
    }
    paramFragment = paramSet1.iterator();
    while (paramFragment.hasNext())
    {
      paramSet = (GoogleApiClient.OnConnectionFailedListener)paramFragment.next();
      this.DP.registerConnectionFailedListener(paramSet);
    }
    paramFragment = paramMap.keySet().iterator();
    while (paramFragment.hasNext())
    {
      paramSet = (Api)paramFragment.next();
      paramSet1 = paramSet.eu();
      Object localObject = paramMap.get(paramSet);
      this.Eb.put(paramSet.ew(), a(paramSet1, localObject, paramContext, paramLooper, paramgz, this.Ef, new GoogleApiClient.OnConnectionFailedListener()
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
    this.Ec = Collections.unmodifiableList(paramgz.fg());
  }
  
  private static <C extends Api.a, O> C a(Api.b<C, O> paramb, Object paramObject, Context paramContext, Looper paramLooper, gz paramgz, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    return paramb.a(paramContext, paramLooper, paramgz, paramObject, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  private <A extends Api.a> void a(c<A> paramc)
    throws DeadObjectException
  {
    boolean bool2 = true;
    this.DN.lock();
    for (;;)
    {
      try
      {
        if (!isConnected())
        {
          if (eH())
          {
            break label152;
            hn.a(bool1, "GoogleApiClient is not connected yet.");
            if (paramc.ew() != null)
            {
              bool1 = bool2;
              hn.b(bool1, "This task can not be executed or enqueued (it's probably a Batch or malformed)");
              this.Ee.add(paramc);
              paramc.a(this.Dv);
              if (!eH()) {
                continue;
              }
              paramc.m(new Status(8));
            }
          }
          else
          {
            bool1 = false;
            continue;
          }
          bool1 = false;
          continue;
          paramc.b(a(paramc.ew()));
          return;
        }
      }
      finally
      {
        this.DN.unlock();
      }
      label152:
      boolean bool1 = true;
    }
  }
  
  private void aa(int paramInt)
  {
    this.DN.lock();
    Object localObject2;
    try
    {
      if (this.DU == 3) {
        break label328;
      }
      if (paramInt != -1) {
        break label195;
      }
      if (isConnecting())
      {
        Iterator localIterator1 = this.DR.iterator();
        while (localIterator1.hasNext())
        {
          localObject2 = (c)localIterator1.next();
          if (((c)localObject2).eB() != 1)
          {
            ((c)localObject2).cancel();
            localIterator1.remove();
          }
        }
      }
      this.DR.clear();
    }
    finally
    {
      this.DN.unlock();
    }
    Iterator localIterator2 = this.Ee.iterator();
    while (localIterator2.hasNext()) {
      ((c)localIterator2.next()).cancel();
    }
    this.Ee.clear();
    if ((this.DS == null) && (!this.DR.isEmpty()))
    {
      this.DW = true;
      this.DN.unlock();
      return;
    }
    label195:
    boolean bool1 = isConnecting();
    boolean bool2 = isConnected();
    this.DU = 3;
    if (bool1)
    {
      if (paramInt == -1) {
        this.DS = null;
      }
      this.DO.signalAll();
    }
    this.Ed = false;
    localIterator2 = this.Eb.values().iterator();
    while (localIterator2.hasNext())
    {
      localObject2 = (Api.a)localIterator2.next();
      if (((Api.a)localObject2).isConnected()) {
        ((Api.a)localObject2).disconnect();
      }
    }
    this.Ed = true;
    this.DU = 4;
    if (bool2)
    {
      if (paramInt != -1) {
        this.DP.ao(paramInt);
      }
      this.Ed = false;
    }
    label328:
    this.DN.unlock();
  }
  
  private void eF()
  {
    this.DN.lock();
    for (;;)
    {
      try
      {
        this.DX -= 1;
        if (this.DX == 0)
        {
          if (this.DS == null) {
            break label128;
          }
          this.DW = false;
          aa(3);
          if (eH()) {
            this.DV -= 1;
          }
          if (eH())
          {
            this.DZ.sendMessageDelayed(this.DZ.obtainMessage(1), this.DY);
            this.Ed = false;
          }
        }
        else
        {
          return;
        }
        this.DP.a(this.DS);
        continue;
        this.DU = 2;
      }
      finally
      {
        this.DN.unlock();
      }
      label128:
      eI();
      this.DO.signalAll();
      eG();
      if (!this.DW) {
        break;
      }
      this.DW = false;
      aa(-1);
    }
    if (this.Ea.isEmpty()) {}
    for (Bundle localBundle = null;; localBundle = this.Ea)
    {
      this.DP.c(localBundle);
      break;
    }
  }
  
  private void eG()
  {
    boolean bool;
    if ((isConnected()) || (eH())) {
      bool = true;
    }
    for (;;)
    {
      hn.a(bool, "GoogleApiClient is not connected yet.");
      this.DN.lock();
      try
      {
        for (;;)
        {
          bool = this.DR.isEmpty();
          if (bool) {
            break;
          }
          try
          {
            a((c)this.DR.remove());
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
        this.DN.unlock();
      }
    }
    this.DN.unlock();
  }
  
  /* Error */
  private boolean eH()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 77	com/google/android/gms/common/api/c:DN	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 237 1 0
    //   9: aload_0
    //   10: getfield 94	com/google/android/gms/common/api/c:DV	I
    //   13: istore_1
    //   14: iload_1
    //   15: ifeq +16 -> 31
    //   18: iconst_1
    //   19: istore_2
    //   20: aload_0
    //   21: getfield 77	com/google/android/gms/common/api/c:DN	Ljava/util/concurrent/locks/Lock;
    //   24: invokeinterface 274 1 0
    //   29: iload_2
    //   30: ireturn
    //   31: iconst_0
    //   32: istore_2
    //   33: goto -13 -> 20
    //   36: astore_3
    //   37: aload_0
    //   38: getfield 77	com/google/android/gms/common/api/c:DN	Ljava/util/concurrent/locks/Lock;
    //   41: invokeinterface 274 1 0
    //   46: aload_3
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	c
    //   13	2	1	i	int
    //   19	14	2	bool	boolean
    //   36	11	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	14	36	finally
  }
  
  private void eI()
  {
    this.DN.lock();
    try
    {
      this.DV = 0;
      this.DZ.removeMessages(1);
      return;
    }
    finally
    {
      this.DN.unlock();
    }
  }
  
  public <C extends Api.a> C a(Api.c<C> paramc)
  {
    paramc = (Api.a)this.Eb.get(paramc);
    hn.b(paramc, "Appropriate Api was not requested.");
    return paramc;
  }
  
  /* Error */
  public <A extends Api.a, T extends a.b<? extends Result, A>> T a(T paramT)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 77	com/google/android/gms/common/api/c:DN	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 237 1 0
    //   9: aload_0
    //   10: invokevirtual 240	com/google/android/gms/common/api/c:isConnected	()Z
    //   13: ifeq +20 -> 33
    //   16: aload_0
    //   17: aload_1
    //   18: invokevirtual 399	com/google/android/gms/common/api/c:b	(Lcom/google/android/gms/common/api/a$b;)Lcom/google/android/gms/common/api/a$b;
    //   21: pop
    //   22: aload_0
    //   23: getfield 77	com/google/android/gms/common/api/c:DN	Ljava/util/concurrent/locks/Lock;
    //   26: invokeinterface 274 1 0
    //   31: aload_1
    //   32: areturn
    //   33: aload_0
    //   34: getfield 90	com/google/android/gms/common/api/c:DR	Ljava/util/Queue;
    //   37: aload_1
    //   38: invokeinterface 400 2 0
    //   43: pop
    //   44: goto -22 -> 22
    //   47: astore_1
    //   48: aload_0
    //   49: getfield 77	com/google/android/gms/common/api/c:DN	Ljava/util/concurrent/locks/Lock;
    //   52: invokeinterface 274 1 0
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
    if ((isConnected()) || (eH())) {}
    for (boolean bool = true;; bool = false)
    {
      hn.a(bool, "GoogleApiClient is not connected yet.");
      eG();
      try
      {
        a(paramT);
        return paramT;
      }
      catch (DeadObjectException localDeadObjectException)
      {
        aa(1);
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
      hn.a(bool, "blockingConnect must not be called on the UI thread");
      this.DN.lock();
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
            this.DO.await();
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
          localConnectionResult = ConnectionResult.CP;
          return localConnectionResult;
        }
        if (this.DS != null)
        {
          localConnectionResult = this.DS;
          return localConnectionResult;
        }
        ConnectionResult localConnectionResult = new ConnectionResult(13, null);
        return localConnectionResult;
      }
      finally
      {
        this.DN.unlock();
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
      hn.a(bool, "blockingConnect must not be called on the UI thread");
      this.DN.lock();
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
            long l = this.DO.awaitNanos(paramLong);
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
          paramTimeUnit = ConnectionResult.CP;
          return paramTimeUnit;
        }
        if (this.DS != null)
        {
          paramTimeUnit = this.DS;
          return paramTimeUnit;
        }
        paramTimeUnit = new ConnectionResult(13, null);
        return paramTimeUnit;
      }
      finally
      {
        this.DN.unlock();
      }
    }
  }
  
  public void connect()
  {
    this.DN.lock();
    try
    {
      this.DW = false;
      if (!isConnected())
      {
        boolean bool = isConnecting();
        if (!bool) {}
      }
      else
      {
        return;
      }
      this.Ed = true;
      this.DS = null;
      this.DU = 1;
      this.Ea.clear();
      this.DX = this.Eb.size();
      Iterator localIterator = this.Eb.values().iterator();
      while (localIterator.hasNext()) {
        ((Api.a)localIterator.next()).connect();
      }
    }
    finally
    {
      this.DN.unlock();
    }
  }
  
  public void disconnect()
  {
    eI();
    aa(-1);
  }
  
  public Looper getLooper()
  {
    return this.DC;
  }
  
  /* Error */
  public boolean isConnected()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 77	com/google/android/gms/common/api/c:DN	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 237 1 0
    //   9: aload_0
    //   10: getfield 92	com/google/android/gms/common/api/c:DU	I
    //   13: istore_1
    //   14: iload_1
    //   15: iconst_2
    //   16: if_icmpne +16 -> 32
    //   19: iconst_1
    //   20: istore_2
    //   21: aload_0
    //   22: getfield 77	com/google/android/gms/common/api/c:DN	Ljava/util/concurrent/locks/Lock;
    //   25: invokeinterface 274 1 0
    //   30: iload_2
    //   31: ireturn
    //   32: iconst_0
    //   33: istore_2
    //   34: goto -13 -> 21
    //   37: astore_3
    //   38: aload_0
    //   39: getfield 77	com/google/android/gms/common/api/c:DN	Ljava/util/concurrent/locks/Lock;
    //   42: invokeinterface 274 1 0
    //   47: aload_3
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	c
    //   13	4	1	i	int
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
    //   3: getfield 77	com/google/android/gms/common/api/c:DN	Ljava/util/concurrent/locks/Lock;
    //   6: invokeinterface 237 1 0
    //   11: aload_0
    //   12: getfield 92	com/google/android/gms/common/api/c:DU	I
    //   15: istore_1
    //   16: iload_1
    //   17: iconst_1
    //   18: if_icmpne +14 -> 32
    //   21: aload_0
    //   22: getfield 77	com/google/android/gms/common/api/c:DN	Ljava/util/concurrent/locks/Lock;
    //   25: invokeinterface 274 1 0
    //   30: iload_2
    //   31: ireturn
    //   32: iconst_0
    //   33: istore_2
    //   34: goto -13 -> 21
    //   37: astore_3
    //   38: aload_0
    //   39: getfield 77	com/google/android/gms/common/api/c:DN	Ljava/util/concurrent/locks/Lock;
    //   42: invokeinterface 274 1 0
    //   47: aload_3
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	c
    //   15	4	1	i	int
    //   1	33	2	bool	boolean
    //   37	11	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	16	37	finally
  }
  
  public boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    return this.DP.isConnectionCallbacksRegistered(paramConnectionCallbacks);
  }
  
  public boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    return this.DP.isConnectionFailedListenerRegistered(paramOnConnectionFailedListener);
  }
  
  public void reconnect()
  {
    disconnect();
    connect();
  }
  
  public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.DP.registerConnectionCallbacks(paramConnectionCallbacks);
  }
  
  public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.DP.registerConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  public void stopAutoManage()
  {
    if (this.DQ != null) {}
    for (boolean bool = true;; bool = false)
    {
      hn.a(bool, "Called stopAutoManage but automatic lifecycle management is not enabled.");
      if (this.DQ.getActivity() != null)
      {
        this.DQ.getActivity().getSupportFragmentManager().beginTransaction().remove(this.DQ).commit();
        disconnect();
      }
      return;
    }
  }
  
  public void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.DP.unregisterConnectionCallbacks(paramConnectionCallbacks);
  }
  
  public void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.DP.unregisterConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  static abstract interface a
  {
    public abstract void b(c.c<?> paramc);
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
        c.a(c.this).lock();
        try
        {
          if ((!c.this.isConnected()) && (!c.this.isConnecting())) {
            c.this.connect();
          }
          return;
        }
        finally
        {
          c.a(c.this).unlock();
        }
      }
      Log.wtf("GoogleApiClientImpl", "Don't know how to handle this message.");
    }
  }
  
  static abstract interface c<A extends Api.a>
  {
    public abstract void a(c.a parama);
    
    public abstract void b(A paramA)
      throws DeadObjectException;
    
    public abstract void cancel();
    
    public abstract int eB();
    
    public abstract Api.c<A> ew();
    
    public abstract void m(Status paramStatus);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/common/api/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */