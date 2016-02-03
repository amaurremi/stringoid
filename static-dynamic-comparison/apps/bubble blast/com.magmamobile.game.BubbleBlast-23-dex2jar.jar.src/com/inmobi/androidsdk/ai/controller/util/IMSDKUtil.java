package com.inmobi.androidsdk.ai.controller.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.util.Log;
import com.inmobi.androidsdk.IMBrowserActivity;
import com.inmobi.commons.IMCommonUtil;
import java.util.Iterator;
import java.util.List;

public class IMSDKUtil
{
  public static final String BROWSER_ACTIVITY = "com.inmobi.androidsdk.IMBrowserActivity";
  public static final long DEFAULT_SLOTID = -1L;
  
  public static Activity getRootActivity(Activity paramActivity)
  {
    for (;;)
    {
      if (paramActivity.getParent() == null) {
        return paramActivity;
      }
      paramActivity = paramActivity.getParent();
    }
  }
  
  public static void validateAdConfiguration(Context paramContext)
    throws IMConfigException
  {
    if (!"3.6.1".equalsIgnoreCase(IMCommonUtil.getReleaseVersion()))
    {
      Log.e("InMobiAndroidSDK_3.6.1", "SDK Bundle mismatch. InMobiAdNetwork version : 3.6.1, InMobiCommons version : 3.6.1.Please add InMobiAdNetwork and InMobiCommons SDK jars from the latest bundle");
      throw new RuntimeException("SDK Bundle mismatch. InMobiAdNetwork version : 3.6.1, InMobiCommons version : 3.6.1.Please add InMobiAdNetwork and InMobiCommons SDK jars from the latest bundle");
    }
    if (paramContext.checkCallingOrSelfPermission("android.permission.INTERNET") != 0)
    {
      Log.e("InMobiAndroidSDK_3.6.1", "App does not have INTERNET permissions. Please provide INTERNET permissions");
      throw new IMConfigException(-1);
    }
    Iterator localIterator = paramContext.getPackageManager().queryIntentActivities(new Intent(paramContext, IMBrowserActivity.class), 65536).iterator();
    if (!localIterator.hasNext()) {
      paramContext = null;
    }
    for (;;)
    {
      if (paramContext != null) {
        break label141;
      }
      Log.e("InMobiAndroidSDK_3.6.1", "IMBrowserActivity not declared in the manifest. Please declare it in the app manifest");
      throw new IMConfigException(-2);
      paramContext = (ResolveInfo)localIterator.next();
      if (!paramContext.activityInfo.name.contentEquals("com.inmobi.androidsdk.IMBrowserActivity")) {
        break;
      }
    }
    label141:
    int i = paramContext.activityInfo.configChanges;
    if (i == 0)
    {
      Log.e("InMobiAndroidSDK_3.6.1", "IMBrowserActivity in the manifest does not have android:configChanges attributes.Please add android:configChanges=keyboardHidden|orientation|keyboard|screenSize|smallestScreenSize to IMBrowserActivity in the app manifest");
      throw new IMConfigException(-3);
    }
    if ((i & 0x10) == 0)
    {
      Log.e("InMobiAndroidSDK_3.6.1", "Missing Config keyboard from android:configChangesof IMBRowserActivity");
      throw new IMConfigException(-4);
    }
    if ((i & 0x20) == 0)
    {
      Log.e("InMobiAndroidSDK_3.6.1", "Missing Config keyboardHidden from android:configChangesof IMBRowserActivity");
      throw new IMConfigException(-5);
    }
    if ((i & 0x80) == 0)
    {
      Log.e("InMobiAndroidSDK_3.6.1", "Missing Config orientation from android:configChangesof IMBRowserActivity");
      throw new IMConfigException(-6);
    }
    if (Build.VERSION.SDK_INT >= 13)
    {
      if ((i & 0x400) == 0)
      {
        Log.e("InMobiAndroidSDK_3.6.1", "Missing Config screenSize from android:configChangesof IMBRowserActivity");
        throw new IMConfigException(-7);
      }
      if ((i & 0x800) == 0)
      {
        Log.e("InMobiAndroidSDK_3.6.1", "Missing Config smallestScreenSize from android:configChanges of IMBRowserActivity");
        throw new IMConfigException(-8);
      }
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
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/inmobi/androidsdk/ai/controller/util/IMSDKUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */