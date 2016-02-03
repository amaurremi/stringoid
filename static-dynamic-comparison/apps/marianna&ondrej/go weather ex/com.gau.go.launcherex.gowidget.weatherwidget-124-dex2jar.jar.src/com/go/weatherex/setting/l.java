package com.go.weatherex.setting;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.weather.d.f;

class l
  extends BroadcastReceiver
{
  private l(h paramh) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null) {}
    do
    {
      do
      {
        return;
        if (!paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.PURCHASE_CHANGE")) {
          break;
        }
      } while ((!GoWidgetApplication.b(h.l(this.a).getApplicationContext()).b()) || (h.q(this.a) == null) || (h.r(this.a) == null));
      if (!h.r(this.a).isChecked())
      {
        h.r(this.a).setEnabled(true);
        h.r(this.a).setChecked(true);
      }
      h.s(this.a).setVisibility(8);
      h.r(this.a).setVisibility(0);
      return;
      if ("com.gau.go.launcherex.gowidget.weatherwidget.action_calendar_binding_app".equals(paramContext))
      {
        h.a(this.a, paramIntent.getStringExtra("app_name"));
        h.b(this.a, paramIntent.getStringExtra("app_package_name"));
        return;
      }
    } while (!"com.gau.go.launcherex.gowidget.weatherwidget.action_clock_binding_app".equals(paramContext));
    h.c(this.a, paramIntent.getStringExtra("app_name"));
    h.d(this.a, paramIntent.getStringExtra("app_package_name"));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/setting/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */