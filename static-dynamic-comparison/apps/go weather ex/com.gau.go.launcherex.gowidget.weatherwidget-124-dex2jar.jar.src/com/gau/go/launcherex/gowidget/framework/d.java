package com.gau.go.launcherex.gowidget.framework;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class d
  extends Handler
{
  WeakReference a;
  
  public d(GoWidgetActivity paramGoWidgetActivity)
  {
    this.a = new WeakReference(paramGoWidgetActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    GoWidgetActivity localGoWidgetActivity = (GoWidgetActivity)this.a.get();
    if ((localGoWidgetActivity != null) && (!localGoWidgetActivity.isFinishing()))
    {
      if (paramMessage.what != 0) {
        break label34;
      }
      localGoWidgetActivity.b();
    }
    label34:
    while (paramMessage.what != 2) {
      return;
    }
    localGoWidgetActivity.a();
    sendEmptyMessageDelayed(2, 80L);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/framework/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */