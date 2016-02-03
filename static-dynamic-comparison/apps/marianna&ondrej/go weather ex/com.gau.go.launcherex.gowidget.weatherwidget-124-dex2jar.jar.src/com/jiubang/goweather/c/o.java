package com.jiubang.goweather.c;

import android.os.Handler;
import android.os.Message;

class o
  implements Runnable
{
  o(m paramm) {}
  
  public void run()
  {
    Message localMessage = new Message();
    localMessage.what = 2;
    localMessage.obj = Integer.valueOf(m.c(this.a));
    m.d(this.a).sendMessage(localMessage);
    m.d(this.a).removeCallbacks(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/goweather/c/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */