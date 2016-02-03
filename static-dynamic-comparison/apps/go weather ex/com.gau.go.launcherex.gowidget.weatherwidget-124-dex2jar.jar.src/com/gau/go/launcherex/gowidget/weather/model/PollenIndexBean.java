package com.gau.go.launcherex.gowidget.weather.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.format.Time;
import com.jiubang.goweather.a.f;
import com.jiubang.goweather.a.g;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

public class PollenIndexBean
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new l();
  private long a = -10000L;
  private int b = 55536;
  private int c = 55536;
  private int d = 55536;
  private int e = 55536;
  private float f = -10000.0F;
  private List g = null;
  
  public PollenIndexBean()
  {
    this.g = new ArrayList();
  }
  
  private PollenIndexBean(Parcel paramParcel)
  {
    this.a = paramParcel.readLong();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readInt();
    this.e = paramParcel.readInt();
    this.f = paramParcel.readFloat();
    this.g = new ArrayList();
    paramParcel.readList(this.g, m.class.getClassLoader());
  }
  
  public long a()
  {
    return this.a;
  }
  
  public void a(float paramFloat)
  {
    this.f = paramFloat;
  }
  
  public void a(long paramLong, int paramInt)
  {
    Time localTime = new Time();
    if (paramInt != 55536)
    {
      String[] arrayOfString = TimeZone.getAvailableIDs(paramInt);
      if (arrayOfString.length > 0) {
        localTime.switchTimezone(arrayOfString[0]);
      }
    }
    this.a = (paramLong - localTime.gmtoff + paramInt);
    localTime.set(this.a);
    this.b = localTime.year;
    this.c = localTime.month;
    this.d = localTime.monthDay;
    this.e = localTime.weekDay;
  }
  
  public void a(m paramm)
  {
    if (this.g == null) {
      this.g = new ArrayList();
    }
    this.g.add(paramm);
  }
  
  public void a(f paramf, int paramInt)
  {
    int i = 0;
    Object localObject = new Time();
    if (paramInt != 55536)
    {
      String[] arrayOfString = TimeZone.getAvailableIDs(paramInt);
      if (arrayOfString.length > 0) {
        ((Time)localObject).switchTimezone(arrayOfString[0]);
      }
    }
    this.a = paramf.a;
    ((Time)localObject).set(this.a);
    this.b = ((Time)localObject).year;
    this.c = ((Time)localObject).month;
    this.d = ((Time)localObject).monthDay;
    this.e = ((Time)localObject).weekDay;
    this.f = paramf.b;
    int j = paramf.a();
    paramInt = i;
    while (paramInt < j)
    {
      localObject = paramf.a(paramInt);
      this.g.add(new m(((g)localObject).a, ((g)localObject).b, ((g)localObject).c));
      paramInt += 1;
    }
  }
  
  public int b()
  {
    return this.b;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public int d()
  {
    return this.d;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int e()
  {
    return this.e;
  }
  
  public float f()
  {
    return this.f;
  }
  
  public List g()
  {
    return this.g;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeFloat(this.f);
    paramParcel.writeList(this.g);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/model/PollenIndexBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */