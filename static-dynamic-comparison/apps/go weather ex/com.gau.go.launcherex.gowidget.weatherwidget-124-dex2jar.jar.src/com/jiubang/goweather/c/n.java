package com.jiubang.goweather.c;

import android.os.Handler;
import android.os.Message;
import com.gtp.a.a.a.a;
import com.gtp.a.a.b.c;

class n
  extends Handler
{
  n(m paramm) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    a.a().a("正在进行的定位超时", "location.txt");
    c.a("Location", "正在进行的定位超时");
    m.a(this.a).a();
    m.b(this.a).a(((Integer)paramMessage.obj).intValue());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/goweather/c/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */