package com.gau.go.launcherex.gowidget.weather.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.gau.go.launcherex.gowidget.language.d;

class x
  extends BroadcastReceiver
{
  x(LanguageSetting paramLanguageSetting) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ((paramContext.equals("android.intent.action.PACKAGE_ADDED")) || (paramContext.equals("android.intent.action.PACKAGE_REMOVED")) || (paramContext.equals("android.intent.action.PACKAGE_REPLACED")))
    {
      paramContext = paramIntent.getDataString();
      if ((paramContext != null) && (paramContext.startsWith("package:com.gau.go.weatherex.language.")))
      {
        d.c(LanguageSetting.a(this.a), this.a);
        LanguageSetting.b(this.a).notifyDataSetChanged();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */