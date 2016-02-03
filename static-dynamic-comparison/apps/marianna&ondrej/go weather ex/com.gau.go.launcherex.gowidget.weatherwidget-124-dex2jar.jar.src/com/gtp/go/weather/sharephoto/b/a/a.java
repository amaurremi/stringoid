package com.gtp.go.weather.sharephoto.b.a;

import com.gtp.go.weather.sharephoto.b.f;
import org.json.JSONObject;

public class a
{
  public static com.gtp.go.weather.sharephoto.b.a a(JSONObject paramJSONObject)
  {
    com.gtp.go.weather.sharephoto.b.a locala = new com.gtp.go.weather.sharephoto.b.a();
    JSONObject localJSONObject = paramJSONObject.optJSONObject("apkPic");
    if (localJSONObject != null) {
      locala.a(f.a(localJSONObject).a());
    }
    locala.c(paramJSONObject.optString("packageName", ""));
    locala.d(paramJSONObject.optString("apkName", ""));
    locala.e(paramJSONObject.optString("apkUrl", ""));
    locala.a(paramJSONObject.optInt("apkUrlType", -1));
    return locala;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/b/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */