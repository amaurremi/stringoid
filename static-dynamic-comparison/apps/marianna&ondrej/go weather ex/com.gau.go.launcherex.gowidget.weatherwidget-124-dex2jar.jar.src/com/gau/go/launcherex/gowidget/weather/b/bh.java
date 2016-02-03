package com.gau.go.launcherex.gowidget.weather.b;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

class bh
  extends Handler
{
  bh(bg parambg) {}
  
  public void handleMessage(Message paramMessage)
  {
    paramMessage = (bj)paramMessage.obj;
    new bk(this.a).execute(new Object[] { paramMessage, bg.a(this.a).getContentResolver() });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/b/bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */