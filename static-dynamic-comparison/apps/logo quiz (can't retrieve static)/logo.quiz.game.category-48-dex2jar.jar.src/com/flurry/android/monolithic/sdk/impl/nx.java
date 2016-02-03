package com.flurry.android.monolithic.sdk.impl;

import java.lang.ref.ReferenceQueue;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class nx<K, V>
  implements Map<K, V>
{
  private final ReferenceQueue<K> a = new ReferenceQueue();
  private Map<nx<K, V>.nz, V> b = new HashMap();
  
  private void a()
  {
    try
    {
      for (Object localObject1 = this.a.poll(); localObject1 != null; localObject1 = this.a.poll())
      {
        localObject1 = (nz)localObject1;
        this.b.remove(localObject1);
      }
      return;
    }
    finally {}
  }
  
  public void clear()
  {
    this.b.clear();
    a();
  }
  
  public boolean containsKey(Object paramObject)
  {
    a();
    return this.b.containsKey(new nz(this, paramObject));
  }
  
  public boolean containsValue(Object paramObject)
  {
    a();
    return this.b.containsValue(paramObject);
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    a();
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.b.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localHashSet.add(new ny(this, ((nz)localEntry.getKey()).get(), localEntry.getValue()));
    }
    return Collections.unmodifiableSet(localHashSet);
  }
  
  public boolean equals(Object paramObject)
  {
    return this.b.equals(((nx)paramObject).b);
  }
  
  public V get(Object paramObject)
  {
    a();
    return (V)this.b.get(new nz(this, paramObject));
  }
  
  public int hashCode()
  {
    a();
    return this.b.hashCode();
  }
  
  public boolean isEmpty()
  {
    a();
    return this.b.isEmpty();
  }
  
  public Set<K> keySet()
  {
    a();
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.b.keySet().iterator();
    while (localIterator.hasNext()) {
      localHashSet.add(((nz)localIterator.next()).get());
    }
    return Collections.unmodifiableSet(localHashSet);
  }
  
  public V put(K paramK, V paramV)
  {
    a();
    return (V)this.b.put(new nz(this, paramK), paramV);
  }
  
  public void putAll(Map paramMap)
  {
    throw new UnsupportedOperationException();
  }
  
  public V remove(Object paramObject)
  {
    a();
    return (V)this.b.remove(new nz(this, paramObject));
  }
  
  public int size()
  {
    a();
    return this.b.size();
  }
  
  public Collection<V> values()
  {
    a();
    return this.b.values();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/nx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */