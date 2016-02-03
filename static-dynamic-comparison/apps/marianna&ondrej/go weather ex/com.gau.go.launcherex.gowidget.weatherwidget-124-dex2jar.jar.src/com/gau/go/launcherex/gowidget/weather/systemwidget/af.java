package com.gau.go.launcherex.gowidget.weather.systemwidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.database.Cursor;
import android.text.TextUtils;
import android.text.format.Time;
import android.util.Log;
import android.util.SparseArray;
import android.widget.RemoteViews;
import com.gau.go.launcherex.gowidget.billing.BillingActivity;
import com.gau.go.launcherex.gowidget.billing.WidgetBillingChangeBroadcaster;
import com.gau.go.launcherex.gowidget.language.d;
import com.gau.go.launcherex.gowidget.scriptengine.parser.i;
import com.gau.go.launcherex.gowidget.weather.c.g;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.RequestBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.gau.go.launcherex.gowidget.weather.service.AppWidgetService;
import com.gau.go.launcherex.gowidget.weather.service.NotifyService;
import com.gau.go.launcherex.gowidget.weather.util.r;
import com.gau.go.launcherex.gowidget.weather.view.WeatherDetailActivity;
import com.gtp.a.a.a.a;
import java.util.ArrayList;
import java.util.Iterator;

public class af
  implements com.gau.go.launcherex.gowidget.billing.x, aa, ae
{
  private Context a;
  private SparseArray b = new SparseArray();
  private ah c;
  private g d;
  private Resources e;
  private ak f;
  private ak g;
  private ai h;
  private aj i;
  private ArrayList j = new ArrayList();
  private boolean k = false;
  private boolean l = false;
  private boolean m = false;
  private Intent n;
  private boolean o;
  private WidgetBillingChangeBroadcaster p;
  private boolean q = false;
  private boolean r = true;
  
  public af(Context paramContext)
  {
    this.a = paramContext;
    this.e = d.a(this.a).a();
    if (this.e == null) {
      this.e = this.a.getResources();
    }
    this.d = new g(this.a);
    this.d.a(true);
    this.h = new ai(this.a.getContentResolver(), this);
    this.c = new ah(this, null);
    paramContext = new IntentFilter();
    paramContext.addAction("android.intent.action.TIME_TICK");
    paramContext.addAction("android.intent.action.TIME_SET");
    paramContext.addAction("android.intent.action.DATE_CHANGED");
    paramContext.addAction("android.intent.action.TIMEZONE_CHANGED");
    paramContext.addAction("android.intent.action.SCREEN_ON");
    paramContext.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_REFRESH_STARTED");
    paramContext.addAction("com.gau.go.launcherex.gowidget.weatherwidget.goweather.ACTION_UPDATE_DATA");
    paramContext.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_INITIALIZED_CITY");
    this.a.registerReceiver(this.c, paramContext);
    a.a().a("AppWidgetWorldClock42ProviderHelper registerReceiver", "插件错误.txt");
    this.k = false;
    this.f = new ak(this, null);
    this.f.a = 16;
    this.f.g = 2131231092;
    this.f.k = 2131231084;
    this.f.l = 2131231082;
    this.f.n = 2131231093;
    this.f.i = 2131231094;
    this.f.j = 2131231095;
    this.f.b = 2131231086;
    this.f.c = 2131231087;
    this.f.d = 2131231088;
    this.f.e = 2131231090;
    this.f.f = 2131231091;
    this.f.h = 2131231096;
    this.f.m = 2131231083;
    this.g = new ak(this, null);
    this.g.a = 32;
    this.g.g = 2131231108;
    this.g.k = 2131231100;
    this.g.l = 2131231098;
    this.g.n = 2131231109;
    this.g.i = 2131231110;
    this.g.j = 2131231111;
    this.g.b = 2131231102;
    this.g.c = 2131231103;
    this.g.d = 2131231104;
    this.g.e = 2131231106;
    this.g.f = 2131231107;
    this.g.h = 2131231112;
    this.g.m = 2131231099;
    this.i = new aj(this, null);
    this.i.a = r.b(this.a);
    this.p = new WidgetBillingChangeBroadcaster(this.a);
    this.p.a(this);
    paramContext = ab.a(this.a);
    paramContext.a(this);
    if (paramContext.a) {
      b(paramContext.a());
    }
    paramContext = x.a(this.a);
    paramContext.a(this);
    if (paramContext.a) {
      a(paramContext.a());
    }
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    int i1 = 2130838898;
    switch (paramInt2)
    {
    default: 
      paramInt2 = 2130838897;
      return paramInt2;
    case 16: 
      paramInt2 = i1;
      switch (paramInt1)
      {
      case 1: 
      default: 
        return 2130838897;
      case 2: 
        return 2130838899;
      case 3: 
        return 2130838900;
      case 4: 
        return 2130838901;
      case 5: 
        return 2130838902;
      case 6: 
        return 2130838903;
      case 7: 
        return 2130838904;
      case 8: 
        return 2130838905;
      }
      return 2130838906;
    }
    paramInt2 = i1;
    switch (paramInt1)
    {
    case 1: 
    default: 
      return 2130838897;
    case 2: 
      return 2130838899;
    case 3: 
      return 2130838900;
    case 4: 
      return 2130838901;
    case 5: 
      return 2130838902;
    case 6: 
      return 2130838903;
    case 7: 
      return 2130838904;
    case 8: 
      return 2130838905;
    }
    return 2130838906;
  }
  
  private int a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2)) {
      return 1;
    }
    if ((paramBoolean1) && (!paramBoolean2)) {
      return 2;
    }
    if ((!paramBoolean1) && (paramBoolean2)) {
      return 3;
    }
    return 0;
  }
  
  private PendingIntent a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    int i2 = this.j.size();
    int i1 = 0;
    while (i1 < i2)
    {
      localObject = (WeatherBean)this.j.get(i1);
      RequestBean localRequestBean = new RequestBean();
      localRequestBean.a(((WeatherBean)localObject).c(), ((WeatherBean)localObject).d(), ((WeatherBean)localObject).k.g());
      localArrayList.add(localRequestBean);
      i1 += 1;
    }
    Object localObject = new Intent(paramContext, NotifyService.class);
    ((Intent)localObject).putExtra("notify_request", 22);
    ((Intent)localObject).putParcelableArrayListExtra("req_arg", localArrayList);
    return PendingIntent.getService(paramContext, 131072, (Intent)localObject, 134217728);
  }
  
  private PendingIntent a(Context paramContext, int paramInt, com.gau.go.launcherex.gowidget.weather.model.x paramx)
  {
    int i1 = 196608;
    Intent localIntent = new Intent(paramContext, AppWidgetService.class);
    localIntent.putExtra("appwidget_service_request", 21);
    localIntent.putExtra("request_extra_appwidget_type", 6);
    localIntent.putExtra("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APPWIDGET_WORLD_CLOCK_42_CITY_CHANGE", paramInt);
    if (paramx != null)
    {
      localIntent.putExtra("extra_appwidget_ids", paramx.a());
      i1 = 196608 + paramx.a() * paramInt;
    }
    return PendingIntent.getService(paramContext, i1, localIntent, 134217728);
  }
  
  private PendingIntent a(Context paramContext, ak paramak, com.gau.go.launcherex.gowidget.weather.model.x paramx)
  {
    if ((paramx != null) && (paramak != null)) {}
    int i1;
    Object localObject;
    switch (paramak.a)
    {
    default: 
      i1 = 0;
      int i3 = this.j.size();
      int i2;
      if (i1 >= 0)
      {
        i2 = i1;
        if (i1 < i3) {}
      }
      else
      {
        i2 = 0;
      }
      if (i3 != 0)
      {
        localObject = (WeatherBean)this.j.get(i2);
        label90:
        String str = "";
        if (localObject != null) {
          str = ((WeatherBean)localObject).c();
        }
        localObject = WeatherDetailActivity.a(this.a, str, true, 14, "", -1);
        ((Intent)localObject).addFlags(67108864);
        if ((paramx == null) || (paramak == null)) {
          break label237;
        }
        switch (paramak.a)
        {
        default: 
          i1 = paramx.a() * 8 + 262144;
        }
      }
      break;
    }
    for (;;)
    {
      return PendingIntent.getActivity(paramContext, i1, (Intent)localObject, 134217728);
      i1 = b(paramx.b());
      break;
      i1 = b(paramx.c());
      break;
      localObject = null;
      break label90;
      i1 = paramx.a() * 7 + 262144;
      continue;
      label237:
      i1 = 262144;
    }
  }
  
  private RemoteViews a(com.gau.go.launcherex.gowidget.weather.model.x paramx)
  {
    RemoteViews localRemoteViews = new RemoteViews(this.a.getPackageName(), 2130903075);
    a(localRemoteViews, paramx);
    return localRemoteViews;
  }
  
  private WeatherBean a(String paramString)
  {
    if (this.j.isEmpty()) {
      return null;
    }
    Iterator localIterator = this.j.iterator();
    while (localIterator.hasNext())
    {
      WeatherBean localWeatherBean = (WeatherBean)localIterator.next();
      if (localWeatherBean.c().equals(paramString)) {
        return localWeatherBean;
      }
    }
    return null;
  }
  
  private String a(int paramInt, boolean paramBoolean, Time paramTime)
  {
    if (paramTime.hour < 12) {}
    for (int i1 = 1;; i1 = 0) {
      switch (paramInt)
      {
      default: 
        return "";
      }
    }
    if (paramBoolean) {
      return "";
    }
    if (i1 != 0) {
      return "AM";
    }
    return "PM";
    if (paramBoolean) {
      return "";
    }
    if (i1 != 0) {
      return "AM";
    }
    return "PM";
  }
  
  private void a(int paramInt)
  {
    boolean bool4 = false;
    boolean bool3 = false;
    com.gau.go.launcherex.gowidget.weather.model.x localx;
    Object localObject2;
    Object localObject1;
    boolean bool1;
    if (paramInt != 0)
    {
      localx = (com.gau.go.launcherex.gowidget.weather.model.x)this.b.get(paramInt);
      if (localx == null) {
        break label418;
      }
      localObject2 = localx.b();
      localObject1 = localx.c();
      if (!this.j.isEmpty())
      {
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (a((String)localObject2) != null)) {
          break label242;
        }
        if (!b(localx.e())) {
          break label200;
        }
        localObject2 = c();
        if (localObject2 == null) {
          break label200;
        }
        localx.a(((WeatherBean)localObject2).c());
        bool1 = true;
      }
    }
    for (;;)
    {
      paramInt = 1;
      for (;;)
      {
        label106:
        boolean bool2;
        label159:
        int i1;
        if ((TextUtils.isEmpty((CharSequence)localObject1)) || (a((String)localObject1) == null)) {
          if (c(localx.e()))
          {
            localObject1 = c();
            if (localObject1 != null)
            {
              localx.b(((WeatherBean)localObject1).c());
              bool2 = true;
              i1 = 1;
            }
          }
        }
        for (;;)
        {
          if (i1 != 0)
          {
            localx.c(a(bool1, bool2));
            v.a(this.a).b(localx);
          }
          a(this.a, localx);
          return;
          label200:
          localObject2 = (WeatherBean)this.j.get(0);
          if (localObject2 == null) {
            break label487;
          }
          localx.a(((WeatherBean)localObject2).c());
          if (((WeatherBean)localObject2).e() != 2) {
            break label487;
          }
          bool1 = true;
          break;
          label242:
          if (!b(localx.e())) {
            break label480;
          }
          localObject2 = c();
          if (localObject2 == null) {
            break label480;
          }
          if (localx.b().equals(((WeatherBean)localObject2).c())) {
            break label473;
          }
          localx.a(((WeatherBean)localObject2).c());
          bool1 = true;
          paramInt = 1;
          break label106;
          localObject1 = (WeatherBean)this.j.get(0);
          bool2 = bool3;
          if (localObject1 == null) {
            break label159;
          }
          localx.b(((WeatherBean)localObject1).c());
          bool2 = bool3;
          if (((WeatherBean)localObject1).e() != 2) {
            break label159;
          }
          bool2 = true;
          break label159;
          i1 = paramInt;
          bool2 = bool4;
          if (c(localx.e()))
          {
            localObject1 = c();
            i1 = paramInt;
            bool2 = bool4;
            if (localObject1 != null) {
              if (!localx.c().equals(((WeatherBean)localObject1).c()))
              {
                localx.b(((WeatherBean)localObject1).c());
                bool2 = true;
                i1 = 1;
                continue;
                label418:
                this.h.a(1, Integer.valueOf(paramInt), WeatherContentProvider.t, new String[] { "current_cityid", "widget_location_type" }, "widget_id=?", new String[] { String.valueOf(paramInt) }, null);
              }
              else
              {
                bool2 = true;
                i1 = paramInt;
              }
            }
          }
        }
        label473:
        bool1 = true;
        paramInt = 0;
        continue;
        label480:
        bool1 = false;
        paramInt = 0;
      }
      label487:
      bool1 = false;
    }
  }
  
  private void a(Context paramContext, com.gau.go.launcherex.gowidget.weather.model.x paramx)
  {
    int i1 = 0;
    if (paramx != null) {
      i1 = paramx.a();
    }
    if (i1 == 0) {}
    do
    {
      return;
      paramContext = a(paramx);
      paramx = AppWidgetManager.getInstance(this.a);
    } while ((paramx == null) || (i1 == 0));
    paramx.updateAppWidget(i1, paramContext);
  }
  
  private void a(RemoteViews paramRemoteViews, com.gau.go.launcherex.gowidget.weather.model.x paramx)
  {
    a(paramRemoteViews, this.f, paramx);
    a(paramRemoteViews, this.g, paramx);
    b(paramRemoteViews, this.f, paramx);
    b(paramRemoteViews, this.g, paramx);
    c(paramRemoteViews, this.f, paramx);
    c(paramRemoteViews, this.g, paramx);
    d(paramRemoteViews, this.f, paramx);
    d(paramRemoteViews, this.g, paramx);
    e(paramRemoteViews, this.f, paramx);
    e(paramRemoteViews, this.g, paramx);
    f(paramRemoteViews, this.f, paramx);
    f(paramRemoteViews, this.g, paramx);
    a(paramRemoteViews, this.q);
    b(paramRemoteViews, paramx);
  }
  
  private void a(RemoteViews paramRemoteViews, ak paramak, com.gau.go.launcherex.gowidget.weather.model.x paramx)
  {
    if ((paramRemoteViews == null) || (paramak == null) || (paramx == null)) {
      return;
    }
    int i1;
    int i3;
    int i2;
    label93:
    Time localTime;
    switch (paramak.a)
    {
    default: 
      i1 = 0;
      i3 = this.j.size();
      if (i1 >= 0)
      {
        i2 = i1;
        if (i1 < i3) {}
      }
      else
      {
        i2 = 0;
      }
      if (i3 != 0)
      {
        paramx = (WeatherBean)this.j.get(i2);
        if ((paramx == null) || (paramx.k == null)) {
          break label393;
        }
        localTime = this.d.b(paramx.k.n());
        Log.d("appwidget_worldclock", paramx.d() + "[" + localTime.hour + ":" + localTime.minute + "]");
      }
      break;
    }
    label393:
    for (paramx = localTime;; paramx = this.d.c())
    {
      i2 = paramx.hour;
      i1 = i2;
      if (!this.i.a)
      {
        i2 %= 12;
        i1 = i2;
        if (i2 == 0) {
          i1 = 12;
        }
      }
      i2 = i1 / 10;
      i3 = paramx.minute / 10;
      int i4 = paramx.minute;
      paramRemoteViews.setImageViewResource(paramak.c, a(i2, paramak.a));
      paramRemoteViews.setImageViewResource(paramak.d, a(i1 % 10, paramak.a));
      paramRemoteViews.setImageViewResource(paramak.e, a(i3, paramak.a));
      paramRemoteViews.setImageViewResource(paramak.f, a(i4 % 10, paramak.a));
      paramRemoteViews.setTextViewText(paramak.g, a(paramak.a, this.i.a, paramx));
      paramRemoteViews.setOnClickPendingIntent(paramak.b, b(this.a));
      return;
      i1 = b(paramx.b());
      break;
      i1 = b(paramx.c());
      break;
      paramx = null;
      break label93;
    }
  }
  
  private void a(RemoteViews paramRemoteViews, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramRemoteViews.setViewVisibility(2131231114, 4);
      paramRemoteViews.setViewVisibility(2131231115, 0);
      return;
    }
    paramRemoteViews.setViewVisibility(2131231114, 0);
    paramRemoteViews.setOnClickPendingIntent(2131231114, a(this.a));
    paramRemoteViews.setViewVisibility(2131231115, 4);
  }
  
  private void a(ak paramak, com.gau.go.launcherex.gowidget.weather.model.x paramx)
  {
    boolean bool3 = true;
    if ((paramx == null) || (paramak == null)) {}
    int i1;
    int i2;
    do
    {
      do
      {
        return;
        switch (paramak.a)
        {
        default: 
          i1 = -1;
        }
      } while (i1 == -1);
      i2 = (i1 + 1) % this.j.size();
    } while (i1 == i2);
    WeatherBean localWeatherBean = (WeatherBean)this.j.get(i2);
    boolean bool1;
    boolean bool2;
    if (localWeatherBean != null)
    {
      bool1 = b(paramx.e());
      bool2 = c(paramx.e());
      switch (paramak.a)
      {
      default: 
        bool3 = bool2;
        bool2 = bool1;
        bool1 = bool3;
      }
    }
    for (;;)
    {
      paramx.c(a(bool2, bool1));
      v.a(this.a).b(paramx);
      Log.d("AppWidgetWorldClock42ProviderHelper", "after change cityId > " + paramx.b() + " | " + paramx.c());
      a(this.a, paramx);
      return;
      i1 = b(paramx.b());
      break;
      i1 = b(paramx.c());
      break;
      paramx.a(localWeatherBean.c());
      if (localWeatherBean.e() == 2)
      {
        bool1 = bool2;
        bool2 = bool3;
      }
      else
      {
        bool1 = bool2;
        bool2 = false;
        continue;
        paramx.b(localWeatherBean.c());
        if (localWeatherBean.e() == 2)
        {
          bool3 = true;
          bool2 = bool1;
          bool1 = bool3;
        }
        else
        {
          bool3 = false;
          bool2 = bool1;
          bool1 = bool3;
        }
      }
    }
  }
  
  private void a(Object paramObject, Cursor paramCursor)
  {
    Integer localInteger = (Integer)paramObject;
    int i1;
    if ((paramCursor != null) && (paramCursor.getCount() > 0))
    {
      com.gau.go.launcherex.gowidget.weather.model.x localx = new com.gau.go.launcherex.gowidget.weather.model.x();
      localx.b(6);
      localx.a(localInteger.intValue());
      paramCursor.moveToFirst();
      int i2 = paramCursor.getColumnCount();
      i1 = 0;
      paramObject = localx;
      if (i1 < i2)
      {
        paramObject = paramCursor.getColumnName(i1);
        if (((String)paramObject).equals("current_cityid"))
        {
          paramObject = paramCursor.getString(i1);
          if ((!TextUtils.isEmpty((CharSequence)paramObject)) && (((String)paramObject).contains("#")))
          {
            paramObject = ((String)paramObject).split("#");
            if ((paramObject != null) && (paramObject.length == 2))
            {
              localx.a(paramObject[0]);
              localx.b(paramObject[1]);
            }
          }
        }
        for (;;)
        {
          i1 += 1;
          break;
          if (((String)paramObject).equals("widget_location_type")) {
            localx.c(paramCursor.getInt(i1));
          }
        }
      }
    }
    else
    {
      if (this.b.get(localInteger.intValue()) != null) {
        break label334;
      }
      paramObject = d(localInteger.intValue());
      v.a(this.a).a((com.gau.go.launcherex.gowidget.weather.model.x)paramObject);
      Log.d("AppWidgetWorldClock42ProviderHelper", "new widgetId > " + localInteger);
    }
    for (;;)
    {
      if (paramObject != null)
      {
        this.b.append(localInteger.intValue(), paramObject);
        a(this.a, (com.gau.go.launcherex.gowidget.weather.model.x)paramObject);
      }
      if (paramCursor != null) {}
      try
      {
        paramCursor.close();
        if (this.n != null)
        {
          i1 = this.n.getIntExtra("extra_appwidget_ids", 0);
          if ((i1 != 0) && (i1 == localInteger.intValue()))
          {
            a(this.n);
            this.n = null;
          }
        }
        return;
      }
      catch (Exception paramObject)
      {
        for (;;)
        {
          ((Exception)paramObject).printStackTrace();
        }
      }
      label334:
      paramObject = null;
    }
  }
  
  private int b(String paramString)
  {
    if ((this.j.isEmpty()) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return 0;
      int i1 = 0;
      while (i1 < this.j.size())
      {
        WeatherBean localWeatherBean = (WeatherBean)this.j.get(i1);
        if ((localWeatherBean != null) && (localWeatherBean.c().equals(paramString))) {
          return i1;
        }
        i1 += 1;
      }
    }
  }
  
  private PendingIntent b(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, AppWidgetService.class);
    localIntent.putExtra("appwidget_service_request", 19);
    return PendingIntent.getService(paramContext, 458752, localIntent, 134217728);
  }
  
  private void b()
  {
    Log.d("AppWidgetWorldClock42ProviderHelper", "refreshUI");
    if (this.o)
    {
      int[] arrayOfInt = AppWidgetManager.getInstance(this.a).getAppWidgetIds(new ComponentName(this.a, AppWidgetWorldClock42Provider.class));
      Log.d("AppWidgetWorldClock42ProviderHelper", "共找到有" + arrayOfInt.length + "个该系统widget样式");
      int i1 = 0;
      while (i1 < arrayOfInt.length)
      {
        Log.d("AppWidgetWorldClock42ProviderHelper", "第" + i1 + "个widgetID：" + arrayOfInt[i1]);
        a(arrayOfInt[i1]);
        i1 += 1;
      }
    }
    d();
  }
  
  private void b(RemoteViews paramRemoteViews, com.gau.go.launcherex.gowidget.weather.model.x paramx)
  {
    if (this.j.size() < 1)
    {
      paramRemoteViews.setOnClickPendingIntent(this.f.l, a(this.a, this.f, paramx));
      paramRemoteViews.setOnClickPendingIntent(this.g.l, a(this.a, this.g, paramx));
      return;
    }
    if (this.j.size() < 2)
    {
      paramx = a(this.a, this.f, paramx);
      paramRemoteViews.setOnClickPendingIntent(this.f.l, paramx);
      paramRemoteViews.setOnClickPendingIntent(this.g.l, paramx);
      return;
    }
    paramRemoteViews.setOnClickPendingIntent(this.f.l, a(this.a, this.f.a, paramx));
    paramRemoteViews.setOnClickPendingIntent(this.g.l, a(this.a, this.g.a, paramx));
  }
  
  private void b(RemoteViews paramRemoteViews, ak paramak, com.gau.go.launcherex.gowidget.weather.model.x paramx)
  {
    if ((paramRemoteViews == null) || (paramak == null) || (paramx == null)) {
      return;
    }
    WeatherBean localWeatherBean;
    label94:
    boolean bool;
    switch (paramak.a)
    {
    default: 
      i1 = 0;
      int i3 = this.j.size();
      int i2;
      if (i1 >= 0)
      {
        i2 = i1;
        if (i1 < i3) {}
      }
      else
      {
        i2 = 0;
      }
      if (i3 != 0)
      {
        localWeatherBean = (WeatherBean)this.j.get(i2);
        bool = b(paramak, paramx);
        if ((localWeatherBean == null) || (localWeatherBean.k == null)) {
          break label196;
        }
      }
      break;
    }
    label196:
    for (int i1 = localWeatherBean.k.d();; i1 = 1)
    {
      paramRemoteViews.setImageViewResource(paramak.h, r.a(i.i, i1, bool));
      paramx = a(this.a, paramak, paramx);
      paramRemoteViews.setOnClickPendingIntent(paramak.h, paramx);
      return;
      i1 = b(paramx.b());
      break;
      i1 = b(paramx.c());
      break;
      localWeatherBean = null;
      break label94;
    }
  }
  
  private void b(String paramString, com.gau.go.launcherex.gowidget.weather.model.q paramq)
  {
    if ("tempUnit".equals(paramString))
    {
      this.i.c = paramq.g;
      b();
    }
    do
    {
      return;
      if ("dateStyle".equals(paramString))
      {
        this.i.b = paramq.k;
        b();
        return;
      }
    } while (!"Google_play_billing".equals(paramString));
    this.o = paramq.J;
    if (this.o) {
      this.d.a(true);
    }
    for (;;)
    {
      b();
      return;
      this.d.a(false);
    }
  }
  
  private boolean b(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 2);
  }
  
  private boolean b(ak paramak, com.gau.go.launcherex.gowidget.weather.model.x paramx)
  {
    boolean bool2 = false;
    if ((paramx != null) && (paramak != null)) {}
    int i1;
    label85:
    label113:
    boolean bool1;
    switch (paramak.a)
    {
    default: 
      i1 = 0;
      int i3 = this.j.size();
      int i2;
      if (i1 >= 0)
      {
        i2 = i1;
        if (i1 < i3) {}
      }
      else
      {
        i2 = 0;
      }
      if (i3 != 0)
      {
        paramak = (WeatherBean)this.j.get(i2);
        if ((paramak == null) || (paramak.k == null)) {
          break label163;
        }
        paramak = paramak.k;
        paramx = this.d.c(paramak.n());
        if (paramak == null) {
          break label176;
        }
        bool1 = r.a(paramak.j(), paramak.k(), paramx);
      }
      break;
    }
    label163:
    label176:
    do
    {
      do
      {
        return bool1;
        i1 = b(paramx.b());
        break;
        i1 = b(paramx.c());
        break;
        paramak = null;
        break label85;
        paramx = this.d.c();
        paramak = null;
        break label113;
        bool1 = bool2;
      } while (paramx.hour < 6);
      bool1 = bool2;
    } while (paramx.hour > 18);
    return true;
  }
  
  private PendingIntent c(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, AppWidgetService.class);
    localIntent.putExtra("appwidget_service_request", 20);
    return PendingIntent.getService(paramContext, 524288, localIntent, 134217728);
  }
  
  private WeatherBean c()
  {
    if (!this.j.isEmpty())
    {
      Iterator localIterator = this.j.iterator();
      while (localIterator.hasNext())
      {
        WeatherBean localWeatherBean = (WeatherBean)localIterator.next();
        if ((localWeatherBean != null) && (localWeatherBean.e() != 1)) {
          return localWeatherBean;
        }
      }
    }
    return null;
  }
  
  private void c(RemoteViews paramRemoteViews, ak paramak, com.gau.go.launcherex.gowidget.weather.model.x paramx)
  {
    if ((paramRemoteViews == null) || (paramak == null) || (paramx == null)) {
      return;
    }
    int i1;
    int i2;
    Object localObject;
    label94:
    String str;
    switch (paramak.a)
    {
    default: 
      i1 = 0;
      int i3 = this.j.size();
      if (i1 >= 0)
      {
        i2 = i1;
        if (i1 < i3) {}
      }
      else
      {
        i2 = 0;
      }
      if (i3 != 0)
      {
        localObject = (WeatherBean)this.j.get(i2);
        if ((localObject == null) || (((WeatherBean)localObject).k == null)) {
          break label418;
        }
        i1 = com.gau.go.launcherex.gowidget.weather.util.q.a(((WeatherBean)localObject).k.a(this.i.c));
        if (i1 != -10000.0F) {
          break label307;
        }
        str = "--°";
        label142:
        i1 = com.gau.go.launcherex.gowidget.weather.util.q.a(((WeatherBean)localObject).k.b(this.i.c));
        i2 = com.gau.go.launcherex.gowidget.weather.util.q.a(((WeatherBean)localObject).k.c(this.i.c));
        if ((i1 != -10000.0F) && (i2 != -10000.0F)) {
          break label381;
        }
        localObject = "--°/--°";
      }
      break;
    }
    for (;;)
    {
      paramRemoteViews.setViewVisibility(paramak.i, 0);
      paramRemoteViews.setTextViewText(paramak.i, str);
      paramRemoteViews.setViewVisibility(paramak.j, 0);
      paramRemoteViews.setTextViewText(paramak.j, (CharSequence)localObject);
      paramx = a(this.a, paramak, paramx);
      paramRemoteViews.setOnClickPendingIntent(paramak.i, paramx);
      paramRemoteViews.setOnClickPendingIntent(paramak.j, paramx);
      return;
      i1 = b(paramx.b());
      break;
      i1 = b(paramx.c());
      break;
      localObject = null;
      break label94;
      label307:
      str = String.valueOf(com.gau.go.launcherex.gowidget.weather.util.q.a(i1));
      if (this.i.c == 2)
      {
        str = str + "°F";
        break label142;
      }
      str = str + "°C";
      break label142;
      label381:
      localObject = i1 + "°/" + i2 + "°";
      continue;
      label418:
      str = "--°";
      localObject = "--°/--°";
    }
  }
  
  private boolean c(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 3);
  }
  
  private PendingIntent d(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, BillingActivity.class);
    localIntent.putExtra("recommend_type", 3);
    return PendingIntent.getActivity(paramContext, -1, localIntent, 134217728);
  }
  
  private com.gau.go.launcherex.gowidget.weather.model.x d(int paramInt)
  {
    com.gau.go.launcherex.gowidget.weather.model.x localx = new com.gau.go.launcherex.gowidget.weather.model.x();
    localx.a(paramInt);
    if (!this.j.isEmpty())
    {
      WeatherBean localWeatherBean = (WeatherBean)this.j.get(0);
      if (localWeatherBean != null)
      {
        String str = localWeatherBean.c();
        localx.a(str);
        localx.b(str);
        if (localWeatherBean.e() != 2) {
          break label78;
        }
        localx.c(1);
      }
    }
    for (;;)
    {
      localx.b(6);
      return localx;
      label78:
      localx.c(0);
    }
  }
  
  private void d()
  {
    RemoteViews localRemoteViews = new RemoteViews(this.a.getPackageName(), 2130903076);
    localRemoteViews.setOnClickPendingIntent(2131231079, d(this.a));
    AppWidgetManager.getInstance(this.a).updateAppWidget(new ComponentName(this.a, AppWidgetWorldClock42Provider.class), localRemoteViews);
  }
  
  private void d(RemoteViews paramRemoteViews, ak paramak, com.gau.go.launcherex.gowidget.weather.model.x paramx) {}
  
  private void e(RemoteViews paramRemoteViews, ak paramak, com.gau.go.launcherex.gowidget.weather.model.x paramx)
  {
    if ((paramRemoteViews == null) || (paramak == null) || (paramx == null)) {
      return;
    }
    int i1;
    WeatherBean localWeatherBean;
    switch (paramak.a)
    {
    default: 
      i1 = 0;
      int i3 = this.j.size();
      int i2;
      if (i1 >= 0)
      {
        i2 = i1;
        if (i1 < i3) {}
      }
      else
      {
        i2 = 0;
      }
      if (i3 != 0)
      {
        localWeatherBean = (WeatherBean)this.j.get(i2);
        label94:
        if (localWeatherBean == null) {
          break label230;
        }
        paramx = localWeatherBean.d();
        if (localWeatherBean.e() == 1) {
          break label282;
        }
        switch (paramak.a)
        {
        default: 
          i1 = -1;
        }
      }
      break;
    }
    for (;;)
    {
      paramRemoteViews.setTextViewText(paramak.k, paramx);
      if (i1 != -1)
      {
        paramRemoteViews.setImageViewResource(paramak.m, i1);
        paramRemoteViews.setViewVisibility(paramak.m, 0);
        return;
        i1 = b(paramx.b());
        break;
        i1 = b(paramx.c());
        break;
        localWeatherBean = null;
        break label94;
        i1 = 2130839061;
        continue;
        i1 = 2130839061;
        continue;
        label230:
        if (this.r)
        {
          paramx = this.e.getString(2131166458);
          i1 = -1;
          continue;
        }
        paramx = this.e.getString(2131166455);
        i1 = -1;
        continue;
      }
      paramRemoteViews.setViewVisibility(paramak.m, 8);
      return;
      label282:
      i1 = -1;
    }
  }
  
  private void f(RemoteViews paramRemoteViews, ak paramak, com.gau.go.launcherex.gowidget.weather.model.x paramx)
  {
    if ((paramRemoteViews == null) || (paramak == null) || (paramx == null)) {
      return;
    }
    int i1;
    switch (paramak.a)
    {
    default: 
      i1 = 0;
      int i3 = this.j.size();
      int i2;
      if (i1 >= 0)
      {
        i2 = i1;
        if (i1 < i3) {}
      }
      else
      {
        i2 = 0;
      }
      if (i3 != 0)
      {
        paramx = (WeatherBean)this.j.get(i2);
        label93:
        if ((paramx == null) || (paramx.k == null)) {
          break label211;
        }
      }
      break;
    }
    label211:
    for (paramx = this.d.b(paramx.k.n());; paramx = this.d.c())
    {
      this.d.a(1, this.i.b);
      paramx = this.d.a(paramx);
      paramRemoteViews.setViewVisibility(paramak.n, 0);
      paramRemoteViews.setTextViewText(paramak.n, paramx);
      paramx = c(this.a);
      paramRemoteViews.setOnClickPendingIntent(paramak.n, paramx);
      return;
      i1 = b(paramx.b());
      break;
      i1 = b(paramx.c());
      break;
      paramx = null;
      break label93;
    }
  }
  
  public void a()
  {
    if (this.n != null) {
      this.n = null;
    }
    this.k = false;
    this.b.clear();
    this.j.clear();
    ab.a(this.a).b(this);
    x.a(this.a).b(this);
    this.d.b();
    this.a.unregisterReceiver(this.c);
    a.a().a("AppWidgetWorldClock42ProviderHelper unregisterReceiver", "插件错误.txt");
    Log.d("AppWidgetWorldClock42ProviderHelper", "AppWidgetWorldClock42ProviderHelper ==============================> onDestroy");
  }
  
  public void a(Intent paramIntent)
  {
    int i1 = 0;
    if (paramIntent == null) {}
    do
    {
      String str;
      do
      {
        for (;;)
        {
          return;
          str = paramIntent.getAction();
          Log.d("appwidget_worldclock", "ActionReceiver.onReceive>>action:" + str);
          Log.d("AppWidgetWorldClock42ProviderHelper", "deal_action:" + str);
          if (!TextUtils.isEmpty(str)) {
            if (!this.k)
            {
              if (str.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APPWIDGET_WORLD_CLOCK_42_CITY_CHANGE")) {
                this.n = paramIntent;
              }
            }
            else
            {
              if ((str.equals("android.intent.action.TIME_TICK")) || (str.equals("android.intent.action.SCREEN_ON")))
              {
                b();
                return;
              }
              if ((str.equals("android.intent.action.TIME_SET")) || (str.equals("android.intent.action.DATE_CHANGED")) || (str.equals("android.intent.action.TIMEZONE_CHANGED")))
              {
                this.i.a = r.b(this.a);
                b();
                Log.d("AppWidgetWorldClock42ProviderHelper", "刷新时间成功");
                return;
              }
              if (str.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_REFRESH_STARTED"))
              {
                this.q = true;
                b();
                return;
              }
              if (str.equals("com.gau.go.launcherex.gowidget.weatherwidget.goweather.ACTION_UPDATE_DATA"))
              {
                this.q = false;
                b();
                return;
              }
              if (str.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APPWIDGET_WORLD_CLOCK_42_CITY_CHANGE"))
              {
                Log.d("AppWidgetWorldClock42ProviderHelper", "切换城市 > mAllHasLoaded = " + this.k);
                if (this.j.size() != 0)
                {
                  i1 = paramIntent.getIntExtra("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APPWIDGET_WORLD_CLOCK_42_CITY_CHANGE", -1);
                  int i2 = paramIntent.getIntExtra("extra_appwidget_ids", 0);
                  Log.d("AppWidgetWorldClock42ProviderHelper", "change city widgetId > " + i2);
                  paramIntent = (com.gau.go.launcherex.gowidget.weather.model.x)this.b.get(i2);
                  if (paramIntent != null)
                  {
                    if (this.n != null) {
                      this.n = null;
                    }
                    switch (i1)
                    {
                    default: 
                      return;
                    case 16: 
                      a(this.f, paramIntent);
                      return;
                    }
                    a(this.g, paramIntent);
                  }
                }
              }
              else
              {
                if (str.equals("appwidget_language_change"))
                {
                  this.e = d.a(this.a).a();
                  if (this.e == null) {
                    this.e = this.a.getResources();
                  }
                  b();
                  return;
                }
                if (str.equals("android.appwidget.action.APPWIDGET_UPDATE"))
                {
                  b();
                  return;
                }
                if (!str.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_WIDGET_DELETE_APPWIDGET_WORLDCLOCK42")) {
                  break;
                }
                if (AppWidgetManager.getInstance(this.a).getAppWidgetIds(new ComponentName(this.a, AppWidgetWorldClock42Provider.class)).length == 0)
                {
                  this.b.clear();
                  return;
                }
                paramIntent = paramIntent.getIntArrayExtra("extra_appwidget_ids");
                if (paramIntent != null) {
                  while (i1 < paramIntent.length)
                  {
                    this.b.remove(paramIntent[i1]);
                    i1 += 1;
                  }
                }
              }
            }
          }
        }
      } while (!str.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_INITIALIZED_CITY"));
      i1 = paramIntent.getIntExtra("city_location_state", 3);
      paramIntent = paramIntent.getStringExtra("city_location_id");
    } while ((i1 == 4) && (!TextUtils.isEmpty(paramIntent)));
    this.r = false;
    b();
  }
  
  public void a(com.gau.go.launcherex.gowidget.weather.model.q paramq)
  {
    this.i.b = paramq.k;
    this.d.a(0, this.i.b);
    this.i.c = paramq.g;
    this.o = paramq.J;
    if (this.o) {
      this.d.a(true);
    }
    for (;;)
    {
      if (!this.m) {
        this.m = true;
      }
      if ((!this.k) && (this.l) && (this.m))
      {
        this.k = true;
        b();
      }
      return;
      this.d.a(false);
    }
  }
  
  public void a(String paramString, com.gau.go.launcherex.gowidget.weather.model.q paramq)
  {
    Log.d("AppWidgetWorldClock42ProviderHelper", "onLoadSettingBeanDone_key = " + paramString);
    if (TextUtils.isEmpty(paramString))
    {
      a(paramq);
      return;
    }
    b(paramString, paramq);
  }
  
  public void a(ArrayList paramArrayList)
  {
    Log.d("AppWidgetWorldClock42ProviderHelper", "onLoadWeatherBeanDone");
    b(paramArrayList);
    if (this.k) {
      b();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.o = paramBoolean;
    if (this.o)
    {
      b();
      return;
    }
    d();
  }
  
  public void b(ArrayList paramArrayList)
  {
    this.j.clear();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      WeatherBean localWeatherBean = (WeatherBean)paramArrayList.next();
      this.j.add(localWeatherBean);
    }
    if (!this.l) {
      this.l = true;
    }
    if ((!this.k) && (this.l) && (this.m))
    {
      this.k = true;
      b();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/systemwidget/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */