package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;

public abstract class abq<T>
  extends abt<T>
{
  protected abq(Class<T> paramClass)
  {
    super(paramClass);
  }
  
  protected abq(Class<?> paramClass, boolean paramBoolean)
  {
    super(paramClass);
  }
  
  public void a(T paramT, or paramor, ru paramru, rx paramrx)
    throws IOException, oq
  {
    paramrx.a(paramT, paramor);
    a(paramT, paramor, paramru);
    paramrx.d(paramT, paramor);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/abq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */