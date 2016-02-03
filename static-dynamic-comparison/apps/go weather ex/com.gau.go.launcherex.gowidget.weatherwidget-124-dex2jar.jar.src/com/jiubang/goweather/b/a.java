package com.jiubang.goweather.b;

class a
{
  private final String a;
  private final String b;
  
  public a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || ("".equals(paramString1))) {
      throw new IllegalArgumentException("Invalid key");
    }
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/goweather/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */