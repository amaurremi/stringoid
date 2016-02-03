package com.gau.go.launcherex.gowidget.framework;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.gau.go.launcherex.gowidget.language.d;

class f
  extends BroadcastReceiver
{
  f(GoWidgetFrame paramGoWidgetFrame) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    GoWidgetFrame.c().a(new g(this));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/framework/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */