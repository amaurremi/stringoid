package com.gau.go.launcherex.gowidget.weather.b;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.gau.go.launcherex.gowidget.weather.util.r;
import com.jiubang.core.b.a;
import com.jiubang.goweather.b.c;
import com.jiubang.goweather.b.e;
import com.jiubang.goweather.b.f;

public class ax
{
  private static ax a;
  private AlarmManager b;
  private PendingIntent c;
  private Context d;
  private BroadcastReceiver e = new ay(this);
  
  private ax(Context paramContext)
  {
    this.d = paramContext;
    this.b = ((AlarmManager)paramContext.getSystemService("alarm"));
    this.c = PendingIntent.getBroadcast(paramContext, 0, new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_CHECK_NEW_VERSION"), 134217728);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_CHECK_NEW_VERSION");
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    paramContext.registerReceiver(this.e, localIntentFilter);
  }
  
  public static ax a(Context paramContext)
  {
    if (a == null) {
      a = new ax(paramContext);
    }
    return a;
  }
  
  private void a(long paramLong)
  {
    long l = System.currentTimeMillis();
    Object localObject = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_CHECK_NEW_VERSION");
    localObject = PendingIntent.getBroadcast(this.d, 0, (Intent)localObject, 0);
    this.b.set(0, l + paramLong, (PendingIntent)localObject);
  }
  
  private void a(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = GoWidgetApplication.c(this.d.getApplicationContext()).a();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putBoolean("check_version_network_ok", paramBoolean).commit();
    }
  }
  
  private void b(long paramLong)
  {
    SharedPreferences localSharedPreferences = GoWidgetApplication.c(this.d.getApplicationContext()).a();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putLong("last_version_update_time", paramLong).commit();
    }
  }
  
  private long c()
  {
    long l = 0L;
    if (GoWidgetApplication.c(this.d.getApplicationContext()) != null) {}
    for (SharedPreferences localSharedPreferences = GoWidgetApplication.c(this.d.getApplicationContext()).a();; localSharedPreferences = this.d.getSharedPreferences("goweatherex_info", 0))
    {
      if (localSharedPreferences != null) {
        l = localSharedPreferences.getLong("last_version_update_time", 0L);
      }
      return l;
    }
  }
  
  private void d()
  {
    long l1 = 259200000L;
    long l2 = System.currentTimeMillis();
    long l3 = c();
    if ((l3 == 0L) || (l2 - l3 >= 259200000L) || (l2 - l3 <= 0L))
    {
      new az(this, null).execute(new String[0]);
      b(l2);
    }
    for (;;)
    {
      a(l1);
      return;
      l1 = 259200000L - (l2 - l3);
    }
  }
  
  private boolean e()
  {
    boolean bool = false;
    SharedPreferences localSharedPreferences = GoWidgetApplication.c(this.d.getApplicationContext()).a();
    if (localSharedPreferences != null) {
      bool = localSharedPreferences.getBoolean("check_version_network_ok", false);
    }
    return bool;
  }
  
  public String a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    Object localObject2 = com.gau.go.launcherex.gowidget.language.d.a(this.d).b();
    Object localObject1;
    if ("zh".equals(localObject2)) {
      localObject1 = String.format("%s-%s", new Object[] { localObject2, com.gau.go.launcherex.gowidget.language.d.a(this.d).e() });
    }
    for (;;)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("http://imupdate.3g.cn:8888/versions/check?");
      ((StringBuilder)localObject2).append("p=");
      ((StringBuilder)localObject2).append(42);
      ((StringBuilder)localObject2).append("&bn=");
      ((StringBuilder)localObject2).append(248);
      ((StringBuilder)localObject2).append("&v=");
      ((StringBuilder)localObject2).append(paramString);
      if (localObject1 != null)
      {
        ((StringBuilder)localObject2).append("&lang=");
        ((StringBuilder)localObject2).append((String)localObject1);
      }
      ((StringBuilder)localObject2).append("&channel=");
      ((StringBuilder)localObject2).append(y.f(this.d));
      ((StringBuilder)localObject2).append("&type=");
      ((StringBuilder)localObject2).append(paramInt3);
      ((StringBuilder)localObject2).append("&vc=");
      ((StringBuilder)localObject2).append(paramInt2);
      localObject2 = ((StringBuilder)localObject2).toString();
      paramString = null;
      paramInt2 = 0;
      while (paramInt2 < paramInt1)
      {
        paramInt2 += 1;
        localObject1 = com.jiubang.goweather.b.d.a().b((String)localObject2, new e((String)localObject2, "GET"), new f());
        paramString = (String)localObject1;
        if (localObject1 != null) {
          paramString = (String)localObject1;
        }
      }
      return paramString;
      if ("en".equals(localObject2))
      {
        String str = com.gau.go.launcherex.gowidget.language.d.a(this.d).e();
        localObject1 = localObject2;
        if (str.equals("US")) {
          localObject1 = String.format("%s-%s", new Object[] { localObject2, str });
        }
      }
      else
      {
        localObject1 = null;
      }
    }
  }
  
  public void a()
  {
    if (!r.c(this.d))
    {
      if (GoWidgetApplication.c(this.d.getApplicationContext()) != null) {}
      for (Object localObject = GoWidgetApplication.c(this.d.getApplicationContext()).a();; localObject = this.d.getSharedPreferences("goweatherex_info", 0))
      {
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putBoolean("check_version_network_ok", true);
        ((SharedPreferences.Editor)localObject).commit();
        return;
      }
    }
    d();
  }
  
  public void b()
  {
    this.d.unregisterReceiver(this.e);
    this.b.cancel(this.c);
    a = null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/b/ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */