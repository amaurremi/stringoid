package com.gau.go.launcherex.gowidget.weather.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.CheckBox;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.model.q;

class at
  extends BroadcastReceiver
{
  private at(Setting41Activity paramSetting41Activity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int j = 0;
    boolean bool2 = true;
    paramContext = Setting41Activity.b(this.a).a();
    this.a.d = paramContext.g;
    if (this.a.d == 1) {
      Setting41Activity.a(this.a).setText(Setting41Activity.h(this.a)[0]);
    }
    int k;
    int i;
    for (;;)
    {
      k = paramContext.k;
      int m = Setting41Activity.d(this.a).length;
      i = 0;
      while (i < m)
      {
        if (k == Setting41Activity.d(this.a)[i]) {
          Setting41Activity.a(this.a, i);
        }
        i += 1;
      }
      Setting41Activity.a(this.a).setText(Setting41Activity.h(this.a)[1]);
    }
    Setting41Activity.b(this.a, Setting41Activity.c(this.a));
    this.a.a = paramContext.j;
    paramIntent = Setting41Activity.i(this.a);
    boolean bool1;
    if (this.a.a == 1)
    {
      bool1 = true;
      paramIntent.setChecked(bool1);
      this.a.c = paramContext.a;
      paramIntent = Setting41Activity.j(this.a);
      if (this.a.c != 1) {
        break label350;
      }
      bool1 = true;
      label220:
      paramIntent.setChecked(bool1);
      if (!Setting41Activity.j(this.a).isChecked()) {
        break label356;
      }
      Setting41Activity.k(this.a).b();
      label249:
      paramIntent = this.a;
      if (this.a.c != 1) {
        break label369;
      }
      bool1 = bool2;
      label269:
      Setting41Activity.a(paramIntent, bool1);
      this.a.b = paramContext.e;
      k = Setting41Activity.e(this.a).length;
      i = j;
    }
    for (;;)
    {
      if (i < k)
      {
        if (this.a.b == Setting41Activity.e(this.a)[i]) {
          Setting41Activity.g(this.a).setText(Setting41Activity.f(this.a)[i]);
        }
      }
      else
      {
        return;
        bool1 = false;
        break;
        label350:
        bool1 = false;
        break label220;
        label356:
        Setting41Activity.k(this.a).a();
        break label249;
        label369:
        bool1 = false;
        break label269;
      }
      i += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */