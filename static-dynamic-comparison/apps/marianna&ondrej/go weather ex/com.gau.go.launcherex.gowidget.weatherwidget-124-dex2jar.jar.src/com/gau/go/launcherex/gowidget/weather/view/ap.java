package com.gau.go.launcherex.gowidget.weather.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.CheckBox;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.model.q;

class ap
  extends BroadcastReceiver
{
  private ap(Setting21Activity paramSetting21Activity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = 0;
    boolean bool2 = true;
    paramContext = Setting21Activity.b(this.a).a();
    this.a.d = paramContext.g;
    boolean bool1;
    label90:
    label129:
    label158:
    label178:
    int j;
    if (this.a.d == 1)
    {
      Setting21Activity.a(this.a).setText(Setting21Activity.f(this.a)[0]);
      this.a.a = paramContext.j;
      paramIntent = Setting21Activity.g(this.a);
      if (this.a.a != 1) {
        break label272;
      }
      bool1 = true;
      paramIntent.setChecked(bool1);
      this.a.c = paramContext.a;
      paramIntent = Setting21Activity.h(this.a);
      if (this.a.c != 1) {
        break label278;
      }
      bool1 = true;
      paramIntent.setChecked(bool1);
      if (!Setting21Activity.h(this.a).isChecked()) {
        break label284;
      }
      Setting21Activity.i(this.a).b();
      paramIntent = this.a;
      if (this.a.c != 1) {
        break label297;
      }
      bool1 = bool2;
      Setting21Activity.a(paramIntent, bool1);
      this.a.b = paramContext.e;
      j = Setting21Activity.c(this.a).length;
    }
    for (;;)
    {
      if (i < j)
      {
        if (this.a.b == Setting21Activity.c(this.a)[i]) {
          Setting21Activity.e(this.a).setText(Setting21Activity.d(this.a)[i]);
        }
      }
      else
      {
        return;
        Setting21Activity.a(this.a).setText(Setting21Activity.f(this.a)[1]);
        break;
        label272:
        bool1 = false;
        break label90;
        label278:
        bool1 = false;
        break label129;
        label284:
        Setting21Activity.i(this.a).a();
        break label158;
        label297:
        bool1 = false;
        break label178;
      }
      i += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */