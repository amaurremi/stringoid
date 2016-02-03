package com.gau.go.launcherex.goweather.goplay;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.gau.go.launcherex.goweather.goplay.a.b;
import com.gau.go.launcherex.gowidget.messagecenter.util.c;
import com.gau.go.launcherex.gowidget.weather.globaltheme.b.a;
import com.gau.go.launcherex.gowidget.weather.globaltheme.b.e;
import com.gau.go.launcherex.gowidget.weather.globaltheme.c.d;
import java.util.ArrayList;

public class ThemeDataHandler$EventReceiver
  extends BroadcastReceiver
{
  public ThemeDataHandler$EventReceiver(ThemeDataHandler paramThemeDataHandler) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    String str;
    do
    {
      return;
      str = paramIntent.getAction();
      if (!"com.gau.go.launcherex.gowidget.weatherwidget.ACTION_USED_COUPON_ID".equals(str)) {
        break;
      }
      paramContext = paramIntent.getStringExtra("extra_used_coupon_id");
    } while (TextUtils.isEmpty(paramContext));
    int j = ThemeDataHandler.a(this.a).size();
    int i = 0;
    label49:
    if (i < j) {
      if (!((a)ThemeDataHandler.a(this.a).get(i)).a().equals(paramContext)) {}
    }
    for (;;)
    {
      if (i != -1) {
        ThemeDataHandler.a(this.a).remove(i);
      }
      ThemeDataHandler.b(this.a).a(paramContext);
      return;
      i += 1;
      break label49;
      if ("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_RECEIVE_THEME_COUPON_NOTIFICATION".equals(str))
      {
        ThemeDataHandler.c(this.a);
        return;
      }
      if ("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APPWIDGET_THEME_CHANGE".equals(str))
      {
        paramIntent = paramIntent.getStringExtra("extra_app_widget_theme_package");
        paramIntent = ThemeDataHandler.d(this.a).a(paramIntent);
        if ((paramIntent == null) || (!this.a.a(paramIntent))) {
          break;
        }
        q.e(paramContext);
        ThemeDataHandler.a(this.a, paramIntent.x(), 1);
        return;
      }
      if ("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_GOWIDGET_THEME_CHANGE".equals(str))
      {
        str = paramIntent.getStringExtra("extra_gowidget_theme_package");
        paramIntent = str;
        if ("app_widget_theme_white".equals(str)) {
          paramIntent = "go_widget_theme_white";
        }
        paramIntent = ThemeDataHandler.d(this.a).a(paramIntent);
        if ((paramIntent == null) || (!this.a.a(paramIntent))) {
          break;
        }
        q.e(paramContext);
        ThemeDataHandler.a(this.a, paramIntent.x(), 2);
        return;
      }
      if ("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APP_THEME_CHANGE".equals(str))
      {
        paramIntent = paramIntent.getStringExtra("extra_app_theme_package");
        if (("com.gtp.go.weather.phototheme".equals(paramIntent)) && (ThemeDataHandler.d(this.a).a(paramIntent) == null)) {
          ThemeDataHandler.d(this.a).g(d.a(ThemeDataHandler.e(this.a)));
        }
        paramIntent = ThemeDataHandler.d(this.a).a(paramIntent);
        if ((paramIntent == null) || (!this.a.a(paramIntent))) {
          break;
        }
        q.e(paramContext);
        ThemeDataHandler.a(this.a, paramIntent.x(), 3);
        return;
      }
      if ("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_LIVE_WALLPAPER_THEME_CHANGE".equals(str))
      {
        paramIntent = paramIntent.getStringExtra("extra_wallpaper_theme_package");
        paramIntent = ThemeDataHandler.d(this.a).a(paramIntent);
        if ((paramIntent == null) || (!this.a.a(paramIntent))) {
          break;
        }
        q.e(paramContext);
        return;
      }
      if (!"com.gau.go.launcherex.gowidget.weatherwidget.ACTION_USER_LANGUAGE_CHANGED".equals(str)) {
        break;
      }
      ThemeDataHandler.d(this.a).a();
      ThemeDataHandler.f(this.a);
      return;
      i = -1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/goweather/goplay/ThemeDataHandler$EventReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */