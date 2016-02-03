package com.gau.go.launcherex.gowidget.weather.e;

import java.util.Locale;

public class q
{
  public static final int a;
  public static final int b;
  public static final String c;
  
  static
  {
    String str1 = Locale.getDefault().getCountry();
    String str2 = Locale.getDefault().getLanguage();
    if ((str1.indexOf("CN") != -1) && (str2.equalsIgnoreCase("zh")))
    {
      a = 1;
      if ((str1.indexOf("KR") == -1) || (!str2.equalsIgnoreCase("ko"))) {
        break label108;
      }
    }
    label108:
    for (b = 4;; b = 2)
    {
      c = "INSERT INTO setting (autoUpdate,autpUpdateFreq,tempUnit,calendarType,festival,auto_update_time_begin,auto_update_time_end, isCycle, dateStyle, notify, notify_city, notify_type, manual_refresh, windUnit,notify_city_type, world_clock, widgt_clock, widgt_calendar)values(1,3600000," + a + ",0,0,0,0,1,1,0,'',1,0," + b + ",1,1,'','')";
      return;
      a = 2;
      break;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/e/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */