package com.jiubang.goweather.c;

import android.content.Context;
import android.location.LocationManager;
import android.os.Handler;
import com.gtp.a.a.b.c;

public class j
  extends t
{
  private LocationManager d = (LocationManager)this.a.getSystemService("location");
  private l e;
  private Handler f;
  
  public j(Context paramContext, m paramm)
  {
    super(paramContext, paramm);
    b();
  }
  
  private void b()
  {
    this.f = new k(this);
  }
  
  private void c()
  {
    if (this.e == null) {
      return;
    }
    this.d.removeUpdates(this.e);
  }
  
  public void a()
  {
    c();
  }
  
  public boolean a(int paramInt, p paramp)
  {
    this.b = paramp;
    int i = f.a(this.d, "network");
    boolean bool;
    if (!com.jiubang.goweather.e.a.b(this.a))
    {
      com.gtp.a.a.a.a.a().a("网络不通，放弃Google定位", "location.txt");
      this.c.a();
      this.b.c(7);
      bool = false;
    }
    for (;;)
    {
      if (bool)
      {
        com.gtp.a.a.a.a.a().a("Google网络定位开始", "location.txt");
        c.a("Location", "Google网络定位开始");
      }
      return bool;
      if (i == 1)
      {
        this.e = new l(this);
        if (paramInt == 1) {
          this.b.b(1);
        }
        for (;;)
        {
          try
          {
            this.d.requestLocationUpdates("network", 0L, 0.0F, this.e);
            bool = true;
          }
          catch (Exception paramp)
          {
            if (!c.a()) {
              continue;
            }
            paramp.printStackTrace();
            bool = false;
          }
          if (paramInt == 3) {
            this.b.b(4);
          }
        }
      }
      else if (i == 2)
      {
        com.gtp.a.a.a.a.a().a("Google定位功能关闭", "location.txt");
        this.c.a();
        this.b.c(2);
        bool = false;
      }
      else
      {
        com.gtp.a.a.a.a.a().a("系统不支持Google定位功能", "location.txt");
        this.c.a();
        this.b.c(1);
        bool = false;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/goweather/c/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */