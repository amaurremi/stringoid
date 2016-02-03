package com.appfireworks.android.track;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class AppAutoReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Log.d("AppFireworks", "AppAutoReceiver onReceive - going to start Service");
    paramIntent = paramIntent.getExtras().getString("apikey");
    Intent localIntent = new Intent(paramContext, AppAutoService.class);
    localIntent.putExtra("apikey", paramIntent);
    paramContext.startService(localIntent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/appfireworks/android/track/AppAutoReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */