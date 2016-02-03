package com.gau.go.launcherex.gowidget.weather.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class RecommendedAppsBean
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new n();
  private int a;
  private int b;
  private int c;
  private int d;
  private String e;
  private String f;
  private String g;
  private String h;
  private int i;
  private String j;
  private int k;
  private String l;
  private String m;
  private String n;
  private String o;
  private String p;
  private String q;
  private String r;
  private String s;
  private String t;
  private String u;
  private String v;
  private String w;
  private int x;
  private boolean y = false;
  
  public RecommendedAppsBean() {}
  
  private RecommendedAppsBean(Parcel paramParcel)
  {
    this.c = paramParcel.readInt();
    this.k = paramParcel.readInt();
    this.d = paramParcel.readInt();
    this.b = paramParcel.readInt();
    this.i = paramParcel.readInt();
    this.q = paramParcel.readString();
    this.o = paramParcel.readString();
    this.p = paramParcel.readString();
    this.r = paramParcel.readString();
    this.f = paramParcel.readString();
    this.v = paramParcel.readString();
    this.e = paramParcel.readString();
    this.s = paramParcel.readString();
    this.j = paramParcel.readString();
    this.l = paramParcel.readString();
    this.m = paramParcel.readString();
    this.g = paramParcel.readString();
    this.n = paramParcel.readString();
    this.h = paramParcel.readString();
    this.t = paramParcel.readString();
    this.u = paramParcel.readString();
    this.w = paramParcel.readString();
  }
  
  public String a()
  {
    return this.j;
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(String paramString)
  {
    this.e = paramString;
  }
  
  public String b()
  {
    return this.p;
  }
  
  public void b(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void b(String paramString)
  {
    this.f = paramString;
  }
  
  public String c()
  {
    return this.q;
  }
  
  public void c(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void c(String paramString)
  {
    this.g = paramString;
  }
  
  public String d()
  {
    return this.r;
  }
  
  public void d(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void d(String paramString)
  {
    this.h = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String e()
  {
    return this.s;
  }
  
  public void e(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void e(String paramString)
  {
    this.j = paramString;
  }
  
  public String f()
  {
    return this.t;
  }
  
  public void f(int paramInt)
  {
    this.x = paramInt;
  }
  
  public void f(String paramString)
  {
    this.l = paramString;
  }
  
  public int g()
  {
    return this.a;
  }
  
  public void g(String paramString)
  {
    this.m = paramString;
  }
  
  public void h(String paramString)
  {
    this.n = paramString;
  }
  
  public void i(String paramString)
  {
    this.o = paramString;
  }
  
  public void j(String paramString)
  {
    this.p = paramString;
  }
  
  public void k(String paramString)
  {
    this.q = paramString;
  }
  
  public void l(String paramString)
  {
    this.r = paramString;
  }
  
  public void m(String paramString)
  {
    this.s = paramString;
  }
  
  public void n(String paramString)
  {
    this.t = paramString;
  }
  
  public void o(String paramString)
  {
    this.v = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.k);
    paramParcel.writeInt(this.d);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.i);
    paramParcel.writeString(this.q);
    paramParcel.writeString(this.o);
    paramParcel.writeString(this.p);
    paramParcel.writeString(this.r);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.v);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.s);
    paramParcel.writeString(this.j);
    paramParcel.writeString(this.l);
    paramParcel.writeString(this.m);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.n);
    paramParcel.writeString(this.h);
    paramParcel.writeString(this.t);
    paramParcel.writeString(this.u);
    paramParcel.writeString(this.w);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/model/RecommendedAppsBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */