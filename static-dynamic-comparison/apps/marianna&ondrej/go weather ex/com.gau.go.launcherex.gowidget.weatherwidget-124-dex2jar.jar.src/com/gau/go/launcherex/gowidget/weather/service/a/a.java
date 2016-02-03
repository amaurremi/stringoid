package com.gau.go.launcherex.gowidget.weather.service.a;

public abstract class a
{
  private b a;
  
  protected abstract void a();
  
  final void a(b paramb)
  {
    if (paramb == null) {
      throw new IllegalStateException("you should never call this method!");
    }
    this.a = paramb;
  }
  
  protected boolean a(a parama)
  {
    return false;
  }
  
  final void b()
  {
    if (this.a == null) {
      throw new IllegalStateException("you should never call this method!");
    }
    this.a = null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/service/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */