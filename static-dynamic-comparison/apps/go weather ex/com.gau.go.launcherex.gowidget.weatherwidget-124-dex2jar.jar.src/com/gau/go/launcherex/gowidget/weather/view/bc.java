package com.gau.go.launcherex.gowidget.weather.view;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.TextView;

public class bc
  extends Animation
{
  public bc(Water paramWater) {}
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    Water.a(this.a, paramFloat);
    if (!Water.a(this.a)) {
      Water.a(this.a, true);
    }
    if (Water.b(this.a) != null) {
      Water.b(this.a).setText(String.valueOf((int)(70.0F * Water.c(this.a)) + 12) + "%");
    }
    this.a.invalidate();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */