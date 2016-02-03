package com.mapbar.android.location;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import java.lang.reflect.Field;

public final class g
{
  public static String a = "2.0.110953";
  public static boolean b = true;
  public static String c;
  public static String d;
  public static String e;
  public static final int f;
  
  static
  {
    k = 3;
    i = k;
    try
    {
      int j = Integer.parseInt(Build.VERSION.SDK);
      i = j;
      k = j;
      Build.VERSION localVERSION = new Build.VERSION();
      i = j;
      k = j;
      Object localObject = localVERSION.getClass();
      i = j;
      if (localObject != null)
      {
        i = j;
        k = j;
        localObject = ((Class)localObject).getField("SDK_INT");
        i = j;
        if (localObject != null)
        {
          i = j;
          k = j;
          j = ((Field)localObject).getInt(localVERSION);
          i = j;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    catch (Error localError)
    {
      for (;;)
      {
        i = k;
      }
    }
    f = i;
  }
  
  public static String a(PackageManager paramPackageManager, String paramString)
  {
    String str = "";
    try
    {
      paramString = paramPackageManager.getApplicationInfo(paramString, 128);
      paramPackageManager = str;
      if (paramString != null) {
        paramPackageManager = paramString.metaData.getString("MAPBAR_APIKEY");
      }
      return paramPackageManager;
    }
    catch (Exception paramPackageManager)
    {
      Log.e("CellLocation", "Could not read apikey meta-data from AndroidManifest.xml.", paramPackageManager);
    }
    return "";
  }
  
  public static boolean a(String paramString)
  {
    if ((paramString != null) && (paramString.trim().length() > 0)) {}
    try
    {
      if ("SYSTEM".equals(c)) {
        return true;
      }
      paramString = new n(p.a(paramString));
      if ((paramString != null) && (paramString.a != null))
      {
        boolean bool = paramString.a.equalsIgnoreCase(c);
        if (bool) {
          break label71;
        }
      }
    }
    catch (Exception paramString)
    {
      for (;;) {}
    }
    return false;
    label71:
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/mapbar/android/location/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */