package com.go.weatherex.setting;

import android.content.Intent;
import com.gau.go.launcherex.gowidget.weather.globalview.c;

class t
  implements c
{
  t(q paramq) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      this.a.startActivityForResult(new Intent("android.settings.WIRELESS_SETTINGS"), 0);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/setting/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */