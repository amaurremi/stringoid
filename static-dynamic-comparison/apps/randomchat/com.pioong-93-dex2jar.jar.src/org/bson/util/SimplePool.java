package org.bson.util;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class SimplePool<T>
{
  final int _max;
  private Queue<T> _stored = new ConcurrentLinkedQueue();
  
  public SimplePool()
  {
    this._max = 1000;
  }
  
  public SimplePool(int paramInt)
  {
    this._max = paramInt;
  }
  
  protected abstract T createNew();
  
  public void done(T paramT)
  {
    if (!ok(paramT)) {}
    while (this._stored.size() > this._max) {
      return;
    }
    this._stored.add(paramT);
  }
  
  public T get()
  {
    Object localObject = this._stored.poll();
    if (localObject != null) {
      return (T)localObject;
    }
    return (T)createNew();
  }
  
  protected boolean ok(T paramT)
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/org/bson/util/SimplePool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */