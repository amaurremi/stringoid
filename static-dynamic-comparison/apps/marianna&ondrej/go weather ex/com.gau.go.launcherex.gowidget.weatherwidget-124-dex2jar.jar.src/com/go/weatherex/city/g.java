package com.go.weatherex.city;

import android.view.animation.Animation;
import com.gau.go.launcherex.gowidget.weather.util.b;

class g
  extends b
{
  g(EditCityScrollComponent paramEditCityScrollComponent, a parama) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.post(new h(this));
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    EditCityScrollComponent.a(this.b, true);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/city/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */