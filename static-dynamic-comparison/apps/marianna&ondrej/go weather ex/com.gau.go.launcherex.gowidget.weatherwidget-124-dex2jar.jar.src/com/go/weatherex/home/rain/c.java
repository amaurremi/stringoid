package com.go.weatherex.home.rain;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;

class c
  implements Runnable
{
  c(ForecastRainProbability paramForecastRainProbability, boolean paramBoolean) {}
  
  public void run()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(300L);
    ForecastRainProbability.a(this.b).startAnimation(localAlphaAnimation);
    ForecastRainProbability.a(this.b).setVisibility(0);
    if (ForecastRainProbability.b(this.b))
    {
      ForecastRainProbability.c(this.b).setVisibility(0);
      ForecastRainProbability.e(this.b).a(ForecastRainProbability.d(this.b), false, ForecastRainProbability.b(this.b), false);
      return;
    }
    ForecastRainProbability.c(this.b).setVisibility(8);
    ForecastRainProbability.e(this.b).a(ForecastRainProbability.d(this.b), this.a, ForecastRainProbability.b(this.b), false);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/rain/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */