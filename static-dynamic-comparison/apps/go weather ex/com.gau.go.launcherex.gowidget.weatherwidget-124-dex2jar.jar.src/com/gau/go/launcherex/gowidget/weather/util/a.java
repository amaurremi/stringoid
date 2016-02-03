package com.gau.go.launcherex.gowidget.weather.util;

import java.util.ArrayList;

public class a
{
  public final ArrayList a = new ArrayList();
  private String b;
  private String c;
  private boolean d;
  private boolean e = true;
  
  public a()
  {
    d();
  }
  
  private a(String paramString1, String paramString2)
  {
    this.c = paramString2;
    this.b = paramString1;
  }
  
  private a(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.c = paramString2;
    this.b = paramString1;
    this.d = paramBoolean;
  }
  
  private a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.c = paramString2;
    this.b = paramString1;
    this.d = paramBoolean2;
    this.e = paramBoolean1;
  }
  
  private void d()
  {
    this.a.add(new a("com.android.deskclock", "AlarmClock"));
    this.a.add(new a("com.sec.android.app.clockpackage", "ClockPackage"));
    this.a.add(new a("com.htc.android.worldclock", "WorldClockTabControl"));
    this.a.add(new a("com.android.alarmclock", "AlarmClock", true));
    this.a.add(new a("com.android.clock", "Clock", true));
    this.a.add(new a("com.android.deskclock", "DeskClock", true));
    this.a.add(new a("zte.com.cn.alarmclock", "AlarmClock", true));
    this.a.add(new a("com.google.android.deskclock", "com.android.deskclock.AlarmClock", false, false));
    this.a.add(new a("com.google.android.deskclock", "com.android.deskclock.DeskClock", false, false));
    this.a.add(new a("com.motorola.blur.alarmclock", "AlarmClock"));
    this.a.add(new a("com.lge.clock", "Clock", true));
    this.a.add(new a("com.baidu.baiduclock", "BaiduClock", true));
  }
  
  public String a()
  {
    return this.b;
  }
  
  public boolean b()
  {
    return this.d;
  }
  
  public String c()
  {
    if (this.e) {
      return this.b + "." + this.c;
    }
    return this.c;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/util/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */