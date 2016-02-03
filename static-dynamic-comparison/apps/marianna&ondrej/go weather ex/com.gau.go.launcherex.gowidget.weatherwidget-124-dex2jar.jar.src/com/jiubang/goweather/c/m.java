package com.jiubang.goweather.c;

import android.content.Context;
import android.location.Location;
import android.os.Handler;

public class m
{
  private Context a;
  private p b;
  private t c;
  private int d;
  private Handler e = new n(this);
  private Runnable f = new o(this);
  
  public m(Context paramContext)
  {
    this.a = paramContext;
    this.d = 0;
  }
  
  public void a()
  {
    this.e.removeCallbacks(this.f);
  }
  
  public void a(Location paramLocation)
  {
    new a(this.a, this.b, paramLocation).execute(new Object[] { paramLocation });
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, p paramp)
  {
    this.b = paramp;
    this.d = paramInt2;
    boolean bool = false;
    switch (paramInt2)
    {
    }
    for (;;)
    {
      if (bool)
      {
        com.gtp.a.a.a.a.a().a("定位开始", "location.txt");
        this.e.postDelayed(this.f, paramInt3 * 1000);
      }
      return bool;
      this.c = new com.jiubang.goweather.celllocation.b(this.a, this);
      com.gtp.a.a.a.a.a().a("准备基站定位", "location.txt");
      bool = this.c.a(paramInt1, this.b);
      continue;
      this.c = new b(this.a, this);
      com.gtp.a.a.a.a.a().a("准备GPS基站定位", "location.txt");
      bool = this.c.a(paramInt1, this.b);
      continue;
      this.c = new j(this.a, this);
      com.gtp.a.a.a.a.a().a("准备网络定位", "location.txt");
      bool = this.c.a(paramInt1, this.b);
    }
  }
  
  public void b()
  {
    a();
    if (this.c != null) {
      this.c.a();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/goweather/c/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */