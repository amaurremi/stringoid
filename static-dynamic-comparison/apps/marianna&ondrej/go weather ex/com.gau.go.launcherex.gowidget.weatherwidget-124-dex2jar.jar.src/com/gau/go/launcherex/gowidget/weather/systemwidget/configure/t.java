package com.gau.go.launcherex.gowidget.weather.systemwidget.configure;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.messagecenter.util.c;
import com.gau.go.launcherex.gowidget.weather.globaltheme.b.a;
import java.util.ArrayList;

class t
  extends BroadcastReceiver
{
  private t(ThemeConfigureView paramThemeConfigureView) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      paramContext = paramIntent.getAction();
      if (!paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APPWIDGET_THEME_CHANGE")) {
        break label37;
      }
      paramContext = paramIntent.getStringExtra("extra_app_widget_theme_package");
      ThemeConfigureView.a(this.a).a(paramContext);
    }
    label37:
    do
    {
      do
      {
        return;
      } while (!"com.gau.go.launcherex.gowidget.weatherwidget.ACTION_USED_COUPON_ID".equals(paramContext));
      paramContext = paramIntent.getStringExtra("extra_used_coupon_id");
    } while (TextUtils.isEmpty(paramContext));
    int i;
    if (ThemeConfigureView.b(this.a) != null)
    {
      int j = ThemeConfigureView.b(this.a).size();
      i = 0;
      if (i >= j) {
        break label167;
      }
      if (!((a)ThemeConfigureView.b(this.a).get(i)).a().equals(paramContext)) {
        break label160;
      }
    }
    for (;;)
    {
      if (i != -1)
      {
        ThemeConfigureView.b(this.a).remove(i);
        ThemeConfigureView.a(this.a).b(ThemeConfigureView.b(this.a));
      }
      ThemeConfigureView.c(this.a).a(paramContext);
      return;
      label160:
      i += 1;
      break;
      label167:
      i = -1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/systemwidget/configure/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */