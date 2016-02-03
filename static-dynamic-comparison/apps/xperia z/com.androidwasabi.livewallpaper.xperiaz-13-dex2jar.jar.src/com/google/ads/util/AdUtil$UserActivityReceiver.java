package com.google.ads.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AdUtil$UserActivityReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.intent.action.USER_PRESENT")) {
      AdUtil.a(true);
    }
    while (!paramIntent.getAction().equals("android.intent.action.SCREEN_OFF")) {
      return;
    }
    AdUtil.a(false);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/ads/util/AdUtil$UserActivityReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */