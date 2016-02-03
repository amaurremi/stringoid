package com.flurry.android.monolithic.sdk.impl;

final class aam
  extends aal
{
  private final Class<?> a;
  private final Class<?> b;
  private final ra<Object> c;
  private final ra<Object> d;
  
  public aam(Class<?> paramClass1, ra<Object> paramra1, Class<?> paramClass2, ra<Object> paramra2)
  {
    this.a = paramClass1;
    this.c = paramra1;
    this.b = paramClass2;
    this.d = paramra2;
  }
  
  public aal a(Class<?> paramClass, ra<Object> paramra)
  {
    return new aao(new aar[] { new aar(this.a, this.c), new aar(this.b, this.d) });
  }
  
  public ra<Object> a(Class<?> paramClass)
  {
    if (paramClass == this.a) {
      return this.c;
    }
    if (paramClass == this.b) {
      return this.d;
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/aam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */