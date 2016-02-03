package com.gtp.go.weather.sharephoto.photo;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.SoftReference;
import java.util.HashMap;

class c
  extends Handler
{
  c(b paramb, String paramString1, e parame, String paramString2, String paramString3) {}
  
  public void handleMessage(Message paramMessage)
  {
    paramMessage = (Drawable)paramMessage.obj;
    b.a(this.e).put(this.a, new SoftReference(paramMessage));
    this.b.a(paramMessage, this.a, this.c, this.d);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/photo/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */