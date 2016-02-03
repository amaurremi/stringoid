package com.gau.go.launcherex.gowidget.weather.b;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.gau.go.launcherex.gowidget.language.b;
import com.gau.go.launcherex.gowidget.language.d;
import com.gau.go.launcherex.gowidget.weather.model.ForecastBean;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.model.c;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

class av
{
  int a = at.a();
  boolean b = false;
  boolean c;
  boolean d;
  int e;
  int f;
  int g;
  String h;
  int i;
  int j;
  int k;
  int l;
  String m;
  String n;
  c o = new c();
  
  av(at paramat, WeatherBean paramWeatherBean)
  {
    this.g = at.a(paramat).g;
    this.e = at.a(paramat).w;
    this.f = at.a(paramat).v;
    if (paramWeatherBean == null)
    {
      this.i = 55536;
      this.j = 55536;
      this.k = 55536;
      this.l = 55536;
      this.m = at.b(paramat).getString(2131166455);
      this.n = "";
      return;
    }
    this.o.g(paramWeatherBean.c());
    this.o.a(paramWeatherBean.k.n());
    long l1 = paramWeatherBean.k.f();
    this.o.a(at.a(paramat, l1));
    this.o.b(at.a(paramat, l1 + 86400000L));
    this.n = paramWeatherBean.c();
    this.m = paramWeatherBean.d();
    Object localObject1 = Calendar.getInstance();
    Object localObject2 = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH);
    String str = ((SimpleDateFormat)localObject2).format(((Calendar)localObject1).getTime());
    ((Calendar)localObject1).add(5, 1);
    localObject2 = ((SimpleDateFormat)localObject2).format(((Calendar)localObject1).getTime());
    Iterator localIterator = paramWeatherBean.g.iterator();
    localObject1 = null;
    paramWeatherBean = localForecastBean;
    if (localIterator.hasNext())
    {
      localForecastBean = (ForecastBean)localIterator.next();
      if (str.equals(localForecastBean.c())) {
        localObject1 = localForecastBean;
      }
      if (!((String)localObject2).equals(localForecastBean.c())) {
        break label517;
      }
      paramWeatherBean = localForecastBean;
    }
    label436:
    label517:
    for (;;)
    {
      break;
      if ((localObject1 != null) && (paramWeatherBean != null))
      {
        if (this.g != 2) {
          break label436;
        }
        this.i = com.gau.go.launcherex.gowidget.weather.util.q.a(((ForecastBean)localObject1).b(2));
        this.j = com.gau.go.launcherex.gowidget.weather.util.q.a(((ForecastBean)localObject1).a(2));
        this.k = com.gau.go.launcherex.gowidget.weather.util.q.a(paramWeatherBean.b(2));
        this.l = com.gau.go.launcherex.gowidget.weather.util.q.a(paramWeatherBean.a(2));
      }
      for (this.h = "°F";; this.h = "°C")
      {
        this.d = at.a(paramat, this.k, this.i, this.e);
        this.c = at.a(paramat, this.j, this.l, this.f);
        return;
        this.e = com.gau.go.launcherex.gowidget.weather.util.q.a(this.e);
        this.f = com.gau.go.launcherex.gowidget.weather.util.q.a(this.f);
        this.i = com.gau.go.launcherex.gowidget.weather.util.q.a(((ForecastBean)localObject1).b(1));
        this.j = com.gau.go.launcherex.gowidget.weather.util.q.a(((ForecastBean)localObject1).a(1));
        this.k = com.gau.go.launcherex.gowidget.weather.util.q.a(paramWeatherBean.b(1));
        this.l = com.gau.go.launcherex.gowidget.weather.util.q.a(paramWeatherBean.a(1));
      }
    }
  }
  
  private boolean a(ArrayList paramArrayList)
  {
    if ((!this.d) && (!this.c)) {}
    while (TextUtils.isEmpty(this.o.j())) {
      return false;
    }
    this.o.d(at.b(this.p).getResources().getString(2131166214));
    this.o.b(1);
    this.o.f(d());
    this.o.e("TC");
    this.o.c("TEMP");
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("cityId", this.o.j());
    localContentValues.put("description", this.o.f());
    localContentValues.put("exp_time", this.o.d());
    localContentValues.put("alert_id", Integer.valueOf(this.o.k()));
    localContentValues.put("level", Integer.valueOf(this.o.h()));
    localContentValues.put("message", this.o.i());
    localContentValues.put("phenomena", this.o.g());
    localContentValues.put("publish_time", this.o.c());
    localContentValues.put("type", this.o.e());
    localContentValues.put("tz_offset", Integer.valueOf(this.o.a()));
    localContentValues.put("has_read", Integer.valueOf(0));
    paramArrayList.add(ContentProviderOperation.newInsert(WeatherContentProvider.k).withValues(localContentValues).build());
    return true;
  }
  
  private Notification b()
  {
    int i1 = 1;
    Notification localNotification = new Notification();
    localNotification.flags |= 0x10;
    if (at.a(this.p).s == 1) {
      if (i1 != 0) {
        break label59;
      }
    }
    label59:
    for (localNotification.defaults = 7;; localNotification.defaults = 6)
    {
      localNotification.icon = 2130838352;
      return localNotification;
      i1 = 0;
      break;
    }
  }
  
  private String c()
  {
    String str1 = null;
    String str3 = this.k - this.i + this.h;
    String str2 = this.j - this.l + this.h;
    b localb = d.a(at.b(this.p)).a();
    if ((this.d) && (this.c)) {
      str1 = localb.getString(2131166235, new Object[] { str3, str2 });
    }
    do
    {
      return str1;
      if (this.d) {
        return localb.getString(2131166233, new Object[] { str3 });
      }
    } while (!this.c);
    return localb.getString(2131166234, new Object[] { str2 });
  }
  
  private String d()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    String str1 = this.k + this.h;
    String str2 = this.l + this.h;
    String str3 = this.k - this.i + this.h;
    String str4 = this.j - this.l + this.h;
    b localb = d.a(at.b(this.p)).a();
    if ((this.d) && (this.c))
    {
      localStringBuffer.append(localb.getString(2131166236, new Object[] { str3, str1 }));
      localStringBuffer.append("\n");
      localStringBuffer.append(localb.getString(2131166237, new Object[] { str4, str2 }));
    }
    for (;;)
    {
      return localStringBuffer.toString();
      if (this.d) {
        localStringBuffer.append(localb.getString(2131166236, new Object[] { str3, str1 }));
      } else if (this.c) {
        localStringBuffer.append(localb.getString(2131166237, new Object[] { str4, str2 }));
      }
    }
  }
  
  void a()
  {
    Notification localNotification;
    String str1;
    String str2;
    RemoteViews localRemoteViews;
    int i1;
    if ((this.b) && ((this.d) || (this.c)))
    {
      localNotification = b();
      localNotification.contentIntent = at.a(this.p, at.b(this.p), this.n, this.a);
      str1 = " - " + at.b(this.p).getResources().getString(2131166214);
      str2 = c();
      localNotification.tickerText = at.b(this.p).getResources().getString(2131166214);
      localRemoteViews = new RemoteViews(at.b(this.p).getPackageName(), 2130903246);
      localRemoteViews.setImageViewResource(2131231779, 2130838351);
      localRemoteViews.setViewVisibility(2131231783, 0);
      if (at.a(this.p).C.equals("notification_style_default")) {
        at.a(this.p, at.a(this.p));
      }
      i1 = 17170443;
      if (!at.a(this.p).C.equals("notification_style_default_black")) {
        break label288;
      }
      i1 = -1118482;
    }
    for (;;)
    {
      localRemoteViews.setTextColor(2131231782, i1);
      localRemoteViews.setTextColor(2131231783, i1);
      localRemoteViews.setTextViewText(2131231781, this.m);
      localRemoteViews.setTextViewText(2131231782, str1);
      localRemoteViews.setTextViewText(2131231783, str2);
      localNotification.contentView = localRemoteViews;
      at.c(this.p).notify("notification_tag_temp_change", this.a, localNotification);
      return;
      label288:
      if (at.a(this.p).C.equals("notification_style_default_white")) {
        i1 = -11316397;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/b/av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */