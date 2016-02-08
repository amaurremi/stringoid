package com.flurry.android.monolithic.sdk.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public final class xl
  extends xo
{
  protected final Method a;
  protected Class<?>[] c;
  
  public xl(Method paramMethod, xp paramxp, xp[] paramArrayOfxp)
  {
    super(paramxp, paramArrayOfxp);
    this.a = paramMethod;
  }
  
  public afm a(adj paramadj)
  {
    return a(paramadj, this.a.getTypeParameters());
  }
  
  public xl a(xp paramxp)
  {
    return new xl(this.a, paramxp, this.d);
  }
  
  public xl a(Method paramMethod)
  {
    return new xl(paramMethod, this.b, this.d);
  }
  
  public Class<?> a(int paramInt)
  {
    Class[] arrayOfClass = this.a.getParameterTypes();
    if (paramInt >= arrayOfClass.length) {
      return null;
    }
    return arrayOfClass[paramInt];
  }
  
  public final Object a(Object paramObject)
    throws Exception
  {
    return this.a.invoke(null, new Object[] { paramObject });
  }
  
  public final Object a(Object[] paramArrayOfObject)
    throws Exception
  {
    return this.a.invoke(null, paramArrayOfObject);
  }
  
  public void a(Object paramObject1, Object paramObject2)
    throws IllegalArgumentException
  {
    try
    {
      this.a.invoke(paramObject1, new Object[] { paramObject2 });
      return;
    }
    catch (IllegalAccessException paramObject1)
    {
      throw new IllegalArgumentException("Failed to setValue() with method " + n() + ": " + ((IllegalAccessException)paramObject1).getMessage(), (Throwable)paramObject1);
    }
    catch (InvocationTargetException paramObject1)
    {
      throw new IllegalArgumentException("Failed to setValue() with method " + n() + ": " + ((InvocationTargetException)paramObject1).getMessage(), (Throwable)paramObject1);
    }
  }
  
  public String b()
  {
    return this.a.getName();
  }
  
  public Type b(int paramInt)
  {
    Type[] arrayOfType = this.a.getGenericParameterTypes();
    if (paramInt >= arrayOfType.length) {
      return null;
    }
    return arrayOfType[paramInt];
  }
  
  public Type c()
  {
    return this.a.getGenericReturnType();
  }
  
  public Class<?> d()
  {
    return this.a.getReturnType();
  }
  
  public Method e()
  {
    return this.a;
  }
  
  public int f()
  {
    return l().length;
  }
  
  public final Object g()
    throws Exception
  {
    return this.a.invoke(null, new Object[0]);
  }
  
  public Class<?> h()
  {
    return this.a.getDeclaringClass();
  }
  
  public Member i()
  {
    return this.a;
  }
  
  public Type[] l()
  {
    return this.a.getGenericParameterTypes();
  }
  
  public Class<?>[] m()
  {
    if (this.c == null) {
      this.c = this.a.getParameterTypes();
    }
    return this.c;
  }
  
  public String n()
  {
    return h().getName() + "#" + b() + "(" + f() + " params)";
  }
  
  public String toString()
  {
    return "[method " + b() + ", annotations: " + this.b + "]";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/xl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */