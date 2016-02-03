package com.google.android.gms.analytics;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

class z
  implements af
{
  private static Object mL = new Object();
  private static z ns;
  protected String mo;
  protected String mp;
  protected String nq;
  protected String nr;
  
  protected z() {}
  
  private z(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    this.nq = paramContext.getPackageName();
    this.nr = localPackageManager.getInstallerPackageName(this.nq);
    String str = this.nq;
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
        j.Z("Error retrieving package info: appName set to " + (String)localObject1);
        paramContext = (Context)localObject2;
      }
    }
    this.mp = ((String)localObject1);
    this.mo = paramContext;
  }
  
  public static z lj()
  {
    return ns;
  }
  
  public static void q(Context paramContext)
  {
    synchronized (mL)
    {
      if (ns == null) {
        ns = new z(paramContext);
      }
      return;
    }
  }
  
  public String getValue(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      if (paramString.equals("&an")) {
        return this.mp;
      }
      if (paramString.equals("&av")) {
        return this.mo;
      }
      if (paramString.equals("&aid")) {
        return this.nq;
      }
    } while (!paramString.equals("&aiid"));
    return this.nr;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/analytics/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */