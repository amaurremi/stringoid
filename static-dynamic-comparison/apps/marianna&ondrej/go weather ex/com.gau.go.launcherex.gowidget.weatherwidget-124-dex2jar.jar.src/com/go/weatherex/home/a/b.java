package com.go.weatherex.home.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.format.Time;
import com.gau.go.launcherex.gowidget.scriptengine.parser.i;
import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.c.g;
import com.gau.go.launcherex.gowidget.weather.globaltheme.c.d;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.model.q;
import com.gau.go.launcherex.gowidget.weather.util.f;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;

class b
  extends BroadcastReceiver
{
  b(a parama) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool = true;
    if (paramIntent == null) {}
    label267:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                paramContext = paramIntent.getAction();
                if (paramContext.equals("android.intent.action.TIME_TICK"))
                {
                  if ((a.b(this.a).d()) && (a.c(this.a) != null)) {}
                  for (paramContext = a.b(this.a).b(a.c(this.a).k.n());; paramContext = a.b(this.a).c())
                  {
                    a.a(this.a, paramContext.hour, paramContext.minute);
                    return;
                  }
                }
                if ((!paramContext.equals("android.intent.action.TIME_SET")) && (!paramContext.equals("android.intent.action.TIMEZONE_CHANGED")) && (!paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_WORLD_CLOCK"))) {
                  break;
                }
              } while (a.c(this.a) == null);
              a.a(this.a, a.d(this.a), a.e(this.a), false);
              return;
              if (!paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.goweather.ACTION_UPDATE_DATA")) {
                break label267;
              }
              paramContext = a.f(this.a).d();
              if (a.c(this.a) != null) {
                break;
              }
            } while (paramContext.isEmpty());
            a.a(this.a, (WeatherBean)paramContext.get(0));
            for (int i = a.c(this.a).k.d();; i = a.c(this.a).k.d())
            {
              a.g(this.a);
              a.a(this.a, i, a.e(this.a), false);
              return;
            }
            if (!paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_SCREEN_BACKGROUND_LOADING_FINISH")) {
              break;
            }
          } while (a.c(this.a) == null);
          a.a(this.a, a.d(this.a), a.e(this.a), true);
          return;
          if ("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DYNAMICBACKGROUND_ONE_RELOAD_DONE".equals(paramContext))
          {
            a.a(this.a, a.d(this.a), a.e(this.a), true);
            return;
          }
          if (!paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_BACKGROUND_CHANGE_FINISH")) {
            break;
          }
          if (d.a(a.h(this.a).a()))
          {
            this.a.b();
            return;
          }
          paramIntent = paramIntent.getStringExtra("extra_background_loaded");
          paramContext = a.a(this.a, a.d(this.a), a.e(this.a));
        } while ((paramIntent == null) || (!paramIntent.equals(paramContext)));
        paramIntent = a.h(this.a).a(paramContext);
        if (paramIntent != null) {
          break;
        }
        a.a(this.a, 2131165776);
      } while (a.i(this.a) >= 3);
      a.j(this.a);
      a.h(this.a).b(paramContext);
      return;
      a.b(this.a, 0);
      paramContext = a.h(this.a).a();
      a.a(this.a, new c(this.a, paramIntent, paramContext));
      a.l(this.a).execute(a.k(this.a));
      return;
    } while (!paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_CHANGE_DYNAMIC_BG"));
    paramContext = this.a;
    if (a.m(this.a).a().l == 1) {}
    for (;;)
    {
      a.a(paramContext, bool);
      a.h(this.a).b(a.e(this.a));
      return;
      bool = false;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */