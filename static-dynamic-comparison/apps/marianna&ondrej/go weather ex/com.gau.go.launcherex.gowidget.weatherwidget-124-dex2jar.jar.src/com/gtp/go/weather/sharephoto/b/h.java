package com.gtp.go.weather.sharephoto.b;

import java.util.TreeMap;

public class h
{
  private boolean a;
  private String b;
  private TreeMap c;
  private boolean d;
  
  public h(String paramString, boolean paramBoolean)
  {
    this.b = paramString;
    this.a = paramBoolean;
    this.c = new TreeMap(new i(this));
  }
  
  public String a()
  {
    return this.b;
  }
  
  public void a(p paramp)
  {
    this.c.put(Long.valueOf(paramp.c()), paramp);
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public boolean a(long paramLong)
  {
    return this.c.remove(Long.valueOf(paramLong)) != null;
  }
  
  public p b(long paramLong)
  {
    return (p)this.c.get(Long.valueOf(paramLong));
  }
  
  public TreeMap b()
  {
    return this.c;
  }
  
  public boolean c()
  {
    return this.c.isEmpty();
  }
  
  public boolean d()
  {
    return this.d;
  }
  
  public boolean e()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/b/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */