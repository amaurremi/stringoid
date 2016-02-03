package com.gau.go.launcherex.gowidget.weather.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ThemeDataBean
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new s();
  private boolean A = false;
  private boolean B = false;
  private boolean C = false;
  private int D;
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
  private boolean v = false;
  private boolean w = false;
  private boolean x = false;
  private int y = -1;
  private boolean z = false;
  
  public ThemeDataBean() {}
  
  private ThemeDataBean(Parcel paramParcel)
  {
    this.c = paramParcel.readInt();
    this.k = paramParcel.readInt();
    this.a = paramParcel.readInt();
    this.d = paramParcel.readInt();
    this.b = paramParcel.readInt();
    this.i = paramParcel.readInt();
    this.q = paramParcel.readString();
    this.o = paramParcel.readString();
    this.p = paramParcel.readString();
    this.r = paramParcel.readString();
    this.f = paramParcel.readString();
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
  }
  
  public int a()
  {
    return this.b;
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(String paramString)
  {
    this.e = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.z = paramBoolean;
  }
  
  public int b()
  {
    return this.c;
  }
  
  public void b(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void b(String paramString)
  {
    this.f = paramString;
  }
  
  public int c()
  {
    return this.d;
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
    return this.e;
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
    return this.f;
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
    return this.g;
  }
  
  public void f(int paramInt)
  {
    this.D = paramInt;
  }
  
  public void f(String paramString)
  {
    this.l = paramString;
  }
  
  public String g()
  {
    return this.h;
  }
  
  public void g(int paramInt)
  {
    this.y = paramInt;
  }
  
  public void g(String paramString)
  {
    this.m = paramString;
  }
  
  public int h()
  {
    return this.i;
  }
  
  public void h(String paramString)
  {
    this.n = paramString;
  }
  
  public String i()
  {
    return this.j;
  }
  
  public void i(String paramString)
  {
    this.o = paramString;
  }
  
  public int j()
  {
    return this.k;
  }
  
  public void j(String paramString)
  {
    this.p = paramString;
  }
  
  public String k()
  {
    return this.l;
  }
  
  public void k(String paramString)
  {
    this.q = paramString;
  }
  
  public String l()
  {
    return this.m;
  }
  
  public void l(String paramString)
  {
    this.r = paramString;
  }
  
  public String m()
  {
    return this.n;
  }
  
  public void m(String paramString)
  {
    this.s = paramString;
  }
  
  public String n()
  {
    return this.o;
  }
  
  public void n(String paramString)
  {
    this.t = paramString;
  }
  
  public String o()
  {
    return this.p;
  }
  
  public void o(String paramString)
  {
    this.u = paramString;
  }
  
  public String p()
  {
    return this.q;
  }
  
  public String q()
  {
    return this.r;
  }
  
  public String r()
  {
    return this.s;
  }
  
  public String s()
  {
    return this.t;
  }
  
  public String t()
  {
    return this.u;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.k);
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.d);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.i);
    paramParcel.writeString(this.q);
    paramParcel.writeString(this.o);
    paramParcel.writeString(this.p);
    paramParcel.writeString(this.r);
    paramParcel.writeString(this.f);
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
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/model/ThemeDataBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */