package com.gau.go.launcherex.gowidget.weather.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.CheckBox;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.model.q;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;

class ah
  extends BroadcastReceiver
{
  private ah(MainWidgetSetting paramMainWidgetSetting) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool2 = true;
    int k = 0;
    int i = 0;
    int j = 0;
    paramContext = e.a(paramContext.getApplicationContext()).a();
    this.a.b = paramContext.j;
    paramIntent = MainWidgetSetting.f(this.a);
    boolean bool1;
    label94:
    int m;
    if (this.a.b == 1)
    {
      bool1 = true;
      paramIntent.setChecked(bool1);
      this.a.c = paramContext.L;
      paramIntent = MainWidgetSetting.g(this.a);
      if (this.a.c != 1) {
        break label344;
      }
      bool1 = true;
      paramIntent.setChecked(bool1);
      this.a.a = paramContext.h;
      MainWidgetSetting.a(this.a, paramContext.i);
      m = MainWidgetSetting.a(this.a).length;
      if (MainWidgetSetting.h(this.a)) {
        break label364;
      }
      if (this.a.a == 0) {
        break label350;
      }
      this.a.a = 0;
      MainWidgetSetting.i(this.a).setChecked(false);
      MainWidgetSetting.e(this.a).k(this.a.a);
      MainWidgetSetting.e(this.a).a(WeatherContentProvider.g, "setting_key", "calendarType", "setting_value", this.a.a);
      label215:
      if (MainWidgetSetting.j(this.a)) {
        break label462;
      }
      i = k;
      if (MainWidgetSetting.d(this.a) == 0) {
        break label413;
      }
      MainWidgetSetting.a(this.a, 0);
      i = j;
    }
    for (;;)
    {
      if (i < m)
      {
        if (MainWidgetSetting.d(this.a) == MainWidgetSetting.a(this.a)[i])
        {
          MainWidgetSetting.c(this.a).setText(MainWidgetSetting.b(this.a)[i]);
          MainWidgetSetting.e(this.a).j(MainWidgetSetting.d(this.a));
          MainWidgetSetting.e(this.a).a(WeatherContentProvider.g, "setting_key", "festival", "setting_value", MainWidgetSetting.d(this.a));
        }
      }
      else
      {
        return;
        bool1 = false;
        break;
        label344:
        bool1 = false;
        break label94;
        label350:
        MainWidgetSetting.i(this.a).setChecked(false);
        break label215;
        label364:
        paramContext = MainWidgetSetting.i(this.a);
        if (this.a.a == 1) {}
        for (bool1 = bool2;; bool1 = false)
        {
          paramContext.setChecked(bool1);
          break;
        }
      }
      i += 1;
    }
    label413:
    do
    {
      i += 1;
      if (i >= m) {
        break;
      }
    } while (MainWidgetSetting.d(this.a) != MainWidgetSetting.a(this.a)[i]);
    MainWidgetSetting.c(this.a).setText(MainWidgetSetting.b(this.a)[i]);
    return;
    label462:
    do
    {
      i += 1;
      if (i >= m) {
        break;
      }
    } while (MainWidgetSetting.d(this.a) != MainWidgetSetting.a(this.a)[i]);
    MainWidgetSetting.c(this.a).setText(MainWidgetSetting.b(this.a)[i]);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */