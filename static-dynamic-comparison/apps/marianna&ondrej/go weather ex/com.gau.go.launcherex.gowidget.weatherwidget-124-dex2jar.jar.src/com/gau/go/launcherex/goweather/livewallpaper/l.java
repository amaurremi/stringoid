package com.gau.go.launcherex.goweather.livewallpaper;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.gau.go.launcherex.goweather.livewallpaper.a.c;
import com.gau.go.launcherex.goweather.livewallpaper.a.e;
import com.gau.go.launcherex.goweather.livewallpaper.b.b;
import com.gau.go.launcherex.goweather.livewallpaper.b.h;
import com.gau.go.launcherex.gowidget.weather.c.g;

class l
  extends BroadcastReceiver
{
  l(k paramk) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (!k.a(this.a))
    {
      paramContext = paramIntent.getAction();
      if (!paramContext.equals("android.intent.action.TIME_TICK")) {
        break label33;
      }
      k.a(this.a, false);
    }
    label33:
    do
    {
      return;
      if ((paramContext.equals("android.intent.action.TIME_SET")) || (paramContext.equals("android.intent.action.TIMEZONE_CHANGED")))
      {
        k.b(this.a).a();
        k.a(this.a, true);
        return;
      }
      if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.goweather.ACTION_UPDATE_DATA"))
      {
        k.a(this.a, 3, k.c(this.a).b());
        return;
      }
      if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_TEMPERATURE_UNIT"))
      {
        k.b(this.a, 5, "tempUnit");
        return;
      }
      if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_WIND_UNIT"))
      {
        k.b(this.a, 6, "windUnit");
        return;
      }
      if (paramContext.equals("android.intent.action.USER_PRESENT"))
      {
        k.e(this.a).a(k.d(this.a).b(), k.d(this.a).c());
        return;
      }
      if (paramContext.equals("android.intent.action.SCREEN_OFF"))
      {
        k.e(this.a).b(k.d(this.a).b(), k.d(this.a).c(), h.d(k.f(this.a)));
        return;
      }
      if ((paramContext.equals("android.intent.action.TIME_SET")) || (paramContext.equals("android.intent.action.TIMEZONE_CHANGED")) || (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_WORLD_CLOCK")))
      {
        k.b(this.a, 7, "world_clock");
        return;
      }
      if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_LIVE_WALLPAPER_SETTINGS_CHANGE"))
      {
        k.g(this.a);
        return;
      }
      if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_LIVE_WALLPAPER_THEME_CHANGE"))
      {
        k.b(this.a, 8, "key_live_wallpaper_theme");
        return;
      }
      if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_USER_LANGUAGE_CHANGED"))
      {
        k.h(this.a).a(this.a);
        return;
      }
      if (paramContext.equals("android.intent.action.LOCALE_CHANGED"))
      {
        k.h(this.a).i();
        k.j(this.a).c(k.c(this.a), k.i(this.a), k.h(this.a).a());
        return;
      }
    } while (!paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_AUTO_LOCATION"));
    k.b(this.a, 13, "auto_location");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/goweather/livewallpaper/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */