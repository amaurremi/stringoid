package com.gau.go.launcherex.gowidget.weather.view.gl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

public class GLWeatherWidget42$PackageChangeReceiver
  extends BroadcastReceiver
{
  public GLWeatherWidget42$PackageChangeReceiver(GLWeatherWidget42 paramGLWeatherWidget42) {}
  
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
    GLWeatherWidget42.access$500(this.a).sendEmptyMessage(19);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/gl/GLWeatherWidget42$PackageChangeReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */