package com.gau.go.launcherex.goweather.goplay;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

class p
  extends BroadcastReceiver
{
  private p(n paramn) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.intent.action.PACKAGE_ADDED"))
    {
      paramContext = paramIntent.getDataString();
      boolean bool = paramIntent.getBooleanExtra("android.intent.extra.REPLACING", false);
      if ((!TextUtils.isEmpty(paramContext)) && (!bool))
      {
        paramContext = paramContext.replace("package:", "");
        n.a(this.a, paramContext);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/goweather/goplay/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */