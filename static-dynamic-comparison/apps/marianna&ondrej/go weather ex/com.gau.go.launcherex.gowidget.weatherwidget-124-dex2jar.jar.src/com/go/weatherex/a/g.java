package com.go.weatherex.a;

import android.content.Context;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.jiubang.goweather.b.e;
import com.jiubang.goweather.e.a;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class g
{
  public static String a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    Object localObject = null;
    e locale = new e(paramString1, "POST");
    locale.a(paramString2.getBytes());
    com.jiubang.goweather.b.f localf = new com.jiubang.goweather.b.f();
    if (paramInt1 != 0) {
      locale.a(paramInt1);
    }
    if (paramInt2 != 0) {
      locale.b(paramInt2);
    }
    com.jiubang.goweather.b.c localc = com.jiubang.goweather.b.d.a();
    paramString2 = (String)localObject;
    if (localc.a(localf, paramContext))
    {
      paramContext = localc.a(paramString1, locale, localf);
      paramString2 = (String)localObject;
      if (paramContext == null) {}
    }
    try
    {
      paramString2 = a.a(paramContext, "UTF-8");
      localc.a();
      return paramString2;
    }
    catch (IOException paramContext)
    {
      for (;;)
      {
        paramString2 = (String)localObject;
        if (com.gtp.a.a.b.c.a())
        {
          paramContext.printStackTrace();
          paramString2 = (String)localObject;
        }
      }
    }
  }
  
  public static JSONObject a(Context paramContext, String paramString1, String paramString2)
  {
    localJSONObject = new JSONObject();
    try
    {
      com.gtp.go.weather.sharephoto.a.f.a(localJSONObject, "pver", "1");
      com.gtp.go.weather.sharephoto.a.f.a(localJSONObject, "version", y.e(paramContext));
      com.gtp.go.weather.sharephoto.a.f.a(localJSONObject, "lang", y.k(paramContext));
      try
      {
        i = Integer.valueOf(y.f(paramContext)).intValue();
        com.gtp.go.weather.sharephoto.a.f.a(localJSONObject, "channel", i);
        com.gtp.go.weather.sharephoto.a.f.a(localJSONObject, "androidid", y.v(paramContext));
        com.gtp.go.weather.sharephoto.a.f.a(localJSONObject, "email", paramString2);
        com.gtp.go.weather.sharephoto.a.f.a(localJSONObject, "goId", com.gau.go.gostaticsdk.d.b(paramContext));
        com.gtp.go.weather.sharephoto.a.f.a(localJSONObject, "code", paramString1);
        com.gtp.go.weather.sharephoto.a.f.a(localJSONObject, "pid", 4);
        return localJSONObject;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          int i = 0;
        }
      }
      return localJSONObject;
    }
    catch (JSONException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static String b(Context paramContext, String paramString1, String paramString2)
  {
    return a(paramContext, paramString1, paramString2, 0, 0);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */