package com.gau.go.launcherex.gowidget.weather.dynamicbackground.preview;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.gau.go.launcherex.gowidget.scriptengine.parser.ae;
import com.gau.go.launcherex.gowidget.scriptengine.parser.z;

class c
  implements Runnable
{
  private final Context b;
  private final String c;
  private final boolean d;
  private final boolean e;
  
  public c(a parama, Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.b = paramContext;
    this.c = paramString;
    this.d = paramBoolean1;
    this.e = paramBoolean2;
  }
  
  public void run()
  {
    z localz;
    Message localMessage;
    if (this.b != null)
    {
      localz = new ae(this.b).a(this.c, a.f(this.a));
      localMessage = a.g(this.a).obtainMessage();
      if (!this.d) {
        break label103;
      }
      if (this.e) {
        break label95;
      }
      localMessage.what = 1;
    }
    for (;;)
    {
      localMessage.obj = new Object[] { this.c, localz };
      a.g(this.a).sendMessage(localMessage);
      return;
      label95:
      localMessage.what = 4;
      continue;
      label103:
      localMessage.what = 2;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/dynamicbackground/preview/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */