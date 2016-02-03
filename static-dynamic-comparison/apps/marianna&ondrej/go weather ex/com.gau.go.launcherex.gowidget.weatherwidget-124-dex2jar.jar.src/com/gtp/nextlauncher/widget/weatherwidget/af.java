package com.gtp.nextlauncher.widget.weatherwidget;

import android.view.animation.Interpolator;

class af
  implements Interpolator
{
  af(WeatherTrendView paramWeatherTrendView) {}
  
  public float getInterpolation(float paramFloat)
  {
    return (float)Math.pow(paramFloat / 0.4F, 2.0D);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/nextlauncher/widget/weatherwidget/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */