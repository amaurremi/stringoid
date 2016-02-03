package com.venticake.retrica;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;

public class o
{
  public static String a()
  {
    return a(1);
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    case 4: 
    default: 
      return "unknown";
    case 1: 
      return "google";
    case 3: 
      return "intel";
    }
    return "amazon";
  }
  
  public static String b()
  {
    switch (1)
    {
    case 4: 
    default: 
      return "support+retricaandroid@bootstlab.com";
    case 5: 
      return "support+retricaandroid.amazon@bootstlab.com";
    }
    return "support+retricaandroid.intel@bootstlab.com";
  }
  
  public static String c()
  {
    return "258115874311602";
  }
  
  public static String d()
  {
    return "com.venticake.retrica";
  }
  
  public static String e()
  {
    return Build.BRAND;
  }
  
  public static String f()
  {
    return Build.MODEL;
  }
  
  public static String g()
  {
    try
    {
      Object localObject = MainActivity.a;
      localObject = ((Context)localObject).getPackageManager().getPackageInfo(((Context)localObject).getPackageName(), 0);
      return "Retrica " + ((PackageInfo)localObject).versionName;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    return "Retrica";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */