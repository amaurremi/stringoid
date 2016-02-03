package com.jtpgodorncrqoeurl;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.IBinder;

public class ReEngagementService
  extends Service
{
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (paramIntent != null) {}
    try
    {
      paramIntent = paramIntent.getExtras().getString("sectionid");
      AdLog.d("LBAdController", "Service startReEngagement = " + paramIntent);
      SharedPreferences.Editor localEditor = getApplicationContext().getSharedPreferences("Preference", 0).edit();
      localEditor.putBoolean("reengagementalarm", true);
      localEditor.commit();
      new AdController(getApplicationContext(), paramIntent).loadReEngagement();
      AdWakeLock.release();
      return 1;
    }
    catch (Exception paramIntent)
    {
      paramIntent = paramIntent;
      AdWakeLock.release();
      return 1;
    }
    finally
    {
      paramIntent = finally;
      AdWakeLock.release();
      throw paramIntent;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/jtpgodorncrqoeurl/ReEngagementService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */