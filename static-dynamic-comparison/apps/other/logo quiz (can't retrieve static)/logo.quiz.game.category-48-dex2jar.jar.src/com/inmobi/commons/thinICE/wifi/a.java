package com.inmobi.commons.thinICE.wifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;

final class a
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    try
    {
      paramContext = WifiScanner.a();
      paramIntent = (WifiManager)WifiScanner.c().getSystemService("wifi");
      WifiScanner.b();
      if (paramContext != null) {
        paramContext.onResultsReceived(paramIntent.getScanResults());
      }
      return;
    }
    catch (Exception paramContext) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/inmobi/commons/thinICE/wifi/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */