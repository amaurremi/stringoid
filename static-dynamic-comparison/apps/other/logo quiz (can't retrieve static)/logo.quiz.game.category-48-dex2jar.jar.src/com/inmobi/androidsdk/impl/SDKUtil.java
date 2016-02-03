package com.inmobi.androidsdk.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.util.Log;
import com.inmobi.androidsdk.IMBrowserActivity;
import com.inmobi.commons.uid.UIDHelper;
import java.util.Iterator;
import java.util.List;

public class SDKUtil
{
  public static final String BROWSER_ACTIVITY = "com.inmobi.androidsdk.IMBrowserActivity";
  public static final long DEFAULT_SLOTID = -1L;
  private static boolean a = false;
  
  public static boolean getQAMode()
  {
    return a;
  }
  
  public static Activity getRootActivity(Activity paramActivity)
  {
    while (paramActivity.getParent() != null) {
      paramActivity = paramActivity.getParent();
    }
    return paramActivity;
  }
  
  private static void setQAMode(boolean paramBoolean)
  {
    a = paramBoolean;
  }
  
  public static void validateAdConfiguration(Context paramContext)
    throws ConfigException
  {
    if (paramContext.checkCallingOrSelfPermission("android.permission.INTERNET") != 0)
    {
      Log.e("InMobiAndroidSDK_3.7.1", "App does not have INTERNET permissions. Please provide INTERNET permissions");
      throw new ConfigException(-1);
    }
    if (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0)
    {
      Log.e("InMobiAndroidSDK_3.7.1", "App does not have ACCESS_NETWORK_STATE permissions. Please provide ACCESS_NETWORK_STATE permissions");
      throw new ConfigException(-9);
    }
    Iterator localIterator = paramContext.getPackageManager().queryIntentActivities(new Intent(paramContext, IMBrowserActivity.class), 65536).iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      paramContext = (ResolveInfo)localIterator.next();
    } while (!paramContext.activityInfo.name.contentEquals("com.inmobi.androidsdk.IMBrowserActivity"));
    for (;;)
    {
      if (paramContext == null)
      {
        Log.e("InMobiAndroidSDK_3.7.1", "IMBrowserActivity not declared in the manifest. Please declare it in the app manifest");
        throw new ConfigException(-2);
      }
      int i = paramContext.activityInfo.configChanges;
      if (i == 0)
      {
        Log.e("InMobiAndroidSDK_3.7.1", "IMBrowserActivity in the manifest does not have android:configChanges attributes.Please add android:configChanges=keyboardHidden|orientation|keyboard|screenSize|smallestScreenSize to IMBrowserActivity in the app manifest");
        throw new ConfigException(-3);
      }
      if ((i & 0x10) == 0)
      {
        Log.e("InMobiAndroidSDK_3.7.1", "Missing Config keyboard from android:configChangesof IMBRowserActivity");
        throw new ConfigException(-4);
      }
      if ((i & 0x20) == 0)
      {
        Log.e("InMobiAndroidSDK_3.7.1", "Missing Config keyboardHidden from android:configChangesof IMBRowserActivity");
        throw new ConfigException(-5);
      }
      if ((i & 0x80) == 0)
      {
        Log.e("InMobiAndroidSDK_3.7.1", "Missing Config orientation from android:configChangesof IMBRowserActivity");
        throw new ConfigException(-6);
      }
      if (Build.VERSION.SDK_INT >= 13)
      {
        if ((i & 0x400) == 0)
        {
          Log.e("InMobiAndroidSDK_3.7.1", "Missing Config screenSize from android:configChangesof IMBRowserActivity");
          throw new ConfigException(-7);
        }
        if ((i & 0x800) == 0)
        {
          Log.e("InMobiAndroidSDK_3.7.1", "Missing Config smallestScreenSize from android:configChanges of IMBRowserActivity");
          throw new ConfigException(-8);
        }
      }
      return;
      paramContext = null;
    }
  }
  
  public static void validateAppID(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("APP ID cannot be null");
    }
    if (paramString.trim().equalsIgnoreCase("")) {
      throw new IllegalArgumentException("APP ID cannot be empty.Please provide a valid APP ID. If APP ID is declared in the layout XML, please provide a valid 'appId' attribute in the 'com.inmobi.androidsdk.IMAdView' tag of layout XML. For example, appId=\"yourAppId\"");
    }
    UIDHelper.setIMAppId(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/inmobi/androidsdk/impl/SDKUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */