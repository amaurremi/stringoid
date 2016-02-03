package com.flurry.android.monolithic.sdk.impl;

import java.lang.reflect.Method;

public final class if
{
  private static final String a = if.class.getSimpleName();
  
  public static ih a()
  {
    try
    {
      ih localih = (ih)Class.forName("com.flurry.android.impl.ads.FlurryAdModule").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
      return localih;
    }
    catch (Exception localException)
    {
      ja.a(5, a, "FlurryAdModule is not available:", localException);
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/if.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */