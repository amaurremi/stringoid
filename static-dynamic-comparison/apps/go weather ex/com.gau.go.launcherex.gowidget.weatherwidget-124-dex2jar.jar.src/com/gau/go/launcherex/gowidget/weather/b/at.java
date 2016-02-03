package com.gau.go.launcherex.gowidget.weather.b;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.TypedArray;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.model.ExtremeCityIdBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.model.q;
import com.gau.go.launcherex.gowidget.weather.util.f;
import com.gau.go.launcherex.gowidget.weather.view.WeatherDetailActivity;
import com.jiubang.core.b.a;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public class at
{
  private static int a = 4;
  private static at d;
  private Context b;
  private NotificationManager c = null;
  private q e;
  private au f;
  private SharedPreferences g;
  
  private at(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
    this.c = ((NotificationManager)this.b.getSystemService("notification"));
    this.e = com.gau.go.launcherex.gowidget.weather.c.c.a(paramContext.getApplicationContext()).f().a();
    this.f = new au(this);
    this.g = GoWidgetApplication.c(paramContext.getApplicationContext()).a();
  }
  
  private PendingIntent a(Context paramContext, String paramString, int paramInt)
  {
    return PendingIntent.getActivity(paramContext, paramInt, WeatherDetailActivity.a(this.b, paramString, true, 11, "", 7), 134217728);
  }
  
  private String a(long paramLong)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm Z", Locale.ENGLISH);
    localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+0800"));
    return localSimpleDateFormat.format(new Date(paramLong));
  }
  
  public static void a(Context paramContext)
  {
    if (d == null) {
      d = new at(paramContext);
    }
    paramContext = d.b();
    d.a(paramContext);
    d.b(paramContext);
  }
  
  private void a(q paramq)
  {
    TypedArray localTypedArray = this.b.obtainStyledAttributes(16973928, new int[] { 16842904 });
    int i = localTypedArray.getColor(0, 0);
    localTypedArray.recycle();
    if ((0xFFFFFF & i) < 8388607) {}
    for (paramq.C = "notification_style_default_white";; paramq.C = "notification_style_default_black")
    {
      com.gau.go.launcherex.gowidget.weather.c.c.a(this.b.getApplicationContext()).f().a("notification_style", paramq.C);
      return;
    }
  }
  
  private void a(List paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((av)paramList.next()).a();
    }
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 == 55536) || (paramInt2 == 55536)) {}
    while (paramInt1 - paramInt2 < paramInt3) {
      return false;
    }
    return true;
  }
  
  private List b()
  {
    Object localObject1 = this.e.K;
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      if (!((String)localObject1).contains("#")) {}
    }
    for (;;)
    {
      int i;
      ArrayList localArrayList;
      int j;
      try
      {
        localObject1 = ((String)localObject1).split("#");
        i = this.g.getInt("key_temp_change_extreme_decrease_id", -1);
        localArrayList = new ArrayList();
        Iterator localIterator = com.gau.go.launcherex.gowidget.weather.c.c.a(this.b.getApplicationContext()).h().d().iterator();
        if (!localIterator.hasNext()) {
          break label218;
        }
        av localav = new av(this, (WeatherBean)localIterator.next());
        localav.b = true;
        if (localObject1 != null)
        {
          int k = localObject1.length;
          j = 0;
          if (j < k)
          {
            if (!localObject1[j].equals(localav.n)) {
              break label211;
            }
            localav.b = false;
          }
        }
        localav.o.c(i);
        localArrayList.add(localav);
        i -= 1;
        continue;
      }
      catch (Exception localException)
      {
        if (com.gtp.a.a.b.c.a()) {
          localException.printStackTrace();
        }
        localObject2 = null;
        continue;
      }
      Object localObject2 = { localObject2 };
      continue;
      label211:
      j += 1;
      continue;
      label218:
      localObject2 = this.g.edit();
      ((SharedPreferences.Editor)localObject2).putInt("key_temp_change_extreme_decrease_id", i);
      ((SharedPreferences.Editor)localObject2).commit();
      return localArrayList;
      localObject2 = null;
    }
  }
  
  private void b(List paramList)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      av localav = (av)paramList.next();
      if (av.a(localav, localArrayList1)) {
        localArrayList2.add(localav.o);
      }
    }
    if (localArrayList1.size() > 0) {
      this.f.a(1, localArrayList2, "com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider", localArrayList1);
    }
  }
  
  private void c(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    f localf = com.gau.go.launcherex.gowidget.weather.c.c.a(this.b.getApplicationContext()).h();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      com.gau.go.launcherex.gowidget.weather.model.c localc = (com.gau.go.launcherex.gowidget.weather.model.c)paramList.next();
      Object localObject = localf.a(localc.j());
      if (localObject != null) {
        ((WeatherBean)localObject).l.put(Integer.valueOf(localc.k()), localc);
      }
      localObject = new ExtremeCityIdBean();
      ((ExtremeCityIdBean)localObject).a(localc.j());
      ((ExtremeCityIdBean)localObject).a(localc.k());
      localArrayList.add(localObject);
    }
    paramList = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_UPDATE_EXTREME_WEATHER");
    paramList.putParcelableArrayListExtra("extra_extreme_city_ids", localArrayList);
    this.b.sendBroadcast(paramList);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/b/at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */