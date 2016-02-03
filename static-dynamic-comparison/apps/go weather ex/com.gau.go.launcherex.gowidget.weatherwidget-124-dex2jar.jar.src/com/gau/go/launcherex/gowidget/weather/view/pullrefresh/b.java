package com.gau.go.launcherex.gowidget.weather.view.pullrefresh;

class b
  implements Runnable
{
  b(LineRefreshView paramLineRefreshView) {}
  
  public void run()
  {
    LineRefreshView.a(this.a);
    this.a.invalidate();
    LineRefreshView.b(this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/pullrefresh/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */