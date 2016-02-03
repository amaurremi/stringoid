package com.ideashower.readitlater.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.ideashower.readitlater.i.a;

public class OnAlarmReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("checkPause", false))
    {
      a.i();
      return;
    }
    b.a(paramContext, AlarmSyncService.class);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/service/OnAlarmReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */