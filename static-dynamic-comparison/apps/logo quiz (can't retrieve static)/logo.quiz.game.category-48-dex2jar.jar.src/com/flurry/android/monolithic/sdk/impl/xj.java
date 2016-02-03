package com.flurry.android.monolithic.sdk.impl;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Type;

public final class xj
  extends xk
{
  protected final Field a;
  
  public xj(Field paramField, xp paramxp)
  {
    super(paramxp);
    this.a = paramField;
  }
  
  public xj a(xp paramxp)
  {
    return new xj(this.a, paramxp);
  }
  
  public <A extends Annotation> A a(Class<A> paramClass)
  {
    return this.b.a(paramClass);
  }
  
  public void a(Object paramObject1, Object paramObject2)
    throws IllegalArgumentException
  {
    try
    {
      this.a.set(paramObject1, paramObject2);
      return;
    }
    catch (IllegalAccessException paramObject1)
    {
      throw new IllegalArgumentException("Failed to setValue() for field " + f() + ": " + ((IllegalAccessException)paramObject1).getMessage(), (Throwable)paramObject1);
    }
  }
  
  public void a(Annotation paramAnnotation)
  {
    this.b.b(paramAnnotation);
  }
  
  public String b()
  {
    return this.a.getName();
  }
  
  public Type c()
  {
    return this.a.getGenericType();
  }
  
  public Class<?> d()
  {
    return this.a.getType();
  }
  
  public Field e()
  {
    return this.a;
  }
  
  public String f()
  {
    return h().getName() + "#" + b();
  }
  
  public Class<?> h()
  {
    return this.a.getDeclaringClass();
  }
  
  public Member i()
  {
    return this.a;
  }
  
  public String toString()
  {
    return "[field " + b() + ", annotations: " + this.b + "]";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/xj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */