package com.gau.go.launcherex.gowidget.weather.a;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.statistics.j;
import com.gau.go.launcherex.gowidget.weather.a.a.a;
import com.gau.go.launcherex.gowidget.weather.model.b;
import com.jiubang.goweather.b.d;
import com.jiubang.goweather.b.e;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class h
  extends AsyncTask
{
  private h(f paramf) {}
  
  private i a(e parame)
  {
    i locali = new i();
    locali.b.b = 2;
    com.jiubang.goweather.b.c localc = null;
    Object localObject;
    try
    {
      localObject = parame.i();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return locali;
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        locali.a.b(11);
        locali.a.c(4);
        locali.a.a(localUnsupportedEncodingException);
        localObject = localc;
        if (com.gtp.a.a.b.c.a())
        {
          localUnsupportedEncodingException.printStackTrace();
          localObject = localc;
        }
      }
      locali.a.d(3);
      localc = d.a();
      if (localc.a(locali.a, this.a.a)) {
        break label202;
      }
    }
    locali.a.b(11);
    locali.a.c(3);
    switch (locali.a.c())
    {
    }
    for (;;)
    {
      new com.gau.go.launcherex.gowidget.statistics.h(this.a.a).b((String)localObject, locali.a);
      return locali;
      label202:
      locali.a.a(SystemClock.elapsedRealtime());
      parame = localc.b((String)localObject, parame, locali.a);
      locali.a.b(SystemClock.elapsedRealtime());
      if (TextUtils.isEmpty(parame)) {
        break;
      }
      try
      {
        locali.a.b(parame);
        locali.a.c(SystemClock.elapsedRealtime());
        a(parame, locali);
        locali.a.d(SystemClock.elapsedRealtime());
        if (locali.a.h() != 0L) {
          break;
        }
        locali.a.c(0L);
        break;
      }
      catch (JSONException parame)
      {
        locali.a.b(11);
        locali.a.c(10);
        locali.a.a(parame);
        if (com.gtp.a.a.b.c.a()) {
          parame.printStackTrace();
        }
        if (locali.a.h() != 0L) {
          break;
        }
        locali.a.c(0L);
        break;
      }
      finally
      {
        if (locali.a.h() == 0L) {
          locali.a.c(0L);
        }
      }
      locali.b.b = 1;
      continue;
      int i = locali.a.e();
      if (i == 0) {
        locali.b.b = 1;
      } else if ((i == 6) || (i == 12)) {
        locali.b.b = 3;
      } else if (i == 3) {
        locali.b.b = 2;
      } else {
        locali.b.b = 1;
      }
    }
  }
  
  private void a(String paramString, i parami)
  {
    a locala = parami.b;
    paramString = new JSONObject(paramString);
    Object localObject1 = paramString.getJSONObject("head");
    int i = ((JSONObject)localObject1).optInt("result", -1);
    if (i == 0)
    {
      parami.a.b(11);
      parami.a.c(0);
    }
    int j = ((JSONObject)localObject1).optInt("costTime", 0);
    parami.a.e(j);
    if (i == 1)
    {
      localObject1 = paramString.getJSONArray("cities");
      if (localObject1 != null)
      {
        j = ((JSONArray)localObject1).length();
        i = 0;
        while (i < j)
        {
          Object localObject2 = ((JSONArray)localObject1).getJSONObject(i);
          String str1 = ((JSONObject)localObject2).getString("city");
          String str2 = ((JSONObject)localObject2).getString("cityId");
          String str3 = ((JSONObject)localObject2).getString("state");
          String str4 = ((JSONObject)localObject2).getString("country");
          localObject2 = ((JSONObject)localObject2).getString("timeZone");
          String str5 = str1 + ", " + str3 + ", (" + str4 + ")";
          locala.a.add(new b(str2, str1, str3, str4, (String)localObject2, str5));
          i += 1;
        }
      }
      paramString = paramString.getString("more");
      if ((TextUtils.isEmpty(paramString)) || (paramString.equalsIgnoreCase("NULL"))) {
        break label279;
      }
      locala.a(true);
      locala.a(paramString);
    }
    for (;;)
    {
      parami.a.b(1);
      return;
      label279:
      locala.a(null);
      locala.a(false);
    }
  }
  
  protected i a(e... paramVarArgs)
  {
    return a(paramVarArgs[0]);
  }
  
  protected void a(i parami)
  {
    parami.b.c = this.a.b;
    this.a.b = null;
    if (isCancelled()) {
      return;
    }
    this.a.a(parami.b);
    j.a(this.a.a).a(parami.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */