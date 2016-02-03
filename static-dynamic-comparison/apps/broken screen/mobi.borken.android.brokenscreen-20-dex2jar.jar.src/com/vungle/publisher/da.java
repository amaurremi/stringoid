package com.vungle.publisher;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

abstract class da<K, V>
{
  private final Map<K, V> a = new LinkedHashMap();
  private final Lock b;
  private final Lock c;
  
  public da()
  {
    ReentrantReadWriteLock localReentrantReadWriteLock = new ReentrantReadWriteLock();
    this.b = localReentrantReadWriteLock.readLock();
    this.c = localReentrantReadWriteLock.writeLock();
  }
  
  protected abstract V a(K paramK);
  
  public final V b(K paramK)
  {
    if (paramK == null) {
      throw new NullPointerException("key == null");
    }
    this.b.lock();
    Object localObject;
    try
    {
      localObject = this.a.get(paramK);
      if (localObject != null)
      {
        this.b.unlock();
        return (V)localObject;
      }
      this.b.unlock();
      localObject = a(paramK);
      if (localObject == null) {
        throw new NullPointerException("create returned null");
      }
    }
    finally
    {
      this.b.unlock();
    }
    this.c.lock();
    try
    {
      this.a.put(paramK, localObject);
      return (V)localObject;
    }
    finally
    {
      this.c.unlock();
    }
  }
  
  public final String toString()
  {
    this.b.lock();
    try
    {
      String str = this.a.toString();
      return str;
    }
    finally
    {
      this.b.unlock();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/da.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */