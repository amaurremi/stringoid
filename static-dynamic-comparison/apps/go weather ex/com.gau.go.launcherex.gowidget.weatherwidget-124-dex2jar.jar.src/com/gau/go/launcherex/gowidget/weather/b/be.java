package com.gau.go.launcherex.gowidget.weather.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.d.f;
import com.gau.go.launcherex.gowidget.weather.model.q;

class be
  extends BroadcastReceiver
{
  be(bd parambd) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool1 = true;
    paramContext = paramIntent.getAction();
    if (paramContext == null) {}
    do
    {
      return;
      if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DATA_READY"))
      {
        this.a.a();
        return;
      }
    } while (!paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.PURCHASE_CHANGE"));
    com.gtp.a.a.b.c.a("Remind Handler", "收到付费状态改变广播");
    paramContext = com.gau.go.launcherex.gowidget.weather.c.c.a(this.a.a.getApplicationContext());
    boolean bool2 = paramContext.e().b();
    paramContext = paramContext.f().a();
    paramIntent = this.a;
    if ((paramContext.u == 1) && (bool2)) {}
    for (;;)
    {
      bd.a(paramIntent, bool1);
      return;
      bool1 = false;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/b/be.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */