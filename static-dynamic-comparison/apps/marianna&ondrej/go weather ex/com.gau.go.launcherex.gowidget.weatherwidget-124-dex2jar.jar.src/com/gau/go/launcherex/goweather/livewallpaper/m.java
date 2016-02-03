package com.gau.go.launcherex.goweather.livewallpaper;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.gau.go.launcherex.goweather.livewallpaper.a.c;
import com.gau.go.launcherex.goweather.livewallpaper.b.f;

class m
  extends BroadcastReceiver
{
  m(k paramk) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = 0;
    if (!k.a(this.a))
    {
      paramContext = paramIntent.getAction();
      if (!paramContext.equals("android.intent.action.MEDIA_SCANNER_FINISHED")) {
        break label43;
      }
      k.a(this.a, 1);
      k.k(this.a);
    }
    for (;;)
    {
      return;
      label43:
      if (!paramContext.equals("android.intent.action.MEDIA_UNMOUNTED")) {
        continue;
      }
      paramContext = k.f(this.a).getPackageManager();
      try
      {
        paramContext.getApplicationInfo(k.d(this.a).e(), 0);
        if (i == 0) {
          continue;
        }
        k.l(this.a).a(k.f(this.a).getPackageName());
        return;
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
          i = 1;
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/goweather/livewallpaper/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */