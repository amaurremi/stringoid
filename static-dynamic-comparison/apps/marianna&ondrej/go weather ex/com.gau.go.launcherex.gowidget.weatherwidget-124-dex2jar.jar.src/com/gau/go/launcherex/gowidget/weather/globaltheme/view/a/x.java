package com.gau.go.launcherex.gowidget.weather.globaltheme.view.a;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.gau.go.launcherex.gowidget.weather.c.c;
import com.gau.go.launcherex.gowidget.weather.d.f;
import com.gau.go.launcherex.gowidget.weather.globaltheme.b.e;

class x
  extends BroadcastReceiver
{
  private x(s params) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_THEME_PURCHASE_SUCCESS".equals(paramContext))
    {
      paramContext = paramIntent.getStringExtra("extra_purchase_theme_package_name");
      if ((s.e(this.a) != null) && (s.e(this.a).x().equals(paramContext)))
      {
        s.e(this.a).d(true);
        this.a.a(s.e(this.a));
      }
    }
    do
    {
      do
      {
        return;
        if (!"com.gau.go.launcherex.gowidget.weatherwidget.PURCHASE_CHANGE".equals(paramContext)) {
          break;
        }
      } while ((s.e(this.a) == null) || (s.e(this.a).m()) || (!c.a(this.a.a.getApplicationContext()).e().b()));
      this.a.a(s.e(this.a));
      return;
    } while ((!"com.gau.go.launcherex.gowidget.weatherwidget.PRODUCT_THEME_VIP_PURCHASE_STATE_CHANGE_ACTION".equals(paramContext)) || (s.e(this.a) == null) || (s.e(this.a).m()) || (!c.a(this.a.a.getApplicationContext()).e().c()));
    this.a.a(s.e(this.a));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/globaltheme/view/a/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */