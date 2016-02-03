package com.gau.go.launcherex.goweather.ad;

import android.os.Handler;
import android.os.Message;

class d
  extends Handler
{
  d(c paramc) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0) {
      new e(this.a).execute(new Void[0]);
    }
    do
    {
      return;
      if (paramMessage.what == 1)
      {
        long l = ((Long)paramMessage.obj).longValue();
        c.a(this.a, l);
        return;
      }
    } while (paramMessage.what != 2);
    c.a(this.a, true);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/goweather/ad/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */