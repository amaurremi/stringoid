package com.gau.go.launcherex.gowidget.weather.view;

class v
  implements Runnable
{
  v(GLWidgetThemeSwitcher paramGLWidgetThemeSwitcher) {}
  
  public void run()
  {
    if (GLWidgetThemeSwitcher.access$000(this.a) < GLWidgetThemeSwitcher.access$100(this.a).length)
    {
      this.a.setImageResource(GLWidgetThemeSwitcher.access$200(this.a, GLWidgetThemeSwitcher.access$000(this.a)));
      this.a.postDelayed(this, 60L);
      GLWidgetThemeSwitcher.access$008(this.a);
    }
    for (;;)
    {
      this.a.invalidate();
      return;
      GLWidgetThemeSwitcher.access$002(this.a, 0);
      this.a.setImageResource(GLWidgetThemeSwitcher.access$200(this.a, 0));
      GLWidgetThemeSwitcher.access$302(this.a, false);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */