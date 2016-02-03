package com.inmobi.commons.data;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;

public class AppInfo
{
  private static String a;
  private static String b;
  private static String c;
  private static String d;
  
  private static void a(String paramString)
  {
    b = paramString;
  }
  
  private static void b(String paramString)
  {
    a = paramString;
  }
  
  private static void c(String paramString)
  {
    c = paramString;
  }
  
  public static void fillAppInfo()
  {
    try
    {
      Object localObject1 = InternalSDKUtil.getContext();
      Object localObject2 = ((Context)localObject1).getPackageManager();
      Object localObject3 = ((PackageManager)localObject2).getApplicationInfo(((Context)localObject1).getPackageName(), 128);
      if (localObject3 != null)
      {
        b(((ApplicationInfo)localObject3).packageName);
        a(((ApplicationInfo)localObject3).loadLabel((PackageManager)localObject2).toString());
      }
      localObject3 = ((PackageManager)localObject2).getPackageInfo(((Context)localObject1).getPackageName(), 128);
      localObject1 = null;
      if (localObject3 != null)
      {
        localObject2 = ((PackageInfo)localObject3).versionName;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (!((String)localObject2).equals("")) {}
        }
        else
        {
          localObject1 = ((PackageInfo)localObject3).versionCode + "";
        }
      }
      if ((localObject1 != null) && (!((String)localObject1).equals(""))) {
        c((String)localObject1);
      }
      return;
    }
    catch (Exception localException)
    {
      Log.internal("[InMobi]-4.1.1", "Failed to fill AppInfo", localException);
    }
  }
  
  public static String getAppBId()
  {
    return a;
  }
  
  public static String getAppDisplayName()
  {
    return b;
  }
  
  public static String getAppId()
  {
    return d;
  }
  
  public static String getAppVer()
  {
    return c;
  }
  
  public static void setAppId(String paramString)
  {
    d = paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/data/AppInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */