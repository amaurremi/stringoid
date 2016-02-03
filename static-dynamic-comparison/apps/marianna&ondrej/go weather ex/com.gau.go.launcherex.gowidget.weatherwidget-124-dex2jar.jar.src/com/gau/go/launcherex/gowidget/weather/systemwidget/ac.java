package com.gau.go.launcherex.gowidget.weather.systemwidget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.gau.go.launcherex.gowidget.weather.util.e;
import com.gtp.a.a.b.c;
import java.util.ArrayList;

class ac
  extends BroadcastReceiver
{
  ac(ab paramab) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      paramContext = paramIntent.getAction();
      if (paramContext != null) {
        break label14;
      }
    }
    label14:
    int i;
    int j;
    int k;
    do
    {
      do
      {
        return;
        c.a("AppWidgetWeatherManager", "deal action:" + paramContext);
        if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.goweather.ACTION_UPDATE_DATA"))
        {
          ab.a(this.a, ab.a(this.a), paramIntent);
          return;
        }
        if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_ADD_CITY"))
        {
          ab.b(this.a);
          return;
        }
        if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DELETE_CITY"))
        {
          ab.c(this.a);
          return;
        }
        if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_LOCATION"))
        {
          ab.d(this.a);
          return;
        }
        if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_RELOAD_DATA"))
        {
          ab.e(this.a);
          return;
        }
      } while (!paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_CONVERT_INDEX_STATE"));
      i = paramIntent.getIntExtra("extra_convert_from_index", -1);
      j = paramIntent.getIntExtra("extra_convert_to_index", -1);
      if ((i < 0) || (j < 0) || (i == j)) {
        break;
      }
      k = ab.f(this.a).size();
    } while ((i >= k) || (j >= k));
    e.a(i, j, ab.f(this.a));
    ab.g(this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/systemwidget/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */