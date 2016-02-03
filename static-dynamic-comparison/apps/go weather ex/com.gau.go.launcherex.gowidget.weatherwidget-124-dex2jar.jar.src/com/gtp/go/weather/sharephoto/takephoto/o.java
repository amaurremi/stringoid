package com.gtp.go.weather.sharephoto.takephoto;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class o
  extends BroadcastReceiver
{
  o(m paramm) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    while (!"com.gau.go.launcherex.gowidget.weatherwidget.ACTION_USER_LANGUAGE_CHANGED".equals(paramIntent.getAction())) {
      return;
    }
    m.a(this.a, 0L);
    q.a(m.a(this.a), null);
    m.b(this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/takephoto/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */