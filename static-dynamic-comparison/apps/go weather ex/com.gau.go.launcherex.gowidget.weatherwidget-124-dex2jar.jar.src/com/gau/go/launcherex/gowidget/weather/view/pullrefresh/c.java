package com.gau.go.launcherex.gowidget.weather.view.pullrefresh;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class c
  extends Animation
{
  float a;
  
  private c(LineRefreshView paramLineRefreshView) {}
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    LineRefreshView.a(this.b, this.a * (1.0F - paramFloat));
    this.b.invalidate();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/pullrefresh/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */