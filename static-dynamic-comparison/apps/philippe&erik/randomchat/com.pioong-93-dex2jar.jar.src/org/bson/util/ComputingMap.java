package org.bson.util;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

final class ComputingMap<K, V>
  implements Map<K, V>, Function<K, V>
{
  private final Function<K, V> function;
  private final ConcurrentMap<K, V> map;
  
  ComputingMap(ConcurrentMap<K, V> paramConcurrentMap, Function<K, V> paramFunction)
  {
    this.map = ((ConcurrentMap)Assertions.notNull("map", paramConcurrentMap));
    this.function = ((Function)Assertions.notNull("function", paramFunction));
  }
  
  public static <K, V> Map<K, V> create(Function<K, V> paramFunction)
  {
    return new ComputingMap(CopyOnWriteMap.newHashMap(), paramFunction);
  }
  
  public V apply(K paramK)
  {
    return (V)get(paramK);
  }
  
  public void clear()
  {
    this.map.clear();
  }
  
  public boolean containsKey(Object paramObject)
  {
    return this.map.containsKey(paramObject);
  }
  
  public boolean containsValue(Object paramObject)
  {
    return this.map.containsValue(paramObject);
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    return this.map.entrySet();
  }
  
  public boolean equals(Object paramObject)
  {
    return this.map.equals(paramObject);
  }
  
  public V get(Object paramObject)
  {
    for (;;)
    {
      Object localObject = this.map.get(paramObject);
      if (localObject != null) {
        return (V)localObject;
      }
      localObject = this.function.apply(paramObject);
      if (localObject == null) {
        return null;
      }
      this.map.putIfAbsent(paramObject, localObject);
    }
  }
  
  public int hashCode()
  {
    return this.map.hashCode();
  }
  
  public boolean isEmpty()
  {
    return this.map.isEmpty();
  }
  
  public Set<K> keySet()
  {
    return this.map.keySet();
  }
  
  public V put(K paramK, V paramV)
  {
    return (V)this.map.put(paramK, paramV);
  }
  
  public void putAll(Map<? extends K, ? extends V> paramMap)
  {
    this.map.putAll(paramMap);
  }
  
  public V putIfAbsent(K paramK, V paramV)
  {
    return (V)this.map.putIfAbsent(paramK, paramV);
  }
  
  public V remove(Object paramObject)
  {
    return (V)this.map.remove(paramObject);
  }
  
  public boolean remove(Object paramObject1, Object paramObject2)
  {
    return this.map.remove(paramObject1, paramObject2);
  }
  
  public V replace(K paramK, V paramV)
  {
    return (V)this.map.replace(paramK, paramV);
  }
  
  public boolean replace(K paramK, V paramV1, V paramV2)
  {
    return this.map.replace(paramK, paramV1, paramV2);
  }
  
  public int size()
  {
    return this.map.size();
  }
  
  public Collection<V> values()
  {
    return this.map.values();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/org/bson/util/ComputingMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */