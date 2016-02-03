package com.gau.go.launcherex.gowidget.weather.systemwidget.configure;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ThemeConfigureView$PackageChangeReceiver
  extends BroadcastReceiver
{
  public ThemeConfigureView$PackageChangeReceiver(ThemeConfigureView paramThemeConfigureView) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    boolean bool;
    if (paramContext.equals("android.intent.action.PACKAGE_ADDED"))
    {
      paramContext = paramIntent.getDataString();
      bool = paramIntent.getBooleanExtra("android.intent.extra.REPLACING", false);
      if ((paramContext != null) && (!bool))
      {
        paramContext = paramContext.replace("package:", "");
        ThemeConfigureView.a(this.a, paramContext);
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (!paramContext.equals("android.intent.action.PACKAGE_REMOVED")) {
            break;
          }
          paramContext = paramIntent.getDataString();
          bool = paramIntent.getBooleanExtra("android.intent.extra.REPLACING", false);
        } while ((paramContext == null) || (bool));
        paramContext = paramContext.replace("package:", "");
        ThemeConfigureView.b(this.a, paramContext);
        return;
      } while (!paramContext.equals("android.intent.action.PACKAGE_REPLACED"));
      paramContext = paramIntent.getDataString();
      bool = paramIntent.getBooleanExtra("android.intent.extra.REPLACING", false);
    } while ((paramContext == null) || (!bool));
    paramContext = paramContext.replace("package:", "");
    ThemeConfigureView.c(this.a, paramContext);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/systemwidget/configure/ThemeConfigureView$PackageChangeReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */