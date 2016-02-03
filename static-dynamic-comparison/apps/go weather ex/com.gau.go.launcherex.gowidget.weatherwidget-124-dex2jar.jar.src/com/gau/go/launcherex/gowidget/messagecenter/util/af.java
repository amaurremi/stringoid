package com.gau.go.launcherex.gowidget.messagecenter.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.gau.go.launcherex.gowidget.weather.model.q;
import java.util.HashMap;

class af
  extends BroadcastReceiver
{
  af(ae paramae) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool = true;
    paramContext = paramIntent.getAction();
    if (paramContext.equals("action_delete_message_notification")) {
      ae.a(this.a).clear();
    }
    while (!paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_CHANGE_NOTIFICATION_SOUND")) {
      return;
    }
    paramContext = this.a;
    if (ae.b(this.a).z == 1) {}
    for (;;)
    {
      ae.a(paramContext, bool);
      return;
      bool = false;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/messagecenter/util/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */