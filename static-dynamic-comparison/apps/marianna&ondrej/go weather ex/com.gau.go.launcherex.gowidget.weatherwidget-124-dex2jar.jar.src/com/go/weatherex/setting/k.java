package com.go.weatherex.setting;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.CheckBox;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.model.q;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;

class k
  extends BroadcastReceiver
{
  private k(h paramh) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool2 = true;
    int k = 0;
    int i = 0;
    int j = 0;
    paramContext = e.a(paramContext.getApplicationContext()).a();
    this.a.b = paramContext.j;
    paramIntent = h.f(this.a);
    boolean bool1;
    label94:
    int m;
    if (this.a.b == 1)
    {
      bool1 = true;
      paramIntent.setChecked(bool1);
      this.a.c = paramContext.L;
      paramIntent = h.g(this.a);
      if (this.a.c != 1) {
        break label344;
      }
      bool1 = true;
      paramIntent.setChecked(bool1);
      this.a.a = paramContext.h;
      h.a(this.a, paramContext.i);
      m = h.a(this.a).length;
      if (h.h(this.a)) {
        break label364;
      }
      if (this.a.a == 0) {
        break label350;
      }
      this.a.a = 0;
      h.i(this.a).setChecked(false);
      h.e(this.a).k(this.a.a);
      h.e(this.a).a(WeatherContentProvider.g, "setting_key", "calendarType", "setting_value", this.a.a);
      label215:
      if (h.j(this.a)) {
        break label462;
      }
      i = k;
      if (h.d(this.a) == 0) {
        break label413;
      }
      h.a(this.a, 0);
      i = j;
    }
    for (;;)
    {
      if (i < m)
      {
        if (h.d(this.a) == h.a(this.a)[i])
        {
          h.c(this.a).setText(h.b(this.a)[i]);
          h.e(this.a).j(h.d(this.a));
          h.e(this.a).a(WeatherContentProvider.g, "setting_key", "festival", "setting_value", h.d(this.a));
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
        h.i(this.a).setChecked(false);
        break label215;
        label364:
        paramContext = h.i(this.a);
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
    } while (h.d(this.a) != h.a(this.a)[i]);
    h.c(this.a).setText(h.b(this.a)[i]);
    return;
    label462:
    do
    {
      i += 1;
      if (i >= m) {
        break;
      }
    } while (h.d(this.a) != h.a(this.a)[i]);
    h.c(this.a).setText(h.b(this.a)[i]);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/setting/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */