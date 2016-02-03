package com.gau.go.launcherex.gowidget.weather.e;

public class s
{
  public static final String a;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CREATE TABLE IF NOT EXISTS appwidget_info_table");
    localStringBuilder.append(" (");
    localStringBuilder.append("_id INTEGER PRIMARY KEY, ");
    localStringBuilder.append("widget_id INTEGER, ");
    localStringBuilder.append("widget_type INTEGER, ");
    localStringBuilder.append("current_cityid TEXT, ");
    localStringBuilder.append("widget_location_type INTEGER, ");
    localStringBuilder.append("theme_package_name TEXT)");
    a = localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/e/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */