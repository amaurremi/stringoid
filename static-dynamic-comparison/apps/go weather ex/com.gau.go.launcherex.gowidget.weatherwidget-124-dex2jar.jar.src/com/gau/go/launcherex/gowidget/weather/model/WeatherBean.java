package com.gau.go.launcherex.gowidget.weather.model;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.gau.go.launcherex.goweather.a.e;
import com.jiubang.goweather.a.a;
import com.jiubang.goweather.a.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class WeatherBean
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new v();
  String a = "";
  String b = "";
  String c = "";
  String d = "";
  String e = "";
  int f;
  public ArrayList g = new ArrayList();
  public ArrayList h = new ArrayList();
  public ArrayList i = new ArrayList();
  public ArrayList j = new ArrayList();
  public NowBean k;
  public Map l = new HashMap();
  private int m;
  private int n;
  
  public WeatherBean()
  {
    this.k = new NowBean();
  }
  
  private WeatherBean(Parcel paramParcel)
  {
    try
    {
      this.a = paramParcel.readString();
      this.b = paramParcel.readString();
      this.c = paramParcel.readString();
      this.m = paramParcel.readInt();
      this.f = paramParcel.readInt();
      this.g = new ArrayList();
      paramParcel.readList(this.g, ForecastBean.class.getClassLoader());
      this.h = new ArrayList();
      paramParcel.readList(this.h, HourlyBean.class.getClassLoader());
      this.i = new ArrayList();
      paramParcel.readList(this.i, PollenIndexBean.class.getClassLoader());
      this.j = new ArrayList();
      paramParcel.readList(this.j, AlarmBean.class.getClassLoader());
      this.k = ((NowBean)paramParcel.readParcelable(NowBean.class.getClassLoader()));
      return;
    }
    catch (Exception paramParcel)
    {
      this.g = new ArrayList();
      this.h = new ArrayList();
      this.i = new ArrayList();
      this.j = new ArrayList();
      this.k = new NowBean();
    }
  }
  
  public static c d(Cursor paramCursor)
  {
    int i2 = paramCursor.getColumnCount();
    String[] arrayOfString = paramCursor.getColumnNames();
    c localc = new c();
    int i1 = 0;
    if (i1 < i2)
    {
      String str = arrayOfString[i1];
      if (str.equals("alert_id")) {
        localc.c(paramCursor.getInt(i1));
      }
      label291:
      do
      {
        for (;;)
        {
          i1 += 1;
          break;
          if (str.equals("cityId"))
          {
            localc.g(paramCursor.getString(i1));
          }
          else if (str.equals("publish_time"))
          {
            localc.a(paramCursor.getString(i1));
          }
          else if (str.equals("exp_time"))
          {
            localc.b(paramCursor.getString(i1));
          }
          else if (str.equals("type"))
          {
            localc.c(paramCursor.getString(i1));
          }
          else if (str.equals("description"))
          {
            localc.d(paramCursor.getString(i1));
          }
          else if (str.equals("phenomena"))
          {
            localc.e(paramCursor.getString(i1));
          }
          else if (str.equals("level"))
          {
            localc.b(paramCursor.getInt(i1));
          }
          else if (str.equals("message"))
          {
            localc.f(paramCursor.getString(i1));
          }
          else
          {
            if (!str.equals("tz_offset")) {
              break label291;
            }
            localc.a(paramCursor.getInt(i1));
          }
        }
      } while (!str.equals("has_read"));
      if (paramCursor.getInt(i1) == 1) {}
      for (boolean bool = true;; bool = false)
      {
        localc.c(bool);
        break;
      }
    }
    return localc;
  }
  
  public WeatherBean a(a parama, String paramString)
  {
    int i3 = 0;
    if (this.k == null) {
      this.k = new NowBean();
    }
    this.b = paramString;
    this.a = parama.d();
    this.c = parama.c();
    paramString = parama.a();
    if (!TextUtils.isEmpty(paramString)) {
      this.d = paramString;
    }
    paramString = parama.b();
    if (!TextUtils.isEmpty(paramString)) {
      this.e = paramString;
    }
    this.k.a(parama);
    this.g.clear();
    int i2 = parama.q();
    int i1 = 0;
    Object localObject;
    while (i1 < i2)
    {
      paramString = parama.c(i1);
      if (paramString != null)
      {
        localObject = new ForecastBean();
        ((ForecastBean)localObject).a(paramString);
        this.g.add(localObject);
      }
      i1 += 1;
    }
    this.h.clear();
    i2 = parama.r();
    i1 = 0;
    while (i1 < i2)
    {
      paramString = parama.d(i1);
      if (paramString != null)
      {
        localObject = new HourlyBean();
        ((HourlyBean)localObject).a(paramString);
        this.h.add(localObject);
      }
      i1 += 1;
    }
    i();
    int i5 = parama.u();
    i1 = 0;
    while (i1 < i5)
    {
      paramString = parama.g(i1);
      if (paramString != null)
      {
        localObject = new PollenIndexBean();
        int i4 = parama.t();
        i2 = i4;
        if (i4 == 55536) {
          i2 = 0;
        }
        ((PollenIndexBean)localObject).a(paramString, i2);
        this.i.add(localObject);
      }
      i1 += 1;
    }
    i2 = parama.s();
    i1 = i3;
    while (i1 < i2)
    {
      paramString = parama.e(i1);
      i3 = paramString.i();
      localObject = new c();
      ((c)localObject).a(paramString);
      this.l.put(Integer.valueOf(i3), localObject);
      i1 += 1;
    }
    return this;
  }
  
  public String a()
  {
    return this.d;
  }
  
  public void a(int paramInt)
  {
    this.m = paramInt;
  }
  
  public void a(Cursor paramCursor)
  {
    int i2 = paramCursor.getColumnCount();
    String[] arrayOfString = paramCursor.getColumnNames();
    int i1 = 0;
    if (i1 < i2)
    {
      String str = arrayOfString[i1];
      if (str.equals("cityName")) {
        e(paramCursor.getString(i1));
      }
      for (;;)
      {
        i1 += 1;
        break;
        if (str.equals("cityId")) {
          c(paramCursor.getString(i1));
        } else if (str.equals("nowDesp")) {
          this.k.c(paramCursor.getString(i1));
        } else if (str.equals("nowTempValue")) {
          this.k.b(paramCursor.getFloat(i1));
        } else if (str.equals("lowTempValue")) {
          this.k.d(paramCursor.getFloat(i1));
        } else if (str.equals("highTempValue")) {
          this.k.c(paramCursor.getFloat(i1));
        } else if (str.equals("windType")) {
          this.k.g(paramCursor.getInt(i1));
        } else if (str.equals("windDirection")) {
          this.k.a(paramCursor.getString(i1));
        } else if (str.equals("windStrengthValue")) {
          this.k.a(paramCursor.getFloat(i1));
        } else if (str.equals("humidityValue")) {
          this.k.d(paramCursor.getInt(i1));
        } else if (str.equals("type")) {
          this.k.e(paramCursor.getInt(i1));
        } else if (str.equals("updateTime")) {
          this.k.a(paramCursor.getLong(i1));
        } else if (str.equals("visibilityValue")) {
          this.k.e(paramCursor.getFloat(i1));
        } else if (str.equals("barometerValue")) {
          this.k.f(paramCursor.getFloat(i1));
        } else if (str.equals("dewpointValue")) {
          this.k.g(paramCursor.getFloat(i1));
        } else if (str.equals("uvIndexValue")) {
          this.k.h(paramCursor.getFloat(i1));
        } else if (str.equals("sunrise")) {
          this.k.d(paramCursor.getString(i1));
        } else if (str.equals("sunset")) {
          this.k.e(paramCursor.getString(i1));
        } else if (str.equals("sequence")) {
          e(paramCursor.getInt(i1));
        } else if (str.equals("city_my_location")) {
          a(paramCursor.getInt(i1));
        } else if (str.equals("tz_offset")) {
          this.k.h(paramCursor.getInt(i1));
        } else if (str.equals("feelslikeValue")) {
          this.k.j(paramCursor.getFloat(i1));
        } else if (str.equals("pop")) {
          this.k.i(paramCursor.getInt(i1));
        } else if (str.equals("state")) {
          a(paramCursor.getString(i1));
        } else if (str.equals("country")) {
          b(paramCursor.getString(i1));
        } else if (str.equals("_id")) {
          b(paramCursor.getInt(i1));
        } else if (str.equals("oldCityId")) {
          d(paramCursor.getString(i1));
        } else if (str.equals("timestamp")) {
          this.k.b(paramCursor.getLong(i1));
        } else if (str.equals("rainFall")) {
          this.k.i(paramCursor.getFloat(i1));
        } else if (str.equals("aqi")) {
          this.k.k(paramCursor.getInt(i1));
        } else if (str.equals("qualityType")) {
          this.k.l(paramCursor.getInt(i1));
        } else if (str.equals("pm25")) {
          this.k.m(paramCursor.getInt(i1));
        } else if (str.equals("pm10")) {
          this.k.n(paramCursor.getInt(i1));
        } else if (str.equals("so2")) {
          this.k.o(paramCursor.getInt(i1));
        } else if (str.equals("no2")) {
          this.k.p(paramCursor.getInt(i1));
        } else if (str.equals("latitude")) {
          this.k.l(paramCursor.getFloat(i1));
        } else if (str.equals("longitude")) {
          this.k.k(paramCursor.getFloat(i1));
        } else if (str.equals("hasRadar")) {
          this.k.q(paramCursor.getInt(i1));
        } else if (str.equals("hasSatellite")) {
          this.k.r(paramCursor.getInt(i1));
        } else if (str.equals("northeast")) {
          this.k.a(e.a(paramCursor.getString(i1)));
        } else if (str.equals("southwest")) {
          this.k.b(e.a(paramCursor.getString(i1)));
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    this.d = paramString;
  }
  
  public String b()
  {
    return this.e;
  }
  
  public void b(int paramInt)
  {
    this.n = paramInt;
  }
  
  public void b(Cursor paramCursor)
  {
    int i2 = paramCursor.getColumnCount();
    String[] arrayOfString = paramCursor.getColumnNames();
    HourlyBean localHourlyBean = k();
    int i1 = 0;
    if (i1 < i2)
    {
      String str = arrayOfString[i1];
      if (str.equals("date_long")) {
        localHourlyBean.a(paramCursor.getString(i1));
      }
      for (;;)
      {
        i1 += 1;
        break;
        if (str.equals("hour")) {
          localHourlyBean.a(paramCursor.getInt(i1));
        } else if (str.equals("tempValue")) {
          localHourlyBean.a(paramCursor.getFloat(i1));
        } else if (str.equals("type")) {
          localHourlyBean.c(paramCursor.getInt(i1));
        } else if (str.equals("windType")) {
          localHourlyBean.d(paramCursor.getInt(i1));
        } else if (str.equals("windStrengthValue")) {
          localHourlyBean.b(paramCursor.getFloat(i1));
        } else if (str.equals("status")) {
          localHourlyBean.d(paramCursor.getString(i1));
        } else if (str.equals("windDirection")) {
          localHourlyBean.b(paramCursor.getString(i1));
        } else if (str.equals("pop")) {
          localHourlyBean.e(paramCursor.getInt(i1));
        }
      }
    }
  }
  
  public void b(String paramString)
  {
    this.e = paramString;
  }
  
  public String c()
  {
    return this.a;
  }
  
  public void c(Cursor paramCursor)
  {
    int i2 = paramCursor.getColumnCount();
    String[] arrayOfString = paramCursor.getColumnNames();
    ForecastBean localForecastBean = l();
    int i1 = 0;
    if (i1 < i2)
    {
      String str = arrayOfString[i1];
      if (str.equals("lowTempValue")) {
        localForecastBean.a(paramCursor.getFloat(i1));
      }
      for (;;)
      {
        i1 += 1;
        break;
        if (str.equals("highTempValue")) {
          localForecastBean.b(paramCursor.getFloat(i1));
        } else if (str.equals("weekDate")) {
          localForecastBean.f(paramCursor.getString(i1));
        } else if (str.equals("type")) {
          localForecastBean.c(paramCursor.getInt(i1));
        } else if (str.equals("windType")) {
          localForecastBean.d(paramCursor.getInt(i1));
        } else if (str.equals("status")) {
          localForecastBean.d(paramCursor.getString(i1));
        } else if (str.equals("windDir")) {
          localForecastBean.g(paramCursor.getString(i1));
        } else if (str.equals("windStrengthValue")) {
          localForecastBean.c(paramCursor.getFloat(i1));
        } else if (str.equals("status_day")) {
          localForecastBean.a(paramCursor.getString(i1));
        } else if (str.equals("status_night")) {
          localForecastBean.b(paramCursor.getString(i1));
        } else if (str.equals("date_long")) {
          localForecastBean.c(paramCursor.getString(i1));
        } else if (str.equals("pop")) {
          localForecastBean.e(paramCursor.getInt(i1));
        }
      }
    }
  }
  
  public void c(String paramString)
  {
    this.a = paramString;
  }
  
  public boolean c(int paramInt)
  {
    Iterator localIterator = this.l.entrySet().iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      if (((c)((Map.Entry)localIterator.next()).getValue()).k() != paramInt) {
        break label57;
      }
      bool = true;
    }
    label57:
    for (;;)
    {
      break;
      return bool;
    }
  }
  
  public c d(int paramInt)
  {
    return (c)this.l.get(Integer.valueOf(paramInt));
  }
  
  public String d()
  {
    return this.c;
  }
  
  public void d(String paramString)
  {
    this.b = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int e()
  {
    return this.m;
  }
  
  public void e(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void e(Cursor paramCursor)
  {
    int i2 = paramCursor.getColumnCount();
    String[] arrayOfString = paramCursor.getColumnNames();
    PollenIndexBean localPollenIndexBean = m();
    int i1 = 0;
    if (i1 < i2)
    {
      String str = arrayOfString[i1];
      if (str.equals("date_time")) {
        localPollenIndexBean.a(paramCursor.getLong(i1), this.k.n());
      }
      for (;;)
      {
        i1 += 1;
        break;
        if (str.equals("pollen_index")) {
          localPollenIndexBean.a(paramCursor.getFloat(i1));
        }
      }
    }
  }
  
  public void e(String paramString)
  {
    this.c = paramString;
  }
  
  public void f()
  {
    this.k.e = 1;
    this.k.f = "--";
    this.k.g = -10000L;
    this.k.k = -10000.0F;
    this.k.l = -10000.0F;
    this.k.j = -10000.0F;
    this.k.m = "--";
    this.k.n = "--";
    this.k.o = -10000.0F;
    this.k.d = 55536;
    this.k.a = -10000.0F;
    this.k.b = -10000.0F;
    this.k.c = -10000.0F;
    this.k.r = -10000.0F;
    this.k.p = "--";
    this.k.q = "--";
    this.k.s = 55536;
  }
  
  public void f(Cursor paramCursor)
  {
    int i2 = paramCursor.getColumnCount();
    String[] arrayOfString = paramCursor.getColumnNames();
    int i1 = 0;
    if (i1 < i2)
    {
      m localm = new m();
      Object localObject = arrayOfString[i1];
      long l1;
      if (((String)localObject).equals("date_time")) {
        l1 = paramCursor.getLong(i1);
      }
      for (;;)
      {
        localObject = this.i.iterator();
        while (((Iterator)localObject).hasNext())
        {
          PollenIndexBean localPollenIndexBean = (PollenIndexBean)((Iterator)localObject).next();
          if (localPollenIndexBean.a() == l1) {
            localPollenIndexBean.a(localm);
          }
        }
        i1 += 1;
        break;
        if (((String)localObject).equals("name"))
        {
          localm.a(paramCursor.getString(i1));
          l1 = 0L;
        }
        else if (((String)localObject).equals("type"))
        {
          localm.a(paramCursor.getInt(i1));
          l1 = 0L;
        }
        else
        {
          if (((String)localObject).equals("url")) {
            localm.b(paramCursor.getString(i1));
          }
          l1 = 0L;
        }
      }
    }
  }
  
  public void g()
  {
    this.g.clear();
  }
  
  public void h()
  {
    this.h.clear();
  }
  
  public void i()
  {
    this.i.clear();
  }
  
  public void j()
  {
    this.j.clear();
  }
  
  public HourlyBean k()
  {
    HourlyBean localHourlyBean = new HourlyBean();
    this.h.add(localHourlyBean);
    return localHourlyBean;
  }
  
  public ForecastBean l()
  {
    ForecastBean localForecastBean = new ForecastBean();
    this.g.add(localForecastBean);
    return localForecastBean;
  }
  
  public PollenIndexBean m()
  {
    PollenIndexBean localPollenIndexBean = new PollenIndexBean();
    this.i.add(localPollenIndexBean);
    return localPollenIndexBean;
  }
  
  public Map n()
  {
    return this.l;
  }
  
  public int o()
  {
    return this.l.size();
  }
  
  public boolean p()
  {
    Iterator localIterator = this.l.entrySet().iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      if (((c)((Map.Entry)localIterator.next()).getValue()).b()) {
        break label56;
      }
      bool = true;
    }
    label56:
    for (;;)
    {
      break;
      return bool;
    }
  }
  
  public int q()
  {
    return this.f;
  }
  
  public boolean r()
  {
    return (this.k.F != 0) || (this.k.G != 0);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeInt(this.m);
    paramParcel.writeInt(this.f);
    paramParcel.writeList(this.g);
    paramParcel.writeList(this.h);
    paramParcel.writeList(this.i);
    paramParcel.writeList(this.j);
    paramParcel.writeParcelable(this.k, 0);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/model/WeatherBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */