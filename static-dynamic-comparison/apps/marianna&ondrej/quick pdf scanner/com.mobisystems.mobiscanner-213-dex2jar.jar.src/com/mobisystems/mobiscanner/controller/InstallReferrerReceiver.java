package com.mobisystems.mobiscanner.controller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import com.google.android.gms.analytics.CampaignTrackingReceiver;
import com.mobisystems.mobiscanner.common.CommonPreferences.Keys;
import java.io.PrintStream;

public class InstallReferrerReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Object localObject1;
    Object localObject2;
    int j;
    int i;
    if (paramIntent != null)
    {
      localObject1 = paramIntent.getExtras();
      if (localObject1 != null)
      {
        localObject1 = ((Bundle)localObject1).getString("referrer", "");
        System.out.println("InstallReferrerReceiver onReceive referrerString = " + (String)localObject1);
        localObject2 = ((String)localObject1).split("&");
        j = localObject2.length;
        i = 0;
      }
    }
    for (;;)
    {
      if (i < j)
      {
        localObject1 = localObject2[i].split("=");
        if ("utm_source".equals(localObject1[0]))
        {
          localObject2 = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
          ((SharedPreferences.Editor)localObject2).putString(CommonPreferences.Keys.aqb.getKey(), localObject1[1]);
          ((SharedPreferences.Editor)localObject2).commit();
        }
      }
      else
      {
        new CampaignTrackingReceiver().onReceive(paramContext, paramIntent);
        return;
      }
      i += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/InstallReferrerReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */