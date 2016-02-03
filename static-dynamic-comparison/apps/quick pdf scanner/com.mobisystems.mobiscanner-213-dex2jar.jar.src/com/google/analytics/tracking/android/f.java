package com.google.analytics.tracking.android;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

class f
  implements j
{
  private static f hS;
  private static Object hT = new Object();
  protected String hO;
  protected String hP;
  protected String hQ;
  protected String hR;
  
  protected f() {}
  
  private f(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    this.hQ = paramContext.getPackageName();
    this.hR = localPackageManager.getInstallerPackageName(this.hQ);
    String str = this.hQ;
    localObject2 = null;
    localObject1 = str;
    try
    {
      PackageInfo localPackageInfo = localPackageManager.getPackageInfo(paramContext.getPackageName(), 0);
      paramContext = (Context)localObject2;
      localObject1 = str;
      if (localPackageInfo != null)
      {
        localObject1 = str;
        paramContext = localPackageManager.getApplicationLabel(localPackageInfo.applicationInfo).toString();
        localObject1 = paramContext;
        str = localPackageInfo.versionName;
        localObject1 = paramContext;
        paramContext = str;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        v.A("Error retrieving package info: appName set to " + (String)localObject1);
        paramContext = (Context)localObject2;
      }
    }
    this.hO = ((String)localObject1);
    this.hP = paramContext;
  }
  
  public static void d(Context paramContext)
  {
    synchronized (hT)
    {
      if (hS == null) {
        hS = new f(paramContext);
      }
      return;
    }
  }
  
  public static f jr()
  {
    return hS;
  }
  
  public String getValue(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      if (paramString.equals("&an")) {
        return this.hO;
      }
      if (paramString.equals("&av")) {
        return this.hP;
      }
      if (paramString.equals("&aid")) {
        return this.hQ;
      }
    } while (!paramString.equals("&aiid"));
    return this.hR;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/analytics/tracking/android/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */