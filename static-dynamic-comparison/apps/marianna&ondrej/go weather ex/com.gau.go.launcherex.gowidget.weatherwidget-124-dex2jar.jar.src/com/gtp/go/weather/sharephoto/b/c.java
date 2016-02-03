package com.gtp.go.weather.sharephoto.b;

public class c
{
  private final String a;
  private final long b;
  private volatile int c;
  private final int d;
  private final int e;
  private volatile boolean f;
  
  public c(String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    this.a = paramString;
    this.b = paramLong;
    this.e = paramInt1;
    this.f = false;
    this.c = paramInt2;
    this.d = -1;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public long b()
  {
    return this.b;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public int d()
  {
    return this.e;
  }
  
  public boolean e()
  {
    return this.f;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */