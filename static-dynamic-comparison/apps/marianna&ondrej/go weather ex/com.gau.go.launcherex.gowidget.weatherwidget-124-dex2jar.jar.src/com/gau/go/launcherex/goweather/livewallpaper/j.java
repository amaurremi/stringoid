package com.gau.go.launcherex.goweather.livewallpaper;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import com.gau.go.launcherex.gowidget.scriptengine.parser.z;

class j
  implements Runnable
{
  private volatile boolean b;
  private final String c;
  private final z d;
  
  public j(h paramh, z paramz, String paramString)
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
    int i;
    int j;
    if (com.gtp.a.a.c.c.b(h.f(this.a)))
    {
      i = h.f(this.a).getResources().getDisplayMetrics().widthPixels;
      j = com.gtp.a.a.c.c.a(h.f(this.a));
    }
    for (Object localObject = new com.gau.go.launcherex.gowidget.scriptengine.parser.c(this.d, h.f(this.a), this.c, false, i, j, Boolean.valueOf(false));; localObject = new com.gau.go.launcherex.gowidget.scriptengine.parser.c(this.d, h.f(this.a), this.c, false, Boolean.valueOf(false)))
    {
      localObject = ((com.gau.go.launcherex.gowidget.scriptengine.parser.c)localObject).a(this.c);
      if (!this.b)
      {
        Message localMessage = h.g(this.a).obtainMessage(1);
        localMessage.obj = localObject;
        h.g(this.a).sendMessage(localMessage);
      }
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/goweather/livewallpaper/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */