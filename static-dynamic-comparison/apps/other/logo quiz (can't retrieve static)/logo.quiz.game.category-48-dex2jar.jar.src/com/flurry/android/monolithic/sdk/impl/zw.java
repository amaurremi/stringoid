package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

public class zw
  extends ru
{
  public static final ra<Object> d = new aai("Null key for a Map not allowed in JSON (use a converting NullKeySerializer?)");
  @Deprecated
  public static final ra<Object> e = new acq();
  public static final ra<Object> f = new aav();
  protected final rs g;
  protected final aat h;
  protected final aem i;
  protected ra<Object> j = f;
  protected ra<Object> k;
  protected ra<Object> l = abn.a;
  protected ra<Object> m = d;
  protected final aas n;
  protected DateFormat o;
  
  public zw()
  {
    super(null);
    this.g = null;
    this.h = new aat();
    this.n = null;
    this.i = new aem();
  }
  
  protected zw(rq paramrq, zw paramzw, rs paramrs)
  {
    super(paramrq);
    if (paramrq == null) {
      throw new NullPointerException();
    }
    this.g = paramrs;
    this.h = paramzw.h;
    this.j = paramzw.j;
    this.k = paramzw.k;
    this.l = paramzw.l;
    this.m = paramzw.m;
    this.i = paramzw.i;
    this.n = this.h.a();
  }
  
  public ra<Object> a(afm paramafm, qc paramqc)
    throws qw
  {
    ra localra2 = this.n.b(paramafm);
    ra localra1 = localra2;
    if (localra2 == null)
    {
      localra2 = this.h.a(paramafm);
      localra1 = localra2;
      if (localra2 == null)
      {
        localra2 = c(paramafm, paramqc);
        localra1 = localra2;
        if (localra2 == null) {
          return a(paramafm.p());
        }
      }
    }
    return a(localra1, paramqc);
  }
  
  public ra<Object> a(afm paramafm, boolean paramBoolean, qc paramqc)
    throws qw
  {
    Object localObject = this.n.a(paramafm);
    if (localObject != null) {}
    ra localra;
    do
    {
      return (ra<Object>)localObject;
      localra = this.h.b(paramafm);
      localObject = localra;
    } while (localra != null);
    localObject = a(paramafm, paramqc);
    paramqc = this.g.b(this.b, paramafm, paramqc);
    if (paramqc != null) {}
    for (paramqc = new zx(paramqc, (ra)localObject);; paramqc = (qc)localObject)
    {
      localObject = paramqc;
      if (!paramBoolean) {
        break;
      }
      this.h.a(paramafm, paramqc);
      return paramqc;
    }
  }
  
  protected ra<Object> a(ra<Object> paramra, qc paramqc)
    throws qw
  {
    if (!(paramra instanceof qj)) {
      return paramra;
    }
    paramqc = ((qj)paramra).a(this.b, paramqc);
    if (paramqc != paramra)
    {
      paramra = paramqc;
      if ((paramqc instanceof rp))
      {
        ((rp)paramqc).a(this);
        paramra = paramqc;
      }
    }
    for (;;)
    {
      return paramra;
    }
  }
  
  public ra<Object> a(Class<?> paramClass)
  {
    return this.j;
  }
  
  public ra<Object> a(Class<?> paramClass, qc paramqc)
    throws qw
  {
    ra localra2 = this.n.b(paramClass);
    ra localra1 = localra2;
    if (localra2 == null)
    {
      localra2 = this.h.a(paramClass);
      localra1 = localra2;
      if (localra2 == null)
      {
        localra2 = this.h.a(this.b.b(paramClass));
        localra1 = localra2;
        if (localra2 == null)
        {
          localra2 = b(paramClass, paramqc);
          localra1 = localra2;
          if (localra2 == null) {
            return a(paramClass);
          }
        }
      }
    }
    return a(localra1, paramqc);
  }
  
  public ra<Object> a(Class<?> paramClass, boolean paramBoolean, qc paramqc)
    throws qw
  {
    Object localObject = this.n.a(paramClass);
    if (localObject != null) {}
    ra localra;
    do
    {
      return (ra<Object>)localObject;
      localra = this.h.b(paramClass);
      localObject = localra;
    } while (localra != null);
    localObject = a(paramClass, paramqc);
    paramqc = this.g.b(this.b, this.b.b(paramClass), paramqc);
    if (paramqc != null) {}
    for (paramqc = new zx(paramqc, (ra)localObject);; paramqc = (qc)localObject)
    {
      localObject = paramqc;
      if (!paramBoolean) {
        break;
      }
      this.h.a(paramClass, paramqc);
      return paramqc;
    }
  }
  
  protected zw a(rq paramrq, rs paramrs)
  {
    return new zw(paramrq, this, paramrs);
  }
  
  public final void a(long paramLong, or paramor)
    throws IOException, oz
  {
    if (a(rr.q))
    {
      paramor.a(paramLong);
      return;
    }
    if (this.o == null) {
      this.o = ((DateFormat)this.b.n().clone());
    }
    paramor.b(this.o.format(new Date(paramLong)));
  }
  
  protected void a(or paramor, Object paramObject)
    throws IOException, oz
  {
    Object localObject;
    int i1;
    if (paramObject == null)
    {
      localObject = d();
      i1 = 0;
    }
    for (;;)
    {
      try
      {
        ((ra)localObject).a(paramObject, paramor, this);
        if (i1 != 0) {
          paramor.e();
        }
        return;
      }
      catch (IOException paramor)
      {
        ra localra;
        boolean bool;
        throw paramor;
      }
      catch (Exception localException)
      {
        paramObject = localException.getMessage();
        paramor = (or)paramObject;
        if (paramObject != null) {
          continue;
        }
        paramor = "[no message for " + localException.getClass().getName() + "]";
        throw new qw(paramor, localException);
      }
      localra = a(paramObject.getClass(), true, null);
      bool = this.b.a(rr.j);
      i1 = bool;
      localObject = localra;
      if (bool)
      {
        paramor.d();
        paramor.a(this.i.a(paramObject.getClass(), this.b));
        i1 = bool;
        localObject = localra;
      }
    }
  }
  
  public final void a(rq paramrq, or paramor, Object paramObject, rs paramrs)
    throws IOException, oq
  {
    if (paramrs == null) {
      throw new IllegalArgumentException("Can not pass null serializerFactory");
    }
    paramrq = a(paramrq, paramrs);
    if (paramrq.getClass() != getClass()) {
      throw new IllegalStateException("Broken serializer provider: createInstance returned instance of type " + paramrq.getClass() + "; blueprint of type " + getClass());
    }
    paramrq.a(paramor, paramObject);
  }
  
  public final void a(Date paramDate, or paramor)
    throws IOException, oz
  {
    if (a(rr.q))
    {
      paramor.a(paramDate.getTime());
      return;
    }
    if (this.o == null) {
      this.o = ((DateFormat)this.b.n().clone());
    }
    paramor.b(this.o.format(paramDate));
  }
  
  public ra<Object> b(afm paramafm, qc paramqc)
    throws qw
  {
    ra localra2 = this.g.c(this.b, paramafm, paramqc);
    ra localra1 = localra2;
    if (localra2 == null) {
      if (this.k != null) {
        break label61;
      }
    }
    label61:
    for (localra1 = acr.a(paramafm);; localra1 = this.k)
    {
      paramafm = localra1;
      if ((localra1 instanceof qj)) {
        paramafm = ((qj)localra1).a(this.b, paramqc);
      }
      return paramafm;
    }
  }
  
  protected ra<Object> b(Class<?> paramClass, qc paramqc)
    throws qw
  {
    try
    {
      paramqc = d(this.b.b(paramClass), paramqc);
      if (paramqc != null) {
        this.h.a(paramClass, paramqc, this);
      }
      return paramqc;
    }
    catch (IllegalArgumentException paramClass)
    {
      throw new qw(paramClass.getMessage(), null, paramClass);
    }
  }
  
  public void b(long paramLong, or paramor)
    throws IOException, oz
  {
    if (a(rr.r))
    {
      paramor.a(String.valueOf(paramLong));
      return;
    }
    if (this.o == null) {
      this.o = ((DateFormat)this.b.n().clone());
    }
    paramor.a(this.o.format(new Date(paramLong)));
  }
  
  public void b(Date paramDate, or paramor)
    throws IOException, oz
  {
    if (a(rr.r))
    {
      paramor.a(String.valueOf(paramDate.getTime()));
      return;
    }
    if (this.o == null) {
      this.o = ((DateFormat)this.b.n().clone());
    }
    paramor.a(this.o.format(paramDate));
  }
  
  public ra<Object> c()
  {
    return this.m;
  }
  
  protected ra<Object> c(afm paramafm, qc paramqc)
    throws qw
  {
    try
    {
      paramqc = d(paramafm, paramqc);
      if (paramqc != null) {
        this.h.a(paramafm, paramqc, this);
      }
      return paramqc;
    }
    catch (IllegalArgumentException paramafm)
    {
      throw new qw(paramafm.getMessage(), null, paramafm);
    }
  }
  
  public ra<Object> d()
  {
    return this.l;
  }
  
  protected ra<Object> d(afm paramafm, qc paramqc)
    throws qw
  {
    return this.g.a(this.b, paramafm, paramqc);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/zw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */