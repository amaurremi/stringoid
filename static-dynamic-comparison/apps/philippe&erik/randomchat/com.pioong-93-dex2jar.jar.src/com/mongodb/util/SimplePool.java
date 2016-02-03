package com.mongodb.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public abstract class SimplePool<T>
{
  protected final List<T> _avail = new ArrayList();
  private boolean _closed;
  protected final String _name;
  protected final Set<T> _out = new HashSet();
  private final Semaphore _sem;
  protected final int _size;
  
  static
  {
    if (!SimplePool.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public SimplePool(String paramString, int paramInt)
  {
    this._name = paramString;
    this._size = paramInt;
    this._sem = new Semaphore(paramInt);
  }
  
  private void assertConditions()
  {
    assert (getTotal() <= getMaxSize());
  }
  
  private T createNewAndReleasePermitIfFailure()
  {
    try
    {
      Object localObject = createNew();
      if (localObject == null) {
        throw new IllegalStateException("null pool members are not allowed");
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      this._sem.release();
      throw localRuntimeException;
    }
    catch (Error localError)
    {
      this._sem.release();
      throw localError;
    }
    return localError;
  }
  
  private boolean permitAcquired(long paramLong)
    throws InterruptedException
  {
    if (paramLong > 0L) {
      return this._sem.tryAcquire(paramLong, TimeUnit.MILLISECONDS);
    }
    if (paramLong < 0L)
    {
      this._sem.acquire();
      return true;
    }
    return this._sem.tryAcquire();
  }
  
  public void cleanup(T paramT) {}
  
  protected void close()
  {
    try
    {
      this._closed = true;
      Iterator localIterator = this._avail.iterator();
      while (localIterator.hasNext()) {
        cleanup(localIterator.next());
      }
      this._avail.clear();
    }
    finally {}
    this._out.clear();
  }
  
  protected abstract T createNew();
  
  public void done(T paramT)
  {
    try
    {
      if (this._closed)
      {
        cleanup(paramT);
        return;
      }
      assertConditions();
      if (!this._out.remove(paramT)) {
        throw new RuntimeException("trying to put something back in the pool wasn't checked out");
      }
    }
    finally {}
    this._avail.add(paramT);
    this._sem.release();
  }
  
  public T get()
    throws InterruptedException
  {
    return (T)get(-1L);
  }
  
  public T get(long paramLong)
    throws InterruptedException
  {
    if (!permitAcquired(paramLong)) {
      return null;
    }
    for (;;)
    {
      try
      {
        assertConditions();
        int i = this._avail.size();
        if (getTotal() < getMaxSize())
        {
          bool = true;
          i = pick(i - 1, bool);
          if (i < 0) {
            break label96;
          }
          Object localObject1 = this._avail.remove(i);
          this._out.add(localObject1);
          return (T)localObject1;
        }
      }
      finally {}
      boolean bool = false;
      continue;
      label96:
      Object localObject3 = createNewAndReleasePermitIfFailure();
    }
  }
  
  public int getAvailable()
  {
    try
    {
      int i = this._avail.size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int getInUse()
  {
    try
    {
      int i = this._out.size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int getMaxSize()
  {
    return this._size;
  }
  
  public String getName()
  {
    return this._name;
  }
  
  public int getTotal()
  {
    try
    {
      int i = this._avail.size();
      int j = this._out.size();
      return i + j;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  protected int pick(int paramInt, boolean paramBoolean)
  {
    return paramInt;
  }
  
  public void remove(T paramT)
  {
    done(paramT);
  }
  
  public String toString()
  {
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("pool: ").append(this._name).append(" maxToKeep: ").append(this._size).append(" avail ").append(this._avail.size()).append(" out ").append(this._out.size());
      localObject1 = ((StringBuilder)localObject1).toString();
      return (String)localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/util/SimplePool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */