package com.jiubang.goweather.c;

import android.content.Context;
import android.location.LocationManager;
import android.os.Handler;
import com.gtp.a.a.a.a;

public class b
  extends t
{
  private LocationManager d = (LocationManager)this.a.getSystemService("location");
  private d e;
  private Handler f = new c(this);
  
  public b(Context paramContext, m paramm)
  {
    super(paramContext, paramm);
  }
  
  private void b()
  {
    if (this.e == null) {
      return;
    }
    this.d.removeUpdates(this.e);
  }
  
  public void a()
  {
    b();
  }
  
  public boolean a(int paramInt, p paramp)
  {
    this.b = paramp;
    boolean bool = false;
    int i = f.a(this.d, "gps");
    if (i == 1)
    {
      this.e = new d(this);
      if (paramInt == 1)
      {
        this.b.b(3);
        this.d.requestLocationUpdates("gps", 0L, 0.0F, this.e);
        bool = true;
      }
    }
    for (;;)
    {
      if (bool)
      {
        a.a().a("GPS定位开始", "location.txt");
        com.gtp.a.a.b.c.a("Location", "GPS定位开始");
      }
      return bool;
      if (paramInt != 2) {
        break;
      }
      this.b.b(2);
      break;
      if (i == 2)
      {
        a.a().a("GPS定位功能关闭", "location.txt");
        this.c.a();
        this.b.c(2);
      }
      else
      {
        a.a().a("系统不支持GPS定位功能", "location.txt");
        this.c.a();
        this.b.c(1);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/goweather/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */