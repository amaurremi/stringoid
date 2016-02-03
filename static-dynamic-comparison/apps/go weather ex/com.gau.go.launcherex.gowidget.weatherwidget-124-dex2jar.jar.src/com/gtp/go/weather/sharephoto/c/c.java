package com.gtp.go.weather.sharephoto.c;

import com.gau.go.launcherex.gowidget.statistics.a.a;
import com.gau.go.launcherex.gowidget.statistics.r;

class c
  implements Runnable
{
  c(b paramb, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    l.a(new n(b.a(this.c), b.b(this.c)));
    a locala = new a(117, "share_photo");
    locala.f(String.valueOf(this.a));
    locala.g(String.valueOf(this.b));
    r.a(b.a(this.c)).a(locala);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */