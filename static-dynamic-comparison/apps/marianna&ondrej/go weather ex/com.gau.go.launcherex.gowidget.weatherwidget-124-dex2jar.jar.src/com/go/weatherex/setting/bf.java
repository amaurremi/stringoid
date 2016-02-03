package com.go.weatherex.setting;

import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.globalview.a;
import com.gau.go.launcherex.gowidget.weather.globalview.i;
import com.gau.go.launcherex.gowidget.weather.globalview.m;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.gau.go.launcherex.gowidget.weather.util.f;
import java.util.ArrayList;
import java.util.Iterator;

class bf
  implements m
{
  bf(bb parambb) {}
  
  public void a(i parami, boolean paramBoolean, ArrayList paramArrayList)
  {
    int i;
    WeatherBean localWeatherBean;
    if (paramBoolean)
    {
      parami = new StringBuffer("");
      Iterator localIterator1 = bb.d(this.a).d().iterator();
      i = 0;
      if (localIterator1.hasNext())
      {
        localWeatherBean = (WeatherBean)localIterator1.next();
        Iterator localIterator2 = paramArrayList.iterator();
        do
        {
          if (!localIterator2.hasNext()) {
            break;
          }
        } while (!((String)((a)localIterator2.next()).c).equals(localWeatherBean.c()));
      }
    }
    for (int j = 1;; j = 0)
    {
      if (j == 0)
      {
        if (i > 0) {
          parami.append("#");
        }
        parami.append(localWeatherBean.c());
        i += 1;
      }
      for (;;)
      {
        break;
        parami = parami.toString();
        bb.a(this.a).a(parami);
        bb.a(this.a).a(WeatherContentProvider.g, "setting_key", "no_notify_temp_change_cities", "setting_value", parami);
        return;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/setting/bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */