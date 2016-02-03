package com.gau.go.launcherex.gowidget.weather.dynamicbackground;

import android.os.Handler;
import android.os.Message;
import com.jiubang.core.a.f;
import java.lang.ref.WeakReference;

class a
  extends Handler
{
  private WeakReference a;
  
  public a(DynamicBackgroundView paramDynamicBackgroundView)
  {
    this.a = new WeakReference(paramDynamicBackgroundView);
  }
  
  public void handleMessage(Message paramMessage)
  {
    DynamicBackgroundView localDynamicBackgroundView = (DynamicBackgroundView)this.a.get();
    if (localDynamicBackgroundView == null) {}
    do
    {
      int i;
      do
      {
        return;
        i = paramMessage.what;
        if (i == 1)
        {
          DynamicBackgroundView.a(localDynamicBackgroundView);
          return;
        }
      } while (i != 2);
      if ((!DynamicBackgroundView.b(localDynamicBackgroundView)) && (!f.e()))
      {
        f.c();
        return;
      }
    } while ((!DynamicBackgroundView.b(localDynamicBackgroundView)) || (!f.e()));
    f.d();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/dynamicbackground/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */