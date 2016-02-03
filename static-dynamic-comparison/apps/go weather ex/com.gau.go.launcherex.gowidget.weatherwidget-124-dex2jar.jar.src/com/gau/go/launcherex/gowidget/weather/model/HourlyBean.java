package com.gau.go.launcherex.gowidget.weather.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.gau.go.launcherex.gowidget.weather.util.q;
import com.jiubang.goweather.a.d;

public class HourlyBean
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new g();
  int a = 55536;
  int b = 55536;
  int c = 55536;
  int d;
  float e = -10000.0F;
  int f;
  String g = "";
  @Deprecated
  String h = "";
  int i;
  float j = -10000.0F;
  String k = "";
  int l = 55536;
  
  public HourlyBean() {}
  
  private HourlyBean(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readInt();
    this.k = paramParcel.readString();
    this.f = paramParcel.readInt();
    this.e = paramParcel.readFloat();
    this.g = paramParcel.readString();
    this.i = paramParcel.readInt();
    this.h = paramParcel.readString();
    this.j = paramParcel.readFloat();
    this.l = paramParcel.readInt();
  }
  
  public int a()
  {
    return this.a;
  }
  
  public void a(float paramFloat)
  {
    this.e = paramFloat;
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
  }
  
  public void a(d paramd)
  {
    a(paramd.c());
    this.d = paramd.f();
    this.k = paramd.g();
    this.f = paramd.j();
    this.e = paramd.h();
    this.g = paramd.d();
    this.i = paramd.a();
    this.h = paramd.e();
    this.j = paramd.b();
    this.l = paramd.k();
  }
  
  public void a(String paramString)
  {
    if ((paramString == null) || (paramString.equals("--"))) {}
    do
    {
      return;
      paramString = paramString.split("/");
    } while (paramString.length < 3);
    try
    {
      this.a = Integer.parseInt(paramString[0]);
      this.b = Integer.parseInt(paramString[1]);
      this.c = Integer.parseInt(paramString[2]);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public float b(int paramInt)
  {
    if ((paramInt == 1) && (this.e != -10000.0F)) {
      return q.b(this.e, 1);
    }
    return this.e;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public void b(float paramFloat)
  {
    this.j = paramFloat;
  }
  
  public void b(String paramString)
  {
    this.g = paramString;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public void c(int paramInt)
  {
    this.f = paramInt;
  }
  
  @Deprecated
  public void c(String paramString)
  {
    this.h = paramString;
  }
  
  public int d()
  {
    return this.d;
  }
  
  public void d(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void d(String paramString)
  {
    this.k = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int e()
  {
    return this.f;
  }
  
  public void e(int paramInt)
  {
    this.l = paramInt;
  }
  
  public String f()
  {
    return this.g;
  }
  
  public String g()
  {
    return this.k;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeString(this.k);
    paramParcel.writeInt(this.f);
    paramParcel.writeFloat(this.e);
    paramParcel.writeString(this.g);
    paramParcel.writeInt(this.i);
    paramParcel.writeString(this.h);
    paramParcel.writeFloat(this.j);
    paramParcel.writeInt(this.l);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/model/HourlyBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */