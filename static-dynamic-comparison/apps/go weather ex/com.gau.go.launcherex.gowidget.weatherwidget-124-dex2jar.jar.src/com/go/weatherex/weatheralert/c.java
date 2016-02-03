package com.go.weatherex.weatheralert;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class c
  implements CompoundButton.OnCheckedChangeListener
{
  c(WeatherAlertActivity paramWeatherAlertActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = this.a;
    String str = WeatherAlertActivity.c(this.a);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      WeatherAlertActivity.a(paramCompoundButton, str, paramBoolean);
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/weatheralert/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */