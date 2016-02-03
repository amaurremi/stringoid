package com.go.weatherex.home.refresh;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class c
  extends Animation
{
  c(PullRefreshLayout paramPullRefreshLayout) {}
  
  public void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    int i = 0;
    if (PullRefreshLayout.a(this.a) != PullRefreshLayout.c(this.a)) {
      i = PullRefreshLayout.a(this.a) + (int)((PullRefreshLayout.c(this.a) - PullRefreshLayout.a(this.a)) * paramFloat);
    }
    PullRefreshLayout.a(this.a, i);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/refresh/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */