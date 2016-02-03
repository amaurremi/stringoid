package com.flurry.android.monolithic.sdk.impl;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class te
  extends qq
{
  protected final ConcurrentHashMap<afm, qu<Object>> a = new ConcurrentHashMap(64, 0.75F, 2);
  protected final HashMap<afm, qu<Object>> b = new HashMap(8);
  protected final aem c;
  protected qo d;
  
  public te()
  {
    this(ss.h);
  }
  
  public te(qo paramqo)
  {
    this.d = paramqo;
    this.c = new aem();
  }
  
  public pw a(qk paramqk, afm paramafm)
    throws qw
  {
    return this.c.a(paramafm, paramqk);
  }
  
  protected qu<Object> a(afm paramafm)
  {
    if (paramafm == null) {
      throw new IllegalArgumentException();
    }
    return (qu)this.a.get(paramafm);
  }
  
  public qu<Object> a(qk paramqk, afm paramafm, qc paramqc)
    throws qw
  {
    Object localObject = a(paramafm);
    if (localObject != null)
    {
      paramafm = (afm)localObject;
      if ((localObject instanceof qh)) {
        paramafm = ((qh)localObject).a(paramqk, paramqc);
      }
    }
    do
    {
      return paramafm;
      qu localqu = d(paramqk, paramafm, paramqc);
      localObject = localqu;
      if (localqu == null) {
        localObject = b(paramafm);
      }
      paramafm = (afm)localObject;
    } while (!(localObject instanceof qh));
    return ((qh)localObject).a(paramqk, paramqc);
  }
  
  protected void a(qk paramqk, ro paramro)
    throws qw
  {
    paramro.a(paramqk, this);
  }
  
  protected qu<Object> b(afm paramafm)
    throws qw
  {
    if (!adz.d(paramafm.p())) {
      throw new qw("Can not find a Value deserializer for abstract type " + paramafm);
    }
    throw new qw("Can not find a Value deserializer for type " + paramafm);
  }
  
  public qu<Object> b(qk paramqk, afm paramafm, qc paramqc)
    throws qw
  {
    qu localqu = a(paramqk, paramafm, paramqc);
    paramqk = this.d.b(paramqk, paramafm, paramqc);
    if (paramqk != null) {
      return new tf(paramqk, localqu);
    }
    return localqu;
  }
  
  protected rc c(afm paramafm)
    throws qw
  {
    throw new qw("Can not find a (Map) Key deserializer for type " + paramafm);
  }
  
  public rc c(qk paramqk, afm paramafm, qc paramqc)
    throws qw
  {
    rc localrc2 = this.d.a(paramqk, paramafm, paramqc);
    rc localrc1 = localrc2;
    if ((localrc2 instanceof qi)) {
      localrc1 = ((qi)localrc2).a(paramqk, paramqc);
    }
    paramqk = localrc1;
    if (localrc1 == null) {
      paramqk = c(paramafm);
    }
    return paramqk;
  }
  
  protected qu<Object> d(qk paramqk, afm paramafm, qc paramqc)
    throws qw
  {
    int i;
    synchronized (this.b)
    {
      qu localqu = a(paramafm);
      if (localqu != null) {
        return localqu;
      }
      i = this.b.size();
      if (i > 0)
      {
        localqu = (qu)this.b.get(paramafm);
        if (localqu != null) {
          return localqu;
        }
      }
    }
    try
    {
      paramqk = e(paramqk, paramafm, paramqc);
      if ((i == 0) && (this.b.size() > 0)) {
        this.b.clear();
      }
      return paramqk;
    }
    finally
    {
      paramqk = finally;
      if ((i == 0) && (this.b.size() > 0)) {
        this.b.clear();
      }
      throw paramqk;
    }
  }
  
  protected qu<Object> e(qk paramqk, afm paramafm, qc paramqc)
    throws qw
  {
    try
    {
      paramqc = f(paramqk, paramafm, paramqc);
      if (paramqc == null)
      {
        paramqk = null;
        return paramqk;
      }
    }
    catch (IllegalArgumentException paramqk)
    {
      throw new qw(paramqk.getMessage(), null, paramqk);
    }
    boolean bool3 = paramqc instanceof ro;
    if (paramqc.getClass() == sp.class) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (paramqk.a(ql.a))
        {
          Object localObject = paramqk.a();
          localObject = ((py)localObject).a(xh.a(paramqc.getClass(), (py)localObject, null));
          bool2 = bool1;
          if (localObject != null) {
            bool2 = ((Boolean)localObject).booleanValue();
          }
        }
      }
      if (bool3)
      {
        this.b.put(paramafm, paramqc);
        a(paramqk, (ro)paramqc);
        this.b.remove(paramafm);
      }
      paramqk = paramqc;
      if (!bool2) {
        break;
      }
      this.a.put(paramafm, paramqc);
      return paramqc;
    }
  }
  
  protected qu<Object> f(qk paramqk, afm paramafm, qc paramqc)
    throws qw
  {
    if (paramafm.r()) {
      return this.d.b(paramqk, this, paramafm, paramqc);
    }
    if (paramafm.f())
    {
      if (paramafm.b()) {
        return this.d.a(paramqk, this, (ada)paramafm, paramqc);
      }
      if (paramafm.j())
      {
        paramafm = (adf)paramafm;
        if (paramafm.l()) {
          return this.d.a(paramqk, this, (adg)paramafm, paramqc);
        }
        return this.d.a(paramqk, this, paramafm, paramqc);
      }
      if (paramafm.i())
      {
        paramafm = (adc)paramafm;
        if (paramafm.a_()) {
          return this.d.a(paramqk, this, (add)paramafm, paramqc);
        }
        return this.d.a(paramqk, this, paramafm, paramqc);
      }
    }
    if (ou.class.isAssignableFrom(paramafm.p())) {
      return this.d.c(paramqk, this, paramafm, paramqc);
    }
    return this.d.a(paramqk, this, paramafm, paramqc);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/te.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */