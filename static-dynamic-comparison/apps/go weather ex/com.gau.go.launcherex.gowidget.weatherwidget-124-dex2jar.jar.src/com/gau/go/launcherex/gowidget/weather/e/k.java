package com.gau.go.launcherex.gowidget.weather.e;

public class k
{
  public static final String a;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CREATE TABLE IF NOT EXISTS my_photo_table");
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY, ");
    localStringBuilder.append("photo_id LONG, ");
    localStringBuilder.append("photo_path TEXT, ");
    localStringBuilder.append("watermark_path TEXT, ");
    localStringBuilder.append("has_watermark TEXT, ");
    localStringBuilder.append("description TEXT, ");
    localStringBuilder.append("city_id TEXT, ");
    localStringBuilder.append("city_name TEXT, ");
    localStringBuilder.append("photo_upload_size LONG, ");
    localStringBuilder.append("watermark_upload_size LONG)");
    a = localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/e/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */