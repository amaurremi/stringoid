package com.gau.go.launcherex.goweather.goplay;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class h
  extends BroadcastReceiver
{
  private h(ThemeDetailActivity paramThemeDetailActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && ("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_THEME_SCROLL_CHANGE".equals(paramIntent.getAction()))) {}
    switch (paramIntent.getIntExtra("extra_theme_change_type", 0))
    {
    default: 
      return;
    case 1: 
      ThemeDetailActivity.a(this.a, 39);
      return;
    }
    ThemeDetailActivity.a(this.a, 40);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/goweather/goplay/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */