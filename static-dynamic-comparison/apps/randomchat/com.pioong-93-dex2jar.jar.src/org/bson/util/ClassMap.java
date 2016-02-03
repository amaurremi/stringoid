package org.bson.util;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ClassMap<T>
{
  private final Map<Class<?>, T> cache = ComputingMap.create(new ComputeFunction(null));
  private final Map<Class<?>, T> map = CopyOnWriteMap.newHashMap();
  
  public static <T> List<Class<?>> getAncestry(Class<T> paramClass)
  {
    return ClassAncestry.getAncestry(paramClass);
  }
  
  public void clear()
  {
    this.map.clear();
    this.cache.clear();
  }
  
  public T get(Object paramObject)
  {
    return (T)this.cache.get(paramObject);
  }
  
  public boolean isEmpty()
  {
    return this.map.isEmpty();
  }
  
  public T put(Class<?> paramClass, T paramT)
  {
    try
    {
      paramClass = this.map.put(paramClass, paramT);
      return paramClass;
    }
    finally
    {
      this.cache.clear();
    }
  }
  
  public T remove(Object paramObject)
  {
    try
    {
      paramObject = this.map.remove(paramObject);
      return (T)paramObject;
    }
    finally
    {
      this.cache.clear();
    }
  }
  
  public int size()
  {
    return this.map.size();
  }
  
  private final class ComputeFunction
    implements Function<Class<?>, T>
  {
    private ComputeFunction() {}
    
    public T apply(Class<?> paramClass)
    {
      paramClass = ClassMap.getAncestry(paramClass).iterator();
      while (paramClass.hasNext())
      {
        Object localObject = (Class)paramClass.next();
        localObject = ClassMap.this.map.get(localObject);
        if (localObject != null) {
          return (T)localObject;
        }
      }
      return null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/org/bson/util/ClassMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */