package com.flurry.android.monolithic.sdk.impl;

import java.lang.reflect.Array;

public final class ada
  extends adi
{
  protected final afm a;
  protected final Object b;
  
  private ada(afm paramafm, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    super(paramObject1.getClass(), paramafm.hashCode(), paramObject2, paramObject3);
    this.a = paramafm;
    this.b = paramObject1;
  }
  
  public static ada a(afm paramafm, Object paramObject1, Object paramObject2)
  {
    return new ada(paramafm, Array.newInstance(paramafm.p(), 0), null, null);
  }
  
  public ada a(Object paramObject)
  {
    if (paramObject == this.g) {
      return this;
    }
    return new ada(this.a, this.b, this.f, paramObject);
  }
  
  protected afm a(Class<?> paramClass)
  {
    if (!paramClass.isArray()) {
      throw new IllegalArgumentException("Incompatible narrowing operation: trying to narrow " + toString() + " to class " + paramClass.getName());
    }
    paramClass = paramClass.getComponentType();
    return a(adk.a().a(paramClass), this.f, this.g);
  }
  
  protected String a()
  {
    return this.d.getName();
  }
  
  public String a(int paramInt)
  {
    if (paramInt == 0) {
      return "E";
    }
    return null;
  }
  
  public ada b(Object paramObject)
  {
    if (paramObject == this.a.o()) {
      return this;
    }
    return new ada(this.a.f(paramObject), this.b, this.f, this.g);
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
    return a(this.a.f(paramClass), this.f, this.g);
  }
  
  public boolean b()
  {
    return true;
  }
  
  public ada c(Object paramObject)
  {
    if (paramObject == this.f) {
      return this;
    }
    return new ada(this.a, this.b, paramObject, this.g);
  }
  
  public afm c(Class<?> paramClass)
  {
    if (paramClass == this.a.p()) {
      return this;
    }
    return a(this.a.h(paramClass), this.f, this.g);
  }
  
  public boolean c()
  {
    return false;
  }
  
  public boolean d()
  {
    return true;
  }
  
  public boolean e()
  {
    return this.a.e();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramObject == this) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramObject == null);
      bool1 = bool2;
    } while (paramObject.getClass() != getClass());
    paramObject = (ada)paramObject;
    return this.a.equals(((ada)paramObject).a);
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
  
  public String toString()
  {
    return "[array type, component type: " + this.a + "]";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ada.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */