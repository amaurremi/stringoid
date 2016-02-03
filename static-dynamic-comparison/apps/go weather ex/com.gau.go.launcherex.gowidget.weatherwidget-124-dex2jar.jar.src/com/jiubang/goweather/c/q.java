package com.jiubang.goweather.c;

import android.content.Context;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.statistics.h;
import com.gau.go.launcherex.gowidget.statistics.j;
import com.gau.go.launcherex.gowidget.weather.model.b;
import com.gau.go.launcherex.gowidget.weather.model.p;
import com.jiubang.goweather.b.d;
import com.jiubang.goweather.b.e;
import com.jiubang.goweather.b.f;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class q
  extends AsyncTask
{
  private int a;
  private e b;
  private volatile boolean c;
  private s d;
  private p e;
  private Context f;
  
  private void a(String paramString, f paramf)
  {
    paramString = new JSONObject(paramString);
    Object localObject1 = paramString.getJSONObject("head");
    int i = ((JSONObject)localObject1).optInt("result", -1);
    if (i == 0)
    {
      paramf.b(11);
      paramf.c(0);
    }
    paramf.e(((JSONObject)localObject1).optInt("costTime", 0));
    if (i == 1)
    {
      localObject1 = paramString.getJSONArray("cities");
      if (localObject1 != null)
      {
        int j = ((JSONArray)localObject1).length();
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
          this.e.a().add(new b(str2, str1, str3, str4, (String)localObject2, str5));
          i += 1;
        }
      }
      paramString = paramString.getString("more");
      if (paramString.equalsIgnoreCase("NULL")) {
        break label256;
      }
      this.e.a(paramString);
      this.e.a(true);
    }
    for (;;)
    {
      paramf.b(1);
      return;
      label256:
      this.e.a(null);
      this.e.a(false);
    }
  }
  
  private f b()
  {
    f localf = new f();
    Object localObject3 = null;
    try
    {
      localObject1 = this.b.i();
      localf.d(3);
      localObject3 = d.a();
      if ((!this.c) && (!TextUtils.isEmpty((CharSequence)localObject1)))
      {
        if (!((com.jiubang.goweather.b.c)localObject3).a(localf, this.f))
        {
          localf.b(11);
          localf.c(3);
        }
      }
      else
      {
        if (!this.c) {
          new h(this.f).b((String)localObject1, localf);
        }
        return localf;
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        localf.b(11);
        localf.c(4);
        localf.a(localUnsupportedEncodingException);
        Object localObject1 = localObject3;
        if (!com.gtp.a.a.b.c.a()) {
          continue;
        }
        localUnsupportedEncodingException.printStackTrace();
        localObject1 = localObject3;
        continue;
        localf.a(SystemClock.elapsedRealtime());
        localObject3 = ((com.jiubang.goweather.b.c)localObject3).b((String)localObject1, this.b, localf);
        localf.b(SystemClock.elapsedRealtime());
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          continue;
        }
        try
        {
          if (!this.c)
          {
            localf.b((String)localObject3);
            localf.c(SystemClock.elapsedRealtime());
            a((String)localObject3, localf);
            localf.d(SystemClock.elapsedRealtime());
          }
          if (localf.h() != 0L) {
            continue;
          }
          localf.c(0L);
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localf.b(11);
            localf.c(10);
            localf.a(localJSONException);
            if (com.gtp.a.a.b.c.a()) {
              localJSONException.printStackTrace();
            }
            if (localf.h() != 0L) {
              break;
            }
          }
        }
        finally
        {
          if (localf.h() == 0L) {
            localf.c(0L);
          }
        }
      }
    }
  }
  
  protected f a(Object... paramVarArgs)
  {
    return b();
  }
  
  public void a()
  {
    this.c = true;
    this.d = null;
  }
  
  protected void a(f paramf)
  {
    super.onPostExecute(paramf);
    if ((!this.c) && (this.d != null)) {}
    switch (paramf.c())
    {
    default: 
      j.a(this.f).a(paramf);
      this.d.b();
      return;
    case 1: 
      j.a(this.f).a(paramf);
      this.d.a(this.e, this.a);
      return;
    }
    int i = paramf.e();
    if (i == 0)
    {
      j.a(this.f).a(paramf);
      this.d.c();
      return;
    }
    if (i == 3)
    {
      this.d.a();
      return;
    }
    j.a(this.f).a(paramf);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/goweather/c/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */