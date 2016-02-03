package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;

public class ww
  extends th
{
  protected final String a;
  protected final boolean b;
  protected xo c;
  protected tn[] d;
  protected xo e;
  protected afm f;
  protected xo g;
  protected xo h;
  protected xo i;
  protected xo j;
  protected xo k;
  protected xo l;
  
  public ww(qk paramqk, afm paramafm)
  {
    boolean bool;
    if (paramqk == null)
    {
      bool = false;
      this.b = bool;
      if (paramafm != null) {
        break label39;
      }
    }
    label39:
    for (paramqk = "UNKNOWN TYPE";; paramqk = paramafm.toString())
    {
      this.a = paramqk;
      return;
      bool = paramqk.a(ql.q);
      break;
    }
  }
  
  protected qw a(Throwable paramThrowable)
  {
    while (paramThrowable.getCause() != null) {
      paramThrowable = paramThrowable.getCause();
    }
    return new qw("Instantiation of " + a() + " value failed: " + paramThrowable.getMessage(), paramThrowable);
  }
  
  public Object a(double paramDouble)
    throws IOException, oz
  {
    try
    {
      if (this.k != null)
      {
        Object localObject = this.k.a(Double.valueOf(paramDouble));
        return localObject;
      }
    }
    catch (Exception localException)
    {
      throw a(localException);
    }
    throw new qw("Can not instantiate value of type " + a() + " from JSON floating-point number; no one-double/Double-arg constructor/factory method");
  }
  
  public Object a(int paramInt)
    throws IOException, oz
  {
    try
    {
      if (this.i != null) {
        return this.i.a(Integer.valueOf(paramInt));
      }
      if (this.j != null)
      {
        Object localObject = this.j.a(Long.valueOf(paramInt));
        return localObject;
      }
    }
    catch (Exception localException)
    {
      throw a(localException);
    }
    throw new qw("Can not instantiate value of type " + a() + " from JSON integral number; no single-int-arg constructor/factory method");
  }
  
  public Object a(long paramLong)
    throws IOException, oz
  {
    try
    {
      if (this.j != null)
      {
        Object localObject = this.j.a(Long.valueOf(paramLong));
        return localObject;
      }
    }
    catch (Exception localException)
    {
      throw a(localException);
    }
    throw new qw("Can not instantiate value of type " + a() + " from JSON long integral number; no single-long-arg constructor/factory method");
  }
  
  public Object a(Object paramObject)
    throws IOException, oz
  {
    if (this.g == null) {
      throw new IllegalStateException("No delegate constructor for " + a());
    }
    try
    {
      paramObject = this.g.a(paramObject);
      return paramObject;
    }
    catch (ExceptionInInitializerError paramObject)
    {
      throw a((Throwable)paramObject);
    }
    catch (Exception paramObject)
    {
      throw a((Throwable)paramObject);
    }
  }
  
  public Object a(String paramString)
    throws IOException, oz
  {
    if (this.h != null) {
      try
      {
        paramString = this.h.a(paramString);
        return paramString;
      }
      catch (Exception paramString)
      {
        throw a(paramString);
      }
    }
    return b(paramString);
  }
  
  public Object a(boolean paramBoolean)
    throws IOException, oz
  {
    try
    {
      if (this.l != null)
      {
        Object localObject = this.l.a(Boolean.valueOf(paramBoolean));
        return localObject;
      }
    }
    catch (Exception localException)
    {
      throw a(localException);
    }
    throw new qw("Can not instantiate value of type " + a() + " from JSON boolean value; no single-boolean/Boolean-arg constructor/factory method");
  }
  
  public Object a(Object[] paramArrayOfObject)
    throws IOException, oz
  {
    if (this.e == null) {
      throw new IllegalStateException("No with-args constructor for " + a());
    }
    try
    {
      paramArrayOfObject = this.e.a(paramArrayOfObject);
      return paramArrayOfObject;
    }
    catch (ExceptionInInitializerError paramArrayOfObject)
    {
      throw a(paramArrayOfObject);
    }
    catch (Exception paramArrayOfObject)
    {
      throw a(paramArrayOfObject);
    }
  }
  
  public String a()
  {
    return this.a;
  }
  
  public void a(xo paramxo)
  {
    this.h = paramxo;
  }
  
  public void a(xo paramxo1, xo paramxo2, afm paramafm, xo paramxo3, tn[] paramArrayOftn)
  {
    this.c = paramxo1;
    this.g = paramxo2;
    this.f = paramafm;
    this.e = paramxo3;
    this.d = paramArrayOftn;
  }
  
  protected Object b(String paramString)
    throws IOException, oz
  {
    if (this.l != null)
    {
      String str = paramString.trim();
      if ("true".equals(str)) {
        return a(true);
      }
      if ("false".equals(str)) {
        return a(false);
      }
    }
    if ((this.b) && (paramString.length() == 0)) {
      return null;
    }
    throw new qw("Can not instantiate value of type " + a() + " from JSON String; no single-String constructor/factory method");
  }
  
  public void b(xo paramxo)
  {
    this.i = paramxo;
  }
  
  public void c(xo paramxo)
  {
    this.j = paramxo;
  }
  
  public boolean c()
  {
    return this.h != null;
  }
  
  public void d(xo paramxo)
  {
    this.k = paramxo;
  }
  
  public boolean d()
  {
    return this.i != null;
  }
  
  public void e(xo paramxo)
  {
    this.l = paramxo;
  }
  
  public boolean e()
  {
    return this.j != null;
  }
  
  public boolean f()
  {
    return this.k != null;
  }
  
  public boolean g()
  {
    return this.l != null;
  }
  
  public boolean h()
  {
    return this.c != null;
  }
  
  public boolean j()
  {
    return this.e != null;
  }
  
  public sw[] k()
  {
    return this.d;
  }
  
  public afm l()
  {
    return this.f;
  }
  
  public Object m()
    throws IOException, oz
  {
    if (this.c == null) {
      throw new IllegalStateException("No default constructor for " + a());
    }
    try
    {
      Object localObject = this.c.g();
      return localObject;
    }
    catch (ExceptionInInitializerError localExceptionInInitializerError)
    {
      throw a(localExceptionInInitializerError);
    }
    catch (Exception localException)
    {
      throw a(localException);
    }
  }
  
  public xo n()
  {
    return this.c;
  }
  
  public xo o()
  {
    return this.g;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ww.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */