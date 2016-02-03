package com.google.analytics.tracking.android;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.common.util.VisibleForTesting;

class AppFieldsDefaultProvider
  implements DefaultProvider
{
  private static AppFieldsDefaultProvider sInstance;
  private static Object sInstanceLock = new Object();
  protected String mAppId;
  protected String mAppInstallerId;
  protected String mAppName;
  protected String mAppVersion;
  
  @VisibleForTesting
  protected AppFieldsDefaultProvider() {}
  
  private AppFieldsDefaultProvider(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    this.mAppId = paramContext.getPackageName();
    this.mAppInstallerId = localPackageManager.getInstallerPackageName(this.mAppId);
    String str2 = this.mAppId;
    localObject = null;
    str1 = str2;
    try
    {
      PackageInfo localPackageInfo = localPackageManager.getPackageInfo(paramContext.getPackageName(), 0);
      str1 = str2;
      paramContext = (Context)localObject;
      if (localPackageInfo != null)
      {
        str1 = str2;
        str2 = localPackageManager.getApplicationLabel(localPackageInfo.applicationInfo).toString();
        str1 = str2;
        paramContext = localPackageInfo.versionName;
        str1 = str2;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        Log.e("Error retrieving package info: appName set to " + str1);
        paramContext = (Context)localObject;
      }
    }
    this.mAppName = str1;
    this.mAppVersion = paramContext;
  }
  
  @VisibleForTesting
  static void dropInstance()
  {
    synchronized (sInstanceLock)
    {
      sInstance = null;
      return;
    }
  }
  
  public static AppFieldsDefaultProvider getProvider()
  {
    return sInstance;
  }
  
  public static void initializeProvider(Context paramContext)
  {
    synchronized (sInstanceLock)
    {
      if (sInstance == null) {
        sInstance = new AppFieldsDefaultProvider(paramContext);
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
        return this.mAppName;
      }
      if (paramString.equals("&av")) {
        return this.mAppVersion;
      }
      if (paramString.equals("&aid")) {
        return this.mAppId;
      }
    } while (!paramString.equals("&aiid"));
    return this.mAppInstallerId;
  }
  
  public boolean providesField(String paramString)
  {
    return ("&an".equals(paramString)) || ("&av".equals(paramString)) || ("&aid".equals(paramString)) || ("&aiid".equals(paramString));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/analytics/tracking/android/AppFieldsDefaultProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */