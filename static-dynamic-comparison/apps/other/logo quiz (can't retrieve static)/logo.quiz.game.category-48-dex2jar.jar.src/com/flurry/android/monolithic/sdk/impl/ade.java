package com.flurry.android.monolithic.sdk.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ade
{
  protected final Type a;
  protected final Class<?> b;
  protected final ParameterizedType c;
  protected ade d;
  protected ade e;
  
  public ade(Type paramType)
  {
    this.a = paramType;
    if ((paramType instanceof Class))
    {
      this.b = ((Class)paramType);
      this.c = null;
      return;
    }
    if ((paramType instanceof ParameterizedType))
    {
      this.c = ((ParameterizedType)paramType);
      this.b = ((Class)this.c.getRawType());
      return;
    }
    throw new IllegalArgumentException("Type " + paramType.getClass().getName() + " can not be used to construct HierarchicType");
  }
  
  private ade(Type paramType, Class<?> paramClass, ParameterizedType paramParameterizedType, ade paramade1, ade paramade2)
  {
    this.a = paramType;
    this.b = paramClass;
    this.c = paramParameterizedType;
    this.d = paramade1;
    this.e = paramade2;
  }
  
  public ade a()
  {
    if (this.d == null) {}
    for (ade localade1 = null;; localade1 = this.d.a())
    {
      ade localade2 = new ade(this.a, this.b, this.c, localade1, null);
      if (localade1 != null) {
        localade1.b(localade2);
      }
      return localade2;
    }
  }
  
  public void a(ade paramade)
  {
    this.d = paramade;
  }
  
  public final ade b()
  {
    return this.d;
  }
  
  public void b(ade paramade)
  {
    this.e = paramade;
  }
  
  public final boolean c()
  {
    return this.c != null;
  }
  
  public final ParameterizedType d()
  {
    return this.c;
  }
  
  public final Class<?> e()
  {
    return this.b;
  }
  
  public String toString()
  {
    if (this.c != null) {
      return this.c.toString();
    }
    return this.b.getName();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ade.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */