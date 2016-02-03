package com.flurry.org.apache.avro.util;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class WeakIdentityHashMap<K, V>
  implements Map<K, V>
{
  private Map<WeakIdentityHashMap<K, V>.IdentityWeakReference, V> backingStore = new HashMap();
  private final ReferenceQueue<K> queue = new ReferenceQueue();
  
  private void reap()
  {
    try
    {
      for (Object localObject1 = this.queue.poll(); localObject1 != null; localObject1 = this.queue.poll())
      {
        localObject1 = (IdentityWeakReference)localObject1;
        this.backingStore.remove(localObject1);
      }
      return;
    }
    finally {}
  }
  
  public void clear()
  {
    this.backingStore.clear();
    reap();
  }
  
  public boolean containsKey(Object paramObject)
  {
    reap();
    return this.backingStore.containsKey(new IdentityWeakReference(paramObject));
  }
  
  public boolean containsValue(Object paramObject)
  {
    reap();
    return this.backingStore.containsValue(paramObject);
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    reap();
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.backingStore.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localHashSet.add(new Map.Entry()
      {
        public K getKey()
        {
          return (K)this.val$key;
        }
        
        public V getValue()
        {
          return (V)this.val$value;
        }
        
        public V setValue(V paramAnonymousV)
        {
          throw new UnsupportedOperationException();
        }
      });
    }
    return Collections.unmodifiableSet(localHashSet);
  }
  
  public boolean equals(Object paramObject)
  {
    return this.backingStore.equals(((WeakIdentityHashMap)paramObject).backingStore);
  }
  
  public V get(Object paramObject)
  {
    reap();
    return (V)this.backingStore.get(new IdentityWeakReference(paramObject));
  }
  
  public int hashCode()
  {
    reap();
    return this.backingStore.hashCode();
  }
  
  public boolean isEmpty()
  {
    reap();
    return this.backingStore.isEmpty();
  }
  
  public Set<K> keySet()
  {
    reap();
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.backingStore.keySet().iterator();
    while (localIterator.hasNext()) {
      localHashSet.add(((IdentityWeakReference)localIterator.next()).get());
    }
    return Collections.unmodifiableSet(localHashSet);
  }
  
  public V put(K paramK, V paramV)
  {
    reap();
    return (V)this.backingStore.put(new IdentityWeakReference(paramK), paramV);
  }
  
  public void putAll(Map paramMap)
  {
    throw new UnsupportedOperationException();
  }
  
  public V remove(Object paramObject)
  {
    reap();
    return (V)this.backingStore.remove(new IdentityWeakReference(paramObject));
  }
  
  public int size()
  {
    reap();
    return this.backingStore.size();
  }
  
  public Collection<V> values()
  {
    reap();
    return this.backingStore.values();
  }
  
  class IdentityWeakReference
    extends WeakReference<K>
  {
    int hash;
    
    IdentityWeakReference(Object paramObject)
    {
      super(WeakIdentityHashMap.this.queue);
      this.hash = System.identityHashCode(paramObject);
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        paramObject = (IdentityWeakReference)paramObject;
      } while (get() == ((IdentityWeakReference)paramObject).get());
      return false;
    }
    
    public int hashCode()
    {
      return this.hash;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/apache/avro/util/WeakIdentityHashMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */