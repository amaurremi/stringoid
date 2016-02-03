package com.amazonaws.org.apache.http.pool;

import com.amazonaws.org.apache.http.concurrent.FutureCallback;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import org.apache.http.annotation.ThreadSafe;

@ThreadSafe
abstract class PoolEntryFuture<T>
  implements Future<T>
{
  private final FutureCallback<T> callback;
  private volatile boolean cancelled;
  private volatile boolean completed;
  private final Condition condition;
  private final Lock lock;
  private T result;
  
  PoolEntryFuture(Lock paramLock, FutureCallback<T> paramFutureCallback)
  {
    this.lock = paramLock;
    this.condition = paramLock.newCondition();
    this.callback = paramFutureCallback;
  }
  
  public boolean await(Date paramDate)
  {
    this.lock.lock();
    try
    {
      if (this.cancelled) {
        throw new InterruptedException("Operation interrupted");
      }
    }
    finally
    {
      this.lock.unlock();
    }
    if (paramDate != null) {}
    for (boolean bool = this.condition.awaitUntil(paramDate); this.cancelled; bool = true)
    {
      throw new InterruptedException("Operation interrupted");
      this.condition.await();
    }
    this.lock.unlock();
    return bool;
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    this.lock.lock();
    try
    {
      paramBoolean = this.completed;
      if (paramBoolean) {
        return false;
      }
      this.completed = true;
      this.cancelled = true;
      if (this.callback != null) {
        this.callback.cancelled();
      }
      this.condition.signalAll();
      return true;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  public T get()
  {
    try
    {
      Object localObject = get(0L, TimeUnit.MILLISECONDS);
      return (T)localObject;
    }
    catch (TimeoutException localTimeoutException)
    {
      throw new ExecutionException(localTimeoutException);
    }
  }
  
  public T get(long paramLong, TimeUnit paramTimeUnit)
  {
    this.lock.lock();
    try
    {
      if (this.completed)
      {
        paramTimeUnit = this.result;
        return paramTimeUnit;
      }
      this.result = getPoolEntry(paramLong, paramTimeUnit);
      this.completed = true;
      if (this.callback != null) {
        this.callback.completed(this.result);
      }
      paramTimeUnit = this.result;
      return paramTimeUnit;
    }
    catch (IOException paramTimeUnit)
    {
      this.completed = true;
      this.result = null;
      if (this.callback != null) {
        this.callback.failed(paramTimeUnit);
      }
      throw new ExecutionException(paramTimeUnit);
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  protected abstract T getPoolEntry(long paramLong, TimeUnit paramTimeUnit);
  
  public boolean isCancelled()
  {
    return this.cancelled;
  }
  
  public boolean isDone()
  {
    return this.completed;
  }
  
  public void wakeup()
  {
    this.lock.lock();
    try
    {
      this.condition.signalAll();
      return;
    }
    finally
    {
      this.lock.unlock();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/pool/PoolEntryFuture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */