package com.flurry.android.monolithic.sdk.impl;

import java.util.Set;

public class js
{
  private final String a;
  private transient int b = -1;
  private final ji c;
  private final String d;
  private final ou e;
  private final jt f;
  private Set<String> g;
  private final kf h = new kf(ji.n());
  
  public js(String paramString1, ji paramji, String paramString2, ou paramou, jt paramjt)
  {
    this.a = ji.g(paramString1);
    this.c = paramji;
    this.d = paramString2;
    this.e = paramou;
    this.f = paramjt;
  }
  
  private boolean a(ou paramou)
  {
    if (this.e == null) {
      return paramou == null;
    }
    if (Double.isNaN(this.e.n())) {
      return Double.isNaN(paramou.n());
    }
    return this.e.equals(paramou);
  }
  
  public String a()
  {
    return this.a;
  }
  
  public void a(String paramString1, String paramString2)
  {
    try
    {
      this.h.a(paramString1, paramString2);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public int b()
  {
    return this.b;
  }
  
  public ji c()
  {
    return this.c;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public ou e()
  {
    return this.e;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof js)) {
        return false;
      }
      paramObject = (js)paramObject;
    } while ((this.a.equals(((js)paramObject).a)) && (this.c.equals(((js)paramObject).c)) && (a(((js)paramObject).e)) && (this.h.equals(((js)paramObject).h)));
    return false;
  }
  
  public jt f()
  {
    return this.f;
  }
  
  public int hashCode()
  {
    return this.a.hashCode() + this.c.m();
  }
  
  public String toString()
  {
    return this.a + " type:" + ji.d(this.c) + " pos:" + this.b;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/js.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */