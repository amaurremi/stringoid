package com.gau.go.launcherex.gowidget.weather.gowidget.configure;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.messagecenter.util.c;
import com.gau.go.launcherex.gowidget.weather.globaltheme.b.a;
import java.util.ArrayList;

class l
  extends BroadcastReceiver
{
  private l(ThemeConfigureView paramThemeConfigureView) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i;
    if ((paramIntent != null) && ("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_USED_COUPON_ID".equals(paramIntent.getAction())))
    {
      paramContext = paramIntent.getStringExtra("extra_used_coupon_id");
      if (!TextUtils.isEmpty(paramContext)) {
        if (ThemeConfigureView.a(this.a) != null)
        {
          int j = ThemeConfigureView.a(this.a).size();
          i = 0;
          if (i >= j) {
            break label137;
          }
          if (!((a)ThemeConfigureView.a(this.a).get(i)).a().equals(paramContext)) {
            break label130;
          }
        }
      }
    }
    for (;;)
    {
      if (i != -1)
      {
        ThemeConfigureView.a(this.a).remove(i);
        ThemeConfigureView.b(this.a).b(ThemeConfigureView.a(this.a));
      }
      ThemeConfigureView.c(this.a).a(paramContext);
      return;
      label130:
      i += 1;
      break;
      label137:
      i = -1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/gowidget/configure/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */