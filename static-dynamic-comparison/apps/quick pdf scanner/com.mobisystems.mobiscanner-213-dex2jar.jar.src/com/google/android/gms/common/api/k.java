package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.b;
import com.google.android.gms.internal.ct;
import com.google.android.gms.internal.ct.b;
import com.google.android.gms.internal.dc;
import com.google.android.gms.internal.ee;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class k
  implements c
{
  private boolean rA = false;
  private int rB;
  private long rC = 5000L;
  final Handler rD;
  private final Bundle rE = new Bundle();
  private final Map<a.b<?>, a.a> rF = new HashMap();
  private boolean rG;
  final Set<c> rH = new HashSet();
  final c.c rI = new c.c()
  {
    public void a(Bundle paramAnonymousBundle)
    {
      k.a(k.this).lock();
      try
      {
        if (k.b(k.this) == 1)
        {
          if (paramAnonymousBundle != null) {
            k.c(k.this).putAll(paramAnonymousBundle);
          }
          k.d(k.this);
        }
        return;
      }
      finally
      {
        k.a(k.this).unlock();
      }
    }
    
    public void bl(int paramAnonymousInt)
    {
      k.a(k.this).lock();
      for (;;)
      {
        try
        {
          k.a(k.this, paramAnonymousInt);
          switch (paramAnonymousInt)
          {
          default: 
            return;
          }
        }
        finally
        {
          k.a(k.this).unlock();
        }
        k.this.connect();
        continue;
        boolean bool = k.e(k.this);
        if (bool)
        {
          k.a(k.this).unlock();
          return;
        }
        k.b(k.this, 2);
        k.this.rD.sendMessageDelayed(k.this.rD.obtainMessage(1), k.f(k.this));
      }
    }
  };
  private final ct.b rJ = new ct.b()
  {
    public boolean isConnected()
    {
      return k.this.isConnected();
    }
    
    public boolean mG()
    {
      return k.g(k.this);
    }
    
    public Bundle mH()
    {
      return null;
    }
  };
  private final a rr = new a()
  {
    public void b(k.c paramAnonymousc)
    {
      k.a(k.this).lock();
      try
      {
        k.this.rH.remove(paramAnonymousc);
        return;
      }
      finally
      {
        k.a(k.this).unlock();
      }
    }
  };
  private final Lock rs = new ReentrantLock();
  private final Condition rt = this.rs.newCondition();
  private final ct ru = new ct(paramContext, paramLooper, this.rJ);
  final Queue<c<?>> rv = new LinkedList();
  private b rw;
  private int rx;
  private int ry = 4;
  private int rz = 0;
  
  public k(Context paramContext, Looper paramLooper, ee paramee, Map<a, c.a> paramMap, Set<c.c> paramSet, final Set<c.d> paramSet1)
  {
    this.rD = new b(paramLooper);
    paramSet = paramSet.iterator();
    Object localObject;
    while (paramSet.hasNext())
    {
      localObject = (c.c)paramSet.next();
      this.ru.b((c.c)localObject);
    }
    paramSet = paramSet1.iterator();
    while (paramSet.hasNext())
    {
      paramSet1 = (c.d)paramSet.next();
      this.ru.a(paramSet1);
    }
    paramSet = paramMap.keySet().iterator();
    while (paramSet.hasNext())
    {
      localObject = (a)paramSet.next();
      paramSet1 = ((a)localObject).mm();
      localObject = (c.a)paramMap.get(localObject);
      this.rF.put(paramSet1, paramSet1.a(paramContext, paramLooper, paramee, (c.a)localObject, this.rI, new c.d()
      {
        public void a(b paramAnonymousb)
        {
          k.a(k.this).lock();
          try
          {
            if ((k.h(k.this) == null) || (paramSet1.getPriority() < k.i(k.this)))
            {
              k.a(k.this, paramAnonymousb);
              k.c(k.this, paramSet1.getPriority());
            }
            k.d(k.this);
            return;
          }
          finally
          {
            k.a(k.this).unlock();
          }
        }
      }));
    }
  }
  
  /* Error */
  private <A extends a.a> void a(c<A> paramc)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 70	com/google/android/gms/common/api/k:rs	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 198 1 0
    //   9: aload_0
    //   10: invokevirtual 201	com/google/android/gms/common/api/k:isConnected	()Z
    //   13: ldc -53
    //   15: invokestatic 208	com/google/android/gms/internal/dc:a	(ZLjava/lang/Object;)V
    //   18: aload_1
    //   19: invokeinterface 209 1 0
    //   24: ifnull +65 -> 89
    //   27: iconst_1
    //   28: istore_2
    //   29: iload_2
    //   30: ldc -45
    //   32: invokestatic 208	com/google/android/gms/internal/dc:a	(ZLjava/lang/Object;)V
    //   35: aload_1
    //   36: instanceof 213
    //   39: ifeq +24 -> 63
    //   42: aload_0
    //   43: getfield 108	com/google/android/gms/common/api/k:rH	Ljava/util/Set;
    //   46: aload_1
    //   47: invokeinterface 217 2 0
    //   52: pop
    //   53: aload_1
    //   54: aload_0
    //   55: getfield 113	com/google/android/gms/common/api/k:rr	Lcom/google/android/gms/common/api/k$a;
    //   58: invokeinterface 220 2 0
    //   63: aload_1
    //   64: aload_0
    //   65: aload_1
    //   66: invokeinterface 209 1 0
    //   71: invokevirtual 223	com/google/android/gms/common/api/k:a	(Lcom/google/android/gms/common/api/a$b;)Lcom/google/android/gms/common/api/a$a;
    //   74: invokeinterface 226 2 0
    //   79: aload_0
    //   80: getfield 70	com/google/android/gms/common/api/k:rs	Ljava/util/concurrent/locks/Lock;
    //   83: invokeinterface 229 1 0
    //   88: return
    //   89: iconst_0
    //   90: istore_2
    //   91: goto -62 -> 29
    //   94: astore_1
    //   95: aload_0
    //   96: getfield 70	com/google/android/gms/common/api/k:rs	Ljava/util/concurrent/locks/Lock;
    //   99: invokeinterface 229 1 0
    //   104: aload_1
    //   105: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	this	k
    //   0	106	1	paramc	c<A>
    //   28	63	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   9	27	94	finally
    //   29	63	94	finally
    //   63	79	94	finally
  }
  
  private void bn(int paramInt)
  {
    this.rs.lock();
    try
    {
      if (this.ry == 3) {
        break label317;
      }
      if (paramInt != -1) {
        break label136;
      }
      if (isConnecting())
      {
        Iterator localIterator1 = this.rv.iterator();
        while (localIterator1.hasNext()) {
          if (((c)localIterator1.next()).mv() != 1) {
            localIterator1.remove();
          }
        }
      }
      this.rv.clear();
    }
    finally
    {
      this.rs.unlock();
    }
    if ((this.rw == null) && (!this.rv.isEmpty()))
    {
      this.rA = true;
      this.rs.unlock();
      return;
    }
    label136:
    boolean bool1 = isConnecting();
    boolean bool2 = isConnected();
    this.ry = 3;
    if (bool1)
    {
      if (paramInt == -1) {
        this.rw = null;
      }
      this.rt.signalAll();
    }
    Iterator localIterator2 = this.rH.iterator();
    while (localIterator2.hasNext()) {
      ((c)localIterator2.next()).mz();
    }
    this.rH.clear();
    this.rG = false;
    localIterator2 = this.rF.values().iterator();
    while (localIterator2.hasNext())
    {
      a.a locala = (a.a)localIterator2.next();
      if (locala.isConnected()) {
        locala.disconnect();
      }
    }
    this.rG = true;
    this.ry = 4;
    if (bool2)
    {
      if (paramInt != -1) {
        this.ru.cF(paramInt);
      }
      this.rG = false;
    }
    label317:
    this.rs.unlock();
  }
  
  private void mC()
  {
    this.rs.lock();
    for (;;)
    {
      try
      {
        this.rB -= 1;
        if (this.rB == 0)
        {
          if (this.rw == null) {
            break label128;
          }
          this.rA = false;
          bn(3);
          if (mE()) {
            this.rz -= 1;
          }
          if (mE())
          {
            this.rD.sendMessageDelayed(this.rD.obtainMessage(1), this.rC);
            this.rG = false;
          }
        }
        else
        {
          return;
        }
        this.ru.b(this.rw);
        continue;
        this.ry = 2;
      }
      finally
      {
        this.rs.unlock();
      }
      label128:
      mF();
      this.rt.signalAll();
      mD();
      if (!this.rA) {
        break;
      }
      this.rA = false;
      bn(-1);
    }
    if (this.rE.isEmpty()) {}
    for (Bundle localBundle = null;; localBundle = this.rE)
    {
      this.ru.l(localBundle);
      break;
    }
  }
  
  private void mD()
  {
    dc.a(isConnected(), "GoogleApiClient is not connected yet.");
    this.rs.lock();
    try
    {
      for (;;)
      {
        boolean bool = this.rv.isEmpty();
        if (bool) {
          break;
        }
        try
        {
          a((c)this.rv.remove());
        }
        catch (DeadObjectException localDeadObjectException)
        {
          Log.w("GoogleApiClientImpl", "Service died while flushing queue", localDeadObjectException);
        }
      }
    }
    finally
    {
      this.rs.unlock();
    }
  }
  
  /* Error */
  private boolean mE()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 70	com/google/android/gms/common/api/k:rs	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 198 1 0
    //   9: aload_0
    //   10: getfield 87	com/google/android/gms/common/api/k:rz	I
    //   13: istore_1
    //   14: iload_1
    //   15: ifeq +16 -> 31
    //   18: iconst_1
    //   19: istore_2
    //   20: aload_0
    //   21: getfield 70	com/google/android/gms/common/api/k:rs	Ljava/util/concurrent/locks/Lock;
    //   24: invokeinterface 229 1 0
    //   29: iload_2
    //   30: ireturn
    //   31: iconst_0
    //   32: istore_2
    //   33: goto -13 -> 20
    //   36: astore_3
    //   37: aload_0
    //   38: getfield 70	com/google/android/gms/common/api/k:rs	Ljava/util/concurrent/locks/Lock;
    //   41: invokeinterface 229 1 0
    //   46: aload_3
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	k
    //   13	2	1	i	int
    //   19	14	2	bool	boolean
    //   36	11	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	14	36	finally
  }
  
  private void mF()
  {
    this.rs.lock();
    try
    {
      this.rz = 0;
      this.rD.removeMessages(1);
      return;
    }
    finally
    {
      this.rs.unlock();
    }
  }
  
  public <C extends a.a> C a(a.b<C> paramb)
  {
    paramb = (a.a)this.rF.get(paramb);
    dc.e(paramb, "Appropriate Api was not requested.");
    return paramb;
  }
  
  /* Error */
  public <A extends a.a, T extends j.a<? extends f, A>> T a(T paramT)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 70	com/google/android/gms/common/api/k:rs	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 198 1 0
    //   9: aload_0
    //   10: invokevirtual 201	com/google/android/gms/common/api/k:isConnected	()Z
    //   13: ifeq +20 -> 33
    //   16: aload_0
    //   17: aload_1
    //   18: invokevirtual 354	com/google/android/gms/common/api/k:b	(Lcom/google/android/gms/common/api/j$a;)Lcom/google/android/gms/common/api/j$a;
    //   21: pop
    //   22: aload_0
    //   23: getfield 70	com/google/android/gms/common/api/k:rs	Ljava/util/concurrent/locks/Lock;
    //   26: invokeinterface 229 1 0
    //   31: aload_1
    //   32: areturn
    //   33: aload_0
    //   34: getfield 83	com/google/android/gms/common/api/k:rv	Ljava/util/Queue;
    //   37: aload_1
    //   38: invokeinterface 355 2 0
    //   43: pop
    //   44: goto -22 -> 22
    //   47: astore_1
    //   48: aload_0
    //   49: getfield 70	com/google/android/gms/common/api/k:rs	Ljava/util/concurrent/locks/Lock;
    //   52: invokeinterface 229 1 0
    //   57: aload_1
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	k
    //   0	59	1	paramT	T
    // Exception table:
    //   from	to	target	type
    //   9	22	47	finally
    //   33	44	47	finally
  }
  
  public <A extends a.a, T extends j.a<? extends f, A>> T b(T paramT)
  {
    dc.a(isConnected(), "GoogleApiClient is not connected yet.");
    mD();
    try
    {
      a(paramT);
      return paramT;
    }
    catch (DeadObjectException localDeadObjectException)
    {
      bn(1);
    }
    return paramT;
  }
  
  public void connect()
  {
    this.rs.lock();
    try
    {
      this.rA = false;
      if (!isConnected())
      {
        boolean bool = isConnecting();
        if (!bool) {}
      }
      else
      {
        return;
      }
      this.rG = true;
      this.rw = null;
      this.ry = 1;
      this.rE.clear();
      this.rB = this.rF.size();
      Iterator localIterator = this.rF.values().iterator();
      while (localIterator.hasNext()) {
        ((a.a)localIterator.next()).connect();
      }
    }
    finally
    {
      this.rs.unlock();
    }
  }
  
  /* Error */
  public boolean isConnected()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 70	com/google/android/gms/common/api/k:rs	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 198 1 0
    //   9: aload_0
    //   10: getfield 85	com/google/android/gms/common/api/k:ry	I
    //   13: istore_1
    //   14: iload_1
    //   15: iconst_2
    //   16: if_icmpne +16 -> 32
    //   19: iconst_1
    //   20: istore_2
    //   21: aload_0
    //   22: getfield 70	com/google/android/gms/common/api/k:rs	Ljava/util/concurrent/locks/Lock;
    //   25: invokeinterface 229 1 0
    //   30: iload_2
    //   31: ireturn
    //   32: iconst_0
    //   33: istore_2
    //   34: goto -13 -> 21
    //   37: astore_3
    //   38: aload_0
    //   39: getfield 70	com/google/android/gms/common/api/k:rs	Ljava/util/concurrent/locks/Lock;
    //   42: invokeinterface 229 1 0
    //   47: aload_3
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	k
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
    //   3: getfield 70	com/google/android/gms/common/api/k:rs	Ljava/util/concurrent/locks/Lock;
    //   6: invokeinterface 198 1 0
    //   11: aload_0
    //   12: getfield 85	com/google/android/gms/common/api/k:ry	I
    //   15: istore_1
    //   16: iload_1
    //   17: iconst_1
    //   18: if_icmpne +14 -> 32
    //   21: aload_0
    //   22: getfield 70	com/google/android/gms/common/api/k:rs	Ljava/util/concurrent/locks/Lock;
    //   25: invokeinterface 229 1 0
    //   30: iload_2
    //   31: ireturn
    //   32: iconst_0
    //   33: istore_2
    //   34: goto -13 -> 21
    //   37: astore_3
    //   38: aload_0
    //   39: getfield 70	com/google/android/gms/common/api/k:rs	Ljava/util/concurrent/locks/Lock;
    //   42: invokeinterface 229 1 0
    //   47: aload_3
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	k
    //   15	4	1	i	int
    //   1	33	2	bool	boolean
    //   37	11	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	16	37	finally
  }
  
  static abstract interface a
  {
    public abstract void b(k.c paramc);
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
        k.a(k.this).lock();
        try
        {
          if ((!k.this.isConnected()) && (!k.this.isConnecting())) {
            k.this.connect();
          }
          return;
        }
        finally
        {
          k.a(k.this).unlock();
        }
      }
      Log.wtf("GoogleApiClientImpl", "Don't know how to handle this message.");
    }
  }
  
  static abstract interface c<A extends a.a>
  {
    public abstract void a(A paramA);
    
    public abstract void a(k.a parama);
    
    public abstract a.b<A> mm();
    
    public abstract int mv();
    
    public abstract void mz();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/common/api/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */