package com.gau.go.launcherex.gowidget.weather.e;

import java.util.Locale;

public abstract class c
{
  public static final int a;
  public static final int b;
  public static final int c;
  public static final int d;
  public static final int e;
  public static final int f;
  public static final String g;
  public static final String h;
  public static final String i;
  public static final String j;
  public static final String k;
  public static final String l;
  
  static
  {
    String str1 = Locale.getDefault().getCountry();
    String str2 = Locale.getDefault().getLanguage();
    if ((str1.indexOf("CN") != -1) && (str2.equalsIgnoreCase("zh")))
    {
      a = 1;
      b = 5;
      c = 2;
      d = 6;
      f = 1;
      e = 1;
    }
    for (;;)
    {
      g = "INSERT INTO common_setting_table (setting_key, setting_value)values('tempUnit', '" + a + "')";
      h = "INSERT INTO common_setting_table (setting_key, setting_value)values('calendarType', '" + e + "')";
      i = "INSERT INTO common_setting_table (setting_key, setting_value)values('festival', '" + f + "')";
      j = "INSERT INTO common_setting_table (setting_key, setting_value)values('windUnit', '" + b + "')";
      k = "INSERT INTO common_setting_table (setting_key, setting_value)values('visibility_unit', '" + c + "')";
      l = "INSERT INTO common_setting_table (setting_key, setting_value)values('pressure_unit', '" + d + "')";
      return;
      if ((str1.indexOf("KR") != -1) && (str2.equalsIgnoreCase("ko")))
      {
        a = 1;
        b = 4;
        c = 2;
        d = 6;
        f = 3;
        e = 1;
      }
      else if (str2.equalsIgnoreCase("en"))
      {
        a = 2;
        b = 2;
        c = 1;
        d = 6;
        f = 2;
        e = 0;
      }
      else if ((str1.indexOf("DE") != -1) && (str2.equalsIgnoreCase("de")))
      {
        a = 1;
        b = 2;
        c = 2;
        d = 6;
        f = 0;
        e = 0;
      }
      else if ((str1.indexOf("FR") != -1) && (str2.equalsIgnoreCase("fr")))
      {
        a = 1;
        b = 2;
        c = 2;
        d = 6;
        f = 0;
        e = 0;
      }
      else if ((str1.indexOf("IT") != -1) && (str2.equalsIgnoreCase("it")))
      {
        a = 1;
        b = 2;
        c = 2;
        d = 6;
        f = 0;
        e = 0;
      }
      else
      {
        a = 1;
        b = 2;
        c = 2;
        d = 6;
        f = 0;
        e = 0;
      }
    }
  }
  
  public static final String a(String paramString)
  {
    return "INSERT INTO common_setting_table (setting_key, setting_value)values('dynamic_bg_switch', '" + paramString + "')";
  }
  
  public static final String a(String paramString1, String paramString2)
  {
    return "INSERT INTO common_setting_table (setting_key, setting_value)values('" + paramString1 + "', '" + paramString2 + "')";
  }
  
  public static String[] a()
  {
    return new String[] { "setting_key", "setting_value" };
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/e/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */