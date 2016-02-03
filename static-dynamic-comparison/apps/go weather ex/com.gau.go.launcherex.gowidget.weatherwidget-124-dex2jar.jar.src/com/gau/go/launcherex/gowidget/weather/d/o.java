package com.gau.go.launcherex.gowidget.weather.d;

import java.text.SimpleDateFormat;

public class o
{
  private final SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  private String b;
  private String c;
  private int d;
  private String e;
  private boolean f;
  
  public String a()
  {
    return this.b;
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public String b()
  {
    return this.c;
  }
  
  public void b(String paramString)
  {
    this.c = paramString;
  }
  
  public int c()
  {
    return this.d;
  }
  
  public void c(String paramString)
  {
    this.e = paramString;
  }
  
  public String d()
  {
    return this.e;
  }
  
  public boolean e()
  {
    return this.f;
  }
  
  public String f()
  {
    return "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<root><installDate>" + a() + "</installDate>" + "<currentDate>" + b() + "</currentDate>" + "<serialRamdonKey>" + c() + "</serialRamdonKey>" + "<serialCode>" + d() + "</serialCode>" + "<paid>" + e() + "</paid>" + "</root>";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/d/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */