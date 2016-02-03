package com.flurry.android.monolithic.sdk.impl;

import java.text.DateFormat;
import java.util.HashMap;

public abstract class rf<T extends rf<T>>
  implements qg
{
  protected static final DateFormat d = aen.f;
  protected rg e;
  protected HashMap<adb, Class<?>> f;
  protected boolean g;
  protected yh h;
  
  protected rf(qf<? extends qb> paramqf, py parampy, ye<?> paramye, yh paramyh, rl paramrl, adk paramadk, qs paramqs)
  {
    this.e = new rg(paramqf, parampy, paramye, paramrl, paramadk, null, d, paramqs);
    this.h = paramyh;
    this.g = true;
  }
  
  protected rf(rf<T> paramrf, rg paramrg, yh paramyh)
  {
    this.e = paramrg;
    this.h = paramyh;
    this.g = true;
    this.f = paramrf.f;
  }
  
  public afm a(afm paramafm, Class<?> paramClass)
  {
    return m().a(paramafm, paramClass);
  }
  
  public py a()
  {
    return this.e.b();
  }
  
  public abstract <DESC extends qb> DESC a(afm paramafm);
  
  public final Class<?> a(Class<?> paramClass)
  {
    if (this.f == null) {
      return null;
    }
    return (Class)this.f.get(new adb(paramClass));
  }
  
  public final afm b(Class<?> paramClass)
  {
    return m().a(paramClass, (adj)null);
  }
  
  public abstract boolean b();
  
  public <DESC extends qb> DESC c(Class<?> paramClass)
  {
    return a(b(paramClass));
  }
  
  public abstract boolean c();
  
  public final yj<?> d(afm paramafm)
  {
    return this.e.f();
  }
  
  public yj<?> d(xg paramxg, Class<? extends yj<?>> paramClass)
  {
    qs localqs = k();
    if (localqs != null)
    {
      paramxg = localqs.a(this, paramxg, paramClass);
      if (paramxg != null) {
        return paramxg;
      }
    }
    return (yj)adz.b(paramClass, c());
  }
  
  public abstract boolean d();
  
  public ye<?> e()
  {
    return this.e.c();
  }
  
  public yi e(xg paramxg, Class<? extends yi> paramClass)
  {
    qs localqs = k();
    if (localqs != null)
    {
      paramxg = localqs.b(this, paramxg, paramClass);
      if (paramxg != null) {
        return paramxg;
      }
    }
    return (yi)adz.b(paramClass, c());
  }
  
  public qf<? extends qb> i()
  {
    return this.e.a();
  }
  
  public final rl j()
  {
    return this.e.d();
  }
  
  public final qs k()
  {
    return this.e.h();
  }
  
  public final yh l()
  {
    if (this.h == null) {
      this.h = new yv();
    }
    return this.h;
  }
  
  public final adk m()
  {
    return this.e.e();
  }
  
  public final DateFormat n()
  {
    return this.e.g();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/rf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */