package com.jiubang.goweather.celllocation;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.jiubang.goweather.c.m;
import com.jiubang.goweather.c.p;
import com.jiubang.goweather.c.t;
import com.mapbar.android.location.CellLocationProvider;

public class b
  extends t
  implements LocationListener
{
  private boolean d = false;
  private p e;
  private CellLocationProvider f;
  
  public b(Context paramContext, m paramm)
  {
    super(paramContext, paramm);
  }
  
  private void b()
  {
    if (this.f == null) {
      this.f = new CellLocationProvider(this.a);
    }
    this.f.addLocationListener(this);
    this.f.enableLocation();
  }
  
  public void a()
  {
    this.d = true;
  }
  
  public boolean a(int paramInt, p paramp)
  {
    this.e = paramp;
    if (com.jiubang.goweather.e.a.c(this.a) != 5)
    {
      com.gtp.a.a.a.a.a().a("手机SIM不可用，放弃图吧基站定位", "location.txt");
      this.c.a();
      this.e.c(6);
      return false;
    }
    if (!com.jiubang.goweather.e.a.b(this.a))
    {
      com.gtp.a.a.a.a.a().a("网络不通，放弃图吧基站定位", "location.txt");
      this.c.a();
      this.e.c(7);
      return false;
    }
    if (paramInt == 3) {
      this.e.b(5);
    }
    while (y.p(this.a))
    {
      b();
      com.gtp.a.a.a.a.a().a("基站定位开始", "location.txt");
      return true;
      if (paramInt == 2) {
        this.e.b(6);
      }
    }
    com.gtp.a.a.a.a.a().a("非国内用户，放弃图吧基站定位", "location.txt");
    this.e.c(5);
    return false;
  }
  
  public void onLocationChanged(Location paramLocation)
  {
    if (!this.d)
    {
      this.c.a();
      if (paramLocation == null) {
        break label53;
      }
      com.gtp.a.a.a.a.a().a("基站定位成功", "location.txt");
      this.e.a(paramLocation);
    }
    for (;;)
    {
      this.f.clearLocationListener();
      this.f.disableLocation();
      return;
      label53:
      this.e.c(5);
    }
  }
  
  public void onProviderDisabled(String paramString) {}
  
  public void onProviderEnabled(String paramString) {}
  
  public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/goweather/celllocation/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */