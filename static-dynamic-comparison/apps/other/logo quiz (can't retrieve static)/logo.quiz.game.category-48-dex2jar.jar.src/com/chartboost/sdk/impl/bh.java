package com.chartboost.sdk.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

class bh
{
  private static final ConcurrentMap<Class<?>, List<Class<?>>> a = ;
  
  public static <T> List<Class<?>> a(Class<T> paramClass)
  {
    ConcurrentMap localConcurrentMap = a();
    for (;;)
    {
      List localList = (List)localConcurrentMap.get(paramClass);
      if (localList != null) {
        return localList;
      }
      localConcurrentMap.putIfAbsent(paramClass, b(paramClass));
    }
  }
  
  private static ConcurrentMap<Class<?>, List<Class<?>>> a()
  {
    return a;
  }
  
  private static <T> void a(Class<T> paramClass, List<Class<?>> paramList)
  {
    if ((paramClass == null) || (paramClass == Object.class)) {}
    do
    {
      return;
      Class[] arrayOfClass = paramClass.getInterfaces();
      int i = arrayOfClass.length - 1;
      while (i >= 0)
      {
        a(arrayOfClass[i], paramList);
        i -= 1;
      }
      a(paramClass.getSuperclass(), paramList);
    } while (paramList.contains(paramClass));
    paramList.add(paramClass);
  }
  
  private static List<Class<?>> b(Class<?> paramClass)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Object.class);
    a(paramClass, localArrayList);
    Collections.reverse(localArrayList);
    return Collections.unmodifiableList(new ArrayList(localArrayList));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/impl/bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */