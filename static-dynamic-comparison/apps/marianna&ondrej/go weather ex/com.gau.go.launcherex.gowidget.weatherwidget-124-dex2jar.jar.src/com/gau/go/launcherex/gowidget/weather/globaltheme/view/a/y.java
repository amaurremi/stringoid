package com.gau.go.launcherex.gowidget.weather.globaltheme.view.a;

import android.app.Activity;
import com.gau.go.launcherex.gowidget.weather.globaltheme.b.e;

public class y
{
  private c a;
  private g b;
  private m c;
  private s d;
  
  public y(Activity paramActivity)
  {
    this.a = new c(paramActivity);
    this.b = new g(paramActivity);
    this.c = new m(paramActivity);
    this.d = new s(paramActivity);
  }
  
  public void a()
  {
    this.b.a();
    this.c.a();
    this.d.a();
  }
  
  public void a(Activity paramActivity, e parame)
  {
    if ("com.gau.go.weatherex.nextwidget.style.one".equals(parame.x()))
    {
      this.a.a(paramActivity);
      this.a.a();
      return;
    }
    if (parame.D())
    {
      this.c.a(paramActivity);
      this.c.a(parame);
      return;
    }
    if (parame.C())
    {
      this.d.a(paramActivity);
      this.d.a(parame);
      return;
    }
    this.b.a(paramActivity);
    this.b.a(parame);
  }
  
  public void a(b paramb)
  {
    this.b.a(paramb);
    this.c.a(paramb);
    this.d.a(paramb);
  }
  
  public void b()
  {
    this.b.b();
    this.c.b();
    this.d.b();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/globaltheme/view/a/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */