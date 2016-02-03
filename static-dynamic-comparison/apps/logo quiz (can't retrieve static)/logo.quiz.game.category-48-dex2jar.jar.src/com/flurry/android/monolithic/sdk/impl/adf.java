package com.flurry.android.monolithic.sdk.impl;

import java.util.Map;

public class adf
  extends adi
{
  protected final afm a;
  protected final afm b;
  
  protected adf(Class<?> paramClass, afm paramafm1, afm paramafm2, Object paramObject1, Object paramObject2)
  {
    super(paramClass, paramafm1.hashCode() ^ paramafm2.hashCode(), paramObject1, paramObject2);
    this.a = paramafm1;
    this.b = paramafm2;
  }
  
  public adf a(Object paramObject)
  {
    return new adf(this.d, this.a, this.b, this.f, paramObject);
  }
  
  protected afm a(Class<?> paramClass)
  {
    return new adf(paramClass, this.a, this.b, this.f, this.g);
  }
  
  protected String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.d.getName());
    if (this.a != null)
    {
      localStringBuilder.append('<');
      localStringBuilder.append(this.a.m());
      localStringBuilder.append(',');
      localStringBuilder.append(this.b.m());
      localStringBuilder.append('>');
    }
    return localStringBuilder.toString();
  }
  
  public String a(int paramInt)
  {
    if (paramInt == 0) {
      return "K";
    }
    if (paramInt == 1) {
      return "V";
    }
    return null;
  }
  
  public adf b(Object paramObject)
  {
    return new adf(this.d, this.a, this.b.f(paramObject), this.f, this.g);
  }
  
  public afm b(int paramInt)
  {
    if (paramInt == 0) {
      return this.a;
    }
    if (paramInt == 1) {
      return this.b;
    }
    return null;
  }
  
  public afm b(Class<?> paramClass)
  {
    if (paramClass == this.b.p()) {
      return this;
    }
    return new adf(this.d, this.a, this.b.f(paramClass), this.f, this.g);
  }
  
  public adf c(Object paramObject)
  {
    return new adf(this.d, this.a, this.b, paramObject, this.g);
  }
  
  public afm c(Class<?> paramClass)
  {
    if (paramClass == this.b.p()) {
      return this;
    }
    return new adf(this.d, this.a, this.b.h(paramClass), this.f, this.g);
  }
  
  public afm d(Class<?> paramClass)
  {
    if (paramClass == this.a.p()) {
      return this;
    }
    return new adf(this.d, this.a.f(paramClass), this.b, this.f, this.g);
  }
  
  public afm e(Class<?> paramClass)
  {
    if (paramClass == this.a.p()) {
      return this;
    }
    return new adf(this.d, this.a.h(paramClass), this.b, this.f, this.g);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (paramObject.getClass() != getClass()) {
        return false;
      }
      paramObject = (adf)paramObject;
    } while ((this.d == ((adf)paramObject).d) && (this.a.equals(((adf)paramObject).a)) && (this.b.equals(((adf)paramObject).b)));
    return false;
  }
  
  public boolean f()
  {
    return true;
  }
  
  public afm g()
  {
    return this.b;
  }
  
  public int h()
  {
    return 2;
  }
  
  public boolean j()
  {
    return true;
  }
  
  public afm k()
  {
    return this.a;
  }
  
  public boolean l()
  {
    return Map.class.isAssignableFrom(this.d);
  }
  
  public String toString()
  {
    return "[map-like type; class " + this.d.getName() + ", " + this.a + " -> " + this.b + "]";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/adf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */