package com.jtpgodorncrqoeurl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class ReEngagement
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AdWakeLock.acquire(paramContext);
    AdLog.i("LBAdController", "Alarm triggered going to start service");
    paramIntent = paramIntent.getExtras().getString("sectionid");
    Intent localIntent = new Intent(paramContext, ReEngagementService.class);
    localIntent.putExtra("sectionid", paramIntent);
    paramContext.startService(localIntent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/jtpgodorncrqoeurl/ReEngagement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */