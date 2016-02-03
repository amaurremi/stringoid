package com.gau.go.launcherex.gowidget.weather.globaltheme.a.a;

import com.gtp.a.a.b.c;

public class b
{
  private int a;
  private String b = "";
  private String c = "";
  private int d = 0;
  private int e = 0;
  private int f = 0;
  
  public b() {}
  
  public b(int paramInt)
  {
    this.a = paramInt;
  }
  
  public String a()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.a).append("#");
    localStringBuffer.append(this.b).append("#");
    localStringBuffer.append(this.c).append("#");
    localStringBuffer.append(this.d).append("#");
    localStringBuffer.append(this.e).append("#");
    localStringBuffer.append(this.f);
    c.a("adid", "OrganizeData => " + localStringBuffer.toString());
    return localStringBuffer.toString();
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public int b()
  {
    return this.a;
  }
  
  public void b(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void b(String paramString)
  {
    this.c = paramString;
  }
  
  public String c()
  {
    return this.b;
  }
  
  public void c(int paramInt)
  {
    this.e = paramInt;
  }
  
  public String d()
  {
    return this.c;
  }
  
  public void d(int paramInt)
  {
    this.f = paramInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/globaltheme/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */