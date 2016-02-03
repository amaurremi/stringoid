package com.gtp.go.weather.sharephoto.d;

import android.app.Activity;
import android.os.Handler;

public class p
{
  private static s f = new r();
  protected Activity a;
  protected s b = f;
  Handler c = new Handler();
  Runnable d = new q(this);
  private boolean e = true;
  
  public p(Activity paramActivity)
  {
    this.a = paramActivity;
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    this.c.removeCallbacks(this.d);
    this.c.postDelayed(this.d, paramInt);
  }
  
  public void a(s params)
  {
    s locals = params;
    if (params == null) {
      locals = f;
    }
    this.b = locals;
  }
  
  public boolean b()
  {
    return this.e;
  }
  
  public void c()
  {
    this.e = false;
    this.b.a(this.e);
  }
  
  public void d()
  {
    this.e = true;
    this.b.a(this.e);
  }
  
  public void e()
  {
    if (b())
    {
      c();
      return;
    }
    d();
  }
  
  public void f()
  {
    this.c.removeCallbacks(this.d);
  }
  
  public void g()
  {
    this.c.postDelayed(this.d, 3000L);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/d/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */