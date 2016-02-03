package com.go.weatherex.home.refresh;

import android.view.animation.Animation;
import com.gau.go.launcherex.gowidget.weather.util.b;

class f
  extends b
{
  f(PullRefreshLayout paramPullRefreshLayout) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    PullRefreshLayout.b(this.a, true);
    this.a.removeCallbacks(PullRefreshLayout.f(this.a));
    this.a.postDelayed(PullRefreshLayout.f(this.a), 2000L);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/refresh/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */