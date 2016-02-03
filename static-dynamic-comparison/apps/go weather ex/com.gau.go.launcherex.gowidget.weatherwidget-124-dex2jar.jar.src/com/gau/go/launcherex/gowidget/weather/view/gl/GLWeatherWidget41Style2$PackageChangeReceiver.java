package com.gau.go.launcherex.gowidget.weather.view.gl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

public class GLWeatherWidget41Style2$PackageChangeReceiver
  extends BroadcastReceiver
{
  public GLWeatherWidget41Style2$PackageChangeReceiver(GLWeatherWidget41Style2 paramGLWeatherWidget41Style2) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ((paramContext.equals("android.intent.action.PACKAGE_ADDED")) || (paramContext.equals("android.intent.action.PACKAGE_REMOVED")))
    {
      paramContext = paramIntent.getDataString();
      if ((!TextUtils.isEmpty(paramContext)) && (!paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget"))) {}
    }
    else
    {
      return;
    }
    GLWeatherWidget41Style2.access$3800(this.a).sendEmptyMessage(7);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/gl/GLWeatherWidget41Style2$PackageChangeReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */