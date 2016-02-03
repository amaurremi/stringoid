package com.google.android.gms.analytics;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

class g
  implements m
{
  private static g tD;
  private static Object tn = new Object();
  protected String tA;
  protected String tB;
  protected String tC;
  protected String tz;
  
  protected g() {}
  
  private g(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    this.tB = paramContext.getPackageName();
    this.tC = localPackageManager.getInstallerPackageName(this.tB);
    String str = this.tB;
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
    this.tz = ((String)localObject1);
    this.tA = paramContext;
  }
  
  public static g cp()
  {
    return tD;
  }
  
  public static void r(Context paramContext)
  {
    synchronized (tn)
    {
      if (tD == null) {
        tD = new g(paramContext);
      }
      return;
    }
  }
  
  public boolean J(String paramString)
  {
    return ("&an".equals(paramString)) || ("&av".equals(paramString)) || ("&aid".equals(paramString)) || ("&aiid".equals(paramString));
  }
  
  public String getValue(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      if (paramString.equals("&an")) {
        return this.tz;
      }
      if (paramString.equals("&av")) {
        return this.tA;
      }
      if (paramString.equals("&aid")) {
        return this.tB;
      }
    } while (!paramString.equals("&aiid"));
    return this.tC;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/analytics/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */