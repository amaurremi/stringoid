package com.go.weatherex.h;

import android.content.Context;
import android.text.format.Time;
import com.gau.go.launcherex.gowidget.weather.c.c;
import com.gau.go.launcherex.gowidget.weather.c.g;
import com.gau.go.launcherex.gowidget.weather.model.ForecastBean;
import com.gau.go.launcherex.gowidget.weather.model.HourlyBean;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.util.r;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class a
{
  public static ArrayList a(Context paramContext, String paramString)
  {
    boolean bool = false;
    Object localObject1 = new ArrayList();
    Object localObject2 = c.a(paramContext);
    paramString = ((c)localObject2).h().a(paramString);
    paramContext = (Context)localObject1;
    if (paramString != null)
    {
      paramContext = (Context)localObject1;
      if (!paramString.h.isEmpty())
      {
        localObject1 = ((c)localObject2).e();
        localObject2 = ((c)localObject2).g();
        paramContext = (ArrayList)paramString.h.clone();
        a(paramContext);
        paramString = ((g)localObject2).b(paramString.k.n());
        paramString.minute = 0;
        paramString.second = 0;
        a(paramContext, paramString);
        if (!((com.gau.go.launcherex.gowidget.weather.d.f)localObject1).b()) {
          bool = true;
        }
        a(bool, paramContext);
      }
    }
    return paramContext;
  }
  
  private static void a(ArrayList paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      HourlyBean localHourlyBean = (HourlyBean)paramArrayList.next();
      if ((localHourlyBean.a() == 55536) || (localHourlyBean.b() == 55536) || (localHourlyBean.c() == 55536) || (localHourlyBean.d() == 55536)) {
        paramArrayList.remove();
      }
    }
  }
  
  private static void a(ArrayList paramArrayList, Time paramTime)
  {
    Time localTime = new Time();
    int k = paramArrayList.size();
    int i;
    if (k > 24)
    {
      i = 0;
      if (i >= k) {
        break label119;
      }
      HourlyBean localHourlyBean = (HourlyBean)paramArrayList.get(i);
      localTime.set(0, 0, localHourlyBean.d(), localHourlyBean.c(), localHourlyBean.b() - 1, localHourlyBean.a());
      if (Time.compare(localTime, paramTime) < 0) {
        break label112;
      }
    }
    for (;;)
    {
      int j;
      if (i != -1)
      {
        j = i;
        if (k - i >= 24) {}
      }
      else
      {
        j = k - 24;
      }
      paramArrayList.subList(0, j).clear();
      return;
      label112:
      i += 1;
      break;
      label119:
      i = -1;
    }
  }
  
  private static void a(boolean paramBoolean, ArrayList paramArrayList)
  {
    int k = 0;
    int j = 6;
    int n = paramArrayList.size();
    if (paramBoolean)
    {
      ArrayList localArrayList = (ArrayList)paramArrayList.clone();
      paramArrayList.clear();
      int i;
      if (n >= 24) {
        i = 4;
      }
      for (;;)
      {
        int m = 0;
        while ((m < n) && (k < j))
        {
          paramArrayList.add(localArrayList.get(m));
          m += i;
          k += 1;
        }
        if ((n > 6) && (n < 24))
        {
          i = n / 6;
        }
        else
        {
          i = 1;
          j = n;
        }
      }
    }
    if (n > 24)
    {
      if (n == 25) {
        paramArrayList.remove(24);
      }
    }
    else {
      return;
    }
    paramArrayList.subList(24, n - 1).clear();
  }
  
  public static boolean a(int paramInt1, int paramInt2, int paramInt3, Time paramTime)
  {
    return new Date(paramTime.year, paramTime.month, paramTime.monthDay).before(new Date(paramInt1, paramInt2 - 1, paramInt3));
  }
  
  public static boolean a(WeatherBean paramWeatherBean)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramWeatherBean != null)
    {
      bool1 = bool2;
      if (r.b(paramWeatherBean.k.a(0))) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static ArrayList b(Context paramContext, String paramString)
  {
    Object localObject1 = c.a(paramContext);
    Object localObject2 = ((c)localObject1).h().a(paramString);
    paramContext = new ArrayList();
    if ((localObject2 == null) || (((WeatherBean)localObject2).g.isEmpty())) {
      return paramContext;
    }
    boolean bool = ((c)localObject1).e().b();
    paramString = ((c)localObject1).g().c(((WeatherBean)localObject2).k.n());
    localObject1 = ((ArrayList)((WeatherBean)localObject2).g.clone()).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ForecastBean)((Iterator)localObject1).next();
      if ((localObject2 != null) && (((ForecastBean)localObject2).e() != 55536) && (((ForecastBean)localObject2).f() != 55536) && (((ForecastBean)localObject2).g() != 55536)) {
        paramContext.add(localObject2);
      }
    }
    int i;
    int k;
    int j;
    if (!bool)
    {
      i = 6;
      k = paramContext.size();
      if (k > i) {
        j = 0;
      }
    }
    else
    {
      for (;;)
      {
        localObject1 = (ForecastBean)paramContext.get(0);
        if ((j + i == k) || (r.a(((ForecastBean)localObject1).e(), ((ForecastBean)localObject1).f(), ((ForecastBean)localObject1).g(), paramString)) || (a(((ForecastBean)localObject1).e(), ((ForecastBean)localObject1).f(), ((ForecastBean)localObject1).g(), paramString)))
        {
          while ((paramContext.size() > i) && (!bool)) {
            paramContext.remove(i);
          }
          i = 10;
          break;
        }
        paramContext.remove(0);
        j += 1;
      }
    }
    return paramContext;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/h/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */