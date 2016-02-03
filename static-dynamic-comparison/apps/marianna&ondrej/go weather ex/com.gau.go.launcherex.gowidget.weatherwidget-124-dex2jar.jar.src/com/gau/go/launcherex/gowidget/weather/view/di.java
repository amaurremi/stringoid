package com.gau.go.launcherex.gowidget.weather.view;

class di
  implements Runnable
{
  di(WidgetThemeSwitcher paramWidgetThemeSwitcher) {}
  
  public void run()
  {
    if (WidgetThemeSwitcher.a(this.a) < WidgetThemeSwitcher.b(this.a).length)
    {
      this.a.setImageResource(WidgetThemeSwitcher.a(this.a, WidgetThemeSwitcher.a(this.a)));
      this.a.postDelayed(this, 60L);
      WidgetThemeSwitcher.c(this.a);
    }
    for (;;)
    {
      this.a.invalidate();
      return;
      WidgetThemeSwitcher.b(this.a, 0);
      this.a.setImageResource(WidgetThemeSwitcher.a(this.a, 0));
      WidgetThemeSwitcher.a(this.a, false);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/di.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */