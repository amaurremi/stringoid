package com.gau.go.launcherex.goweather.livewallpaper;

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
    Object localObject;
    z localz;
    boolean bool;
    if (this.b != null)
    {
      localObject = new ae(this.b);
      localz = ((ae)localObject).a(this.c, a.g(this.a));
      bool = ((ae)localObject).a();
      localObject = a.i(this.a).obtainMessage();
      if (!this.d) {
        break label117;
      }
      if (this.e) {
        break label109;
      }
      ((Message)localObject).what = 1;
    }
    for (;;)
    {
      ((Message)localObject).obj = new Object[] { this.c, localz, Boolean.valueOf(bool) };
      a.i(this.a).sendMessage((Message)localObject);
      return;
      label109:
      ((Message)localObject).what = 4;
      continue;
      label117:
      ((Message)localObject).what = 2;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/goweather/livewallpaper/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */