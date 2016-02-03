package com.gau.go.launcherex.gowidget.weather.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.weather.d.f;

class ai
  extends BroadcastReceiver
{
  private ai(MainWidgetSetting paramMainWidgetSetting) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null) {}
    while ((!paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.PURCHASE_CHANGE")) || (!GoWidgetApplication.b(this.a.getApplicationContext()).b()) || (MainWidgetSetting.l(this.a) == null) || (MainWidgetSetting.m(this.a) == null)) {
      return;
    }
    if (!MainWidgetSetting.m(this.a).isChecked())
    {
      MainWidgetSetting.m(this.a).setEnabled(true);
      MainWidgetSetting.m(this.a).setChecked(true);
    }
    MainWidgetSetting.n(this.a).setVisibility(8);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */