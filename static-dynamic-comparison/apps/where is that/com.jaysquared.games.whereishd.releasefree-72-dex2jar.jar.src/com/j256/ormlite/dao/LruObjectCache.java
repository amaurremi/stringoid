package com.j256.ormlite.dao;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class LruObjectCache
  implements ObjectCache
{
  private final int capacity;
  private final ConcurrentHashMap<Class<?>, Map<Object, Object>> classMaps = new ConcurrentHashMap();
  
  public LruObjectCache(int paramInt)
  {
    this.capacity = paramInt;
  }
  
  private Map<Object, Object> getMapForClass(Class<?> paramClass)
  {
    Map localMap = (Map)this.classMaps.get(paramClass);
    paramClass = localMap;
    if (localMap == null) {
      paramClass = null;
    }
    return paramClass;
  }
  
  public <T> void clear(Class<T> paramClass)
  {
    paramClass = getMapForClass(paramClass);
    if (paramClass != null) {
      paramClass.clear();
    }
  }
  
  public void clearAll()
  {
    Iterator localIterator = this.classMaps.values().iterator();
    while (localIterator.hasNext()) {
      ((Map)localIterator.next()).clear();
    }
  }
  
  public <T, ID> T get(Class<T> paramClass, ID paramID)
  {
    paramClass = getMapForClass(paramClass);
    if (paramClass == null) {
      return null;
    }
    return (T)paramClass.get(paramID);
  }
  
  public <T, ID> void put(Class<T> paramClass, ID paramID, T paramT)
  {
    paramClass = getMapForClass(paramClass);
    if (paramClass != null) {
      paramClass.put(paramID, paramT);
    }
  }
  
  public <T> void registerClass(Class<T> paramClass)
  {
    try
    {
      if ((Map)this.classMaps.get(paramClass) == null)
      {
        Map localMap = Collections.synchronizedMap(new LimitedLinkedHashMap(this.capacity));
        this.classMaps.put(paramClass, localMap);
      }
      return;
    }
    finally
    {
      paramClass = finally;
      throw paramClass;
    }
  }
  
  public <T, ID> void remove(Class<T> paramClass, ID paramID)
  {
    paramClass = getMapForClass(paramClass);
    if (paramClass != null) {
      paramClass.remove(paramID);
    }
  }
  
  public <T> int size(Class<T> paramClass)
  {
    paramClass = getMapForClass(paramClass);
    if (paramClass == null) {
      return 0;
    }
    return paramClass.size();
  }
  
  public int sizeAll()
  {
    int i = 0;
    Iterator localIterator = this.classMaps.values().iterator();
    while (localIterator.hasNext()) {
      i += ((Map)localIterator.next()).size();
    }
    return i;
  }
  
  public <T, ID> T updateId(Class<T> paramClass, ID paramID1, ID paramID2)
  {
    paramClass = getMapForClass(paramClass);
    if (paramClass == null) {}
    do
    {
      return null;
      paramID1 = paramClass.remove(paramID1);
    } while (paramID1 == null);
    paramClass.put(paramID2, paramID1);
    return paramID1;
  }
  
  private static class LimitedLinkedHashMap<K, V>
    extends LinkedHashMap<K, V>
  {
    private static final long serialVersionUID = -4566528080395573236L;
    private final int capacity;
    
    public LimitedLinkedHashMap(int paramInt)
    {
      super(0.75F, true);
      this.capacity = paramInt;
    }
    
    protected boolean removeEldestEntry(Map.Entry<K, V> paramEntry)
    {
      return size() > this.capacity;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/dao/LruObjectCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */