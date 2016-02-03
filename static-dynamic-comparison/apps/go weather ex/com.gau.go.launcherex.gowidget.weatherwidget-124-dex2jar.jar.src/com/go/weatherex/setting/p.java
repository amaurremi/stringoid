package com.go.weatherex.setting;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.gau.go.launcherex.gowidget.weather.c.c;
import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.d.f;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;

class p
  extends BroadcastReceiver
{
  private p(m paramm) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    while (!paramIntent.getAction().equals("com.gau.go.launcherex.gowidget.weatherwidget.PURCHASE_CHANGE")) {
      return;
    }
    paramContext = c.a(this.a.getActivity().getApplicationContext());
    if (paramContext.e().b()) {
      paramContext.f().a(WeatherContentProvider.g, "setting_key", "world_clock", "setting_value", "1");
    }
    m.a(this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/setting/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */