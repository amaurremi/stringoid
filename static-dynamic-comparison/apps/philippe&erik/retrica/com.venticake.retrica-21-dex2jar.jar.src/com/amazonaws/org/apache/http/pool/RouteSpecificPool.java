package com.amazonaws.org.apache.http.pool;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
abstract class RouteSpecificPool<T, C, E extends PoolEntry<T, C>>
{
  private final LinkedList<E> available;
  private final Set<E> leased;
  private final LinkedList<PoolEntryFuture<E>> pending;
  private final T route;
  
  RouteSpecificPool(T paramT)
  {
    this.route = paramT;
    this.leased = new HashSet();
    this.available = new LinkedList();
    this.pending = new LinkedList();
  }
  
  public E add(C paramC)
  {
    paramC = createEntry(paramC);
    this.leased.add(paramC);
    return paramC;
  }
  
  protected abstract E createEntry(C paramC);
  
  public void free(E paramE, boolean paramBoolean)
  {
    if (paramE == null) {
      throw new IllegalArgumentException("Pool entry may not be null");
    }
    if (!this.leased.remove(paramE)) {
      throw new IllegalStateException("Entry " + paramE + " has not been leased from this pool");
    }
    if (paramBoolean) {
      this.available.add(paramE);
    }
  }
  
  public int getAllocatedCount()
  {
    return this.available.size() + this.leased.size();
  }
  
  public int getAvailableCount()
  {
    return this.available.size();
  }
  
  public E getFree(Object paramObject)
  {
    if (!this.available.isEmpty())
    {
      Object localObject;
      if (paramObject != null)
      {
        localObject = this.available.iterator();
        while (((Iterator)localObject).hasNext())
        {
          PoolEntry localPoolEntry = (PoolEntry)((Iterator)localObject).next();
          if (paramObject.equals(localPoolEntry.getState()))
          {
            ((Iterator)localObject).remove();
            this.leased.add(localPoolEntry);
            return localPoolEntry;
          }
        }
      }
      paramObject = this.available.iterator();
      while (((Iterator)paramObject).hasNext())
      {
        localObject = (PoolEntry)((Iterator)paramObject).next();
        if (((PoolEntry)localObject).getState() == null)
        {
          ((Iterator)paramObject).remove();
          this.leased.add(localObject);
          return (E)localObject;
        }
      }
    }
    return null;
  }
  
  public E getLastUsed()
  {
    if (!this.available.isEmpty()) {
      return (PoolEntry)this.available.getFirst();
    }
    return null;
  }
  
  public int getLeasedCount()
  {
    return this.leased.size();
  }
  
  public int getPendingCount()
  {
    return this.pending.size();
  }
  
  public PoolEntryFuture<E> nextPending()
  {
    return (PoolEntryFuture)this.pending.poll();
  }
  
  public void queue(PoolEntryFuture<E> paramPoolEntryFuture)
  {
    if (paramPoolEntryFuture == null) {
      return;
    }
    this.pending.add(paramPoolEntryFuture);
  }
  
  public boolean remove(E paramE)
  {
    if (paramE == null) {
      throw new IllegalArgumentException("Pool entry may not be null");
    }
    return (this.available.remove(paramE)) || (this.leased.remove(paramE));
  }
  
  public void shutdown()
  {
    Iterator localIterator = this.pending.iterator();
    while (localIterator.hasNext()) {
      ((PoolEntryFuture)localIterator.next()).cancel(true);
    }
    this.pending.clear();
    localIterator = this.available.iterator();
    while (localIterator.hasNext()) {
      ((PoolEntry)localIterator.next()).close();
    }
    this.available.clear();
    localIterator = this.leased.iterator();
    while (localIterator.hasNext()) {
      ((PoolEntry)localIterator.next()).close();
    }
    this.leased.clear();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[route: ");
    localStringBuilder.append(this.route);
    localStringBuilder.append("][leased: ");
    localStringBuilder.append(this.leased.size());
    localStringBuilder.append("][available: ");
    localStringBuilder.append(this.available.size());
    localStringBuilder.append("][pending: ");
    localStringBuilder.append(this.pending.size());
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void unqueue(PoolEntryFuture<E> paramPoolEntryFuture)
  {
    if (paramPoolEntryFuture == null) {
      return;
    }
    this.pending.remove(paramPoolEntryFuture);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/pool/RouteSpecificPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */