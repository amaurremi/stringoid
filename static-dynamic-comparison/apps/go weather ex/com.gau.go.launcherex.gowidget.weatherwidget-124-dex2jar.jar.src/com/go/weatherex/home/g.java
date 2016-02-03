package com.go.weatherex.home;

import android.view.View;
import android.view.animation.Animation;
import com.gau.go.launcherex.gowidget.weather.util.b;
import com.go.weatherex.viewex.CityNameSwitcher;

class g
  extends b
{
  g(c paramc) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    c.a(this.a).getCurrentView().clearAnimation();
    c.a(this.a).invalidate();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */