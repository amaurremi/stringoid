package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;

public abstract class sw
  implements qc
{
  protected final String a;
  protected final afm b;
  protected final ado c;
  protected qu<Object> d;
  protected rw e;
  protected tb f;
  protected String g;
  protected int h = -1;
  
  protected sw(sw paramsw)
  {
    this.a = paramsw.a;
    this.b = paramsw.b;
    this.c = paramsw.c;
    this.d = paramsw.d;
    this.e = paramsw.e;
    this.f = paramsw.f;
    this.g = paramsw.g;
    this.h = paramsw.h;
  }
  
  protected sw(sw paramsw, qu<Object> paramqu)
  {
    this.a = paramsw.a;
    this.b = paramsw.b;
    this.c = paramsw.c;
    this.e = paramsw.e;
    this.g = paramsw.g;
    this.h = paramsw.h;
    this.d = paramqu;
    if (paramqu == null)
    {
      this.f = null;
      return;
    }
    paramsw = paramqu.b();
    if (paramsw == null) {}
    for (paramsw = (sw)localObject;; paramsw = new tb(this.b, paramsw))
    {
      this.f = paramsw;
      return;
    }
  }
  
  protected sw(String paramString, afm paramafm, rw paramrw, ado paramado)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (this.a = "";; this.a = afv.a.a(paramString))
    {
      this.b = paramafm;
      this.c = paramado;
      this.e = paramrw;
      return;
    }
  }
  
  public afm a()
  {
    return this.b;
  }
  
  public abstract sw a(qu<Object> paramqu);
  
  protected IOException a(Exception paramException)
    throws IOException
  {
    if ((paramException instanceof IOException)) {
      throw ((IOException)paramException);
    }
    Object localObject = paramException;
    if ((paramException instanceof RuntimeException)) {
      throw ((RuntimeException)paramException);
    }
    while (((Throwable)localObject).getCause() != null) {
      localObject = ((Throwable)localObject).getCause();
    }
    throw new qw(((Throwable)localObject).getMessage(), null, (Throwable)localObject);
  }
  
  public final Object a(ow paramow, qm paramqm)
    throws IOException, oz
  {
    if (paramow.e() == pb.m)
    {
      if (this.f == null) {
        return null;
      }
      return this.f.a(paramqm);
    }
    if (this.e != null) {
      return this.d.a(paramow, paramqm, this.e);
    }
    return this.d.a(paramow, paramqm);
  }
  
  public void a(int paramInt)
  {
    if (this.h != -1) {
      throw new IllegalStateException("Property '" + c() + "' already had index (" + this.h + "), trying to assign " + paramInt);
    }
    this.h = paramInt;
  }
  
  public abstract void a(ow paramow, qm paramqm, Object paramObject)
    throws IOException, oz;
  
  protected void a(Exception paramException, Object paramObject)
    throws IOException
  {
    if ((paramException instanceof IllegalArgumentException))
    {
      StringBuilder localStringBuilder;
      if (paramObject == null)
      {
        paramObject = "[NULL]";
        localStringBuilder = new StringBuilder("Problem deserializing property '").append(d());
        localStringBuilder.append("' (expected type: ").append(a());
        localStringBuilder.append("; actual type: ").append((String)paramObject).append(")");
        paramObject = paramException.getMessage();
        if (paramObject == null) {
          break label106;
        }
        localStringBuilder.append(", problem: ").append((String)paramObject);
      }
      for (;;)
      {
        throw new qw(localStringBuilder.toString(), null, paramException);
        paramObject = paramObject.getClass().getName();
        break;
        label106:
        localStringBuilder.append(" (no error message provided)");
      }
    }
    a(paramException);
  }
  
  public abstract void a(Object paramObject1, Object paramObject2)
    throws IOException;
  
  public void a(String paramString)
  {
    this.g = paramString;
  }
  
  public abstract xk b();
  
  public final String c()
  {
    return this.a;
  }
  
  @Deprecated
  public String d()
  {
    return this.a;
  }
  
  public String e()
  {
    return this.g;
  }
  
  public boolean f()
  {
    return this.d != null;
  }
  
  public boolean g()
  {
    return this.e != null;
  }
  
  public qu<Object> h()
  {
    return this.d;
  }
  
  public rw i()
  {
    return this.e;
  }
  
  public int j()
  {
    return this.h;
  }
  
  public Object k()
  {
    return null;
  }
  
  public String toString()
  {
    return "[property '" + c() + "']";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/sw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */