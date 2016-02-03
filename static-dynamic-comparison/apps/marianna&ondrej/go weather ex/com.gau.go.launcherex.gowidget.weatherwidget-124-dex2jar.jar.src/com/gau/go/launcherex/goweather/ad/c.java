package com.gau.go.launcherex.goweather.ad;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.Handler;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;

public class c
{
  private static c b;
  private Context a;
  private boolean c = false;
  private AlarmManager d;
  private Handler e;
  private boolean f = false;
  private boolean g = false;
  private f h;
  private PendingIntent i;
  private PendingIntent j;
  private String k = "";
  private a l;
  
  private c(Context paramContext)
  {
    this.a = paramContext;
    this.d = ((AlarmManager)paramContext.getSystemService("alarm"));
    paramContext = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_INLAND_AD_REQUEST");
    this.i = PendingIntent.getBroadcast(this.a, 1, paramContext, 268435456);
    this.l = new a(this.a);
    c();
    b();
  }
  
  public static c a(Context paramContext)
  {
    if (b == null) {
      b = new c(paramContext);
    }
    return b;
  }
  
  private void a(int paramInt, long paramLong, String paramString)
  {
    paramLong /= paramInt;
    Intent localIntent = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_INLAND_AD_PROFILE");
    this.k = paramString;
    this.j = PendingIntent.getBroadcast(this.a, 2, localIntent, 268435456);
    this.d.setRepeating(0, System.currentTimeMillis(), paramLong, this.j);
  }
  
  private void a(long paramLong)
  {
    this.d.set(0, System.currentTimeMillis() + paramLong, this.i);
  }
  
  private void b()
  {
    this.e = new d(this);
  }
  
  private void c()
  {
    this.h = new f(this);
    IntentFilter localIntentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_INLAND_AD_REQUEST");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_INLAND_AD_PROFILE");
    this.a.registerReceiver(this.h, localIntentFilter);
  }
  
  private com.gau.go.launcherex.goweather.ad.a.a d()
  {
    com.gau.go.launcherex.goweather.ad.a.a locala = new com.gau.go.launcherex.goweather.ad.a.a();
    Cursor localCursor = this.a.getContentResolver().query(WeatherContentProvider.s, null, null, null, null);
    if (localCursor != null) {}
    try
    {
      if (localCursor.moveToFirst())
      {
        locala.a(localCursor.getString(localCursor.getColumnIndex("ad_id")));
        locala.a(localCursor.getLong(localCursor.getColumnIndex("ad_interval")));
        locala.a(localCursor.getInt(localCursor.getColumnIndex("ad_overcount")));
        locala.b(localCursor.getString(localCursor.getColumnIndex("ad_monitor")));
        locala.b(localCursor.getInt(localCursor.getColumnIndex("pcount")));
        locala.c(localCursor.getString(localCursor.getColumnIndex("purl")));
        locala.d(localCursor.getString(localCursor.getColumnIndex("timestamp")));
      }
      return locala;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return locala;
    }
    finally
    {
      localCursor.close();
    }
  }
  
  private long e()
  {
    long l1 = 86400000L;
    Cursor localCursor = this.a.getContentResolver().query(WeatherContentProvider.s, new String[] { "ad_interval" }, null, null, null);
    if (localCursor != null) {}
    for (;;)
    {
      try
      {
        if (localCursor.moveToFirst())
        {
          l1 = localCursor.getLong(localCursor.getColumnIndex("ad_interval"));
          return l1;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return 86400000L;
      }
      finally
      {
        localCursor.close();
      }
      l1 = 86400000L;
    }
  }
  
  public void a()
  {
    if (!this.c)
    {
      this.c = true;
      this.e.sendEmptyMessage(0);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/goweather/ad/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */