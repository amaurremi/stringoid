package com.flurry.android.monolithic.sdk.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class za
  extends yz
{
  protected final rf<?> a;
  protected final HashMap<String, String> b;
  protected final HashMap<String, afm> e;
  
  protected za(rf<?> paramrf, afm paramafm, HashMap<String, String> paramHashMap, HashMap<String, afm> paramHashMap1)
  {
    super(paramafm, paramrf.m());
    this.a = paramrf;
    this.b = paramHashMap;
    this.e = paramHashMap1;
  }
  
  public static za a(rf<?> paramrf, afm paramafm, Collection<yg> paramCollection, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1 == paramBoolean2) {
      throw new IllegalArgumentException();
    }
    if (paramBoolean1) {}
    for (HashMap localHashMap1 = new HashMap();; localHashMap1 = null)
    {
      if (paramBoolean2) {}
      for (HashMap localHashMap2 = new HashMap();; localHashMap2 = null)
      {
        if (paramCollection != null)
        {
          Iterator localIterator = paramCollection.iterator();
          if (localIterator.hasNext())
          {
            paramCollection = (yg)localIterator.next();
            Class localClass = paramCollection.a();
            if (paramCollection.c()) {}
            for (paramCollection = paramCollection.b();; paramCollection = a(localClass))
            {
              if (paramBoolean1) {
                localHashMap1.put(localClass.getName(), paramCollection);
              }
              if (!paramBoolean2) {
                break;
              }
              afm localafm = (afm)localHashMap2.get(paramCollection);
              if ((localafm != null) && (localClass.isAssignableFrom(localafm.p()))) {
                break;
              }
              localHashMap2.put(paramCollection, paramrf.b(localClass));
              break;
            }
          }
        }
        return new za(paramrf, paramafm, localHashMap1, localHashMap2);
      }
    }
  }
  
  protected static String a(Class<?> paramClass)
  {
    paramClass = paramClass.getName();
    int i = paramClass.lastIndexOf('.');
    if (i < 0) {
      return paramClass;
    }
    return paramClass.substring(i + 1);
  }
  
  public afm a(String paramString)
    throws IllegalArgumentException
  {
    return (afm)this.e.get(paramString);
  }
  
  public String a(Object paramObject)
  {
    Class localClass = paramObject.getClass();
    String str = localClass.getName();
    synchronized (this.b)
    {
      paramObject = (String)this.b.get(str);
      Object localObject = paramObject;
      if (paramObject == null)
      {
        if (this.a.b())
        {
          paramObject = (xq)this.a.c(localClass);
          paramObject = this.a.a().g(((xq)paramObject).c());
        }
        localObject = paramObject;
        if (paramObject == null) {
          localObject = a(localClass);
        }
        this.b.put(str, localObject);
      }
      return (String)localObject;
    }
  }
  
  public String a(Object paramObject, Class<?> paramClass)
  {
    return a(paramObject);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('[').append(getClass().getName());
    localStringBuilder.append("; id-to-type=").append(this.e);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/za.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */