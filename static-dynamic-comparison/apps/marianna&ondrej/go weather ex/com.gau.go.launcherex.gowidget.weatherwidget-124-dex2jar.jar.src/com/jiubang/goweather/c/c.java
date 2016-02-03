package com.jiubang.goweather.c;

import android.location.Location;
import android.os.Handler;
import android.os.Message;
import com.gtp.a.a.a.a;

class c
  extends Handler
{
  c(b paramb) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    b.a(this.a);
    paramMessage = (Location)paramMessage.obj;
    a.a().a("GPS定位成功", "location.txt");
    this.a.b.a(paramMessage);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/goweather/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */