package com.flurry.android.monolithic.sdk.impl;

final class aaq
  extends aal
{
  private final Class<?> a;
  private final ra<Object> b;
  
  public aaq(Class<?> paramClass, ra<Object> paramra)
  {
    this.a = paramClass;
    this.b = paramra;
  }
  
  public aal a(Class<?> paramClass, ra<Object> paramra)
  {
    return new aam(this.a, this.b, paramClass, paramra);
  }
  
  public ra<Object> a(Class<?> paramClass)
  {
    if (paramClass == this.a) {
      return this.b;
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/aaq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */