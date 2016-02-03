package com.gau.go.launcherex.goweather.goplay.a;

import android.content.Context;
import com.gau.go.launcherex.gowidget.statistics.y;

public class c
  extends a
{
  public final String a = "20";
  public String b = "0";
  public String c = "0";
  public final String d = "11";
  public String e = "0";
  public String f = "0";
  public String g = "1";
  public String h = "0";
  public String i = "0";
  public String j = "0";
  public String k = "0";
  public String l = "0";
  public String m = "0";
  public String n = "0";
  public String o = "0";
  public String p = "0";
  public String q = "0";
  public String r = "0";
  
  public c(Context paramContext)
  {
    this.b = y.v(paramContext);
    this.h = y.n(paramContext);
    this.i = y.f(paramContext);
    this.j = String.valueOf(y.e(paramContext));
    this.k = y.c(paramContext);
  }
  
  public void a()
  {
    this.e = "0";
    this.f = "0";
    this.g = "1";
    this.q = "0";
    this.r = "0";
  }
  
  public String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("20");
    localStringBuilder.append("||");
    localStringBuilder.append(this.b);
    localStringBuilder.append("||");
    this.c = a("%Y-%m-%d %H:%M:%S");
    localStringBuilder.append(this.c);
    localStringBuilder.append("||");
    localStringBuilder.append("11");
    localStringBuilder.append("||");
    localStringBuilder.append(this.e);
    localStringBuilder.append("||");
    localStringBuilder.append(this.f);
    localStringBuilder.append("||");
    localStringBuilder.append(this.g);
    localStringBuilder.append("||");
    localStringBuilder.append(this.h);
    localStringBuilder.append("||");
    localStringBuilder.append(this.i);
    localStringBuilder.append("||");
    localStringBuilder.append(this.j);
    localStringBuilder.append("||");
    localStringBuilder.append(this.k);
    localStringBuilder.append("||");
    localStringBuilder.append(this.l);
    localStringBuilder.append("||");
    localStringBuilder.append(this.m);
    localStringBuilder.append("||");
    localStringBuilder.append(this.n);
    localStringBuilder.append("||");
    localStringBuilder.append(this.o);
    localStringBuilder.append("||");
    localStringBuilder.append(this.p);
    localStringBuilder.append("||");
    localStringBuilder.append(this.q);
    localStringBuilder.append("||");
    localStringBuilder.append(this.r);
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/goweather/goplay/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */