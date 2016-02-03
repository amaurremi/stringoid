package com.go.weatherex.d;

import android.os.Handler;
import android.os.Message;
import com.gau.go.launcherex.gowidget.weather.util.r;

class d
  extends Handler
{
  d(b paramb) {}
  
  public void handleMessage(Message paramMessage)
  {
    if ((this.a.a) && (r.c(b.a(this.a))))
    {
      this.a.a = false;
      f.a(b.a(this.a));
      b.b(this.a);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/d/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */