package com.amazonaws.org.apache.http.pool;

import java.util.concurrent.TimeUnit;
import org.apache.http.annotation.GuardedBy;
import org.apache.http.annotation.ThreadSafe;

@ThreadSafe
public abstract class PoolEntry<T, C>
{
  private final C conn;
  private final long created;
  @GuardedBy("this")
  private long expiry;
  private final String id;
  private final T route;
  private volatile Object state;
  @GuardedBy("this")
  private long updated;
  private final long validUnit;
  
  public PoolEntry(String paramString, T paramT, C paramC, long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramT == null) {
      throw new IllegalArgumentException("Route may not be null");
    }
    if (paramC == null) {
      throw new IllegalArgumentException("Connection may not be null");
    }
    if (paramTimeUnit == null) {
      throw new IllegalArgumentException("Time unit may not be null");
    }
    this.id = paramString;
    this.route = paramT;
    this.conn = paramC;
    this.created = System.currentTimeMillis();
    if (paramLong > 0L) {}
    for (this.validUnit = (this.created + paramTimeUnit.toMillis(paramLong));; this.validUnit = Long.MAX_VALUE)
    {
      this.expiry = this.validUnit;
      return;
    }
  }
  
  public abstract void close();
  
  public C getConnection()
  {
    return (C)this.conn;
  }
  
  public long getExpiry()
  {
    try
    {
      long l = this.expiry;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public T getRoute()
  {
    return (T)this.route;
  }
  
  public Object getState()
  {
    return this.state;
  }
  
  public long getUpdated()
  {
    try
    {
      long l = this.updated;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public abstract boolean isClosed();
  
  /* Error */
  public boolean isExpired(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 62	com/amazonaws/org/apache/http/pool/PoolEntry:expiry	J
    //   6: lstore_3
    //   7: lload_1
    //   8: lload_3
    //   9: lcmp
    //   10: iflt +11 -> 21
    //   13: iconst_1
    //   14: istore 5
    //   16: aload_0
    //   17: monitorexit
    //   18: iload 5
    //   20: ireturn
    //   21: iconst_0
    //   22: istore 5
    //   24: goto -8 -> 16
    //   27: astore 6
    //   29: aload_0
    //   30: monitorexit
    //   31: aload 6
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	PoolEntry
    //   0	34	1	paramLong	long
    //   6	3	3	l	long
    //   14	9	5	bool	boolean
    //   27	5	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	27	finally
  }
  
  public void setState(Object paramObject)
  {
    this.state = paramObject;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[id:");
    localStringBuilder.append(this.id);
    localStringBuilder.append("][route:");
    localStringBuilder.append(this.route);
    localStringBuilder.append("][state:");
    localStringBuilder.append(this.state);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void updateExpiry(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramTimeUnit == null) {
      try
      {
        throw new IllegalArgumentException("Time unit may not be null");
      }
      finally {}
    }
    this.updated = System.currentTimeMillis();
    if (paramLong > 0L) {}
    for (paramLong = this.updated + paramTimeUnit.toMillis(paramLong);; paramLong = Long.MAX_VALUE)
    {
      this.expiry = Math.min(paramLong, this.validUnit);
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/pool/PoolEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */