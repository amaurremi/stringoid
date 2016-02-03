package com.gau.go.launcherex.gowidget.weather.service;

import android.app.Notification;
import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.language.d;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.gau.go.launcherex.gowidget.weather.systemwidget.AppWidget21Provider;
import com.gau.go.launcherex.gowidget.weather.systemwidget.AppWidget41Provider;
import com.gau.go.launcherex.gowidget.weather.systemwidget.AppWidget42Provider;
import com.gau.go.launcherex.gowidget.weather.systemwidget.AppWidgetDays41Provider;
import com.gau.go.launcherex.gowidget.weather.systemwidget.AppWidgetDays42Provider;
import com.gau.go.launcherex.gowidget.weather.systemwidget.AppWidgetWorldClock42Provider;
import com.gau.go.launcherex.gowidget.weather.systemwidget.ab;
import com.gau.go.launcherex.gowidget.weather.systemwidget.af;
import com.gau.go.launcherex.gowidget.weather.systemwidget.al;
import com.gau.go.launcherex.gowidget.weather.systemwidget.e;
import com.gau.go.launcherex.gowidget.weather.systemwidget.m;
import com.gau.go.launcherex.gowidget.weather.systemwidget.v;
import com.gau.go.launcherex.gowidget.weather.systemwidget.x;
import com.gtp.a.a.b.c;

public class AppWidgetService
  extends Service
  implements com.gau.go.launcherex.gowidget.language.i
{
  private b a;
  private com.gau.go.launcherex.gowidget.weather.systemwidget.a b;
  private e c;
  private com.gau.go.launcherex.gowidget.weather.systemwidget.i d;
  private m e;
  private com.gau.go.launcherex.gowidget.weather.systemwidget.q f;
  private af g;
  private al h;
  private x i;
  private int j = 0;
  
  private int a()
  {
    Cursor localCursor = getContentResolver().query(WeatherContentProvider.a, new String[] { "cityId" }, null, null, null);
    if (localCursor != null)
    {
      int k = localCursor.getCount();
      try
      {
        localCursor.close();
        return k;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return k;
      }
    }
    return 0;
  }
  
  private void a(int paramInt)
  {
    c.a("appwidget_service", "checkStopService - " + paramInt);
    if ((!com.gau.go.launcherex.gowidget.weather.globaltheme.a.e(getApplicationContext())) && (!com.gau.go.launcherex.gowidget.weather.globaltheme.a.c(getApplicationContext())) && (!com.gau.go.launcherex.gowidget.weather.globaltheme.a.a(getApplicationContext(), AppWidget42Provider.class)) && (!com.gau.go.launcherex.gowidget.weather.globaltheme.a.a(getApplicationContext(), AppWidgetDays42Provider.class)) && (!com.gau.go.launcherex.gowidget.weather.globaltheme.a.a(getApplicationContext(), AppWidget41Provider.class)) && (!com.gau.go.launcherex.gowidget.weather.globaltheme.a.a(getApplicationContext(), AppWidgetDays41Provider.class)))
    {
      c.a("appwidget_service", "stopService - " + paramInt);
      stopSelfResult(paramInt);
    }
  }
  
  private void a(Intent paramIntent)
  {
    if (com.gau.go.launcherex.gowidget.weather.globaltheme.a.a(this, AppWidget21Provider.class))
    {
      if (this.b == null)
      {
        com.gtp.a.a.a.a.a().a("AppWidget21ProviderHelper start", "AppWidget Service.txt");
        this.b = new com.gau.go.launcherex.gowidget.weather.systemwidget.a(getApplicationContext());
      }
      this.b.a(paramIntent);
    }
    if (com.gau.go.launcherex.gowidget.weather.globaltheme.a.a(this, AppWidget41Provider.class))
    {
      if (this.c == null)
      {
        com.gtp.a.a.a.a.a().a("AppWidget41ProviderHelper start", "AppWidget Service.txt");
        this.c = new e(getApplicationContext());
      }
      this.c.a(paramIntent);
    }
    if (com.gau.go.launcherex.gowidget.weather.globaltheme.a.a(this, AppWidget42Provider.class))
    {
      if (this.d == null)
      {
        com.gtp.a.a.a.a.a().a("AppWidget42ProviderHelper start", "AppWidget Service.txt");
        this.d = new com.gau.go.launcherex.gowidget.weather.systemwidget.i(getApplicationContext());
      }
      this.d.a(paramIntent);
    }
    if (com.gau.go.launcherex.gowidget.weather.globaltheme.a.a(this, AppWidgetDays41Provider.class))
    {
      if (this.e == null)
      {
        com.gtp.a.a.a.a.a().a("AppWidgetDays41ProviderHelper start", "AppWidget Service.txt");
        this.e = new m(getApplicationContext());
      }
      this.e.a(paramIntent);
    }
    if (com.gau.go.launcherex.gowidget.weather.globaltheme.a.a(this, AppWidgetDays42Provider.class))
    {
      if (this.f == null)
      {
        com.gtp.a.a.a.a.a().a("AppWidgetDays42ProviderHelper start", "AppWidget Service.txt");
        this.f = new com.gau.go.launcherex.gowidget.weather.systemwidget.q(getApplicationContext());
      }
      this.f.a(paramIntent);
    }
    if (com.gau.go.launcherex.gowidget.weather.globaltheme.a.a(this, AppWidgetWorldClock42Provider.class))
    {
      if (this.g == null)
      {
        com.gtp.a.a.a.a.a().a("AppWidgetWorldClock42ProviderHelper start", "AppWidget Service.txt");
        this.g = new af(getApplicationContext());
      }
      this.g.a(paramIntent);
    }
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    localIntent.setPackage("com.android.vending");
    localIntent.setFlags(268435456);
    try
    {
      startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
      paramString.setFlags(268435456);
      try
      {
        startActivity(paramString);
        return;
      }
      catch (ActivityNotFoundException paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void b()
  {
    startService(new Intent(this, AppWidgetService.class));
  }
  
  private void c()
  {
    com.gtp.a.a.a.a.a().a("AppWidgetService start", "AppWidget Service.txt");
    a(new Intent("android.appwidget.action.APPWIDGET_ENABLED"));
  }
  
  public void e()
  {
    c.a("AppWidgetService", "onLanguageRefresh");
    a(new Intent("appwidget_language_change"));
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = d.a(getApplicationContext());
    paramConfiguration.i();
    if (paramConfiguration.c().equalsIgnoreCase("default")) {
      e();
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (Build.VERSION.SDK_INT <= 17) {
      startForeground(7, new Notification());
    }
    d.a(getApplicationContext());
    ab.a(getApplicationContext());
    this.i = x.a(getApplicationContext());
    v.a(getApplicationContext());
    this.h = new al(getApplicationContext());
    this.a = new b(this, null);
    this.j = a();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_USER_LANGUAGE_CHANGED");
    if (this.j < 1) {
      localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_INITIALIZED_CITY");
    }
    registerReceiver(this.a, localIntentFilter);
    c();
    startService(new Intent(this, NotifyService.class));
  }
  
  public void onDestroy()
  {
    c.a("AppWidgetService", "onDestroy");
    com.gtp.a.a.a.a.a().a("AppWidgetService end", "AppWidget Service.txt");
    super.onDestroy();
    unregisterReceiver(this.a);
    if ((com.gau.go.launcherex.gowidget.weather.globaltheme.a.a(getApplicationContext(), AppWidget42Provider.class)) || (com.gau.go.launcherex.gowidget.weather.globaltheme.a.a(getApplicationContext(), AppWidgetDays42Provider.class)) || (com.gau.go.launcherex.gowidget.weather.globaltheme.a.a(getApplicationContext(), AppWidget41Provider.class)) || (com.gau.go.launcherex.gowidget.weather.globaltheme.a.a(getApplicationContext(), AppWidgetDays41Provider.class)) || (com.gau.go.launcherex.gowidget.weather.globaltheme.a.a(getApplicationContext(), AppWidget21Provider.class)) || (com.gau.go.launcherex.gowidget.weather.globaltheme.a.a(getApplicationContext(), AppWidgetWorldClock42Provider.class)))
    {
      b();
      return;
    }
    if (this.b != null)
    {
      this.b.a();
      this.b = null;
    }
    if (this.c != null)
    {
      this.c.a();
      this.c = null;
    }
    if (this.d != null)
    {
      this.d.a();
      this.d = null;
    }
    if (this.e != null)
    {
      this.e.a();
      this.e = null;
    }
    if (this.f != null)
    {
      this.f.a();
      this.f = null;
    }
    if (this.g != null)
    {
      this.g.a();
      this.g = null;
    }
    x.b();
    ab.b();
    this.i = null;
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    int k = 0;
    Object localObject;
    if (this.j < 1)
    {
      this.j = a();
      if (this.j < 1)
      {
        localObject = new Intent(this, NotifyService.class);
        ((Intent)localObject).putExtra("notify_request", 50);
        startService((Intent)localObject);
      }
    }
    if (paramIntent != null)
    {
      c.a("AppWidgetService", "onStartCommand>>intent.getAction(): " + paramIntent.getAction());
      localObject = paramIntent.getExtras();
      if (localObject != null) {
        switch (((Bundle)localObject).getInt("appwidget_service_request", -1))
        {
        }
      }
    }
    for (;;)
    {
      return super.onStartCommand(paramIntent, paramInt1, paramInt2);
      localObject = (Intent)paramIntent.getParcelableExtra("request_extra_appwidget_world_clock_42_enabled");
      if (this.g == null) {
        this.g = new af(getApplicationContext());
      }
      if (localObject != null)
      {
        this.g.a((Intent)localObject);
        String str = ((Intent)localObject).getAction();
        if ((!TextUtils.isEmpty(str)) && (str.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_WIDGET_DELETE_APPWIDGET_WORLDCLOCK42")))
        {
          c.a("AppWidgetService", "删除系统Widget操作 > worldclock42");
          if (AppWidgetManager.getInstance(getApplicationContext()).getAppWidgetIds(new ComponentName(getApplicationContext(), AppWidgetWorldClock42Provider.class)).length == 0)
          {
            v.a(getApplicationContext()).b(6);
          }
          else
          {
            localObject = ((Intent)localObject).getIntArrayExtra("extra_appwidget_ids");
            if (localObject != null)
            {
              k = 0;
              while (k < localObject.length)
              {
                v.a(getApplicationContext()).a(localObject[k]);
                k += 1;
              }
              if (this.g != null)
              {
                this.g.a();
                this.g = null;
              }
              a(paramInt2);
              continue;
              localObject = (Intent)paramIntent.getParcelableExtra("request_extra_appwidget_21");
              if (this.b == null) {
                this.b = new com.gau.go.launcherex.gowidget.weather.systemwidget.a(getApplicationContext());
              }
              if (localObject != null)
              {
                this.b.a((Intent)localObject);
                str = ((Intent)localObject).getAction();
                if ((!TextUtils.isEmpty(str)) && (str.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_WIDGET_DELETE_APPWIDGET21")))
                {
                  c.a("AppWidgetService", "删除系统Widget操作 > now21");
                  if (AppWidgetManager.getInstance(getApplicationContext()).getAppWidgetIds(new ComponentName(getApplicationContext(), AppWidget21Provider.class)).length == 0)
                  {
                    v.a(getApplicationContext()).b(3);
                  }
                  else
                  {
                    localObject = ((Intent)localObject).getIntArrayExtra("extra_appwidget_ids");
                    if (localObject != null)
                    {
                      while (k < localObject.length)
                      {
                        v.a(getApplicationContext()).a(localObject[k]);
                        k += 1;
                      }
                      if (this.b != null)
                      {
                        this.b.a();
                        this.b = null;
                      }
                      a(paramInt2);
                      continue;
                      c.a("AppWidgetService", "系统widget 4×2 Enable");
                      localObject = (Intent)paramIntent.getParcelableExtra("request_extra_appwidget_42");
                      if (this.d == null) {
                        this.d = new com.gau.go.launcherex.gowidget.weather.systemwidget.i(getApplicationContext());
                      }
                      if (localObject != null)
                      {
                        this.d.a((Intent)localObject);
                        str = ((Intent)localObject).getAction();
                        if ((!TextUtils.isEmpty(str)) && (str.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_WIDGET_DELETE_APPWIDGET42")))
                        {
                          c.a("AppWidgetService", "删除系统Widget操作 > now42");
                          if (AppWidgetManager.getInstance(getApplicationContext()).getAppWidgetIds(new ComponentName(getApplicationContext(), AppWidget42Provider.class)).length == 0)
                          {
                            v.a(getApplicationContext()).b(1);
                          }
                          else
                          {
                            localObject = ((Intent)localObject).getIntArrayExtra("extra_appwidget_ids");
                            if (localObject != null)
                            {
                              k = m;
                              while (k < localObject.length)
                              {
                                v.a(getApplicationContext()).a(localObject[k]);
                                k += 1;
                              }
                              c.a("AppWidgetService", "系统widget 4×2 Disable");
                              if (this.d != null)
                              {
                                this.d.a();
                                this.d = null;
                              }
                              a(paramInt2);
                              continue;
                              localObject = (Intent)paramIntent.getParcelableExtra("request_extra_appwidget_days_42");
                              if (this.f == null) {
                                this.f = new com.gau.go.launcherex.gowidget.weather.systemwidget.q(getApplicationContext());
                              }
                              if (localObject != null)
                              {
                                this.f.a((Intent)localObject);
                                str = ((Intent)localObject).getAction();
                                if ((!TextUtils.isEmpty(str)) && (str.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_WIDGET_DELETE_APPWIDGETDAYS42")))
                                {
                                  c.a("AppWidgetService", "删除系统Widget操作 > days42");
                                  if (AppWidgetManager.getInstance(getApplicationContext()).getAppWidgetIds(new ComponentName(getApplicationContext(), AppWidgetDays42Provider.class)).length == 0)
                                  {
                                    v.a(getApplicationContext()).b(4);
                                  }
                                  else
                                  {
                                    localObject = ((Intent)localObject).getIntArrayExtra("extra_appwidget_ids");
                                    if (localObject != null)
                                    {
                                      k = n;
                                      while (k < localObject.length)
                                      {
                                        v.a(getApplicationContext()).a(localObject[k]);
                                        k += 1;
                                      }
                                      if (this.f != null)
                                      {
                                        this.f.a();
                                        this.f = null;
                                      }
                                      a(paramInt2);
                                      continue;
                                      localObject = (Intent)paramIntent.getParcelableExtra("request_extra_appwidget_41");
                                      if (this.c == null) {
                                        this.c = new e(getApplicationContext());
                                      }
                                      if (localObject != null)
                                      {
                                        this.c.a((Intent)localObject);
                                        str = ((Intent)localObject).getAction();
                                        if ((!TextUtils.isEmpty(str)) && (str.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_WIDGET_DELETE_APPWIDGET41")))
                                        {
                                          c.a("AppWidgetService", "删除系统Widget操作 > now41");
                                          if (AppWidgetManager.getInstance(getApplicationContext()).getAppWidgetIds(new ComponentName(getApplicationContext(), AppWidget41Provider.class)).length == 0)
                                          {
                                            v.a(getApplicationContext()).b(2);
                                          }
                                          else
                                          {
                                            localObject = ((Intent)localObject).getIntArrayExtra("extra_appwidget_ids");
                                            if (localObject != null)
                                            {
                                              k = i1;
                                              while (k < localObject.length)
                                              {
                                                v.a(getApplicationContext()).a(localObject[k]);
                                                k += 1;
                                              }
                                              if (this.c != null)
                                              {
                                                this.c.a();
                                                this.c = null;
                                              }
                                              a(paramInt2);
                                              continue;
                                              localObject = (Intent)paramIntent.getParcelableExtra("request_extra_appwidget_days_41");
                                              if (this.e == null) {
                                                this.e = new m(getApplicationContext());
                                              }
                                              if (localObject != null)
                                              {
                                                this.e.a((Intent)localObject);
                                                str = ((Intent)localObject).getAction();
                                                if ((!TextUtils.isEmpty(str)) && (str.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_WIDGET_DELETE_APPWIDGETDAYS41")))
                                                {
                                                  c.a("AppWidgetService", "删除系统Widget操作 > days41");
                                                  if (AppWidgetManager.getInstance(getApplicationContext()).getAppWidgetIds(new ComponentName(getApplicationContext(), AppWidgetDays41Provider.class)).length == 0)
                                                  {
                                                    v.a(getApplicationContext()).b(5);
                                                  }
                                                  else
                                                  {
                                                    localObject = ((Intent)localObject).getIntArrayExtra("extra_appwidget_ids");
                                                    if (localObject != null)
                                                    {
                                                      k = i2;
                                                      while (k < localObject.length)
                                                      {
                                                        v.a(getApplicationContext()).a(localObject[k]);
                                                        k += 1;
                                                      }
                                                      if (this.e != null)
                                                      {
                                                        this.e.a();
                                                        this.e = null;
                                                      }
                                                      a(paramInt2);
                                                      continue;
                                                      if ((this.i != null) && (this.i.a))
                                                      {
                                                        this.h.b(this.i.a().H);
                                                      }
                                                      else
                                                      {
                                                        this.h.b();
                                                        continue;
                                                        if ((this.i != null) && (this.i.a))
                                                        {
                                                          this.h.a(this.i.a().I);
                                                        }
                                                        else
                                                        {
                                                          this.h.a();
                                                          continue;
                                                          m = paramIntent.getIntExtra("request_extra_appwidget_type", 0);
                                                          k = paramIntent.getIntExtra("extra_appwidget_ids", 0);
                                                          if ((m != 0) && (k != 0)) {
                                                            switch (m)
                                                            {
                                                            default: 
                                                              break;
                                                            case 1: 
                                                              if (this.d == null) {
                                                                this.d = new com.gau.go.launcherex.gowidget.weather.systemwidget.i(getApplicationContext());
                                                              }
                                                              localObject = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APPWIDGET42_CITY_CHANGE");
                                                              ((Intent)localObject).putExtra("extra_appwidget_ids", k);
                                                              this.d.a((Intent)localObject);
                                                              break;
                                                            case 3: 
                                                              if (this.b == null) {
                                                                this.b = new com.gau.go.launcherex.gowidget.weather.systemwidget.a(getApplicationContext());
                                                              }
                                                              localObject = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APPWIDGET21_CITY_CHANGE");
                                                              ((Intent)localObject).putExtra("extra_appwidget_ids", k);
                                                              this.b.a((Intent)localObject);
                                                              break;
                                                            case 2: 
                                                              if (this.c == null) {
                                                                this.c = new e(getApplicationContext());
                                                              }
                                                              localObject = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APPWIDGET41_CITY_CHANGE");
                                                              ((Intent)localObject).putExtra("extra_appwidget_ids", k);
                                                              this.c.a((Intent)localObject);
                                                              break;
                                                            case 5: 
                                                              if (this.e == null) {
                                                                this.e = new m(getApplicationContext());
                                                              }
                                                              localObject = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APPWIDGET_DAYS_41_CITY_CHANGE");
                                                              ((Intent)localObject).putExtra("extra_appwidget_ids", k);
                                                              this.e.a((Intent)localObject);
                                                              break;
                                                            case 4: 
                                                              if (this.f == null) {
                                                                this.f = new com.gau.go.launcherex.gowidget.weather.systemwidget.q(getApplicationContext());
                                                              }
                                                              localObject = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APPWIDGET_DAYS_42_CITY_CHANGE");
                                                              ((Intent)localObject).putExtra("extra_appwidget_ids", k);
                                                              this.f.a((Intent)localObject);
                                                              break;
                                                            case 6: 
                                                              if (this.g == null) {
                                                                this.g = new af(getApplicationContext());
                                                              }
                                                              m = paramIntent.getIntExtra("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APPWIDGET_WORLD_CLOCK_42_CITY_CHANGE", -1);
                                                              localObject = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APPWIDGET_WORLD_CLOCK_42_CITY_CHANGE");
                                                              ((Intent)localObject).putExtra("extra_appwidget_ids", k);
                                                              ((Intent)localObject).putExtra("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APPWIDGET_WORLD_CLOCK_42_CITY_CHANGE", m);
                                                              this.g.a((Intent)localObject);
                                                              continue;
                                                              k = paramIntent.getIntExtra("request_extra_appwidget_type", 0);
                                                              m = paramIntent.getIntExtra("extra_appwidget_ids", 0);
                                                              if ((k != 0) && (m != 0)) {
                                                                switch (k)
                                                                {
                                                                default: 
                                                                  break;
                                                                case 4: 
                                                                  if (this.f == null) {
                                                                    this.f = new com.gau.go.launcherex.gowidget.weather.systemwidget.q(getApplicationContext());
                                                                  }
                                                                  localObject = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APPWIDGET_DAYS_42_NEXT_PAGE");
                                                                  ((Intent)localObject).putExtra("extra_appwidget_ids", m);
                                                                  this.f.a((Intent)localObject);
                                                                  break;
                                                                case 5: 
                                                                  if (this.e == null) {
                                                                    this.e = new m(getApplicationContext());
                                                                  }
                                                                  localObject = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APPWIDGET_DAYS_41_NEXT_PAGE");
                                                                  ((Intent)localObject).putExtra("extra_appwidget_ids", m);
                                                                  this.e.a((Intent)localObject);
                                                                  continue;
                                                                  a(paramIntent.getStringExtra("request_extra_url"));
                                                                }
                                                              }
                                                              break;
                                                            }
                                                          }
                                                        }
                                                      }
                                                    }
                                                  }
                                                }
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/service/AppWidgetService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */