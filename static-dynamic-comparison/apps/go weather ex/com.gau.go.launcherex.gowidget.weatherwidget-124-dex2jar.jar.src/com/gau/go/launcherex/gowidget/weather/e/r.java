package com.gau.go.launcherex.gowidget.weather.e;

public class r
{
  public static final String a;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CREATE TABLE IF NOT EXISTS user_table");
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY, ");
    localStringBuilder.append("user_id TEXT, ");
    localStringBuilder.append("user_gmail TEXT, ");
    localStringBuilder.append("go_id TEXT, ");
    localStringBuilder.append("register_time INTEGER)");
    a = localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/e/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */