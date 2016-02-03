package com.go.weatherex.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;

class e
  extends BroadcastReceiver
{
  private e(b paramb) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((b.a(this.a) == null) || (f.c(b.a(this.a)))) {}
    do
    {
      return;
      paramContext = paramIntent.getAction();
      if (paramContext.equals("com.go.weatherex.goad.ACTION_GO_AD_DOWNLOAD"))
      {
        b.c(this.a).sendEmptyMessage(0);
        return;
      }
    } while (!paramContext.equals("android.net.conn.CONNECTIVITY_CHANGE"));
    b.d(this.a).sendEmptyMessage(0);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/d/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */