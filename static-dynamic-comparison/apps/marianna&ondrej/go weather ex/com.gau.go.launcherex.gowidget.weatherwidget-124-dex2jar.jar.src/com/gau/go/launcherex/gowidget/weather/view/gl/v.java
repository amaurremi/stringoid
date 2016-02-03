package com.gau.go.launcherex.gowidget.weather.view.gl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class v
  extends BroadcastReceiver
{
  v(GLWeatherWidget41Style2 paramGLWeatherWidget41Style2) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ((paramContext == null) || (GLWeatherWidget41Style2.access$500(this.a) == null)) {}
    while ((!paramContext.equals("android.intent.action.PACKAGE_DATA_CLEARED")) || (!paramIntent.getDataString().replace("package:", "").equals(GLWeatherWidget41Style2.access$2100(this.a).getPackageName()))) {
      return;
    }
    GLWeatherWidget41Style2.access$2200(this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/gl/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */