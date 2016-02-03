package com.gau.go.launcherex.gowidget.weather.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.d.g;
import com.gau.go.launcherex.gowidget.weather.model.ThemeDataBean;
import com.gau.go.launcherex.gowidget.weather.model.t;
import com.gtp.a.a.b.c;
import java.util.ArrayList;
import java.util.List;

class z
  extends AsyncTask
{
  private z(x paramx) {}
  
  protected Boolean a(Void... paramVarArgs)
  {
    Object localObject1 = null;
    boolean bool2 = true;
    boolean bool3 = false;
    long l = x.a(this.a);
    c.a("LJL", "syncTime-------" + l);
    if (l + 86400000L > System.currentTimeMillis()) {
      return Boolean.valueOf(false);
    }
    ArrayList localArrayList = new ArrayList();
    x.a(this.a, localArrayList);
    x.a(this.a, false);
    Object localObject2 = x.b(this.a, localArrayList);
    if (x.b(this.a))
    {
      g.a(x.c(this.a), "/GOWeatherEX/download", "hiWeather.ex", true);
      x.d(this.a);
      return Boolean.valueOf(true);
    }
    if (localObject2 == null) {
      return Boolean.valueOf(false);
    }
    int j = ((ArrayList)localObject2).size();
    paramVarArgs = "com.gau.go.launcherex.gowidget.weatherwidget.launchimage." + x.e(this.a);
    c.a("LJL", "mLanguageSetting---" + x.e(this.a));
    int i = 0;
    if (i < j) {
      if (!paramVarArgs.equalsIgnoreCase(((ThemeDataBean)((ArrayList)localObject2).get(i)).i())) {}
    }
    for (paramVarArgs = (ThemeDataBean)((ArrayList)localObject2).get(i);; paramVarArgs = null)
    {
      if (paramVarArgs == null)
      {
        Object localObject3 = x.e(this.a).split("_");
        c.a("LJL", "langLocale.length---" + localObject3.length);
        if ((localObject3.length == 2) && (!TextUtils.isEmpty(localObject3[0])))
        {
          c.a("LJL", "langLocale[0]---" + localObject3[0]);
          localObject3 = "com.gau.go.launcherex.gowidget.weatherwidget.launchimage." + localObject3[0];
          i = 0;
          label359:
          if (i < j)
          {
            if ("com.gau.go.launcherex.gowidget.weatherwidget.launchimage.en".equalsIgnoreCase(((ThemeDataBean)((ArrayList)localObject2).get(i)).i())) {
              localObject1 = (ThemeDataBean)((ArrayList)localObject2).get(i);
            }
            if (((String)localObject3).equalsIgnoreCase(((ThemeDataBean)((ArrayList)localObject2).get(i)).i()))
            {
              localObject2 = (ThemeDataBean)((ArrayList)localObject2).get(i);
              paramVarArgs = (Void[])localObject1;
              localObject1 = localObject2;
            }
          }
        }
      }
      for (;;)
      {
        if (localObject1 == null) {}
        for (;;)
        {
          if (paramVarArgs == null)
          {
            g.a(x.c(this.a), "/GOWeatherEX/download", "hiWeather.ex", true);
            x.d(this.a);
            return Boolean.valueOf(true);
            i += 1;
            break;
            i += 1;
            break label359;
          }
          localArrayList.clear();
          x.a(this.a, localArrayList, paramVarArgs);
          paramVarArgs = x.c(this.a, localArrayList);
          if (paramVarArgs == null) {
            return Boolean.valueOf(false);
          }
          boolean bool1 = bool3;
          if (!TextUtils.isEmpty(paramVarArgs.a()))
          {
            paramVarArgs = paramVarArgs.a().split("#");
            bool1 = bool3;
            if (paramVarArgs != null)
            {
              bool1 = bool3;
              if (paramVarArgs.length > 0)
              {
                localArrayList.clear();
                x.a(this.a, localArrayList, paramVarArgs[0]);
                paramVarArgs = x.a(this.a, paramVarArgs[0]);
                bool1 = bool3;
                if (paramVarArgs != null)
                {
                  localObject1 = g.a(paramVarArgs, "/GOWeatherEX/download", "hiWeather.ex", Bitmap.CompressFormat.PNG, 100, x.c(this.a), true);
                  paramVarArgs.recycle();
                  if (localObject1 == null) {
                    break label653;
                  }
                }
              }
            }
          }
          label653:
          for (bool1 = bool2;; bool1 = false)
          {
            if (bool1) {
              x.d(this.a);
            }
            return Boolean.valueOf(bool1);
          }
          paramVarArgs = (Void[])localObject1;
        }
        localObject2 = paramVarArgs;
        paramVarArgs = (Void[])localObject1;
        localObject1 = localObject2;
        continue;
        localObject2 = null;
        localObject1 = paramVarArgs;
        paramVarArgs = (Void[])localObject2;
      }
    }
  }
  
  protected void a(Boolean paramBoolean)
  {
    x.f(null);
    x.b(this.a, false);
  }
  
  protected void b(Void... paramVarArgs) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/b/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */