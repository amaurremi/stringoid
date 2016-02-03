package com.gau.go.launcherex.gowidget.weather.model;

public class h
{
  public boolean a = false;
  public boolean b = false;
  private String c;
  private String d;
  private String e;
  private int f;
  private String g;
  private String h;
  private String i;
  private String j;
  private String k;
  private String l;
  private int m;
  
  public h() {}
  
  public h(String paramString)
  {
    paramString = paramString.split("#");
    if (paramString.length == 5)
    {
      this.d = paramString[0];
      this.c = paramString[1];
      this.g = paramString[2];
      this.e = paramString[3];
    }
    try
    {
      this.f = Integer.valueOf(paramString[4]).intValue();
      this.i = null;
      this.l = null;
      this.h = null;
      this.j = null;
      this.k = null;
      return;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        this.f = 0;
      }
    }
  }
  
  public int a()
  {
    return this.m;
  }
  
  public void a(int paramInt)
  {
    this.m = paramInt;
  }
  
  public void a(String paramString)
  {
    this.h = paramString;
  }
  
  public String b()
  {
    return this.c;
  }
  
  public void b(String paramString)
  {
    this.i = paramString;
  }
  
  public int c()
  {
    return this.f;
  }
  
  public void c(String paramString)
  {
    this.j = paramString;
  }
  
  public String d()
  {
    return this.g;
  }
  
  public void d(String paramString)
  {
    this.k = paramString;
  }
  
  public String e()
  {
    return this.h;
  }
  
  public void e(String paramString)
  {
    this.l = paramString;
  }
  
  public String f()
  {
    return this.i;
  }
  
  public String g()
  {
    return this.k;
  }
  
  public String h()
  {
    return this.l;
  }
  
  public String i()
  {
    return this.d;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/model/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */