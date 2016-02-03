package com.gau.go.launcherex.gowidget.language;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class f
  extends BroadcastReceiver
{
  private f(d paramd) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_SETTING_USER_LANGUAGE".endsWith(paramIntent.getAction()))
    {
      paramContext = paramIntent.getStringExtra("extra_language_package");
      paramIntent = paramIntent.getStringExtra("extra_language_code");
      this.a.a(paramIntent, paramContext);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/language/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */