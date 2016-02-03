package com.gtp.nextlauncher.widget.weatherwidget;

import android.os.Handler;
import android.os.Message;

class ai
  extends Handler
{
  ai(WeatherTrendView paramWeatherTrendView) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    WeatherTrendView.access$100(this.a)[i].setVisibility(0);
    if (!WeatherTrendView.access$100(this.a)[i].isNoData()) {
      WeatherTrendView.access$100(this.a)[i].startAnimating(WeatherTrendView.access$300(this.a), WeatherTrendView.access$400(this.a), true);
    }
    for (;;)
    {
      if (i < 5) {
        WeatherTrendView.access$500(this.a).sendEmptyMessageDelayed(i + 1, 50L);
      }
      return;
      WeatherTrendView.access$100(this.a)[i].updateLastWeatherMark();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/nextlauncher/widget/weatherwidget/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */