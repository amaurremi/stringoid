package com.flurry.android.monolithic.sdk.impl;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;

@Deprecated
public final class xv
  extends xw
{
  public boolean a(Method paramMethod)
  {
    if (super.a(paramMethod)) {}
    do
    {
      return true;
      if (!adz.a(paramMethod)) {
        return false;
      }
      paramMethod = paramMethod.getReturnType();
    } while ((Collection.class.isAssignableFrom(paramMethod)) || (Map.class.isAssignableFrom(paramMethod)));
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/xv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */