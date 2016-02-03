package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.util.HashMap;

public abstract class yy
  extends rw
{
  protected final yi b;
  protected final afm c;
  protected final qc d;
  protected final afm e;
  protected final HashMap<String, qu<Object>> f;
  protected qu<Object> g;
  
  protected yy(afm paramafm, yi paramyi, qc paramqc, Class<?> paramClass)
  {
    this.c = paramafm;
    this.b = paramyi;
    this.d = paramqc;
    this.f = new HashMap();
    if (paramClass == null)
    {
      this.e = null;
      return;
    }
    this.e = paramafm.g(paramClass);
  }
  
  protected final qu<Object> a(qm paramqm)
    throws IOException, oz
  {
    if (this.e == null) {
      return null;
    }
    synchronized (this.e)
    {
      if (this.g == null) {
        this.g = paramqm.b().a(paramqm.a(), this.e, this.d);
      }
      paramqm = this.g;
      return paramqm;
    }
  }
  
  protected final qu<Object> a(qm paramqm, String paramString)
    throws IOException, oz
  {
    Object localObject2;
    Object localObject1;
    synchronized (this.f)
    {
      localObject2 = (qu)this.f.get(paramString);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = this.b.a(paramString);
        if (localObject2 != null) {
          break label93;
        }
        if (this.e == null) {
          throw paramqm.a(this.c, paramString);
        }
      }
    }
    for (paramqm = a(paramqm);; paramqm = paramqm.b().a(paramqm.a(), (afm)localObject1, this.d))
    {
      this.f.put(paramString, paramqm);
      localObject1 = paramqm;
      return (qu<Object>)localObject1;
      label93:
      localObject1 = localObject2;
      if (this.c != null)
      {
        localObject1 = localObject2;
        if (this.c.getClass() == localObject2.getClass()) {
          localObject1 = this.c.f(((afm)localObject2).p());
        }
      }
    }
  }
  
  public String b()
  {
    return null;
  }
  
  public String c()
  {
    return this.c.p().getName();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('[').append(getClass().getName());
    localStringBuilder.append("; base-type:").append(this.c);
    localStringBuilder.append("; id-resolver: ").append(this.b);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/yy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */