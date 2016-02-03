package com.gau.go.launcherex.gowidget.gcm;

import android.app.AlarmManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.gau.go.launcherex.gowidget.weather.util.r;
import com.jiubang.core.b.a;
import java.util.ArrayList;

class c
  extends BroadcastReceiver
{
  c(b paramb) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    boolean bool2;
    if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DATA_READY"))
    {
      paramContext = GoWidgetApplication.c(b.a(this.a).getApplicationContext()).a();
      paramIntent = paramContext.getString("gcm_cur_reg_id", null);
      if ((paramIntent != null) && (paramIntent.length() > 0))
      {
        boolean bool1 = paramContext.getBoolean("language_changed", true);
        bool2 = paramContext.getBoolean("city_list_changed", false);
        if (bool1)
        {
          paramContext.edit().putBoolean("language_changed", false).commit();
          this.a.a(paramIntent, paramIntent, bool2);
          if (!bool2) {}
        }
      }
    }
    label135:
    label466:
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
                paramContext.edit().putBoolean("city_list_changed", false).commit();
                break label135;
                break label135;
                break label135;
                break label135;
                do
                {
                  return;
                } while (!bool2);
                paramContext.edit().putBoolean("city_list_changed", false).commit();
              } while (com.gau.go.launcherex.gowidget.weather.util.f.a(b.a(this.a)).e() <= 0);
              this.a.b();
              return;
              this.a.c();
              return;
              if (!paramContext.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                break;
              }
            } while (paramIntent.getBooleanExtra("noConnectivity", false));
            b.e(this.a).cancel(b.d(this.a));
            this.a.a();
            return;
            if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_GCM_OPERATION"))
            {
              paramIntent = paramIntent.getStringExtra("extra_gcm_id");
              if ((paramIntent != null) && (!paramIntent.equals("")))
              {
                if (b.b(this.a).size() > 0)
                {
                  paramContext = (e)b.b(this.a).get(0);
                  paramContext.c = paramIntent;
                  paramIntent = new StringBuilder().append("http://goweathergcm.goforandroid.com:8099/gcmServer/alarm/registry?regId=").append(paramIntent).append("&").append("lang").append("=").append(y.k(b.a(this.a))).append("&").append("region").append("=").append(b.f(this.a)).append("&").append("is_paid_user").append("=");
                  if (!GoWidgetApplication.b(b.a(this.a)).b()) {
                    break label466;
                  }
                }
                for (int i = 1;; i = 0)
                {
                  paramContext.a = i;
                  new d(this.a).execute(new e[] { paramContext });
                  return;
                  paramContext = new e(this.a, 1);
                  b.b(this.a).add(paramContext);
                  break;
                }
              }
              b.a(this.a, false);
              b.c(this.a);
              return;
            }
            if (!paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_GCM_UPDATE_REG_ID")) {
              break;
            }
            paramContext = paramIntent.getStringExtra("extra_old_reg_id");
            paramIntent = paramIntent.getStringExtra("extra_cur_reg_id");
          } while ((paramContext == null) || (paramContext.length() <= 0) || (paramIntent == null) || (paramIntent.length() <= 0));
          b.e(this.a).cancel(b.d(this.a));
          this.a.a(paramIntent, paramContext, false);
          return;
          if (!paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_LAUNCH_GCM_TASKS")) {
            break;
          }
          b.e(this.a).cancel(b.d(this.a));
        } while (!r.c(b.a(this.a)));
        this.a.a();
        return;
      } while (!paramContext.equals("android.intent.action.LOCALE_CHANGED"));
      paramContext = GoWidgetApplication.c(b.a(this.a).getApplicationContext()).a();
      paramContext.edit().putBoolean("language_changed", true).commit();
      paramContext = paramContext.getString("gcm_cur_reg_id", null);
    } while (TextUtils.isEmpty(paramContext));
    this.a.a(paramContext, paramContext, false);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/gcm/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */