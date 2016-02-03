package com.gau.go.launcherex.gowidget.weather.model;

import com.gau.go.launcherex.gowidget.weather.util.r;
import com.jiubang.goweather.a.b;

public class c
{
  private String a;
  private String b;
  private String c;
  private String d;
  private String e;
  private int f;
  private String g;
  private String h;
  private int i;
  private int j;
  private boolean k;
  private boolean l;
  private boolean m;
  
  public int a()
  {
    return this.j;
  }
  
  public void a(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void a(b paramb)
  {
    this.a = paramb.a();
    this.b = paramb.b();
    this.c = paramb.c();
    this.d = paramb.d();
    this.e = paramb.e();
    this.f = paramb.f();
    this.g = paramb.g();
    this.h = paramb.h();
    this.i = paramb.i();
    this.j = paramb.j();
    this.k = r.c(this.b);
    this.l = paramb.k();
    this.m = paramb.l();
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public void b(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void b(String paramString)
  {
    this.b = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public boolean b()
  {
    return this.k;
  }
  
  public String c()
  {
    return this.a;
  }
  
  public void c(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void c(String paramString)
  {
    this.c = paramString;
  }
  
  public void c(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public String d()
  {
    return this.b;
  }
  
  public void d(String paramString)
  {
    this.d = paramString;
  }
  
  public String e()
  {
    return this.c;
  }
  
  public void e(String paramString)
  {
    this.e = paramString;
  }
  
  public String f()
  {
    return this.d;
  }
  
  public void f(String paramString)
  {
    this.g = paramString;
  }
  
  public String g()
  {
    return this.e;
  }
  
  public void g(String paramString)
  {
    this.h = paramString;
  }
  
  public int h()
  {
    return this.f;
  }
  
  public String i()
  {
    return this.g;
  }
  
  public String j()
  {
    return this.h;
  }
  
  public int k()
  {
    return this.i;
  }
  
  public boolean l()
  {
    return this.l;
  }
  
  public boolean m()
  {
    return this.m;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ExtremeId : " + this.i + "||");
    localStringBuilder.append("CityId : " + this.h + "||");
    localStringBuilder.append("PublishTime : " + this.a + "||");
    localStringBuilder.append("ExpTime : " + this.b + "||");
    localStringBuilder.append("Type : " + this.c + "||");
    localStringBuilder.append("Description : " + this.d + "||");
    localStringBuilder.append("Phenomena : " + this.e + "||");
    localStringBuilder.append("Level : " + this.f + "||");
    localStringBuilder.append("TzOffset : " + this.j);
    localStringBuilder.append("IsNotify : " + this.l);
    localStringBuilder.append("mHasRead : " + this.m);
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/model/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */