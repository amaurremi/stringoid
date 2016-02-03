package com.ideashower.readitlater.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.ideashower.readitlater.h.a;
import com.ideashower.readitlater.h.i;

public class BootReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (("android.intent.action.BOOT_COMPLETED".equals(paramIntent.getAction())) && (i.a(a.a) != null)) {
      b.a(paramContext);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/service/BootReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */