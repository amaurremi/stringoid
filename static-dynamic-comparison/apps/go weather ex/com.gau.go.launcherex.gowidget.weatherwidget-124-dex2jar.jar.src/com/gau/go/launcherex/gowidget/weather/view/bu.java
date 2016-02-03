package com.gau.go.launcherex.gowidget.weather.view;

import android.content.Intent;

public class bu
{
  public String a;
  public boolean b = false;
  public int c = 0;
  public String d;
  public int e;
  
  public void a(Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getExtras() != null))
    {
      this.a = paramIntent.getStringExtra("cityId");
      this.b = paramIntent.getBooleanExtra("EXTRA_BG_LOADING_IMMEDIATELY_", true);
      this.c = paramIntent.getIntExtra("detailSrc", 0);
      this.d = paramIntent.getStringExtra("extra_src_app_package_name");
      this.e = paramIntent.getIntExtra("detail_goto", -1);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/bu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */