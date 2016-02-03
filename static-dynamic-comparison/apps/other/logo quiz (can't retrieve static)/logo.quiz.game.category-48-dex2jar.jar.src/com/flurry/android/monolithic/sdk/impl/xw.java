package com.flurry.android.monolithic.sdk.impl;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

@Deprecated
public class xw
  implements xz
{
  public boolean a(Method paramMethod)
  {
    if (Modifier.isStatic(paramMethod.getModifiers())) {
      return false;
    }
    switch (paramMethod.getParameterTypes().length)
    {
    default: 
      return false;
    case 1: 
      return true;
    }
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/xw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */