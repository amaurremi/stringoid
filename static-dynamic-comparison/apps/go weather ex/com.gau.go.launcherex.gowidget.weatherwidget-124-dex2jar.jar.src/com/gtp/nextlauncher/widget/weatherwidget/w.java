package com.gtp.nextlauncher.widget.weatherwidget;

import android.view.animation.Interpolator;

class w
  implements Interpolator
{
  w(HourlyTypeView paramHourlyTypeView) {}
  
  public float getInterpolation(float paramFloat)
  {
    if (paramFloat <= 0.4F) {
      return (float)Math.pow(paramFloat / 0.4F, 2.0D);
    }
    paramFloat = (paramFloat - 0.4F) / 0.6F;
    return (float)((float)Math.sin(2.0F * paramFloat * 6.283185307179586D) * (1.0D - Math.pow(paramFloat, 2.0D)) * 0.4000000059604645D + 1.0D);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/nextlauncher/widget/weatherwidget/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */