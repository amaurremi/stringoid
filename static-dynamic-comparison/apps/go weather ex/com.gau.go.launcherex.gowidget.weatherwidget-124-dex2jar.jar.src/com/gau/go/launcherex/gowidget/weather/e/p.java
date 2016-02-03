package com.gau.go.launcherex.gowidget.weather.e;

public class p
{
  public static final String a;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CREATE TABLE IF NOT EXISTS prompt_table");
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY, ");
    localStringBuilder.append("page_type INTEGER, ");
    localStringBuilder.append("need_show INTEGER, ");
    localStringBuilder.append("local_type INTEGER, ");
    localStringBuilder.append("response_type INTEGER, ");
    localStringBuilder.append("prompt_id INTEGER, ");
    localStringBuilder.append("prompt_text TEXT, ");
    localStringBuilder.append("prompt_type INTEGER)");
    a = localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/e/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */