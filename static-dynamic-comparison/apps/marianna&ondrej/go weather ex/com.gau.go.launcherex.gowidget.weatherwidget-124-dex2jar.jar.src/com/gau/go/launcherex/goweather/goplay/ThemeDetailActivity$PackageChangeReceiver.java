package com.gau.go.launcherex.goweather.goplay;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.jiubang.playsdk.a.a;

public class ThemeDetailActivity$PackageChangeReceiver
  extends BroadcastReceiver
{
  public ThemeDetailActivity$PackageChangeReceiver(ThemeDetailActivity paramThemeDetailActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.intent.action.PACKAGE_REMOVED"))
    {
      paramContext = paramIntent.getDataString();
      boolean bool = paramIntent.getBooleanExtra("android.intent.extra.REPLACING", false);
      if ((paramContext != null) && (!bool))
      {
        paramContext = paramContext.replace("package:", "");
        if (((ThemeDetailActivity.b(this.a) instanceof a)) && (ThemeDetailActivity.a(this.a, (a)ThemeDetailActivity.b(this.a)).equals(paramContext))) {
          this.a.finish();
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/goweather/goplay/ThemeDetailActivity$PackageChangeReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */