package com.gtp.go.weather.sharephoto.b;

import org.json.JSONObject;

public class f
{
  private String a;
  private int b;
  private int c;
  private int d;
  
  public static f a(JSONObject paramJSONObject)
  {
    f localf = new f();
    localf.a(paramJSONObject.optString("url", ""));
    localf.c(paramJSONObject.optInt("type", -1));
    localf.b(paramJSONObject.optInt("hight", 0));
    localf.a(paramJSONObject.optInt("width", 0));
    return localf;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public void b(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void c(int paramInt)
  {
    this.d = paramInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */