package com.gau.go.launcherex.gowidget.language;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.gau.go.launcherex.gowidget.weather.view.LanguageSetting;

class h
  extends BroadcastReceiver
{
  h(d paramd) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null) {}
    do
    {
      return;
      if (paramContext.equals("action_touch_language_check_update_notification"))
      {
        paramIntent = new Intent(d.a(this.a), LanguageSetting.class);
        paramIntent.setFlags(872415232);
        paramIntent.putExtra("weather_alerts_lists_entrance", "widget&notification");
        d.a(this.a).startActivity(paramIntent);
        d.b(this.a);
        d.c(this.a);
      }
    } while (!paramContext.equals("action_delete_language_check_update_notification"));
    d.c(this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/language/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */