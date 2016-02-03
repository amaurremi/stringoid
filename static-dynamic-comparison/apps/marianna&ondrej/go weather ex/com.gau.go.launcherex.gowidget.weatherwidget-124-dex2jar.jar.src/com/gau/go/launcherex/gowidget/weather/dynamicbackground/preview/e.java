package com.gau.go.launcherex.gowidget.weather.dynamicbackground.preview;

import android.os.Handler;
import android.os.Message;
import com.gau.go.launcherex.gowidget.scriptengine.parser.z;
import com.gau.go.launcherex.gowidget.weather.dynamicbackground.DynamicBackgroundView;
import com.jiubang.core.a.o;

class e
  implements Runnable
{
  private volatile boolean b;
  private final String c;
  private final z d;
  
  public e(d paramd, z paramz, String paramString)
  {
    this.c = paramString;
    this.d = paramz;
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void run()
  {
    com.gtp.a.a.b.c.a("LJL", "mBgLayout.getWidth():" + d.a(this.a).getWidth() + "mBgLayout.getHeight():" + d.a(this.a).getHeight());
    o localo = new com.gau.go.launcherex.gowidget.scriptengine.parser.c(this.d, d.b(this.a), this.c, false, d.a(this.a).getWidth(), d.a(this.a).getHeight(), Boolean.valueOf(true)).a(this.c);
    if (!this.b)
    {
      Message localMessage = d.c(this.a).obtainMessage(1);
      localMessage.obj = localo;
      d.c(this.a).sendMessage(localMessage);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/dynamicbackground/preview/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */