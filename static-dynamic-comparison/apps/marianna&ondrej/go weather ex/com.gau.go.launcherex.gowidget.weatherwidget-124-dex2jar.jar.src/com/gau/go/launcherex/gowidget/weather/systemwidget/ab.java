package com.gau.go.launcherex.gowidget.weather.systemwidget;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import com.gau.go.launcherex.gowidget.weather.model.ForecastBean;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.gau.go.launcherex.gowidget.weather.util.v;
import com.gau.go.launcherex.gowidget.weather.util.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ab
{
  private static volatile ab b;
  public boolean a = false;
  private ad c;
  private ArrayList d = new ArrayList();
  private Context e;
  private ac f;
  private boolean g = false;
  private ArrayList h = new ArrayList();
  
  private ab(Context paramContext)
  {
    this.e = paramContext.getApplicationContext();
    this.c = new ad(this.e.getContentResolver(), this);
    this.f = new ac(this);
    paramContext = new IntentFilter();
    paramContext.addAction("com.gau.go.launcherex.gowidget.weatherwidget.goweather.ACTION_UPDATE_DATA");
    paramContext.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_ADD_CITY");
    paramContext.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DELETE_CITY");
    paramContext.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_RELOAD_DATA");
    paramContext.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_CONVERT_INDEX_STATE");
    paramContext.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_LOCATION");
    this.e.registerReceiver(this.f, paramContext);
    c();
  }
  
  private WeatherBean a(String paramString)
  {
    if (this.d.isEmpty()) {
      return null;
    }
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      WeatherBean localWeatherBean = (WeatherBean)localIterator.next();
      if (localWeatherBean.c().equals(paramString)) {
        return localWeatherBean;
      }
    }
    return null;
  }
  
  public static ab a(Context paramContext)
  {
    try
    {
      if (b == null) {
        b = new ab(paramContext);
      }
      paramContext = b;
      return paramContext;
    }
    finally {}
  }
  
  private void a(Context paramContext, Intent paramIntent)
  {
    paramContext = new v().a(paramIntent);
    if (paramContext != null) {}
    switch (paramContext.a)
    {
    case 2: 
    case 11: 
    default: 
      return;
    }
    this.c.startQuery(1, null, WeatherContentProvider.a, new String[] { "cityName", "cityId", "nowTempValue", "highTempValue", "lowTempValue", "windDirection", "windStrength", "windStrengthValue", "nowDesp", "type", "city_my_location", "sunrise", "sunset", "tz_offset", "updateTime", "sequence" }, null, null, "sequence");
  }
  
  private void a(Cursor paramCursor)
  {
    d(paramCursor);
  }
  
  private void a(Cursor paramCursor, WeatherBean paramWeatherBean)
  {
    int j = paramCursor.getColumnCount();
    int i = 0;
    if (i < j)
    {
      String str = paramCursor.getColumnName(i);
      if (str.equals("cityName")) {
        paramWeatherBean.e(paramCursor.getString(i));
      }
      for (;;)
      {
        i += 1;
        break;
        if (str.equals("cityId")) {
          paramWeatherBean.c(paramCursor.getString(i));
        } else if (str.equals("nowDesp")) {
          paramWeatherBean.k.c(paramCursor.getString(i));
        } else if (str.equals("nowTempValue")) {
          paramWeatherBean.k.b(paramCursor.getFloat(i));
        } else if (str.equals("lowTempValue")) {
          paramWeatherBean.k.d(paramCursor.getFloat(i));
        } else if (str.equals("highTempValue")) {
          paramWeatherBean.k.c(paramCursor.getFloat(i));
        } else if (str.equals("windDirection")) {
          paramWeatherBean.k.a(paramCursor.getString(i));
        } else if (str.equals("windStrengthValue")) {
          paramWeatherBean.k.a(paramCursor.getFloat(i));
        } else if (str.equals("type")) {
          paramWeatherBean.k.e(paramCursor.getInt(i));
        } else if (str.equals("city_my_location")) {
          paramWeatherBean.a(paramCursor.getInt(i));
        } else if (str.equals("sunrise")) {
          paramWeatherBean.k.d(paramCursor.getString(i));
        } else if (str.equals("sunset")) {
          paramWeatherBean.k.e(paramCursor.getString(i));
        } else if (str.equals("tz_offset")) {
          paramWeatherBean.k.h(paramCursor.getInt(i));
        } else if (str.equals("updateTime")) {
          paramWeatherBean.k.a(paramCursor.getLong(i));
        } else if (str.equals("timestamp")) {
          paramWeatherBean.k.b(paramCursor.getLong(i));
        } else if (str.equals("sequence")) {
          paramWeatherBean.e(paramCursor.getInt(i));
        }
      }
    }
  }
  
  public static void b()
  {
    if (b != null)
    {
      b.i();
      b = null;
    }
  }
  
  private void b(Cursor paramCursor)
  {
    Object localObject1 = "";
    Object localObject4 = "";
    for (;;)
    {
      int j;
      Object localObject5;
      try
      {
        if (paramCursor.getCount() > 0)
        {
          paramCursor.moveToFirst();
          int i = -1;
          int k = paramCursor.getColumnCount();
          j = 0;
          if (j < k)
          {
            localObject5 = paramCursor.getColumnName(j);
            if (((String)localObject5).endsWith("cityId"))
            {
              localObject5 = paramCursor.getString(j);
              localObject1 = localObject4;
              localObject4 = localObject5;
              break label306;
            }
            if (((String)localObject5).endsWith("cityName"))
            {
              localObject5 = paramCursor.getString(j);
              localObject4 = localObject1;
              localObject1 = localObject5;
              break label306;
            }
            if (!((String)localObject5).endsWith("sequence")) {
              break label294;
            }
            i = paramCursor.getInt(j);
            localObject5 = localObject1;
            localObject1 = localObject4;
            localObject4 = localObject5;
            break label306;
          }
          localObject5 = this.d.iterator();
          if (!((Iterator)localObject5).hasNext()) {
            break label289;
          }
          if (!((WeatherBean)((Iterator)localObject5).next()).c().equals(localObject1)) {
            continue;
          }
          j = 1;
          if (j != 0) {
            continue;
          }
          localObject5 = new WeatherBean();
          ((WeatherBean)localObject5).c((String)localObject1);
          ((WeatherBean)localObject5).e((String)localObject4);
          if (i != -1) {
            ((WeatherBean)localObject5).e(i);
          }
          ((WeatherBean)localObject5).a(1);
          ((WeatherBean)localObject5).g();
          this.d.add(localObject5);
        }
      }
      catch (Exception localException)
      {
        boolean bool;
        localException.printStackTrace();
        continue;
      }
      finally
      {
        paramCursor.close();
      }
      paramCursor.close();
      return;
      bool = paramCursor.moveToNext();
      if (!bool)
      {
        continue;
        label289:
        j = 0;
        continue;
        label294:
        localObject5 = localObject4;
        localObject4 = localObject2;
        Object localObject3 = localObject5;
        label306:
        j += 1;
        localObject5 = localObject4;
        localObject4 = localObject3;
        localObject3 = localObject5;
      }
    }
  }
  
  private void c()
  {
    if (!this.g)
    {
      this.g = true;
      this.c.startQuery(1, null, WeatherContentProvider.a, new String[] { "cityName", "cityId", "nowTempValue", "highTempValue", "lowTempValue", "windDirection", "windStrength", "windStrengthValue", "nowDesp", "type", "city_my_location", "sunrise", "sunset", "tz_offset", "updateTime", "sequence" }, null, null, "sequence");
    }
  }
  
  private void c(Cursor paramCursor)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      int i;
      try
      {
        if (paramCursor.getCount() > 0)
        {
          paramCursor.moveToFirst();
          int j = paramCursor.getColumnCount();
          i = 0;
          if (i < j)
          {
            if (!paramCursor.getColumnName(i).endsWith("cityId")) {
              break label377;
            }
            localArrayList.add(paramCursor.getString(i));
            break label377;
          }
          boolean bool = paramCursor.moveToNext();
          if (bool) {
            continue;
          }
        }
      }
      catch (Exception localException)
      {
        Iterator localIterator;
        String str2;
        localException.printStackTrace();
        continue;
      }
      finally
      {
        paramCursor.close();
      }
      paramCursor.close();
      paramCursor = new ArrayList();
      localIterator = this.d.iterator();
      Object localObject3;
      Object localObject4;
      if (localIterator.hasNext())
      {
        localObject3 = (WeatherBean)localIterator.next();
        localObject4 = localArrayList.iterator();
        i = 0;
        if (((Iterator)localObject4).hasNext())
        {
          str2 = (String)((Iterator)localObject4).next();
          if (((WeatherBean)localObject3).c().equals(str2)) {
            i = 1;
          }
        }
        else
        {
          if (i != 0) {
            break label375;
          }
          paramCursor.add(((WeatherBean)localObject3).c());
        }
      }
      else
      {
        Object localObject2 = new ArrayList();
        paramCursor = paramCursor.iterator();
        while (paramCursor.hasNext())
        {
          String str1 = (String)paramCursor.next();
          localObject3 = this.d.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (WeatherBean)((Iterator)localObject3).next();
            if (((WeatherBean)localObject4).c().equals(str1)) {
              ((List)localObject2).add(localObject4);
            }
          }
        }
        paramCursor = ((List)localObject2).iterator();
        while (paramCursor.hasNext())
        {
          localObject2 = (WeatherBean)paramCursor.next();
          if (((WeatherBean)localObject2).e() == 3) {
            ((WeatherBean)localObject2).a(2);
          } else {
            this.d.remove(localObject2);
          }
        }
        return;
      }
      continue;
      label375:
      continue;
      label377:
      i += 1;
    }
  }
  
  private void d()
  {
    this.c.startQuery(2, null, WeatherContentProvider.b, new String[] { "cityId", "weekDate", "date", "lowTempValue", "highTempValue", "type", "date_long" }, null, null, "cityId");
  }
  
  private void d(Cursor paramCursor)
  {
    if (paramCursor == null) {
      return;
    }
    for (;;)
    {
      try
      {
        if (paramCursor.getCount() > 0)
        {
          this.d.clear();
          paramCursor.moveToFirst();
          WeatherBean localWeatherBean = new WeatherBean();
          a(paramCursor, localWeatherBean);
          localWeatherBean.g();
          this.d.add(localWeatherBean);
          boolean bool = paramCursor.moveToNext();
          if (bool) {
            continue;
          }
        }
      }
      catch (Exception localException)
      {
        localException = localException;
        localException.printStackTrace();
        try
        {
          paramCursor.close();
          return;
        }
        catch (Exception paramCursor) {}
        continue;
      }
      finally {}
      try
      {
        paramCursor.close();
        return;
      }
      catch (Exception paramCursor)
      {
        paramCursor.printStackTrace();
        return;
      }
    }
    try
    {
      paramCursor.close();
      throw ((Throwable)localObject);
    }
    catch (Exception paramCursor)
    {
      for (;;)
      {
        paramCursor.printStackTrace();
      }
    }
  }
  
  private void e()
  {
    this.c.startQuery(3, null, WeatherContentProvider.a, new String[] { "cityName", "cityId", "sequence" }, null, null, "sequence");
  }
  
  private void e(Cursor paramCursor)
  {
    if (paramCursor == null) {
      return;
    }
    for (;;)
    {
      WeatherBean localWeatherBean;
      ForecastBean localForecastBean;
      int i;
      try
      {
        if (paramCursor.getCount() > 0)
        {
          int j = paramCursor.getColumnCount();
          String[] arrayOfString = paramCursor.getColumnNames();
          paramCursor.moveToFirst();
          localWeatherBean = a(paramCursor.getString(paramCursor.getColumnIndex("cityId")));
          localForecastBean = new ForecastBean();
          i = 0;
          if (i < j)
          {
            if (arrayOfString[i].equals("lowTempValue"))
            {
              localForecastBean.a(paramCursor.getFloat(i));
              break label461;
            }
            if (arrayOfString[i].equals("highTempValue"))
            {
              localForecastBean.b(paramCursor.getFloat(i));
              break label461;
            }
          }
        }
      }
      catch (Exception localException)
      {
        localException = localException;
        localException.printStackTrace();
        try
        {
          paramCursor.close();
          return;
        }
        catch (Exception paramCursor) {}
        paramCursor.printStackTrace();
        return;
        if (localException[i].equals("weekDate"))
        {
          localForecastBean.f(paramCursor.getString(i));
          break label461;
        }
      }
      finally {}
      try
      {
        paramCursor.close();
        throw ((Throwable)localObject);
        if (localObject[i].equals("date"))
        {
          localForecastBean.e(paramCursor.getString(i));
        }
        else if (localObject[i].equals("type"))
        {
          localForecastBean.c(paramCursor.getInt(i));
        }
        else if (localObject[i].equals("date_long"))
        {
          localForecastBean.c(paramCursor.getString(i));
        }
        else if (localObject[i].equals("windType"))
        {
          localForecastBean.d(paramCursor.getInt(i));
        }
        else if (localObject[i].equals("status"))
        {
          localForecastBean.d(paramCursor.getString(i));
        }
        else if (localObject[i].equals("windDir"))
        {
          localForecastBean.g(paramCursor.getString(i));
        }
        else if (localObject[i].equals("windStrengthValue"))
        {
          localForecastBean.c(paramCursor.getInt(i));
          break label461;
          if ((localWeatherBean != null) && (localForecastBean.e() != 55536) && (localForecastBean.f() != 55536) && (localForecastBean.g() != 55536)) {
            localWeatherBean.g.add(localForecastBean);
          }
          boolean bool = paramCursor.moveToNext();
          if (bool) {
            continue;
          }
          try
          {
            paramCursor.close();
            return;
          }
          catch (Exception paramCursor) {}
        }
      }
      catch (Exception paramCursor)
      {
        for (;;)
        {
          paramCursor.printStackTrace();
        }
      }
      label461:
      i += 1;
    }
  }
  
  private void f()
  {
    this.c.startQuery(4, null, WeatherContentProvider.a, new String[] { "cityId" }, null, null, "sequence");
  }
  
  private void g()
  {
    this.c.startQuery(5, null, WeatherContentProvider.a, new String[] { "cityName", "cityId", "nowTempValue", "highTempValue", "windDirection", "windStrength", "windStrengthValue", "lowTempValue", "nowDesp", "type", "city_my_location", "sunrise", "sunset", "tz_offset", "updateTime", "sequence" }, null, null, "sequence");
  }
  
  private void h()
  {
    Iterator localIterator = new ArrayList(this.h).iterator();
    while (localIterator.hasNext()) {
      ((ae)localIterator.next()).a(a());
    }
  }
  
  private void i()
  {
    this.e.unregisterReceiver(this.f);
    this.h.clear();
    this.d.clear();
    this.g = false;
    this.a = false;
  }
  
  public ArrayList a()
  {
    return this.d;
  }
  
  public void a(ae paramae)
  {
    if ((paramae != null) && (!this.h.contains(paramae))) {
      this.h.add(paramae);
    }
  }
  
  public void b(ae paramae)
  {
    this.h.remove(paramae);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/systemwidget/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */