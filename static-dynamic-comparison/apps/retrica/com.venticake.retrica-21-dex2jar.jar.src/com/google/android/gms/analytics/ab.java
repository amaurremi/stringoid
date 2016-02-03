package com.google.android.gms.analytics;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

class ab
  implements ag
{
  private static ab e;
  private static Object f = new Object();
  protected String a;
  protected String b;
  protected String c;
  protected String d;
  
  protected ab() {}
  
  private ab(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    this.c = paramContext.getPackageName();
    this.d = localPackageManager.getInstallerPackageName(this.c);
    String str = this.c;
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
        aa.A("Error retrieving package info: appName set to " + (String)localObject1);
        paramContext = (Context)localObject2;
      }
    }
    this.a = ((String)localObject1);
    this.b = paramContext;
  }
  
  public static ab a()
  {
    return e;
  }
  
  public static void a(Context paramContext)
  {
    synchronized (f)
    {
      if (e == null) {
        e = new ab(paramContext);
      }
      return;
    }
  }
  
  public String a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      if (paramString.equals("&an")) {
        return this.a;
      }
      if (paramString.equals("&av")) {
        return this.b;
      }
      if (paramString.equals("&aid")) {
        return this.c;
      }
    } while (!paramString.equals("&aiid"));
    return this.d;
  }
  
  public boolean b(String paramString)
  {
    return ("&an".equals(paramString)) || ("&av".equals(paramString)) || ("&aid".equals(paramString)) || ("&aiid".equals(paramString));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/analytics/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */