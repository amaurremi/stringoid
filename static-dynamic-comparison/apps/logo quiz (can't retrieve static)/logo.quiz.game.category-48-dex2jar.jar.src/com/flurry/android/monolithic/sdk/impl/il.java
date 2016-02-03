package com.flurry.android.monolithic.sdk.impl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;

public final class il
{
  private static final String a = il.class.getSimpleName();
  
  public static PackageInfo a(Context paramContext)
  {
    PackageInfo localPackageInfo = null;
    if (paramContext != null) {}
    try
    {
      localPackageInfo = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 20815);
      return localPackageInfo;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      ja.a(a, "Cannot find package info for package: " + paramContext.getPackageName());
    }
    return null;
  }
  
  public static ApplicationInfo b(Context paramContext)
  {
    ApplicationInfo localApplicationInfo = null;
    if (paramContext != null) {}
    try
    {
      localApplicationInfo = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      return localApplicationInfo;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      ja.a(a, "Cannot find application info for package: " + paramContext.getPackageName());
    }
    return null;
  }
  
  public static String c(Context paramContext)
  {
    paramContext = a(paramContext);
    if ((paramContext != null) && (paramContext.packageName != null)) {
      return paramContext.packageName;
    }
    return "";
  }
  
  public static String d(Context paramContext)
  {
    paramContext = a(paramContext);
    if ((paramContext != null) && (paramContext.versionName != null)) {
      return paramContext.versionName;
    }
    return "";
  }
  
  public static Bundle e(Context paramContext)
  {
    paramContext = b(paramContext);
    if ((paramContext != null) && (paramContext.metaData != null)) {
      return paramContext.metaData;
    }
    return Bundle.EMPTY;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/il.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */