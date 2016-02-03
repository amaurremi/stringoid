package org.bson.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

class ClassAncestry
{
  private static final ConcurrentMap<Class<?>, List<Class<?>>> _ancestryCache = ;
  
  private static List<Class<?>> computeAncestry(Class<?> paramClass)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Object.class);
    computeAncestry(paramClass, localArrayList);
    Collections.reverse(localArrayList);
    return Collections.unmodifiableList(new ArrayList(localArrayList));
  }
  
  private static <T> void computeAncestry(Class<T> paramClass, List<Class<?>> paramList)
  {
    if ((paramClass == null) || (paramClass == Object.class)) {}
    do
    {
      return;
      Class[] arrayOfClass = paramClass.getInterfaces();
      int i = arrayOfClass.length - 1;
      while (i >= 0)
      {
        computeAncestry(arrayOfClass[i], paramList);
        i -= 1;
      }
      computeAncestry(paramClass.getSuperclass(), paramList);
    } while (paramList.contains(paramClass));
    paramList.add(paramClass);
  }
  
  public static <T> List<Class<?>> getAncestry(Class<T> paramClass)
  {
    ConcurrentMap localConcurrentMap = getClassAncestryCache();
    for (;;)
    {
      List localList = (List)localConcurrentMap.get(paramClass);
      if (localList != null) {
        return localList;
      }
      localConcurrentMap.putIfAbsent(paramClass, computeAncestry(paramClass));
    }
  }
  
  private static ConcurrentMap<Class<?>, List<Class<?>>> getClassAncestryCache()
  {
    return _ancestryCache;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/org/bson/util/ClassAncestry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */