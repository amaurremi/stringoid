package com.gtp.go.weather.sharephoto.c;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.gtp.go.weather.sharephoto.b.c;
import com.gtp.go.weather.sharephoto.b.o;
import java.util.concurrent.ConcurrentHashMap;

public class d
{
  private static volatile d j;
  private ConcurrentHashMap a;
  private ConcurrentHashMap b;
  private ConcurrentHashMap c;
  private AlarmManager d;
  private ConnectivityManager e;
  private Context f;
  private boolean g;
  private boolean h;
  private k i;
  
  private d(Context paramContext)
  {
    this.f = paramContext;
    this.a = new ConcurrentHashMap();
    this.b = new ConcurrentHashMap();
    this.c = new ConcurrentHashMap();
    this.d = ((AlarmManager)paramContext.getSystemService("alarm"));
    this.e = ((ConnectivityManager)paramContext.getSystemService("connectivity"));
    this.g = false;
    this.i = new k(this);
    new g(this, null).execute(new Object[0]);
  }
  
  public static d a(Context paramContext)
  {
    if (j == null) {
      j = new d(paramContext);
    }
    return j;
  }
  
  private void a()
  {
    if (!this.g)
    {
      this.g = true;
      Object localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("LIKE_OR_BG_UPLOAD");
      ((IntentFilter)localObject).addAction("android.net.conn.CONNECTIVITY_CHANGE");
      this.f.registerReceiver(this.i, (IntentFilter)localObject);
      localObject = this.e.getActiveNetworkInfo();
      if ((localObject != null) && (((NetworkInfo)localObject).isConnected())) {
        b(System.currentTimeMillis() + 5000L);
      }
    }
    else
    {
      return;
    }
    this.h = true;
  }
  
  private void a(String paramString, long paramLong, int paramInt)
  {
    if (paramInt == 2) {
      paramString = new c(paramString, paramLong, 2, paramInt);
    }
    c localc;
    do
    {
      this.a.put(Long.valueOf(paramLong), paramString);
      do
      {
        return;
      } while ((paramInt != 1) && (paramInt != -1));
      localc = (c)this.b.get(Long.valueOf(paramLong));
      if (localc == null) {
        break;
      }
    } while (localc.c() + paramInt != 0);
    localc.a(paramInt);
    return;
    paramString = new c(paramString, paramLong, 1, paramInt);
    this.b.put(Long.valueOf(paramLong), paramString);
  }
  
  private void a(String paramString, com.gtp.go.weather.sharephoto.b.j paramj)
  {
    paramString = new c(com.gtp.go.weather.sharephoto.a.g.a(this.f).b().a(), paramj.a(), 3, paramj.c());
    this.c.put(Long.valueOf(paramj.a()), paramString);
  }
  
  private void b(long paramLong)
  {
    Object localObject = new Intent("LIKE_OR_BG_UPLOAD");
    localObject = PendingIntent.getBroadcast(this.f, 100, (Intent)localObject, 134217728);
    this.d.set(0, paramLong, (PendingIntent)localObject);
  }
  
  private void b(com.gtp.go.weather.sharephoto.b.j paramj)
  {
    a(com.gtp.go.weather.sharephoto.a.g.a(this.f).b().a(), paramj);
    a();
  }
  
  private void b(String paramString, long paramLong, int paramInt)
  {
    a(paramString, paramLong, paramInt);
    a();
  }
  
  public void a(long paramLong)
  {
    if (paramLong != 0L)
    {
      Intent localIntent = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_CHANGE_FAVOUR_OR_BACKCOUNT");
      localIntent.putExtra("extra_change_photo_id", paramLong);
      localIntent.putExtra("extra_change_type", 2);
      this.f.sendBroadcast(localIntent);
      new h(this, null).execute(new Object[] { Long.valueOf(paramLong) });
    }
  }
  
  public void a(com.gtp.go.weather.sharephoto.b.g paramg)
  {
    Intent localIntent;
    if (paramg != null)
    {
      localIntent = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_CHANGE_FAVOUR_OR_BACKCOUNT");
      localIntent.putExtra("extra_change_photo_id", paramg.a());
      localIntent.putExtra("extra_change_type", 1);
      if (!paramg.h()) {
        break label80;
      }
    }
    label80:
    for (int k = 1;; k = -1)
    {
      localIntent.putExtra("extra_change_value", k);
      this.f.sendBroadcast(localIntent);
      new i(this, null).execute(new Object[] { paramg });
      return;
    }
  }
  
  public void a(com.gtp.go.weather.sharephoto.b.j paramj)
  {
    if (paramj != null) {
      new j(this, null).execute(new Object[] { paramj });
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/c/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */