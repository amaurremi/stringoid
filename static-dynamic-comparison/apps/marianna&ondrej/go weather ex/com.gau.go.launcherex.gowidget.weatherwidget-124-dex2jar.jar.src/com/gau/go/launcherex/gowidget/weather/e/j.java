package com.gau.go.launcherex.gowidget.weather.e;

public class j
{
  public static final String a;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CREATE TABLE IF NOT EXISTS my_award_table");
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY, ");
    localStringBuilder.append("user_award_id LONG, ");
    localStringBuilder.append("award_id LONG, ");
    localStringBuilder.append("prompt_type INTEGER, ");
    localStringBuilder.append("award_desc TEXT, ");
    localStringBuilder.append("award_time LONG, ");
    localStringBuilder.append("award_type INTEGER, ");
    localStringBuilder.append("small_pic_url TEXT, ");
    localStringBuilder.append("small_pic_path TEXT, ");
    localStringBuilder.append("is_receive INTEGER)");
    a = localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/e/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */