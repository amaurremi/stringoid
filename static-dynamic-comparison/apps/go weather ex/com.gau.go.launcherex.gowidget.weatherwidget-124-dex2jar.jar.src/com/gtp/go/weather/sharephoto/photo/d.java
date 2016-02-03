package com.gtp.go.weather.sharephoto.photo;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

class d
  extends Thread
{
  d(b paramb, boolean paramBoolean, Context paramContext, String paramString, Handler paramHandler) {}
  
  public void run()
  {
    if (this.a) {}
    for (Object localObject = b.b(this.b, this.c, b.b(this.e));; localObject = b.a(this.b, this.c, b.b(this.e)))
    {
      localObject = this.d.obtainMessage(0, localObject);
      this.d.sendMessage((Message)localObject);
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/photo/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */