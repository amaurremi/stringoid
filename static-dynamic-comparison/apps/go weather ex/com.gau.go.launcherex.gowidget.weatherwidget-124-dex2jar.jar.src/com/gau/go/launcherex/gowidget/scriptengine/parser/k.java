package com.gau.go.launcherex.gowidget.scriptengine.parser;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.gau.go.launcherex.gowidget.weather.globaltheme.c.d;

class k
  extends BroadcastReceiver
{
  private k(i parami) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = 1;
    if (paramIntent == null) {}
    for (;;)
    {
      return;
      if ("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APP_THEME_CHANGE".equals(paramIntent.getAction()))
      {
        paramIntent = paramIntent.getStringExtra("extra_app_theme_package");
        if (d.a(paramIntent))
        {
          i.a(this.a, paramIntent);
          paramContext = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_BACKGROUND_CHANGE_FINISH");
          i.d(this.a).sendBroadcast(paramContext);
        }
        while (i != 0)
        {
          paramContext = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DYNAMICBACKGROUND_LOAD_ALL_SCRIPT_DONE");
          i.d(this.a).sendBroadcast(paramContext);
          return;
          if (!i.g(this.a).equals(paramIntent))
          {
            i.a(this.a, paramIntent);
            i.i(this.a);
            this.a.b(paramContext);
            i = 0;
          }
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/scriptengine/parser/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */