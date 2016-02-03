package com.gau.go.launcherex.gowidget.weather.systemwidget.configure;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

class r
  extends BroadcastReceiver
{
  r(q paramq) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APPWIDGET_UPDATE_PREVIEW".equals(paramIntent.getAction())) && (paramIntent.getIntExtra("extra_widget_type", 0) == q.a(this.a)))
    {
      paramContext = (RemoteViews)paramIntent.getParcelableExtra("extra_widget_preview");
      q.a(this.a, paramContext);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/systemwidget/configure/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */