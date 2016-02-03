package com.gau.go.launcherex.gowidget.weather.widget.dynamicicon;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class e
  extends Handler
{
  private WeakReference a;
  private boolean b;
  
  public e(WeakReference paramWeakReference)
  {
    this.a = paramWeakReference;
    this.b = false;
  }
  
  public void a()
  {
    b();
    this.b = true;
    sendEmptyMessage(34);
  }
  
  public void b()
  {
    this.b = false;
    removeMessages(34);
    removeMessages(35);
  }
  
  public void handleMessage(Message paramMessage)
  {
    GoWidgetDynamicIconView localGoWidgetDynamicIconView = (GoWidgetDynamicIconView)this.a.get();
    if (localGoWidgetDynamicIconView != null) {
      localGoWidgetDynamicIconView.invalidate();
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    if ((this.b) && (GoWidgetDynamicIconView.a(localGoWidgetDynamicIconView) != null) && (!GoWidgetDynamicIconView.a(localGoWidgetDynamicIconView).a()))
    {
      sendEmptyMessageDelayed(34, 30L);
      return;
    }
    sendEmptyMessageDelayed(35, 30L);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/widget/dynamicicon/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */