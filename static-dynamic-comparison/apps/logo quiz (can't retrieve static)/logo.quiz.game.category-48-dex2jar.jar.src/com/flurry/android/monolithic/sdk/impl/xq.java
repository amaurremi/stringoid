package com.flurry.android.monolithic.sdk.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class xq
  extends qb
{
  protected final rf<?> b;
  protected final py c;
  protected final xh d;
  protected adj e;
  protected final List<qe> f;
  protected xl g;
  protected Map<Object, xk> h;
  protected Set<String> i;
  protected Set<String> j;
  protected xl k;
  protected xl l;
  
  protected xq(rf<?> paramrf, afm paramafm, xh paramxh, List<qe> paramList)
  {
    super(paramafm);
    this.b = paramrf;
    if (paramrf == null) {}
    for (paramrf = null;; paramrf = paramrf.a())
    {
      this.c = paramrf;
      this.d = paramxh;
      this.f = paramList;
      return;
    }
  }
  
  public static xq a(rf<?> paramrf, afm paramafm, xh paramxh)
  {
    return new xq(paramrf, paramafm, paramxh, Collections.emptyList());
  }
  
  public static xq a(yb paramyb)
  {
    xq localxq = new xq(paramyb.a(), paramyb.b(), paramyb.c(), paramyb.d());
    localxq.g = paramyb.h();
    localxq.i = paramyb.i();
    localxq.j = paramyb.j();
    localxq.h = paramyb.e();
    return localxq;
  }
  
  public static xq b(yb paramyb)
  {
    xq localxq = new xq(paramyb.a(), paramyb.b(), paramyb.c(), paramyb.d());
    localxq.k = paramyb.f();
    localxq.l = paramyb.g();
    return localxq;
  }
  
  public afm a(Type paramType)
  {
    if (paramType == null) {
      return null;
    }
    return j().a(paramType);
  }
  
  public sf a(sf paramsf)
  {
    if (this.c == null) {
      return paramsf;
    }
    return this.c.a(this.d, paramsf);
  }
  
  public xl a(String paramString, Class<?>[] paramArrayOfClass)
  {
    return this.d.a(paramString, paramArrayOfClass);
  }
  
  public Object a(boolean paramBoolean)
  {
    Object localObject = this.d.h();
    if (localObject == null) {
      return null;
    }
    if (paramBoolean) {
      ((xi)localObject).k();
    }
    for (;;)
    {
      try
      {
        localObject = ((xi)localObject).e().newInstance(new Object[0]);
        return localObject;
      }
      catch (Exception localException)
      {
        continue;
      }
      if (((Throwable)localObject).getCause() == null) {
        continue;
      }
      localObject = ((Throwable)localObject).getCause();
    }
    if ((localObject instanceof Error)) {
      throw ((Error)localObject);
    }
    if ((localObject instanceof RuntimeException)) {
      throw ((RuntimeException)localObject);
    }
    throw new IllegalArgumentException("Failed to instantiate bean of type " + this.d.e().getName() + ": (" + localObject.getClass().getName() + ") " + ((Throwable)localObject).getMessage(), (Throwable)localObject);
  }
  
  public Constructor<?> a(Class<?>... paramVarArgs)
  {
    Iterator localIterator = this.d.i().iterator();
    while (localIterator.hasNext())
    {
      xi localxi = (xi)localIterator.next();
      if (localxi.f() == 1)
      {
        Class localClass = localxi.a(0);
        int n = paramVarArgs.length;
        int m = 0;
        while (m < n)
        {
          if (paramVarArgs[m] == localClass) {
            return localxi.e();
          }
          m += 1;
        }
      }
    }
    return null;
  }
  
  protected boolean a(xl paramxl)
  {
    Class localClass = paramxl.d();
    if (!b().isAssignableFrom(localClass)) {}
    do
    {
      return false;
      if (this.c.k(paramxl)) {
        return true;
      }
    } while (!"valueOf".equals(paramxl.b()));
    return true;
  }
  
  public Method b(Class<?>... paramVarArgs)
  {
    Iterator localIterator = this.d.j().iterator();
    while (localIterator.hasNext())
    {
      xl localxl = (xl)localIterator.next();
      if (a(localxl))
      {
        Class localClass = localxl.a(0);
        int n = paramVarArgs.length;
        int m = 0;
        while (m < n)
        {
          if (localClass.isAssignableFrom(paramVarArgs[m])) {
            return localxl.e();
          }
          m += 1;
        }
      }
    }
    return null;
  }
  
  public xh c()
  {
    return this.d;
  }
  
  public List<qe> d()
  {
    return this.f;
  }
  
  public xl e()
  {
    return this.k;
  }
  
  public Set<String> f()
  {
    if (this.i == null) {
      return Collections.emptySet();
    }
    return this.i;
  }
  
  public Set<String> g()
  {
    return this.j;
  }
  
  public boolean h()
  {
    return this.d.g();
  }
  
  public ado i()
  {
    return this.d.f();
  }
  
  public adj j()
  {
    if (this.e == null) {
      this.e = new adj(this.b.m(), this.a);
    }
    return this.e;
  }
  
  public xi k()
  {
    return this.d.h();
  }
  
  public xl l()
    throws IllegalArgumentException
  {
    if (this.g != null)
    {
      Class localClass = this.g.a(0);
      if ((localClass != String.class) && (localClass != Object.class)) {
        throw new IllegalArgumentException("Invalid 'any-setter' annotation on method " + this.g.b() + "(): first argument not of type String or Object, but " + localClass.getName());
      }
    }
    return this.g;
  }
  
  public Map<Object, xk> m()
  {
    return this.h;
  }
  
  public List<xi> n()
  {
    return this.d.i();
  }
  
  public List<xl> o()
  {
    Object localObject = this.d.j();
    if (((List)localObject).isEmpty()) {
      return (List<xl>)localObject;
    }
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      xl localxl = (xl)((Iterator)localObject).next();
      if (a(localxl)) {
        localArrayList.add(localxl);
      }
    }
    return localArrayList;
  }
  
  public xl p()
    throws IllegalArgumentException
  {
    if ((this.l != null) && (!Map.class.isAssignableFrom(this.l.d()))) {
      throw new IllegalArgumentException("Invalid 'any-getter' annotation on method " + this.l.b() + "(): return type is not instance of java.util.Map");
    }
    return this.l;
  }
  
  public Map<String, xk> q()
  {
    HashMap localHashMap = null;
    Iterator localIterator = this.f.iterator();
    for (;;)
    {
      xk localxk;
      Object localObject;
      if (localIterator.hasNext())
      {
        localxk = ((qe)localIterator.next()).k();
        if (localxk == null) {
          continue;
        }
        localObject = this.c.a(localxk);
        if ((localObject == null) || (!((pz)localObject).c())) {
          continue;
        }
        if (localHashMap != null) {
          break label127;
        }
        localHashMap = new HashMap();
      }
      label127:
      for (;;)
      {
        localObject = ((pz)localObject).a();
        if (localHashMap.put(localObject, localxk) == null) {
          break;
        }
        throw new IllegalArgumentException("Multiple back-reference properties with name '" + (String)localObject + "'");
        return localHashMap;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/xq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */