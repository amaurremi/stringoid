package com.gtp.go.weather.sharephoto.a;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.gtp.go.weather.sharephoto.b.o;
import org.json.JSONException;
import org.json.JSONObject;

class c
  extends AsyncTask
{
  private String b = null;
  private String c = null;
  private boolean d;
  
  public c(a parama, boolean paramBoolean, String paramString1, String paramString2)
  {
    this.d = paramBoolean;
    this.b = paramString1;
    this.c = paramString2;
  }
  
  protected o a(Object... paramVarArgs)
  {
    Object localObject2 = null;
    if (!TextUtils.isEmpty(this.b)) {}
    for (String str = this.b;; str = null)
    {
      o localo = new o();
      paramVarArgs = f.a(a.a(this.a));
      Object localObject1 = "";
      if (paramVarArgs != null) {
        localObject1 = paramVarArgs.toString();
      }
      com.gtp.a.a.b.c.a("login", "pheadData --> " + (String)localObject1);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {}
      do
      {
        return null;
        paramVarArgs = "";
        if (TextUtils.isEmpty(str)) {
          break;
        }
        paramVarArgs = a.a(this.a, 2, str, a.a(this.a)).toString();
        com.gtp.a.a.b.c.a("login", "userInfo --> " + paramVarArgs);
        com.gtp.a.a.b.c.a("login", "url --> " + "http://gows.goforandroid.com/goweatherexSns/registry/user");
        paramVarArgs = f.a(a.a(this.a), "http://gows.goforandroid.com/goweatherexSns/registry/user", 0, 0, (String)localObject1, paramVarArgs);
        com.gtp.a.a.b.c.a("login", "result --> " + paramVarArgs);
      } while (TextUtils.isEmpty(paramVarArgs));
      for (;;)
      {
        try
        {
          localObject1 = new JSONObject(paramVarArgs);
          paramVarArgs = (Object[])localObject2;
          if (localObject1 != null) {
            paramVarArgs = ((JSONObject)localObject1).optJSONObject("head");
          }
          if (paramVarArgs == null) {
            continue;
          }
          i = paramVarArgs.optInt("result", 0);
          if (i == 1)
          {
            paramVarArgs = ((JSONObject)localObject1).optJSONObject("user");
            if (paramVarArgs == null) {
              continue;
            }
            paramVarArgs = paramVarArgs.optString("userId");
            com.gtp.a.a.b.c.a("login", "userId = " + paramVarArgs);
            if ((!TextUtils.isEmpty(paramVarArgs)) && (!paramVarArgs.equals("0")))
            {
              localo.a(paramVarArgs);
              localo.a(System.currentTimeMillis());
              localo.b(str);
              localObject1 = new ContentValues();
              ((ContentValues)localObject1).put("user_id", paramVarArgs);
              if (TextUtils.isEmpty(str)) {
                continue;
              }
              ((ContentValues)localObject1).put("user_gmail", str);
              a.a(this.a).getContentResolver().insert(WeatherContentProvider.u, (ContentValues)localObject1);
            }
          }
        }
        catch (JSONException paramVarArgs)
        {
          int i;
          if (!com.gtp.a.a.b.c.a()) {
            continue;
          }
          paramVarArgs.printStackTrace();
          continue;
        }
        return localo;
        if (TextUtils.isEmpty(this.c)) {
          break;
        }
        paramVarArgs = a.a(this.a, 1, this.c, a.a(this.a)).toString();
        break;
        i = -1;
        continue;
        paramVarArgs = "";
        continue;
        if (!TextUtils.isEmpty(this.c)) {
          ((ContentValues)localObject1).put("go_id", this.c);
        }
      }
    }
  }
  
  protected void a(o paramo)
  {
    super.onPostExecute(paramo);
    Object localObject;
    boolean bool;
    if ((paramo != null) && (!TextUtils.isEmpty(paramo.a())))
    {
      if (a.b(this.a) != null)
      {
        a.b(this.a).a(paramo);
        a.c(this.a);
        a.d(this.a);
      }
    }
    else if ((this.d) && (a.e(this.a) != null))
    {
      localObject = a.e(this.a);
      if (paramo == null) {
        break label181;
      }
      if (TextUtils.isEmpty(paramo.a())) {
        break label176;
      }
      bool = true;
    }
    for (;;)
    {
      ((e)localObject).a(bool);
      a.a(this.a, false);
      return;
      if (TextUtils.isEmpty(paramo.a())) {
        break;
      }
      localObject = g.a(a.a(this.a));
      o localo = ((g)localObject).b();
      localo.a(paramo.a());
      localo.b(paramo.b());
      localo.c(paramo.d());
      ((g)localObject).b(paramo);
      break;
      label176:
      bool = false;
      continue;
      label181:
      bool = false;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */