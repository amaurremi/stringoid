package com.gau.go.launcherex.gowidget.scriptengine.parser;

import android.graphics.Color;

public class ac
{
  private String a = "";
  private int b = 0;
  
  public void a(String paramString1, String paramString2)
  {
    try
    {
      if (paramString1.equals("gw_weather_ex_main_selector"))
      {
        this.a = paramString2;
        return;
      }
      if (paramString1.equals("go_weather_ex_main_shadowcolor"))
      {
        this.b = Color.parseColor(paramString2);
        return;
      }
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/scriptengine/parser/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */