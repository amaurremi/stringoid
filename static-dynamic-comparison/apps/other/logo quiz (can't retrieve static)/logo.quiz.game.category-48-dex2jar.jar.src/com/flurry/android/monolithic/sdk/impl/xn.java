package com.flurry.android.monolithic.sdk.impl;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.lang.reflect.Type;

public final class xn
  extends xk
{
  protected final xo a;
  protected final Type c;
  protected final int d;
  
  public xn(xo paramxo, Type paramType, xp paramxp, int paramInt)
  {
    super(paramxp);
    this.a = paramxo;
    this.c = paramType;
    this.d = paramInt;
  }
  
  public xn a(xp paramxp)
  {
    if (paramxp == this.b) {
      return this;
    }
    return this.a.a(this.d, paramxp);
  }
  
  public <A extends Annotation> A a(Class<A> paramClass)
  {
    return this.b.a(paramClass);
  }
  
  public AnnotatedElement a()
  {
    return null;
  }
  
  public void a(Object paramObject1, Object paramObject2)
    throws UnsupportedOperationException
  {
    throw new UnsupportedOperationException("Cannot call setValue() on constructor parameter of " + h().getName());
  }
  
  public String b()
  {
    return "";
  }
  
  public Type c()
  {
    return this.c;
  }
  
  public Class<?> d()
  {
    if ((this.c instanceof Class)) {
      return (Class)this.c;
    }
    return adk.a().a(this.c).p();
  }
  
  public Type e()
  {
    return this.c;
  }
  
  public xo f()
  {
    return this.a;
  }
  
  public int g()
  {
    return this.d;
  }
  
  public Class<?> h()
  {
    return this.a.h();
  }
  
  public Member i()
  {
    return this.a.i();
  }
  
  public String toString()
  {
    return "[parameter #" + g() + ", annotations: " + this.b + "]";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/xn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */