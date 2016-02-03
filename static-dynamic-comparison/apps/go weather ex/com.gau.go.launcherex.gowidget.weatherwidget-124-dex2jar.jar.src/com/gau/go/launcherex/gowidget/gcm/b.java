package com.gau.go.launcherex.gowidget.gcm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.util.r;
import com.jiubang.core.b.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class b
{
  private static b a;
  private ArrayList b;
  private Context c;
  private boolean d = false;
  private AlarmManager e;
  private PendingIntent f;
  private boolean g;
  private BroadcastReceiver h = new c(this);
  
  private b(Context paramContext)
  {
    if (y.s(paramContext))
    {
      this.c = paramContext;
      this.b = new ArrayList();
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DATA_READY");
      localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_GCM_OPERATION");
      localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_GCM_UPDATE_REG_ID");
      localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_LAUNCH_GCM_TASKS");
      localIntentFilter.addAction("android.intent.action.LOCALE_CHANGED");
      paramContext.registerReceiver(this.h, localIntentFilter);
      this.e = ((AlarmManager)paramContext.getSystemService("alarm"));
      this.f = PendingIntent.getBroadcast(paramContext, 0, new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_LAUNCH_GCM_TASKS"), 134217728);
      this.g = true;
      return;
    }
    this.g = false;
  }
  
  public static b a(Context paramContext)
  {
    if (a == null) {
      a = new b(paramContext);
    }
    return a;
  }
  
  private void a(e parame)
  {
    this.b.remove(parame);
    if (this.b.size() > 0)
    {
      if (r.c(this.c))
      {
        parame = (e)this.b.get(0);
        if ((parame.b == 1) || (parame.b == 3))
        {
          while (this.b.size() > 1) {
            this.b.remove(1);
          }
          if (parame.b == 1)
          {
            parame = new Intent("com.google.android.c2dm.intent.REGISTER");
            parame.putExtra("app", PendingIntent.getBroadcast(this.c, 0, new Intent(), 0));
            parame.putExtra("sender", "535733622764");
            this.c.startService(parame);
          }
        }
        for (;;)
        {
          this.d = true;
          return;
          new d(this).execute(new e[] { parame });
          continue;
          if (parame.b == 2)
          {
            new d(this).execute(new e[] { parame });
          }
          else
          {
            parame = g();
            new d(this).execute(new e[] { parame });
          }
        }
      }
      this.d = false;
      return;
    }
    this.d = false;
  }
  
  private boolean d()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.g)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(GoWidgetApplication.c(this.c.getApplicationContext()).a().getString("gcm_cur_reg_id", null))) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private String e()
  {
    return this.c.getResources().getConfiguration().locale.getCountry();
  }
  
  private void f()
  {
    this.d = false;
    this.g = false;
    this.e.cancel(this.f);
    this.c.unregisterReceiver(this.h);
  }
  
  private e g()
  {
    int j = this.b.size();
    int i = 0;
    e locale;
    if (i < j)
    {
      locale = (e)this.b.get(i);
      if (locale.b != 6) {}
    }
    for (;;)
    {
      if (locale != null)
      {
        locale.a = h();
        this.b.clear();
        this.b.add(locale);
      }
      return (e)this.b.get(0);
      i += 1;
      break;
      locale = null;
    }
  }
  
  private String h()
  {
    String str3 = GoWidgetApplication.c(this.c.getApplicationContext()).a().getString("gcm_cur_reg_id", null);
    ArrayList localArrayList = i();
    int i = localArrayList.size();
    String str1 = "";
    String str2 = str1;
    if (i > 0)
    {
      int j = i - 1;
      i = 0;
      while (i < j)
      {
        str1 = str1 + (String)localArrayList.get(i);
        str1 = str1 + ",";
        i += 1;
      }
      str2 = str1 + (String)localArrayList.get(j);
    }
    return "http://goweathergcm.goforandroid.com:8099/gcmServer/alarm/city/sync?cityIds=" + str2 + "&" + "regId" + "=" + str3;
  }
  
  private ArrayList i()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = com.gau.go.launcherex.gowidget.weather.util.f.a(this.c).c().entrySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((WeatherBean)((Map.Entry)localIterator.next()).getValue()).c());
    }
    return localArrayList;
  }
  
  private void j()
  {
    this.e.cancel(this.f);
    this.e.setRepeating(0, System.currentTimeMillis() + 300000L, 300000L, this.f);
  }
  
  public void a()
  {
    Object localObject;
    if ((!this.d) && (this.b.size() > 0))
    {
      localObject = (e)this.b.get(0);
      if ((((e)localObject).b != 1) && (((e)localObject).b != 3)) {
        break label169;
      }
      while (this.b.size() > 1) {
        this.b.remove(1);
      }
      if (((e)localObject).b == 1)
      {
        this.d = true;
        localObject = new Intent("com.google.android.c2dm.intent.REGISTER");
        ((Intent)localObject).putExtra("app", PendingIntent.getBroadcast(this.c, 0, new Intent(), 0));
        ((Intent)localObject).putExtra("sender", "535733622764");
      }
    }
    else
    {
      try
      {
        this.c.startService((Intent)localObject);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        f();
        return;
      }
    }
    new d(this).execute(new e[] { localException });
    this.d = true;
    return;
    label169:
    if (localException.b == 2)
    {
      new d(this).execute(new e[] { localException });
      return;
    }
    e locale = g();
    new d(this).execute(new e[] { locale });
    this.d = true;
  }
  
  public void a(String paramString)
  {
    if (d())
    {
      Object localObject = GoWidgetApplication.c(this.c.getApplicationContext()).a();
      ((SharedPreferences)localObject).edit().putBoolean("city_list_changed", true).commit();
      localObject = ((SharedPreferences)localObject).getString("gcm_cur_reg_id", null);
      paramString = new e(this, "http://goweathergcm.goforandroid.com:8099/gcmServer/alarm/city/delete?cityId=" + paramString + "&" + "regId" + "=" + (String)localObject, 5);
      this.b.add(paramString);
      if (!this.d)
      {
        this.e.cancel(this.f);
        if (r.c(this.c))
        {
          paramString = g();
          this.d = true;
          new d(this).execute(new e[] { paramString });
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString2 = new StringBuilder().append("http://goweathergcm.goforandroid.com:8099/gcmServer/alarm/updateReg?oldRegId=").append(paramString2).append("&").append("newRegId").append("=").append(paramString1).append("&").append("lang").append("=").append(y.k(this.c)).append("&").append("region").append("=").append(e()).append("&").append("is_paid_user").append("=");
    if (GoWidgetApplication.b(this.c).b()) {}
    for (int i = 1;; i = 0)
    {
      paramString2 = new e(this, i, 2);
      paramString2.c = paramString1;
      paramString2.d = paramBoolean;
      if (this.d) {
        break;
      }
      this.e.cancel(this.f);
      this.b.add(0, paramString2);
      if (r.c(this.c))
      {
        this.d = true;
        new d(this).execute(new e[] { (e)this.b.get(0) });
      }
      return;
    }
    this.b.add(0, paramString2);
  }
  
  public void b()
  {
    e locale;
    if (this.b.size() > 0)
    {
      locale = (e)this.b.get(0);
      if ((locale.b != 1) && (locale.b != 2)) {}
    }
    do
    {
      do
      {
        return;
        locale = new e(this, 6);
        this.b.add(locale);
      } while (this.d);
      this.e.cancel(this.f);
      this.b.clear();
      this.b.add(locale);
    } while (!r.c(this.c));
    locale.a = h();
    this.d = true;
    new d(this).execute(new e[] { locale });
  }
  
  public void b(String paramString)
  {
    if (d())
    {
      Object localObject = GoWidgetApplication.c(this.c.getApplicationContext()).a();
      ((SharedPreferences)localObject).edit().putBoolean("city_list_changed", true).commit();
      localObject = ((SharedPreferences)localObject).getString("gcm_cur_reg_id", null);
      paramString = new e(this, "http://goweathergcm.goforandroid.com:8099/gcmServer/alarm/city/add?cityIds=" + paramString + "&" + "regId" + "=" + (String)localObject, 4);
      this.b.add(paramString);
      if (!this.d)
      {
        this.e.cancel(this.f);
        if (r.c(this.c))
        {
          paramString = g();
          this.d = true;
          new d(this).execute(new e[] { paramString });
        }
      }
    }
  }
  
  public void c()
  {
    if (!this.d)
    {
      this.e.cancel(this.f);
      this.b.clear();
      Object localObject = new e(this, 1);
      this.b.add(localObject);
      if (r.c(this.c))
      {
        this.d = true;
        localObject = new Intent("com.google.android.c2dm.intent.REGISTER");
        ((Intent)localObject).putExtra("app", PendingIntent.getBroadcast(this.c, 0, new Intent(), 0));
        ((Intent)localObject).putExtra("sender", "535733622764");
      }
      try
      {
        this.c.startService((Intent)localObject);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        f();
        return;
      }
    }
    e locale = new e(this, 1);
    this.b.add(0, locale);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/gcm/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */