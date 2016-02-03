package com.gau.go.launcherex.gowidget.weather.dynamicbackground.preview;

import android.os.Handler;
import android.os.Message;
import com.gau.go.launcherex.gowidget.weather.dynamicbackground.DynamicBackgroundView;
import com.jiubang.core.a.l;
import java.lang.ref.WeakReference;

class f
  extends Handler
{
  WeakReference a;
  
  public f(d paramd)
  {
    this.a = new WeakReference(paramd);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    d locald = (d)this.a.get();
    if (locald != null) {
      d.a(locald).a((l)paramMessage.obj, true);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/dynamicbackground/preview/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */