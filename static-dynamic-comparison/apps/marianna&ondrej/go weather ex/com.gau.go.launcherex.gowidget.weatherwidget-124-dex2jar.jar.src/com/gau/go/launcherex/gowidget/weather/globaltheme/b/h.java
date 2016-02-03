package com.gau.go.launcherex.gowidget.weather.globaltheme.b;

import android.content.Context;
import android.text.format.Time;
import com.gau.go.launcherex.gowidget.statistics.y;

public class h
{
  public String a = "0";
  public String b = "0";
  public String c = "0";
  public String d = "0";
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
  private Time q = new Time();
  
  public h(Context paramContext)
  {
    this.b = y.v(paramContext);
    this.d = "11";
    this.h = y.n(paramContext);
    this.i = y.f(paramContext);
    this.j = String.valueOf(y.e(paramContext));
    this.k = y.c(paramContext);
  }
  
  public String a()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.a);
    localStringBuffer.append("||");
    localStringBuffer.append(this.b);
    localStringBuffer.append("||");
    this.q.setToNow();
    this.q.set(this.q.toMillis(true) - (this.q.gmtoff - 28800L) * 1000L);
    this.c = this.q.format("%Y/%m/%d %H:%M:%S");
    localStringBuffer.append(this.c);
    localStringBuffer.append("||");
    localStringBuffer.append(this.d);
    localStringBuffer.append("||");
    localStringBuffer.append(this.e);
    localStringBuffer.append("||");
    localStringBuffer.append(this.f);
    localStringBuffer.append("||");
    localStringBuffer.append(this.g);
    localStringBuffer.append("||");
    localStringBuffer.append(this.h);
    localStringBuffer.append("||");
    localStringBuffer.append(this.i);
    localStringBuffer.append("||");
    localStringBuffer.append(this.j);
    localStringBuffer.append("||");
    localStringBuffer.append(this.k);
    localStringBuffer.append("||");
    localStringBuffer.append(this.l);
    localStringBuffer.append("||");
    localStringBuffer.append(this.m);
    localStringBuffer.append("||");
    localStringBuffer.append(this.n);
    localStringBuffer.append("||");
    localStringBuffer.append(this.o);
    localStringBuffer.append("||");
    localStringBuffer.append(this.p);
    return localStringBuffer.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/globaltheme/b/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */