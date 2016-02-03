package com.gtp.go.weather.sharephoto.takephoto;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.location.Location;
import android.os.SystemClock;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.jiubang.goweather.a.a;
import com.jiubang.goweather.a.h;
import com.jiubang.goweather.b.d;
import com.jiubang.goweather.b.e;
import com.jiubang.goweather.c.i;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class m
{
  private static m a;
  private com.jiubang.goweather.c.g b;
  private com.gau.go.launcherex.gowidget.weather.util.f c;
  private q d;
  private p e;
  private Context f;
  private long g;
  private final i h = new n(this);
  private final BroadcastReceiver i = new o(this);
  
  private m(Context paramContext)
  {
    this.f = paramContext.getApplicationContext();
    this.b = new com.jiubang.goweather.c.g(this.f);
    this.b.a(this.h);
    this.c = com.gau.go.launcherex.gowidget.weather.c.c.a(this.f).h();
    this.d = new q();
    paramContext = new IntentFilter();
    paramContext.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_USER_LANGUAGE_CHANGED");
    this.f.registerReceiver(this.i, paramContext);
  }
  
  private String a(Context paramContext, Location paramLocation, String paramString)
  {
    double d1 = paramLocation.getLongitude();
    double d2 = paramLocation.getLatitude();
    if (y.p(paramContext)) {
      paramLocation = "http://ditu.google.com/maps/api/geocode/json";
    }
    for (;;)
    {
      e locale = new e(paramLocation, 7000, 7000);
      locale.a("latlng", String.valueOf(d2) + "," + String.valueOf(d1));
      locale.a("sensor", "false");
      locale.a("language", paramString);
      locale.a(true);
      paramString = new com.jiubang.goweather.b.f();
      try
      {
        paramLocation = locale.i();
        if (TextUtils.isEmpty(paramLocation))
        {
          return null;
          paramLocation = "http://maps.google.com/maps/api/geocode/json";
        }
      }
      catch (UnsupportedEncodingException paramLocation)
      {
        do
        {
          do
          {
            com.jiubang.goweather.b.c localc;
            do
            {
              for (;;)
              {
                if (com.gtp.a.a.b.c.a()) {
                  paramLocation.printStackTrace();
                }
                paramLocation = null;
              }
              localc = d.a();
            } while (!localc.a(paramString, paramContext));
            paramContext = localc.b(paramLocation, locale, paramString);
          } while (TextUtils.isEmpty(paramContext));
          try
          {
            paramContext = a(paramContext);
            return paramContext;
          }
          catch (JSONException paramContext) {}
        } while (!com.gtp.a.a.b.c.a());
        paramContext.printStackTrace();
      }
    }
    return null;
  }
  
  private String a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    paramString = new JSONObject(paramString);
    Object localObject;
    if ("OK".equalsIgnoreCase(paramString.getString("status")))
    {
      paramString = paramString.getJSONArray("results");
      int m = paramString.length();
      int j = 0;
      while (j < m)
      {
        localObject = paramString.getJSONObject(j);
        JSONArray localJSONArray = ((JSONObject)localObject).getJSONArray("types");
        int k = 0;
        if (k < localJSONArray.length())
        {
          String str = localJSONArray.getString(k);
          if ("sublocality".equalsIgnoreCase(str)) {
            localHashMap.put("sublocality", ((JSONObject)localObject).optString("formatted_address", ""));
          }
          for (;;)
          {
            k += 1;
            break;
            if ("locality".equalsIgnoreCase(str)) {
              localHashMap.put("locality", ((JSONObject)localObject).optString("formatted_address", ""));
            } else if ("street_address".equalsIgnoreCase(str)) {
              localHashMap.put("street_address", ((JSONObject)localObject).optString("formatted_address", ""));
            }
          }
        }
        j += 1;
      }
    }
    paramString = (String)localHashMap.get("street_address");
    if (!TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return paramString;
        localObject = (String)localHashMap.get("sublocality");
        paramString = (String)localObject;
      } while (!TextUtils.isEmpty((CharSequence)localObject));
      localObject = (String)localHashMap.get("locality");
      paramString = (String)localObject;
    } while (!TextUtils.isEmpty((CharSequence)localObject));
    return null;
  }
  
  public static void a()
  {
    c().e();
  }
  
  public static void a(Context paramContext)
  {
    if (a == null) {
      a = new m(paramContext);
    }
  }
  
  private void a(Location paramLocation)
  {
    q.a(this.d, paramLocation);
    if (this.e != null) {
      this.e.cancel(true);
    }
    this.e = new p(this, null);
    this.e.execute(new Location[] { paramLocation });
  }
  
  private WeatherBean b(Location paramLocation)
  {
    Object localObject = new e("http://goweatherex.3g.cn/goweatherex/weather/getNearestWeather");
    com.jiubang.goweather.b.g.a(this.f, (e)localObject);
    ((e)localObject).a("latlng", paramLocation.getLatitude() + "," + paramLocation.getLongitude());
    ((e)localObject).a("h", "24");
    com.jiubang.goweather.b.f localf;
    com.jiubang.goweather.b.c localc;
    try
    {
      paramLocation = ((e)localObject).i();
      if (paramLocation == null) {
        return null;
      }
    }
    catch (UnsupportedEncodingException paramLocation)
    {
      for (;;)
      {
        if (com.gtp.a.a.b.c.a()) {
          paramLocation.printStackTrace();
        }
        paramLocation = null;
      }
      localf = new com.jiubang.goweather.b.f();
      localc = d.a(true);
      if (!localc.a(localf, this.f)) {
        break label241;
      }
    }
    localf.d(1);
    localf.b(localc.b(paramLocation, (e)localObject, localf));
    localObject = new ArrayList();
    if (!TextUtils.isEmpty(localf.l()))
    {
      ((ArrayList)localObject).add(new a("", "", 0L));
      new h((ArrayList)localObject).a(localf.l(), localf, paramLocation, this.f);
    }
    if (localf.c() == 1)
    {
      localObject = (a)((ArrayList)localObject).get(0);
      paramLocation = new WeatherBean();
      paramLocation.j();
      paramLocation.g();
      paramLocation.h();
      paramLocation.a((a)localObject, "");
    }
    for (;;)
    {
      return paramLocation;
      label241:
      localf.b(11);
      localf.c(3);
      break;
      paramLocation = null;
    }
  }
  
  public static q b()
  {
    return c().d();
  }
  
  private static m c()
  {
    if (a == null) {
      throw new IllegalStateException("Did you forget to call PhotoLocationHandler.initSingleton(Context)?");
    }
    return a;
  }
  
  private q d()
  {
    if (q.a(this.d) == null)
    {
      ArrayList localArrayList = this.c.d();
      if (localArrayList.size() > 0) {
        q.a(this.d, (WeatherBean)localArrayList.get(0));
      }
    }
    return this.d;
  }
  
  private void e()
  {
    int k = 0;
    if (SystemClock.elapsedRealtime() - this.g > 1800000L) {}
    for (int j = 1;; j = 0)
    {
      if (j == 0)
      {
        j = k;
        if (q.a(this.d) != null) {}
      }
      else
      {
        j = 1;
      }
      if (j != 0) {
        this.b.a();
      }
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/takephoto/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */