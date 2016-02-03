package com.gau.go.launcherex.gowidget.weather.globaltheme.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.gau.go.launcherex.gowidget.weather.d.f;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  private Context a;
  private boolean b = false;
  private SharedPreferences c;
  
  public a(Context paramContext)
  {
    this.a = paramContext;
    this.c = GoWidgetApplication.c(paramContext).a();
  }
  
  private String a(Context paramContext)
  {
    paramContext = new StringBuffer();
    paramContext.append("http://goadv.3g.cn/GoAdCenter/common").append("?");
    paramContext.append("funid").append("=").append("1");
    paramContext.append("&").append("rd").append("=").append(String.valueOf(System.currentTimeMillis()));
    return paramContext.toString();
  }
  
  private JSONObject b(Context paramContext)
  {
    com.gau.go.launcherex.gowidget.weather.globaltheme.a.a.a locala = new com.gau.go.launcherex.gowidget.weather.globaltheme.a.a.a();
    locala.a = 3;
    locala.c = 1;
    locala.b = y.v(paramContext);
    locala.d = y.c(paramContext);
    locala.e = y.d(paramContext);
    try
    {
      locala.f = Integer.valueOf(y.f(this.a)).intValue();
      locala.g = y.n(paramContext);
      locala.h = y.k(paramContext);
      locala.i = Build.VERSION.SDK_INT;
      locala.j = y.r(paramContext);
      paramContext = new JSONObject();
      localJSONObject = new JSONObject();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          JSONObject localJSONObject;
          localJSONObject.put("pversion", locala.a);
          localJSONObject.put("aid", locala.b);
          localJSONObject.put("cid", locala.c);
          localJSONObject.put("cversion", locala.d);
          localJSONObject.put("uid", locala.e);
          localJSONObject.put("channel", locala.f);
          localJSONObject.put("local", locala.g);
          localJSONObject.put("lang", locala.h);
          localJSONObject.put("sdk", locala.i);
          localJSONObject.put("imsi", locala.j);
          paramContext.put("phead", localJSONObject);
          return paramContext;
        }
        catch (JSONException paramContext)
        {
          paramContext.printStackTrace();
        }
        localException = localException;
        localException.printStackTrace();
      }
    }
    return null;
  }
  
  public void a()
  {
    f localf = GoWidgetApplication.b(this.a);
    if ((localf.a(2)) || (localf.a(1)) || (localf.a(32)) || (localf.a(128))) {}
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (!this.b))
      {
        this.b = true;
        new c(this, null).execute(new Object[0]);
      }
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/globaltheme/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */