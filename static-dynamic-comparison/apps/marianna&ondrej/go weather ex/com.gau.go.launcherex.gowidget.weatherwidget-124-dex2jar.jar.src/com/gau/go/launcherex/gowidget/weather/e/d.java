package com.gau.go.launcherex.gowidget.weather.e;

public class d
{
  public static final String a;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CREATE TABLE IF NOT EXISTS coupons_collect_table");
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY, ");
    localStringBuilder.append("coupon_id LONG, ");
    localStringBuilder.append("source_coupon_id LONG, ");
    localStringBuilder.append("shop_name TEXT, ");
    localStringBuilder.append("coupon_type INTEGER, ");
    localStringBuilder.append("title TEXT, ");
    localStringBuilder.append("desc TEXT, ");
    localStringBuilder.append("exp_time TEXT, ");
    localStringBuilder.append("code TEXT, ");
    localStringBuilder.append("logo_url TEXT, ");
    localStringBuilder.append("logo_path TEXT)");
    a = localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/e/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */