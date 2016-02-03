package com.gau.go.launcherex.gowidget.weather.service;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.messagecenter.util.w;
import com.gau.go.launcherex.gowidget.service.error.model.LocationErrorBean;
import com.gau.go.launcherex.gowidget.statistics.u;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.gau.go.launcherex.gowidget.weather.b.ae;
import com.gau.go.launcherex.gowidget.weather.b.ag;
import com.gau.go.launcherex.gowidget.weather.b.ai;
import com.gau.go.launcherex.gowidget.weather.b.an;
import com.gau.go.launcherex.gowidget.weather.b.ap;
import com.gau.go.launcherex.gowidget.weather.b.ar;
import com.gau.go.launcherex.gowidget.weather.b.aw;
import com.gau.go.launcherex.gowidget.weather.b.ax;
import com.gau.go.launcherex.gowidget.weather.b.ba;
import com.gau.go.launcherex.gowidget.weather.b.bd;
import com.gau.go.launcherex.gowidget.weather.b.m;
import com.gau.go.launcherex.gowidget.weather.d.p;
import com.gau.go.launcherex.gowidget.weather.view.WeatherDetailActivity;
import com.google.analytics.tracking.android.GAServiceManager;
import com.gtp.go.weather.a.a.b;
import com.gtp.go.weather.sharephoto.b.g;
import com.gtp.go.weather.sharephoto.photo.f;
import java.io.File;
import java.util.ArrayList;

public class NotifyService
  extends Service
{
  private ag a;
  private ae b;
  private bd c;
  private Notification d;
  private ai e;
  private ar f;
  private ax g;
  private Handler h;
  private an i;
  private p j;
  private com.gau.go.launcherex.gowidget.weather.globaltheme.a.a k;
  private ap l;
  
  private void a()
  {
    if (com.gau.go.launcherex.gowidget.weather.globaltheme.a.a(this)) {
      startService(new Intent(this, AppWidgetService.class));
    }
  }
  
  private void a(Bundle paramBundle)
  {
    ArrayList localArrayList = paramBundle.getParcelableArrayList("req_arg");
    if (localArrayList != null)
    {
      int m = paramBundle.getInt("updateWay", 1);
      this.i.a(localArrayList, m);
    }
  }
  
  private void a(Bundle paramBundle, int paramInt)
  {
    ArrayList localArrayList = paramBundle.getParcelableArrayList("req_arg");
    int m = paramBundle.getInt("updateWay", 1);
    this.i.a(localArrayList, paramInt, m);
  }
  
  private void b()
  {
    com.gau.go.launcherex.gowidget.statistics.j localj = com.gau.go.launcherex.gowidget.statistics.j.a(getApplicationContext());
    long l1 = getSharedPreferences("network_time_and_status_schedule_task", 0).getLong("upload_time", 0L);
    Log.i("NotifyService", "lastTime : " + l1);
    if (l1 == 0L)
    {
      localj.a(180000L);
      return;
    }
    l1 = System.currentTimeMillis() - l1;
    Log.i("NotifyService", "interval : " + l1);
    if ((l1 >= 0L) && (l1 <= 28800000L))
    {
      localj.a(28800000L - l1);
      return;
    }
    localj.a(5000L);
  }
  
  private void b(Bundle paramBundle)
  {
    int m = paramBundle.getInt("notify_on_or_off", -1);
    if (m != -1)
    {
      if (m != 1) {
        break label48;
      }
      if (this.a == null) {
        this.a = new ag(getApplicationContext());
      }
      this.a.a();
    }
    label48:
    while ((m != 0) || (this.a == null)) {
      return;
    }
    this.a.b();
    this.a = null;
  }
  
  private void c()
  {
    u localu = u.a(getApplicationContext());
    long l1 = getSharedPreferences("schedule_task", 0).getLong("upload_time", 0L);
    Log.i("NotifyService", "lastTime : " + l1);
    if (l1 == 0L)
    {
      localu.a();
      return;
    }
    l1 = System.currentTimeMillis() - l1;
    Log.i("NotifyService", "interval : " + l1);
    if ((l1 >= 0L) && (l1 <= 28800000L))
    {
      localu.a(28800000L - l1);
      return;
    }
    localu.a(0L);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.h = new Handler();
    this.d = new Notification();
    this.g = ax.a(getApplicationContext());
    this.g.a();
    this.b = new ae(getApplicationContext());
    this.c = new bd(getApplicationContext());
    this.k = new com.gau.go.launcherex.gowidget.weather.globaltheme.a.a(getApplicationContext());
    c();
    this.i = an.a(getApplicationContext());
    b();
    a();
    com.gau.go.launcherex.gowidget.statistics.a.a(getApplicationContext()).a();
    this.l = new ap(getApplicationContext());
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.a != null)
    {
      this.a.b();
      this.a = null;
    }
    if (this.b != null)
    {
      this.b.c();
      this.b = null;
    }
    if (this.d != null) {
      this.d = null;
    }
    if (this.c != null)
    {
      this.c.b();
      this.c = null;
    }
    if (this.g != null)
    {
      this.g.b();
      this.g = null;
    }
    if (this.e != null)
    {
      this.e.b();
      this.e = null;
    }
    if (this.l != null) {
      this.l.a();
    }
    if (this.f != null) {
      this.f.a();
    }
    u.a(getApplicationContext()).b();
    this.i.c();
    if (this.j != null)
    {
      this.j.c();
      this.j = null;
    }
    startService(new Intent(this, NotifyService.class));
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    com.gtp.a.a.b.c.a("NotifyService", "onStartCommand: " + paramIntent + ", " + paramInt1 + ", " + paramInt2);
    if (paramIntent == null)
    {
      if (this.k != null) {
        this.k.a();
      }
      return super.onStartCommand(paramIntent, paramInt1, paramInt2);
    }
    Object localObject1 = paramIntent.getExtras();
    int m;
    if (localObject1 != null)
    {
      m = ((Bundle)localObject1).getInt("notify_request", -1);
      switch (m)
      {
      }
    }
    for (;;)
    {
      return super.onStartCommand(paramIntent, paramInt1, paramInt2);
      b((Bundle)localObject1);
      continue;
      localObject1 = paramIntent.getStringExtra("notify_extra_warn_type");
      if (((String)localObject1).equals("notify_extra_warn_delete"))
      {
        if (this.b != null)
        {
          this.b.b();
          this.b.a();
        }
      }
      else if ((((String)localObject1).equals("notify_extra_warn_touch")) && (this.b != null))
      {
        localObject1 = paramIntent.getStringExtra("cityId");
        long l1 = paramIntent.getLongExtra("notify_extra_warn_notifyid", 0L);
        startActivity(WeatherDetailActivity.a(this, (String)localObject1, true, 11, "", 7));
        this.b.a(l1);
        continue;
        if (this.c == null) {
          this.c = new bd(getApplicationContext());
        }
        this.c.a();
        continue;
        if (this.e == null) {
          this.e = new ai(getApplicationContext());
        }
        this.e.a();
        continue;
        this.h.postDelayed(new i(this), 20000L);
        continue;
        Log.d("NotifyService", "Start GA2 GAServiceManager");
        GAServiceManager.getInstance().dispatch();
        continue;
        this.h.postDelayed(new j(this), 1000L);
        continue;
        if (y.p(this))
        {
          com.gau.go.launcherex.goweather.ad.c.a(this).a();
          continue;
          localObject1 = paramIntent.getStringExtra("request_extra_statistics_installed_theme_package_name");
          new aw(getApplicationContext()).a((String)localObject1);
          continue;
          m = ((Bundle)localObject1).getInt("isMyLocation", 2);
          this.i.a(m);
          continue;
          ba.a(getApplicationContext()).a();
          continue;
          a((Bundle)localObject1);
          continue;
          a((Bundle)localObject1, m);
          continue;
          new m(getApplicationContext()).a();
          continue;
          new w(getApplicationContext()).a((Bundle)localObject1);
          continue;
          localObject1 = ((Bundle)localObject1).getString("request_extra_notify_request_code_open_app");
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            try
            {
              startActivity(getPackageManager().getLaunchIntentForPackage((String)localObject1));
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
            continue;
            Object localObject2 = (LocationErrorBean)localException.getParcelable("request_extra_feedback_location_data");
            new com.gau.go.launcherex.gowidget.service.error.a.a(getApplicationContext()).a((LocationErrorBean)localObject2);
            continue;
            new com.gau.go.launcherex.gowidget.b.a.a().execute(new Void[0]);
            continue;
            if (this.j == null)
            {
              this.j = p.a(getApplicationContext());
              this.j.b();
              continue;
              if (this.k != null)
              {
                this.k.a();
                continue;
                boolean bool = ((Bundle)localObject2).getBoolean("request_extra_show_new_theme_star", false);
                com.gau.go.launcherex.gowidget.weather.globaltheme.a.d.a(getApplication(), bool);
                continue;
                new com.gau.go.launcherex.gowidget.statistics.d(getApplicationContext()).a(paramIntent);
                continue;
                l1 = ((Bundle)localObject2).getLong("request_extra_redownload_photo_id");
                if ((l1 != 0L) && (TextUtils.isEmpty(f.a(getApplicationContext()).a(l1))))
                {
                  localObject3 = ((Bundle)localObject2).getString("request_extra_redownload_photo_path");
                  if (!TextUtils.isEmpty((CharSequence)localObject3))
                  {
                    localObject3 = new File((String)localObject3);
                    if ((localObject3 != null) && (((File)localObject3).exists())) {
                      ((File)localObject3).delete();
                    }
                  }
                  localObject2 = ((Bundle)localObject2).getString("request_extra_redownload_photo_url");
                  if (!TextUtils.isEmpty((CharSequence)localObject2))
                  {
                    localObject3 = new g();
                    ((g)localObject3).a(l1);
                    ((g)localObject3).l((String)localObject2);
                    f.a(getApplicationContext()).a((g)localObject3);
                  }
                }
                y.a("key_gowidget_theme_switcher_click", getApplicationContext());
                continue;
                Object localObject3 = ((Bundle)localObject2).getString("request_extra_runtime_crash_title");
                localObject2 = ((Bundle)localObject2).getString("request_extra_runtime_crash_text");
                b.a(getApplicationContext()).a(new com.gtp.go.weather.a.a.a((String)localObject3, (String)localObject2));
                continue;
                if (this.f == null) {
                  this.f = new ar(getApplicationContext());
                }
                this.f.a(paramIntent);
                continue;
                com.gau.go.launcherex.gowidget.statistics.a.a(getApplicationContext()).e();
                localObject2 = GoWidgetApplication.c(getApplicationContext()).a().edit();
                ((SharedPreferences.Editor)localObject2).putLong("key_ab_test_last_upload", System.currentTimeMillis());
                ((SharedPreferences.Editor)localObject2).commit();
              }
            }
          }
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/service/NotifyService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */