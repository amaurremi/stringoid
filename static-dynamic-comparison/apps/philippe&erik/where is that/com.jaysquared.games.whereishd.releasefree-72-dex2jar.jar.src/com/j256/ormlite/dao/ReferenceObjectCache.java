package com.j256.ormlite.dao;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ReferenceObjectCache
  implements ObjectCache
{
  private final ConcurrentHashMap<Class<?>, Map<Object, Reference<Object>>> classMaps = new ConcurrentHashMap();
  private final boolean useWeak;
  
  public ReferenceObjectCache(boolean paramBoolean)
  {
    this.useWeak = paramBoolean;
  }
  
  private void cleanMap(Map<Object, Reference<Object>> paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext()) {
      if (((Reference)((Map.Entry)paramMap.next()).getValue()).get() == null) {
        paramMap.remove();
      }
    }
  }
  
  private Map<Object, Reference<Object>> getMapForClass(Class<?> paramClass)
  {
    Map localMap = (Map)this.classMaps.get(paramClass);
    paramClass = localMap;
    if (localMap == null) {
      paramClass = null;
    }
    return paramClass;
  }
  
  public static ReferenceObjectCache makeSoftCache()
  {
    return new ReferenceObjectCache(false);
  }
  
  public static ReferenceObjectCache makeWeakCache()
  {
    return new ReferenceObjectCache(true);
  }
  
  public <T> void cleanNullReferences(Class<T> paramClass)
  {
    paramClass = getMapForClass(paramClass);
    if (paramClass != null) {
      cleanMap(paramClass);
    }
  }
  
  public <T> void cleanNullReferencesAll()
  {
    Iterator localIterator = this.classMaps.values().iterator();
    while (localIterator.hasNext()) {
      cleanMap((Map)localIterator.next());
    }
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
    if (paramClass == null) {}
    do
    {
      return null;
      localObject = (Reference)paramClass.get(paramID);
    } while (localObject == null);
    Object localObject = ((Reference)localObject).get();
    if (localObject == null)
    {
      paramClass.remove(paramID);
      return null;
    }
    return (T)localObject;
  }
  
  public <T, ID> void put(Class<T> paramClass, ID paramID, T paramT)
  {
    paramClass = getMapForClass(paramClass);
    if (paramClass != null)
    {
      if (this.useWeak) {
        paramClass.put(paramID, new WeakReference(paramT));
      }
    }
    else {
      return;
    }
    paramClass.put(paramID, new SoftReference(paramT));
  }
  
  public <T> void registerClass(Class<T> paramClass)
  {
    try
    {
      if ((Map)this.classMaps.get(paramClass) == null)
      {
        ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
        this.classMaps.put(paramClass, localConcurrentHashMap);
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
      paramID1 = (Reference)paramClass.remove(paramID1);
    } while (paramID1 == null);
    paramClass.put(paramID2, paramID1);
    return (T)paramID1.get();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/dao/ReferenceObjectCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */