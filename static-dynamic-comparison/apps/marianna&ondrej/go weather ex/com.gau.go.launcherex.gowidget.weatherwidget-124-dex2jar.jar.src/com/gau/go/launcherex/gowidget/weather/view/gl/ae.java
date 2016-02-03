package com.gau.go.launcherex.gowidget.weather.view.gl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class ae
  extends BroadcastReceiver
{
  ae(GLWeatherWidget42 paramGLWeatherWidget42) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ((paramContext == null) || (GLWeatherWidget42.access$1500(this.a) == null)) {}
    while ((!paramContext.equals("android.intent.action.PACKAGE_DATA_CLEARED")) || (!paramIntent.getDataString().replace("package:", "").equals(this.a.getContext().getPackageName()))) {
      return;
    }
    GLWeatherWidget42.access$3800(this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/gl/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */