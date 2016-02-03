package com.jaysquared.games.whereishd.utils;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Build.VERSION;
import java.lang.reflect.Field;

public class SystemHelper
{
  private static final String LOG_TAG = SystemHelper.class.getSimpleName();
  
  @TargetApi(11)
  public static int getMaxHeapSize(Context paramContext)
  {
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    int j = paramContext.getMemoryClass();
    if (Build.VERSION.SDK_INT >= 13) {}
    for (int i = paramContext.getLargeMemoryClass();; i = 0)
    {
      SLog.v(LOG_TAG, "Max heap normal: " + j + "MB, max heap large: " + i + "MB");
      return Math.max(j, i);
    }
  }
  
  public static int getVersionCode(Context paramContext)
  {
    try
    {
      int i = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode;
      return i;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      SLog.e(LOG_TAG, "Error getting package info: " + paramContext.getLocalizedMessage());
    }
    return -1;
  }
  
  public static boolean isTablet(Context paramContext)
  {
    paramContext = paramContext.getResources().getConfiguration();
    int i = 1;
    try
    {
      int j = paramContext.getClass().getDeclaredField("screenLayout").getInt(paramContext);
      i = j;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        SLog.e(LOG_TAG, "Error while checking if tablet: " + paramContext.getLocalizedMessage());
      }
    }
    return (i & 0xF) >= 3;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jaysquared/games/whereishd/utils/SystemHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */