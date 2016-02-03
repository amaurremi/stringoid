package com.gau.go.launcherex.gowidget.weather.e;

public class m
{
  public static final String a;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CREATE TABLE IF NOT EXISTS photo_upload_table");
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY, ");
    localStringBuilder.append("photo_id LONG, ");
    localStringBuilder.append("data_type INTEGER, ");
    localStringBuilder.append("data_value INTEGER, ");
    localStringBuilder.append("user_id TEXT, ");
    localStringBuilder.append("city_id TEXT)");
    a = localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/e/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */