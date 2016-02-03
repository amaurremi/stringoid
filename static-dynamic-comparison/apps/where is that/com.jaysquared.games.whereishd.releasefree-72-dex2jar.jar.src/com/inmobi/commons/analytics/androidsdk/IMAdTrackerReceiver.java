package com.inmobi.commons.analytics.androidsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.inmobi.commons.analytics.iat.impl.AdTrackerUtils;
import com.inmobi.commons.analytics.iat.impl.net.AdTrackerNetworkInterface;
import com.inmobi.commons.internal.FileOperations;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import java.net.URLEncoder;

public class IMAdTrackerReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("com.android.vending.INSTALL_REFERRER")) {}
    while ((!paramIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) || (!InternalSDKUtil.checkNetworkAvailibility(paramContext))) {
      try
      {
        Log.debug("[InMobi]-[AdTracker]-4.1.1", "Received INSTALL REFERRER");
        paramIntent = paramIntent.getExtras().getString("referrer");
        Log.debug("[InMobi]-[AdTracker]-4.1.1", "Referrer String: " + paramIntent);
        FileOperations.setPreferences(paramContext.getApplicationContext(), "IMAdTrackerStatusUpload", "rfs", 1);
        paramIntent = URLEncoder.encode(paramIntent, "utf-8");
        AdTrackerUtils.setInternalReferrer(paramContext.getApplicationContext(), paramIntent);
        return;
      }
      catch (Exception paramContext)
      {
        Log.internal("[InMobi]-[AdTracker]-4.1.1", "Error install receiver", paramContext);
        return;
      }
    }
    try
    {
      Log.internal("[InMobi]-[AdTracker]-4.1.1", "Received CONNECTIVITY BROADCAST");
      AdTrackerNetworkInterface.init();
      AdTrackerNetworkInterface.reportToServer(FileOperations.getPreferences(paramContext.getApplicationContext(), "IMAdTrackerStatusUpload", "appId"));
      return;
    }
    catch (Exception paramContext)
    {
      Log.internal("[InMobi]-[AdTracker]-4.1.1", "Connectivity receiver exception", paramContext);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/analytics/androidsdk/IMAdTrackerReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */