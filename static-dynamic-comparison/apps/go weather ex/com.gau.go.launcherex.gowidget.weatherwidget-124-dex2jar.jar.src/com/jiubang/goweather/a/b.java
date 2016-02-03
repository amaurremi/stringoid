package com.jiubang.goweather.a;

public class b
{
  private int a;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private int g;
  private String h;
  private String i;
  private String j;
  private int k;
  private boolean l;
  private boolean m;
  
  public String a()
  {
    return this.b;
  }
  
  public void a(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public String b()
  {
    return this.c;
  }
  
  public void b(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void b(String paramString)
  {
    this.c = paramString;
  }
  
  public String c()
  {
    return this.d;
  }
  
  public void c(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void c(String paramString)
  {
    this.d = paramString;
  }
  
  public String d()
  {
    return this.e;
  }
  
  public void d(String paramString)
  {
    this.e = paramString;
  }
  
  public String e()
  {
    return this.f;
  }
  
  public void e(String paramString)
  {
    this.f = paramString;
  }
  
  public int f()
  {
    return this.g;
  }
  
  public void f(String paramString)
  {
    this.h = paramString;
  }
  
  public String g()
  {
    return this.h;
  }
  
  public void g(String paramString)
  {
    this.i = paramString;
  }
  
  public String h()
  {
    return this.i;
  }
  
  public void h(String paramString)
  {
    this.j = paramString;
  }
  
  public int i()
  {
    return this.a;
  }
  
  public int j()
  {
    return this.k;
  }
  
  public boolean k()
  {
    return this.l;
  }
  
  public boolean l()
  {
    return this.m;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ("ExtremeId : " + this.a != null)
    {
      localObject = Integer.valueOf(this.a);
      localStringBuilder.append(localObject);
      if ("||PublishTime : " + this.b == null) {
        break label220;
      }
      localObject = this.b;
      label77:
      localStringBuilder.append((String)localObject);
      if ("||CityId : " + this.i == null) {
        break label226;
      }
      localObject = this.i;
      label113:
      localStringBuilder.append((String)localObject);
      if ("||Description : " + this.e == null) {
        break label232;
      }
    }
    label220:
    label226:
    label232:
    for (Object localObject = this.e;; localObject = "")
    {
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("||mIsNotify : " + this.l);
      localStringBuilder.append("||mHasRead : " + this.m);
      return localStringBuilder.toString();
      localObject = "";
      break;
      localObject = "";
      break label77;
      localObject = "";
      break label113;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/goweather/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */