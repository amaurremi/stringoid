package com.gau.go.launcherex.gowidget.weather.scroller;

import android.view.animation.Interpolator;

public class j
  implements Interpolator
{
  static float a = 1.0F / a(1.0F);
  
  public static float a(float paramFloat)
  {
    paramFloat = 8.0F * paramFloat;
    if (paramFloat < 1.0F) {}
    for (paramFloat -= 1.0F - (float)Math.exp(-paramFloat);; paramFloat = (1.0F - (float)Math.exp(1.0F - paramFloat)) * 0.63212055F + 0.36787945F) {
      return paramFloat * a;
    }
  }
  
  public float getInterpolation(float paramFloat)
  {
    return a(paramFloat);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/scroller/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */