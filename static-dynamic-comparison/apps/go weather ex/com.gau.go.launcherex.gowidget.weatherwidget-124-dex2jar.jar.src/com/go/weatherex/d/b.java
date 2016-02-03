package com.go.weatherex.d;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import com.gau.go.launcherex.gowidget.weather.util.r;

public class b
{
  private static b b;
  boolean a = false;
  private AlarmManager c;
  private PendingIntent d;
  private Context e;
  private SharedPreferences f;
  private e g;
  private Handler h = new c(this);
  private Handler i = new d(this);
  
  private b(Context paramContext)
  {
    this.e = paramContext;
    this.f = paramContext.getSharedPreferences("go_ad_share_prefs", 0);
    this.c = ((AlarmManager)paramContext.getSystemService("alarm"));
    this.d = PendingIntent.getBroadcast(paramContext, 0, new Intent("com.go.weatherex.goad.ACTION_GO_AD_DOWNLOAD"), 134217728);
    if (r.c(this.e))
    {
      this.a = false;
      a();
    }
    for (;;)
    {
      this.g = new e(this, null);
      paramContext = new IntentFilter("com.go.weatherex.goad.ACTION_GO_AD_DOWNLOAD");
      paramContext.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      this.e.registerReceiver(this.g, paramContext);
      return;
      this.a = true;
    }
  }
  
  public static b a(Context paramContext)
  {
    if (b == null) {
      b = new b(paramContext);
    }
    return b;
  }
  
  private void a()
  {
    long l = b();
    SharedPreferences.Editor localEditor = this.f.edit();
    localEditor.putLong("go_ad_share_next_download_time", l);
    localEditor.commit();
    this.c.set(0, l, this.d);
  }
  
  private long b()
  {
    long l2 = this.f.getLong("go_ad_share_next_download_time", 0L);
    long l3 = System.currentTimeMillis();
    long l1;
    if (l2 - l3 <= 28800000L)
    {
      l1 = l2;
      if (l2 - l3 >= 0L) {}
    }
    else
    {
      f.a(this.e);
      l1 = 28800000L + l3;
    }
    return l1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/d/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */