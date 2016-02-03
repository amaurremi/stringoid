package com.gau.go.launcherex.gowidget.weather.view.gl;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class b
  extends Handler
{
  private WeakReference a;
  
  public b(WeakReference paramWeakReference)
  {
    this.a = paramWeakReference;
  }
  
  public void handleMessage(Message paramMessage)
  {
    paramMessage = (GLWeatherLouverView)this.a.get();
    if (paramMessage != null)
    {
      GLWeatherLouverView.access$000(paramMessage);
      if (!GLWeatherLouverView.access$100(paramMessage)) {
        break label35;
      }
      GLWeatherLouverView.access$200(paramMessage);
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/gl/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */