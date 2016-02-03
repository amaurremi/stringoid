package com.gau.go.launcherex.goweather.livewallpaper.a;

public class g
{
  private int a;
  private int b;
  private int c;
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public boolean a()
  {
    return this.a != 0;
  }
  
  public String b()
  {
    if (this.b == 1) {
      return "°C";
    }
    return "°F";
  }
  
  public boolean b(int paramInt)
  {
    boolean bool = false;
    if (paramInt != this.a) {
      bool = true;
    }
    return bool;
  }
  
  public int c()
  {
    return this.b;
  }
  
  public void c(int paramInt)
  {
    this.b = paramInt;
  }
  
  public int d()
  {
    return this.c;
  }
  
  public boolean d(int paramInt)
  {
    boolean bool = false;
    if (paramInt != this.b)
    {
      bool = true;
      this.b = paramInt;
    }
    return bool;
  }
  
  public void e(int paramInt)
  {
    this.c = paramInt;
  }
  
  public boolean f(int paramInt)
  {
    boolean bool = false;
    if (paramInt != this.c)
    {
      bool = true;
      this.c = paramInt;
    }
    return bool;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/goweather/livewallpaper/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */