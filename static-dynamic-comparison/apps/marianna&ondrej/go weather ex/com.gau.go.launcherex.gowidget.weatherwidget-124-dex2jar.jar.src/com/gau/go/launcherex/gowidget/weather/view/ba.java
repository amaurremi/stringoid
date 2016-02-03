package com.gau.go.launcherex.gowidget.weather.view;

import android.content.Intent;

public class ba
{
  public int a = 40;
  public int b = 40;
  public int c = -1;
  public String d;
  
  public void a(Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getExtras() != null))
    {
      this.d = paramIntent.getStringExtra("cityId");
      this.c = paramIntent.getIntExtra("extra_theme_entrance", -1);
      if (this.c == 33)
      {
        this.a = paramIntent.getIntExtra("first_level_tab_id", 40);
        this.b = paramIntent.getIntExtra("second_level_tab_id", 40);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */