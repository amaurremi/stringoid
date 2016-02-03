package com.chartboost.sdk.impl;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

final class bj<K, V>
  implements bl<K, V>, Map<K, V>
{
  private final ConcurrentMap<K, V> a;
  private final bl<K, V> b;
  
  bj(ConcurrentMap<K, V> paramConcurrentMap, bl<K, V> parambl)
  {
    this.a = ((ConcurrentMap)bg.a("map", paramConcurrentMap));
    this.b = ((bl)bg.a("function", parambl));
  }
  
  public static <K, V> Map<K, V> a(bl<K, V> parambl)
  {
    return new bj(bk.c(), parambl);
  }
  
  public V a(K paramK)
  {
    return (V)get(paramK);
  }
  
  public void clear()
  {
    this.a.clear();
  }
  
  public boolean containsKey(Object paramObject)
  {
    return this.a.containsKey(paramObject);
  }
  
  public boolean containsValue(Object paramObject)
  {
    return this.a.containsValue(paramObject);
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    return this.a.entrySet();
  }
  
  public boolean equals(Object paramObject)
  {
    return this.a.equals(paramObject);
  }
  
  public V get(Object paramObject)
  {
    for (;;)
    {
      Object localObject = this.a.get(paramObject);
      if (localObject != null) {
        return (V)localObject;
      }
      localObject = this.b.a(paramObject);
      if (localObject == null) {
        return null;
      }
      this.a.putIfAbsent(paramObject, localObject);
    }
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
  
  public boolean isEmpty()
  {
    return this.a.isEmpty();
  }
  
  public Set<K> keySet()
  {
    return this.a.keySet();
  }
  
  public V put(K paramK, V paramV)
  {
    return (V)this.a.put(paramK, paramV);
  }
  
  public void putAll(Map<? extends K, ? extends V> paramMap)
  {
    this.a.putAll(paramMap);
  }
  
  public V remove(Object paramObject)
  {
    return (V)this.a.remove(paramObject);
  }
  
  public int size()
  {
    return this.a.size();
  }
  
  public Collection<V> values()
  {
    return this.a.values();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/impl/bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */