package com.flurry.android.monolithic.sdk.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class yv
  extends yh
{
  protected LinkedHashSet<yg> a;
  
  public Collection<yg> a(xh paramxh, rf<?> paramrf, py parampy)
  {
    HashMap localHashMap = new HashMap();
    if (this.a != null)
    {
      Class localClass = paramxh.d();
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        yg localyg = (yg)localIterator.next();
        if (localClass.isAssignableFrom(localyg.a())) {
          a(xh.b(localyg.a(), parampy, paramrf), localyg, paramrf, parampy, localHashMap);
        }
      }
    }
    a(paramxh, new yg(paramxh.d(), null), paramrf, parampy, localHashMap);
    return new ArrayList(localHashMap.values());
  }
  
  public Collection<yg> a(xk paramxk, rf<?> paramrf, py parampy)
  {
    HashMap localHashMap = new HashMap();
    Object localObject2;
    if (this.a != null)
    {
      localObject1 = paramxk.d();
      localObject2 = this.a.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        yg localyg = (yg)((Iterator)localObject2).next();
        if (((Class)localObject1).isAssignableFrom(localyg.a())) {
          a(xh.b(localyg.a(), parampy, paramrf), localyg, paramrf, parampy, localHashMap);
        }
      }
    }
    Object localObject1 = parampy.a(paramxk);
    if (localObject1 != null)
    {
      localObject1 = ((Collection)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (yg)((Iterator)localObject1).next();
        a(xh.b(((yg)localObject2).a(), parampy, paramrf), (yg)localObject2, paramrf, parampy, localHashMap);
      }
    }
    localObject1 = new yg(paramxk.d(), null);
    a(xh.b(paramxk.d(), parampy, paramrf), (yg)localObject1, paramrf, parampy, localHashMap);
    return new ArrayList(localHashMap.values());
  }
  
  protected void a(xh paramxh, yg paramyg, rf<?> paramrf, py parampy, HashMap<yg, yg> paramHashMap)
  {
    Object localObject = paramyg;
    if (!paramyg.c())
    {
      String str = parampy.g(paramxh);
      localObject = paramyg;
      if (str != null) {
        localObject = new yg(paramyg.a(), str);
      }
    }
    if (paramHashMap.containsKey(localObject)) {
      if ((((yg)localObject).c()) && (!((yg)paramHashMap.get(localObject)).c())) {
        paramHashMap.put(localObject, localObject);
      }
    }
    do
    {
      return;
      paramHashMap.put(localObject, localObject);
      paramxh = parampy.a(paramxh);
    } while ((paramxh == null) || (paramxh.isEmpty()));
    paramyg = paramxh.iterator();
    label123:
    if (paramyg.hasNext())
    {
      paramxh = (yg)paramyg.next();
      localObject = xh.b(paramxh.a(), parampy, paramrf);
      if (paramxh.c()) {
        break label195;
      }
      paramxh = new yg(paramxh.a(), parampy.g((xh)localObject));
    }
    label195:
    for (;;)
    {
      a((xh)localObject, paramxh, paramrf, parampy, paramHashMap);
      break label123;
      break;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/yv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */