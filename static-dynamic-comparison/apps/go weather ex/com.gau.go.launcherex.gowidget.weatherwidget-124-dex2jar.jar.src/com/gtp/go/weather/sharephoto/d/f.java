package com.gtp.go.weather.sharephoto.d;

import android.graphics.Bitmap;
import android.os.Handler;
import com.jiubang.core.c.a.a;

class f
  extends Thread
{
  f(c paramc, a parama, k paramk) {}
  
  public void run()
  {
    Bitmap localBitmap = h.a(c.a(this.c), this.a.a());
    c.b(this.c).post(new g(this, localBitmap));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/d/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */