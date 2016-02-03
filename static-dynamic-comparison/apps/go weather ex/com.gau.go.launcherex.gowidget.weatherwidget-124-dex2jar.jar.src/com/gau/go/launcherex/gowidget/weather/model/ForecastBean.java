package com.gau.go.launcherex.gowidget.weather.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.gau.go.launcherex.gowidget.weather.util.q;
import com.gau.go.launcherex.gowidget.weather.util.r;
import com.jiubang.goweather.a.c;

public class ForecastBean
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new f();
  String a = "";
  int b = 55536;
  int c = 55536;
  int d = 55536;
  String e = "";
  float f = -10000.0F;
  float g = -10000.0F;
  String h = "";
  int i;
  @Deprecated
  String j = "";
  float k;
  int l;
  int m = 55536;
  String n = "";
  String o = "";
  String p = "";
  
  public ForecastBean() {}
  
  private ForecastBean(Parcel paramParcel)
  {
    this.b = paramParcel.readInt();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readInt();
    this.g = paramParcel.readFloat();
    this.f = paramParcel.readFloat();
    this.a = paramParcel.readString();
    this.l = paramParcel.readInt();
    this.e = paramParcel.readString();
    this.h = paramParcel.readString();
    this.i = paramParcel.readInt();
    this.j = paramParcel.readString();
    this.k = paramParcel.readFloat();
    this.m = paramParcel.readInt();
    this.p = paramParcel.readString();
    this.n = paramParcel.readString();
    this.o = paramParcel.readString();
  }
  
  public float a(int paramInt)
  {
    if ((paramInt == 1) && (this.f != -10000.0F)) {
      return q.b(this.f, 1);
    }
    return this.f;
  }
  
  public String a()
  {
    return this.n;
  }
  
  public void a(float paramFloat)
  {
    this.f = paramFloat;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
  }
  
  public void a(c paramc)
  {
    e(paramc.m());
    this.g = r.a(paramc.h());
    this.f = r.a(paramc.i());
    this.a = paramc.f();
    this.l = paramc.g();
    this.e = paramc.e();
    this.h = paramc.c();
    this.i = paramc.b();
    this.j = paramc.d();
    this.k = paramc.a();
    this.m = paramc.j();
    this.p = paramc.m();
    this.n = paramc.k();
    this.o = paramc.l();
  }
  
  public void a(String paramString)
  {
    this.n = paramString;
  }
  
  public float b(int paramInt)
  {
    if ((paramInt == 1) && (this.g != -10000.0F)) {
      return q.b(this.g, 1);
    }
    return this.g;
  }
  
  public String b()
  {
    return this.o;
  }
  
  public void b(float paramFloat)
  {
    this.g = paramFloat;
  }
  
  public void b(String paramString)
  {
    this.o = paramString;
  }
  
  public String c()
  {
    return this.p;
  }
  
  public void c(float paramFloat)
  {
    this.k = paramFloat;
  }
  
  public void c(int paramInt)
  {
    this.l = paramInt;
  }
  
  public void c(String paramString)
  {
    this.p = paramString;
    e(paramString);
  }
  
  public String d()
  {
    return this.a;
  }
  
  public void d(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void d(String paramString)
  {
    this.a = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int e()
  {
    return this.b;
  }
  
  public void e(int paramInt)
  {
    this.m = paramInt;
  }
  
  public void e(String paramString)
  {
    if ((paramString == null) || (paramString.equals("--"))) {}
    do
    {
      return;
      paramString = paramString.split("/");
    } while (paramString.length < 3);
    try
    {
      this.b = Integer.parseInt(paramString[0]);
      this.c = Integer.parseInt(paramString[1]);
      this.d = Integer.parseInt(paramString[2]);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public int f()
  {
    return this.c;
  }
  
  public void f(String paramString)
  {
    this.e = paramString;
  }
  
  public int g()
  {
    return this.d;
  }
  
  public void g(String paramString)
  {
    this.h = paramString;
  }
  
  public String h()
  {
    return this.e;
  }
  
  @Deprecated
  public void h(String paramString)
  {
    this.j = paramString;
  }
  
  public int i()
  {
    return this.l;
  }
  
  public String j()
  {
    return this.h;
  }
  
  public int k()
  {
    return this.i;
  }
  
  public float l()
  {
    return this.k;
  }
  
  public int m()
  {
    return this.m;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeFloat(this.g);
    paramParcel.writeFloat(this.f);
    paramParcel.writeString(this.a);
    paramParcel.writeInt(this.l);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.h);
    paramParcel.writeInt(this.i);
    paramParcel.writeString(this.j);
    paramParcel.writeFloat(this.k);
    paramParcel.writeInt(this.m);
    paramParcel.writeString(this.p);
    paramParcel.writeString(this.n);
    paramParcel.writeString(this.o);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/model/ForecastBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */