package com.gtp.nextlauncher.widget.weatherwidget;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Handler;
import android.provider.Settings.System;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.format.Time;
import com.gau.go.launcherex.gowidget.weather.model.ForecastBean;
import com.gau.go.launcherex.gowidget.weather.model.HourlyBean;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.RequestBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.gau.go.launcherex.gowidget.weather.util.q;
import com.gau.go.launcherex.gowidget.weather.util.r;
import com.go.gl.view.GLView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class e
{
  public static int a = 2;
  public static int b = 1;
  private boolean A = false;
  private boolean B = true;
  private int C = -1;
  private boolean D = false;
  private d E = new d();
  private final BroadcastReceiver F = new f(this);
  private int G = -1;
  private boolean H = false;
  private final BroadcastReceiver I = new g(this);
  private Time J = new Time();
  private boolean K = false;
  private String L;
  private String M;
  private String N;
  private String O;
  private String P;
  private Context c = null;
  private int d = 0;
  private boolean e = false;
  private j f;
  private com.gau.go.launcherex.gowidget.weather.c.g g = null;
  private String h = "";
  private int i = -1;
  private ArrayList j = new ArrayList();
  private List k = new ArrayList();
  private ArrayList l = new ArrayList();
  private ContentResolver m;
  private boolean n = true;
  private int o = 2;
  private HourlyBean p;
  private WeatherBean q = null;
  private long r = 86400000L;
  private Time s = new Time();
  private List t;
  private Handler u;
  private i v;
  private GLView w;
  private boolean x = true;
  private boolean y = false;
  private boolean z = false;
  
  public e(Context paramContext, int paramInt, GLView paramGLView, boolean paramBoolean)
  {
    this.w = paramGLView;
    this.c = paramContext;
    this.g = new com.gau.go.launcherex.gowidget.weather.c.g(paramContext);
    this.g.a(true);
    this.d = paramInt;
    a(this.c);
    this.f = new j(this, this.c.getContentResolver());
    this.q = new WeatherBean();
    this.c.startService(new Intent("com.gau.go.launcherex.gowidget.weather.service.NotifyService"));
    if (paramBoolean) {}
    for (this.G = 1;; this.G = 0)
    {
      v();
      this.u = new Handler();
      this.m = this.c.getContentResolver();
      this.v = new i(this, this.u);
      paramContext = Settings.System.getUriFor("time_12_24");
      this.m.registerContentObserver(paramContext, true, this.v);
      H();
      return;
    }
  }
  
  private void A()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(1));
    localArrayList.add(Integer.valueOf(3));
    localArrayList.add(Integer.valueOf(4));
    b(localArrayList);
  }
  
  private void B()
  {
    this.x = false;
    this.z = false;
    z();
  }
  
  private void C()
  {
    this.f.a(9, null, WeatherContentProvider.a, new String[] { "cityId" }, null, null, "sequence");
  }
  
  private void D()
  {
    String str = this.d + "";
    this.f.a(-1, null, WeatherContentProvider.D, "go_widget_id=?", new String[] { str });
  }
  
  private void E()
  {
    String str = this.d + "";
    this.f.a(6, null, WeatherContentProvider.D, null, "go_widget_id=?", new String[] { str }, null);
  }
  
  private void F()
  {
    Intent localIntent = new Intent("com.gau.go.launcherex.gowidget.weather.service.NotifyService");
    localIntent.putExtra("notify_request", 50);
    this.c.startService(localIntent);
  }
  
  private void G()
  {
    if (this.t == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.t.iterator();
      while (localIterator.hasNext()) {
        ((h)localIterator.next()).onLoadFinish();
      }
    }
  }
  
  private void H()
  {
    if ((!L()) || (!this.g.d()) || (this.q == null))
    {
      this.s = this.g.c();
      if (this.t != null) {
        break label54;
      }
    }
    for (;;)
    {
      return;
      this.s = t();
      break;
      label54:
      Iterator localIterator = this.t.iterator();
      while (localIterator.hasNext()) {
        ((h)localIterator.next()).onTimeChange(this.s.hour, this.s.minute);
      }
    }
  }
  
  private void I()
  {
    if (this.t == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.t.iterator();
      while (localIterator.hasNext()) {
        ((h)localIterator.next()).startRefresh();
      }
    }
  }
  
  private void J()
  {
    if (this.t == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.t.iterator();
      while (localIterator.hasNext()) {
        ((h)localIterator.next()).endRefresh();
      }
    }
  }
  
  private Time K()
  {
    if ((this.g.d()) && (this.q != null) && (L()))
    {
      int i1 = this.q.k.n();
      return this.g.b(i1);
    }
    return this.g.c();
  }
  
  private boolean L()
  {
    return this.n;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    int i1 = this.j.size();
    Object localObject;
    if ((paramInt1 >= 0) && (paramInt2 >= 0) && (paramInt1 < i1) && (paramInt2 < i1) && (paramInt1 != paramInt2))
    {
      localObject = (WeatherBean)this.j.remove(paramInt1);
      if (paramInt2 != i1 - 1) {
        break label121;
      }
      this.j.add(localObject);
    }
    for (;;)
    {
      localObject = ((WeatherBean)this.j.get(this.i)).c();
      if (!((String)localObject).equals(this.h))
      {
        this.h = ((String)localObject);
        this.q = ((WeatherBean)this.j.get(this.i));
        w();
      }
      return;
      label121:
      this.j.add(paramInt2, localObject);
    }
  }
  
  private void a(Context paramContext)
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.TIME_TICK");
    localIntentFilter.addAction("android.intent.action.TIME_SET");
    localIntentFilter.addAction("android.intent.action.DATE_CHANGED");
    localIntentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    localIntentFilter.addAction("android.intent.action.SCREEN_ON");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.action_clock_binding_app");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_LOCATION");
    localIntentFilter.addAction("android.intent.action.CONFIGURATION_CHANGED");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_LUNAR");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_TEMPERATURE_UNIT");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_WIND_UNIT");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DATESTYLE_UNIT");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_ADD_CITY");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DELETE_CITY");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_FESTIVAL");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_REFRESH_STARTED");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.goweather.ACTION_CYCLE_MODE");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.goweather.ACTION_UPDATE_DATA");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_AUTO_LOCATION");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_GOWIDGET_THEME_CHANGE");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.PURCHASE_CHANGE");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_WORLD_CLOCK");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_UPDATE_EXTREME_WEATHER");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DELETE_EXPIRED_EXTREME_WEATHER");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_CLEAR_EXTREME_WEATHER");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.action_calendar_binding_app");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.action_clock_binding_app");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_CONVERT_INDEX_STATE");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_INITIALIZED_CITY");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_RELOAD_DATA");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DATA_READY");
    localIntentFilter.setPriority(1009);
    paramContext.registerReceiver(this.F, localIntentFilter);
    localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.PACKAGE_DATA_CLEARED");
    localIntentFilter.addDataScheme("package");
    paramContext.registerReceiver(this.I, localIntentFilter);
  }
  
  private void a(Cursor paramCursor)
  {
    int i2;
    Object localObject;
    if (paramCursor != null)
    {
      for (;;)
      {
        try
        {
          if (paramCursor.getCount() <= 0) {
            break label241;
          }
          paramCursor.moveToFirst();
          int i1 = paramCursor.getColumnIndex("setting_key");
          i2 = paramCursor.getColumnIndex("setting_value");
          localObject = paramCursor.getString(i1);
          if (((String)localObject).equals("tempUnit"))
          {
            f(paramCursor.getInt(i2));
            if (paramCursor.moveToNext()) {}
          }
          else
          {
            if (!((String)localObject).equals("dateStyle")) {
              break label121;
            }
            int i3 = paramCursor.getInt(i2);
            b = i3;
            g(i3);
            continue;
          }
          continue;
          if (!((String)localObject).equals("widgt_clock")) {
            break;
          }
        }
        catch (Exception paramCursor)
        {
          paramCursor.printStackTrace();
          return;
        }
        label121:
        this.E.a(paramCursor.getString(i2));
      }
      if (((String)localObject).equals("world_clock"))
      {
        this.n = L();
        if (this.n)
        {
          localObject = this.g;
          if (paramCursor.getInt(i2) != 1) {
            break label242;
          }
        }
      }
    }
    label241:
    label242:
    for (boolean bool = true;; bool = false)
    {
      ((com.gau.go.launcherex.gowidget.weather.c.g)localObject).a(bool);
      break;
      this.g.a(false);
      break;
      if (!((String)localObject).equals("windUnit")) {
        break;
      }
      this.o = paramCursor.getInt(i2);
      break;
      return;
    }
  }
  
  private void a(Cursor paramCursor, WeatherBean paramWeatherBean)
  {
    int i2 = paramCursor.getColumnCount();
    int i1 = 0;
    if (i1 < i2)
    {
      String str = paramCursor.getColumnName(i1);
      if (str.equals("cityName")) {
        paramWeatherBean.e(paramCursor.getString(i1));
      }
      for (;;)
      {
        i1 += 1;
        break;
        if (str.equals("cityId")) {
          paramWeatherBean.c(paramCursor.getString(i1));
        } else if (str.equals("nowDesp")) {
          paramWeatherBean.k.c(paramCursor.getString(i1));
        } else if (str.equals("nowTempValue")) {
          paramWeatherBean.k.b(paramCursor.getFloat(i1));
        } else if (str.equals("lowTempValue")) {
          paramWeatherBean.k.d(paramCursor.getFloat(i1));
        } else if (str.equals("highTempValue")) {
          paramWeatherBean.k.c(paramCursor.getFloat(i1));
        } else if (str.equals("windDirection")) {
          paramWeatherBean.k.a(paramCursor.getString(i1));
        } else if (str.equals("windStrength")) {
          paramWeatherBean.k.b(paramCursor.getString(i1));
        } else if (str.equals("windType")) {
          paramWeatherBean.k.g(paramCursor.getInt(i1));
        } else if (str.equals("humidityValue")) {
          paramWeatherBean.k.d(paramCursor.getInt(i1));
        } else if (str.equals("type")) {
          paramWeatherBean.k.e(paramCursor.getInt(i1));
        } else if (str.equals("sequence")) {
          paramWeatherBean.e(paramCursor.getInt(i1));
        } else if (str.equals("city_my_location")) {
          paramWeatherBean.a(paramCursor.getInt(i1));
        } else if (str.equals("sunrise")) {
          paramWeatherBean.k.d(paramCursor.getString(i1));
        } else if (str.equals("sunset")) {
          paramWeatherBean.k.e(paramCursor.getString(i1));
        } else if (str.equals("tz_offset")) {
          paramWeatherBean.k.h(paramCursor.getInt(i1));
        } else if (str.equals("timestamp")) {
          paramWeatherBean.k.b(paramCursor.getLong(i1));
        } else if (str.endsWith("windStrengthValue")) {
          paramWeatherBean.k.a(paramCursor.getFloat(i1));
        }
      }
    }
  }
  
  private void a(String paramString)
  {
    this.f.a(16, paramString, WeatherContentProvider.g, new String[] { "setting_key", "setting_value" }, "setting_key=?", new String[] { paramString }, null);
  }
  
  private void a(String paramString, Cursor paramCursor)
  {
    boolean bool = true;
    if ((TextUtils.isEmpty(paramString)) || (paramCursor == null)) {}
    int i1;
    label179:
    do
    {
      do
      {
        return;
        paramCursor.moveToFirst();
        i1 = paramCursor.getColumnIndex("setting_value");
      } while ((i1 == -1) || (paramCursor.getCount() == 0));
      if (paramString.equals("tempUnit"))
      {
        f(paramCursor.getInt(i1));
        return;
      }
      if (paramString.equals("dateStyle"))
      {
        i1 = paramCursor.getInt(i1);
        b = i1;
        g(i1);
        return;
      }
      if (paramString.equals("widgt_clock"))
      {
        paramString = paramCursor.getString(i1);
        this.E.a(paramString);
        return;
      }
      if (paramString.equals("world_clock"))
      {
        if (paramCursor.getInt(i1) == 1)
        {
          this.n = L();
          if (!this.n) {
            break label179;
          }
          this.g.a(bool);
        }
        for (;;)
        {
          G();
          return;
          bool = false;
          break;
          this.g.a(false);
        }
      }
    } while (!paramString.equals("windUnit"));
    this.o = paramCursor.getInt(i1);
    G();
  }
  
  private void a(List paramList)
  {
    this.f.a(11, paramList, WeatherContentProvider.j, null, null, null, null);
  }
  
  private boolean a(HourlyBean paramHourlyBean)
  {
    this.s = t();
    return (paramHourlyBean.a() == this.s.year) && (paramHourlyBean.b() - 1 == this.s.month) && (paramHourlyBean.c() == this.s.monthDay) && (paramHourlyBean.d() == this.s.hour);
  }
  
  private void b(Cursor paramCursor)
  {
    label97:
    do
    {
      try
      {
        if (paramCursor.getCount() > 0)
        {
          i2 = paramCursor.getColumnCount();
          arrayOfString = paramCursor.getColumnNames();
          paramCursor.moveToFirst();
          boolean bool;
          do
          {
            localObject2 = paramCursor.getString(paramCursor.getColumnIndex("cityId"));
            i1 = this.k.indexOf(localObject2);
            if ((i1 >= 0) && (i1 < this.j.size())) {
              break;
            }
            bool = paramCursor.moveToNext();
          } while (bool);
        }
        if (paramCursor == null) {
          break label97;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int i2;
          String[] arrayOfString;
          localException.printStackTrace();
          if (paramCursor == null) {}
        }
        if (!localException[i1].equals("tempValue")) {
          break label247;
        }
        ((HourlyBean)localObject2).a(paramCursor.getFloat(i1));
      }
      finally
      {
        if (paramCursor == null) {
          break;
        }
        paramCursor.close();
      }
      paramCursor.close();
      w();
      return;
      localObject2 = (WeatherBean)this.j.get(i1);
    } while (localObject2 == null);
    Object localObject2 = ((WeatherBean)localObject2).k();
    int i1 = 0;
    while (i1 < i2)
    {
      if (arrayOfString[i1].equals("date_long")) {
        ((HourlyBean)localObject2).a(paramCursor.getString(i1));
      } else if (arrayOfString[i1].equals("hour")) {
        ((HourlyBean)localObject2).a(paramCursor.getInt(i1));
      } else {
        label247:
        if (localObject1[i1].equals("type")) {
          ((HourlyBean)localObject2).c(paramCursor.getInt(i1));
        } else if (localObject1[i1].equals("windType")) {
          ((HourlyBean)localObject2).d(paramCursor.getInt(i1));
        } else if (localObject1[i1].equals("windStrength")) {
          ((HourlyBean)localObject2).c(paramCursor.getString(i1));
        } else if (localObject1[i1].equals("windStrengthValue")) {
          ((HourlyBean)localObject2).b(paramCursor.getFloat(i1));
        } else if (localObject1[i1].equals("status")) {
          ((HourlyBean)localObject2).d(paramCursor.getString(i1));
        } else if (localObject1[i1].equals("windDirection")) {
          ((HourlyBean)localObject2).b(paramCursor.getString(i1));
        } else if (localObject1[i1].equals("pop")) {
          ((HourlyBean)localObject2).e(paramCursor.getInt(i1));
        }
      }
      i1 += 1;
    }
  }
  
  private void b(HourlyBean paramHourlyBean)
  {
    Time localTime1 = new Time();
    localTime1.set(0, 0, paramHourlyBean.d(), paramHourlyBean.c(), paramHourlyBean.b() - 1, paramHourlyBean.a());
    Time localTime2 = t();
    localTime2.set(0, 0, this.s.hour, this.s.monthDay, this.s.month, this.s.year);
    long l1 = localTime1.toMillis(true) - localTime2.toMillis(true);
    if ((l1 >= 0L) && (l1 < this.r))
    {
      this.r = l1;
      this.p = paramHourlyBean;
      this.C = this.l.indexOf(this.p);
    }
  }
  
  private void b(String paramString)
  {
    if (this.t == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.t.iterator();
      while (localIterator.hasNext()) {
        ((h)localIterator.next()).onScreenChange(paramString);
      }
    }
  }
  
  private void b(List paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {}
    switch (((Integer)paramList.remove(0)).intValue())
    {
    case 5: 
    case 6: 
    case 8: 
    case 9: 
    case 10: 
    default: 
      return;
    case 2: 
      f(paramList);
      return;
    case 1: 
      g(paramList);
      return;
    case 7: 
      c(paramList);
      return;
    case 3: 
      d(paramList);
      return;
    case 4: 
      e(paramList);
      return;
    }
    a(paramList);
  }
  
  private void c(Cursor paramCursor)
  {
    Object localObject1 = this.j.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((WeatherBean)((Iterator)localObject1).next()).g();
    }
    for (;;)
    {
      int i1;
      try
      {
        if (paramCursor.getCount() > 0)
        {
          i2 = paramCursor.getColumnCount();
          localObject1 = paramCursor.getColumnNames();
          paramCursor.moveToFirst();
          localObject3 = paramCursor.getString(paramCursor.getColumnIndex("cityId"));
          i1 = this.k.indexOf(localObject3);
          if ((i1 >= 0) && (i1 < this.j.size())) {
            continue;
          }
          boolean bool = paramCursor.moveToNext();
          if (bool) {
            continue;
          }
        }
      }
      catch (Exception localException)
      {
        int i2;
        localException.printStackTrace();
        continue;
      }
      finally
      {
        paramCursor.close();
      }
      paramCursor.close();
      G();
      return;
      Object localObject3 = (WeatherBean)this.j.get(i1);
      if (localObject3 != null)
      {
        localObject3 = ((WeatherBean)localObject3).l();
        i1 = 0;
        if (i1 < i2)
        {
          if (localObject1[i1].equals("lowTempValue")) {
            ((ForecastBean)localObject3).a(paramCursor.getFloat(i1));
          } else if (localObject1[i1].equals("highTempValue")) {
            ((ForecastBean)localObject3).b(paramCursor.getFloat(i1));
          } else if (localObject2[i1].equals("weekDate")) {
            ((ForecastBean)localObject3).f(paramCursor.getString(i1));
          } else if (localObject2[i1].equals("type")) {
            ((ForecastBean)localObject3).c(paramCursor.getInt(i1));
          } else if (localObject2[i1].equals("windType")) {
            ((ForecastBean)localObject3).d(paramCursor.getInt(i1));
          } else if (localObject2[i1].equals("status")) {
            ((ForecastBean)localObject3).d(paramCursor.getString(i1));
          } else if (localObject2[i1].equals("windDir")) {
            ((ForecastBean)localObject3).g(paramCursor.getString(i1));
          } else if (localObject2[i1].equals("windStrengthValue")) {
            ((ForecastBean)localObject3).c(paramCursor.getFloat(i1));
          } else if (localObject2[i1].equals("windStrength")) {
            ((ForecastBean)localObject3).h(paramCursor.getString(i1));
          } else if (localObject2[i1].equals("status_day")) {
            ((ForecastBean)localObject3).a(paramCursor.getString(i1));
          } else if (localObject2[i1].equals("status_night")) {
            ((ForecastBean)localObject3).b(paramCursor.getString(i1));
          } else if (localObject2[i1].equals("date_long")) {
            ((ForecastBean)localObject3).c(paramCursor.getString(i1));
          } else if (localObject2[i1].equals("pop")) {
            ((ForecastBean)localObject3).e(paramCursor.getInt(i1));
          }
          i1 += 1;
        }
      }
    }
  }
  
  private void c(String paramString)
  {
    if (this.t == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.t.iterator();
      while (localIterator.hasNext()) {
        ((h)localIterator.next()).onAutoLocateFail(paramString);
      }
    }
  }
  
  private void c(List paramList)
  {
    String str = this.d + "";
    this.f.a(7, paramList, WeatherContentProvider.D, new String[] { "city_id" }, "go_widget_id=?", new String[] { str }, null);
  }
  
  private void d(Cursor paramCursor)
  {
    if (paramCursor == null) {}
    do
    {
      return;
      paramCursor.moveToFirst();
    } while ((paramCursor == null) || (paramCursor.getCount() <= 0));
    this.k.clear();
    try
    {
      boolean bool;
      do
      {
        this.k.add(paramCursor.getString(0));
        bool = paramCursor.moveToNext();
      } while (bool);
    }
    catch (Exception paramCursor)
    {
      for (;;)
      {
        int i3;
        int i2;
        int i1;
        Object localObject;
        paramCursor.printStackTrace();
        continue;
        paramCursor = paramCursor.iterator();
        while (paramCursor.hasNext())
        {
          localObject = (WeatherBean)paramCursor.next();
          this.j.remove(localObject);
        }
        if ((i1 == 0) && (this.k.contains(this.h))) {
          this.i = this.k.indexOf(this.h);
        }
        for (this.q = ((WeatherBean)this.j.get(this.i));; this.q = ((WeatherBean)this.j.get(this.i)))
        {
          G();
          return;
          this.i = 0;
          this.h = ((String)this.k.get(this.i));
        }
      }
    }
    paramCursor = new ArrayList();
    i3 = this.j.size();
    i2 = 0;
    i1 = 0;
    while (i2 < i3)
    {
      localObject = ((WeatherBean)this.j.get(i2)).c();
      if (this.k.contains(localObject)) {
        break label306;
      }
      if (i2 != this.i) {
        break label303;
      }
      i1 = 1;
      paramCursor.add(this.j.get(i2));
      i2 += 1;
    }
  }
  
  private void d(List paramList)
  {
    this.f.a(3, paramList, WeatherContentProvider.e, new String[] { "cityId", "hour", "tempValue", "type", "windType", "windDirection", "windStrength", "windStrengthValue", "status", "windDirection", "date_long" }, null, null, "cityId");
  }
  
  private void e(Cursor paramCursor)
  {
    int i1 = 0;
    this.i = 0;
    int i2;
    if ((paramCursor != null) && (paramCursor.getCount() > 0))
    {
      paramCursor.moveToNext();
      this.h = paramCursor.getString(0);
      i2 = this.k.size();
    }
    for (;;)
    {
      if (i1 < i2)
      {
        if (this.h.equals(this.k.get(i1))) {
          this.i = i1;
        }
      }
      else {
        return;
      }
      i1 += 1;
    }
  }
  
  private void e(List paramList)
  {
    this.f.a(4, paramList, WeatherContentProvider.b, new String[] { "cityId", "weekDate", "date", "lowTempValue", "highTempValue", "type", "windType", "windDir", "windStrength", "windStrengthValue", "status", "status_day", "status_night", "date_long", "pop" }, null, null, "cityId");
  }
  
  private void f(int paramInt)
  {
    a = paramInt;
    if (this.t == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.t.iterator();
      while (localIterator.hasNext()) {
        ((h)localIterator.next()).onTemperatureUnitChange(paramInt);
      }
    }
  }
  
  private void f(List paramList)
  {
    this.f.a(2, paramList, WeatherContentProvider.g, new String[] { "setting_key", "setting_value" }, "setting_key in ('tempUnit', 'calendarType', 'festival', 'isCycle', 'dateStyle', 'world_clock', 'widgt_clock', 'widgt_calendar', 'dynamic_icon_gowidget', 'windUnit')", null, null);
  }
  
  private boolean f(Cursor paramCursor)
  {
    if ((this.B) && (!this.k.isEmpty())) {
      this.B = false;
    }
    this.A = true;
    if ((paramCursor != null) && (paramCursor.getCount() > 0))
    {
      if (this.j != null) {
        this.j.clear();
      }
      if (this.k != null) {
        this.k.clear();
      }
    }
    for (;;)
    {
      int i1;
      try
      {
        paramCursor.moveToFirst();
        localWeatherBean2 = new WeatherBean();
        localWeatherBean2.h();
        a(paramCursor, localWeatherBean2);
        int i2 = this.j.size();
        localWeatherBean1 = null;
        i1 = 0;
        if (i1 >= i2) {
          break label402;
        }
        if (!localWeatherBean2.c().equals(((WeatherBean)this.j.get(i1)).c())) {
          continue;
        }
        localWeatherBean1 = localWeatherBean2;
        if (localWeatherBean1 != null) {
          continue;
        }
        this.j.add(localWeatherBean2);
        this.k.add(localWeatherBean2.c());
        boolean bool = paramCursor.moveToNext();
        if (bool) {
          continue;
        }
      }
      catch (Exception paramCursor)
      {
        WeatherBean localWeatherBean2;
        WeatherBean localWeatherBean1;
        WeatherBean localWeatherBean3;
        paramCursor.printStackTrace();
        continue;
      }
      if ((this.k == null) || (this.k.size() < 1))
      {
        return false;
        i1 += 1;
        continue;
        localWeatherBean3 = (WeatherBean)this.j.get(i1);
        if (localWeatherBean3 != null) {
          localWeatherBean2.a(localWeatherBean3.e());
        }
        this.j.remove(i1);
        this.k.remove(localWeatherBean1.c());
        this.j.add(localWeatherBean1);
        this.k.add(localWeatherBean1.c());
        continue;
        return true;
      }
      else
      {
        this.i = this.k.indexOf(this.h);
        if (this.i == -1)
        {
          this.i = 0;
          if ((this.k != null) && (this.k.size() > this.i)) {
            this.h = ((String)this.k.get(this.i));
          }
        }
        this.q = ((WeatherBean)this.j.get(this.i));
        return false;
        label402:
        i1 = -1;
      }
    }
  }
  
  private void g(int paramInt)
  {
    if (this.t == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.t.iterator();
      while (localIterator.hasNext()) {
        ((h)localIterator.next()).onDateStyleChange(paramInt);
      }
    }
  }
  
  private void g(List paramList)
  {
    this.f.a(1, paramList, WeatherContentProvider.a, new String[] { "cityName", "cityId", "nowTempValue", "highTempValue", "lowTempValue", "windDirection", "humidityValue", "nowDesp", "type", "sequence", "city_my_location", "sunrise", "sunset", "tz_offset", "timestamp", "windStrengthValue" }, null, null, "sequence");
  }
  
  private void v()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(11));
    localArrayList.add(Integer.valueOf(2));
    localArrayList.add(Integer.valueOf(7));
    localArrayList.add(Integer.valueOf(1));
    if (this.G == 0) {
      localArrayList.add(Integer.valueOf(3));
    }
    localArrayList.add(Integer.valueOf(4));
    b(localArrayList);
  }
  
  private void w()
  {
    this.l.clear();
    this.r = 86400000L;
    if (this.q.h == null) {
      return;
    }
    Iterator localIterator = this.q.h.iterator();
    label38:
    HourlyBean localHourlyBean1;
    HourlyBean localHourlyBean2;
    for (int i1 = 0; localIterator.hasNext(); i1 = 1)
    {
      localHourlyBean1 = (HourlyBean)localIterator.next();
      if ((localHourlyBean1.a() == 55536) || (localHourlyBean1.b() == 55536) || (localHourlyBean1.c() == 55536) || (localHourlyBean1.d() == 55536) || (q.a(localHourlyBean1.b(a)) == 55536)) {
        break label38;
      }
      localHourlyBean2 = new HourlyBean();
      localHourlyBean2.a(localHourlyBean1.b(2));
      localHourlyBean2.a(localHourlyBean1.a(), localHourlyBean1.b(), localHourlyBean1.c());
      localHourlyBean2.a(localHourlyBean1.d());
      localHourlyBean2.b(localHourlyBean1.f());
      if ((localHourlyBean1.e() != 55536) && (localHourlyBean1.e() != 0)) {
        break label292;
      }
      localHourlyBean2.c(1);
      label190:
      if ((!localHourlyBean1.g().equals("--")) && (!TextUtils.isEmpty(localHourlyBean1.g()))) {
        break label304;
      }
      localHourlyBean2.d(this.c.getString(2131165323));
      label228:
      this.l.add(localHourlyBean2);
      if ((i1 != 0) || (!a(localHourlyBean2))) {
        break label316;
      }
      this.p = localHourlyBean2;
      this.C = this.l.indexOf(this.p);
      this.r = 0L;
    }
    label292:
    label304:
    label316:
    for (;;)
    {
      if (i1 == 0) {
        b(localHourlyBean2);
      }
      break label38;
      break;
      localHourlyBean2.c(localHourlyBean1.e());
      break label190;
      localHourlyBean2.d(localHourlyBean1.g());
      break label228;
    }
  }
  
  private void x()
  {
    if (this.D) {
      this.H = true;
    }
    do
    {
      do
      {
        return;
        this.D = true;
      } while (this.w == null);
      w();
      H();
      this.D = false;
    } while (!this.H);
    x();
    this.H = false;
  }
  
  private void y()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(1));
    localArrayList.add(Integer.valueOf(3));
    localArrayList.add(Integer.valueOf(4));
    b(localArrayList);
  }
  
  private void z()
  {
    this.k.clear();
    this.j.clear();
    this.q.h();
    this.q.g();
    this.q.f();
    this.l.clear();
    G();
  }
  
  public String a(WeatherBean paramWeatherBean)
  {
    return paramWeatherBean.k.e();
  }
  
  public void a()
  {
    this.E.a(this.c);
  }
  
  public void a(int paramInt)
  {
    D();
  }
  
  public void a(h paramh)
  {
    if (this.t == null) {
      this.t = new ArrayList();
    }
    if (!this.t.contains(paramh)) {
      this.t.add(paramh);
    }
    G();
  }
  
  public WeatherBean b(int paramInt)
  {
    int i1 = this.k.size();
    if ((paramInt < 0) || (paramInt >= i1)) {
      return null;
    }
    return (WeatherBean)this.j.get(paramInt);
  }
  
  public String b(WeatherBean paramWeatherBean)
  {
    if (paramWeatherBean != null)
    {
      if (paramWeatherBean.k.a(a) == -10000.0F) {
        return "--";
      }
      return Math.round(paramWeatherBean.k.a(a)) + "";
    }
    return null;
  }
  
  public void b(h paramh)
  {
    if (this.t.contains(paramh)) {
      this.t.remove(paramh);
    }
  }
  
  public boolean b()
  {
    return DateFormat.is24HourFormat(this.c);
  }
  
  public String c(WeatherBean paramWeatherBean)
  {
    paramWeatherBean = null;
    if (a == 1) {
      paramWeatherBean = "°C";
    }
    while (a != 2) {
      return paramWeatherBean;
    }
    return "°F";
  }
  
  public void c()
  {
    if (this.K) {}
    ArrayList localArrayList;
    do
    {
      int i2;
      do
      {
        return;
        i2 = this.j.size();
      } while (i2 < 1);
      localArrayList = new ArrayList();
      int i1 = 0;
      while (i1 < i2)
      {
        localObject = (WeatherBean)this.j.get(i1);
        if (localObject != null)
        {
          RequestBean localRequestBean = new RequestBean();
          localRequestBean.a(((WeatherBean)localObject).c(), ((WeatherBean)localObject).d(), ((WeatherBean)localObject).k.g());
          localArrayList.add(localRequestBean);
        }
        i1 += 1;
      }
    } while (localArrayList.isEmpty());
    Object localObject = new Intent("com.gau.go.launcherex.gowidget.weather.service.NotifyService");
    ((Intent)localObject).putExtra("notify_request", 22);
    ((Intent)localObject).putParcelableArrayListExtra("req_arg", localArrayList);
    this.c.startService((Intent)localObject);
  }
  
  public boolean c(int paramInt)
  {
    Object localObject = b(paramInt);
    if (localObject == null) {
      return true;
    }
    paramInt = ((WeatherBean)localObject).k.n();
    this.J = this.g.b(paramInt);
    String str = ((WeatherBean)localObject).k.j();
    localObject = ((WeatherBean)localObject).k.k();
    if (this.g.d()) {
      return r.a(str, (String)localObject, this.J);
    }
    return r.a(str, (String)localObject);
  }
  
  public String d(WeatherBean paramWeatherBean)
  {
    if (this.L == null) {
      this.L = this.c.getResources().getString(2131165882);
    }
    int i1 = paramWeatherBean.k.c();
    if (i1 == 55536) {
      return this.L;
    }
    return this.L + " : " + i1 + "%";
  }
  
  public void d()
  {
    if (this.K)
    {
      this.K = false;
      J();
    }
  }
  
  public boolean d(int paramInt)
  {
    if (this.q == null) {
      return false;
    }
    String str1 = this.q.k.j();
    String str2 = this.q.k.k();
    return r.a(paramInt, r.a(true, str1), r.a(false, str2));
  }
  
  public HourlyBean e(int paramInt)
  {
    paramInt = paramInt * 4 + this.C;
    if ((paramInt > 0) && (paramInt < this.l.size())) {
      return (HourlyBean)this.l.get(paramInt);
    }
    return null;
  }
  
  public String e(WeatherBean paramWeatherBean)
  {
    if (this.M == null) {
      this.M = this.c.getResources().getString(2131165341);
    }
    String str = null;
    if (a == 1) {
      str = "°C";
    }
    int i1;
    for (;;)
    {
      i1 = Math.round(paramWeatherBean.k.b(a));
      if (r.b(i1)) {
        break;
      }
      return "--";
      if (a == 2) {
        str = "°F";
      }
    }
    return this.M + i1 + str;
  }
  
  public void e()
  {
    this.c.unregisterReceiver(this.I);
    this.c.unregisterReceiver(this.F);
    this.m.unregisterContentObserver(this.v);
    this.g.b();
  }
  
  public String f(WeatherBean paramWeatherBean)
  {
    if (this.N == null) {
      this.N = this.c.getResources().getString(2131165833);
    }
    String str = null;
    if (a == 1) {
      str = "°C";
    }
    int i1;
    for (;;)
    {
      i1 = Math.round(paramWeatherBean.k.c(a));
      if (r.b(i1)) {
        break;
      }
      return "--";
      if (a == 2) {
        str = "°F";
      }
    }
    return this.N + i1 + str;
  }
  
  public void f()
  {
    int i1 = this.k.size();
    if (i1 < 2) {
      return;
    }
    this.i = ((this.i + 1) % i1);
    this.h = ((String)this.k.get(this.i));
    this.q = ((WeatherBean)this.j.get(this.i));
    E();
    w();
    G();
  }
  
  public int g()
  {
    int i1 = this.k.size();
    if (i1 < 2) {
      return this.i;
    }
    this.i = ((this.i + 1) % i1);
    this.h = ((String)this.k.get(this.i));
    this.q = ((WeatherBean)this.j.get(this.i));
    E();
    return this.i;
  }
  
  public String g(WeatherBean paramWeatherBean)
  {
    if (paramWeatherBean == null) {
      return null;
    }
    if (this.O == null) {
      this.O = this.c.getResources().getString(2131165880);
    }
    if (this.P == null) {
      this.P = this.c.getResources().getString(2131165343);
    }
    int i1 = this.o;
    String str = paramWeatherBean.k.b();
    if (!r.a(str)) {
      return "--";
    }
    float f1 = paramWeatherBean.k.a();
    if (!r.b(f1)) {
      return this.O + " : " + str;
    }
    if (i1 == 1) {
      paramWeatherBean = q.c(f1, 1) + " " + this.c.getResources().getString(2131165333);
    }
    for (;;)
    {
      return this.O + " : " + paramWeatherBean + " , " + str;
      if (i1 == 4) {
        paramWeatherBean = q.e(f1, 1) + " " + this.c.getResources().getString(2131165336);
      } else if (i1 == 3) {
        paramWeatherBean = q.d(f1, 1) + " " + this.c.getResources().getString(2131165335);
      } else if (i1 == 5) {
        paramWeatherBean = String.format(this.c.getResources().getString(2131165813), new Object[] { Integer.valueOf(q.a(f1)) });
      } else if (i1 == 6) {
        paramWeatherBean = q.f(f1, 1) + " " + this.c.getResources().getString(2131165338);
      } else {
        paramWeatherBean = f1 + " " + this.c.getResources().getString(2131165334);
      }
    }
  }
  
  public int h()
  {
    int i1 = this.k.size();
    if (i1 < 2) {
      return this.i;
    }
    this.i = ((this.i - 1 + i1) % i1);
    this.h = ((String)this.k.get(this.i));
    this.q = ((WeatherBean)this.j.get(this.i));
    E();
    return this.i;
  }
  
  public int i()
  {
    if (this.k == null) {
      return 0;
    }
    return this.k.size();
  }
  
  public int j()
  {
    return this.i;
  }
  
  public String k()
  {
    return this.h;
  }
  
  public int l()
  {
    return this.q.e();
  }
  
  public String m()
  {
    if ((this.q != null) && (this.j.size() > 0) && (this.q.d() != null)) {
      return this.q.d();
    }
    if ((!this.y) && (this.x))
    {
      if ((!this.z) && (this.A))
      {
        this.z = true;
        F();
      }
      if (this.z) {
        return this.c.getResources().getString(2131166458);
      }
      return this.c.getResources().getString(2131166457);
    }
    return this.c.getResources().getString(2131166455);
  }
  
  public List n()
  {
    if (this.q != null) {
      return this.q.g;
    }
    return null;
  }
  
  public boolean o()
  {
    if (this.q == null) {
      return true;
    }
    return r.a(this.q.k.j(), this.q.k.k());
  }
  
  public NowBean p()
  {
    if (this.q != null) {
      return this.q.k;
    }
    return null;
  }
  
  public void q()
  {
    if ((!L()) || (!this.g.d()) || (this.q == null))
    {
      this.s = K();
      return;
    }
    this.s = t();
  }
  
  public int r()
  {
    return this.s.hour;
  }
  
  public int s()
  {
    return this.s.minute;
  }
  
  public Time t()
  {
    if (this.q != null)
    {
      int i1 = this.q.k.n();
      return this.g.b(i1);
    }
    return this.g.c();
  }
  
  public int u()
  {
    return this.d;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/nextlauncher/widget/weatherwidget/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */