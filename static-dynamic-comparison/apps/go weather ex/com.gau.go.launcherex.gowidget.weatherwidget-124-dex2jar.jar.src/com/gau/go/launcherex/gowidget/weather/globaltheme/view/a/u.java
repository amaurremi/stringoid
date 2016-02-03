package com.gau.go.launcherex.gowidget.weather.globaltheme.view.a;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.gau.go.launcherex.gowidget.weather.globaltheme.a;
import com.gau.go.launcherex.gowidget.weather.globalview.d;

class u
  implements d
{
  u(s params, int paramInt) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      switch (this.a)
      {
      }
    }
    for (;;)
    {
      Object localObject;
      if (paramBoolean2)
      {
        localObject = s.c(this.b).edit();
        ((SharedPreferences.Editor)localObject).putBoolean("show_widget_tip_dialog", false);
        ((SharedPreferences.Editor)localObject).commit();
      }
      return;
      s.a(this.b);
      continue;
      s.b(this.b);
      continue;
      if ((this.a == 3) && (a.a(this.b.a)))
      {
        localObject = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_THEME_SCROLL_CHANGE");
        ((Intent)localObject).putExtra("extra_theme_change_type", 2);
        this.b.a.sendBroadcast((Intent)localObject);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/globaltheme/view/a/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */