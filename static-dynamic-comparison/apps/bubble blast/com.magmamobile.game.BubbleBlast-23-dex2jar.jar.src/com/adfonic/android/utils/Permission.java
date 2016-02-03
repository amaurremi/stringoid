package com.adfonic.android.utils;

import android.content.Context;
import android.content.pm.PackageManager;

public class Permission
{
  public static boolean hasCoarseLocationAccess(Context paramContext)
  {
    return paramContext.getPackageManager().checkPermission("android.permission.ACCESS_COARSE_LOCATION", paramContext.getPackageName()) == 0;
  }
  
  public static boolean hasFineGrainLocationAccess(Context paramContext)
  {
    return paramContext.getPackageManager().checkPermission("android.permission.ACCESS_FINE_LOCATION", paramContext.getPackageName()) == 0;
  }
  
  public static boolean hasNetworkStateAccess(Context paramContext)
  {
    return paramContext.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", paramContext.getPackageName()) == 0;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/adfonic/android/utils/Permission.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */