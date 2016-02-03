package com.gau.go.launcherex.goweather.livewallpaper;

import android.os.Handler;
import android.os.Message;
import com.jiubang.core.a.l;

class i
  extends Handler
{
  i(h paramh) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (!h.a(this.a)) {
      h.e(this.a).a((l)paramMessage.obj, h.b(this.a), h.c(this.a), h.d(this.a).a());
    }
    do
    {
      return;
      paramMessage = (l)paramMessage.obj;
    } while (paramMessage == null);
    paramMessage.h();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/goweather/livewallpaper/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */