package com.flurry.android.monolithic.sdk.impl;

import java.lang.reflect.Method;

public final class ii
{
  private static final String a = ii.class.getSimpleName();
  
  public static ik a()
  {
    try
    {
      ik localik = (ik)Class.forName("com.flurry.android.impl.appcloud.AppCloudModule").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
      return localik;
    }
    catch (Exception localException)
    {
      ja.a(5, a, "FlurryAdModule is not available:", localException);
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ii.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */