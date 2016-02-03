package com.gau.go.launcherex.gowidget.weather.view.gl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class k
  extends BroadcastReceiver
{
  k(GLWeatherWidget21 paramGLWeatherWidget21) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    while ((!paramIntent.getAction().equals("android.intent.action.PACKAGE_DATA_CLEARED")) || (!paramIntent.getDataString().replace("package:", "").equals(this.a.getContext().getPackageName()))) {
      return;
    }
    GLWeatherWidget21.access$2400(this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/gl/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */