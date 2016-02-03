package com.gau.go.launcherex.gowidget.weather.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import com.gau.go.launcherex.gowidget.weather.model.b;
import com.gau.go.launcherex.gowidget.weather.util.f;
import com.gtp.a.a.a.a;
import com.jiubang.goweather.c.m;
import com.jiubang.goweather.c.p;

class ab
  implements p
{
  ab(aa paramaa, int paramInt1, int paramInt2) {}
  
  public void a()
  {
    aa.a(this.c, false);
    aa.a(this.c);
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 3)
    {
      aa.a(this.c, false);
      aa.a(this.c);
      return;
    }
    aa.a(this.c, this.a, this.b, 9);
  }
  
  public void a(Location paramLocation)
  {
    double d3 = 0.0D;
    Object localObject1 = aa.b(this.c).getSharedPreferences("myLocation", 0);
    Object localObject2 = ((SharedPreferences)localObject1).getString("lat", "");
    try
    {
      if (!"".equals(localObject2))
      {
        d1 = Double.parseDouble((String)localObject2);
        localObject1 = ((SharedPreferences)localObject1).getString("lng", "");
        d2 = d3;
      }
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      try
      {
        double d1;
        if (!"".equals(localObject1)) {
          d2 = Double.parseDouble((String)localObject1);
        }
        localObject1 = f.a(aa.b(this.c));
        localObject1 = ((f)localObject1).a(((f)localObject1).h());
        localObject2 = new Location("");
        ((Location)localObject2).setLatitude(d1);
        ((Location)localObject2).setLongitude(d2);
        if ((localObject1 != null) && (!com.jiubang.goweather.c.e.a((Location)localObject2, paramLocation)))
        {
          aa.a(this.c, false);
          aa.a(this.c);
          a.a().a("与上次定位位置接近，属于同一个城市", "location.txt");
          com.gtp.a.a.b.c.a("Location", "与上次定位位置接近，属于同一个城市");
          return;
          localNumberFormatException2 = localNumberFormatException2;
          localNumberFormatException2.printStackTrace();
          d1 = 0.0D;
        }
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        for (;;)
        {
          localNumberFormatException1.printStackTrace();
          double d2 = d3;
        }
        a.a().a("寻找新的定位城市", "location.txt");
        com.gtp.a.a.b.c.a("Location", "寻找新的定位城市");
        aa.c(this.c).a(paramLocation);
      }
    }
  }
  
  public void a(b paramb, Location paramLocation)
  {
    if ((paramb.a() == null) || (paramb.a().trim().length() == 0))
    {
      aa.a(this.c, false);
      aa.a(this.c);
      return;
    }
    Object localObject1 = com.gau.go.launcherex.gowidget.weather.c.c.a(aa.b(this.c));
    Object localObject2 = ((com.gau.go.launcherex.gowidget.weather.c.c)localObject1).f();
    localObject1 = ((com.gau.go.launcherex.gowidget.weather.c.c)localObject1).h();
    if (((com.gau.go.launcherex.gowidget.weather.c.e)localObject2).e())
    {
      aa.a(this.c, paramLocation, paramb);
      localObject2 = ((f)localObject1).h();
      if ((localObject2 == null) || (!((String)localObject2).equals(paramb.a()))) {
        break label187;
      }
    }
    label187:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        paramLocation = null;
        if (localObject2 != null) {
          paramLocation = ((f)localObject1).a((String)localObject2);
        }
        new ad(this.c).execute(new Object[] { paramb, paramLocation });
        return;
      }
      aa.a(this.c, false);
      aa.a(this.c);
      return;
      aa.a(this.c, false);
      aa.a(this.c);
      return;
    }
  }
  
  public void b(int paramInt) {}
  
  public void c(int paramInt)
  {
    aa.a(this.c, this.a, this.b, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/b/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */