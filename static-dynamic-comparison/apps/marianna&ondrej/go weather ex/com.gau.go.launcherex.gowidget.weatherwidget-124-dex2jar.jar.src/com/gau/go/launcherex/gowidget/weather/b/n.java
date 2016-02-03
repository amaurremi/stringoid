package com.gau.go.launcherex.gowidget.weather.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.gau.go.launcherex.gowidget.weather.c.c;
import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.util.f;
import com.gau.go.launcherex.gowidget.weather.util.r;

class n
  extends BroadcastReceiver
{
  n(m paramm) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if (str.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DATA_READY"))
    {
      paramIntent = c.a(paramContext.getApplicationContext());
      if (paramIntent.h().e() > 0)
      {
        m.a(this.a, 2);
        if (r.c(paramContext))
        {
          m.a(this.a, 4);
          if (m.a(this.a) == 7) {
            m.a(this.a, paramContext);
          }
        }
        an.a(paramContext).a(paramIntent.f().a());
      }
    }
    do
    {
      do
      {
        return;
        m.b(this.a, 0);
        break;
      } while ((!str.equals("android.net.conn.CONNECTIVITY_CHANGE")) || (paramIntent.getBooleanExtra("noConnectivity", false)));
      m.a(this.a, 4);
    } while (m.a(this.a) != 7);
    m.a(this.a, paramContext);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/b/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */