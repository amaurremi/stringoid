package com.flurry.android.monolithic.sdk.impl;

public final class add
  extends adc
{
  private add(Class<?> paramClass, afm paramafm, Object paramObject1, Object paramObject2)
  {
    super(paramClass, paramafm, paramObject1, paramObject2);
  }
  
  public static add a(Class<?> paramClass, afm paramafm)
  {
    return new add(paramClass, paramafm, null, null);
  }
  
  protected afm a(Class<?> paramClass)
  {
    return new add(paramClass, this.a, null, null);
  }
  
  public afm b(Class<?> paramClass)
  {
    if (paramClass == this.a.p()) {
      return this;
    }
    return new add(this.d, this.a.f(paramClass), this.f, this.g);
  }
  
  public afm c(Class<?> paramClass)
  {
    if (paramClass == this.a.p()) {
      return this;
    }
    return new add(this.d, this.a.h(paramClass), this.f, this.g);
  }
  
  public add g(Object paramObject)
  {
    return new add(this.d, this.a, this.f, paramObject);
  }
  
  public add h(Object paramObject)
  {
    return new add(this.d, this.a.f(paramObject), this.f, this.g);
  }
  
  public add i(Object paramObject)
  {
    return new add(this.d, this.a, paramObject, this.g);
  }
  
  public String toString()
  {
    return "[collection type; class " + this.d.getName() + ", contains " + this.a + "]";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/add.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */