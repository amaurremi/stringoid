package com.flurry.android.monolithic.sdk.impl;

public abstract class abc<T>
  extends abt<T>
{
  protected abc(Class<T> paramClass)
  {
    super(paramClass);
  }
  
  protected abc(Class<?> paramClass, boolean paramBoolean)
  {
    super(paramClass, paramBoolean);
  }
  
  public abstract abc<?> a(rx paramrx);
  
  public abc<?> b(rx paramrx)
  {
    if (paramrx == null) {
      return this;
    }
    return a(paramrx);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/abc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */