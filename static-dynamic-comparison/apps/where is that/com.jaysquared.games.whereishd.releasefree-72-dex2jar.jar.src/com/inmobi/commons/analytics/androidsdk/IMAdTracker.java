package com.inmobi.commons.analytics.androidsdk;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import com.inmobi.commons.analytics.iat.impl.AdTrackerUtils;
import com.inmobi.commons.analytics.iat.impl.GoalList;
import com.inmobi.commons.analytics.iat.impl.net.AdTrackerNetworkInterface;
import com.inmobi.commons.internal.FileOperations;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;

public final class IMAdTracker
{
  private static IMAdTracker a;
  
  private boolean a(String paramString)
  {
    try
    {
      String str = FileOperations.getPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "appId");
      if ((InternalSDKUtil.getContext() == null) || (str == null) || (str.trim().equals("")))
      {
        Log.debug("[InMobi]-[AdTracker]-4.1.1", "Please call init() with valid context and app id");
        return false;
      }
      if ((paramString == null) || ("".equals(paramString.trim())))
      {
        Log.debug("[InMobi]-[AdTracker]-4.1.1", "Please pass a valid GoalName");
        return false;
      }
      boolean bool = AdTrackerUtils.checkDownloadGoalUploaded();
      if (("download".equals(paramString)) && (true == bool))
      {
        Log.debug("[InMobi]-[AdTracker]-4.1.1", "Download goal already uploaded");
        return false;
      }
      AdTrackerNetworkInterface.init();
      if ("download".equals(paramString)) {
        if (!AdTrackerUtils.checkDownloadGoalAdded())
        {
          FileOperations.setPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "insertStatus", true);
          Log.debug("[InMobi]-[AdTracker]-4.1.1", "Goal Queued " + paramString);
          AdTrackerNetworkInterface.getGoalList().addGoal(paramString, 1, 0L, 0, false);
        }
      }
      for (;;)
      {
        AdTrackerNetworkInterface.reportToServer(str);
        return true;
        Log.debug("[InMobi]-[AdTracker]-4.1.1", "Goal Queued " + paramString);
        AdTrackerNetworkInterface.getGoalList().addGoal(paramString, 1, 0L, 0, false);
      }
      return false;
    }
    catch (Exception paramString)
    {
      Log.internal("[InMobi]-[AdTracker]-4.1.1", "Cannot report goal", paramString);
    }
  }
  
  public static IMAdTracker getInstance()
  {
    try
    {
      if (a == null) {
        a = new IMAdTracker();
      }
      IMAdTracker localIMAdTracker = a;
      return localIMAdTracker;
    }
    finally {}
  }
  
  public void init(Context paramContext, String paramString)
  {
    if (paramContext == null) {}
    try
    {
      Log.debug("[InMobi]-[AdTracker]-4.1.1", "Application Context NULL");
      Log.debug("[InMobi]-[AdTracker]-4.1.1", "context cannot be null");
      return;
    }
    catch (Exception paramContext)
    {
      Log.internal("[InMobi]-[AdTracker]-4.1.1", "Failed to init", paramContext);
      return;
    }
    if (paramString == null)
    {
      Log.debug("[InMobi]-[AdTracker]-4.1.1", "APP ID Cannot be NULL");
      Log.debug("[InMobi]-[AdTracker]-4.1.1", "appId cannot be null");
      return;
    }
    if (paramString.trim().equals(""))
    {
      Log.debug("[InMobi]-[AdTracker]-4.1.1", "appId cannot be blank");
      return;
    }
    Log.debug("[InMobi]-[AdTracker]-4.1.1", "IMAdtracker init successfull");
    FileOperations.setPreferences(paramContext, "IMAdTrackerStatusUpload", "appId", paramString);
    if ((!AdTrackerUtils.isPermissionGranted("android.permission.INTERNET")) || (!AdTrackerUtils.isPermissionGranted("android.permission.ACCESS_NETWORK_STATE")))
    {
      Log.debug("[InMobi]-[AdTracker]-4.1.1", "Add android.permission.INTERNET and android.permission.ACCESS_NETWORK_STATE permission in Android manifest");
      return;
    }
    if ((Build.VERSION.SDK_INT < 17) && (!AdTrackerUtils.isPermissionGranted("android.permission.READ_LOGS"))) {
      Log.debug("[InMobi]-[AdTracker]-4.1.1", "Add android.permission.READ_LOGS permission in Android Manifest");
    }
    if (0L == FileOperations.getLongPreferences(paramContext.getApplicationContext(), "IMAdTrackerStatusUpload", "t1")) {
      FileOperations.setPreferences(paramContext.getApplicationContext(), "IMAdTrackerStatusUpload", "t1", System.currentTimeMillis());
    }
    paramString = new IntentFilter();
    paramString.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    paramString.addAction("com.android.vending.INSTALL_REFERRER");
    paramContext.getApplicationContext().registerReceiver(new IMAdTrackerReceiver(), paramString);
  }
  
  public void reportAppDownloadGoal()
  {
    a("download");
  }
  
  public void reportCustomGoal(String paramString)
  {
    if ("download".equals(paramString))
    {
      Log.debug("[InMobi]-[AdTracker]-4.1.1", "Download Goal should be reported using reportAppDownloadGoal()..");
      return;
    }
    a(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/analytics/androidsdk/IMAdTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */