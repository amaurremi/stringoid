package com.go.weatherex.home.refresh;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class d
  extends Animation
{
  d(PullRefreshLayout paramPullRefreshLayout) {}
  
  public void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    float f1 = PullRefreshLayout.d(this.a);
    float f2 = PullRefreshLayout.d(this.a);
    PullRefreshLayout.e(this.a).a(f1 + (0.0F - f2) * paramFloat);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/refresh/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */