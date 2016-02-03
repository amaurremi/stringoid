package com.gau.go.launcherex.gowidget.statistics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.google.analytics.tracking.android.AnalyticsReceiver;
import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.GAServiceManager;
import com.google.analytics.tracking.android.Tracker;

public class TrackerReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Log.i("ABEN", "TrackerReceiver");
    if ((paramIntent == null) || (paramIntent.getAction() == null)) {
      return;
    }
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = paramIntent.getStringExtra("referrer");
        if (localObject != null)
        {
          Log.i("ABEN", "campaign = " + (String)localObject);
          if ("com.android.vending.INSTALL_REFERRER".equals(paramIntent.getAction()))
          {
            Log.i("ABEN", "TrackerReceiver action match");
            localObject = paramIntent.getData();
            if (localObject != null)
            {
              if (((Uri)localObject).getQueryParameter("utm_source") == null) {
                break label186;
              }
              Log.i("ABEN", "TrackerReceiver utm_source = " + ((Uri)localObject).getPath());
              EasyTracker.getTracker().setCampaign(((Uri)localObject).getPath());
            }
          }
          Log.i("ABEN", "TrackerReceiver new AnalyticsReceiver");
          new AnalyticsReceiver().onReceive(paramContext, paramIntent);
          Log.i("ABEN", "TrackerReceiver dispatch");
          GAServiceManager.getInstance().dispatch();
          return;
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        return;
      }
      Log.i("ABEN", "campaign is null");
      continue;
      label186:
      if (((Uri)localObject).getQueryParameter("referrer") != null)
      {
        Log.i("ABEN", "TrackerReceiver referrer = " + ((Uri)localObject).getQueryParameter("referrer"));
        EasyTracker.getTracker().setReferrer(((Uri)localObject).getQueryParameter("referrer"));
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/statistics/TrackerReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */