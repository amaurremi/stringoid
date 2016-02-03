package org.apache.commons.logging.impl;

import java.lang.ref.ReferenceQueue;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class WeakHashtable
  extends Hashtable
{
  private static final int MAX_CHANGES_BEFORE_PURGE = 100;
  private static final int PARTIAL_PURGE_COUNT = 10;
  private int changeCount = 0;
  private ReferenceQueue queue = new ReferenceQueue();
  
  private void purge()
  {
    synchronized (this.queue)
    {
      WeakHashtable.WeakKey localWeakKey = (WeakHashtable.WeakKey)this.queue.poll();
      if (localWeakKey != null) {
        super.remove(WeakHashtable.WeakKey.access$400(localWeakKey));
      }
    }
  }
  
  private void purgeOne()
  {
    synchronized (this.queue)
    {
      WeakHashtable.WeakKey localWeakKey = (WeakHashtable.WeakKey)this.queue.poll();
      if (localWeakKey != null) {
        super.remove(WeakHashtable.WeakKey.access$400(localWeakKey));
      }
      return;
    }
  }
  
  public boolean containsKey(Object paramObject)
  {
    return super.containsKey(new WeakHashtable.Referenced(paramObject, null));
  }
  
  public Enumeration elements()
  {
    purge();
    return super.elements();
  }
  
  public Set entrySet()
  {
    purge();
    Object localObject1 = super.entrySet();
    HashSet localHashSet = new HashSet();
    localObject1 = ((Set)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject3 = (Map.Entry)((Iterator)localObject1).next();
      Object localObject2 = WeakHashtable.Referenced.access$100((WeakHashtable.Referenced)((Map.Entry)localObject3).getKey());
      localObject3 = ((Map.Entry)localObject3).getValue();
      if (localObject2 != null) {
        localHashSet.add(new WeakHashtable.Entry(localObject2, localObject3, null));
      }
    }
    return localHashSet;
  }
  
  public Object get(Object paramObject)
  {
    return super.get(new WeakHashtable.Referenced(paramObject, null));
  }
  
  public boolean isEmpty()
  {
    purge();
    return super.isEmpty();
  }
  
  public Set keySet()
  {
    purge();
    Object localObject1 = super.keySet();
    HashSet localHashSet = new HashSet();
    localObject1 = ((Set)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = WeakHashtable.Referenced.access$100((WeakHashtable.Referenced)((Iterator)localObject1).next());
      if (localObject2 != null) {
        localHashSet.add(localObject2);
      }
    }
    return localHashSet;
  }
  
  public Enumeration keys()
  {
    purge();
    return new WeakHashtable.1(this, super.keys());
  }
  
  public Object put(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      throw new NullPointerException("Null keys are not allowed");
    }
    if (paramObject2 == null) {
      throw new NullPointerException("Null values are not allowed");
    }
    int i = this.changeCount;
    this.changeCount = (i + 1);
    if (i > 100)
    {
      purge();
      this.changeCount = 0;
    }
    for (;;)
    {
      return super.put(new WeakHashtable.Referenced(paramObject1, this.queue, null), paramObject2);
      if (this.changeCount % 10 == 0) {
        purgeOne();
      }
    }
  }
  
  public void putAll(Map paramMap)
  {
    if (paramMap != null)
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        put(localEntry.getKey(), localEntry.getValue());
      }
    }
  }
  
  protected void rehash()
  {
    purge();
    super.rehash();
  }
  
  public Object remove(Object paramObject)
  {
    int i = this.changeCount;
    this.changeCount = (i + 1);
    if (i > 100)
    {
      purge();
      this.changeCount = 0;
    }
    for (;;)
    {
      return super.remove(new WeakHashtable.Referenced(paramObject, null));
      if (this.changeCount % 10 == 0) {
        purgeOne();
      }
    }
  }
  
  public int size()
  {
    purge();
    return super.size();
  }
  
  public String toString()
  {
    purge();
    return super.toString();
  }
  
  public Collection values()
  {
    purge();
    return super.values();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/apache/commons/logging/impl/WeakHashtable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */