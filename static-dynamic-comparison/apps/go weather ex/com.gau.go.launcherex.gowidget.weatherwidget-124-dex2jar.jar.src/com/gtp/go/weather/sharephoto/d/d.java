package com.gtp.go.weather.sharephoto.d;

import android.graphics.Bitmap;
import android.os.Handler;

class d
  extends Thread
{
  d(c paramc, String paramString1, b paramb, k paramk, String paramString2) {}
  
  public void run()
  {
    Bitmap localBitmap = h.a(c.a(this.e), this.a, this.b);
    c.b(this.e).post(new e(this, localBitmap));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/d/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */