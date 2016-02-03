package com.flurry.android.monolithic.sdk.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ss
  extends so
{
  public static final ss h = new ss(null);
  private static final Class<?>[] j = { Throwable.class };
  protected final qp i;
  
  @Deprecated
  public ss()
  {
    this(null);
  }
  
  public ss(qp paramqp)
  {
    Object localObject = paramqp;
    if (paramqp == null) {
      localObject = new st();
    }
    this.i = ((qp)localObject);
  }
  
  private rc c(qk paramqk, afm paramafm, qc paramqc)
    throws qw
  {
    Object localObject = (xq)paramqk.b(paramafm);
    paramafm = paramafm.p();
    paramqc = a(paramafm, paramqk);
    localObject = ((xq)localObject).o().iterator();
    while (((Iterator)localObject).hasNext())
    {
      xl localxl = (xl)((Iterator)localObject).next();
      if (paramqk.a().k(localxl))
      {
        if ((localxl.f() == 1) && (localxl.d().isAssignableFrom(paramafm)))
        {
          if (localxl.b(0) != String.class) {
            throw new IllegalArgumentException("Parameter #0 type for factory method (" + localxl + ") not suitable, must be java.lang.String");
          }
          if (paramqk.c()) {
            adz.a(localxl.i());
          }
          return wu.a(paramqc, localxl);
        }
        throw new IllegalArgumentException("Unsuitable method (" + localxl + ") decorated with @JsonCreator (for Enum type " + paramafm.getName() + ")");
      }
    }
    return wu.a(paramqc);
  }
  
  public afm a(qk paramqk, afm paramafm)
    throws qw
  {
    for (;;)
    {
      afm localafm = b(paramqk, paramafm);
      if (localafm == null) {
        return paramafm;
      }
      Class localClass1 = paramafm.p();
      Class localClass2 = localafm.p();
      if ((localClass1 == localClass2) || (!localClass1.isAssignableFrom(localClass2))) {
        throw new IllegalArgumentException("Invalid abstract type resolution from " + paramafm + " to " + localafm + ": latter is not a subtype of former");
      }
      paramafm = localafm;
    }
  }
  
  protected qu<?> a(ada paramada, qk paramqk, qq paramqq, qc paramqc, rw paramrw, qu<?> paramqu)
    throws qw
  {
    Iterator localIterator = this.i.a().iterator();
    while (localIterator.hasNext())
    {
      qu localqu = ((qr)localIterator.next()).a(paramada, paramqk, paramqq, paramqc, paramrw, paramqu);
      if (localqu != null) {
        return localqu;
      }
    }
    return null;
  }
  
  protected qu<?> a(adc paramadc, qk paramqk, qq paramqq, xq paramxq, qc paramqc, rw paramrw, qu<?> paramqu)
    throws qw
  {
    Iterator localIterator = this.i.a().iterator();
    while (localIterator.hasNext())
    {
      qu localqu = ((qr)localIterator.next()).a(paramadc, paramqk, paramqq, paramxq, paramqc, paramrw, paramqu);
      if (localqu != null) {
        return localqu;
      }
    }
    return null;
  }
  
  protected qu<?> a(add paramadd, qk paramqk, qq paramqq, xq paramxq, qc paramqc, rw paramrw, qu<?> paramqu)
    throws qw
  {
    Iterator localIterator = this.i.a().iterator();
    while (localIterator.hasNext())
    {
      qu localqu = ((qr)localIterator.next()).a(paramadd, paramqk, paramqq, paramxq, paramqc, paramrw, paramqu);
      if (localqu != null) {
        return localqu;
      }
    }
    return null;
  }
  
  protected qu<?> a(adf paramadf, qk paramqk, qq paramqq, xq paramxq, qc paramqc, rc paramrc, rw paramrw, qu<?> paramqu)
    throws qw
  {
    Iterator localIterator = this.i.a().iterator();
    while (localIterator.hasNext())
    {
      qu localqu = ((qr)localIterator.next()).a(paramadf, paramqk, paramqq, paramxq, paramqc, paramrc, paramrw, paramqu);
      if (localqu != null) {
        return localqu;
      }
    }
    return null;
  }
  
  protected qu<?> a(adg paramadg, qk paramqk, qq paramqq, xq paramxq, qc paramqc, rc paramrc, rw paramrw, qu<?> paramqu)
    throws qw
  {
    Iterator localIterator = this.i.a().iterator();
    while (localIterator.hasNext())
    {
      qu localqu = ((qr)localIterator.next()).a(paramadg, paramqk, paramqq, paramxq, paramqc, paramrc, paramrw, paramqu);
      if (localqu != null) {
        return localqu;
      }
    }
    return null;
  }
  
  protected qu<Object> a(afm paramafm, qk paramqk, qq paramqq, xq paramxq, qc paramqc)
    throws qw
  {
    Iterator localIterator = this.i.a().iterator();
    while (localIterator.hasNext())
    {
      qu localqu = ((qr)localIterator.next()).a(paramafm, paramqk, paramqq, paramxq, paramqc);
      if (localqu != null) {
        return localqu;
      }
    }
    return null;
  }
  
  public qu<Object> a(qk paramqk, afm paramafm, xq paramxq, qc paramqc)
    throws qw
  {
    Object localObject = a(paramqk, paramxq);
    if ((paramafm.c()) && (!((th)localObject).b()))
    {
      paramqc = new sm(paramafm);
      return paramqc;
    }
    paramafm = a(paramxq);
    paramafm.a((th)localObject);
    a(paramqk, paramxq, paramafm);
    b(paramqk, paramxq, paramafm);
    c(paramqk, paramxq, paramafm);
    if (this.i.g())
    {
      Iterator localIterator = this.i.c().iterator();
      for (;;)
      {
        localObject = paramafm;
        if (!localIterator.hasNext()) {
          break;
        }
        paramafm = ((su)localIterator.next()).a(paramqk, paramxq, paramafm);
      }
    }
    localObject = paramafm;
    paramafm = ((sr)localObject).a(paramqc);
    if (this.i.g())
    {
      localObject = this.i.c().iterator();
      for (;;)
      {
        paramqc = paramafm;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        paramafm = ((su)((Iterator)localObject).next()).a(paramqk, paramxq, paramafm);
      }
    }
    return paramafm;
  }
  
  public qu<Object> a(qk paramqk, qq paramqq, afm paramafm, qc paramqc)
    throws qw
  {
    afm localafm = paramafm;
    if (paramafm.c()) {
      localafm = a(paramqk, paramafm);
    }
    xq localxq = (xq)paramqk.b(localafm);
    paramafm = a(paramqk, localxq.c(), paramqc);
    if (paramafm != null) {
      return paramafm;
    }
    paramafm = a(paramqk, localxq.c(), localafm, null);
    if (paramafm.p() != localafm.p())
    {
      localxq = (xq)paramqk.b(paramafm);
      localafm = paramafm;
    }
    for (;;)
    {
      qu localqu = a(localafm, paramqk, paramqq, localxq, paramqc);
      paramafm = localqu;
      if (localqu != null) {
        break;
      }
      if (localafm.q()) {
        return b(paramqk, localafm, localxq, paramqc);
      }
      if (localafm.c())
      {
        paramafm = b(paramqk, localxq);
        if (paramafm != null) {
          return a(paramqk, paramafm, (xq)paramqk.b(paramafm), paramqc);
        }
      }
      paramqq = d(paramqk, paramqq, localafm, paramqc);
      paramafm = paramqq;
      if (paramqq != null) {
        break;
      }
      if (!a(localafm.p())) {
        return null;
      }
      return a(paramqk, localafm, localxq, paramqc);
    }
  }
  
  protected qu<?> a(Class<? extends ou> paramClass, qk paramqk, qc paramqc)
    throws qw
  {
    Iterator localIterator = this.i.a().iterator();
    while (localIterator.hasNext())
    {
      qu localqu = ((qr)localIterator.next()).a(paramClass, paramqk, paramqc);
      if (localqu != null) {
        return localqu;
      }
    }
    return null;
  }
  
  protected qu<?> a(Class<?> paramClass, qk paramqk, xq paramxq, qc paramqc)
    throws qw
  {
    Iterator localIterator = this.i.a().iterator();
    while (localIterator.hasNext())
    {
      qu localqu = ((qr)localIterator.next()).a(paramClass, paramqk, paramxq, paramqc);
      if (localqu != null) {
        return localqu;
      }
    }
    return null;
  }
  
  public rc a(qk paramqk, afm paramafm, qc paramqc)
    throws qw
  {
    Object localObject2;
    Object localObject1;
    if (this.i.f())
    {
      localObject2 = (xq)paramqk.c(paramafm.p());
      Iterator localIterator = this.i.b().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = ((re)localIterator.next()).a(paramafm, paramqk, (qb)localObject2, paramqc);
      } while (localObject1 == null);
    }
    do
    {
      return (rc)localObject1;
      localObject1 = paramafm.p();
      if ((localObject1 == String.class) || (localObject1 == Object.class)) {
        return wu.a(paramqk, paramafm);
      }
      localObject2 = (rc)c.get(paramafm);
      localObject1 = localObject2;
    } while (localObject2 != null);
    if (paramafm.r()) {
      return c(paramqk, paramafm, paramqc);
    }
    return wu.b(paramqk, paramafm);
  }
  
  protected sr a(xq paramxq)
  {
    return new sr(paramxq);
  }
  
  protected sv a(qk paramqk, xq paramxq, xl paramxl)
    throws qw
  {
    if (paramqk.a(ql.f)) {
      paramxl.k();
    }
    Object localObject = paramxq.j().a(paramxl.b(1));
    qd localqd = new qd(paramxl.b(), (afm)localObject, paramxq.i(), paramxl);
    paramxq = a(paramqk, paramxq, (afm)localObject, paramxl, localqd);
    localObject = a(paramqk, paramxl, localqd);
    if (localObject != null) {
      return new sv(localqd, paramxl, paramxq, (qu)localObject);
    }
    return new sv(localqd, paramxl, a(paramqk, paramxl, paramxq, localqd.c()), null);
  }
  
  protected sw a(qk paramqk, xq paramxq, String paramString, xj paramxj)
    throws qw
  {
    if (paramqk.a(ql.f)) {
      paramxj.k();
    }
    afm localafm2 = paramxq.j().a(paramxj.c());
    Object localObject2 = new qd(paramString, localafm2, paramxq.i(), paramxj);
    afm localafm1 = a(paramqk, paramxq, localafm2, paramxj, (qc)localObject2);
    Object localObject1 = localObject2;
    if (localafm1 != localafm2) {
      localObject1 = ((qd)localObject2).a(localafm1);
    }
    localObject1 = a(paramqk, paramxj, (qc)localObject1);
    localObject2 = a(paramqk, paramxj, localafm1, paramString);
    paramString = new sx(paramString, (afm)localObject2, (rw)((afm)localObject2).o(), paramxq.i(), paramxj);
    paramxq = paramString;
    if (localObject1 != null) {
      paramxq = paramString.a((qu)localObject1);
    }
    paramqk = paramqk.a().a(paramxj);
    if ((paramqk != null) && (paramqk.b())) {
      paramxq.a(paramqk.a());
    }
    return paramxq;
  }
  
  protected sw a(qk paramqk, xq paramxq, String paramString, xl paramxl)
    throws qw
  {
    if (paramqk.a(ql.f)) {
      paramxl.k();
    }
    afm localafm2 = paramxq.j().a(paramxl.b(0));
    Object localObject2 = new qd(paramString, localafm2, paramxq.i(), paramxl);
    afm localafm1 = a(paramqk, paramxq, localafm2, paramxl, (qc)localObject2);
    Object localObject1 = localObject2;
    if (localafm1 != localafm2) {
      localObject1 = ((qd)localObject2).a(localafm1);
    }
    localObject1 = a(paramqk, paramxl, (qc)localObject1);
    localObject2 = a(paramqk, paramxl, localafm1, paramString);
    paramString = new ta(paramString, (afm)localObject2, (rw)((afm)localObject2).o(), paramxq.i(), paramxl);
    paramxq = paramString;
    if (localObject1 != null) {
      paramxq = paramString.a((qu)localObject1);
    }
    paramqk = paramqk.a().a(paramxl);
    if ((paramqk != null) && (paramqk.b())) {
      paramxq.a(paramqk.a());
    }
    return paramxq;
  }
  
  public th a(qk paramqk, xq paramxq)
    throws qw
  {
    Object localObject1 = paramxq.c();
    Object localObject2 = paramqk.a().j((xh)localObject1);
    if (localObject2 != null) {
      if ((localObject2 instanceof th)) {
        localObject1 = (th)localObject2;
      }
    }
    while (this.i.i())
    {
      Iterator localIterator = this.i.e().iterator();
      ti localti;
      do
      {
        localObject2 = localObject1;
        if (!localIterator.hasNext()) {
          break;
        }
        localti = (ti)localIterator.next();
        localObject2 = localti.a(paramqk, paramxq, (th)localObject1);
        localObject1 = localObject2;
      } while (localObject2 != null);
      throw new qw("Broken registered ValueInstantiators (of type " + localti.getClass().getName() + "): returned null ValueInstantiator");
      if (!(localObject2 instanceof Class)) {
        throw new IllegalStateException("Invalid value instantiator returned for type " + paramxq + ": neither a Class nor ValueInstantiator");
      }
      localObject2 = (Class)localObject2;
      if (!th.class.isAssignableFrom((Class)localObject2)) {
        throw new IllegalStateException("Invalid instantiator Class<?> returned for type " + paramxq + ": " + ((Class)localObject2).getName() + " not a ValueInstantiator");
      }
      localObject1 = paramqk.c((xg)localObject1, (Class)localObject2);
      continue;
      localObject1 = c(paramqk, paramxq);
    }
    localObject2 = localObject1;
    return (th)localObject2;
  }
  
  protected tn a(qk paramqk, xq paramxq, String paramString, int paramInt, xn paramxn, Object paramObject)
    throws qw
  {
    Object localObject3 = paramqk.m().a(paramxn.e(), paramxq.j());
    Object localObject2 = new qd(paramString, (afm)localObject3, paramxq.i(), paramxn);
    afm localafm = a(paramqk, paramxq, (afm)localObject3, paramxn, (qc)localObject2);
    Object localObject1 = localObject2;
    if (localafm != localObject3) {
      localObject1 = ((qd)localObject2).a(localafm);
    }
    localObject3 = a(paramqk, paramxn, (qc)localObject1);
    localafm = a(paramqk, paramxn, localafm, paramString);
    localObject2 = (rw)localafm.o();
    if (localObject2 == null) {}
    for (paramqk = b(paramqk, localafm, (qc)localObject1);; paramqk = (qk)localObject2)
    {
      paramxq = new tn(paramString, localafm, paramqk, paramxq.i(), paramxn, paramInt, paramObject);
      paramqk = paramxq;
      if (localObject3 != null) {
        paramqk = paramxq.b((qu)localObject3);
      }
      return paramqk;
    }
  }
  
  protected void a(qk paramqk, xq paramxq, sr paramsr)
    throws qw
  {
    Object localObject3 = paramxq.d();
    Object localObject1 = paramqk.a();
    Object localObject2 = ((py)localObject1).d(paramxq.c());
    if (localObject2 != null) {
      paramsr.a(((Boolean)localObject2).booleanValue());
    }
    localObject2 = adp.a(((py)localObject1).c(paramxq.c()));
    localObject1 = ((Set)localObject2).iterator();
    while (((Iterator)localObject1).hasNext()) {
      paramsr.a((String)((Iterator)localObject1).next());
    }
    Object localObject4 = paramxq.l();
    if (localObject4 == null) {}
    for (localObject1 = paramxq.f(); localObject1 != null; localObject1 = paramxq.g())
    {
      localObject1 = ((Collection)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        paramsr.a((String)((Iterator)localObject1).next());
      }
    }
    localObject1 = new HashMap();
    Object localObject5 = ((List)localObject3).iterator();
    while (((Iterator)localObject5).hasNext())
    {
      Object localObject7 = (qe)((Iterator)localObject5).next();
      Object localObject6 = ((qe)localObject7).a();
      if (!((Set)localObject2).contains(localObject6)) {
        if (((qe)localObject7).e())
        {
          paramsr.a((qe)localObject7);
        }
        else if (((qe)localObject7).c())
        {
          localObject7 = ((qe)localObject7).h();
          if (a(paramqk, paramxq, ((xl)localObject7).a(0), (Map)localObject1))
          {
            paramsr.a((String)localObject6);
          }
          else
          {
            localObject6 = a(paramqk, paramxq, (String)localObject6, (xl)localObject7);
            if (localObject6 != null) {
              paramsr.a((sw)localObject6);
            }
          }
        }
        else if (((qe)localObject7).d())
        {
          localObject7 = ((qe)localObject7).i();
          if (a(paramqk, paramxq, ((xj)localObject7).d(), (Map)localObject1))
          {
            paramsr.a((String)localObject6);
          }
          else
          {
            localObject6 = a(paramqk, paramxq, (String)localObject6, (xj)localObject7);
            if (localObject6 != null) {
              paramsr.a((sw)localObject6);
            }
          }
        }
      }
    }
    if (localObject4 != null) {
      paramsr.a(a(paramqk, paramxq, (xl)localObject4));
    }
    if (paramqk.a(ql.e))
    {
      localObject1 = ((List)localObject3).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject4 = (qe)((Iterator)localObject1).next();
        if (((qe)localObject4).b())
        {
          localObject3 = ((qe)localObject4).a();
          if ((!paramsr.b((String)localObject3)) && (!((Set)localObject2).contains(localObject3)))
          {
            localObject4 = ((qe)localObject4).g();
            localObject5 = ((xl)localObject4).d();
            if (((Collection.class.isAssignableFrom((Class)localObject5)) || (Map.class.isAssignableFrom((Class)localObject5))) && (!((Set)localObject2).contains(localObject3)) && (!paramsr.b((String)localObject3))) {
              paramsr.a(b(paramqk, paramxq, (String)localObject3, (xl)localObject4));
            }
          }
        }
      }
    }
  }
  
  protected void a(qk paramqk, xq paramxq, ye<?> paramye, py parampy, tm paramtm)
    throws qw
  {
    Iterator localIterator = paramxq.n().iterator();
    while (localIterator.hasNext())
    {
      xi localxi = (xi)localIterator.next();
      int i3 = localxi.f();
      if (i3 >= 1)
      {
        boolean bool1 = parampy.k(localxi);
        boolean bool2 = paramye.a(localxi);
        if (i3 == 1)
        {
          a(paramqk, paramxq, paramye, parampy, paramtm, localxi, bool1, bool2);
        }
        else if ((bool1) || (bool2))
        {
          Object localObject1 = null;
          int m = 0;
          int n = 0;
          tn[] arrayOftn = new tn[i3];
          int k = 0;
          if (k < i3)
          {
            xn localxn = localxi.c(k);
            Object localObject2;
            label145:
            Object localObject3;
            int i2;
            int i1;
            if (localxn == null)
            {
              localObject2 = null;
              localObject3 = parampy.d(localxn);
              if ((localObject2 == null) || (((String)localObject2).length() <= 0)) {
                break label233;
              }
              i2 = m + 1;
              arrayOftn[k] = a(paramqk, paramxq, (String)localObject2, k, localxn, localObject3);
              localObject2 = localObject1;
              i1 = n;
            }
            for (;;)
            {
              k += 1;
              localObject1 = localObject2;
              n = i1;
              m = i2;
              break;
              localObject2 = parampy.a(localxn);
              break label145;
              label233:
              if (localObject3 != null)
              {
                i1 = n + 1;
                arrayOftn[k] = a(paramqk, paramxq, (String)localObject2, k, localxn, localObject3);
                i2 = m;
                localObject2 = localObject1;
              }
              else
              {
                i1 = n;
                i2 = m;
                localObject2 = localxn;
                if (localObject1 != null)
                {
                  i1 = n;
                  i2 = m;
                  localObject2 = localObject1;
                }
              }
            }
          }
          if ((bool1) || (m > 0) || (n > 0)) {
            if (m + n == i3)
            {
              paramtm.a(localxi, arrayOftn);
            }
            else
            {
              if ((m == 0) && (n + 1 == i3)) {
                throw new IllegalArgumentException("Delegated constructor with Injectables not yet supported (see [JACKSON-712]) for " + localxi);
              }
              throw new IllegalArgumentException("Argument #" + ((xn)localObject1).g() + " of constructor " + localxi + " has no property name annotation; must have name when multiple-paramater constructor annotated as Creator");
            }
          }
        }
      }
    }
  }
  
  protected boolean a(qk paramqk, xq paramxq, ye<?> paramye, py parampy, tm paramtm, xi paramxi, boolean paramBoolean1, boolean paramBoolean2)
    throws qw
  {
    paramye = paramxi.c(0);
    String str = parampy.a(paramye);
    parampy = parampy.d(paramye);
    if ((parampy != null) || ((str != null) && (str.length() > 0)))
    {
      paramtm.a(paramxi, new tn[] { a(paramqk, paramxq, str, 0, paramye, parampy) });
      return true;
    }
    paramqk = paramxi.a(0);
    if (paramqk == String.class)
    {
      if ((paramBoolean1) || (paramBoolean2)) {
        paramtm.a(paramxi);
      }
      return true;
    }
    if ((paramqk == Integer.TYPE) || (paramqk == Integer.class))
    {
      if ((paramBoolean1) || (paramBoolean2)) {
        paramtm.b(paramxi);
      }
      return true;
    }
    if ((paramqk == Long.TYPE) || (paramqk == Long.class))
    {
      if ((paramBoolean1) || (paramBoolean2)) {
        paramtm.c(paramxi);
      }
      return true;
    }
    if ((paramqk == Double.TYPE) || (paramqk == Double.class))
    {
      if ((paramBoolean1) || (paramBoolean2)) {
        paramtm.d(paramxi);
      }
      return true;
    }
    if (paramBoolean1)
    {
      paramtm.f(paramxi);
      return true;
    }
    return false;
  }
  
  protected boolean a(qk paramqk, xq paramxq, ye<?> paramye, py parampy, tm paramtm, xl paramxl, boolean paramBoolean)
    throws qw
  {
    paramqk = paramxl.a(0);
    if (paramqk == String.class) {
      if ((paramBoolean) || (paramye.a(paramxl))) {
        paramtm.a(paramxl);
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return true;
            if ((paramqk != Integer.TYPE) && (paramqk != Integer.class)) {
              break;
            }
          } while ((!paramBoolean) && (!paramye.a(paramxl)));
          paramtm.b(paramxl);
          return true;
          if ((paramqk != Long.TYPE) && (paramqk != Long.class)) {
            break;
          }
        } while ((!paramBoolean) && (!paramye.a(paramxl)));
        paramtm.c(paramxl);
        return true;
        if ((paramqk != Double.TYPE) && (paramqk != Double.class)) {
          break;
        }
      } while ((!paramBoolean) && (!paramye.a(paramxl)));
      paramtm.d(paramxl);
      return true;
      if ((paramqk != Boolean.TYPE) && (paramqk != Boolean.class)) {
        break;
      }
    } while ((!paramBoolean) && (!paramye.a(paramxl)));
    paramtm.e(paramxl);
    return true;
    if (parampy.k(paramxl))
    {
      paramtm.f(paramxl);
      return true;
    }
    return false;
  }
  
  protected boolean a(qk paramqk, xq paramxq, Class<?> paramClass, Map<Class<?>, Boolean> paramMap)
  {
    paramMap = (Boolean)paramMap.get(paramClass);
    paramxq = paramMap;
    if (paramMap == null)
    {
      paramxq = (xq)paramqk.c(paramClass);
      paramqk = paramqk.a().e(paramxq.c());
      paramxq = paramqk;
      if (paramqk == null) {
        paramxq = Boolean.FALSE;
      }
    }
    return paramxq.booleanValue();
  }
  
  protected boolean a(Class<?> paramClass)
  {
    String str = adz.a(paramClass);
    if (str != null) {
      throw new IllegalArgumentException("Can not deserialize Class " + paramClass.getName() + " (of type " + str + ") as a Bean");
    }
    if (adz.c(paramClass)) {
      throw new IllegalArgumentException("Can not deserialize Proxy class " + paramClass.getName() + " as a Bean");
    }
    str = adz.a(paramClass, true);
    if (str != null) {
      throw new IllegalArgumentException("Can not deserialize Class " + paramClass.getName() + " (of type " + str + ") as a Bean");
    }
    return true;
  }
  
  protected afm b(qk paramqk, afm paramafm)
    throws qw
  {
    Class localClass = paramafm.p();
    if (this.i.h())
    {
      Iterator localIterator = this.i.d().iterator();
      while (localIterator.hasNext())
      {
        afm localafm = ((px)localIterator.next()).a(paramqk, paramafm);
        if ((localafm != null) && (localafm.p() != localClass)) {
          return localafm;
        }
      }
    }
    return null;
  }
  
  protected afm b(qk paramqk, xq paramxq)
    throws qw
  {
    paramxq = paramxq.a();
    Iterator localIterator = this.i.d().iterator();
    while (localIterator.hasNext())
    {
      afm localafm = ((px)localIterator.next()).b(paramqk, paramxq);
      if (localafm != null) {
        return localafm;
      }
    }
    return null;
  }
  
  public qu<Object> b(qk paramqk, afm paramafm, xq paramxq, qc paramqc)
    throws qw
  {
    paramafm = a(paramxq);
    paramafm.a(a(paramqk, paramxq));
    a(paramqk, paramxq, paramafm);
    Object localObject = paramxq.a("initCause", j);
    if (localObject != null)
    {
      localObject = a(paramqk, paramxq, "cause", (xl)localObject);
      if (localObject != null) {
        paramafm.a((sw)localObject, true);
      }
    }
    paramafm.a("localizedMessage");
    paramafm.a("message");
    if (this.i.g())
    {
      Iterator localIterator = this.i.c().iterator();
      for (;;)
      {
        localObject = paramafm;
        if (!localIterator.hasNext()) {
          break;
        }
        paramafm = ((su)localIterator.next()).a(paramqk, paramxq, paramafm);
      }
    }
    localObject = paramafm;
    paramqc = ((sr)localObject).a(paramqc);
    paramafm = paramqc;
    if ((paramqc instanceof sp)) {
      paramafm = new wz((sp)paramqc);
    }
    if (this.i.g())
    {
      localObject = this.i.c().iterator();
      for (;;)
      {
        paramqc = paramafm;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        paramafm = ((su)((Iterator)localObject).next()).a(paramqk, paramxq, paramafm);
      }
    }
    paramqc = paramafm;
    return paramqc;
  }
  
  protected sw b(qk paramqk, xq paramxq, String paramString, xl paramxl)
    throws qw
  {
    if (paramqk.a(ql.f)) {
      paramxl.k();
    }
    afm localafm = paramxl.a(paramxq.j());
    qu localqu = a(paramqk, paramxl, new qd(paramString, localafm, paramxq.i(), paramxl));
    paramqk = a(paramqk, paramxl, localafm, paramString);
    paramxq = new tc(paramString, paramqk, (rw)paramqk.o(), paramxq.i(), paramxl);
    paramqk = paramxq;
    if (localqu != null) {
      paramqk = paramxq.a(localqu);
    }
    return paramqk;
  }
  
  protected void b(qk paramqk, xq paramxq, sr paramsr)
    throws qw
  {
    Object localObject1 = paramxq.q();
    if (localObject1 != null)
    {
      localObject1 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
        String str = (String)((Map.Entry)localObject2).getKey();
        localObject2 = (xk)((Map.Entry)localObject2).getValue();
        if ((localObject2 instanceof xl)) {
          paramsr.a(str, a(paramqk, paramxq, ((xk)localObject2).b(), (xl)localObject2));
        } else {
          paramsr.a(str, a(paramqk, paramxq, ((xk)localObject2).b(), (xj)localObject2));
        }
      }
    }
  }
  
  protected void b(qk paramqk, xq paramxq, ye<?> paramye, py parampy, tm paramtm)
    throws qw
  {
    Iterator localIterator = paramxq.o().iterator();
    while (localIterator.hasNext())
    {
      xl localxl = (xl)localIterator.next();
      int m = localxl.f();
      if (m >= 1)
      {
        boolean bool = parampy.k(localxl);
        Object localObject2;
        if (m == 1)
        {
          localObject1 = localxl.c(0);
          localObject2 = parampy.a((xn)localObject1);
          if ((parampy.d((xk)localObject1) == null) && ((localObject2 == null) || (((String)localObject2).length() == 0))) {
            a(paramqk, paramxq, paramye, parampy, paramtm, localxl, bool);
          }
        }
        else
        {
          if (!parampy.k(localxl)) {
            continue;
          }
        }
        Object localObject1 = new tn[m];
        int k = 0;
        while (k < m)
        {
          localObject2 = localxl.c(k);
          String str = parampy.a((xn)localObject2);
          Object localObject3 = parampy.d((xk)localObject2);
          if (((str == null) || (str.length() == 0)) && (localObject3 == null)) {
            throw new IllegalArgumentException("Argument #" + k + " of factory method " + localxl + " has no property name annotation; must have when multiple-paramater static method annotated as Creator");
          }
          localObject1[k] = a(paramqk, paramxq, str, k, (xn)localObject2, localObject3);
          k += 1;
        }
        paramtm.a(localxl, (tn[])localObject1);
      }
    }
  }
  
  protected th c(qk paramqk, xq paramxq)
    throws qw
  {
    boolean bool = paramqk.a(ql.f);
    tm localtm = new tm(paramxq, bool);
    py localpy = paramqk.a();
    if (paramxq.a().d())
    {
      localObject = paramxq.k();
      if (localObject != null)
      {
        if (bool) {
          adz.a(((xi)localObject).e());
        }
        localtm.a((xi)localObject);
      }
    }
    Object localObject = paramqk.e();
    localObject = paramqk.a().a(paramxq.c(), (ye)localObject);
    b(paramqk, paramxq, (ye)localObject, localpy, localtm);
    a(paramqk, paramxq, (ye)localObject, localpy, localtm);
    return localtm.a(paramqk);
  }
  
  protected void c(qk paramqk, xq paramxq, sr paramsr)
    throws qw
  {
    Object localObject = paramxq.m();
    if (localObject != null)
    {
      boolean bool = paramqk.a(ql.f);
      paramqk = ((Map)localObject).entrySet().iterator();
      while (paramqk.hasNext())
      {
        localObject = (Map.Entry)paramqk.next();
        xk localxk = (xk)((Map.Entry)localObject).getValue();
        if (bool) {
          localxk.k();
        }
        paramsr.a(localxk.b(), paramxq.a(localxk.c()), paramxq.i(), localxk, ((Map.Entry)localObject).getKey());
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ss.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */