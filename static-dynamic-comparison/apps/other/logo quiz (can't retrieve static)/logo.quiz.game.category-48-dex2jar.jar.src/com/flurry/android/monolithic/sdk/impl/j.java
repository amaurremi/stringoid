package com.flurry.android.monolithic.sdk.impl;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ComponentName;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.SparseArray;
import android.util.SparseIntArray;

public final class j
{
  private static final String a = j.class.getSimpleName();
  private static final SparseArray<SparseIntArray> b = c();
  
  @TargetApi(9)
  public static int a()
  {
    int i = 1;
    if (Build.VERSION.SDK_INT >= 9) {
      i = 7;
    }
    return i;
  }
  
  @TargetApi(13)
  public static int a(ActivityInfo paramActivityInfo)
  {
    int i;
    if (paramActivityInfo == null) {
      i = 0;
    }
    int j;
    do
    {
      return i;
      j = paramActivityInfo.configChanges;
      i = j;
    } while (paramActivityInfo.applicationInfo.targetSdkVersion >= 13);
    return j | 0xC00;
  }
  
  public static ActivityInfo a(Activity paramActivity)
  {
    if (paramActivity == null) {
      return null;
    }
    return a(paramActivity.getPackageManager(), paramActivity.getComponentName());
  }
  
  public static ActivityInfo a(PackageManager paramPackageManager, ComponentName paramComponentName)
  {
    if ((paramPackageManager == null) || (paramComponentName == null)) {
      return null;
    }
    try
    {
      paramPackageManager = paramPackageManager.getActivityInfo(paramComponentName, 0);
      return paramPackageManager;
    }
    catch (PackageManager.NameNotFoundException paramPackageManager)
    {
      ja.a(5, a, "cannot find info for activity: " + paramComponentName);
    }
    return null;
  }
  
  public static void a(Activity paramActivity, int paramInt)
  {
    if (paramActivity != null) {
      paramActivity.setRequestedOrientation(paramInt);
    }
  }
  
  public static boolean a(Activity paramActivity, int paramInt, boolean paramBoolean)
  {
    boolean bool = true;
    if (paramActivity == null) {
      bool = false;
    }
    do
    {
      return bool;
      int i = paramInt;
      if (!b(paramActivity))
      {
        i = b(paramActivity, paramInt);
        if (-1 == i)
        {
          ja.a(5, a, "cannot set requested orientation without restarting activity, requestedOrientation = " + paramInt);
          ja.b(a, "cannot set requested orientation without restarting activity. It is recommended to add keyboardHidden|orientation|screenSize for android:configChanges attribute for activity: " + paramActivity.getComponentName().getClassName());
          return false;
        }
        paramBoolean = true;
      }
      paramActivity.setRequestedOrientation(i);
    } while (paramBoolean);
    paramActivity.setRequestedOrientation(-1);
    return true;
  }
  
  @TargetApi(9)
  public static int b()
  {
    int i = 0;
    if (Build.VERSION.SDK_INT >= 9) {
      i = 6;
    }
    return i;
  }
  
  public static int b(Activity paramActivity, int paramInt)
  {
    if (paramActivity == null) {
      return -1;
    }
    int i = paramActivity.getResources().getConfiguration().orientation;
    paramActivity = (SparseIntArray)b.get(i);
    if (paramActivity != null) {}
    for (paramInt = paramActivity.get(paramInt, -1);; paramInt = -1) {
      return paramInt;
    }
  }
  
  public static boolean b(Activity paramActivity)
  {
    int i = a(a(paramActivity));
    if ((i & 0x80) == 0) {}
    while ((i & 0x400) == 0) {
      return false;
    }
    return true;
  }
  
  private static SparseArray<SparseIntArray> c()
  {
    SparseArray localSparseArray = new SparseArray();
    localSparseArray.put(1, d());
    localSparseArray.put(2, e());
    return localSparseArray;
  }
  
  @TargetApi(9)
  private static SparseIntArray d()
  {
    int i = a();
    SparseIntArray localSparseIntArray = new SparseIntArray();
    localSparseIntArray.put(-1, i);
    localSparseIntArray.put(2, i);
    localSparseIntArray.put(3, i);
    localSparseIntArray.put(4, i);
    localSparseIntArray.put(1, 1);
    localSparseIntArray.put(5, 5);
    localSparseIntArray.put(7, 7);
    localSparseIntArray.put(9, 9);
    localSparseIntArray.put(10, 7);
    return localSparseIntArray;
  }
  
  @TargetApi(9)
  private static SparseIntArray e()
  {
    int i = b();
    SparseIntArray localSparseIntArray = new SparseIntArray();
    localSparseIntArray.put(-1, i);
    localSparseIntArray.put(2, i);
    localSparseIntArray.put(3, i);
    localSparseIntArray.put(4, i);
    localSparseIntArray.put(0, 0);
    localSparseIntArray.put(5, 5);
    localSparseIntArray.put(6, 6);
    localSparseIntArray.put(8, 8);
    localSparseIntArray.put(10, 6);
    return localSparseIntArray;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */