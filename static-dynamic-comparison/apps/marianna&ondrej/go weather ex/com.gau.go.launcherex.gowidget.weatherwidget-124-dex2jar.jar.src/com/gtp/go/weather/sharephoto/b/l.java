package com.gtp.go.weather.sharephoto.b;

import org.json.JSONObject;

public class l
{
  public int a;
  public String b;
  public int c;
  
  public static l a(JSONObject paramJSONObject)
  {
    l locall = new l();
    locall.a = paramJSONObject.optInt("result");
    locall.b = paramJSONObject.optString("msg");
    locall.c = paramJSONObject.optInt("costTime");
    return locall;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/b/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */