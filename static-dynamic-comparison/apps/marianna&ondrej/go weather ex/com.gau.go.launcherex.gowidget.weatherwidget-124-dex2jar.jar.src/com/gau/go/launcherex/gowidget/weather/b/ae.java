package com.gau.go.launcherex.gowidget.weather.b;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.model.q;
import com.gau.go.launcherex.gowidget.weather.util.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ae
{
  private Context a;
  private NotificationManager b;
  private HashMap c;
  private af d;
  private f e;
  private e f;
  private q g;
  private HashMap h = new HashMap();
  
  public ae(Context paramContext)
  {
    this.a = paramContext;
    this.b = ((NotificationManager)this.a.getSystemService("notification"));
    Object localObject = com.gau.go.launcherex.gowidget.weather.c.c.a(this.a.getApplicationContext());
    this.e = ((com.gau.go.launcherex.gowidget.weather.c.c)localObject).h();
    this.f = ((com.gau.go.launcherex.gowidget.weather.c.c)localObject).f();
    this.g = this.f.a();
    this.c = new HashMap();
    this.d = new af(this);
    localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_UPDATE_EXTREME_WEATHER");
    ((IntentFilter)localObject).addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DELETE_EXPIRED_EXTREME_WEATHER");
    ((IntentFilter)localObject).addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_CLEAR_EXTREME_WEATHER");
    ((IntentFilter)localObject).addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_LOCATION");
    paramContext.registerReceiver(this.d, (IntentFilter)localObject);
  }
  
  private PendingIntent a(long paramLong, String paramString)
  {
    Intent localIntent = new Intent("com.gau.go.launcherex.gowidget.weather.service.NotifyService");
    localIntent.putExtra("notify_request", 3);
    localIntent.putExtra("notify_extra_warn_type", "notify_extra_warn_touch");
    localIntent.putExtra("cityId", paramString);
    localIntent.putExtra("notify_extra_warn_notifyid", paramLong);
    return PendingIntent.getService(this.a, (int)(17L + paramLong), localIntent, 134217728);
  }
  
  private RemoteViews a(String paramString1, String paramString2, String paramString3)
  {
    RemoteViews localRemoteViews = new RemoteViews(this.a.getPackageName(), 2130903247);
    localRemoteViews.setTextViewText(2131231784, paramString1);
    localRemoteViews.setImageViewResource(2131231779, 2130838351);
    localRemoteViews.setViewVisibility(2131231783, 0);
    localRemoteViews.setTextViewText(2131231783, paramString2 + " — " + paramString3);
    if (this.g.C.equals("notification_style_default")) {
      d();
    }
    paramString1 = this.a.getResources();
    if (this.g.C.equals("notification_style_default_black"))
    {
      localRemoteViews.setTextColor(2131231783, paramString1.getColor(2131361859));
      localRemoteViews.setTextColor(2131231784, paramString1.getColor(2131361860));
    }
    while (!this.g.C.equals("notification_style_default_white")) {
      return localRemoteViews;
    }
    localRemoteViews.setTextColor(2131231783, paramString1.getColor(2131361862));
    localRemoteViews.setTextColor(2131231784, paramString1.getColor(2131361863));
    return localRemoteViews;
  }
  
  private void a(long paramLong, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString1)) || (paramLong == 0L) || (TextUtils.isEmpty(paramString2))) {}
    Object localObject;
    String str1;
    do
    {
      return;
      localObject = "";
      WeatherBean localWeatherBean = this.e.a(paramString1);
      str1 = paramString2;
      if (localWeatherBean != null)
      {
        String str2 = localWeatherBean.d();
        Map localMap = localWeatherBean.n();
        localObject = str2;
        str1 = paramString2;
        if (localMap != null)
        {
          localObject = str2;
          str1 = paramString2;
          if (localMap.size() > 1)
          {
            str1 = paramString2 + " (" + localWeatherBean.n().size() + ")";
            localObject = str2;
          }
        }
      }
    } while (this.g.t == 0);
    paramString2 = new NotificationCompat.Builder(this.a).setAutoCancel(true).setOnlyAlertOnce(true);
    if (paramBoolean) {}
    for (int i = -1;; i = 6)
    {
      paramString1 = paramString2.setDefaults(i).setTicker((String)localObject + " — " + str1).setSmallIcon(2130838352).setContent(a(str1, (String)localObject, paramString3)).setContentIntent(a(paramLong, paramString1)).setDeleteIntent(c(paramLong));
      this.b.notify("com.gau.go.launcherex.gowidget.weather.handler.NotifyWarnHandler", (int)paramLong, paramString1.build());
      return;
    }
  }
  
  private void a(HashMap paramHashMap, boolean paramBoolean)
  {
    Iterator localIterator;
    if ((paramHashMap != null) && (!paramHashMap.isEmpty())) {
      localIterator = paramHashMap.entrySet().iterator();
    }
    label211:
    for (;;)
    {
      Object localObject1;
      String str;
      Object localObject2;
      if (localIterator.hasNext())
      {
        localObject1 = (Map.Entry)localIterator.next();
        if (localObject1 != null)
        {
          str = (String)((Map.Entry)localObject1).getKey();
          if (!TextUtils.isEmpty(str))
          {
            localObject2 = ((ArrayList)paramHashMap.get(str)).iterator();
            do
            {
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              localObject1 = (com.gau.go.launcherex.gowidget.weather.model.c)((Iterator)localObject2).next();
            } while ((localObject1 == null) || (!((com.gau.go.launcherex.gowidget.weather.model.c)localObject1).l()));
          }
        }
      }
      else
      {
        for (;;)
        {
          if (localObject1 == null) {
            break label211;
          }
          localObject2 = ((com.gau.go.launcherex.gowidget.weather.model.c)localObject1).f();
          localObject1 = ((com.gau.go.launcherex.gowidget.weather.model.c)localObject1).i();
          long l;
          if (this.h.containsKey(str)) {
            l = ((Long)this.h.get(str)).longValue();
          }
          for (;;)
          {
            b(l);
            a(l, str, (String)localObject2, (String)localObject1, paramBoolean);
            break;
            l = System.currentTimeMillis();
            this.h.put(str, Long.valueOf(l));
          }
          return;
          localObject1 = null;
        }
      }
    }
  }
  
  private void b(long paramLong)
  {
    if (this.b != null) {
      this.b.cancel("com.gau.go.launcherex.gowidget.weather.handler.NotifyWarnHandler", (int)paramLong);
    }
  }
  
  private PendingIntent c(long paramLong)
  {
    Intent localIntent = new Intent("com.gau.go.launcherex.gowidget.weather.service.NotifyService");
    localIntent.putExtra("notify_request", 3);
    localIntent.putExtra("notify_extra_warn_type", "notify_extra_warn_delete");
    return PendingIntent.getService(this.a, (int)(34L + paramLong), localIntent, 134217728);
  }
  
  private void d()
  {
    TypedArray localTypedArray = this.a.obtainStyledAttributes(16973928, new int[] { 16842904 });
    int i = localTypedArray.getColor(0, 0);
    localTypedArray.recycle();
    if ((0xFFFFFF & i) < 8388607) {}
    for (this.g.C = "notification_style_default_white";; this.g.C = "notification_style_default_black")
    {
      this.f.a("notification_style", this.g.C);
      return;
    }
  }
  
  public void a()
  {
    if ((this.h != null) && (!this.h.isEmpty()))
    {
      Iterator localIterator = this.h.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (localEntry != null)
        {
          long l = ((Long)localEntry.getValue()).longValue();
          if (l != 0L) {
            b(l);
          }
        }
      }
    }
  }
  
  public void a(long paramLong)
  {
    Map.Entry localEntry;
    if (paramLong != 0L)
    {
      if (this.h.isEmpty()) {
        break label129;
      }
      localObject = this.h.entrySet().iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localEntry = (Map.Entry)((Iterator)localObject).next();
      } while ((localEntry == null) || (((Long)localEntry.getValue()).longValue() != paramLong));
    }
    label129:
    for (Object localObject = (String)localEntry.getKey();; localObject = "")
    {
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (!this.h.isEmpty()) {
          this.h.remove(localObject);
        }
        if (!this.c.isEmpty()) {
          this.c.remove(localObject);
        }
      }
      return;
    }
  }
  
  public void b()
  {
    if (!this.c.isEmpty()) {
      this.c.clear();
    }
    if (!this.h.isEmpty()) {
      this.h.clear();
    }
  }
  
  public void c()
  {
    this.a.unregisterReceiver(this.d);
    a();
    b();
    if (this.b != null) {
      this.b = null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/b/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */