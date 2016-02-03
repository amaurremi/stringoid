package com.jiubang.goweather.c;

import android.content.Context;
import android.location.Location;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.statistics.h;
import com.gau.go.launcherex.gowidget.statistics.j;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.gau.go.launcherex.gowidget.weather.model.b;
import com.gtp.a.a.a.a;
import com.jiubang.goweather.b.e;
import com.jiubang.goweather.b.f;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class u
{
  public static List a(Context paramContext, Location paramLocation, f paramf, String paramString)
  {
    String str = null;
    Object localObject = null;
    e locale = new e("http://goweatherex.3g.cn/goweatherex/city/gps");
    com.gtp.a.a.b.c.a("LJL", paramLocation.getLatitude() + "---" + paramLocation.getLongitude());
    locale.a("latlng", paramLocation.getLatitude() + "," + paramLocation.getLongitude());
    locale.a("lang", paramString);
    locale.a("sys", Build.VERSION.RELEASE);
    locale.a("ps", "2.0");
    locale.a("chan", String.valueOf(100));
    locale.a("cliId", y.v(paramContext));
    locale.a("gliId", com.gau.go.gostaticsdk.d.b(paramContext));
    locale.a("chanId", y.f(paramContext));
    try
    {
      paramString = locale.i();
      paramLocation = str;
      if (paramString != null)
      {
        com.jiubang.goweather.b.c localc = com.jiubang.goweather.b.d.a();
        paramLocation = str;
        if (localc.a(paramf, paramContext))
        {
          a.a().a("服务器定位：" + paramString, "location.txt");
          com.gtp.a.a.b.c.a("Location", "服务器定位：" + paramString);
          paramf.d(2);
          paramf.a(SystemClock.elapsedRealtime());
          str = localc.b(paramString, locale, paramf);
          paramf.b(SystemClock.elapsedRealtime());
          if (str == null) {
            break label418;
          }
          paramf.b(str);
          paramf.c(SystemClock.elapsedRealtime());
          a.a().a("服务器定位结果：" + str, "location.txt");
          com.gtp.a.a.b.c.a("Location", "服务器定位结果：" + str);
          paramLocation = new ArrayList();
          a(paramLocation, str, true, paramf, paramString);
          paramf.d(SystemClock.elapsedRealtime());
          j.a(paramContext).a(paramf);
        }
      }
      new h(paramContext).c(paramString, paramf);
      return paramLocation;
    }
    catch (UnsupportedEncodingException paramLocation)
    {
      for (;;)
      {
        paramf.a(paramLocation);
        if (com.gtp.a.a.b.c.a()) {
          paramLocation.printStackTrace();
        }
        paramString = null;
        continue;
        label418:
        a.a().a("服务器定位失败", "location.txt");
        com.gtp.a.a.b.c.a("Location", "服务器定位失败");
        paramLocation = (Location)localObject;
      }
    }
  }
  
  private static void a(List paramList, String paramString1, boolean paramBoolean, f paramf, String paramString2)
  {
    try
    {
      paramString1 = new JSONObject(paramString1);
      if (paramString1 != null)
      {
        localJSONObject = paramString1.optJSONObject("head");
        i = localJSONObject.optInt("result", -1);
        paramf.e(localJSONObject.optInt("costTime", 0));
        if (i != 1) {
          break label381;
        }
        paramf.b(1);
        paramString1 = paramString1.optJSONArray("cities");
        if (paramString1 != null)
        {
          int k = paramString1.length();
          i = 0;
          if (i < k)
          {
            paramf = new b();
            localJSONObject = paramString1.optJSONObject(i);
            if (localJSONObject == null) {
              break label372;
            }
            paramf.a(localJSONObject.optString("cityId", "--"));
            paramf.b(localJSONObject.optString("city", "--"));
            paramf.g(localJSONObject.optString("oldId", "--"));
            paramf.d(localJSONObject.optString("state", "--"));
            paramf.c(localJSONObject.optString("country", "--"));
            paramf.e(localJSONObject.optString("timeZone", "--"));
            paramf.h(paramString2);
            localObject = localJSONObject.optString("latlng");
            paramf.a(-10000.0F);
            paramf.b(-10000.0F);
            if (TextUtils.isEmpty((CharSequence)localObject)) {}
          }
        }
      }
    }
    catch (JSONException paramString1)
    {
      int i;
      label372:
      label381:
      do
      {
        for (;;)
        {
          try
          {
            JSONObject localJSONObject;
            Object localObject = ((String)localObject).split(",");
            if (localObject.length == 2)
            {
              paramf.a(Float.valueOf(localObject[0]).floatValue());
              paramf.b(Float.valueOf(localObject[1]).floatValue());
            }
            if (localJSONObject.optBoolean("hasRadar", false))
            {
              j = 1;
              paramf.a(j);
              if (!localJSONObject.optBoolean("hasSatellite", false)) {
                continue;
              }
              j = 1;
              paramf.b(j);
              paramList.add(paramf);
              if (!paramBoolean) {
                break label372;
              }
              return;
              paramString1 = paramString1;
              paramf.b(11);
              paramf.c(10);
              paramf.a(paramString1);
              if (com.gtp.a.a.b.c.a()) {
                paramString1.printStackTrace();
              }
              paramString1 = null;
            }
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            continue;
            int j = 0;
            continue;
            j = 0;
            continue;
          }
          i += 1;
        }
        if (i == -1)
        {
          paramf.b(11);
          paramf.c(5);
          return;
        }
      } while (i != 0);
      paramf.b(11);
      paramf.c(4);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/goweather/c/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */