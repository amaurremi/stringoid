package com.flurry.android.monolithic.sdk.impl;

import java.util.HashMap;

public final class aas
{
  protected final aaj a;
  protected final aau b = new aau(getClass(), false);
  
  private aas(aaj paramaaj)
  {
    this.a = paramaaj;
  }
  
  public static aas a(HashMap<aau, ra<Object>> paramHashMap)
  {
    return new aas(new aaj(paramHashMap));
  }
  
  public aas a()
  {
    return new aas(this.a);
  }
  
  public ra<Object> a(afm paramafm)
  {
    this.b.a(paramafm);
    return this.a.a(this.b);
  }
  
  public ra<Object> a(Class<?> paramClass)
  {
    this.b.a(paramClass);
    return this.a.a(this.b);
  }
  
  public ra<Object> b(afm paramafm)
  {
    this.b.b(paramafm);
    return this.a.a(this.b);
  }
  
  public ra<Object> b(Class<?> paramClass)
  {
    this.b.b(paramClass);
    return this.a.a(this.b);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/aas.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */