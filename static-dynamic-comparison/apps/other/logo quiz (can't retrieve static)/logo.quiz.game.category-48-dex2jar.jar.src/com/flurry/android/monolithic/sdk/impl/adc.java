package com.flurry.android.monolithic.sdk.impl;

import java.util.Collection;

public class adc
  extends adi
{
  protected final afm a;
  
  protected adc(Class<?> paramClass, afm paramafm, Object paramObject1, Object paramObject2)
  {
    super(paramClass, paramafm.hashCode(), paramObject1, paramObject2);
    this.a = paramafm;
  }
  
  public adc a(Object paramObject)
  {
    return new adc(this.d, this.a, this.f, paramObject);
  }
  
  protected afm a(Class<?> paramClass)
  {
    return new adc(paramClass, this.a, this.f, this.g);
  }
  
  protected String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.d.getName());
    if (this.a != null)
    {
      localStringBuilder.append('<');
      localStringBuilder.append(this.a.m());
      localStringBuilder.append('>');
    }
    return localStringBuilder.toString();
  }
  
  public String a(int paramInt)
  {
    if (paramInt == 0) {
      return "E";
    }
    return null;
  }
  
  public boolean a_()
  {
    return Collection.class.isAssignableFrom(this.d);
  }
  
  public adc b(Object paramObject)
  {
    return new adc(this.d, this.a.f(paramObject), this.f, this.g);
  }
  
  public afm b(int paramInt)
  {
    if (paramInt == 0) {
      return this.a;
    }
    return null;
  }
  
  public afm b(Class<?> paramClass)
  {
    if (paramClass == this.a.p()) {
      return this;
    }
    return new adc(this.d, this.a.f(paramClass), this.f, this.g);
  }
  
  public adc c(Object paramObject)
  {
    return new adc(this.d, this.a, paramObject, this.g);
  }
  
  public afm c(Class<?> paramClass)
  {
    if (paramClass == this.a.p()) {
      return this;
    }
    return new adc(this.d, this.a.h(paramClass), this.f, this.g);
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
      paramObject = (adc)paramObject;
    } while ((this.d == ((adc)paramObject).d) && (this.a.equals(((adc)paramObject).a)));
    return false;
  }
  
  public boolean f()
  {
    return true;
  }
  
  public afm g()
  {
    return this.a;
  }
  
  public int h()
  {
    return 1;
  }
  
  public boolean i()
  {
    return true;
  }
  
  public String toString()
  {
    return "[collection-like type; class " + this.d.getName() + ", contains " + this.a + "]";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/adc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */