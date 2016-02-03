package com.amazonaws.org.apache.http.pool;

import com.amazonaws.org.apache.http.concurrent.FutureCallback;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.http.annotation.ThreadSafe;

@ThreadSafe
public abstract class AbstractConnPool<T, C, E extends PoolEntry<T, C>>
  implements ConnPoolControl<T>
{
  private final LinkedList<E> available;
  private final ConnFactory<T, C> connFactory;
  private volatile int defaultMaxPerRoute;
  private volatile boolean isShutDown;
  private final Set<E> leased;
  private final Lock lock;
  private final Map<T, Integer> maxPerRoute;
  private volatile int maxTotal;
  private final LinkedList<PoolEntryFuture<E>> pending;
  private final Map<T, RouteSpecificPool<T, C, E>> routeToPool;
  
  public AbstractConnPool(ConnFactory<T, C> paramConnFactory, int paramInt1, int paramInt2)
  {
    if (paramConnFactory == null) {
      throw new IllegalArgumentException("Connection factory may not null");
    }
    if (paramInt1 <= 0) {
      throw new IllegalArgumentException("Max per route value may not be negative or zero");
    }
    if (paramInt2 <= 0) {
      throw new IllegalArgumentException("Max total value may not be negative or zero");
    }
    this.lock = new ReentrantLock();
    this.connFactory = paramConnFactory;
    this.routeToPool = new HashMap();
    this.leased = new HashSet();
    this.available = new LinkedList();
    this.pending = new LinkedList();
    this.maxPerRoute = new HashMap();
    this.defaultMaxPerRoute = paramInt1;
    this.maxTotal = paramInt2;
  }
  
  private int getMax(T paramT)
  {
    paramT = (Integer)this.maxPerRoute.get(paramT);
    if (paramT != null) {
      return paramT.intValue();
    }
    return this.defaultMaxPerRoute;
  }
  
  private RouteSpecificPool<T, C, E> getPool(final T paramT)
  {
    RouteSpecificPool localRouteSpecificPool = (RouteSpecificPool)this.routeToPool.get(paramT);
    Object localObject = localRouteSpecificPool;
    if (localRouteSpecificPool == null)
    {
      localObject = new RouteSpecificPool(paramT)
      {
        protected E createEntry(C paramAnonymousC)
        {
          return AbstractConnPool.this.createEntry(paramT, paramAnonymousC);
        }
      };
      this.routeToPool.put(paramT, localObject);
    }
    return (RouteSpecificPool<T, C, E>)localObject;
  }
  
  private E getPoolEntryBlocking(T paramT, Object paramObject, long paramLong, TimeUnit paramTimeUnit, PoolEntryFuture<E> paramPoolEntryFuture)
  {
    Object localObject1 = null;
    if (paramLong > 0L) {}
    for (paramTimeUnit = new Date(System.currentTimeMillis() + paramTimeUnit.toMillis(paramLong));; paramTimeUnit = null)
    {
      this.lock.lock();
      for (;;)
      {
        RouteSpecificPool localRouteSpecificPool;
        try
        {
          localRouteSpecificPool = getPool(paramT);
          if (localObject1 != null) {
            break label460;
          }
          if (this.isShutDown) {
            throw new IllegalStateException("Connection pool shut down");
          }
        }
        finally
        {
          this.lock.unlock();
        }
        Object localObject2;
        do
        {
          if ((!((PoolEntry)localObject2).isClosed()) && (!((PoolEntry)localObject2).isExpired(System.currentTimeMillis()))) {
            break;
          }
          ((PoolEntry)localObject2).close();
          this.available.remove(localObject2);
          localRouteSpecificPool.free((PoolEntry)localObject2, false);
          localObject2 = localRouteSpecificPool.getFree(paramObject);
        } while (localObject2 != null);
        if (localObject2 != null)
        {
          this.available.remove(localObject2);
          this.leased.add(localObject2);
          this.lock.unlock();
          return (E)localObject2;
        }
        int j = getMax(paramT);
        int k = Math.max(0, localRouteSpecificPool.getAllocatedCount() + 1 - j);
        int i;
        if (k > 0) {
          i = 0;
        }
        for (;;)
        {
          if (i < k)
          {
            localObject1 = localRouteSpecificPool.getLastUsed();
            if (localObject1 != null) {}
          }
          else
          {
            if (localRouteSpecificPool.getAllocatedCount() >= j) {
              break;
            }
            i = this.leased.size();
            i = Math.max(this.maxTotal - i, 0);
            if (i <= 0) {
              break;
            }
            if ((this.available.size() > i - 1) && (!this.available.isEmpty()))
            {
              paramObject = (PoolEntry)this.available.removeFirst();
              ((PoolEntry)paramObject).close();
              getPool(((PoolEntry)paramObject).getRoute()).remove((PoolEntry)paramObject);
            }
            paramT = localRouteSpecificPool.add(this.connFactory.create(paramT));
            this.leased.add(paramT);
            this.lock.unlock();
            return paramT;
          }
          ((PoolEntry)localObject1).close();
          this.available.remove(localObject1);
          localRouteSpecificPool.remove((PoolEntry)localObject1);
          i += 1;
        }
        try
        {
          localRouteSpecificPool.queue(paramPoolEntryFuture);
          this.pending.add(paramPoolEntryFuture);
          boolean bool = paramPoolEntryFuture.await(paramTimeUnit);
          localRouteSpecificPool.unqueue(paramPoolEntryFuture);
          this.pending.remove(paramPoolEntryFuture);
          localObject1 = localObject2;
          if (!bool)
          {
            localObject1 = localObject2;
            if (paramTimeUnit != null)
            {
              localObject1 = localObject2;
              if (paramTimeUnit.getTime() <= System.currentTimeMillis()) {
                label460:
                throw new TimeoutException("Timeout waiting for connection");
              }
            }
          }
        }
        finally
        {
          localRouteSpecificPool.unqueue(paramPoolEntryFuture);
          this.pending.remove(paramPoolEntryFuture);
        }
      }
    }
  }
  
  private void notifyPending(RouteSpecificPool<T, C, E> paramRouteSpecificPool)
  {
    paramRouteSpecificPool = paramRouteSpecificPool.nextPending();
    if (paramRouteSpecificPool != null) {
      this.pending.remove(paramRouteSpecificPool);
    }
    for (;;)
    {
      if (paramRouteSpecificPool != null) {
        paramRouteSpecificPool.wakeup();
      }
      return;
      paramRouteSpecificPool = (PoolEntryFuture)this.pending.poll();
    }
  }
  
  public void closeIdle(long paramLong, TimeUnit paramTimeUnit)
  {
    long l = 0L;
    if (paramTimeUnit == null) {
      throw new IllegalArgumentException("Time unit must not be null.");
    }
    paramLong = paramTimeUnit.toMillis(paramLong);
    if (paramLong < 0L) {
      paramLong = l;
    }
    for (;;)
    {
      l = System.currentTimeMillis();
      this.lock.lock();
      try
      {
        paramTimeUnit = this.available.iterator();
        while (paramTimeUnit.hasNext())
        {
          PoolEntry localPoolEntry = (PoolEntry)paramTimeUnit.next();
          if (localPoolEntry.getUpdated() <= l - paramLong)
          {
            localPoolEntry.close();
            RouteSpecificPool localRouteSpecificPool = getPool(localPoolEntry.getRoute());
            localRouteSpecificPool.remove(localPoolEntry);
            paramTimeUnit.remove();
            notifyPending(localRouteSpecificPool);
          }
        }
      }
      finally
      {
        this.lock.unlock();
      }
      return;
    }
  }
  
  protected abstract E createEntry(T paramT, C paramC);
  
  public PoolStats getStats(T paramT)
  {
    if (paramT == null) {
      throw new IllegalArgumentException("Route may not be null");
    }
    this.lock.lock();
    try
    {
      RouteSpecificPool localRouteSpecificPool = getPool(paramT);
      paramT = new PoolStats(localRouteSpecificPool.getLeasedCount(), localRouteSpecificPool.getPendingCount(), localRouteSpecificPool.getAvailableCount(), getMax(paramT));
      return paramT;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  public PoolStats getTotalStats()
  {
    this.lock.lock();
    try
    {
      PoolStats localPoolStats = new PoolStats(this.leased.size(), this.pending.size(), this.available.size(), this.maxTotal);
      return localPoolStats;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  public Future<E> lease(T paramT, Object paramObject)
  {
    return lease(paramT, paramObject, null);
  }
  
  public Future<E> lease(final T paramT, final Object paramObject, FutureCallback<E> paramFutureCallback)
  {
    if (paramT == null) {
      throw new IllegalArgumentException("Route may not be null");
    }
    if (this.isShutDown) {
      throw new IllegalStateException("Connection pool shut down");
    }
    new PoolEntryFuture(this.lock, paramFutureCallback)
    {
      public E getPoolEntry(long paramAnonymousLong, TimeUnit paramAnonymousTimeUnit)
      {
        return AbstractConnPool.this.getPoolEntryBlocking(paramT, paramObject, paramAnonymousLong, paramAnonymousTimeUnit, this);
      }
    };
  }
  
  /* Error */
  public void release(E paramE, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 56	com/amazonaws/org/apache/http/pool/AbstractConnPool:lock	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 138 1 0
    //   9: aload_0
    //   10: getfield 68	com/amazonaws/org/apache/http/pool/AbstractConnPool:leased	Ljava/util/Set;
    //   13: aload_1
    //   14: invokeinterface 313 2 0
    //   19: ifeq +43 -> 62
    //   22: aload_0
    //   23: aload_1
    //   24: invokevirtual 209	com/amazonaws/org/apache/http/pool/PoolEntry:getRoute	()Ljava/lang/Object;
    //   27: invokespecial 140	com/amazonaws/org/apache/http/pool/AbstractConnPool:getPool	(Ljava/lang/Object;)Lcom/amazonaws/org/apache/http/pool/RouteSpecificPool;
    //   30: astore_3
    //   31: aload_3
    //   32: aload_1
    //   33: iload_2
    //   34: invokevirtual 171	com/amazonaws/org/apache/http/pool/RouteSpecificPool:free	(Lcom/amazonaws/org/apache/http/pool/PoolEntry;Z)V
    //   37: iload_2
    //   38: ifeq +34 -> 72
    //   41: aload_0
    //   42: getfield 142	com/amazonaws/org/apache/http/pool/AbstractConnPool:isShutDown	Z
    //   45: ifne +27 -> 72
    //   48: aload_0
    //   49: getfield 73	com/amazonaws/org/apache/http/pool/AbstractConnPool:available	Ljava/util/LinkedList;
    //   52: aload_1
    //   53: invokevirtual 224	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   56: pop
    //   57: aload_0
    //   58: aload_3
    //   59: invokespecial 278	com/amazonaws/org/apache/http/pool/AbstractConnPool:notifyPending	(Lcom/amazonaws/org/apache/http/pool/RouteSpecificPool;)V
    //   62: aload_0
    //   63: getfield 56	com/amazonaws/org/apache/http/pool/AbstractConnPool:lock	Ljava/util/concurrent/locks/Lock;
    //   66: invokeinterface 150 1 0
    //   71: return
    //   72: aload_1
    //   73: invokevirtual 163	com/amazonaws/org/apache/http/pool/PoolEntry:close	()V
    //   76: goto -19 -> 57
    //   79: astore_1
    //   80: aload_0
    //   81: getfield 56	com/amazonaws/org/apache/http/pool/AbstractConnPool:lock	Ljava/util/concurrent/locks/Lock;
    //   84: invokeinterface 150 1 0
    //   89: aload_1
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	AbstractConnPool
    //   0	91	1	paramE	E
    //   0	91	2	paramBoolean	boolean
    //   30	29	3	localRouteSpecificPool	RouteSpecificPool
    // Exception table:
    //   from	to	target	type
    //   9	37	79	finally
    //   41	57	79	finally
    //   57	62	79	finally
    //   72	76	79	finally
  }
  
  public void setDefaultMaxPerRoute(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("Max value may not be negative or zero");
    }
    this.lock.lock();
    try
    {
      this.defaultMaxPerRoute = paramInt;
      return;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  public void setMaxTotal(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("Max value may not be negative or zero");
    }
    this.lock.lock();
    try
    {
      this.maxTotal = paramInt;
      return;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  public void shutdown()
  {
    if (this.isShutDown) {
      return;
    }
    this.isShutDown = true;
    this.lock.lock();
    try
    {
      Iterator localIterator1 = this.available.iterator();
      while (localIterator1.hasNext()) {
        ((PoolEntry)localIterator1.next()).close();
      }
      localIterator2 = this.leased.iterator();
    }
    finally
    {
      this.lock.unlock();
    }
    while (localIterator2.hasNext()) {
      ((PoolEntry)localIterator2.next()).close();
    }
    Iterator localIterator2 = this.routeToPool.values().iterator();
    while (localIterator2.hasNext()) {
      ((RouteSpecificPool)localIterator2.next()).shutdown();
    }
    this.routeToPool.clear();
    this.leased.clear();
    this.available.clear();
    this.lock.unlock();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[leased: ");
    localStringBuilder.append(this.leased);
    localStringBuilder.append("][available: ");
    localStringBuilder.append(this.available);
    localStringBuilder.append("][pending: ");
    localStringBuilder.append(this.pending);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/pool/AbstractConnPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */