package com.gau.go.launcherex.gowidget.weather.e;

public class l
{
  public static final String a;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CREATE TABLE IF NOT EXISTS photo_table");
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY, ");
    localStringBuilder.append("photo_id LONG, ");
    localStringBuilder.append("photo_type INTEGER, ");
    localStringBuilder.append("belong_page INTEGER, ");
    localStringBuilder.append("image_type INTEGER, ");
    localStringBuilder.append("city_id TEXT, ");
    localStringBuilder.append("city TEXT, ");
    localStringBuilder.append("favour INTEGER, ");
    localStringBuilder.append("backcount INTEGER, ");
    localStringBuilder.append("is_myfavourite INTEGER, ");
    localStringBuilder.append("user_id TEXT, ");
    localStringBuilder.append("up_time_long LONG, ");
    localStringBuilder.append("up_time_date TEXT, ");
    localStringBuilder.append("original_url TEXT, ");
    localStringBuilder.append("original_path TEXT, ");
    localStringBuilder.append("original_w_h TEXT, ");
    localStringBuilder.append("watermark_url TEXT, ");
    localStringBuilder.append("watermark_path TEXT, ");
    localStringBuilder.append("watermark_w_h TEXT, ");
    localStringBuilder.append("compose_url TEXT, ");
    localStringBuilder.append("compose_path TEXT, ");
    localStringBuilder.append("compose_w_h TEXT, ");
    localStringBuilder.append("desc TEXT, ");
    localStringBuilder.append("latlng TEXT, ");
    localStringBuilder.append("addr TEXT)");
    a = localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/e/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */