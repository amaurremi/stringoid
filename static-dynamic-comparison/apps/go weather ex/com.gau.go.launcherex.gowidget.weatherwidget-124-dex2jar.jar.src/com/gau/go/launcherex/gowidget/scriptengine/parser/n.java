package com.gau.go.launcherex.gowidget.scriptengine.parser;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

class n
  implements Runnable
{
  private final Context b;
  private final String c;
  private final boolean d;
  private final boolean e;
  private final int f;
  
  public n(i parami, Context paramContext, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.b = paramContext;
    this.c = paramString;
    this.d = paramBoolean1;
    this.e = paramBoolean2;
    this.f = paramInt;
  }
  
  public void run()
  {
    z localz;
    Message localMessage;
    if (this.b != null)
    {
      localz = new ae(this.b).a(this.c, i.g(this.a));
      localMessage = i.h(this.a).obtainMessage();
      if (!this.d) {
        break label113;
      }
      if (this.e) {
        break label105;
      }
      localMessage.what = 1;
    }
    for (;;)
    {
      localMessage.obj = new Object[] { this.c, localz, Integer.valueOf(this.f) };
      i.h(this.a).sendMessage(localMessage);
      return;
      label105:
      localMessage.what = 4;
      continue;
      label113:
      localMessage.what = 2;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/scriptengine/parser/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */