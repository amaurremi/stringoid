package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;

@rz
public class abp<T>
  extends abt<T>
{
  public abp(Class<?> paramClass)
  {
    super(paramClass, false);
  }
  
  public void a(T paramT, or paramor, ru paramru)
    throws IOException, oq
  {
    paramor.d(paramT.toString());
  }
  
  public void a(T paramT, or paramor, ru paramru, rx paramrx)
    throws IOException, oz
  {
    paramrx.a(paramT, paramor);
    a(paramT, paramor, paramru);
    paramrx.d(paramT, paramor);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/abp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */