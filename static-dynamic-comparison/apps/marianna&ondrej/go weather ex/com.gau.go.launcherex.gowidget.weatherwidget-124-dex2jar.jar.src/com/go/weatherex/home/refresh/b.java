package com.go.weatherex.home.refresh;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class b
  extends Animation
{
  b(PullRefreshLayout paramPullRefreshLayout) {}
  
  public void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    int i = 0;
    if (PullRefreshLayout.a(this.a) != PullRefreshLayout.b(this.a)) {
      i = PullRefreshLayout.a(this.a) + (int)((PullRefreshLayout.b(this.a) - PullRefreshLayout.a(this.a)) * paramFloat);
    }
    PullRefreshLayout.a(this.a, i);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/refresh/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */