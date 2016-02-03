package com.gau.go.launcherex.gowidget.weather.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.gau.go.launcherex.gowidget.weather.util.q;
import com.gau.go.launcherex.gowidget.weather.util.r;
import com.jiubang.goweather.a.a;
import com.jiubang.goweather.a.e;

public class NowBean
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new j();
  int A = 55536;
  int B = 55536;
  int C = 55536;
  float D = -10000.0F;
  float E = -10000.0F;
  int F = 0;
  int G = 0;
  double[] H = { -10000.0D, -10000.0D };
  double[] I = { -10000.0D, -10000.0D };
  float a = -10000.0F;
  float b = -10000.0F;
  float c = -10000.0F;
  int d = 55536;
  int e = 1;
  String f = "";
  long g = -10000L;
  long h = -10000L;
  long i = -10000L;
  float j = -10000.0F;
  float k = -10000.0F;
  float l = -10000.0F;
  String m = "";
  String n = "";
  float o = -10000.0F;
  String p = "";
  @Deprecated
  String q = "";
  float r = -10000.0F;
  int s;
  int t = 55536;
  int u = 55536;
  float v = -10000.0F;
  float w = -10000.0F;
  int x = 55536;
  int y = 55536;
  int z = 55536;
  
  public NowBean() {}
  
  private NowBean(Parcel paramParcel)
  {
    this.k = paramParcel.readFloat();
    this.l = paramParcel.readFloat();
    this.j = paramParcel.readFloat();
    this.m = paramParcel.readString();
    this.n = paramParcel.readString();
    this.o = paramParcel.readFloat();
    this.v = paramParcel.readFloat();
    this.u = paramParcel.readInt();
    this.w = paramParcel.readFloat();
    this.a = paramParcel.readFloat();
    this.c = paramParcel.readFloat();
    this.b = paramParcel.readFloat();
    this.f = paramParcel.readString();
    this.d = paramParcel.readInt();
    this.e = paramParcel.readInt();
    this.g = paramParcel.readLong();
    this.h = paramParcel.readLong();
    this.i = paramParcel.readLong();
    this.p = paramParcel.readString();
    this.s = paramParcel.readInt();
    this.q = paramParcel.readString();
    this.r = paramParcel.readFloat();
    this.t = paramParcel.readInt();
    this.x = paramParcel.readInt();
    this.y = paramParcel.readInt();
    this.z = paramParcel.readInt();
    this.A = paramParcel.readInt();
    this.B = paramParcel.readInt();
    this.C = paramParcel.readInt();
  }
  
  public double[] A()
  {
    return this.I;
  }
  
  public long B()
  {
    return this.i;
  }
  
  public float a()
  {
    return this.r;
  }
  
  public float a(int paramInt)
  {
    if ((paramInt == 1) && (this.a != -10000.0F)) {
      return q.b(this.a, 1);
    }
    return this.a;
  }
  
  public void a(float paramFloat)
  {
    this.r = paramFloat;
  }
  
  public void a(long paramLong)
  {
    this.g = paramLong;
  }
  
  public void a(a parama)
  {
    e locale = parama.p();
    this.k = locale.k();
    this.l = locale.l();
    this.j = locale.j();
    this.m = locale.n();
    this.n = locale.o();
    this.o = locale.m();
    this.v = locale.i();
    this.u = locale.p();
    this.w = locale.x();
    this.a = r.a(locale.v());
    this.c = r.a(locale.s());
    this.b = r.a(locale.r());
    this.f = locale.t();
    this.d = locale.w();
    this.e = locale.u();
    this.g = parama.m();
    this.h = parama.n();
    this.i = parama.o();
    this.p = locale.q();
    this.s = locale.g();
    this.q = locale.h();
    this.r = locale.f();
    this.t = parama.t();
    this.H = parama.i();
    this.I = parama.k();
    this.x = locale.y();
    this.y = locale.a();
    this.z = locale.b();
    this.A = locale.c();
    this.B = locale.d();
    this.C = locale.e();
    this.E = parama.e();
    this.D = parama.f();
    this.F = parama.g();
    this.G = parama.h();
  }
  
  public void a(String paramString)
  {
    this.p = paramString;
  }
  
  public void a(double[] paramArrayOfDouble)
  {
    this.H = paramArrayOfDouble;
  }
  
  public float b(int paramInt)
  {
    if ((paramInt == 1) && (this.b != -10000.0F)) {
      return q.b(this.b, 1);
    }
    return this.b;
  }
  
  public String b()
  {
    return this.p;
  }
  
  public void b(float paramFloat)
  {
    this.a = paramFloat;
  }
  
  public void b(long paramLong)
  {
    this.h = paramLong;
  }
  
  @Deprecated
  public void b(String paramString)
  {
    this.q = paramString;
  }
  
  public void b(double[] paramArrayOfDouble)
  {
    this.I = paramArrayOfDouble;
  }
  
  public float c(int paramInt)
  {
    if ((paramInt == 1) && (this.c != -10000.0F)) {
      return q.b(this.c, 1);
    }
    return this.c;
  }
  
  public int c()
  {
    return this.d;
  }
  
  public void c(float paramFloat)
  {
    this.b = paramFloat;
  }
  
  public void c(String paramString)
  {
    this.f = paramString;
  }
  
  public int d()
  {
    return this.e;
  }
  
  public void d(float paramFloat)
  {
    this.c = paramFloat;
  }
  
  public void d(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void d(String paramString)
  {
    this.m = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String e()
  {
    return this.f;
  }
  
  public void e(float paramFloat)
  {
    this.j = paramFloat;
  }
  
  public void e(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void e(String paramString)
  {
    this.n = paramString;
  }
  
  public float f(int paramInt)
  {
    if ((paramInt == 1) && (this.l != -10000.0F)) {
      return q.b(this.l, 1);
    }
    return this.l;
  }
  
  public long f()
  {
    return this.g;
  }
  
  public void f(float paramFloat)
  {
    this.k = paramFloat;
  }
  
  public long g()
  {
    return this.h;
  }
  
  public void g(float paramFloat)
  {
    this.l = paramFloat;
  }
  
  public void g(int paramInt)
  {
    this.s = paramInt;
  }
  
  public float h()
  {
    return this.j;
  }
  
  public void h(float paramFloat)
  {
    this.o = paramFloat;
  }
  
  public void h(int paramInt)
  {
    this.t = paramInt;
  }
  
  public float i()
  {
    return this.k;
  }
  
  public void i(float paramFloat)
  {
    this.w = paramFloat;
  }
  
  public void i(int paramInt)
  {
    this.u = paramInt;
  }
  
  public float j(int paramInt)
  {
    if ((paramInt == 1) && (this.v != -10000.0F)) {
      return q.b(this.v, 1);
    }
    return this.v;
  }
  
  public String j()
  {
    return this.m;
  }
  
  public void j(float paramFloat)
  {
    this.v = paramFloat;
  }
  
  public String k()
  {
    return this.n;
  }
  
  public void k(float paramFloat)
  {
    this.D = paramFloat;
  }
  
  public void k(int paramInt)
  {
    this.x = paramInt;
  }
  
  public float l()
  {
    return this.o;
  }
  
  public void l(float paramFloat)
  {
    this.E = paramFloat;
  }
  
  public void l(int paramInt)
  {
    this.y = paramInt;
  }
  
  public int m()
  {
    return this.s;
  }
  
  public void m(int paramInt)
  {
    this.z = paramInt;
  }
  
  public int n()
  {
    return this.t;
  }
  
  public void n(int paramInt)
  {
    this.A = paramInt;
  }
  
  public int o()
  {
    return this.u;
  }
  
  public void o(int paramInt)
  {
    this.B = paramInt;
  }
  
  public int p()
  {
    return this.x;
  }
  
  public void p(int paramInt)
  {
    this.C = paramInt;
  }
  
  public int q()
  {
    return this.y;
  }
  
  public void q(int paramInt)
  {
    this.F = paramInt;
  }
  
  public int r()
  {
    return this.z;
  }
  
  public void r(int paramInt)
  {
    this.G = paramInt;
  }
  
  public int s()
  {
    return this.A;
  }
  
  public int t()
  {
    return this.B;
  }
  
  public int u()
  {
    return this.C;
  }
  
  public float v()
  {
    return this.D;
  }
  
  public float w()
  {
    return this.E;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeFloat(this.k);
    paramParcel.writeFloat(this.l);
    paramParcel.writeFloat(this.j);
    paramParcel.writeString(this.m);
    paramParcel.writeString(this.n);
    paramParcel.writeFloat(this.o);
    paramParcel.writeFloat(this.v);
    paramParcel.writeInt(this.u);
    paramParcel.writeFloat(this.w);
    paramParcel.writeFloat(this.a);
    paramParcel.writeFloat(this.c);
    paramParcel.writeFloat(this.b);
    paramParcel.writeString(this.f);
    paramParcel.writeInt(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeLong(this.g);
    paramParcel.writeLong(this.h);
    paramParcel.writeLong(this.i);
    paramParcel.writeString(this.p);
    paramParcel.writeInt(this.s);
    paramParcel.writeString(this.q);
    paramParcel.writeFloat(this.r);
    paramParcel.writeInt(this.t);
    paramParcel.writeInt(this.x);
    paramParcel.writeInt(this.y);
    paramParcel.writeInt(this.z);
    paramParcel.writeInt(this.A);
    paramParcel.writeInt(this.B);
    paramParcel.writeInt(this.C);
  }
  
  public int x()
  {
    return this.F;
  }
  
  public int y()
  {
    return this.G;
  }
  
  public double[] z()
  {
    return this.H;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/model/NowBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */