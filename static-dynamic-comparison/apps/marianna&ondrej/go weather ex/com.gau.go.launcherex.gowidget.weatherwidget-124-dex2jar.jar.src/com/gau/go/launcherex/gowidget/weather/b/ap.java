package com.gau.go.launcherex.gowidget.weather.b;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.RequestBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.util.f;
import java.util.ArrayList;

public class ap
{
  private aq a;
  private ConnectivityManager b;
  private Context c;
  
  public ap(Context paramContext)
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.SCREEN_ON");
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DATA_READY");
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    this.a = new aq(this);
    paramContext.registerReceiver(this.a, localIntentFilter);
    this.b = ((ConnectivityManager)paramContext.getSystemService("connectivity"));
    this.c = paramContext;
  }
  
  private void b()
  {
    Object localObject = f.a(this.c);
    ArrayList localArrayList = new ArrayList();
    localObject = ((f)localObject).f();
    int j = ((ArrayList)localObject).size();
    if (j > 0)
    {
      int i = 0;
      while (i < j)
      {
        WeatherBean localWeatherBean = (WeatherBean)((ArrayList)localObject).get(i);
        RequestBean localRequestBean = new RequestBean();
        localRequestBean.a(localWeatherBean.c(), localWeatherBean.d(), localWeatherBean.k.g());
        localArrayList.add(localRequestBean);
        i += 1;
      }
      an.a(this.c).a(localArrayList, 22, 4);
    }
  }
  
  public void a()
  {
    this.c.unregisterReceiver(this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/b/ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */