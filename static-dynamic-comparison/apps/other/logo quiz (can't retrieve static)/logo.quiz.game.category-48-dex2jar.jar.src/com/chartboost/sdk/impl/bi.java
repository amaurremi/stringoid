package com.chartboost.sdk.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class bi<T>
{
  private final Map<Class<?>, T> a = bk.c();
  private final Map<Class<?>, T> b = bj.a(new a(null));
  
  public static <T> List<Class<?>> a(Class<T> paramClass)
  {
    return bh.a(paramClass);
  }
  
  public int a()
  {
    return this.a.size();
  }
  
  public T a(Class<?> paramClass, T paramT)
  {
    try
    {
      paramClass = this.a.put(paramClass, paramT);
      return paramClass;
    }
    finally
    {
      this.b.clear();
    }
  }
  
  public T a(Object paramObject)
  {
    return (T)this.b.get(paramObject);
  }
  
  private final class a
    implements bl<Class<?>, T>
  {
    private a() {}
    
    public T a(Class<?> paramClass)
    {
      paramClass = bi.a(paramClass).iterator();
      while (paramClass.hasNext())
      {
        Object localObject = (Class)paramClass.next();
        localObject = bi.a(bi.this).get(localObject);
        if (localObject != null) {
          return (T)localObject;
        }
      }
      return null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/impl/bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */