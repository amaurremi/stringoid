package com.appfireworks.android.track;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;

public class AppTrackerReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    try
    {
      String str = paramIntent.getStringExtra("referrer");
      paramIntent = str;
      if (str == null) {
        paramIntent = "referrer_null";
      }
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        paramIntent = "referrer_exception";
      }
    }
    Log.d("AppFireworks", "Referrer - " + paramIntent);
    paramContext = paramContext.getSharedPreferences("APPFIREWORKS", 0).edit();
    paramContext.putString("installreferrer", paramIntent);
    paramContext.commit();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/appfireworks/android/track/AppTrackerReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */