package com.gau.go.launcherex.gowidget.weather.view;

import android.view.animation.Animation;
import android.view.animation.Transformation;

public class ad
  extends Animation
{
  public ad(LightAnimView paramLightAnimView) {}
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    LightAnimView.a(this.a, paramFloat);
    this.a.invalidate();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */