package com.gau.go.launcherex.goweather.goplay.a;

import android.text.format.Time;

public class a
{
  private static final Time a = new Time();
  
  protected String a(String paramString)
  {
    a.setToNow();
    a.set(a.toMillis(true) - (a.gmtoff - 28800L) * 1000L);
    return a.format(paramString);
  }
  
  public void a() {}
  
  public String b()
  {
    return "";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/goweather/goplay/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */