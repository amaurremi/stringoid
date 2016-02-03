package com.gau.go.launcherex.gowidget.statistics;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;

public class a
{
  private static a b;
  private Context a;
  private SharedPreferences c;
  private r d;
  private String e = "";
  private AlarmManager f;
  private boolean g;
  
  private a(Context paramContext)
  {
    this.a = paramContext;
    this.d = r.a(paramContext);
    this.c = GoWidgetApplication.c(paramContext).a();
    int i = this.c.getInt("key_ab_test_user", -1);
    if (i == 0)
    {
      this.e = "ab_test";
      this.f = ((AlarmManager)paramContext.getSystemService("alarm"));
      long l = this.c.getLong("key_ab_test_install_time", 0L);
      if (System.currentTimeMillis() - l <= 604800000L) {
        break label128;
      }
    }
    label128:
    for (boolean bool = true;; bool = false)
    {
      this.g = bool;
      return;
      if (i == 1)
      {
        this.e = "n_ab_test";
        break;
      }
      this.e = "";
      break;
    }
  }
  
  public static a a(Context paramContext)
  {
    if (b == null) {
      b = new a(paramContext);
    }
    return b;
  }
  
  private PendingIntent f()
  {
    Intent localIntent = new Intent("com.gau.go.launcherex.gowidget.weather.service.NotifyService");
    localIntent.putExtra("notify_request", 53);
    localIntent.putExtra("user_type", this.e);
    return PendingIntent.getService(this.a, 99999, localIntent, 134217728);
  }
  
  public void a()
  {
    if ((!this.g) && (!TextUtils.isEmpty(this.e)))
    {
      long l = this.c.getLong("key_ab_test_last_upload", 0L);
      l = Math.max(0L, 86400000L - (System.currentTimeMillis() - l));
      this.f.setRepeating(0, l + System.currentTimeMillis(), 86400000L, f());
    }
  }
  
  public boolean b()
  {
    return "ab_test".equals(this.e);
  }
  
  public boolean c()
  {
    return this.g;
  }
  
  public void d()
  {
    if (!this.g)
    {
      com.gtp.a.a.a.a.a().a("上传展示广告统计", "ab_test.txt");
      com.gau.go.launcherex.gowidget.statistics.a.a locala = new com.gau.go.launcherex.gowidget.statistics.a.a(93, "ab_show");
      this.d.a(locala);
    }
  }
  
  public void e()
  {
    if (!this.g)
    {
      com.gtp.a.a.a.a.a().a("上传用户类型[" + this.e + "]", "ab_test.txt");
      com.gau.go.launcherex.gowidget.statistics.a.a locala = new com.gau.go.launcherex.gowidget.statistics.a.a(93, this.e);
      this.d.a(locala);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/statistics/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */