package com.go.weatherex.home.refresh;

import android.view.animation.Animation;
import com.gau.go.launcherex.gowidget.weather.util.b;

class e
  extends b
{
  e(PullRefreshLayout paramPullRefreshLayout) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    PullRefreshLayout.b(this.a, 0);
    PullRefreshLayout.a(this.a, false);
    PullRefreshLayout.b(this.a, false);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/refresh/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */