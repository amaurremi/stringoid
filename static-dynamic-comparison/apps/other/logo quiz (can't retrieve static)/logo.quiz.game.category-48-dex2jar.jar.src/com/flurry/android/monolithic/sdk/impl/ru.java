package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Date;

public abstract class ru
{
  protected static final afm a = adk.a().a(Object.class);
  protected final rq b;
  protected final Class<?> c;
  
  protected ru(rq paramrq)
  {
    this.b = paramrq;
    if (paramrq == null) {}
    for (paramrq = null;; paramrq = this.b.f())
    {
      this.c = paramrq;
      return;
    }
  }
  
  public afm a(afm paramafm, Class<?> paramClass)
  {
    return this.b.a(paramafm, paramClass);
  }
  
  public afm a(Type paramType)
  {
    return this.b.m().a(paramType);
  }
  
  public abstract ra<Object> a(afm paramafm, qc paramqc)
    throws qw;
  
  public abstract ra<Object> a(afm paramafm, boolean paramBoolean, qc paramqc)
    throws qw;
  
  public abstract ra<Object> a(Class<?> paramClass, qc paramqc)
    throws qw;
  
  public abstract ra<Object> a(Class<?> paramClass, boolean paramBoolean, qc paramqc)
    throws qw;
  
  public final Class<?> a()
  {
    return this.c;
  }
  
  public abstract void a(long paramLong, or paramor)
    throws IOException, oz;
  
  public final void a(or paramor)
    throws IOException, oz
  {
    d().a(null, paramor, this);
  }
  
  public abstract void a(rq paramrq, or paramor, Object paramObject, rs paramrs)
    throws IOException, oq;
  
  public final void a(Object paramObject, or paramor)
    throws IOException, oz
  {
    if (paramObject == null)
    {
      d().a(null, paramor, this);
      return;
    }
    a(paramObject.getClass(), true, null).a(paramObject, paramor, this);
  }
  
  public abstract void a(Date paramDate, or paramor)
    throws IOException, oz;
  
  public final boolean a(rr paramrr)
  {
    return this.b.a(paramrr);
  }
  
  public abstract ra<Object> b(afm paramafm, qc paramqc)
    throws qw;
  
  public final zl b()
  {
    return this.b.h();
  }
  
  public abstract void b(long paramLong, or paramor)
    throws IOException, oz;
  
  public abstract void b(Date paramDate, or paramor)
    throws IOException, oz;
  
  public abstract ra<Object> c();
  
  public abstract ra<Object> d();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ru.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */