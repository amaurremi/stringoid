package com.jiubang.goweather.c;

import android.location.Location;
import android.os.Handler;
import android.os.Message;
import com.gtp.a.a.a.a;
import com.gtp.a.a.b.c;

class k
  extends Handler
{
  k(j paramj) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    j.a(this.a);
    paramMessage = (Location)paramMessage.obj;
    a.a().a("网络定位成功", "location.txt");
    c.a("Location", "网络定位成功");
    this.a.b.a(paramMessage);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/goweather/c/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */