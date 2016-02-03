package com.gau.go.launcherex.gowidget.weather.model;

import com.gtp.a.a.b.c;

public class b
{
  float a = -10000.0F;
  float b = -10000.0F;
  int c = 0;
  int d = 0;
  double[] e = { -10000.0D, -10000.0D };
  double[] f = { -10000.0D, -10000.0D };
  private String g;
  private String h;
  private String i;
  private String j;
  private int k = 55536;
  private String l;
  @Deprecated
  private String m;
  private String n;
  
  public b() {}
  
  public b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    a(paramString1);
    b(paramString2);
    d(paramString3);
    c(paramString4);
    e(paramString5);
    f(paramString6);
  }
  
  public String a()
  {
    return this.g;
  }
  
  public void a(float paramFloat)
  {
    this.a = paramFloat;
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(String paramString)
  {
    this.g = paramString;
  }
  
  public String b()
  {
    return this.h;
  }
  
  public void b(float paramFloat)
  {
    this.b = paramFloat;
  }
  
  public void b(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void b(String paramString)
  {
    this.h = paramString;
  }
  
  public String c()
  {
    return this.i;
  }
  
  public void c(String paramString)
  {
    this.i = paramString;
  }
  
  public String d()
  {
    return this.j;
  }
  
  public void d(String paramString)
  {
    this.j = paramString;
  }
  
  public int e()
  {
    return this.k;
  }
  
  public void e(String paramString)
  {
    try
    {
      this.k = Integer.parseInt(paramString);
      return;
    }
    catch (NumberFormatException paramString)
    {
      while (!c.a()) {}
      paramString.printStackTrace();
    }
  }
  
  public String f()
  {
    return this.l;
  }
  
  public void f(String paramString)
  {
    this.l = paramString;
  }
  
  @Deprecated
  public String g()
  {
    return this.m;
  }
  
  @Deprecated
  public void g(String paramString)
  {
    this.m = paramString;
  }
  
  public float h()
  {
    return this.a;
  }
  
  public void h(String paramString)
  {
    this.n = paramString;
  }
  
  public int i()
  {
    return this.c;
  }
  
  public float j()
  {
    return this.b;
  }
  
  public int k()
  {
    return this.d;
  }
  
  public String l()
  {
    return this.n;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/model/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */