package com.gau.go.launcherex.gowidget.weather.globaltheme.view.a;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.gau.go.launcherex.goweather.livewallpaper.b.h;
import com.gau.go.launcherex.gowidget.weather.c.c;
import com.gau.go.launcherex.gowidget.weather.d.f;
import com.gau.go.launcherex.gowidget.weather.globaltheme.b.e;

class k
  extends BroadcastReceiver
{
  k(g paramg) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DYNAMICBACKGROUND_LOAD_DONE".equals(paramContext)) || ("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DYNAMICBACKGROUND_LOAD_ALL_SCRIPT_DONE".equals(paramContext)))
    {
      g.a(this.a);
      if (g.c(this.a) != null)
      {
        if ((!g.c(this.a).t()) && (h.a(this.a.a.getApplicationContext()))) {
          Toast.makeText(this.a.a, 2131166418, 1).show();
        }
        if (this.a.b != null) {
          this.a.b.a(g.c(this.a));
        }
        g.d(this.a);
        g.c(this.a, null);
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (!"com.gau.go.launcherex.gowidget.weatherwidget.ACTION_THEME_PURCHASE_SUCCESS".equals(paramContext)) {
            break;
          }
          paramContext = paramIntent.getStringExtra("extra_purchase_theme_package_name");
        } while ((g.c(this.a) == null) || (!g.c(this.a).x().equals(paramContext)));
        g.c(this.a).d(true);
        this.a.a(g.c(this.a));
        return;
        if (!"com.gau.go.launcherex.gowidget.weatherwidget.PURCHASE_CHANGE".equals(paramContext)) {
          break;
        }
      } while ((g.c(this.a) == null) || (g.c(this.a).m()) || (!c.a(this.a.a.getApplicationContext()).e().b()));
      this.a.a(g.c(this.a));
      return;
    } while ((!"com.gau.go.launcherex.gowidget.weatherwidget.PRODUCT_THEME_VIP_PURCHASE_STATE_CHANGE_ACTION".equals(paramContext)) || (g.c(this.a) == null) || (g.c(this.a).m()) || (!c.a(this.a.a.getApplicationContext()).e().c()));
    this.a.a(g.c(this.a));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/globaltheme/view/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */