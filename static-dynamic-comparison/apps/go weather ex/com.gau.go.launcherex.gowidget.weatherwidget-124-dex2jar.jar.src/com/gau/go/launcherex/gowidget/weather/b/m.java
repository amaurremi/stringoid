package com.gau.go.launcherex.gowidget.weather.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.RequestBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.util.f;
import java.util.ArrayList;

public class m
{
  private int a;
  private Context b;
  private BroadcastReceiver c = new n(this);
  
  public m(Context paramContext)
  {
    this.b = paramContext;
    paramContext = new IntentFilter();
    paramContext.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DATA_READY");
    paramContext.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    this.b.registerReceiver(this.c, paramContext);
  }
  
  private void a(Context paramContext)
  {
    ArrayList localArrayList1 = f.a(paramContext).f();
    ArrayList localArrayList2 = new ArrayList();
    int j = localArrayList1.size();
    int i = 0;
    while (i < j)
    {
      WeatherBean localWeatherBean = (WeatherBean)localArrayList1.get(i);
      RequestBean localRequestBean = new RequestBean();
      localRequestBean.a(localWeatherBean.c(), localWeatherBean.d(), localWeatherBean.k.g());
      localArrayList2.add(localRequestBean);
      i += 1;
    }
    an.a(paramContext).a(localArrayList2, 2);
    this.a = 0;
    b();
  }
  
  private void b()
  {
    this.b.unregisterReceiver(this.c);
  }
  
  public void a()
  {
    this.a |= 0x1;
    if (this.a == 7) {
      a(this.b);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/b/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */