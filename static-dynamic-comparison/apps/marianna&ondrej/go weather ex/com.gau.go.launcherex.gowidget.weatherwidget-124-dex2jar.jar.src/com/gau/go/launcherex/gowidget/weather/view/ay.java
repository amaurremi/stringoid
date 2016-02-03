package com.gau.go.launcherex.gowidget.weather.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.CheckBox;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.model.q;

class ay
  extends BroadcastReceiver
{
  private ay(Setting42Activity paramSetting42Activity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int j = 0;
    boolean bool2 = true;
    paramContext = Setting42Activity.b(this.a).a();
    this.a.c = paramContext.g;
    if (this.a.c == 1) {
      Setting42Activity.a(this.a).setText(Setting42Activity.l(this.a)[0]);
    }
    int k;
    int i;
    for (;;)
    {
      k = paramContext.k;
      int m = Setting42Activity.d(this.a).length;
      i = 0;
      while (i < m)
      {
        if (k == Setting42Activity.d(this.a)[i]) {
          Setting42Activity.a(this.a, i);
        }
        i += 1;
      }
      Setting42Activity.a(this.a).setText(Setting42Activity.l(this.a)[1]);
    }
    Setting42Activity.b(this.a, Setting42Activity.c(this.a));
    this.a.d = paramContext.h;
    paramIntent = Setting42Activity.m(this.a);
    boolean bool1;
    if (this.a.d == 1)
    {
      bool1 = true;
      paramIntent.setChecked(bool1);
      this.a.e = paramContext.j;
      paramIntent = Setting42Activity.n(this.a);
      if (this.a.e != 1) {
        break label457;
      }
      bool1 = true;
      label220:
      paramIntent.setChecked(bool1);
      this.a.b = paramContext.a;
      paramIntent = Setting42Activity.o(this.a);
      if (this.a.b != 1) {
        break label463;
      }
      bool1 = true;
      label259:
      paramIntent.setChecked(bool1);
      if (!Setting42Activity.o(this.a).isChecked()) {
        break label469;
      }
      Setting42Activity.p(this.a).b();
      label288:
      paramIntent = this.a;
      if (this.a.b != 1) {
        break label482;
      }
      bool1 = bool2;
      label308:
      Setting42Activity.a(paramIntent, bool1);
      this.a.a = paramContext.e;
      k = Setting42Activity.e(this.a).length;
      i = 0;
      label337:
      if (i < k)
      {
        if (this.a.a != Setting42Activity.e(this.a)[i]) {
          break label488;
        }
        Setting42Activity.g(this.a).setText(Setting42Activity.f(this.a)[i]);
      }
      Setting42Activity.c(this.a, paramContext.i);
      k = Setting42Activity.h(this.a).length;
      i = j;
    }
    for (;;)
    {
      if (i < k)
      {
        if (Setting42Activity.k(this.a) == Setting42Activity.h(this.a)[i]) {
          Setting42Activity.j(this.a).setText(Setting42Activity.i(this.a)[i]);
        }
      }
      else
      {
        return;
        bool1 = false;
        break;
        label457:
        bool1 = false;
        break label220;
        label463:
        bool1 = false;
        break label259;
        label469:
        Setting42Activity.p(this.a).a();
        break label288;
        label482:
        bool1 = false;
        break label308;
        label488:
        i += 1;
        break label337;
      }
      i += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */