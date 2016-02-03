package com.flurry.android.monolithic.sdk.impl;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

public class ir
{
  private static final String a = ir.class.getSimpleName();
  private static String b;
  private static String c;
  
  public static String a()
  {
    if (!TextUtils.isEmpty(b)) {
      return b;
    }
    if (!TextUtils.isEmpty(c)) {
      return c;
    }
    c = b();
    return c;
  }
  
  public static void a(String paramString)
  {
    b = paramString;
  }
  
  private static String b()
  {
    try
    {
      Object localObject = ia.a().b();
      localObject = ((Context)localObject).getPackageManager().getPackageInfo(((Context)localObject).getPackageName(), 0);
      if (((PackageInfo)localObject).versionName != null) {
        return ((PackageInfo)localObject).versionName;
      }
      if (((PackageInfo)localObject).versionCode != 0)
      {
        localObject = Integer.toString(((PackageInfo)localObject).versionCode);
        return (String)localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      ja.a(6, a, "", localThrowable);
    }
    return "Unknown";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ir.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */