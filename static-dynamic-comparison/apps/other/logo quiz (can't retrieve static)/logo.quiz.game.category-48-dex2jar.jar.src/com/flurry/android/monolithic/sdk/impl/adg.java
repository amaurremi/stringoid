package com.flurry.android.monolithic.sdk.impl;

public final class adg
  extends adf
{
  private adg(Class<?> paramClass, afm paramafm1, afm paramafm2, Object paramObject1, Object paramObject2)
  {
    super(paramClass, paramafm1, paramafm2, paramObject1, paramObject2);
  }
  
  public static adg a(Class<?> paramClass, afm paramafm1, afm paramafm2)
  {
    return new adg(paramClass, paramafm1, paramafm2, null, null);
  }
  
  protected afm a(Class<?> paramClass)
  {
    return new adg(paramClass, this.a, this.b, this.f, this.g);
  }
  
  public afm b(Class<?> paramClass)
  {
    if (paramClass == this.b.p()) {
      return this;
    }
    return new adg(this.d, this.a, this.b.f(paramClass), this.f, this.g);
  }
  
  public afm c(Class<?> paramClass)
  {
    if (paramClass == this.b.p()) {
      return this;
    }
    return new adg(this.d, this.a, this.b.h(paramClass), this.f, this.g);
  }
  
  public afm d(Class<?> paramClass)
  {
    if (paramClass == this.a.p()) {
      return this;
    }
    return new adg(this.d, this.a.f(paramClass), this.b, this.f, this.g);
  }
  
  public afm e(Class<?> paramClass)
  {
    if (paramClass == this.a.p()) {
      return this;
    }
    return new adg(this.d, this.a.h(paramClass), this.b, this.f, this.g);
  }
  
  public adg g(Object paramObject)
  {
    return new adg(this.d, this.a, this.b, this.f, paramObject);
  }
  
  public adg h(Object paramObject)
  {
    return new adg(this.d, this.a, this.b.f(paramObject), this.f, this.g);
  }
  
  public adg i(Object paramObject)
  {
    return new adg(this.d, this.a, this.b, paramObject, this.g);
  }
  
  public String toString()
  {
    return "[map type; class " + this.d.getName() + ", " + this.a + " -> " + this.b + "]";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/adg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */