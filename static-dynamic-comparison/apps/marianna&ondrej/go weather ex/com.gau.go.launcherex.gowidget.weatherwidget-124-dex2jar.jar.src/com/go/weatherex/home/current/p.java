package com.go.weatherex.home.current;

import android.view.View;
import android.view.View.OnClickListener;
import com.gau.go.launcherex.gowidget.weather.util.r;

class p
  implements View.OnClickListener
{
  p(CurrentWeatherContent paramCurrentWeatherContent) {}
  
  public void onClick(View paramView)
  {
    if (r.a(paramView)) {
      CurrentWeatherContent.b(this.a).f(CurrentWeatherContent.a(this.a));
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/current/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */