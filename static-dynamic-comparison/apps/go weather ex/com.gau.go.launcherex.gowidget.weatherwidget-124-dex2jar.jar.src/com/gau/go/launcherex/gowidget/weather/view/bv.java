package com.gau.go.launcherex.gowidget.weather.view;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class bv
  extends Handler
{
  private WeakReference a;
  
  public bv(WeakReference paramWeakReference)
  {
    this.a = paramWeakReference;
  }
  
  public void handleMessage(Message paramMessage)
  {
    paramMessage = (WeatherLouverView)this.a.get();
    if (paramMessage != null)
    {
      WeatherLouverView.a(paramMessage);
      if (!WeatherLouverView.b(paramMessage)) {
        break label35;
      }
      WeatherLouverView.c(paramMessage);
    }
    for (;;)
    {
      paramMessage.invalidate();
      return;
      label35:
      sendEmptyMessageDelayed(0, 30L);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/bv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */