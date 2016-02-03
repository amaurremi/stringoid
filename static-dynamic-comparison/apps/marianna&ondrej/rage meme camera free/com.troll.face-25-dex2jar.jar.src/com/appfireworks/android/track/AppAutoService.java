package com.appfireworks.android.track;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import com.appfireworks.android.util.AppLog;

public class AppAutoService
  extends Service
{
  private void startSync(Intent paramIntent)
  {
    AppTracker.setApiKey(paramIntent.getExtras().getString("apikey"));
    AppTracker.sync(getApplicationContext());
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    Log.d("AppFireworks", "AppAutoService onBind");
    return null;
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    AppLog.enableLog(true);
    Log.d("AppFireworks", "AppAutoService onStart - going to start sync");
    startSync(paramIntent);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppLog.enableLog(true);
    Log.d("AppFireworks", "AppAutoService onStartCommand - going to start sync");
    startSync(paramIntent);
    return 3;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/appfireworks/android/track/AppAutoService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */