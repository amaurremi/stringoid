package com.gau.go.launcherex.gowidget.weather.globaltheme.view.a;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.gau.go.launcherex.gowidget.weather.b.ar;
import com.gau.go.launcherex.gowidget.weather.globalview.d;

class l
  implements d
{
  l(g paramg) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("dynamic_bg_switch", Boolean.valueOf(true));
      ar.a(this.a.a, localContentValues);
      g.a(this.a, true);
    }
    if (paramBoolean2) {
      g.e(this.a).edit().putBoolean("key_not_remind_open_dynamic_effect", true).commit();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/globaltheme/view/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */