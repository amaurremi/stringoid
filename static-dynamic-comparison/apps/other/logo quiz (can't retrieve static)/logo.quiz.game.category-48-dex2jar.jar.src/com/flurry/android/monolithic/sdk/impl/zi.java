package com.flurry.android.monolithic.sdk.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class zi
  extends zd
{
  public static final zi e = new zi(null);
  protected final rt f;
  
  protected zi(rt paramrt)
  {
    Object localObject = paramrt;
    if (paramrt == null) {
      localObject = new zj();
    }
    this.f = ((rt)localObject);
  }
  
  public ra<Object> a(rq paramrq, afm paramafm, qc paramqc)
    throws qw
  {
    xq localxq = (xq)paramrq.b(paramafm);
    ra localra = a(paramrq, localxq.c(), paramqc);
    if (localra != null) {
      paramafm = localra;
    }
    afm localafm;
    boolean bool;
    do
    {
      do
      {
        do
        {
          return paramafm;
          localafm = a(paramrq, localxq.c(), paramafm);
          if (localafm != paramafm) {}
          for (bool = true; paramafm.f(); bool = false) {
            return b(paramrq, localafm, localxq, paramqc, bool);
          }
          paramafm = this.f.c().iterator();
          while (paramafm.hasNext())
          {
            localra = ((rv)paramafm.next()).a(paramrq, localafm, localxq, paramqc);
            if (localra != null) {
              return localra;
            }
          }
          localra = a(localafm, paramrq, localxq, paramqc, bool);
          paramafm = localra;
        } while (localra != null);
        localra = b(localafm, paramrq, localxq, paramqc, bool);
        paramafm = localra;
      } while (localra != null);
      localra = a(paramrq, localafm, localxq, paramqc);
      paramafm = localra;
    } while (localra != null);
    return a(paramrq, localafm, localxq, paramqc, bool);
  }
  
  public ra<Object> a(rq paramrq, afm paramafm, xq paramxq, qc paramqc)
    throws qw
  {
    if (!b(paramafm.p()))
    {
      paramqc = null;
      return paramqc;
    }
    paramafm = a(paramrq, paramxq, paramqc);
    if (this.f.b())
    {
      Iterator localIterator = this.f.e().iterator();
      for (;;)
      {
        paramqc = paramafm;
        if (!localIterator.hasNext()) {
          break;
        }
        paramafm = ((zk)localIterator.next()).a(paramrq, paramxq, paramafm);
      }
    }
    return paramafm;
  }
  
  protected ra<Object> a(rq paramrq, xq paramxq, qc paramqc)
    throws qw
  {
    if (paramxq.b() == Object.class) {
      throw new IllegalArgumentException("Can not create bean serializer for Object.class");
    }
    zh localzh = a(paramxq);
    Object localObject2 = c(paramrq, paramxq);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ArrayList();
    }
    Iterator localIterator;
    if (this.f.b())
    {
      localIterator = this.f.e().iterator();
      for (;;)
      {
        localObject2 = localObject1;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = ((zk)localIterator.next()).a(paramrq, paramxq, (List)localObject1);
      }
    }
    localObject2 = localObject1;
    localObject1 = b(paramrq, paramxq, a(paramrq, paramxq, (List)localObject2));
    if (this.f.b())
    {
      localIterator = this.f.e().iterator();
      for (;;)
      {
        localObject2 = localObject1;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = ((zk)localIterator.next()).b(paramrq, paramxq, (List)localObject1);
      }
    }
    localObject2 = localObject1;
    localzh.a((List)localObject2);
    localzh.a(b(paramrq, paramxq));
    localObject1 = paramxq.p();
    if (localObject1 != null)
    {
      if (paramrq.a(rr.e)) {
        ((xl)localObject1).k();
      }
      localObject2 = ((xl)localObject1).a(paramxq.j());
      localzh.a(new zc((xl)localObject1, abl.a(null, (afm)localObject2, paramrq.a(rr.h), b(paramrq, ((afm)localObject2).g(), paramqc), paramqc, null, null)));
    }
    a(paramrq, localzh);
    if (this.f.b())
    {
      localObject2 = this.f.e().iterator();
      for (paramqc = localzh;; paramqc = ((zk)((Iterator)localObject2).next()).a(paramrq, paramxq, paramqc))
      {
        localObject1 = paramqc;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
      }
    }
    localObject1 = localzh;
    paramqc = ((zh)localObject1).b();
    paramrq = paramqc;
    if (paramqc == null)
    {
      paramrq = paramqc;
      if (paramxq.h()) {
        paramrq = ((zh)localObject1).c();
      }
    }
    return paramrq;
  }
  
  public rx a(afm paramafm, rq paramrq, xk paramxk, qc paramqc)
    throws qw
  {
    py localpy = paramrq.a();
    yj localyj = localpy.a(paramrq, paramxk, paramafm);
    if (localyj == null) {
      return b(paramrq, paramafm, paramqc);
    }
    return localyj.a(paramrq, paramafm, paramrq.l().a(paramxk, paramrq, localpy), paramqc);
  }
  
  protected zf a(rq paramrq, adj paramadj, zp paramzp, boolean paramBoolean, String paramString, xk paramxk)
    throws qw
  {
    if (paramrq.a(rr.e)) {
      paramxk.k();
    }
    afm localafm = paramxk.a(paramadj);
    qd localqd = new qd(paramString, localafm, paramzp.a(), paramxk);
    ra localra = a(paramrq, paramxk, localqd);
    paramadj = null;
    if (adz.e(localafm.p())) {
      paramadj = b(localafm, paramrq, paramxk, localqd);
    }
    paramadj = paramzp.a(paramString, localafm, localra, a(localafm, paramrq, paramxk, localqd), paramadj, paramxk, paramBoolean);
    paramadj.a(paramrq.a().g(paramxk));
    return paramadj;
  }
  
  protected zf a(zf paramzf, Class<?>[] paramArrayOfClass)
  {
    return zm.a(paramzf, paramArrayOfClass);
  }
  
  protected zh a(xq paramxq)
  {
    return new zh(paramxq);
  }
  
  protected zp a(rq paramrq, xq paramxq)
  {
    return new zp(paramrq, paramxq);
  }
  
  protected Iterable<rv> a()
  {
    return this.f.c();
  }
  
  protected List<zf> a(rq paramrq, xq paramxq, List<zf> paramList)
  {
    paramrq = paramrq.a().c(paramxq.c());
    if ((paramrq != null) && (paramrq.length > 0))
    {
      paramrq = adp.a(paramrq);
      paramxq = paramList.iterator();
      while (paramxq.hasNext()) {
        if (paramrq.contains(((zf)paramxq.next()).d())) {
          paramxq.remove();
        }
      }
    }
    return paramList;
  }
  
  protected void a(rq paramrq, zh paramzh)
  {
    List localList = paramzh.a();
    boolean bool = paramrq.a(rr.i);
    int m = localList.size();
    paramrq = new zf[m];
    int k = 0;
    int i = 0;
    if (k < m)
    {
      zf localzf = (zf)localList.get(k);
      Class[] arrayOfClass = localzf.h();
      int j;
      if (arrayOfClass == null)
      {
        j = i;
        if (!bool) {
          break label108;
        }
        paramrq[k] = localzf;
      }
      for (;;)
      {
        k += 1;
        break;
        j = i + 1;
        paramrq[k] = a(localzf, arrayOfClass);
        label108:
        i = j;
      }
    }
    if ((bool) && (i == 0)) {
      return;
    }
    paramzh.a(paramrq);
  }
  
  public rx b(afm paramafm, rq paramrq, xk paramxk, qc paramqc)
    throws qw
  {
    afm localafm = paramafm.g();
    py localpy = paramrq.a();
    paramafm = localpy.b(paramrq, paramxk, paramafm);
    if (paramafm == null) {
      return b(paramrq, localafm, paramqc);
    }
    return paramafm.a(paramrq, localafm, paramrq.l().a(paramxk, paramrq, localpy), paramqc);
  }
  
  protected Object b(rq paramrq, xq paramxq)
  {
    return paramrq.a().f(paramxq.c());
  }
  
  @Deprecated
  protected List<zf> b(rq paramrq, xq paramxq, List<zf> paramList)
  {
    return paramList;
  }
  
  protected boolean b(Class<?> paramClass)
  {
    return (adz.a(paramClass) == null) && (!adz.c(paramClass));
  }
  
  public ra<Object> c(rq paramrq, afm paramafm, qc paramqc)
  {
    Object localObject = null;
    ra localra = null;
    if (!this.f.a()) {
      localObject = localra;
    }
    do
    {
      xq localxq;
      Iterator localIterator;
      while (!localIterator.hasNext())
      {
        return (ra<Object>)localObject;
        localxq = (xq)paramrq.c(paramafm.p());
        localIterator = this.f.d().iterator();
      }
      localra = ((rv)localIterator.next()).a(paramrq, paramafm, localxq, paramqc);
      localObject = localra;
    } while (localra == null);
    return localra;
  }
  
  protected List<zf> c(rq paramrq, xq paramxq)
    throws qw
  {
    Object localObject1 = paramxq.d();
    py localpy = paramrq.a();
    c(paramrq, paramxq, (List)localObject1);
    if (paramrq.a(rr.f)) {
      d(paramrq, paramxq, (List)localObject1);
    }
    if (((List)localObject1).isEmpty()) {
      return null;
    }
    boolean bool = a(paramrq, paramxq, null, null);
    zp localzp = a(paramrq, paramxq);
    ArrayList localArrayList = new ArrayList(((List)localObject1).size());
    paramxq = paramxq.j();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (qe)((Iterator)localObject1).next();
      xk localxk = ((qe)localObject2).j();
      pz localpz = localpy.a(localxk);
      if ((localpz == null) || (!localpz.c()))
      {
        localObject2 = ((qe)localObject2).a();
        if ((localxk instanceof xl)) {
          localArrayList.add(a(paramrq, paramxq, localzp, bool, (String)localObject2, (xl)localxk));
        } else {
          localArrayList.add(a(paramrq, paramxq, localzp, bool, (String)localObject2, (xj)localxk));
        }
      }
    }
    return localArrayList;
  }
  
  protected void c(rq paramrq, xq paramxq, List<qe> paramList)
  {
    py localpy = paramrq.a();
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramxq = ((qe)localIterator.next()).j();
      if (paramxq == null)
      {
        localIterator.remove();
      }
      else
      {
        Class localClass = paramxq.d();
        paramList = (Boolean)localHashMap.get(localClass);
        paramxq = paramList;
        if (paramList == null)
        {
          paramList = localpy.e(((xq)paramrq.c(localClass)).c());
          paramxq = paramList;
          if (paramList == null) {
            paramxq = Boolean.FALSE;
          }
          localHashMap.put(localClass, paramxq);
        }
        if (paramxq.booleanValue()) {
          localIterator.remove();
        }
      }
    }
  }
  
  protected void d(rq paramrq, xq paramxq, List<qe> paramList)
  {
    paramrq = paramList.iterator();
    while (paramrq.hasNext()) {
      if (!((qe)paramrq.next()).f()) {
        paramrq.remove();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/zi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */