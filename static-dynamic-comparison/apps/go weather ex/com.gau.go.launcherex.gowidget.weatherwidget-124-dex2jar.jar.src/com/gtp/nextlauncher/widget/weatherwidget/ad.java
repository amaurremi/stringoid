package com.gtp.nextlauncher.widget.weatherwidget;

import android.os.Handler;
import android.os.Message;

class ad
  extends Handler
{
  ad(WeatherIcon paramWeatherIcon) {}
  
  public void handleMessage(Message paramMessage)
  {
    WeatherIcon.access$002(this.a, false);
    if (!WeatherIcon.access$100(this.a)) {
      this.a.startZoom();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/nextlauncher/widget/weatherwidget/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */